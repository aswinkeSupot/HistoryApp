package com.aswin.transactionsapp.utilities;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.provider.Settings;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.LinearLayout;

import androidx.annotation.IdRes;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;


import com.aswin.transactionsapp.R;

import java.io.UnsupportedEncodingException;
import java.net.NetworkInterface;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommonUtils {

    // Take ScreenShot of a Scrollview.
    public static Bitmap getBitmapFromView(View view, int height, int width) {
        Bitmap bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        Drawable bgDrawable = view.getBackground();
        if (bgDrawable != null)
            bgDrawable.draw(canvas);
        else
            canvas.drawColor(Color.WHITE);
        view.draw(canvas);
        return bitmap;
    }

    // Take ScreenShot of a view(Like layout's).
    public static Bitmap takeScreenshot(LinearLayout view) {
        Bitmap bitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.ARGB_8888);
        Paint paint2 = new Paint();
        paint2.setColor(Color.WHITE);
        paint2.setStyle(Paint.Style.FILL);
        Canvas canvas = new Canvas(bitmap);
        canvas.drawPaint(paint2);
        view.draw(canvas);
        return bitmap;
    }



    public static String encodeString(String text) {
        String base64 = "";
        try {
            byte[] data = text.getBytes("UTF-16");
            base64 = Base64.encodeToString(data, Base64.DEFAULT);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return base64;
    }

    //Capitalize the first letter of the words
    public static String Capitalize(String str) {
        String[] arr = str.split(" "); //convert String to StringArray
        StringBuilder stringBuilder = new StringBuilder();

        for (String w : arr) {
            if (w.length() > 1) {
                stringBuilder.append(w.substring(0, 1).toUpperCase(Locale.US) + w.substring(1).toLowerCase(Locale.US) + " ");
            }
        }
        return stringBuilder.toString().trim();
    }

    public static String decodeString(String base64) {
        String text = "";
        try {
            byte[] data = Base64.decode(base64, Base64.DEFAULT);
            text = new String(data, "UTF-16");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return text;
    }

    public static boolean isDarkModeEnabled(Context context) {
        int nightModeFlags = context.getResources().getConfiguration().uiMode & Configuration.UI_MODE_NIGHT_MASK;
        switch (nightModeFlags) {
            case Configuration.UI_MODE_NIGHT_YES:
                return true;
            case Configuration.UI_MODE_NIGHT_NO:
            case Configuration.UI_MODE_NIGHT_UNDEFINED:
                return false;
        }
        return false;
    }

    public static Bitmap transformBitmapToCircularBitmap(Bitmap source) {
        int size = Math.min(source.getWidth(), source.getHeight());

        int x = (source.getWidth() - size) / 2;
        int y = (source.getHeight() - size) / 2;

        Bitmap squaredBitmap = Bitmap.createBitmap(source, x, y, size, size);
        if (squaredBitmap != source) {
            source.recycle();
        }

        Bitmap bitmap = Bitmap.createBitmap(size, size, source.getConfig());

        Canvas canvas = new Canvas(bitmap);
        Paint paint = new Paint();
        BitmapShader shader = new BitmapShader(squaredBitmap,
                BitmapShader.TileMode.CLAMP, BitmapShader.TileMode.CLAMP);
        paint.setShader(shader);
        paint.setAntiAlias(true);

        float r = size / 2f;
        canvas.drawCircle(r, r, r, paint);

        squaredBitmap.recycle();
        return bitmap;
    }

    public static String amountWithoutZero(String amount) {
        try {
            String temp = "0";
            boolean haveDecimalValue = false;
            try {
                temp = amount.split("\\.")[1];
                if (Integer.parseInt(temp) > 0) {
                    haveDecimalValue = true;
                }
            } catch (Exception e) {
                e.printStackTrace();
                temp = "0";
            }
            String resultAmount = amount;
            if (!haveDecimalValue) {
                resultAmount = amount.replaceAll("\\.00000000", "").replaceAll("\\.0000000", "").replaceAll("\\.000000", "").replaceAll("\\.00000", "").replaceAll("\\.0000", "").replaceAll("\\.000", "").replaceAll("\\.00", "").replaceAll("\\.0", "");
            }
            NumberFormat formatter = new DecimalFormat("#,###.##");
            double myNumber = Double.parseDouble(resultAmount);
            String formattedNumber = formatter.format(myNumber);
            if (!haveDecimalValue) {
                return formattedNumber.replaceAll("\\.00000000", "").replaceAll("\\.0000000", "").replaceAll("\\.000000", "").replaceAll("\\.00000", "").replaceAll("\\.0000", "").replaceAll("\\.000", "").replaceAll("\\.00", "").replaceAll("\\.0", "");
            } else {
                return formattedNumber;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return amount.replaceAll("\\.00000000", "").replaceAll("\\.0000000", "").replaceAll("\\.000000", "").replaceAll("\\.00000", "").replaceAll("\\.0000", "").replaceAll("\\.000", "").replaceAll("\\.00", "").replaceAll("\\.0", "");
        }
    }


    public static Date getDateByString(String dateStr, SimpleDateFormat dateFormat) {
        if (dateStr == null)
            return new Date();
        try {
            return dateFormat.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return new Date();
    }

    public static int getAllReportsLoading(int totalResult, int limit) {
        int totalPages_pre = (totalResult / limit);
        return (totalResult % limit) == 0 ? totalPages_pre : totalPages_pre + 1;
    }

    public static final SimpleDateFormat SDF_DATE_FROM_SERVER_FORMAT = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ", Locale.ENGLISH); // Eg:- 2024-04-10T06:30:03+02:00
    public static final SimpleDateFormat SDF_DATE_FROM_STAGE_SERVER_FORMAT = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.ENGLISH); //2024-04-10T10:18:04Z
//    public static final SimpleDateFormat SDF_DATE_FROM_SERVER_FORMAT = new SimpleDateFormat("YYYY-MM-DDTHH:MM:SSZ", Locale.ENGLISH);
//    public static final SimpleDateFormat SDF_DATE_FROM_UTC_FORMAT = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS",Locale.ENGLISH);

    public static final SimpleDateFormat SDF_DATE_DISPLAY_FORMAT_REMICARD = new SimpleDateFormat("MM/yy", Locale.ENGLISH);

    public static final SimpleDateFormat SDF_DATE_FROM_POS_CURRENT_FORMAT = new SimpleDateFormat("ddMMyyyy", Locale.ENGLISH);
    public static final SimpleDateFormat SDF_DATE_FROM_POS_API_FORMAT = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);

    public static final SimpleDateFormat SDF_DATE_DISPLAY_FORMAT = new SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH);

    public static final SimpleDateFormat SDF_TIME_DISPLAY_FORMAT = new SimpleDateFormat(" hh:mm a", Locale.ENGLISH);

    public static final SimpleDateFormat SDF_DATE_TIME_DISPLAY_FORMAT = new SimpleDateFormat("MM/dd/yyyy hh:mm a", Locale.ENGLISH);
    public static final SimpleDateFormat SDF_DATE_TIME_DISPLAY_FORMAT_NEW = new SimpleDateFormat("dd MMM yyyy, hh:mm a", Locale.ENGLISH);


    public static String getDateStringByFormat(String dateStr, SimpleDateFormat currentFormat, SimpleDateFormat toFormat) {
        return toFormat.format(getDateByString(dateStr, currentFormat));
    }

    public static String getDateTimeStringByLocalFormat(String dateStr, SimpleDateFormat currentFormat, SimpleDateFormat toFormat) {
        try {
            currentFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
            Date date = currentFormat.parse(dateStr);
            toFormat.setTimeZone(TimeZone.getDefault());
            String formattedDate = toFormat.format(date);
            return formattedDate;
        } catch (ParseException e) {
            e.printStackTrace();
            return "";
        }

    }

    public static void showSettingsDialog(final FragmentActivity activity, final int requestCode) {
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setTitle(activity.getString(R.string.dialog_permission_title));
        builder.setMessage(activity.getString(R.string.dialog_permission_message));
        builder.setPositiveButton(activity.getString(R.string.dialog_btn_settings), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
                openSettings(activity, requestCode);
            }
        });

        builder.setNegativeButton(activity.getString(R.string.dialog_btn_cancel), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();

            }
        });
        builder.show();

    }

    public static String getTimeStringForPOS(String dateStr, SimpleDateFormat currentFormat, SimpleDateFormat toFormat) {
        try {
//            currentFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
            Date date = currentFormat.parse(dateStr);

            int days = getTimeRemaining(date);
            toFormat.setTimeZone(TimeZone.getDefault());
            String formattedDate = toFormat.format(date);
            String formattedDateFinal = formattedDate;
            return formattedDateFinal;
        } catch (ParseException e) {
            e.printStackTrace();
            return "";
        }

    }

    public static String getDateTimeStringByLocalFormatWithToday(String dateStr, SimpleDateFormat currentFormat, SimpleDateFormat toFormat) {
        try {
//            currentFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
            Date date = currentFormat.parse(dateStr);

            int days = getTimeRemaining(date);
            toFormat.setTimeZone(TimeZone.getDefault());
            String formattedDate = toFormat.format(date);
            String formattedDateFinal = formattedDate;
            if (days == 0) {
                formattedDateFinal = "Today, " + formattedDate.split(",")[1];
            } else if (days == 1) {
                formattedDateFinal = "Yesterday, " + formattedDate.split(",")[1];
            }
            return formattedDateFinal;
        } catch (ParseException e) {
            e.printStackTrace();
            return "";
        }

    }

    public static String getConvertedTimeFromUTC(String dateString, SimpleDateFormat currentFormat, SimpleDateFormat toFormat){
        try {
            String utcTimestamp = dateString;
            currentFormat.setTimeZone(TimeZone.getTimeZone("UTC"));

            // Parse the UTC timestamp into a Date object
            Date utcDate = null;

            utcDate = currentFormat.parse(utcTimestamp);

            int days = getTimeRemaining(utcDate);

            // Get the default time zone of the phone
            TimeZone defaultTimeZone = TimeZone.getDefault();
            String timeZoneID = defaultTimeZone.getID();

            // Create a SimpleDateFormat object for Current Phone Timezone
            toFormat.setTimeZone(TimeZone.getTimeZone(timeZoneID)); // Set Current phone timezone

            // Format the Date object to IST time in the desired format
            String formattedDate = toFormat.format(utcDate) + "";

            String formattedDateFinal = formattedDate;
            if (days == 0) {
                formattedDateFinal = "Today, " + formattedDate.split(",")[1];
            } else if (days == 1) {
                formattedDateFinal = "Yesterday, " + formattedDate.split(",")[1];
            }

            return formattedDateFinal;
        } catch (ParseException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static int getTimeRemaining(Date date) {
        Calendar sDate = toCalendar(date.getTime());
        Calendar eDate = toCalendar(System.currentTimeMillis());

        // Get the represented date in milliseconds
        long milis1 = sDate.getTimeInMillis();
        long milis2 = eDate.getTimeInMillis();

        // Calculate difference in milliseconds
        long diff = Math.abs(milis2 - milis1);

        return (int) (diff / (24 * 60 * 60 * 1000));
    }

    private static Calendar toCalendar(long timestamp) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(timestamp);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar;
    }

//    public static void showSettingsDialog(final FragmentActivity activity, final int requestCode) {
//        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
//        builder.setTitle(activity.getString(R.string.dialog_permission_title));
//        builder.setMessage(activity.getString(R.string.dialog_permission_message));
//        builder.setPositiveButton(activity.getString(R.string.dialog_btn_settings), new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialogInterface, int i) {
//                dialogInterface.cancel();
//                openSettings(activity, requestCode);
//            }
//        });
//
//        builder.setNegativeButton(activity.getString(R.string.dialog_btn_cancel), new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialogInterface, int i) {
//                dialogInterface.cancel();
//
//            }
//        });
//        builder.show();
//
//    }

    private static void openSettings(FragmentActivity activity, int requestCode) {
        Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
        Uri uri = Uri.fromParts("package", activity.getPackageName(), null);
        intent.setData(uri);
        activity.startActivityForResult(intent, requestCode);
    }

    public static String getDateStringByFormat(int year, int monthOfYear, int dayOfMonth, SimpleDateFormat dateFormat) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, monthOfYear);
        calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);

        return dateFormat.format(calendar.getTime());
    }

