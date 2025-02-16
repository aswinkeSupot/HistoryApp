package com.aswin.transactionsapp.utilities;


import com.aswin.transactionsapp.api.ApiClient;
import com.aswin.transactionsapp.api.ApiInterface;

public class Constants {

    // Switch Availabities.
//    public static final Boolean isInternationalMode = true;
//    public static final Boolean isDomesticMode = true;
//    public static final Boolean isWallet = true;
//    public static final Boolean isDomesticBank = true;
//    public static final Boolean isDomesticCash = true;
//    public static final Boolean isRemicard = true;
//    public static final Boolean isUtility = true;
//    public static final Boolean isRewards = true;
//    public static final Boolean isOffers = true;
//    public static final Boolean isCashPickup = true;
    public static final boolean IS_DEBUGGING_MODE = true;
    public static Boolean isInternationalMode = true;
    public static Boolean isDomesticMode = true;
    public static Boolean isWallet = true;
    public static Boolean isDomesticBank = true;
    public static Boolean isDomesticCash = true;
    public static Boolean isRemicard = false;
    public static Boolean isUtility = true;
    public static Boolean isRewards = false;
    public static Boolean isOffers = false;
    public static Boolean isCashPickup = true;

//    public static final String IS_INTERNATIONAL_MODE = "isInternationalMode";
//    public static final String IS_DOMESTIC_MODE = "isDomesticMode";
//    public static final String IS_WALLET = "isWallet";
//    public static final String IS_DOMESTIC_BANK = "isDomesticBank";
//    public static final String IS_DOMESTIC_CASH = "isDomesticCash";
//    public static final String IS_REMICARD = "isRemicard";
//    public static final String IS_UTILITY = "isUtility";
//    public static final String IS_REWARDS = "isRewards";
//    public static final String IS_OFFERS = "isOffers";
//    public static final String IS_CASH_PICKUP = "isCashPickup";

        // Wallet Remicard Send Rewards More Accounts Recipients History
    public static final int BOTTOM_TAB_ACCOUNTS = 1;
    public static final int BOTTOM_TAB_RECIPIENTS = 2;
    public static final int BOTTOM_TAB_STORES = 27;
    public static final int BOTTOM_TAB_REWARDS = 3;
    public static final int BOTTOM_TAB_HISTORY = 4;
    public static final int BOTTOM_TAB_SEND_MONEY_ABROAD = 5;
    public static final int BOTTOM_TAB_MORE = 6;
    public static final int BOTTOM_TAB_MY_WALLET = 7;
    public static final int BOTTOM_TAB_REMICARD = 8;
    public static final int BOTTOM_TAB_ADD_COUNTRY = 9;
    public static final int BOTTOM_TAB_SEND_COUNTRY_LIST = 10;
    public static final int BOTTOM_TAB_WALLET = 11;
//    public static final int BOTTOM_TAB_MORE_HISTORY = 11;
    public static final int BOTTOM_TAB_OFFERS = 12;
    public static final int BOTTOM_TAB_UTILITIES = 13;
    public static final int BOTTOM_TAB_BANK_TRANSFER = 14;
    public static final int BOTTOM_TAB_PAZANA_CASH = 25;
    public static final int BOTTOM_TAB_INFO = 26;

    /** WALLET **/
    public static final int LINKED_ACCOUNT_WALLET = 15;
    public static final int SAVED_CARDS_WALLET = 16;
    public static final int PAYMENT_LIMITS_WALLET = 17;
    public static final int WITHDRAY_FUND_WALLET = 18;
    public static final int ADD_MONEY_TO_WALLET = 19;

    /** SAVE CARDS **/
    public static final int GET_CHARGE_FRAGMENT = 127;
    public static final int ADD_NEW_CARD = 20;
    public static final int INITIAL_ADD_NEW_CARDS_FRAGMENT = 121;
    public static final int INITIAL_UPDATE_CARDS_FRAGMENT = 122;
    public static final int WEB_VIEW_SMALL_ADD_CARD_FRAGMENT = 123;
    public static final int INITIAL_ADD_CARDS_FRAGMENT = 124;

    public static final int PAYOUT_TO_AGENT_FRAGMENT = 125;
    public static final int ENTER_AMOUNT_FRAGMENT = 126;

    /** WITHDRAW FUNDS **/
    public static final int TRANSFER_TO_BANK = 21;
    public static final int PAYOUT_TO_AGENT = 22;
    public static final int PAYOUT_TO_AGENT_ENTER_AMOUNT = 23;

    /** PAY TO AGENT - PIN ENTER **/
    public static final int PAY_TO_AGENT_PIN_ENTER = 24;

    /** RECIPIENT ADD **/
    public static final int BACK_TO_RECIPIENT_HOME = 40;
    public static final int BACK_TO_RECIPIENT_TYPE = 41;
    public static final int BACK_TO_COUNTRY_LIST = 42;
    public static final int BACK_TO_DELIVERY_METHOD_SELECTION = 43;
    public static final int BACK_TO_ADD_RECIPIENT_DETAILS = 44;

    /** SEND **/
    public static final int BACK_TO_SEND_HOME = 50;
    public static final int BACK_TO_SEND_MONEY_WALLET = 51;
    public static final int BACK_TO_ADD_NEW_CONTACT_WALLET = 52;
    public static final int BACK_TO_SEND_MONEY_ENTER_AMOUNT = 53;
    public static final int BACK_TO_ADD_NEW_CONNECTION_SEARCH = 54;

    /** International Transation **/
    public static final int BACK_TO_INTERNATIONAL_HOME_PAGE = 55;
    public static final int BACK_TO_INTERNATIONAL_COUNTRYLIST_PAGE = 56;
    public static final int BACK_TO_INTERNATIONAL_RATE_PAGE = 57;
    public static final int BACK_TO_INTERNATIONAL_RECIPIENTLIST_PAGE = 58;
    public static final int BACK_TO_INTERNATIONAL_PURPOSE_PAGE = 59;
    public static final int BACK_TO_INTERNATIONAL_CONFIRMATION_PAGE = 60;
    public static final int BACK_TO_INTERNATIONAL_TRANSATIONSUCCESSFULL_PAGE = 61;
    public static final int BACK_TO_INTERNATIONAL_TRANSATIONINVOICE_PAGE = 62;
    public static final int BACK_TO_INTERNATIONAL_CANCELREASON_PAGE = 63;

    /** Transfer to bank **/
    public static final int BACK_TO_TRANSFER_TO_BANK_HOME = 70;

    /** AddMoneyFragmentID's **/
    public static final int BACK_TO_ADD_MONEY_HOME_PAGE = 80;
    public static final int BACK_TO_GET_CARD_CHARGES_PAGE = 85;
    public static final int BACK_TO_SELECT_PAYMENT_SERVICE_FRAGMENT = 81;
    public static final int BACK_TO_INITIAL_ADD_NEW_CARD_FRAGMENT = 82;
    public static final int BACK_TO_INITIAL_UPDATE_CARD_FRAGMENT = 83;
    public static final int BACK_TO_INITIAL_ADD_CARD_FRAGMENT = 84;

    public static final String Constant_Key = "PayzanaLive";
    public static final String APP_VERSION = "App_Version";

    public static final String isMaintenanceOn = "isMaintenanceOn";

