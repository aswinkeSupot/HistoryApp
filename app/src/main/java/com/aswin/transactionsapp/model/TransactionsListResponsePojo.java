package com.aswin.transactionsapp.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class TransactionsListResponsePojo {
    @SerializedName("success")
    private String success;
    @SerializedName("message")
    private String message;
    @SerializedName("accessToken")
    private String accessToken;
    @SerializedName("tokenStatus")
    private String tokenStatus;
    @SerializedName("data")
    private DataBean data =new DataBean();

    public String getSuccess() {
        return success;
    }
    public void setSuccess(String success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }

    public String getAccessToken() {
        return accessToken;
    }
    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getTokenStatus() {
        return tokenStatus;
    }
    public void setTokenStatus(String tokenStatus) {
        this.tokenStatus = tokenStatus;
    }

    public DataBean getData() {
        return data;
    }
    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        @SerializedName("transactions")
        private List<TransactionsBean> transactions =new ArrayList<>();
        @SerializedName("pagination")
        private PaginationBean pagination =new PaginationBean();

        public List<TransactionsBean> getTransactions() {
            return transactions;
        }
        public void setTransactions(List<TransactionsBean> transactions) {
            this.transactions = transactions;
        }

        public PaginationBean getPagination() {
            return pagination;
        }
        public void setPagination(PaginationBean pagination) {
            this.pagination = pagination;
        }

        public static class PaginationBean {
            @SerializedName("totalEntries")
            private Integer totalEntries;
            @SerializedName("totalPages")
            private Integer totalPages;
            @SerializedName("perPage")
            private Integer perPage;
            @SerializedName("previousPage")
            private Integer previousPage;
            @SerializedName("nextPage")
            private Integer nextPage;
            @SerializedName("currentPage")
            private Integer currentPage;

            public Integer getTotalEntries() {
                return totalEntries;
            }
            public void setTotalEntries(Integer totalEntries) {
                this.totalEntries = totalEntries;
            }

            public Integer getTotalPages() {
                return totalPages;
            }
            public void setTotalPages(Integer totalPages) {
                this.totalPages = totalPages;
            }

            public Integer getPerPage() {
                return perPage;
            }
            public void setPerPage(Integer perPage) {
                this.perPage = perPage;
            }

            public Integer getPreviousPage() {
                return previousPage;
            }
            public void setPreviousPage(Integer previousPage) {
                this.previousPage = previousPage;
            }

            public Integer getNextPage() {
                return nextPage;
            }
            public void setNextPage(Integer nextPage) {
                this.nextPage = nextPage;
            }

            public Integer getCurrentPage() {
                return currentPage;
            }
            public void setCurrentPage(Integer currentPage) {
                this.currentPage = currentPage;
            }
        }

        public static class TransactionsBean {
            public TransactionsBean(String referenceId, String status, Double convertingAmount, Double receivingAmount, String convertingAmountCurrency, String receivingAmountCurrency,
                                    String transactionDate, Double charges, String beneficiaryName, String accountNumber, String flagURL, Double totalDebitAmount, Double amount,
                                    String tranferMode, String transactionType, String purposeOfTransaction, String transactionStatus) {
                this.referenceId = referenceId;
                this.status = status;
                this.convertingAmount = convertingAmount;
                this.receivingAmount = receivingAmount;
                this.convertingAmountCurrency = convertingAmountCurrency;
                this.receivingAmountCurrency = receivingAmountCurrency;
                this.transactionDate = transactionDate;
                this.charges = charges;
                this.beneficiaryName = beneficiaryName;
                this.accountNumber = accountNumber;
                this.flagURL = flagURL;
                this.totalDebitAmount = totalDebitAmount;
                Amount = amount;
                TranferMode = tranferMode;
                TransactionType = transactionType;
                PurposeOfTransaction = purposeOfTransaction;
                TransactionStatus = transactionStatus;
//                this.BeneficiaryPhoto = BeneficiaryPhoto;
            }

            @SerializedName("accountNumber")
            private String accountNumber;
            @SerializedName("amount")
            private Double Amount;
            @SerializedName("beneficiaryName")
            private String beneficiaryName;
            @SerializedName("beneficiaryPhoto")
            private String BeneficiaryPhoto;
            @SerializedName("charges")
            private Double charges;
            @SerializedName("convertingAmount")
            private Double convertingAmount;
            @SerializedName("convertingAmountCurrency")
            private String convertingAmountCurrency;
            @SerializedName("flagURL")
            private String flagURL;
            @SerializedName("purposeOfTransaction")
            private String PurposeOfTransaction;
            @SerializedName("receivingAmount")
            private Double receivingAmount;
            @SerializedName("receivingAmountCurrency")
            private String receivingAmountCurrency;
            @SerializedName("referenceId")
            private String referenceId;
            @SerializedName("status")
            private String status;
            @SerializedName("totalDebitAmount")
            private Double totalDebitAmount;
            @SerializedName("tranferMode")
            private String TranferMode;
            @SerializedName("transactionDate")
            private String transactionDate;
            @SerializedName("transactionStatus")
            private String TransactionStatus;
            @SerializedName("transactionType")
            private String TransactionType;



            public String getReferenceId() {
                return referenceId;
            }
            public void setReferenceId(String referenceId) {
                this.referenceId = referenceId;
            }

            public String getStatus() {
                return status;
            }
            public void setStatus(String status) {
                this.status = status;
            }

            public Double getConvertingAmount() {
                return convertingAmount;
            }
            public void setConvertingAmount(Double convertingAmount) {
                this.convertingAmount = convertingAmount;
            }

            public Double getReceivingAmount() {
                return receivingAmount;
            }
            public void setReceivingAmount(Double receivingAmount) {
                this.receivingAmount = receivingAmount;
            }

            public String getConvertingAmountCurrency() {
                return convertingAmountCurrency;
            }
            public void setConvertingAmountCurrency(String convertingAmountCurrency) {
                this.convertingAmountCurrency = convertingAmountCurrency;
            }

            public String getReceivingAmountCurrency() {
                return receivingAmountCurrency;
            }
            public void setReceivingAmountCurrency(String receivingAmountCurrency) {
                this.receivingAmountCurrency = receivingAmountCurrency;
            }

            public String getTransactionDate() {
                return transactionDate;
            }
            public void setTransactionDate(String transactionDate) {
                this.transactionDate = transactionDate;
            }

            public Double getCharges() {
                return charges;
            }
            public void setCharges(Double charges) {
                this.charges = charges;
            }

            public String getBeneficiaryName() {
                return beneficiaryName;
            }
            public void setBeneficiaryName(String beneficiaryName) {
                this.beneficiaryName = beneficiaryName;
            }

            public String getAccountNumber() {
                return accountNumber;
            }
            public void setAccountNumber(String accountNumber) {
                this.accountNumber = accountNumber;
            }

            public String getFlagURL() {
                return flagURL;
            }
            public void setFlagURL(String flagURL) {
                this.flagURL = flagURL;
            }

            public Double getTotalDebitAmount() {
                return totalDebitAmount;
            }
            public void setTotalDebitAmount(Double totalDebitAmount) {
                this.totalDebitAmount = totalDebitAmount;
            }

            public Double getAmount() {
                return Amount;
            }
            public void setAmount(Double amount) {
                Amount = amount;
            }

            public String getTranferMode() {
                return TranferMode;
            }
            public void setTranferMode(String tranferMode) {
                TranferMode = tranferMode;
            }

            public String getTransactionType() {
                return TransactionType;
            }
            public void setTransactionType(String transactionType) {
                TransactionType = transactionType;
            }

            public String getPurposeOfTransaction() {
                return PurposeOfTransaction;
            }
            public void setPurposeOfTransaction(String purposeOfTransaction) {
                PurposeOfTransaction = purposeOfTransaction;
            }

            public String getTransactionStatus() {
                return TransactionStatus;
            }
            public void setTransactionStatus(String transactionStatus) {
                TransactionStatus = transactionStatus;
            }

            public String getBeneficiaryPhoto() {
                return BeneficiaryPhoto;
            }
            public void setBeneficiaryPhoto(String beneficiaryPhoto) {
                BeneficiaryPhoto = beneficiaryPhoto;
            }
        }
    }
}
