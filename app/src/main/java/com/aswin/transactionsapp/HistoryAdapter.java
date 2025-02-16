package com.aswin.transactionsapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.aswin.transactionsapp.model.HistoryHeaderItem;
import com.aswin.transactionsapp.model.HistoryItem;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.aswin.transactionsapp.utilities.Constants;
import com.aswin.transactionsapp.utilities.CheckObject;
import com.aswin.transactionsapp.utilities.CommonUtils;
import com.yuyang.stickyheaders.AdapterDataProvider;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public final class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.BaseViewHolder> implements AdapterDataProvider {

    private final List<Object> dataList = new ArrayList<>();
    private Context context;
    private RecyclerItemClickListener mListener;

    public HistoryAdapter(Context context, RecyclerItemClickListener mListener) {
        this.context = context;
        this.mListener = mListener;
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == 0) {
            return new ItemViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.history_item_view, parent, false));
        } else {
            return new HeaderViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.history_header_view, parent, false));
        }
    }

    @Override
    public void onBindViewHolder(final BaseViewHolder holder, @SuppressLint("RecyclerView") final int position) {
        final Object item = dataList.get(position);
        if (item instanceof HistoryItem) {

            ItemViewHolder itemViewHolder = (ItemViewHolder) holder;
            if(((HistoryItem) item).getBeneficiaryName() != null){
                itemViewHolder.tv_benificiary_name.setText(((HistoryItem) item).getBeneficiaryName());
            }

            // LIVE
            String dateRecieved = ((HistoryItem) item).getTransactionDate();
//            String dateRecieved = "2024-04-11T09:48:15+00:00";  //"3:18PM"
//            String dateRecieved = "2024-04-11T09:21:37+00:00";  //"2024-04-11T09:21:37+02:00"  "2.51 PM"
            String date = CommonUtils.getDateTimeStringByLocalFormatWithToday(dateRecieved, CommonUtils.SDF_DATE_FROM_SERVER_FORMAT, CommonUtils.SDF_DATE_TIME_DISPLAY_FORMAT_NEW);
            // STAGE
//            String date = CommonUtils.getConvertedTimeFromUTC(((HistoryItem) item).getTransactionDate(), CommonUtils.SDF_DATE_FROM_STAGE_SERVER_FORMAT, CommonUtils.SDF_DATE_TIME_DISPLAY_FORMAT_NEW);

            itemViewHolder.tv_date.setText(date);
            itemViewHolder.tv_amount.setText( "P"+" "+formatDecimal(((HistoryItem) item).getTotalDebitAmount())+"");
//            itemViewHolder.tv_amount.setText( "P"+" "+((HistoryItem) item).getTotalDebitAmount()+"");  //formatDecimal


            if(((HistoryItem) item).getBeneficiaryName() != null){
//                itemViewHolder.tvNameLetter.setText(((HistoryItem) item).getBeneficiaryName().trim().toUpperCase().charAt(0)+"");
                itemViewHolder.tvNameLetter.setText(CheckObject.getFirstLetters(((HistoryItem) item).getBeneficiaryName()));
            }

            if(((HistoryItem) item).getBeneficiaryPhoto() != null){
                itemViewHolder.imgProfile.setVisibility(View.VISIBLE);
                itemViewHolder.tvNameLetter.setVisibility(View.GONE);
                Glide.with(context).load(((HistoryItem) item).getBeneficiaryPhoto()).apply(new RequestOptions().override(100, 100)).centerCrop().placeholder(R.drawable.avatar_male).error(R.drawable.avatar_male).into(itemViewHolder.imgProfile);
            }else{
                itemViewHolder.imgProfile.setVisibility(View.GONE);
                itemViewHolder.tvNameLetter.setVisibility(View.VISIBLE);
            }

            if(((HistoryItem) item).getFlagURL() != null){
                itemViewHolder.imgFlag.setVisibility(View.VISIBLE);
                Glide.with(context).load(((HistoryItem) item).getFlagURL()).apply(new RequestOptions().override(100, 100)).centerCrop().placeholder(R.drawable.ic_flag_placeholder).error(R.drawable.ic_flag_placeholder).into(itemViewHolder.imgFlag);
            }else{
                itemViewHolder.imgFlag.setVisibility(View.GONE);
            }

            if(((HistoryItem) item).getTransactionStatus().equals("credit")){
                if(!CheckObject.isNullString(((HistoryItem) item).getStatus())) {
                    String status = ((HistoryItem) item).getStatus().toUpperCase();
                    if(status.equals("SUCCESS")){
                        itemViewHolder.imgTransactionStatus.setBackgroundResource(R.drawable.ic_arrow_receive);
                        itemViewHolder.tv_amount.setTextColor(context.getResources().getColor(R.color.green));
                        itemViewHolder.tvFailedProcessingStatus.setVisibility(View.GONE);
                    }else if(status.equals("FAILED")){
                        itemViewHolder.imgTransactionStatus.setBackgroundResource(R.drawable.ic_arrow_failed);
                        itemViewHolder.tv_amount.setTextColor(context.getResources().getColor(R.color.background_text_fit_black_light));
                        itemViewHolder.tvFailedProcessingStatus.setText("Failed");
                        itemViewHolder.tvFailedProcessingStatus.setVisibility(View.VISIBLE);
                        itemViewHolder.tvFailedProcessingStatus.setTextColor(context.getResources().getColor(R.color.red));
                    }else{
                        itemViewHolder.imgTransactionStatus.setBackgroundResource(R.drawable.ic_arrow_processing);
                        itemViewHolder.tv_amount.setTextColor(context.getResources().getColor(R.color.background_text_fit_black_light));
                        itemViewHolder.tvFailedProcessingStatus.setText("Processing");
                        itemViewHolder.tvFailedProcessingStatus.setVisibility(View.VISIBLE);
                        itemViewHolder.tvFailedProcessingStatus.setTextColor(context.getResources().getColor(R.color.primaryUserDark));
                    }
                }else{
                    itemViewHolder.imgTransactionStatus.setBackgroundResource(R.drawable.ic_arrow_receive);
                    itemViewHolder.tv_amount.setTextColor(context.getResources().getColor(R.color.redReport));
                    itemViewHolder.tvFailedProcessingStatus.setVisibility(View.GONE);
                }
            }
            // Debit
            else{
                if(!CheckObject.isNullString(((HistoryItem) item).getStatus())) {
                    String status = ((HistoryItem) item).getStatus().toUpperCase();
                    if(status.equals("SUCCESS")){
                        itemViewHolder.imgTransactionStatus.setBackgroundResource(R.drawable.ic_arrow_send);
                        itemViewHolder.tv_amount.setTextColor(context.getResources().getColor(R.color.redReport));
                        itemViewHolder.tvFailedProcessingStatus.setVisibility(View.GONE);
                    }else if(status.equals("FAILED")){
                        itemViewHolder.imgTransactionStatus.setBackgroundResource(R.drawable.ic_arrow_failed);
                        itemViewHolder.tv_amount.setTextColor(context.getResources().getColor(R.color.background_text_fit_black_light));
                        itemViewHolder.tvFailedProcessingStatus.setText("Failed");
                        itemViewHolder.tvFailedProcessingStatus.setVisibility(View.VISIBLE);
                        itemViewHolder.tvFailedProcessingStatus.setTextColor(context.getResources().getColor(R.color.red));
                    }else{
                        itemViewHolder.imgTransactionStatus.setBackgroundResource(R.drawable.ic_arrow_processing);
                        itemViewHolder.tv_amount.setTextColor(context.getResources().getColor(R.color.background_text_fit_black_light));
                        itemViewHolder.tvFailedProcessingStatus.setText("Processing");
                        itemViewHolder.tvFailedProcessingStatus.setVisibility(View.VISIBLE);
                        itemViewHolder.tvFailedProcessingStatus.setTextColor(context.getResources().getColor(R.color.primaryUserDark));
                    }
                } else{
                    itemViewHolder.imgTransactionStatus.setBackgroundResource(R.drawable.ic_arrow_send);
                    itemViewHolder.tv_amount.setTextColor(context.getResources().getColor(R.color.redReport));
                    itemViewHolder.tvFailedProcessingStatus.setVisibility(View.GONE);
                }
            }

            switch (((HistoryItem) item).getTransactionType().toUpperCase()) {
                case Constants.TRANSACTIONTYPE_NAME_WALLET_TO_WALLET:
                    itemViewHolder.tvTransferType.setText(Constants.ALIAS_TRANSACTIONTYPE_NAME_WALLET_TO_WALLET);
                    break;
                case Constants.TRANSACTIONTYPE_NAME_WALLET_TO_BANK:
                    itemViewHolder.tvTransferType.setText(Constants.ALIAS_TRANSACTIONTYPE_NAME_WALLET_TO_BANK);
                    break;
                case Constants.TRANSACTIONTYPE_NAME_WALLET_TO_CASHPICKUP:
                    itemViewHolder.tvTransferType.setText(Constants.ALIAS_TRANSACTIONTYPE_NAME_WALLET_TO_CASHPICKUP);
                    break;
                case Constants.TRANSACTIONTYPE_NAME_WALLET_TO_INSTANT:
                    itemViewHolder.tvTransferType.setText(Constants.ALIAS_TRANSACTIONTYPE_NAME_WALLET_TO_INSTANT);
                    break;
                case Constants.TRANSACTIONTYPE_NAME_WALLET_TO_UTILITY:
                    itemViewHolder.tvTransferType.setText(Constants.ALIAS_TRANSACTIONTYPE_NAME_WALLET_TO_UTILITY);
                    break;
                case Constants.TRANSACTIONTYPE_NAME_WALLET_TO_CUSTOMER:
                    itemViewHolder.tvTransferType.setText(Constants.ALIAS_TRANSACTIONTYPE_NAME_WALLET_TO_CUSTOMER);
                    break;
                case Constants.TRANSACTIONTYPE_NAME_WALLET_TO_CASHOUT:
                    itemViewHolder.tvTransferType.setText(Constants.ALIAS_TRANSACTIONTYPE_NAME_WALLET_TO_CASHOUT);
                    break;
                case Constants.TRANSACTIONTYPE_NAME_WALLET_TO_MOBILENUMBER:
                    itemViewHolder.tvTransferType.setText(Constants.ALIAS_TRANSACTIONTYPE_NAME_WALLET_TO_MOBILENUMBER);
                    break;
                case Constants.TRANSACTIONTYPE_NAME_CUSTOMER_TO_MERCHANT_QR_CASH:
                    itemViewHolder.tvTransferType.setText(Constants.ALIAS_TRANSACTIONTYPE_NAME_CUSTOMER_TO_MERCHANT_QR_CASH);
                    break;
                case Constants.TRANSACTIONTYPE_NAME_CUSTOMER_TO_MERCHANT_MOBNO_CASH:
                    itemViewHolder.tvTransferType.setText(Constants.ALIAS_TRANSACTIONTYPE_NAME_CUSTOMER_TO_MERCHANT_MOBNO_CASH);
                    break;
                case Constants.TRANSACTIONTYPE_NAME_INTERNATIONAL_TRANSFER:
                    itemViewHolder.tvTransferType.setText(Constants.ALIAS_TRANSACTIONTYPE_NAME_INTERNATIONAL_TRANSFER);
                    break;
                case Constants.TRANSACTIONTYPE_NAME_MERCHANT_TO_WALLET:
                    itemViewHolder.tvTransferType.setText(Constants.ALIAS_TRANSACTIONTYPE_NAME_MERCHANT_TO_WALLET);
                    break;
                case Constants.TRANSACTIONTYPE_NAME_MOBILENO_TO_MERCHANT:
                    itemViewHolder.tvTransferType.setText(Constants.ALIAS_TRANSACTIONTYPE_NAME_MOBILENO_TO_MERCHANT);
                    break;
                default:
                    itemViewHolder.tvTransferType.setText(((HistoryItem) item).getTransactionType());
                    break;
            }

            itemViewHolder.llMain.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mListener.onItemClick(((HistoryItem) item));
                }
            });
        } else if (item instanceof HistoryHeaderItem) {
            HeaderViewHolder headerViewHolder = (HeaderViewHolder) holder;
            headerViewHolder.titleTextView.setText(((HistoryHeaderItem) item).title);
        }
    }

    public String formatDecimal(double number) {
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        return decimalFormat.format(number);
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    @Override
    public int getItemViewType(int position) {
        return dataList.get(position) instanceof HistoryItem ? 0 : 1;
    }

    @Override
    public List<?> getAdapterData() {
        return dataList;
    }

    public void setDataList(List<Object> items) {
        dataList.clear();
        dataList.addAll(items);
        notifyDataSetChanged();
    }

    public void addDataList(List<Object> items) {
        if (items != null) {
            int start = dataList.size();
            dataList.addAll(items);
            notifyItemRangeInserted(start, items.size());
        }
    }

    public void clearDataList(){
        dataList.clear();
        notifyDataSetChanged();
    }

    private static final class ItemViewHolder extends BaseViewHolder {
        TextView tv_benificiary_name;
        TextView tv_date;
        TextView tv_amount;
        TextView tvFailedProcessingStatus;
        TextView tvNameLetter;
        TextView tvTransferType;
        ImageView imgTransactionStatus;
        ImageView imgFlag;
        CircleImageView imgProfile;
        LinearLayout llMain;
        ItemViewHolder(View itemView) {
            super(itemView);
            tv_benificiary_name = itemView.findViewById(R.id.tv_benificiary_name);
            tv_date = itemView.findViewById(R.id.tv_date);
            tv_amount = itemView.findViewById(R.id.tv_amount);
            tvFailedProcessingStatus= itemView.findViewById(R.id.tvFailedProcessingStatus);
            tvNameLetter = itemView.findViewById(R.id.tvNameLetter);
            tvTransferType = itemView.findViewById(R.id.tvTransferType);
            imgTransactionStatus = itemView.findViewById(R.id.imgTransactionStatus);
            imgProfile = itemView.findViewById(R.id.imgProfile);
            imgFlag = itemView.findViewById(R.id.imgFlag);
            llMain = itemView.findViewById(R.id.llMain);
        }
    }

    private static final class HeaderViewHolder extends BaseViewHolder {
        TextView titleTextView;
        HeaderViewHolder(View itemView) {
            super(itemView);
            titleTextView = itemView.findViewById(R.id.tv_title);
        }
    }

    static class BaseViewHolder extends RecyclerView.ViewHolder {
        BaseViewHolder(View itemView) {
            super(itemView);
        }
    }

    public interface RecyclerItemClickListener {
        void onItemClick(HistoryItem historyItem);
    }

}