    public static final String SIGN_UP_TEMP_FIRST_NAME = "signUpTempFirstName";
    public static final String SIGN_UP_TEMP_MIDDLE_NAME = "signUpTempMiddleName";
    public static final String SIGN_UP_TEMP_LAST_NAME = "signUpTempLastName";
    public static final String SIGN_UP_TEMP_EMAIL = "signUpTempEmail";
    public static final String SIGN_UP_TEMP_GENDER = "signUpTempGender";
    public static final String SIGN_UP_TEMP_GENDER_ID = "signUpTempGenderId";
    public static final String SIGN_UP_TEMP_REFFERAL_CODE = "signUpTempRefferal";
    public static final String SIGN_UP_TEMP_PLOT_NO = "signUpTempPlotNo";
    public static final String SIGN_UP_TEMP_STREET = "signUpTempStreet";
    public static final String SIGN_UP_TEMP_CITY = "signUpTempCity";
    public static final String SIGN_UP_TEMP_DOB = "signUpTempDob";  // DOB Format - "dd/MMM/yyyy"
    public static final String SIGN_UP_TEMP_DOB_FOR_SET = "signUpTempDobForSet";  // DOB Format - "dd MMMM yyyy"
    public static final String SIGN_UP_TEMP_LATITUDE = "signUpTempLatitude";
    public static final String SIGN_UP_TEMP_LONGITUDE = "signUpTempLongitude";
    public static final String SIGN_UP_TEMP_DOCUMENT_TYPE_ID = "signUpTempDocumentTypeId";
    public static final String SIGN_UP_TEMP_DOCUMENT_TYPE_NAME = "signUpTempDocumentTypeName";
    public static final String SIGN_UP_TEMP_DOCUMENT_NUMBER = "signUpTempDocumentNumber";
    public static final String SIGN_UP_TEMP_IS_ISSUE_DATE_REQURED = "signupTempIsIssueDateRequred";
    public static final String SIGN_UP_TEMP_IS_EXPIRY_DATE_REQURED = "signupTempIsExpiryDateRequred";
    public static final String SIGN_UP_TEMP_ISSUE_DATE = "signUpTempIssueDate";
    public static final String SIGN_UP_TEMP_EXPIRY_DATE = "signUpTempExpiryDate";
    public static final String SIGN_UP_TEMP_ISSUE_COUNTRY_ID = "signUpTempIssueCountryId";
    public static final String SIGN_UP_TEMP_ISSUE_COUNTRY_NAME = "signUpTempIssueCounutryName";
    public static final String SIGN_UP_TEMP_ISSUE_COUNTRY_CODE = "signUpTempIssueCountryCode";
    public static final String SIGN_UP_TEMP_RANDOM_NUMBER = "signUpTempRandomNumber";
    public static final String SIGN_UP_TEMP_IS_KYC_COMPLETED = "signUpTempIsKycCompleted";
    public static final String SIGN_UP_TEMP_ISSUE_DATE_FOR_SET = "signUpTempIssueDateForSet";
    public static final String SIGN_UP_TEMP_EXPIRY_DATE_FOR_SET = "signUpTempExpiryDateForSet";
    public static final String CHANGE_PIN_TEMP_ID = "changePinTempId";
    public static final String FORGOT_PIN_TEMP_ID = "forgotPinTempId";
    public static final String SIGN_UP_TEMP_DOC_FRONT_IMAGE = "SignUpTempDocFrontImage";
    public static final String SIGN_UP_TEMP_DOC_BACK_IMAGE = "SignUpTempDocBackImage";
    public static final String SIGN_UP_TEMP_FRONT_IMAGE_TEXT_CONTENT = "SignUpTempFrontImageTextContent";
    public static final String SIGN_UP_TEMP_BACK_IMAGE_TEXT_CONTENT = "SignUpTempBackImageTextContent";
    public static final String SIGN_UP_TEMP_DOC_SCAN_DOCUMENT_TYPE = "SignUpTempDocScanDocumentType";
    public static final String SIGN_UP_TEMP_DOC_FACE_IMAGE = "SignUpTempDocFaceImage";

    //User Details
    public static final String USER_IS_PROFILE_SUBMITTED = Constant_Key + "userIsProfileCreated";
    public static final String USER_IS_EMAIL_VERIFIED = Constant_Key + "userIsEmailVerified";
    public static final String USER_IS_PROFILE_ADDRESS_SUBMITTED = Constant_Key + "userIsKycSubmitted";
    public static final String USER_IS_DOCUMENT_DETAIL_SUBMITTED = Constant_Key + "userIsDocumentDetailSubmitted";
    public static final String USER_IS_SCAN_DOCUMENT_SUBMITTED = Constant_Key + "userIsScanDocumentSubmitted";
    public static final String USER_IS_SELFEE_SUBMITTED = Constant_Key + "userIsSelfeeSubmitted";

    public static final String USER_IS_KYC_SUBMITTED = Constant_Key + "userIsKYCCreated";

    //User KYC API Call Completion
    public static final String USER_IS_UPLOADED_REGISTER_PROFILE = Constant_Key + "userIsUploadedRegisterProfile";
    public static final String USER_IS_UPLOADED_KYC_ADDRESS_PROFILE = Constant_Key + "userIsUploadedKYCAddressProfile";
    public static final String USER_IS_UPLOADED_DOCUMENT_DETAIL = Constant_Key + "userIsUploadedDocumentDetail";
    public static final String USER_IS_UPLOADED_SCANNED_DOCUMENT = Constant_Key + "userIsUploadedScannedDocument";
//    public static final String USER_IS_UPLOADED_REGISTER_PROFILE = Constant_Key + "userIs";

    public static final String USER_IS_DOCUMENT_DETAILS_SUBMITTED = Constant_Key + "userIsDocumentDetailsSubmitted";
    public static final String USER_IS_KYC_APPROVED = Constant_Key + "userIsKycApproved";
    public static final String USER_IS_MOOV_APPROVED = Constant_Key + "userIsMoovApproved";
    public static final String USER_IS_DOCUMENT_UPLOADED = Constant_Key + "userIsDocumentUploaded";
    public static final String USER_IS_ALL_UPLOADED = Constant_Key + "userIsAllUploaded";
    public static final String USER_IS_VIDEO_UPLOADED = Constant_Key + "userIsVideoUploaded";
    public static final String USER_IS_VIDEO_APPROVED = Constant_Key + "userIsVideoApproved";
    public static final String USER_IS_PIN_ENABLED = Constant_Key + "userIsPinEnabled";
    public static final String USER_IS_MOBILE_VERIFIED = Constant_Key + "userIsMobileVerified";
    public static final String USER_IS_ACCOUNT_DELETED = Constant_Key + "userIsAccountDeleted";
    public static final String USER_LANGUAGE = "userLanguage";
    public static final String USER_LANGUAGE_TEMP = "userLanguageTemp";
    public static final String USER_TOKEN = "userToken";
    public static final String USER_FIXED_PIN = "userFixedPin";
    public static final String USER_FIXED_PIN_OLD_TEMP = "userFixedPinOldTemp";
    public static final String USER_FIXED_PIN_TEMP = "userFixedPinTemp";
    public static final String USER_FIXED_PIN_TEMP1 = "userFixedPinTemp1";
    public static final String USER_FIXED_PIN_ATTEMPT1_TEMP = "userFixedPinAttempt1Temp";
    public static final String USER_FIXED_PIN_ATTEMPT2_TEMP = "userFixedPinAttempt2Temp2";
    public static final String USER_LOGIN_TRIES = "userLoginTries";
    public static final String USER_KYC_STATUS = "userKycStatus";
    public static final String USER_KYC_AGE_LIMIT = "kycAgeLimit";
    public static final String USER_KYC_FIRST_TIME_LOAD_PENDING_KYC_ACTIVITY = "userKycFirstTimeLoadPendingKycActivity";
    public static final String IS_INFO_PAGE_NOT_ALLOWED = "isInfoPageNotAllowed";

    public static ApiInterface apiInterface = ApiClient.getRetrofit().create(ApiInterface.class);

