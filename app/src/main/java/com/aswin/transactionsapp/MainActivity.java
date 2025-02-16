package com.aswin.transactionsapp;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;
import com.aswin.transactionsapp.model.HistoryHeaderItem;
import com.aswin.transactionsapp.model.HistoryItem;
import com.aswin.transactionsapp.model.TransactionsListRequestPojo;
import com.aswin.transactionsapp.model.TransactionsListResponsePojo;
import com.aswin.transactionsapp.utilities.CommonUtils;
import com.aswin.transactionsapp.utilities.Constants;
import com.aswin.transactionsapp.utilities.LMTTextFadeInAnimation;
import com.aswin.transactionsapp.utilities.PaginationScrollListener;
import com.facebook.shimmer.ShimmerFrameLayout;
import com.google.gson.Gson;
import com.yuyang.stickyheaders.StickyLinearLayoutManager;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import de.hdodenhof.circleimageview.CircleImageView;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "ViewReportsHomeFragment";

    private EditText edSearch;
    private ImageView imgSearch;
    private TextView tvTotalNumberHint;
    private TextView tvMainTitle;
    private FrameLayout innerLayoutInvoiceNew;
    private RecyclerView recyclerReports;
    private ImageView imgBack;
    private LinearLayout cvSearch;
    private ShimmerFrameLayout shimmerView;
    private CircleImageView imgFalg;
    private FrameLayout frame_recycler_view;
    private View vNoData;
    private LinearLayout llReportMain;
    private LinearLayout llNoTransactions;
    private ImageView imgClose;

    private Handler handler;

    private TransactionsListResponsePojo reportsListPojo;
