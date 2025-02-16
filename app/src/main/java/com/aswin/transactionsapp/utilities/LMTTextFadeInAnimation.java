package com.aswin.transactionsapp.utilities;

import android.content.Context;
import android.os.Handler;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.widget.TextView;

import com.aswin.transactionsapp.R;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Lijo Mathew Theckanal on 14-10-2020.
 */

public class LMTTextFadeInAnimation {

    //Color
    public static final String WHITE = "whiteColor";
    public static final String WHITE_COMMON = "whiteColorCommon";
    public static final String BLACK_LIGHT = "blackLightColor";
    public static final String GRAY_DARK = "grayDarkColor";
    public static final String BLACK = "blackColor";

    private Map<Integer, Integer> COLORS_MAP_WHITE = new HashMap<>();
    private Map<Integer, Integer> COLORS_MAP_WHITE_COMMON = new HashMap<>();
    private Map<Integer, Integer> COLORS_MAP_BLACK_LIGHT = new HashMap<>();
    private Map<Integer, Integer> COLORS_MAP_GRAY_DARK = new HashMap<>();
    private Map<Integer, Integer> COLORS_MAP_BLACK = new HashMap<>();
    private int fadeInSteps = 0;
    private int completedTextPos = 0;
    private int textLength;
    private int animationCharLength;
    private int animationCharLengthMain;
    private long animationTimeForEach;
    private String textColor;