    public static final String IS_SERVER_MAINTENANCE_ENABLED = "isServerMaintenanceEnabled";
    public static final String APP_VERSION_UPDATE_CHECK = "appVersionUpdateCheck";

    //TIME
    public static final long ONE_DAY_IN_MILLI = 86400000;

    //Invitation
    public static final String INVITATION_ANDROID_PACKAGE = "com.remitap.payzana";
    public static final String INVITATION_IOS_PACKAGE = "com.remitap.payzana";
    public static final String INVITATION_IOS_APP_STORE_ID = "1638073430";
    public static final String INVITATION_LINK = "https://payzana.com/invites/?referralCode=";
    public static final String INVITATION_LINK_REFERRED_BY = "&referredBy=";
    public static final String INVITATION_URI_PREFIX = "https://payzana.page.link/referrals";
//    public static final String INVITATION_URI_PREFIX = "https://remitap.page.link";

//    "https://payzana.com/invites/?referralCode=\(User.referralCode)&referredBy=\(User.FullName)"

//    public static final String INVITATION_ANDROID_PACKAGE = "com.remitap.payzana";
//    public static final String INVITATION_IOS_PACKAGE = "com.remitap.nepal";
//    public static final String INVITATION_IOS_APP_STORE_ID = "1448097454";
//    public static final String INVITATION_LINK = "https://remitap.com/Nepal/?referralCode=";
//    public static final String INVITATION_LINK_REFERRED_BY = "&referredBy=";
//    public static final String INVITATION_URI_PREFIX = "https://remitap.page.link";

    //Push
    public static final String DEVICE_TOKEN = "deviceToken";

    //User
    public static final String USER_ACCESS_TOKEN = "userAccessToken";
    public static final String USER_ACCESS_TOKEN_NEPAL = "userAccessTokenNepal";
    public static final String IS_MERCHANT_LOGGED = "isMerchantLogged";
    public static final String IS_REMICARD_EXIST = "isRemicardExist";
    public static final String USER_DETAILS_MOBILE_NUMBER = "userDetailsMobileNumber";
    public static final String USER_TOTAL_CONTACTS_COUNT = "userTotalContactsCount";
    public static final String USER_CONTACTS = "userContacts";
    public static final String USER_CONTACTS_WITH_NAME = "userContactsWithName";
    public static final String USER_LAST_LANGUAGE_UPDATE_TIME = "userLastLanguageUpdateTime";
    public static final String USER_LAST_LANGUAGE_ID = "userLastLanguageId";
    public static final String IS_SECURITY_DISABLED = "isSecurityDisabled";

    // TransactionType
    public static final String TRANSACTIONTYPE_WALLET_TO_WALLET = "WALLET TO WALLET";
    public static final String TRANSACTIONTYPE_WALLET_TO_INSTANT = "WALLET TO INSTANT";
    public static final String TRANSACTIONTYPE_WALLET_TO_CASH_OUT = "WALLET TO CASH OUT";
    public static final String TRANSACTIONTYPE_WALLET_TO_MOBILENUMBER = "WALLET TO MOBILENUMBER";
    public static final String TRANSACTIONTYPE_BANK_TO_WALLET = "BANK TO WALLET";
    public static final String TRANSACTIONTYPE_CARD_TO_WALLET = "CARD TO WALLET";

    public static final String TRANSACTIONTYPE_WALLET_TO_BANK = "WALLET TO BANK";
    public static final String TRANSACTIONTYPE_WALLET_TO_CASHPICKUP = "WALLET TO CASHPICKUP";
    public static final String TRANSACTIONTYPE_WALLET_TO_UTILITY = "WALLET TO UTILITY";
    public static final String TRANSACTIONTYPE_WALLET_TO_CUSTOMER_BANK = "WALLET TO CUSTOMER BANK";

    //Referral code
    public static final String USER_REFERRAL_CODE = "userReferralCode";
    public static final String USER_REFERRAL_NAME = "userReferralName";
    public static final String IS_REFERRAL_CODE_USED = "isReferralCodeUsed";

    //Info
    public static final String IS_POPUP_KYC_SHOULD_SKIP = "isPopupKycShouldSkip";
    public static final String IS_POPUP_MERCHANT_KYC_SHOULD_SKIP = "isPopupMerchantKycShouldSkip";
    public static final String IS_POPUP_BIOMETRIC_SHOULD_SKIP = "isPopupBiometricShouldSkip";
    public static final String IS_POPUP_PIN_SHOULD_SKIP = "isPopupPinShouldSkip";
    public static final String IS_POPUP_REFER_SHOULD_SKIP = "isPopupReferShouldSkip";

    //Login
    public static final String IS_USER_LOGGED = "isUserLogged";
    public static final String USER_LOGIN_TYPE = "userLoginType";
    public static final String USER_LOGIN_TYPE_PASSWORD = "userLoginTypePassword";
    public static final String USER_LOGIN_TYPE_PIN = "userLoginTypePin";
    public static final String USER_LOGIN_TYPE_BIOMETRICS = "userLoginTypeBiometrics";
    public static final String USER_LOGIN_IS_PIN_ADDED_LOCALLY = "userLoginTypeIsPinAddedLocally";
    public static final String USER_LOGIN_IS_BIOMETRIC_ADDED_LOCALLY = "userLoginTypeIsBiometricAddedLocally";

    //Languages
    public static final String LANGUAGE_ENGLISH = "en";
    public static final String LANGUAGE_ARABIC = "ar";
    public static final String LANGUAGE_CHINESE = "zh";
    public static final String LANGUAGE_DUTCH = "nl";
    public static final String LANGUAGE_FRENCH = "fr";
    public static final String LANGUAGE_GERMAN = "de";
    public static final String LANGUAGE_KOREAN = "ko";
    public static final String LANGUAGE_POLISH = "pl";
    public static final String LANGUAGE_RUSSIAN = "ru";
    public static final String LANGUAGE_SPANISH = "es";
    public static final String LANGUAGE_VIETNAMESE = "vi";
    public static final String LANGUAGE_MALAYALAM = "ml";

    public static final String DEVICE_LANGUAGE = "deviceLanguage";
    public static final String DEVICE_LANGUAGE_POSITION = "deviceLanguagePosition";

    public static final String IS_RTL = "isRtl";



    //
    public static final String MOOV_ID = "MoovId";
    public static final String C_CLOUD_ID = "CCloudId";
    public static final String CC_CONTACT_ID = "CCContactID";

    //DB RESPONSES
    public static final String RESPONSE_COUNTRIES = "responseCountries";
    public static final String RESPONSE_DROPDOWN = "";

    //Temp
    public static final String SIGN_UP_BUSINESS_PDF = "signUpBusinessPdf";
    public static final String SIGN_UP_BUSINESS_PDF_TEXT = "signUpBusinessPdfText";
    public static final String TEMP_LOG_IN_TEMP_ID = "tempLogInTempID";
    public static final String TEMP_EMAIL_ID_OTP_TEMP_ID = "tempeMailIdOtpTempId";
    public static final String TEMP_OTP_SENT_SO_FAR = "tempOtpSentSoFar";
    public static final String TEMP_OTP_MAXIMUM_RESEND = "tempOtpMaximumResend";

    public static final String SIGN_UP_MOBILE_NUMBER = "signUpMobileNumber";
    public static final String SIGN_UP_ADDRESS_CITY = "signUpAddressCity";
    public static final String SIGN_UP_IS_IMAGE_FOUND = "signUpIsImageFound";

    public static final String TAMP_ADD_DOB = "tempDob";
    public static final String TAMP_ADD_AMOUNT = "tempAddAmount";

