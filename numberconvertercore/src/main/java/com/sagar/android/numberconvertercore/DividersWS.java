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
    private static final String QUADRILLION = "quadrillion";
    private static final String QUINTILLION = "quintillion";
    private static final String SEXTILLION = "sextillion";
    private static final String SEPTILLION = "septillion";
    private static final String OCTILLION = "octillion";
    private static final String NONILLION = "nonillion";
    private static final String DECILLION = "decillion";
    private static final String UNDECILLION = "undecillion";
    private static final String DUODECILLION = "duodecillion";
    private static final String TREDECILLION = "tredecillion";
    private static final String QUATTUORDECILLION = "quattuordecillion";
    private static final String QUINQUADECILLION = "quinquadecillion";
    private static final String SEDECILLION = "sedecillion";
    private static final String SEPTENDECILLION = "septendecillion";
    private static final String OCTODECILLION = "octodecillion";
    private static final String NOVENDECILLION = "novendecillion";
    private static final String VIGINTILLION = "vigintillion";
    private static final String UNVIGINTILLION = "unvigintillion";
    private static final String DUOVIGINTILLION = "duovigintillion";
    private static final String TRESVIGINTILLION = "tresvigintillion";
    private static final String QUATTUORVIGINTILLION = "quattuorvigintillion";
    private static final String QUINQUAVIGINTILLION = "quinquavigintillion";
    private static final String SESVIGINTILLION = "sesvigintillion";
    private static final String SEPTEMVIGINTILLION = "septemvigintillion";
    private static final String OCTOVIGINTILLION = "octovigintillion";
    private static final String NOVEMVIGINTILLION = "novemvigintillion";
    private static final String TRIGINTILLION = "trigintillion";
    private static final String UNTRIGINTILLION = "untrigintillion";
    private static final String DUOTRIGINTILLION = "duotrigintillion";
    private static final String TRESTRIGINTILLION = "trestrigintillion";
    private static final String QUATTUORTRIGINTILLION = "quattuortrigintillion";
    private static final String QUINQUATRIGINTILLION = "quinquatrigintillion";
    private static final String SESTRIGINTILLION = "sestrigintillion";
    private static final String SEPTENTRIGINTILLION = "septentrigintillion";
    private static final String OCTOTRIGINTILLION = "octotrigintillion";
    private static final String NOVENTRIGINTILLION = "noventrigintillion";
    private static final String QUADRAGINTILLION = "quadragintillion";
    private static final String QUINQUAGINTILLION = "quinquagintillion";
    private static final String SEXAGINTILLION = "sexagintillion";
    private static final String SEPTUAGINTILLION = "septuagintillion";
    private static final String OCTOGINTILLION = "octogintillion";
    private static final String NONAGINTILLION = "nonagintillion";
    private static final String CENTILLION = "centillion";
    private static final String UNCENTILLION = "uncentillion";
    private static final String DUOCENTILLION = "duocentillion";
    private static final String TRESCENTILLION = "trescentillion";
    private static final String DECICENTILLION = "decicentillion";
    private static final String UNDECICENTILLION = "undecicentillion";
    private static final String VIGINTICENTILLION = "viginticentillion";
    private static final String UNVIGINTICENTILLION = "unviginticentillion";
    private static final String TRIGINTACENTILLION = "trigintacentillion";
    private static final String QUADRAGINTACENTILLION = "quadragintacentillion";
    private static final String QUINQUAGINTACENTILLION = "quinquagintacentillion";
    private static final String SEXAGINTACENTILLION = "sexagintacentillion";
    private static final String SEPTUAGINTACENTILLION = "septuagintacentillion";
    private static final String OCTOGINTACENTILLION = "octogintacentillion";
    private static final String NONAGINTACENTILLION = "nonagintacentillion";
    private static final String DUCENTILLION = "ducentillion";
    private static final String TRECENTILLION = "trecentillion";
    private static final String QUADRINGENTILLION = "quadringentillion";
    private static final String QUINGENTILLION = "quingentillion";
    private static final String SESCENTILLION = "sescentillion";
    private static final String SEPTINGENTILLION = "septingentillion";
    private static final String OCTINGENTILLION = "octingentillion";
    private static final String NONGENTILLION = "nongentillion";
    static final String MILLINILLION = "millinillion";
    static final String NO_MORE_DEVIDER_AVAILABLE = "NO_MORE_DEVIDER_AVAILABLE";

    static final int MAX_DIVIDER_LIMIT = 70;

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
            case 6:
                return QUINTILLION;
            case 7:
                return SEXTILLION;
            case 8:
                return SEPTILLION;
            case 9:
                return OCTILLION;
            case 10:
                return NONILLION;
            case 11:
                return DECILLION;
            case 12:
                return UNDECILLION;
            case 13:
                return DUODECILLION;
            case 14:
                return TREDECILLION;
            case 15:
                return QUATTUORDECILLION;
            case 16:
                return QUINQUADECILLION;
            case 17:
                return SEDECILLION;
            case 18:
                return SEPTENDECILLION;
            case 19:
                return OCTODECILLION;
            case 20:
                return NOVENDECILLION;
            case 21:
                return VIGINTILLION;
            case 22:
                return UNVIGINTILLION;
            case 23:
                return DUOVIGINTILLION;
            case 24:
                return TRESVIGINTILLION;
            case 25:
                return QUATTUORVIGINTILLION;
            case 26:
                return QUINQUAVIGINTILLION;
            case 27:
                return SESVIGINTILLION;
            case 28:
                return SEPTEMVIGINTILLION;
            case 29:
                return OCTOVIGINTILLION;
            case 30:
                return NOVEMVIGINTILLION;
            case 31:
                return TRIGINTILLION;
            case 32:
                return UNTRIGINTILLION;
            case 33:
                return DUOTRIGINTILLION;
            case 34:
                return TRESTRIGINTILLION;
            case 35:
                return QUATTUORTRIGINTILLION;
            case 36:
                return QUINQUATRIGINTILLION;
            case 37:
                return SESTRIGINTILLION;
            case 38:
                return SEPTENTRIGINTILLION;
            case 39:
                return OCTOTRIGINTILLION;
            case 40:
                return NOVENTRIGINTILLION;
            case 41:
                return QUADRAGINTILLION;
            case 42:
                return QUINQUAGINTILLION;
            case 43:
                return SEXAGINTILLION;
            case 44:
                return SEPTUAGINTILLION;
            case 45:
                return OCTOGINTILLION;
            case 46:
                return NONAGINTILLION;
            case 47:
                return CENTILLION;
            case 48:
                return UNCENTILLION;
            case 49:
                return DUOCENTILLION;
            case 50:
                return TRESCENTILLION;
            case 51:
                return DECICENTILLION;
            case 52:
                return UNDECICENTILLION;
            case 53:
                return VIGINTICENTILLION;
            case 54:
                return UNVIGINTICENTILLION;
            case 55:
                return TRIGINTACENTILLION;
            case 56:
                return QUADRAGINTACENTILLION;
            case 57:
                return QUINQUAGINTACENTILLION;
            case 58:
                return SEXAGINTACENTILLION;
            case 59:
                return SEPTUAGINTACENTILLION;
            case 60:
                return OCTOGINTACENTILLION;
            case 61:
                return NONAGINTACENTILLION;
            case 62:
                return DUCENTILLION;
            case 63:
                return TRECENTILLION;
            case 64:
                return QUADRINGENTILLION;
            case 65:
                return QUINGENTILLION;
            case 66:
                return SESCENTILLION;
            case 67:
                return SEPTINGENTILLION;
            case 68:
                return OCTINGENTILLION;
            case 69:
                return NONGENTILLION;
            case 70:
                return MILLINILLION;
            default:
                return NO_MORE_DEVIDER_AVAILABLE;
        }
    }
}
