package com.aswin.transactionsapp.model;

public class HistoryItem {
    private String referenceId;
    private String status;
    private Double convertingAmount;
    private Double receivingAmount;
    private String convertingAmountCurrency;
    private String receivingAmountCurrency;
    private String transactionDate;
    private Double charges;
    private String beneficiaryName;
    private String accountNumber;
    private String flagURL;
    private Double totalDebitAmount;
    private Double Amount;
    private String TranferMode;
    private String TransactionType;
    private String PurposeOfTransaction;
    private String TransactionStatus;
    private String BeneficiaryPhoto;

    public HistoryItem(String referenceId, String status, Double convertingAmount, Double receivingAmount, String convertingAmountCurrency,
                       String receivingAmountCurrency, String transactionDate, Double charges, String beneficiaryName, String accountNumber,
                       String flagURL, Double totalDebitAmount, Double Amount, String TranferMode, String TransactionType, String PurposeOfTransaction, String TransactionStatus, String BeneficiaryPhoto) {

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
        this.Amount = Amount;
        this.TranferMode = TranferMode;
        this.TransactionType = TransactionType;
        this.PurposeOfTransaction = PurposeOfTransaction;
        this.TransactionStatus = TransactionStatus;
        this.BeneficiaryPhoto = BeneficiaryPhoto;
    }

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