    //From Page PinChange
    public static final String FROM_PAGE_PIN_CHANGE_OLD_PIN = "fromPagePinChangeOldPin";
    public static final String FROM_PAGE_PIN_CHANGE_NEW_PIN = "fromPagePinChangeNewPin";
    public static final String FROM_PAGE_PIN_CHANGE_CONFIRM_NEW_PIN = "fromPagePinChangeConfirmNewPin";

    //From Page ForgotPin
    public static final String FROM_PAGE_FORGOTPIN_NEW_PIN = "fromPageForgotpinNewPin";
    public static final String FROM_PAGE_FORGOTPIN_CONFIRM_NEW_PIN = "fromPageForgotpinConfirmNewPin";

    public static final String FROM_PAGE_UPDATE_EMAIL = "fromPageUpdateEmail";
    public static final String FROM_PAGE_EDIT_MOBILE = "fromPageEditMobile";
    public static final String FROM_PAGE_PROFILE_FRAGMENT = "fromPageProfileFragment";
    public static final String FROM_PAGE_MANAGE_ACCOUNT_FRAGMENT = "fromPageManageAccountFragment";

    public static final String FROM_PAGE_PROFILE_MOBILE_UPDATE_INITIAL_FRAGMENT = "fromPageProfileMobileUpdateInitialFragment";
    public static final String FROM_PAGE_PROFILE_MOBILE_FRAGMENT_INITIAL_PAGE = "fromPageProfileMobileFragmentInitialPage";
    public static final String FROM_PAGE_PROFILE_MOBILE_FRAGMENT_EDIT_PAGE = "fromPageProfileMobileFragmentEditPage";

    public static final String FROM_PAGE_ADD_NEW_EMAIL_UPDATE_INITIAL_FRAGMENT = "fromPageAddNewEmailUpdateInitialFragment";
    public static final String FROM_PAGE_ADD_NEW_EMAIL_FRAGMENT_INITIAL_PAGE = "fromPageAddNewEmailFragmentInitialPage";
    public static final String FROM_PAGE_ADD_NEW_EMAIL_FRAGMENT_EDIT_PAGE = "fromPageAddNewEmailFragmentEditPage";


    //Amount
    public static final String AMOUNT_DEBIT = "Debit";
    public static final String AMOUNT_CREDIT = "Credit";

    //Responses
    public static final String RESPONSE_USER_DETAILS = "userDetails";
    public static final String RESPONSE_USER_BANK_ACCOUNTS = "userBankAccounts";
    public static final String RESPONSE_USER_RECIPIENTS = "userRecipients";
    public static final String RESPONSE_PURPOSE = "purpose";
    public static final String RESPONSE_CREATE_CONVERSION = "createConversion";
    public static final String RESPONSE_DISPLAY_COUNTRIES = "displayCountries";

    public static final String RESPONSE_MERCHANT_BANK_ACCOUNTS = "merchantBankAccounts";
    public static final String RESPONSE_RECENT_WALLET_TO_WALLET_USERS = "recentWalletToWalletUsers";
    public static final String RESPONSE_RECENT_PAYZANA_CASH_USERS = "recentPayzanaCashUsers";
    public static final String RESPONSE_CONTACTS = "responseContacts";
    public static final String RESPONSE_RECENT_WALLET_TO_BANK_USERS = "recentWalletToBankUsers";
    public static final String RESPONSE_RECENT_WALLET_TO_BANK_MERCHANT = "recentWalletToBankMerchant";
    public static final String RESPONSE_RECENT_WALLET_TO_CASH_PICK_UP_USERS = "recentWalletToCashPickUpUsers";
    public static final String RESPONSE_LAST_CREATED_REMICARD = "lastCreatedRemiCard";
    public static final String RESPONSE_UNUSED_REMICARDS = "unusedRemiCards";
    public static final String RESPONSE_INUSED_REMICARDS = "inUsedRemiCards";
    public static final String RESPONSE_USED_REMICARDS = "usedRemiCards";
    public static final String RESPONSE_BANNERS_CUSTOMER = "bannersCustomer";
    public static final String RESPONSE_BANNERS_MERCHANT = "bannersMerchant";
    public static final String RESPONSE_LIST_OF_UTILITIES_USER = "listOfUtilitiesUser";
    public static final String RESPONSE_LIST_OF_REWARDS = "listOfRewards";
    public static final String RESPONSE_SELF_TRANSFER_TEMP = "selfTransferTemp";
    public static final String RESPONSE_RECIPIENT_DETAILS = "recipientDetails";
    public static final String RESPONSE_LAST_SELECTED_UTILITY = "responseLastSelectedUtility";


    //Back button
    public static final String BACK_TO_ADD_MONEY = "backToAddMoney";
    public static final String BACK_TO_MY_ACCOUNTS = "backToMyAccounts";
    public static final String BACK_TO_PAYMENT_SERVICES = "backToPaymentServices";
    public static final String BACK_TO_ACCOUNT_DETAILS = "backToAccountDetails";
    public static final String BACK_TO_SEND_MONEY = "backToSendMoney";
    public static final String BACK_TO_SEND_MONEY_BANK = "backToSendMoneyBank";
    public static final String BACK_TO_SEND_MONEY_CASH_PICK_UP = "backToSendMoneyCashPickUp";
    public static final String BACK_TO_CREATE_CARDS = "backToCreateCards";
    public static final String BACK_TO_SCAN_CARDS = "backToScanCards";
    public static final String BACK_TO_MY_CARDS_INSTANCE = "backToMyCardsInstance";
    public static final String BACK_TO_MY_CARDS_DETAILS = "backToMyCardsDetails";

    public static final String BACK_TO_UTILITIES_LIST = "backToUtilitiesList";
    public static final String BACK_TO_UTILITIES_DETAILS_MAIN = "backToUtilitiesDetailsMain";
    public static final String BACK_TO_UTILITIES_PROVIDERS = "backToUtilitiesProviders";
    public static final String BACK_TO_UTILITIES_BILLERS = "backToUtilitiesBillers";

    public static final String BACK_TO_REPORTS_LIST = "backToReportsList";
    public static final String BACK_TO_TRANSACTION_DETAILS = "backToTransactionDetails";
    public static final String BACK_TO_CANCEL_REASON = "backToCancelReason";
    public static final String BACK_TO_CONTACTS_LIST_HOME = "backToContactsListHome";
    public static final String BACK_TO_SEND_MONEY_INTERNATIONAL_COUNTRY = "backToSendMoneyInternationalCountry";
    public static final String BACK_TO_SEND_MONEY_MAIN_HOME = "backToSendMoneyMainHome";

    //Language
    public static final String LANGUAGE_VERSION = "1";

    //Timer
    public static final int TIMER_TIME = 60;
    public static final int TIMER_COUNTDOWN_TIMER = 60002;
    public static final int API_OPENING_DELAY = 500;
    public static final int CIRCULAR_REVEL_DELAY_LOGIN = 600;


    //Country Code
//    public static final String COUNTRY_CODE = "+1";
    public static final String COUNTRY_CODE = "+267";

    //Remicard NFC constant
    public static final String NFC_REMICARD_IDENTIFICATION = "977RCNP";
    public static final String NFC_REMICARD_IDENTIFICATION_NEPAL = "977RCNP";
    public static final String NFC_REMICARD_IDENTIFICATION_SRILANKA = "94RCSL";
    public static final String NFC_REMICARD_IDENTIFICATION_BOTSWANA = "267RCBW";
    public static final String NFC_REMICARD_IDENTIFICATION_INDIA = "91RCIN";
    public static final String NFC_REMICARD_IDENTIFICATION_BUYSAFE = "1BCBS";
    public static final String NFC_REMICARD_IDENTIFICATION_BENGLADESH = "880RCBG";

