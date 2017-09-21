package com.sagar.android.numberconvertercore;

/**
 * Created by SAGAR on 9/19/2017.
 * dividers for indian counting system
 */

class DividersIND {
    static final String HUNDRED = "Hundred";
    static final String SPACE = " ";
    static final String COMMA = ",";
    private static final String THOUSAND = "thousand";
    private static final String LAKH = "lakh";
    private static final String CRORE = "crore";
    private static final String ARAB = "arab";
    private static final String KHARAB = "kharab";
    private static final String NEEL = "neel";
    private static final String PADMA = "padma";
    private static final String SANKH = "snkh";
    static final String MAHA_SANKH = "maha sankh";
    private static final String NO_MORE_DEVIDER_AVAILABLE = "NO_MORE_DEVIDER_AVAILABLE";

    static final int MAX_DIVIDER_LIMIT = 10;

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
                return LAKH;
            case 3:
                return CRORE;
            case 4:
                return ARAB;
            case 5:
                return KHARAB;
            case 6:
                return NEEL;
            case 7:
                return PADMA;
            case 8:
                return SANKH;
            case 9:
                return MAHA_SANKH;
            default:
                return NO_MORE_DEVIDER_AVAILABLE;
        }
    }
}
