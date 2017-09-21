package com.sagar.android.numberconvertercore;

/**
 * Created by SAGAR on 9/19/2017.
 * divider for western counting system
 */

class DividersWS {
    static final String HUNDRED = "Hundred";
    static final String SPACE = " ";
    static final String COMMA = ",";
    private static final String THOUSAND = "thousand";
    private static final String MILLION = "million";
    private static final String BILLION = "billion";
    private static final String TRILLION = "trillion";
    static final String QUADRILLION = "quadrillion";
    static final String NO_MORE_DEVIDER_AVAILABLE = "NO_MORE_DEVIDER_AVAILABLE";

    static final int MAX_DIVIDER_LIMIT = 5;

    /**
     * get the proper divider for comma position from the right.
     *
     * @param position comma position fro left
     * @return divider name
     */
    static String getDividerNameByPos(int position) {
        switch (position) {
            case 1:
                return THOUSAND;
            case 2:
                return MILLION;
            case 3:
                return BILLION;
            case 4:
                return TRILLION;
            case 5:
                return QUADRILLION;
            default:
                return NO_MORE_DEVIDER_AVAILABLE;
        }
    }
}