    //Constant Keys
    public static final String KEY_INDIVIDUAL = "Individual";
    public static final String KEY_ANDROID = "Android";
    public static final String KEY_GRAND_TYPE_PASSWORD = "Password";
    public static final String KEY_LOGIN_TYPE_BIOMETRIC = "Biometric";
    public static final String KEY_LOGIN_TYPE_PIN = "Fixed Pin";
    public static final String USER_TYPE_CUSTOMER = "Customer";
    public static final String USER_TYPE_INDIVIDUAL = "Individual";
    public static final String USER_TYPE_MERCHANT = "Merchant";
    public static final String TOUCH_ID = "Touch ID";

    //Transaction States
    public static final String TRANSACTION_SUCCESS = "success";
    public static final String TRANSACTION_PROCESSING = "processing";
    public static final String TRANSACTION_FAILED = "failed";

    //Biometric
    public static final String BIOMETRIC_ADD = "Add Biometric";

    //App Preference
    public static final String REFRESH_TOKEN = "refreshToken";
    public static final String LATITUDE = "Latitude";
    public static final String LONGITUDE = "Longitude";

    //Resend OTP
    public static final String RESEND_OTP_REGISTRATION = "Registration";
    public static final String RESEND_OTP_CREATE_REMICARD = "Remicard";
    public static final String RESEND_OTP_REMICARD_RETRIEVAL = "Web Card Retrieval";
    public static final String RESEND_OTP_PIN = "Pin";
    public static final String RESEND_OTP_BIOMETRIC = "Biometric";
    public static final String RESEND_OTP_PASSWORD = "password";
    public static final String RESEND_OTP_LOAD_REMICARD = "Load Remicard";
    //    public static final String RESEND_OTP_REMICARD_PAYMENT = "RemiCardPayment";
    public static final String RESEND_OTP_REMICARD_PAYMENT = "Web Card Payment";
    public static final String RESEND_OTP_WALLET_TO_WALLET = "Wallet To Wallet";
    public static final String RESEND_OTP_BANK_TO_WALLET_MBL = "BANK TO WALLET MBL";
    public static final String RESEND_OTP_BANK_TO_WALLET_MBL_MERCHANT = "BANK TO WALLET MBL MERCHANT";
    public static final String RESEND_OTP_WALLET_TO_BANK = "Wallet To Bank";
    public static final String RESEND_OTP_WALLET_TO_CASH_PICK_UP = "Wallet To CashPickUp";
    public static final String RESEND_OTP_WALLET_TO_CUSTOMER_BANK = "Wallet To Customer Bank";
    public static final String RESEND_OTP_WALLET_TO_MERCHANT_BANK = "Wallet To Merchant Bank";
    public static final String RESEND_OTP_WALLET_TO_WALLET_INSTANT = "InstantPayWithQR";
    public static final String RESEND_OTP_CUSTOMER_BENEFICIARY = "Customer Beneficiary";
    public static final String RESEND_OTP_MERCHANT_BENEFICIARY = "Merchant Beneficiary";
    public static final String RESEND_OTP_UPDATE_EMAIL = "UpdateEmail";
    public static final String RESEND_OTP_EDIT_MOBILE = "EditMobile";



    //Log
    public static final String LOG_REMITAP_FLOW = "logRemitapFlow";

    //Popup Types
    public static final String POPUP_WARING = "popupWarning";
    public static final String POPUP_ERROR = "popupError";
    public static final String POPUP_SUCCESS = "popupSuccess";
    public static final String POPUP_VPN = "popupVpn";
    public static final String POPUP_INTERNET = "popupInternet";
    public static final String POPUP_SESSION_TIMEOUT = "popupSessionTimeout";
    public static final String POPUP_NOSOUND = "popupNoSound";

    //Sound
    public static final String SOUND_ALERT = "soundAlert";
    public static final String SOUND_ALERT_OPTION = "soundAlertOption";
    public static final String SOUND_NOTIFICATION = "soundNotification";
    public static final String SOUND_REMICARD_SUCCESS = "soundRemicardSuccess";
    public static final String SOUND_REQUEST_QR = "soundRequestQR";
    public static final String SOUND_TOGGLE_ACTION = "soundToggleAction";
    public static final String SOUND_TOGGLE_CLOSE = "soundToggleClose";
    public static final String SOUND_TOGGLE_OPEN = "soundToggleOpen";
    public static final String SOUND_TRANSACTION_SUCCESSFUL = "soundTransactionSuccessful";
    public static final String SOUND_REWARD = "soundReward";
    public static final String SOUND_REWARD_POP = "soundRewardPop";

    //Webview
    public static final String WEB_VIEW_TYPE = "webViewType";
    public static final String WEB_VIEW_TYPE_PRIVACY_POLICY = "webViewTypePrivacyPolicy";
    public static final String WEB_VIEW_TYPE_TERMS_AND_CONDITIONS = "webViewTypeTermsAndConditions";
    public static final String WEB_VIEW_TYPE_TERMS_AND_CONDITIONS_REFER = "webViewTypeTermsAndConditionsRefer";
    public static final String WEB_VIEW_TYPE_TERMS_AND_CONDITIONS_FOOTBALL = "webViewTypeTermsAndConditionsFottball";
    public static final String WEB_VIEW_TYPE_FAQ = "webViewTypeFAQ";
    public static final String WEB_VIEW_TYPE_CONTACT_SUPPORT = "webViewTypeContactSupport";

    //Colors
    public static final String COLOR_WHITE = "colorWhite";
    public static final String COLOR_BLACK = "colorBlack";

    //Backend keys
    public static final String TRUE = "true";
    public static final String FALSE = "false";
    public static final String YES = "Yes";
    public static final String NO = "no";
    public static final String GENDER_MALE = "male";
    public static final String GENDER_FEMALE = "female";
    public static final String READ = "Read";

    //Kyc Status
    public static final String KYC_APPROVED = "approved";
    public static final String KYC_VERIFIED = "verified";
    public static final String KYC_REJECTED = "rejected";
    public static final String KYC_PENDING = "pending";
    public static final String KYC_SUSPECT = "suspect";
    public static final String KYC_NOT_SUBMITTED = "kyc not submitted";
    public static final String KYC_EXPIRED = "expired";

    //Payment mode
    public static final String PAYMENT_MODE_BANK_TO_WALLET_MBL = "BANK TO WALLET MBL";
    public static final String PAYMENT_MODE_BANK_TO_WALLET_MBL_MERCHANT = "BANK TO WALLET MBL MERCHANT";
    public static final String PAYMENT_MODE_BANK_TO_WALLET_OTHER = "Bank To wallet";

