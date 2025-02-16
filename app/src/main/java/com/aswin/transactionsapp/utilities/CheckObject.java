package com.aswin.transactionsapp.utilities;

import java.lang.reflect.Array;

/**
 * Created by Aswin on 14-09-2023.
 * About Class - For checking An object is null or empty or String value "null".
 */
public class CheckObject {

    /**
     * Check an Object is null or not.
     * @param  data object data.
     *
     * @return  true  - if data object is null or Empty or String value null.
     *          false - if data object is not null or Empty.
     **/
    public static boolean isNullObject(Object data) {
        boolean isnull = false;
        if(data != null){
            if(data.toString().equals("")){
                isnull = true;
            }else if(data.toString().toLowerCase().equals("null")){
               isnull = true;
            }
            else {
                isnull = false;
            }
        }else{
            isnull = true;
        }
        return isnull;
    }

    /**
     * Check an Short is null or not
     * @param  data - short dataType.
     *
     * @return  true  - if data Short is null or Empty or String value null.
     *          false - if data Short is not null or Empty.
     **/
    public static boolean isNullShort(Short data){
        boolean isnull = false;
        if(data != null){
            if(data.toString().equals("")){
                isnull = true;
            }else if(data.toString().toLowerCase().equals("null")){
                isnull = true;
            }
            else {
                isnull = false;
            }
        }else{
            isnull = true;
        }
        return isnull;
    }

    /**
     * Check an Integer is null or not
     * @param  data - Integer dataType.
     *
     * @return  true  - if data Integer is null or Empty or String value null.
     *          false - if data Integer is not null or Empty.
     **/
    public static boolean isNullInt(Integer data){
        boolean isnull = false;
        if(data != null){
            if(data.toString().equals("")){
                isnull = true;
            }else if(data.toString().toLowerCase().equals("null")){
                isnull = true;
            }
            else {
                isnull = false;
            }
        }else{
            isnull = true;
        }
        return isnull;
    }

    /**
     * Check an Long is null or not
     * @param  data - Long dataType.
     *
     * @return  true  - if data Long is null or Empty or String value null.
     *          false - if data Long is not null or Empty.
     **/
    public static boolean isNullFloat(Long data){
        boolean isnull = false;
        if(data != null){
            if(data.toString().equals("")){
                isnull = true;
            }else if(data.toString().toLowerCase().equals("null")){
                isnull = true;
            }
            else {
                isnull = false;
            }
        }else{
            isnull = true;
        }
        return isnull;
    }

    /**
     * Check an Float is null or not
     * @param  data - Float dataType.
     *
     * @return  true  - if data Float is null or Empty or String value null.
     *          false - if data Float is not null or Empty.
     **/
    public static boolean isNullFloat(Float data){
        boolean isnull = false;
        if(data != null){
            if(data.toString().equals("")){
                isnull = true;
            }else if(data.toString().toLowerCase().equals("null")){
                isnull = true;
            }
            else {
                isnull = false;
            }
        }else{
            isnull = true;
        }
        return isnull;
    }

    /**
     * Check an Double is null or not
     * @param  data - Double dataType.
     *
     * @return  true  - if data Double is null or Empty or String value null.
     *          false - if data Double is not null or Empty.
     **/
    public static boolean isNullDouble(Double data){
        boolean isnull = false;
        if(data != null){
            if(data.toString().equals("")){
                isnull = true;
            }else if(data.toString().toLowerCase().equals("null")){
                isnull = true;
            }
            else {
                isnull = false;
            }
        }else{
            isnull = true;
        }
        return isnull;
    }

    /**
     * Check an String is null or not
     * @param  data - String dataType.
     *
     * @return  true  - if data String is null or Empty or String value null.
     *          false - if data String is not null or Empty.
     **/
    public static boolean isNullString(String data){
        boolean isnull = false;
        if(data != null){
            if(data.equals("")){
                isnull = true;
            }else if(data.toLowerCase().equals("null")){
                isnull = true;
            }
            else {
                isnull = false;
            }
        }else{
            isnull = true;
        }
        return isnull;
    }

    /**
     * Check an Array is null or not
     * @param  data - Array dataType.
     *
     * @return  true  - if data Array is null or Empty or String value null.
     *          false - if data Array is not null or Empty.
     **/
    public static boolean isNullDouble(Array data){
        boolean isnull = false;
        if(data != null){
            if(data.toString().equals("")){
                isnull = true;
            }else if(data.toString().toLowerCase().equals("null")){
                isnull = true;
            }
            else {
                isnull = false;
            }
        }else{
            isnull = true;
        }
        return isnull;
    }

    /**
     * Extracts the first letters from a given sentence.
     *
     * @param sentence The input sentence from which to extract first letters.
     * @return A string containing the first letters of the words in the sentence.
     */
    public static String getFirstLetters(String sentence) {
        if (sentence == null || sentence.isEmpty()) {
            return "";
        } else {
            String[] words = sentence.split("\\s+");

            String firstLetterFirstWord = "";
            String firstLetterSecondWord = "";

            // Extract first letters based on the number of words
            if (words.length == 1) {
                firstLetterFirstWord = String.valueOf(words[0].charAt(0));
            } else {
                firstLetterFirstWord = String.valueOf(words[0].charAt(0));
                firstLetterSecondWord = String.valueOf(words[1].charAt(0));
            }
            return firstLetterFirstWord + firstLetterSecondWord;
        }
    }

}