//    CountryListBottomFragment countryListBottomFragment;
    private TransactionsListResponsePojo.DataBean.TransactionsBean lastSelectedReport;
    private HistoryAdapter adapter;

    private int NO_OF_RECORDS_LOAD_PER_APICALL = 10;
    private int PAGE_NO = 1;
    private int TOTAL_PAGES = 1;
    private int TOTAL_RECORDS = 0;
    private boolean isLoading = false;
    private boolean isLastPage = false;
    private boolean isInitialLoading = true;
    private boolean isInitialAPICalling = true;
    private String backToPage;
    private boolean shouldShowAnimation = false;
    private String countryId = null;
    private static TransactionsListResponsePojo ReportJsonData;
    private int currentDisplayedMonth = 0;
    private int currentDisplayedYear = 0;
    private boolean CurrentYear = true;

    @Override
    protected void onDestroy() {
        super.onDestroy();
        try {
            // Remove any pending callbacks and messages from the handler
            handler.removeCallbacksAndMessages(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bindViews();

        handler = new Handler();

        shimmerView.setVisibility(View.VISIBLE);
        recyclerReports.setVisibility(View.GONE);

        SetRecyclerAdapterData();
        callApiViewReports();
        setSearchListeners();
        initPagination();
        localize();

        imgClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                imgCloseClick();
            }
        });

        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                imgBackClick();
            }
        });

        imgSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgSearchClick();
            }
        });
    }

    private void bindViews() {
        edSearch = findViewById(R.id.edSearch);
        imgSearch = findViewById(R.id.imgSearch);
        tvTotalNumberHint = findViewById(R.id.tvTotalNumberHint);
        tvMainTitle = findViewById(R.id.tvMainTitle);
        innerLayoutInvoiceNew = findViewById(R.id.innerLayoutInvoiceNew);
        recyclerReports = findViewById(R.id.recyclerReports);
        imgBack = findViewById(R.id.imgBack);
        cvSearch = findViewById(R.id.cvSearch);
        shimmerView = findViewById(R.id.shimmerView);
        imgFalg = findViewById(R.id.imgFalg);
        frame_recycler_view = findViewById(R.id.frame_recycler_view);
        vNoData = findViewById(R.id.vNoData);
        llReportMain = findViewById(R.id.llReportMain);
        llNoTransactions = findViewById(R.id.llNoTransactions);
        imgClose = findViewById(R.id.imgClose);
    }

    /**
     * Search image Click
     * **/
    private void imgSearchClick() {
        searchReport();
    }

    /**
     * Initializes pagination for the History RecyclerView.
     * Sets up a scroll listener to load more items when the user scrolls to the end.
     */
    private void initPagination() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerReports.setLayoutManager(linearLayoutManager);
        recyclerReports.addOnScrollListener(new PaginationScrollListener((linearLayoutManager)) {
            @Override
            protected void loadMoreItems() {
                isLoading = true;
                PAGE_NO += 1;
                if(PAGE_NO <= TOTAL_PAGES){
                    callApiViewReports();
                }
//                callApiViewReports();
            }

            @Override
            public int getTotalPageCount() {
                return TOTAL_PAGES;
            }

            @Override
            public boolean isLastPage() {
                return isLastPage;
            }

            @Override
            public boolean isLoading() {
                return isLoading;
            }
        });
    }

    /**
     * Sets up listeners for the search functionality.
     * Triggers the searchReport method when the search action is performed.
     */
    private void setSearchListeners() {
        // Set editor action listener for the search EditText
        edSearch.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                // Check if the search action is performed
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                    // Trigger the searchReport method when the search action is detected
                    searchReport();

                    return true;
                }
                return false;
            }
        });
    }

    /**
     * Initiates the process of searching and displaying reports.
     * Hides the RecyclerView and shows a shimmer animation during the search.
     */
    private void searchReport() {
        // Display shimmer animation while loading the search results
        shimmerView.setVisibility(View.VISIBLE);
        recyclerReports.setVisibility(View.GONE);

        // Disable animation during the search
        shouldShowAnimation = false;

        // Localize UI elements
        localize();

        // Reset pagination variables
        NO_OF_RECORDS_LOAD_PER_APICALL = 30;
        PAGE_NO = 1;
        TOTAL_PAGES = 1;

        // Reset flags and counters
        isLoading = false;
        isLastPage = false;
        TOTAL_PAGES = 1;
        TOTAL_RECORDS = 0;
        isInitialLoading = true;

        // Notify the adapter about data changes
        adapter.notifyDataSetChanged();

        // Initiate the API call to fetch and display reports
        callApiViewReports();

        // Hide the keyboard after initiating the search
        hideKeyboard(imgSearch);
    }

    public void hideKeyboard(View view) {
        try {
            InputMethodManager inputMethodManager = (InputMethodManager) getApplicationContext().getSystemService(Activity.INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Set Text String in the UI
     * **/
    private void localize() {
        tvMainTitle.setText("Transactions");
    }

    /**
     * Sets up the RecyclerView adapter for displaying transaction history.
     * Initializes the adapter, layout manager, and adds necessary listeners.
     */
    public void SetRecyclerAdapterData(){
        // Create a new HistoryAdapter with a RecyclerItemClickListener
        adapter = new HistoryAdapter(getApplicationContext(), new HistoryAdapter.RecyclerItemClickListener() {
            @Override
            public void onItemClick(HistoryItem historyItem) {
                // Create a TransactionsBean from the selected HistoryItem
                TransactionsListResponsePojo.DataBean.TransactionsBean selectedhistoryItem = new TransactionsListResponsePojo.DataBean.TransactionsBean(
                        historyItem.getReferenceId(),historyItem.getStatus(),historyItem.getConvertingAmount(),
                        historyItem.getReceivingAmount(), historyItem.getConvertingAmountCurrency(),historyItem.getReceivingAmountCurrency(),
                        historyItem.getTransactionDate(),historyItem.getCharges(), historyItem.getBeneficiaryName(),
                        historyItem.getAccountNumber(),historyItem.getFlagURL(),historyItem.getTotalDebitAmount(),
                        historyItem.getAmount(),historyItem.getTranferMode(),historyItem.getTransactionType(),
                        historyItem.getPurposeOfTransaction(),historyItem.getTransactionStatus()
                );
                // Set the lastSelectedReport and open the fragment
                lastSelectedReport = selectedhistoryItem;
//                openFragment(1);
            }
        });

        // Create a StickyLinearLayoutManager with a TopSmoothScroller
        StickyLinearLayoutManager layoutManager = new StickyLinearLayoutManager(getApplicationContext(), adapter) {
            @Override
            public boolean isAutoMeasureEnabled() {
                return true;
            }

            @Override
            public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int position) {
                RecyclerView.SmoothScroller smoothScroller = new TopSmoothScroller(recyclerView.getContext());
                smoothScroller.setTargetPosition(position);
                startSmoothScroll(smoothScroller);
            }
            class TopSmoothScroller extends LinearSmoothScroller {

                TopSmoothScroller(Context context) {
                    super(context);
                }

                @Override
                public int calculateDtToFit(int viewStart, int viewEnd, int boxStart, int boxEnd, int snapPreference) {
                    return boxStart - viewStart;
                }
            }
        };

        // Elevate headers with a shadow
        layoutManager.elevateHeaders(5);

        // Set up the RecyclerView with the adapter and layout manager
        recyclerReports.setVisibility(View.VISIBLE);
        recyclerReports.setLayoutManager(layoutManager);
        recyclerReports.setAdapter(adapter);

        // Set a StickyHeaderListener for header attachment/detachment events
        layoutManager.setStickyHeaderListener(new StickyLinearLayoutManager.StickyHeaderListener() {
            @Override
            public void headerAttached(View headerView, int adapterPosition) {
                Log.d("StickyHeader", "Header Attached : " + adapterPosition);
            }

            @Override
            public void headerDetached(View headerView, int adapterPosition) {
                Log.d("StickyHeader", "Header Detached : " + adapterPosition);
            }
        });


    }

    /**
     * Method to initiate the API call for Fetch History report list.
     * API Name - "transactionsHistory"
     * **/
    private void callApiViewReports() {
        if(isInitialLoading){
            adapter.clearDataList();
            reportsListPojo = null;
            reportsListPojo = new TransactionsListResponsePojo();
        }
        TransactionsListRequestPojo initTransactionDetailsRequestPojo = new TransactionsListRequestPojo();
        TransactionsListRequestPojo.PagingBean pagingBean = new TransactionsListRequestPojo.PagingBean();
        initTransactionDetailsRequestPojo.setCountryId(countryId);
        initTransactionDetailsRequestPojo.setSearchTerm(edSearch.getText().toString());
        pagingBean.setPage(PAGE_NO);
        pagingBean.setPerPage(NO_OF_RECORDS_LOAD_PER_APICALL);
        initTransactionDetailsRequestPojo.setPaging(pagingBean);

        String json = "";
        Gson gsonUserDetails = new Gson();
        json = gsonUserDetails.toJson(initTransactionDetailsRequestPojo);
        RequestBody accessTokenValue = null;
        try {
            accessTokenValue = RequestBody.create(MediaType.parse("application/json"), json.getBytes("UTF-8"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        Constants.apiInterface.transactionsList(accessTokenValue).enqueue(new Callback<TransactionsListResponsePojo>() {
            @Override
            public void onResponse(Call<TransactionsListResponsePojo> call, Response<TransactionsListResponsePojo> response) {
                if (response.isSuccessful() && response.body() != null) {
                    Gson gson = new Gson();
                    String Json = gson.toJson(response.body());
//                    if (verifyResponse(Json, true, false)) {
                        TOTAL_PAGES = CommonUtils.getAllReportsLoading(response.body().getData().getPagination().getTotalEntries(), NO_OF_RECORDS_LOAD_PER_APICALL);
                        reportsListPojo.getData().getTransactions().addAll(response.body().getData().getTransactions());
                        reportsListPojo.getData().getPagination().setTotalEntries(response.body().getData().getPagination().getTotalEntries());
                        if(isInitialLoading){
                            TOTAL_RECORDS = reportsListPojo.getData().getPagination().getTotalEntries();
                            if(isInitialAPICalling){
                                if(reportsListPojo.getData().getTransactions().size()==0){
                                    llReportMain.setVisibility(View.GONE);
                                    llNoTransactions.setVisibility(View.VISIBLE);
                                }else{
                                    llReportMain.setVisibility(View.VISIBLE);
                                    llNoTransactions.setVisibility(View.GONE);
                                }
                            }else{
                                if(reportsListPojo.getData().getTransactions().size()==0){
                                    vNoData.setVisibility(View.VISIBLE);
                                }else{
                                    vNoData.setVisibility(View.GONE);
                                }
                            }
                            isInitialAPICalling = false;
                            isInitialLoading = false;
                        }
                        if (shouldShowAnimation) {
                            new LMTTextFadeInAnimation().startTextViewAnimation(getApplicationContext(),
                                    "Showing transactions" + " " + reportsListPojo.getData().getTransactions().size() + " " + "of"+ " " + TOTAL_RECORDS
                                    , tvTotalNumberHint, 1500, 0, 5000, LMTTextFadeInAnimation.GRAY_DARK, 2);

                            shouldShowAnimation = false;
                        } else {
                            tvTotalNumberHint.setText("Showing transactions" + " " + reportsListPojo.getData().getTransactions().size() + " " + "of" + " " + TOTAL_RECORDS);
                        }

                        if(!isInitialLoading){
                            try {
                                adapter.addDataList(getHistoryList(Json));
                            } catch (ParseException e) {
                                e.printStackTrace();
                            }
                        }else{
                            try {
                                adapter.setDataList(getHistoryList(Json));
                            } catch (ParseException e) {
                                e.printStackTrace();
                            }
                        }

                        frame_recycler_view.setVisibility(View.VISIBLE);;
                        if (reportsListPojo.getData().getTransactions().size() > 0) {
                            recyclerReports.setVisibility(View.VISIBLE);
                        } else {
                            recyclerReports.setVisibility(View.GONE);
                        }

                        isLoading = false;
//                    }
                }
//                else {
//                    if (response.code() == 401) {
//                        showSessionOutPopUp();
//                    } else {
//                        showServerErrorPopup();
//                    }
//                }
//                myProgressDialog.dismissProgress();
//                HomeActivity.homeActionsInterface.onApiCallEnds();
                shimmerView.setVisibility(View.GONE);
            }

            @Override
            public void onFailure(Call<TransactionsListResponsePojo> call, Throwable t) {
//                myProgressDialog.dismissProgress();
                shimmerView.setVisibility(View.GONE);
//                HomeActivity.homeActionsInterface.onApiCallEnds();
//                if (!isNetworkConnected(getContext())) {
//                    showInternetErrorPopUp();
//                } else {
//                    showServerErrorPopup();
//                }
            }
        });
    }

    /**
     * Parses the JSON response and creates a list of HistoryItems for displaying transaction history.
     *
     * @param JsonResponse JSON response containing transaction data.
     * @return List of HistoryItems for the transaction history.
     * @throws ParseException Thrown if there is an error parsing the date.
     */
    public List<Object> getHistoryList(String JsonResponse) throws ParseException {

        Gson gson = new Gson();
        ReportJsonData = gson.fromJson(JsonResponse, TransactionsListResponsePojo.class);

        List<Object> items = new ArrayList<>();
        int historyListCount =  ReportJsonData.getData().getTransactions().size();

        for (int i = 0; i < historyListCount; i++ ){

            SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
            Date d = f.parse(ReportJsonData.getData().getTransactions().get(i).getTransactionDate()); // Format String to a dateobject with the format provided by the String.
            SimpleDateFormat month = new SimpleDateFormat("MM");  // eg - "02" (February)
            SimpleDateFormat monthFullName = new SimpleDateFormat("MMMM"); // MMMM for full month name  eg - "February"
            SimpleDateFormat year = new SimpleDateFormat("yyyy");
            System.out.println(month.format(d)); // eg - 03

            if( currentDisplayedMonth == 0 && currentDisplayedYear == 0){
                currentDisplayedMonth = Integer.parseInt(month.format(d));
                currentDisplayedYear = Integer.parseInt(year.format(d));
                //items.add(new HistoryHeaderItem(CommonUtils.getEnglishMonth(month.format(d))));
                items.add(new HistoryHeaderItem(CommonUtils.getEnglishMonth(month.format(d))+ " " +year.format(d) ));
            }else{
                if(Integer.parseInt(month.format(d)) != currentDisplayedMonth){
                    if(CurrentYear){
                        if(Integer.parseInt(year.format(d)) != currentDisplayedYear){
                            currentDisplayedYear = Integer.parseInt(year.format(d));
                            currentDisplayedMonth = Integer.parseInt(month.format(d));
                            CurrentYear = false;

                            items.add(new HistoryHeaderItem(CommonUtils.getEnglishMonth(month.format(d))+ " " +year.format(d) ));
                        }else{
                            if(currentDisplayedMonth != Integer.parseInt(month.format(d))){
                                currentDisplayedMonth = Integer.parseInt(month.format(d));

                                //items.add(new HistoryHeaderItem(CommonUtils.getEnglishMonth(month.format(d))));
                                items.add(new HistoryHeaderItem(CommonUtils.getEnglishMonth(month.format(d))+ " " +year.format(d) ));
                            }
                        }
                    }else{
                        if(currentDisplayedMonth != Integer.parseInt(month.format(d))){
                            currentDisplayedYear = Integer.parseInt(year.format(d));
                            currentDisplayedMonth = Integer.parseInt(month.format(d));

                            items.add(new HistoryHeaderItem(CommonUtils.getEnglishMonth(month.format(d))+ " " +year.format(d)));
                        }
                    }
                }
            }

            String referenceId  = ReportJsonData.getData().getTransactions().get(i).getReferenceId();
            String status = ReportJsonData.getData().getTransactions().get(i).getStatus();
            Double convertingAmount = ReportJsonData.getData().getTransactions().get(i).getConvertingAmount();
            Double receivingAmount = ReportJsonData.getData().getTransactions().get(i).getReceivingAmount();
            String convertingAmountCurrency = ReportJsonData.getData().getTransactions().get(i).getConvertingAmountCurrency();
            String receivingAmountCurrency = ReportJsonData.getData().getTransactions().get(i).getReceivingAmountCurrency();
            String transactionDate = ReportJsonData.getData().getTransactions().get(i).getTransactionDate();
            Double charges = ReportJsonData.getData().getTransactions().get(i).getCharges();
            String beneficiaryName = ReportJsonData.getData().getTransactions().get(i).getBeneficiaryName();
            String accountNumber = ReportJsonData.getData().getTransactions().get(i).getAccountNumber();
            String flagURL = ReportJsonData.getData().getTransactions().get(i).getFlagURL();
            Double totalDebitAmount = ReportJsonData.getData().getTransactions().get(i).getTotalDebitAmount();
            Double Amount = ReportJsonData.getData().getTransactions().get(i).getAmount();
            String TranferMode = ReportJsonData.getData().getTransactions().get(i).getTranferMode();
            String TransactionType = ReportJsonData.getData().getTransactions().get(i).getTransactionType();
            String PurposeOfTransaction = ReportJsonData.getData().getTransactions().get(i).getPurposeOfTransaction();
            String TransactionStatus = ReportJsonData.getData().getTransactions().get(i).getTransactionStatus();
            String BeneficiaryPhoto = ReportJsonData.getData().getTransactions().get(i).getBeneficiaryPhoto();

            items.add(new HistoryItem(referenceId,status,convertingAmount,receivingAmount,convertingAmountCurrency,
                    receivingAmountCurrency,transactionDate,charges,beneficiaryName,accountNumber,flagURL,totalDebitAmount,
                    Amount,TranferMode,TransactionType,PurposeOfTransaction,TransactionStatus,BeneficiaryPhoto));

        }

        return items;
    }
}