    //OTP Fragment fromPage
    public static final String OTP_PAGE_ADD_MONEY_FROM_CARD = "otpPageAddMoneyFromCard";
    public static final String OTP_PAGE_ADD_MONEY_FROM_MBL = "otpPageAddMoneyFromMbl";
    public static final String OTP_PAGE_ADD_PAYZANA_CASH_CONNECTION = "otpPageAddPayzanaCashConnection";
    public static final String OTP_PAGE_SENT_MONEY_TO_OWN_BANK_ACCOUNT = "otpPageSentMoneyToOwnBankAccount";
    public static final String OTP_PAGE_SENT_MONEY_TO_WALLET = "otpPageSentMoneyToWallet";
    public static final String OTP_PAGE_WALLET_TO_CASH_OUT = "otpPageWalletToCashOut";
    public static final String OTP_PAGE_SENT_MONEY_WALLET_TOP_UP = "otpPageSentMoneyWalletTopUp";
    public static final String OTP_PAGE_SENT_MONEY_TO_BANK_BENEFICIARY = "otpPageSentMoneyToBankBeneficiary";
    public static final String OTP_PAGE_SENT_MONEY_FOR_CASH_PICK_UP = "otpPageSentMoneyForCashPickUp";
    public static final String OTP_PAGE_INSTANT_PAY = "otpPageInstantPay";
    public static final String OTP_PAGE_CREATE_REMICARD = "otpPageCreateRemiCard";
    public static final String OTP_PAGE_INSTANT_PAY_REMICARD = "otpPageInstantPayRemiCard";
    public static final String OTP_PAGE_INSTANT_PAY_REMICARD_HOME = "otpPageInstantPayRemiCardHome";
    public static final String OTP_PAGE_REDEEM_REMICARD = "otpPageRedeemRemiCard";
    public static final String OTP_PAGE_UTILITY_PAYMENT = "otpPageUtilityPayment";
    public static final String OTP_PAGE_QUICK_ACCESS_PIN = "otpPageQuickAccessPin";
    public static final String OTP_PAGE_BIOMETRIC = "otpPageBiometric";
    public static final String OTP_PAGE_CHANGE_PASSWORD = "otpPageChangePassword";
    public static final String OTP_PAGE_TOP_UP_REMICARD = "otpPageTopUpRemicard";
    public static final String OTP_PAGE_ADD_BANK_ACCOUNT_SELF = "otpPageAddBankAccountSelf";
    public static final String OTP_PAGE_ADD_BANK_ACCOUNT_MERCHANT_SELF = "otpPageAddBankAccountMerchantSelf";
    public static final String OTP_PAGE_UPDATE_EMAIL = "UpdateEmail";
    public static final String OTP_PAGE_EDIT_MOBILE = "EditMobile";


    //PIN Fragment fromPage
    public static final String PIN_PAGE_CANCEL_OTHER = "pinPageCancelOther";
    public static final String PIN_INTERNATIONAL_CARD_PAY = "pinCvvFragmentPage";
    public static final String PIN_INTERNATIONAL_WALLET_PAY = "pinInternationalWalletPay";
    public static final String PIN_INSTANT_PAY = "pinInstantPay";
    public static final String PIN_WALLET_PAY = "pinWalletPay";
    public static final String PIN_WALLET_MOBILENUMBER = "Wallet To MobileNumber";
    public static final String PIN_WALLET_TO_CASH_OUT = "WalletToCashOut";


    //Fragment or Activity Names
    public static final String ACTIVITY_HOME = "activityHome";
    public static final String FRAGMENT_MY_WALLET = "fragmentMyWallet";
    public static final String FRAGMENT_ADD_MONEY = "fragmentAddMoney";
    public static final String FRAGMENT_MY_ACCOUNTS = "fragmentMyAccounts";
    public static final String FRAGMENT_SEND_MONEY = "fragmentSendMoney";
    public static final String FRAGMENT_SEND_MONEY_WALLET_NEW_CONTACT = "fragmentSendMoneyWalletNewContact";
    public static final String FRAGMENT_VIRTUAL_CARDS = "fragmentVirtualCards";
    public static final String FRAGMENT_VERIFY_OTP_FRAGMENT = "VerifyOtpFragment";
    public static final String FRAGMENT_RECIPIENTS_HOME = "RecipientsHomeFragment";
    public static final String FRAGMENT_SEND_MONEY_HOME_NEW = "SendMoneyHomeNewFragment";



    public static final String ACTIVITY = "activity";
    public static final String FRAGMENT = "fragment";

    public static final String TEMP_DETAILS_AMOUNT = "TEMP_DETAILS_AMOUNT";
    public static final String TEMP_DETAILS_PAYMENT_MODE = "TEMP_DETAILS_PAYMENT_MODE";
    public static final String TEMP_DETAILS_BANK_QR = "TEMP_DETAILS_BANK_QR";
    public static final String TEMP_DETAILS_REFERENCE_ID = "TEMP_DETAILS_REFERENCE_ID";
    public static final String TEMP_DETAILS_UTILITY_TYPE = "TEMP_DETAILS_UTILITY_TYPE";
    public static final String TEMP_DETAILS_UTILITY_REFERENCE_ID = "TEMP_DETAILS_UTILITY_REFERENCE_ID";

    //Intent keys
    public static final String INTENT_ACCOUNT_DETAILS = "intentAccountDetails";
    public static final String INTENT_FROM_PAGE = "intentFromPage";
    public static final String INTENT_ADDRESS_DETAILS = "intentAddressDetails";
    public static final String INTENT_DOCUMENT_DETAILS = "intentDocumentDetails";
    public static final String INTENT_DOCUMENT_ID = "intentDocumentId";

    public static final String INTENT_ADDRESS1 = "intentAddress1";
    public static final String INTENT_ADDRESS2 = "intentAddress2";
    public static final String INTENT_CITY = "intentCity";
    public static final String INTENT_STATE = "intentState";
    public static final String INTENT_ZIP = "intentZip";
    public static final String INTENT_EMAIL = "intentEmail";
    public static final String INTENT_COUNTRY_CODE = "intentCountryCode";
    public static final String INTENT_IMAGE_FRONT = "intentImageFront";
    public static final String INTENT_IMAGE_BACK = "intentImageBack";

    public static final String INTENT_AMOUNT = "intentAmount";

    public static final String INTENT_REWARDS_DATA = "intentRewardsData";
    public static final String INTENT_REWARDS_POSITION = "intentRewardsPosition";

    public static final String INTENT_IS_SCRATCH_CARD_EXIST = "intentIsScratchCardExist";
    public static final String INTENT_SCRATCH_CARD_AMOUNT = "intentScratchCardAmount";
    public static final String INTENT_SCRATCH_REFERENCE_ID = "intentScratchReferenceId";
    public static final String INTENT_CASH_BACK = "intentCashBack";

    //Transfer Types
    public static final String TRANSFER_TYPE_WALLET_TO_CUSTOMER_BANK = "Wallet To Customer Bank";
    public static final String TRANSFER_TYPE_WALLET_TO_MERCHANT_BANK = "Wallet To Merchant Bank";
    public static final String TRANSFER_TYPE_WALLET_TO_WALLET = "Wallet To Wallet";
    public static final String TRANSFER_TYPE_WALLET_TO_MOBILE = "Wallet To MobileNumber";
    public static final String TRANSFER_TYPE_WALLET_TO_BANK = "Wallet To Bank";
    public static final String TRANSFER_TYPE_WALLET_TO_CASH_PICK_UP = "Wallet To CashPickUp";
    public static final String TRANSFER_TYPE_WALLET_TO_UTILITY = "Wallet To Utility";
    public static final String TRANSFER_TYPE_WALLET_TO_CASH_OUT = "Wallet To Cash Out";
    //Wallet To Cash Out


    //    //Reward Types Backend
    public static final String REWARD_TYPE_SCRATCH_CARD = "scratchreward";
    public static final String REWARD_TYPE_CASH_BACK = "cashbackreward";
    public static final String REWARD_TYPE_GIFT_CARD = "giftreward";
    public static final String REWARD_TYPE_REFERRAL_REWARD = "referralreward";
    public static final String REWARD_TYPE_COUPON_REWARD = "couponreward";
    public static final String REWARD_TYPE_OTHER_REWARD = "otherreward";
//TOdo - Delete
    //Reward Types Backend
//    public static final String REWARD_TYPE_SCRATCH_CARD = "scratchcard";
//    public static final String REWARD_TYPE_CASH_BACK = "cashbackreward";
//    public static final String REWARD_TYPE_GIFT_CARD = "giftcard";
//    public static final String REWARD_TYPE_REFERRAL_REWARD = "referralcard";
//    public static final String REWARD_TYPE_COUPON_REWARD = "couponreward";
//    public static final String REWARD_TYPE_OTHER_REWARD = "otherreward";

