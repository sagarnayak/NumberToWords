package com.sagar.android.numberconvertercore;

import android.app.Activity;
import android.content.Context;

import java.util.ArrayList;

/**
 * Created by sagar on 9/19/2017.
 * ConvertIND numbers to words
 */
public class ConvertWS {

    /*
    context to be used when calling the interface functions.
     */
    private Context context;

    public ConvertWS(Context context) {
        this.context = context;
    }

    /**
     * interface for sending the conversionResult to the calling function after the execution is finished.
     */
    public interface CallbackConvertWS {
        void conversionResultWS(ConversionResult conversionResult);
    }

    /**
     * method that will convert the number to words. this will run on a separate thread and after
     * completion of the work. it will send back the result to the calling activity.
     *
     * @param numberToConvert number to convert in string
     */
    public void convertNumberToWord(final String numberToConvert) {
        try {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    final ConversionResult conversionResult = numberToWords(numberToConvert);
                    ((Activity) context).runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            sendResult(conversionResult);
                        }
                    });
                }
            }).start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * convert numbers to words. this is the method that will be called by the in library function
     * and this will start the work.
     * it will check if the number supplied is a number or not. if all of its contains are not digit
     * then this will return back a error.
     * if the passed arg is a number then it will check for the length and parse them accordingly.
     *
     * @param numberToConvert number to convert
     * @return result of the conversion
     */
    private ConversionResult numberToWords(String numberToConvert) {
        char[] numberToConvertCharArray = numberToConvert.toCharArray();
        for (char c : numberToConvertCharArray) {
            if (!Character.isDigit(c)) {
                return new ConversionResult(ErrorMaster.NOT_A_NUMBER,
                        ConversionResult.ResultCode.FAIL);
            }
        }
        switch (numberToConvert.length()) {
            case 0:
                return new ConversionResult(ErrorMaster.NO_NUMBER_TO_CONVERT,
                        ConversionResult.ResultCode.FAIL);
            case 1:
                return convertSingleDigitToWords(numberToConvert);
            case 2:
                ConversionResult result = convertDoubleDigitToWords(numberToConvert);
                if (result.getResult().get(0).equals(Numbers.NOTHING))
                    return new ConversionResult(Numbers.ZERO, ConversionResult.ResultCode.SUCCESS);
                return result;
            case 3:
                return convertThreeDigitToWord(numberToConvert);
            default:
                return proceedByDividingNumber(numberToConvert);
        }
    }

    /**
     * convert single digit to words.
     * this function will convert number from 0 - 9 to its words representation.
     *
     * @param numberToConvert number to convert
     * @return word representation of the number
     */
    private ConversionResult convertSingleDigitToWords(String numberToConvert) {
        switch (numberToConvert) {
            case "0":
                return new ConversionResult(Numbers.ZERO, ConversionResult.ResultCode.SUCCESS);
            case "1":
                return new ConversionResult(Numbers.ONE, ConversionResult.ResultCode.SUCCESS);
            case "2":
                return new ConversionResult(Numbers.TWO, ConversionResult.ResultCode.SUCCESS);
            case "3":
                return new ConversionResult(Numbers.THREE, ConversionResult.ResultCode.SUCCESS);
            case "4":
                return new ConversionResult(Numbers.FOUR, ConversionResult.ResultCode.SUCCESS);
            case "5":
                return new ConversionResult(Numbers.FIVE, ConversionResult.ResultCode.SUCCESS);
            case "6":
                return new ConversionResult(Numbers.SIX, ConversionResult.ResultCode.SUCCESS);
            case "7":
                return new ConversionResult(Numbers.SEVEN, ConversionResult.ResultCode.SUCCESS);
            case "8":
                return new ConversionResult(Numbers.EIGHT, ConversionResult.ResultCode.SUCCESS);
            case "9":
                return new ConversionResult(Numbers.NINE, ConversionResult.ResultCode.SUCCESS);
            default:
                return new ConversionResult(ErrorMaster.NOT_A_NUMBER + numberToConvert,
                        ConversionResult.ResultCode.FAIL);
        }
    }

    /**
     * method to convert double digit number to its word representation.
     *
     * @param numberToConvert number to convert
     * @return word representation
     */
    private ConversionResult convertDoubleDigitToWords(String numberToConvert) {
        switch (numberToConvert) {
            case "00":
                return new ConversionResult(Numbers.NOTHING, ConversionResult.ResultCode.SUCCESS);
            case "10":
                return new ConversionResult(Numbers.TEN, ConversionResult.ResultCode.SUCCESS);
            case "11":
                return new ConversionResult(Numbers.ELEVEN, ConversionResult.ResultCode.SUCCESS);
            case "12":
                return new ConversionResult(Numbers.TWELVE, ConversionResult.ResultCode.SUCCESS);
            case "13":
                return new ConversionResult(Numbers.THIRTEEN, ConversionResult.ResultCode.SUCCESS);
            case "14":
                return new ConversionResult(Numbers.FOURTEEN, ConversionResult.ResultCode.SUCCESS);
            case "15":
                return new ConversionResult(Numbers.FIFTEEN, ConversionResult.ResultCode.SUCCESS);
            case "16":
                return new ConversionResult(Numbers.SIXTEEN, ConversionResult.ResultCode.SUCCESS);
            case "17":
                return new ConversionResult(Numbers.SEVENTEEN, ConversionResult.ResultCode.SUCCESS);
            case "18":
                return new ConversionResult(Numbers.EIGHTEEN, ConversionResult.ResultCode.SUCCESS);
            case "19":
                return new ConversionResult(Numbers.NINETEEN, ConversionResult.ResultCode.SUCCESS);
            case "20":
                return new ConversionResult(Numbers.TWENTY, ConversionResult.ResultCode.SUCCESS);
            case "30":
                return new ConversionResult(Numbers.THIRTY, ConversionResult.ResultCode.SUCCESS);
            case "40":
                return new ConversionResult(Numbers.FORTY, ConversionResult.ResultCode.SUCCESS);
            case "50":
                return new ConversionResult(Numbers.FIFTY, ConversionResult.ResultCode.SUCCESS);
            case "60":
                return new ConversionResult(Numbers.SIXTY, ConversionResult.ResultCode.SUCCESS);
            case "70":
                return new ConversionResult(Numbers.SEVENTY, ConversionResult.ResultCode.SUCCESS);
            case "80":
                return new ConversionResult(Numbers.EIGHTY, ConversionResult.ResultCode.SUCCESS);
            case "90":
                return new ConversionResult(Numbers.NINETY, ConversionResult.ResultCode.SUCCESS);
            default:
                char[] digits = numberToConvert.toCharArray();
                ConversionResult tenthDigitWordResult = convertDoubleDigitToWords(digits[0] + "0");
                if (tenthDigitWordResult.getResultCode() == ConversionResult.ResultCode.FAIL) {
                    return new ConversionResult(ErrorMaster.NOT_A_NUMBER + digits[0], ConversionResult.ResultCode.FAIL);
                }
                ConversionResult unitDigitWordResult = convertSingleDigitToWords(String.valueOf(digits[1]));
                if (unitDigitWordResult.getResultCode() == ConversionResult.ResultCode.FAIL) {
                    return new ConversionResult(ErrorMaster.NOT_A_NUMBER + digits[1], ConversionResult.ResultCode.FAIL);
                }
                return new ConversionResult(
                        tenthDigitWordResult.getResult().get(0) +
                                unitDigitWordResult.getResult().get(0), ConversionResult.ResultCode.SUCCESS);
        }
    }

    /**
     * convert number with 3 digit to its words representation.
     * LOGIC-
     * ---------------------------------------------------------------------------------------------
     * divide the number to hundred place and remaining two digits.
     * convert the hundred place digit to word req and add divider KW hundred to its right.
     * convert the remaining two digits to its word representation and add then to the result right.
     * ---------------------------------------------------------------------------------------------
     *
     * @param numberToConvert number to convert
     * @return word representation
     */
    private ConversionResult convertThreeDigitToWord(String numberToConvert) {
        try {
            ConversionResult result = new ConversionResult();
            if (numberToConvert.equals("000")) {
                result.setResult(Numbers.NOTHING);
                result.setResultCode(ConversionResult.ResultCode.SUCCESS);
                return result;
            }
            char[] digits = numberToConvert.toCharArray();
            ConversionResult conversionResultTenthPlace =
                    convertDoubleDigitToWords(String.valueOf(digits[1]) + String.valueOf(digits[2]));
            if (conversionResultTenthPlace.getResultCode() == ConversionResult.ResultCode.FAIL)
                throw new RuntimeException("Failed to convert");
            ConversionResult conversionResultHundredPlace = convertSingleDigitToWords(String.valueOf(digits[0]));
            if (conversionResultHundredPlace.getResultCode() == ConversionResult.ResultCode.FAIL)
                throw new RuntimeException("Failed to convert");
            if (conversionResultHundredPlace.getResult().get(0).equals(Numbers.ZERO)) {
                result.setResult(
                        (conversionResultTenthPlace.getResult().get(0).equals(Numbers.NOTHING) ?
                                "" : DividersWS.SPACE) + conversionResultTenthPlace.getResult().get(0));
            } else {
                result.setResult(
                        conversionResultHundredPlace.getResult().get(0) + DividersWS.SPACE +
                                DividersWS.HUNDRED +
                                (conversionResultTenthPlace.getResult().get(0)
                                        .equals(Numbers.NOTHING) ? "" : DividersWS.SPACE) +
                                conversionResultTenthPlace.getResult().get(0));
            }
            result.setResultCode(ConversionResult.ResultCode.SUCCESS);
            return result;
        } catch (Exception e) {
            return new ConversionResult(ErrorMaster.FAILED_DURING_CONVERTING + numberToConvert,
                    ConversionResult.ResultCode.FAIL);
        }
    }

    /**
     * if the number is larger then 3 digit. then we have to divide it with comma to generate a
     * word representation.
     * this method will first divide the number with the appropriate places for comma and create a
     * word representation.
     * LOGIC-
     * ---------------------------------------------------------------------------------------------
     * divide by comma.
     * check if the number is completely zero, if so send a zero as result.
     * check if the number is larger then the max number of divider available for counting.
     * if YES then just strip the extra from the left side and send it to the function
     * proceedByDividingNumber(String numberToConvert) for its words representation.
     * after getting the word representation of the extra in the left, comma separate the rest to
     * right. and start the conversion.
     * if the number is only 2 parts when divided by "," then just do a simple word representation
     * that is separated from the rest logic (which is for the big number).
     * if the number is greater then 2 after dividing with "," then we are good to go for next loop.
     * there can be many ways in which a single number can be represented in words.
     * all those can be done by dividing the number by every comma place one at a time. and as much
     * as we can divide that number of representation can be retrieved for that same number.
     * ---------------------------------------------------------------------------------------------
     *
     * @param numberToConvert number to convert to words
     * @return word representation for the number
     */
    private ConversionResult proceedByDividingNumber(String numberToConvert) {
        String numberWithCommas = divideNumberWithCommas(numberToConvert);
        String[] commasDividedStringArray = numberWithCommas.split(",");
        boolean boolIsZero = true;
        for (String s :
                commasDividedStringArray) {
            if (Integer.parseInt(s) != 0) {
                boolIsZero = false;
                break;
            }
        }
        if (boolIsZero)
            return new ConversionResult(Numbers.ZERO, ConversionResult.ResultCode.SUCCESS);
        ConversionResult result = new ConversionResult();
        ConversionResult conversionResultTemp = new ConversionResult();
        result.setResultCode(ConversionResult.ResultCode.SUCCESS);
        if (commasDividedStringArray.length > DividersWS.MAX_DIVIDER_LIMIT) {
            String temp = "";
            String commasDividedStringTemp = "";
            int i;
            for (i = 0; i <= commasDividedStringArray.length - DividersWS.MAX_DIVIDER_LIMIT; i++) {
                temp = temp + commasDividedStringArray[i];
            }
            for (int j = i; j < commasDividedStringArray.length; j++) {
                commasDividedStringTemp = commasDividedStringTemp + commasDividedStringArray[j];
            }
            conversionResultTemp =
                    temp.length() == 1 ?
                            convertSingleDigitToWords(temp) : temp.length() == 2 ?
                            convertDoubleDigitToWords(temp) : temp.length() == 3 ?
                            convertThreeDigitToWord(temp) : proceedByDividingNumber(temp);
            numberWithCommas = divideNumberWithCommas(commasDividedStringTemp);
            commasDividedStringArray = numberWithCommas.split(",");
        }
        if (commasDividedStringArray.length == 2) {
            if (commasDividedStringArray[0].length() == 1) {
                if (conversionResultTemp.getResult().size() == 0) {
                    result.setResult(
                            convertSingleDigitToWords(
                                    commasDividedStringArray[0]).getResult().get(0) +
                                    DividersWS.SPACE +
                                    DividersWS.getDividerNameByPos(1) +
                                    DividersWS.SPACE +
                                    convertThreeDigitToWord(commasDividedStringArray[1]).getResult().get(0));
                } else {
                    for (int i = 0; i < conversionResultTemp.getResult().size(); i++) {
                        result.setResult(
                                conversionResultTemp.getResult().get(i) +
                                        DividersWS.SPACE +
                                        DividersWS.QUADRILLION +
                                        DividersWS.SPACE +
                                        convertSingleDigitToWords(
                                                commasDividedStringArray[0]).getResult().get(0) +
                                        DividersWS.SPACE +
                                        DividersWS.getDividerNameByPos(1) +
                                        DividersWS.SPACE +
                                        convertThreeDigitToWord(commasDividedStringArray[1]).getResult().get(0));
                    }
                }
            }
            if (commasDividedStringArray[0].length() == 2) {
                if (conversionResultTemp.getResult().size() == 0) {
                    result.setResult(
                            convertDoubleDigitToWords(commasDividedStringArray[0]).getResult().get(0) +
                                    DividersWS.SPACE +
                                    DividersWS.getDividerNameByPos(1) +
                                    DividersWS.SPACE +
                                    convertThreeDigitToWord(commasDividedStringArray[1]).getResult().get(0));
                } else {
                    for (int i = 0; i < conversionResultTemp.getResult().size(); i++) {
                        result.setResult(
                                convertDoubleDigitToWords(conversionResultTemp.getResult().get(i) +
                                        DividersWS.SPACE +
                                        DividersWS.QUADRILLION +
                                        DividersWS.SPACE +
                                        commasDividedStringArray[0]).getResult().get(0) +
                                        DividersWS.SPACE +
                                        DividersWS.getDividerNameByPos(1) +
                                        DividersWS.SPACE +
                                        convertThreeDigitToWord(commasDividedStringArray[1]).getResult().get(0));
                    }
                }
            }
            if (commasDividedStringArray[0].length() == 3) {
                if (conversionResultTemp.getResult().size() == 0) {
                    result.setResult(
                            convertThreeDigitToWord(
                                    commasDividedStringArray[0]).getResult().get(0) +
                                    DividersWS.SPACE +
                                    DividersWS.getDividerNameByPos(1) +
                                    DividersWS.SPACE +
                                    convertThreeDigitToWord(commasDividedStringArray[1]).getResult().get(0));
                } else {
                    for (int i = 0; i < conversionResultTemp.getResult().size(); i++) {
                        result.setResult(
                                conversionResultTemp.getResult().get(i) +
                                        DividersWS.SPACE +
                                        DividersWS.QUADRILLION +
                                        DividersWS.SPACE +
                                        convertThreeDigitToWord(commasDividedStringArray[0]).getResult().get(0) +
                                        DividersWS.SPACE +
                                        DividersWS.getDividerNameByPos(1) +
                                        DividersWS.SPACE +
                                        convertThreeDigitToWord(commasDividedStringArray[1]).getResult().get(0));
                    }
                }
            }
        } else {
            String strLeftSide = "";
            String strRightSide;
            for (int i = 0; i <= commasDividedStringArray.length - 2; i++) {
                strRightSide = "";
                strLeftSide = strLeftSide + commasDividedStringArray[i];
                for (int j = i + 1; j < commasDividedStringArray.length; j++) {
                    if (commasDividedStringArray[j].length() == 1) {
                        strRightSide =
                                strRightSide +
                                        (convertSingleDigitToWords(
                                                commasDividedStringArray[j]).getResult().get(0).equals(Numbers.ZERO) ?
                                                "" : convertSingleDigitToWords(commasDividedStringArray[j]).getResult().get(0) +
                                                DividersWS.SPACE +
                                                DividersWS.getDividerNameByPos(commasDividedStringArray.length - 1 - j) +
                                                DividersWS.SPACE);
                    } else if (commasDividedStringArray[j].length() == 2) {
                        strRightSide =
                                strRightSide +
                                        (convertDoubleDigitToWords(
                                                commasDividedStringArray[j]).getResult().get(0).equals(Numbers.NOTHING) ?
                                                "" : convertDoubleDigitToWords(commasDividedStringArray[j]).getResult().get(0) +
                                                DividersWS.SPACE +
                                                DividersWS.getDividerNameByPos(commasDividedStringArray.length - 1 - j) +
                                                DividersWS.SPACE);
                    } else if (commasDividedStringArray[j].length() == 3) {
                        strRightSide =
                                strRightSide +
                                        (convertThreeDigitToWord(
                                                commasDividedStringArray[j]).getResult().get(0).equals(Numbers.NOTHING) ?
                                                "" : convertThreeDigitToWord(commasDividedStringArray[j]).getResult().get(0) +
                                                (DividersWS.getDividerNameByPos(commasDividedStringArray.length - 1 - j)
                                                        .equals(DividersWS.NO_MORE_DEVIDER_AVAILABLE) ?
                                                        "" :
                                                        DividersWS.SPACE +
                                                                DividersWS.getDividerNameByPos(commasDividedStringArray.length - 1 - j) +
                                                                DividersWS.SPACE));
                    }
                }
                if (strLeftSide.length() > 3) {
                    ConversionResult conversionResult = new ConversionResult();
                    conversionResult.setResult(proceedByDividingNumber(strLeftSide).getResult());
                    for (int j = 0; j < conversionResult.getResult().size(); j++) {
                        if (conversionResultTemp.getResult().size() == 0) {
                            if (conversionResult.getResult().get(j).equals(Numbers.ZERO)) {
                                result.setResult(strRightSide);
                            } else {
                                result.setResult(
                                        conversionResult.getResult().get(j) +
                                                DividersWS.SPACE +
                                                DividersWS.getDividerNameByPos(commasDividedStringArray.length - 1 - i) +
                                                DividersWS.SPACE + strRightSide);
                            }
                        } else {
                            for (int k = 0; k < conversionResultTemp.getResult().size(); k++) {
                                result.setResult(
                                        conversionResultTemp.getResult().get(k) +
                                                DividersWS.SPACE +
                                                DividersWS.QUADRILLION +
                                                DividersWS.SPACE +
                                                (conversionResult.getResult().get(j).equals(Numbers.ZERO) ?
                                                        "" :
                                                        conversionResult.getResult().get(j) +
                                                                DividersWS.SPACE +
                                                                DividersWS.getDividerNameByPos(commasDividedStringArray.length - 1 - i) +
                                                                DividersWS.SPACE) + strRightSide);
                            }
                        }
                    }
                } else {
                    if (strLeftSide.length() == 1) {
                        if (conversionResultTemp.getResult().size() == 0) {
                            if (convertSingleDigitToWords(strLeftSide).getResult().get(0).equals(Numbers.ZERO)) {
                                result.setResult(strRightSide);
                            } else {
                                result.setResult(
                                        convertSingleDigitToWords(strLeftSide).getResult().get(0) +
                                                DividersWS.SPACE +
                                                DividersWS.getDividerNameByPos(commasDividedStringArray.length - 1 - i) +
                                                DividersWS.SPACE + strRightSide);
                            }
                        } else {
                            for (int k = 0; k < conversionResultTemp.getResult().size(); k++) {
                                if (convertSingleDigitToWords(strLeftSide).getResult().get(0).equals(Numbers.ZERO)) {
                                    result.setResult(
                                            conversionResultTemp.getResult().get(i) +
                                                    DividersWS.SPACE +
                                                    DividersWS.QUADRILLION + strRightSide);
                                } else {
                                    result.setResult(
                                            conversionResultTemp.getResult().get(i) +
                                                    DividersWS.SPACE +
                                                    DividersWS.QUADRILLION +
                                                    DividersWS.SPACE +
                                                    convertSingleDigitToWords(strLeftSide).getResult().get(0) +
                                                    DividersWS.SPACE +
                                                    DividersWS.getDividerNameByPos(commasDividedStringArray.length - 1 - i) +
                                                    DividersWS.SPACE + strRightSide);
                                }
                            }
                        }
                    }
                    if (strLeftSide.length() == 2) {
                        if (conversionResultTemp.getResult().size() == 0) {
                            if (convertDoubleDigitToWords(strLeftSide).getResult().get(0).equals(Numbers.NOTHING)) {
                                result.setResult(strRightSide);
                            } else {
                                result.setResult(
                                        convertDoubleDigitToWords(strLeftSide).getResult().get(0) +
                                                DividersWS.SPACE +
                                                DividersWS.getDividerNameByPos(commasDividedStringArray.length - 1 - i) +
                                                DividersWS.SPACE + strRightSide);
                            }
                        } else {
                            for (int k = 0; k < conversionResultTemp.getResult().size(); k++) {
                                if (convertDoubleDigitToWords(strLeftSide).getResult().get(0).equals(Numbers.NOTHING)) {
                                    result.setResult(conversionResultTemp.getResult().get(i) +
                                            DividersWS.SPACE +
                                            DividersWS.QUADRILLION +
                                            DividersWS.SPACE + strRightSide);
                                } else {
                                    result.setResult(
                                            conversionResultTemp.getResult().get(i) +
                                                    DividersWS.SPACE +
                                                    DividersWS.QUADRILLION +
                                                    DividersWS.SPACE +
                                                    convertDoubleDigitToWords(strLeftSide).getResult().get(0) +
                                                    DividersWS.SPACE +
                                                    DividersWS.getDividerNameByPos(commasDividedStringArray.length - 1 - i) +
                                                    DividersWS.SPACE + strRightSide);
                                }
                            }
                        }
                    }
                    if (strLeftSide.length() == 3) {
                        if (conversionResultTemp.getResult().size() == 0) {
                            if (convertThreeDigitToWord(strLeftSide).getResult().get(0).equals(Numbers.NOTHING)) {
                                result.setResult(strRightSide);
                            } else {
                                result.setResult(
                                        convertThreeDigitToWord(strLeftSide).getResult().get(0) +
                                                DividersWS.SPACE +
                                                DividersWS.getDividerNameByPos(commasDividedStringArray.length - 1 - i) +
                                                DividersWS.SPACE + strRightSide);
                            }
                        } else {
                            for (int k = 0; k < conversionResultTemp.getResult().size(); k++) {
                                if (convertThreeDigitToWord(strLeftSide).getResult().get(0).equals(Numbers.NOTHING)) {
                                    result.setResult(
                                            conversionResultTemp.getResult().get(i) +
                                                    DividersWS.SPACE +
                                                    DividersWS.QUADRILLION +
                                                    DividersWS.SPACE + strRightSide);
                                } else {
                                    result.setResult(
                                            conversionResultTemp.getResult().get(i) +
                                                    DividersWS.SPACE +
                                                    DividersWS.QUADRILLION +
                                                    DividersWS.SPACE +
                                                    convertThreeDigitToWord(strLeftSide).getResult().get(0) +
                                                    DividersWS.SPACE +
                                                    DividersWS.getDividerNameByPos(commasDividedStringArray.length - 1 - i) +
                                                    DividersWS.SPACE + strRightSide);
                                }
                            }
                        }
                    }
                }
            }
        }
        return result;
    }

    /**
     * method to divide the number with commas.
     * this will put a comma at the 3 digits from last and pass on the number to another function for
     * placing comma at every 4rd place from the last.
     *
     * @param numberToConvert number to place comma on
     * @return word representation
     */
    private String divideNumberWithCommas(String numberToConvert) {
        char[] digits = numberToConvert.toCharArray();
        ArrayList<String> digitsArraylist = new ArrayList<>();
        for (char c : digits) {
            digitsArraylist.add(String.valueOf(c));
        }
        digitsArraylist.add(digitsArraylist.size() - 3, DividersWS.COMMA);
        ArrayList<String> digitsWithComma = addDividerEverySecondPlace(digitsArraylist);
        String result = "";
        for (String s : digitsWithComma) {
            result = result + s;
        }
        return result;
    }

    /**
     * method to place comma at every 4rd place of the number.
     *
     * @param digitsArrayList number to put comma
     * @return comma separated number
     */
    private ArrayList<String> addDividerEverySecondPlace(ArrayList<String> digitsArrayList) {
        int leftMostComaPos = 0;
        for (int i = 0; i < digitsArrayList.size(); i++) {
            if (digitsArrayList.get(i).equals(DividersWS.COMMA)) {
                leftMostComaPos = i;
                break;
            }
        }
        if (leftMostComaPos <= 3)
            return digitsArrayList;
        digitsArrayList.add(leftMostComaPos - 3, DividersWS.COMMA);
        return addDividerEverySecondPlace(digitsArrayList);
    }

    /**
     * send result to the calling activity
     *
     * @param conversionResult conversion result object to send
     */
    private void sendResult(ConversionResult conversionResult) {
        ((CallbackConvertWS) context).conversionResultWS(conversionResult);
    }
}
