package com.sagar.android.numberconvertercore;

import java.util.ArrayList;

/**
 * Created by sagar on 9/19/2017.
 * the conversionResult of the conversion of number to words will be sent in this object.
 */

public class ConversionResult {

    /**
     * result code for sending the result to the calling activity.
     */
    public enum ResultCode {
        SUCCESS,
        FAIL
    }

    /*
    arraylist ro contain the results
     */
    private ArrayList<String> result;
    /*
    result code will save if the result is success or failed
     */
    private ResultCode resultCode;

    ConversionResult() {
        result = new ArrayList<>();
    }

    @SuppressWarnings("unused")
    public ConversionResult(ArrayList<String> result, ResultCode resultCode) {
        this.result = new ArrayList<>();
        this.result = result;
        this.resultCode = resultCode;
    }

    /**
     * if a single result is provided then just add that single result to the arraylist that is saved
     * in the conversion result object.
     * it will also remove if any extra space is entered to the result
     * @param result result of conversion
     * @param resultCode result code
     */
    ConversionResult(String result, ResultCode resultCode) {
        result = result.trim();
        result = result.replaceAll("  ", " ");
        this.result = new ArrayList<>();
        ArrayList<String> results = new ArrayList<>();
        results.add(result);
        this.result.addAll(results);
        this.resultCode = resultCode;
    }

    /**
     * getter method for the result arraylist.
     * @return arraylist of the result
     */
    public ArrayList<String> getResult() {
        return result;
    }

    /**
     * add a list of result to the result list in the object.
     * it will check for duplicates. and if that object is not present in the object then it will
     * add it to the list of results.
     * @param result list of result
     */
    void setResult(ArrayList<String> result) {
        if (this.result.size() > 0) {
            for (String res :
                    result) {
                if (!this.result.contains(res)) {
                    this.result.add(res);
                }
            }
        } else {
            this.result.addAll(result);
        }
    }

    /**
     * it will add a single result to the object.
     * it will do it indirectly by sending it to setResult(ArrayList<String> result) method in form
     * of a arraylist.
     * @param result single result to add
     */
    void setResult(String result) {
        result = result.trim();
        result = result.replaceAll("  ", " ");
        ArrayList<String> results = new ArrayList<>();
        results.add(result);
        setResult(results);
    }

    /**
     * get the result code of the conversion result.
     * @return result code
     */
    public ResultCode getResultCode() {
        return resultCode;
    }

    /**
     * set teh result code to the object.
     * @param resultCode result code to set
     */
    void setResultCode(ResultCode resultCode) {
        this.resultCode = resultCode;
    }
}