    //Reward Types
    public static final String REWARD_CASH_BACK = "rewardCashBack";
    public static final String REWARD_SCRATCH_CARD = "rewardScratchCard";


    // The constant FRAGMENT_OTHER_OPTIONS_FRAGMENT.
    public static final String FRAGMENT_OTHER_OPTIONS_FRAGMENT = "otherOptionsFragment";

    //Beneficiary Types
    public static final String BENEFICIARY_TYPE_BANK = "Bank";
    public static final String BENEFICIARY_TYPE_CASH_PICK_UP = "cashpickup";

    //QR Mode
    public static final String QR_MODE_REMICARD = "RemiCard";
    public static final String QR_MODE_CUSTOMER = "Customer";
    public static final String QR_MODE_MERCHANT = "Merchant";
    public static final String QR_MODE_INSTANT = "Instant";
    public static final String QR_MODE_COUNTER = "Counter";

    //RemiCard
    public static final String REMICARD_AUTHORITY_SELF = "Self";
    public static final String REMICARD_AUTHORITY_OTHERS = "Other";

    //RemiCard Types
    public static final String REMICARD_TYPE_UNUSED = "Unused";
    public static final String REMICARD_TYPE_INUSE = "Inuse";
    public static final String REMICARD_TYPE_USED = "Used";
    public static final String REMICARD_TYPE_ALL = "All";

    //Transaction Types
    public static final String TRANSACTION_TYPE_NEW_INTERNATIONAL_TRANSFER = "International Transfer";
    public static final String TRANSACTION_TYPE_WALLET_TO_WALLET = "wallet to wallet";
    public static final String TRANSACTION_TYPE_WALLET_TO_BANK = "wallet to bank";
    public static final String TRANSACTION_TYPE_WALLET_TO_INSTANT = "wallet to instant";
    public static final String TRANSACTION_TYPE_BANK_TO_WALLET = "bank to wallet";
    public static final String TRANSACTION_TYPE_BANK_TO_WALLET_MBL = "bank to wallet mbl";
    public static final String TRANSACTION_TYPE_WALLET_TO_CASH_PICKUP = "wallet to cash pickup";
    public static final String TRANSACTION_TYPE_WALLET_TO_REMICARD = "wallet to remicard";
    public static final String TRANSACTION_TYPE_CARD_TO_WALLET = "card to wallet";
    public static final String TRANSACTION_TYPE_LOAD_REMICARD = "load remicard";
    public static final String TRANSACTION_TYPE_CARD_RETRIEVAL = "card retrieval";
    public static final String TRANSACTION_TYPE_CARD_REDEEM = "redeemCard";
    public static final String TRANSACTION_TYPE_CARD_RECALL = "card recall";
    public static final String TRANSACTION_TYPE_WALLET_TO_UTILITIES = "wallet to utilities";
    public static final String TRANSACTION_TYPE_WALLET_TO_UTILITY = "wallet to utility";
    public static final String TRANSACTION_TYPE_NEW_CARD_TO_WALLET = "Card To Wallet";
    public static final String PAYMENT_MODE_CREDIT_CARD = "Credit Card";


    //"transactionType":"Card To Wallet"//Card To Wallet, International Transfer

    public static final String TRANSACTION_TYPE_WALLET_TOP_UP = "Wallet TopUp";
    public static final String TRANSACTION_TYPE_WALLET_TO_MERCHANT_BANK = "Wallet to Merchant Bank";
    public static final String TRANSACTION_TYPE_WALLET_TO_UTILITIES_MERCHANT = "Wallet to Utilities";

    // Side men fragments
    public static final String FRAGMENT_MANAGE_ACCOUNT_DETAILS = "ManageAccountDetailsFragment";
    public static final String FRAGMENT_MANAGE_DATA = "ManageDataFragment";
    public static final String FRAGMENT_CHANGE_LANGUAGE = "ChangeLanguageFragment";
    public static final String FRAGMENT_CHANGE_EMAIL = "ChangeEmailFragment";
    public static final String FRAGMENT_CHANGE_MOBILE = "ChangeMobileFragment";


    public static final String FRAGMENT_SUPPORT_DETAILS = "SupportDetailsFragment";
    public static final String FRAGMENT_WEB_VIEW_FAQ = "WebViewSmallFragmentFaq";
    public static final String FRAGMENT_WEB_VIEW_TERMS = "WebViewSmallFragmentTerms";
    public static final String FRAGMENT_WEB_VIEW_PRIVACY = "WebViewSmallFragmentPrivacy";
    public static final String FRAGMENT_ABOUT_DETAILS = "AboutDetailsFragment";



    // Security Setting
    public static final String FRAGMENT_SECURITY_SETTINGS_HOME = "SecuritySettingsHomeFragment";
    public static final String FRAGMENT_CHANGEPIN_OLD_PIN = "ChangePinOldPinFragment";
    public static final String FRAGMENT_CHANGEPIN_NEW_PIN = "ChangePinNewPinFragment";
    public static final String FRAGMENT_CHANGEPIN_NEW_PIN_CONFIRM = "ChangePinNewPinConfirmFragment";
    public static final String FRAGMENT_CHANGEPIN_VERIFY_OTP = "ChangePinVerifyOtpFragment";

    public static final String FRAGMENT_FORGOTPIN_INITIAL = "ForgotPinInitialFragment";
    public static final String FRAGMENT_FORGOTPIN_VERIFY_OTP = "ForgotPinVerifyOtpFragment";
    public static final String FRAGMENT_FORGOTPIN_NEW_PIN = "ForgotPinNewPinFragment";
    public static final String FRAGMENT_FORGOTPIN_NEW_PIN_CONFIRM = "ForgotPinNewPinConfirmFragment";

    public static final String FRAGMENT_SUCCESSFULL_PIN_CHANGED = "SuccessfullPinChangedFragment";

    public static final String FRAGMENT_VERIFY_OTP = "VerifyOtpFragment";
    public static final String FRAGMENT_FORGOT_PIN = "ForgotPinFragment";

    public static final String REWARDS_CASHBACK = "RewardsCashback";
    public static final String REWARDS_VOUCHER = "RewardsVoucher";
    public static final String REWARDS_REMICOIN = "RewardsRemicon";

    public static final String REFERAL_STATUS_JOINED = "Joined";
    public static final String REFERAL_STATUS_JOINED_TEXT = "Joined, KYC not done yet";
    public static final String REFERAL_STATUS_TRANSACTION_PENDING = "Transaction Pending";
    public static final String REFERAL_STATUS_TRANSACTION_PENDING_TEXT = "KYC done, no transactions yet";
    public static final String REFERAL_STATUS_REWARD_RECEIVE = "Reward Received";
    public static final String REFERAL_STATUS_REWARD_RECEIVE_TEXT = "Rewarded for successful referral";