//    public static ProgressDialog createProgressDialog(Context context) {
//        ProgressDialog dialog = new ProgressDialog(context);
//        try {
//            dialog.show();
//        } catch (WindowManager.BadTokenException e) {
//
//        }
//        dialog.setCancelable(false);
//        dialog.getWindow()
//                .setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
//        dialog.setContentView(R.layout.activity_progress_dialog);
//        // dialog.setMessage(Message);
//        return dialog;
//    }

//    public static ProgressDialog dissmissProgressDialog(Context context) {
//        ProgressDialog dialog = new ProgressDialog(context);
//        try {
//            dialog.dismiss();
//        } catch (WindowManager.BadTokenException e) {
//
//        }
//        dialog.setCancelable(false);
//        dialog.getWindow()
//                .setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
//        dialog.setContentView(R.layout.activity_progress_dialog);
//        // dialog.setMessage(Message);
//        return dialog;
//    }

    public static void replaceFragment(@IdRes int layoutId, FragmentManager fm, Fragment fragment, String tag, boolean isInitial) {
        FragmentTransaction transaction = fm.beginTransaction();

        transaction.isAddToBackStackAllowed();
        transaction.replace(layoutId, fragment, tag);
        if (!isInitial)
            transaction.addToBackStack(tag);
        transaction.commit();
    }

    public static int GetVersionNo(Context context) {

        PackageManager manager = context.getPackageManager();
        PackageInfo info = null;
        try {
            info = manager.getPackageInfo(context.getPackageName(), PackageManager.GET_ACTIVITIES);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }

        return info.versionCode;
    }


    public static String properCase(String inputVal) {
        // Empty strings should be returned as-is.

        if (inputVal.length() == 0) return "";

        // Strings with only one character uppercased.

        if (inputVal.length() == 1) ;
        return inputVal.toUpperCase();

        // Otherwise uppercase first letter, lowercase the rest.


    }

    public static String getUniqueNumbers(String data) {
        String[] contacts = data.split(",");
        String finalData = "";
        for (int i = 0; i < contacts.length; i++) {
            if (!finalData.contains(getTenDigitsNumber(contacts[i]))) {
                finalData = finalData + "," + getTenDigitsNumber(contacts[i]);
            }
        }
        return finalData.replaceFirst(",", "");
    }

    private static String getTenDigitsNumber(String number) {
        if (number.length() > 10) {
            return number.substring(number.length() - 10);
        } else {
            return number;
        }
    }

    public String toEncrypt(String s) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-512");
            byte[] digest = md.digest(s.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte aDigest : digest) {
                sb.append(Integer.toString((aDigest & 0xff) + 0x100, 16).substring(1));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return "";
        }


    }

    public static boolean isVPNOn() {
        List<String> networkList = new ArrayList<>();
        try {
            for (NetworkInterface networkInterface : Collections.list(NetworkInterface.getNetworkInterfaces())) {
                if (networkInterface.isUp())
                    networkList.add(networkInterface.getName());
            }
        } catch (Exception ex) {
            Log.e("", "isVpnUsing Network List didn't received");
        }

        return networkList.contains("tun0");

    }

    public static void hideSoftKeyboard(Activity activity) {
        InputMethodManager inputMethodManager =
                (InputMethodManager) activity.getSystemService(
                        Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(
                activity.getCurrentFocus().getWindowToken(), 0);
    }

    public static String formatCardNumber(String number) {
        StringBuilder s;
        s = new StringBuilder(number.replaceAll(" ", ""));
        for (int i = 4; i < s.length(); i += 5) {
            s.insert(i, " ");
        }
        return s.toString();
    }

    public static String maskedCardNumber(String number) {
        try {
            if (isValidCardNumber(number)) {
                StringBuilder s;
                s = new StringBuilder(number.replaceAll(" ", ""));
                String finalValue = "";
                for (int i = 4; i < s.length(); i += 5) {
                    s.insert(i, " ");
                }
                for (int i = 0; i < s.length(); i++) {
                    if (i < 15) {
                        if ((s.charAt(i) + "").equalsIgnoreCase(" ")) {
                            finalValue = finalValue + " ";
                        } else {
                            finalValue = finalValue + "x";
                        }
                    } else {
                        finalValue = finalValue + s.charAt(i);
                    }
                }
                return finalValue;
            } else {
                try {
                    return capitalizeFirstCharsInString(number);
                } catch (Exception e) {
                    e.printStackTrace();
                    return number;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return number;
        }
    }

    private static boolean isValidCardNumber(String number) {
        if (number.matches("^[0-9 ]+$")) {
            // contains only listed chars
            return true;
        } else {
            // contains other chars
            return false;
        }
    }

    public static String capitalizeFirstCharsInString(String str) {
        try {
            String regex = "\\s+";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(str);
            str = matcher.replaceAll(" ");
            String[] strArray = str.split(" ");
            StringBuilder builder = new StringBuilder();
            for (String s : strArray) {
                String cap = s.substring(0, 1).toUpperCase() + s.substring(1);
                builder.append(cap + " ");
            }
            return builder.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return str;
        }
    }

    public static String capitalizeFirstTwoCharsInString(String str) {
        try {
            String regex = "\\s+";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(str);
            str = matcher.replaceAll(" ");
            String[] strArray = str.split(" ");
            StringBuilder builder = new StringBuilder();
            if (strArray.length > 1) {
                for (int i = 0; i < 2; i++) {
                    String s = strArray[i];
                    String cap = s.substring(0, 1).toUpperCase();
                    builder.append(cap);
                }
            } else {
                for (String s : strArray) {
                    String cap = s.substring(0, 1).toUpperCase();
                    builder.append(cap);
                }
            }
            return builder.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return str;
        }
    }

    public static String getEnglishMonth(String month) {
        switch (month) {
            case "01":
                return "January";
            case "02":
                return "February";
            case "03":
                return "March";
            case "04":
                return "April";
            case "05":
                return "May";
            case "06":
                return "June";
            case "07":
                return "July";
            case "08":
                return "August";
            case "09":
                return "September";
            case "10":
                return "October";
            case "11":
                return "November";
            case "12":
                return "December";
        }
        return month;
    }

    public static String getEnglishMonthShortFromLong(String month) {
        switch (month) {
            case "January":
                return "Jan";
            case "February":
                return "Feb";
            case "March":
                return "Mar";
            case "April":
                return "Apr";
            case "May":
                return "May";
            case "June":
                return "Jun";
            case "July":
                return "Jul";
            case "August":
                return "Aug";
            case "September":
                return "Sep";
            case "October":
                return "Oct";
            case "November":
                return "Nov";
            case "December":
                return "Dec";
        }
        return month;
    }

    public static String getEnglishMonthShort(String month) {
        switch (month) {
            case "01":
                return "Jan";
            case "02":
                return "Feb";
            case "03":
                return "Mar";
            case "04":
                return "Apr";
            case "05":
                return "May";
            case "06":
                return "Jun";
            case "07":
                return "Jul";
            case "08":
                return "Aug";
            case "09":
                return "Sep";
            case "10":
                return "Oct";
            case "11":
                return "Nov";
            case "12":
                return "Dec";
        }
        return month;
    }

    public static String getMonthFromString(String month) {
        switch (month) {
            case "Jan":
                return "01";
            case "Feb":
                return "02";
            case "Mar":
                return "03";
            case "Apr":
                return "04";
            case "May":
                return "05";
            case "Jun":
                return "06";
            case "Jul":
                return "07";
            case "Aug":
                return "08";
            case "Sep":
                return "09";
            case "Oct":
                return "10";
            case "Nov":
                return "11";
            case "Dec":
                return "12";
        }
        return month;
    }

    public static String getNepaliMonth(String month) {
        switch (month) {
            case "01":
                return "बैशाख";
            case "02":
                return "जेष्ठ";
            case "03":
                return "आषाढ";
            case "04":
                return "श्रावण";
            case "05":
                return "भाद्र";
            case "06":
                return "आश्विन";
            case "07":
                return "कार्तिक";
            case "08":
                return "मार्ग";
            case "09":
                return "पौष";
            case "10":
                return "माघ";
            case "11":
                return "फाल्गुन";
            case "12":
                return "चैत्र";
        }
        return month;
    }
}