    public void startTextViewAnimation(final Context context, final String text, final TextView textView, long animationTime, long startDelayTime, long hideViewTime, String textColor, int animationCharLength) {
        try {
            COLORS_MAP_WHITE.put(0, context.getColor(R.color.whiteTransparent0));
            COLORS_MAP_WHITE.put(1, context.getColor(R.color.whiteTransparent1));
            COLORS_MAP_WHITE.put(2, context.getColor(R.color.whiteTransparent2));
            COLORS_MAP_WHITE.put(3, context.getColor(R.color.whiteTransparent3));
            COLORS_MAP_WHITE.put(4, context.getColor(R.color.whiteTransparent4));
            COLORS_MAP_WHITE.put(5, context.getColor(R.color.whiteTransparent5));
            COLORS_MAP_WHITE.put(6, context.getColor(R.color.whiteTransparent6));
            COLORS_MAP_WHITE.put(7, context.getColor(R.color.whiteTransparent7));
            COLORS_MAP_WHITE.put(8, context.getColor(R.color.whiteTransparent8));
            COLORS_MAP_WHITE.put(9, context.getColor(R.color.whiteTransparent9));
            COLORS_MAP_WHITE.put(10, context.getColor(R.color.whiteTransparent10));
            COLORS_MAP_WHITE.put(11, context.getColor(R.color.whiteTransparent11));
            COLORS_MAP_WHITE.put(12, context.getColor(R.color.whiteTransparent12));
            COLORS_MAP_WHITE.put(13, context.getColor(R.color.whiteTransparent13));
            COLORS_MAP_WHITE.put(14, context.getColor(R.color.whiteTransparent14));
            COLORS_MAP_WHITE.put(15, context.getColor(R.color.whiteTransparent15));

            COLORS_MAP_WHITE_COMMON.put(0, context.getColor(R.color.whiteTransparentCommon0));
            COLORS_MAP_WHITE_COMMON.put(1, context.getColor(R.color.whiteTransparentCommon1));
            COLORS_MAP_WHITE_COMMON.put(2, context.getColor(R.color.whiteTransparentCommon2));
            COLORS_MAP_WHITE_COMMON.put(3, context.getColor(R.color.whiteTransparentCommon3));
            COLORS_MAP_WHITE_COMMON.put(4, context.getColor(R.color.whiteTransparentCommon4));
            COLORS_MAP_WHITE_COMMON.put(5, context.getColor(R.color.whiteTransparentCommon5));
            COLORS_MAP_WHITE_COMMON.put(6, context.getColor(R.color.whiteTransparentCommon6));
            COLORS_MAP_WHITE_COMMON.put(7, context.getColor(R.color.whiteTransparentCommon7));
            COLORS_MAP_WHITE_COMMON.put(8, context.getColor(R.color.whiteTransparentCommon8));
            COLORS_MAP_WHITE_COMMON.put(9, context.getColor(R.color.whiteTransparentCommon9));
            COLORS_MAP_WHITE_COMMON.put(10, context.getColor(R.color.whiteTransparentCommon10));
            COLORS_MAP_WHITE_COMMON.put(11, context.getColor(R.color.whiteTransparentCommon11));
            COLORS_MAP_WHITE_COMMON.put(12, context.getColor(R.color.whiteTransparentCommon12));
            COLORS_MAP_WHITE_COMMON.put(13, context.getColor(R.color.whiteTransparentCommon13));
            COLORS_MAP_WHITE_COMMON.put(14, context.getColor(R.color.whiteTransparentCommon14));
            COLORS_MAP_WHITE_COMMON.put(15, context.getColor(R.color.whiteTransparentCommon15));

            COLORS_MAP_BLACK_LIGHT.put(0, context.getColor(R.color.blackLightTransparent0));
            COLORS_MAP_BLACK_LIGHT.put(1, context.getColor(R.color.blackLightTransparent1));
            COLORS_MAP_BLACK_LIGHT.put(2, context.getColor(R.color.blackLightTransparent2));
            COLORS_MAP_BLACK_LIGHT.put(3, context.getColor(R.color.blackLightTransparent3));
            COLORS_MAP_BLACK_LIGHT.put(4, context.getColor(R.color.blackLightTransparent4));
            COLORS_MAP_BLACK_LIGHT.put(5, context.getColor(R.color.blackLightTransparent5));
            COLORS_MAP_BLACK_LIGHT.put(6, context.getColor(R.color.blackLightTransparent6));
            COLORS_MAP_BLACK_LIGHT.put(7, context.getColor(R.color.blackLightTransparent7));
            COLORS_MAP_BLACK_LIGHT.put(8, context.getColor(R.color.blackLightTransparent8));
            COLORS_MAP_BLACK_LIGHT.put(9, context.getColor(R.color.blackLightTransparent9));
            COLORS_MAP_BLACK_LIGHT.put(10, context.getColor(R.color.blackLightTransparent10));
            COLORS_MAP_BLACK_LIGHT.put(11, context.getColor(R.color.blackLightTransparent11));
            COLORS_MAP_BLACK_LIGHT.put(12, context.getColor(R.color.blackLightTransparent12));
            COLORS_MAP_BLACK_LIGHT.put(13, context.getColor(R.color.blackLightTransparent13));
            COLORS_MAP_BLACK_LIGHT.put(14, context.getColor(R.color.blackLightTransparent14));
            COLORS_MAP_BLACK_LIGHT.put(15, context.getColor(R.color.blackLightTransparent15));

            COLORS_MAP_GRAY_DARK.put(0, context.getColor(R.color.grayDarkTransparent0));
            COLORS_MAP_GRAY_DARK.put(1, context.getColor(R.color.grayDarkTransparent1));
            COLORS_MAP_GRAY_DARK.put(2, context.getColor(R.color.grayDarkTransparent2));
            COLORS_MAP_GRAY_DARK.put(3, context.getColor(R.color.grayDarkTransparent3));
            COLORS_MAP_GRAY_DARK.put(4, context.getColor(R.color.grayDarkTransparent4));
            COLORS_MAP_GRAY_DARK.put(5, context.getColor(R.color.grayDarkTransparent5));
            COLORS_MAP_GRAY_DARK.put(6, context.getColor(R.color.grayDarkTransparent6));
            COLORS_MAP_GRAY_DARK.put(7, context.getColor(R.color.grayDarkTransparent7));
            COLORS_MAP_GRAY_DARK.put(8, context.getColor(R.color.grayDarkTransparent8));
            COLORS_MAP_GRAY_DARK.put(9, context.getColor(R.color.grayDarkTransparent9));
            COLORS_MAP_GRAY_DARK.put(10, context.getColor(R.color.grayDarkTransparent10));
            COLORS_MAP_GRAY_DARK.put(11, context.getColor(R.color.grayDarkTransparent11));
            COLORS_MAP_GRAY_DARK.put(12, context.getColor(R.color.grayDarkTransparent12));
            COLORS_MAP_GRAY_DARK.put(13, context.getColor(R.color.grayDarkTransparent13));
            COLORS_MAP_GRAY_DARK.put(14, context.getColor(R.color.grayDarkTransparent14));
            COLORS_MAP_GRAY_DARK.put(15, context.getColor(R.color.grayDarkTransparent15));

            COLORS_MAP_BLACK.put(0, context.getColor(R.color.blackTransparent0));
            COLORS_MAP_BLACK.put(1, context.getColor(R.color.blackTransparent1));
            COLORS_MAP_BLACK.put(2, context.getColor(R.color.blackTransparent2));
            COLORS_MAP_BLACK.put(3, context.getColor(R.color.blackTransparent3));
            COLORS_MAP_BLACK.put(4, context.getColor(R.color.blackTransparent4));
            COLORS_MAP_BLACK.put(5, context.getColor(R.color.blackTransparent5));
            COLORS_MAP_BLACK.put(6, context.getColor(R.color.blackTransparent6));
            COLORS_MAP_BLACK.put(7, context.getColor(R.color.blackTransparent7));
            COLORS_MAP_BLACK.put(8, context.getColor(R.color.blackTransparent8));
            COLORS_MAP_BLACK.put(9, context.getColor(R.color.blackTransparent9));
            COLORS_MAP_BLACK.put(10, context.getColor(R.color.blackTransparent10));
            COLORS_MAP_BLACK.put(11, context.getColor(R.color.blackTransparent11));
            COLORS_MAP_BLACK.put(12, context.getColor(R.color.blackTransparent12));
            COLORS_MAP_BLACK.put(13, context.getColor(R.color.blackTransparent13));
            COLORS_MAP_BLACK.put(14, context.getColor(R.color.blackTransparent14));
            COLORS_MAP_BLACK.put(15, context.getColor(R.color.blackTransparent15));


            textLength = text.length();
            this.textColor = textColor;
            this.animationCharLength = animationCharLength;
            this.animationCharLengthMain = animationCharLength;
            animationTimeForEach = animationTime / textLength;
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    doAnimation(context, text, textView);
                }
            }, startDelayTime);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void doAnimation(final Context context, final String text, final TextView textView) {
        try {
            animationCharLength = animationCharLengthMain;
            SpannableStringBuilder mSpannableStringBuilder = new SpannableStringBuilder();
            if (fadeInSteps > 15) {
                completedTextPos = completedTextPos + animationCharLength;
            }
            for (int i = 0; i < textLength; i = i + animationCharLength) {
                if (i + animationCharLength > textLength) {
                    animationCharLength = animationCharLength - (animationCharLength - 1);
                }
                if ((i >= completedTextPos) && (i < (completedTextPos + 16)) && (i <= fadeInSteps)) {
                    SpannableString lastSpannableChar = new SpannableString(text.substring(i, i + animationCharLength));
                    int color = pickColorByPos((fadeInSteps - (i)) % 16);
                    ForegroundColorSpan fcs = new ForegroundColorSpan(color);
                    lastSpannableChar.setSpan(fcs, 0, animationCharLength, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
                    mSpannableStringBuilder.append(lastSpannableChar);
                } else if ((i <= completedTextPos)) {
                    SpannableString lastSpannableChar = new SpannableString(text.substring(i, i + animationCharLength));
                    int color = pickColorByPos(15);
                    ForegroundColorSpan fcs = new ForegroundColorSpan(color);
                    lastSpannableChar.setSpan(fcs, 0, animationCharLength, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
                    mSpannableStringBuilder.append(lastSpannableChar);
                } else {
                    SpannableString lastSpannableChar = new SpannableString(text.substring(i, i + animationCharLength));
                    int color = pickColorByPos(0);
                    ForegroundColorSpan fcs = new ForegroundColorSpan(color);
                    lastSpannableChar.setSpan(fcs, 0, animationCharLength, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
                    mSpannableStringBuilder.append(lastSpannableChar);
                }
            }
            fadeInSteps = fadeInSteps + animationCharLength;
            textView.setText(mSpannableStringBuilder);
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    if (fadeInSteps < text.length() + 16) {
                        doAnimation(context, text, textView);
                    }
                }
            }, animationTimeForEach);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void doAnimationFast(final Context context, final String text, final TextView textView) {
        try {
            SpannableStringBuilder mSpannableStringBuilder = new SpannableStringBuilder();
            if (fadeInSteps > 15) {
                completedTextPos++;
                completedTextPos++;
            }
            for (int i = 0; i < textLength; i++) {
                if ((i >= completedTextPos) && (i < (completedTextPos + 16)) && (i <= fadeInSteps)) {
                    SpannableString lastSpannableChar = new SpannableString(text.substring(i, i + 2));
                    int color = pickColorByPos((fadeInSteps - (i)) % 16);
                    ForegroundColorSpan fcs = new ForegroundColorSpan(color);
                    lastSpannableChar.setSpan(fcs, 0, 2, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
                    mSpannableStringBuilder.append(lastSpannableChar);
                } else if ((i <= completedTextPos)) {
                    SpannableString lastSpannableChar = new SpannableString(text.substring(i, i + 2));
                    int color = pickColorByPos(15);
                    ForegroundColorSpan fcs = new ForegroundColorSpan(color);
                    lastSpannableChar.setSpan(fcs, 0, 2, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
                    mSpannableStringBuilder.append(lastSpannableChar);
                } else {
                    SpannableString lastSpannableChar = new SpannableString(text.substring(i, i + 2));
                    int color = pickColorByPos(0);
                    ForegroundColorSpan fcs = new ForegroundColorSpan(color);
                    lastSpannableChar.setSpan(fcs, 0, 2, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
                    mSpannableStringBuilder.append(lastSpannableChar);
                }
                i++;
            }
            fadeInSteps++;
            fadeInSteps++;
            textView.setText(mSpannableStringBuilder);
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    if (fadeInSteps < text.length() + 16) {
                        doAnimationFast(context, text, textView);
                    }
                }
            }, animationTimeForEach);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private int pickColorByPos(int pos) {
        if (textColor.equals(WHITE)) {
            return COLORS_MAP_WHITE.get(pos);
        } else if (textColor.equals(WHITE_COMMON)) {
            return COLORS_MAP_WHITE_COMMON.get(pos);
        } else if (textColor.equals(BLACK_LIGHT)) {
            return COLORS_MAP_BLACK_LIGHT.get(pos);
        } else if (textColor.equals(GRAY_DARK)) {
            return COLORS_MAP_GRAY_DARK.get(pos);
        }else if (textColor.equals(BLACK)) {
            return COLORS_MAP_BLACK.get(pos);
        } else {
            return COLORS_MAP_WHITE.get(pos);
        }
    }
}