    //  Transaction Type
    public static final String TRANSACTIONTYPE_NAME_WALLET_TO_WALLET  = "WALLET TO WALLET";      // Wallet Transfer
    public static final String TRANSACTIONTYPE_NAME_WALLET_TO_BANK  = "WALLET TO BANK";      // Bank Transfer
    public static final String TRANSACTIONTYPE_NAME_WALLET_TO_CASHPICKUP  = "WALLET TO CASHPICKUP";      // Cash Pickup
    public static final String TRANSACTIONTYPE_NAME_WALLET_TO_INSTANT  = "WALLET TO INSTANT";   // QR Code Transfer
    public static final String TRANSACTIONTYPE_NAME_WALLET_TO_UTILITY  = "WALLET TO UTILITY";   // Utility Payment
    public static final String TRANSACTIONTYPE_NAME_WALLET_TO_CUSTOMER  = "WALLET TO CUSTOMER BANK";    // Bank Withdrawal
    public static final String TRANSACTIONTYPE_NAME_WALLET_TO_CASHOUT  = "WALLET TO CASH OUT";      // In-Store Cash Withdrawal
    public static final String TRANSACTIONTYPE_NAME_WALLET_TO_MOBILENUMBER  = "WALLET TO MOBILENUMBER";     // Mobile Number Transfer
    public static final String TRANSACTIONTYPE_NAME_CUSTOMER_TO_MERCHANT_QR_CASH  = "CUSTOMER TO MERCHANT QR CASH";     // Store Payment (QR)
    public static final String TRANSACTIONTYPE_NAME_CUSTOMER_TO_MERCHANT_MOBNO_CASH  = "CUSTOMER TO MERCHANT MOBNO CASH";   //Store Payment (Mobile)
    public static final String TRANSACTIONTYPE_NAME_INTERNATIONAL_TRANSFER  = "INTERNATIONAL TRANSFER";     //International Transfer
    public static final String TRANSACTIONTYPE_NAME_MERCHANT_TO_WALLET  = "MERCHANT TO WALLET";     // Cash Top-Up at Store
    public static final String TRANSACTIONTYPE_NAME_MOBILENO_TO_MERCHANT  = "MOBILENO TO MERCHANT";     // Store Payment (Mobile)
    public static final String TRANSACTIONTYPE_NAME_WALLET_TO_REMICARD  = "WALLET TO REMICARD";
    public static final String TRANSACTIONTYPE_NAME_REMICARD_RETRIEVAL  = "REMICARD RETRIEVAL";
    public static final String TRANSACTIONTYPE_NAME_REMICARD_REDEEM  = "REMICARD REDEEM";
    public static final String TRANSACTIONTYPE_NAME_REMICARD_TO_WALLET  = "REMICARD TO WALLET";
    public static final String TRANSACTIONTYPE_NAME_BANK_TO_WALLET  = "BANK TO WALLET";
    public static final String TRANSACTIONTYPE_NAME_BANK_TO_WALLET_MBL  = "BANK TO WALLET MBL";
    public static final String TRANSACTIONTYPE_NAME_CARD_TO_WALLET  = "CARD TO WALLET";
    public static final String TRANSACTIONTYPE_NAME_LOADREMICARD  = "LOADREMICARD";
    public static final String TRANSACTIONTYPE_NAME_LOAD_REMICARD  = "LOAD REMICARD";


    // Transaction Type Alias
    public static final String ALIAS_TRANSACTIONTYPE_NAME_WALLET_TO_WALLET  = "Wallet Transfer";      // Wallet To Wallet
    public static final String ALIAS_TRANSACTIONTYPE_NAME_WALLET_TO_BANK  = "Bank Transfer";      // Wallet To Bank
    public static final String ALIAS_TRANSACTIONTYPE_NAME_WALLET_TO_CASHPICKUP  = "Cash Pickup";      // Wallet To CashPickUp
    public static final String ALIAS_TRANSACTIONTYPE_NAME_WALLET_TO_INSTANT  = "QR Code Transfer";   // Wallet To Instant
    public static final String ALIAS_TRANSACTIONTYPE_NAME_WALLET_TO_UTILITY  = "Utility Payment";   // Wallet To Utility
    public static final String ALIAS_TRANSACTIONTYPE_NAME_WALLET_TO_CUSTOMER  = "Bank Withdrawal";    // Wallet To Customer Bank
    public static final String ALIAS_TRANSACTIONTYPE_NAME_WALLET_TO_CASHOUT  = "In-Store Cash Withdrawal";      // Wallet To Cash Out
    public static final String ALIAS_TRANSACTIONTYPE_NAME_WALLET_TO_MOBILENUMBER  = "Mobile Number Transfer";     // Wallet To MobileNumber
    public static final String ALIAS_TRANSACTIONTYPE_NAME_CUSTOMER_TO_MERCHANT_QR_CASH  = "Store Payment (QR)";     //  Customer To Merchant QR Cash
    public static final String ALIAS_TRANSACTIONTYPE_NAME_CUSTOMER_TO_MERCHANT_MOBNO_CASH  = "Store Payment (Mobile)";   // Customer To Merchant MobNo Cash
    public static final String ALIAS_TRANSACTIONTYPE_NAME_INTERNATIONAL_TRANSFER  = "International Transfer";     // International Transfer
    public static final String ALIAS_TRANSACTIONTYPE_NAME_MERCHANT_TO_WALLET  = "Cash Top-Up at Store";     // Merchant to Wallet
    public static final String ALIAS_TRANSACTIONTYPE_NAME_MOBILENO_TO_MERCHANT  = "Store Payment (Mobile)";     // MobileNo To Merchant

    public static final int ZERO = 0;
    public static final int ONE = 1;
    public static final int TWO = 2;
    public static final int THREE = 3;
    public static final int FOUR = 4;
    public static final int FIVE = 5;
    public static final int SIX = 6;
    public static final int SEVEN = 7;
    public static final int EIGHT = 8;
    public static final int NINE = 9;
    public static final int TEN = 10;
    public static final int TWELVE = 12;
    public static final int THIRTEEN = 13;
    public static final int FIFTEEN = 15;
    public static final int TWENTY = 20;
    public static final int THIRTY = 30;
    public static final int FOURTY = 40;
    public static final int FOURTY_TWO = 42;
    public static final int FIFTY = 50;
    public static final int SIXTY = 60;
    public static final int SEVENTY = 70;
    public static final int EIGHTY = 80;
    public static final int NINTY = 90;
    public static final int HUNDRED = 100;
    public static final int TWO_HUNDRED = 200;
    public static final int THREE_HUNDRED = 300;
    public static final int THREE_HUNDRED_FIFTY = 350;
    public static final int FOUR_HUNDRED = 400;
    public static final int FOUR_HUNDRED_ONE = 401;
    public static final int FIVE_HUNDRED = 500;
    public static final int SIX_HUNDRED = 600;
    public static final int SEVEN_HUNDRED = 700;
    public static final int EIGHT_HUNDRED = 800;
    public static final int NINE_HUNDRED = 900;
    public static final int THOUSAND = 1000;
    public static final int THOUSAND_EIGHTY = 1080;
    public static final int THOUSAND_ONE_HUNDRED = 1100;
    public static final int THOUSAND_TWO_HUNDRED = 1200;
    public static final int THOUSAND_THREE_HUNDRED = 1300;
    public static final int THOUSAND_FOUR_HUNDRED = 1400;
    public static final int THOUSAND_FIVE_HUNDRED = 1500;
    public static final int THOUSAND_SIX_HUNDRED = 1600;
    public static final int THOUSAND_SEVEN_HUNDRED = 1700;
    public static final int THOUSAND_EIGHT_HUNDRED = 1800;
    public static final int THOUSAND_NINE_HUNDRED = 1900;
    public static final int TWO_THOUSAND = 2000;
    public static final int TWO_THOUSAND_FIVE_HUNDRED = 2500;
    public static final int TWO_THOUSAND_EIGHT_HUNDRED = 2800;
    public static final int THREE_THOUSAND = 3000;
    public static final int THREE_THOUSAND_FIVE_HUNDRED = 3500;
    public static final int THREE_THOUSAND_EIGHT_HUNDRED = 3800;
    public static final int FOUR_THOUSAND = 4000;
    public static final int FOUR_THOUSAND_TWO_HUNDRED = 4200;
    public static final int FOUR_THOUSAND_FOUR_HUNDRED = 4400;
    public static final int FOUR_THOUSAND_FIVE_HUNDRED = 4500;
    public static final int FIVE_THOUSAND = 5000;
    public static final int SIX_THOUSAND = 6000;
}
