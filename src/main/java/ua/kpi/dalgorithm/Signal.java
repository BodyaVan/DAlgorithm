package ua.kpi.dalgorithm;

import java.io.Serializable;

/**
 * Created on 09.11.2014
 *
 * @author Bohdan Vanchuhov
 */
public enum Signal implements Serializable {
    ZERO,
    ONE,
    NO_DIGIT;

    public static final char NO_DIGIT_CHAR = '-';
    public static final String NO_DIGIT_STRING = "-";

    public static Signal valueOf(char c) {
        switch (c) {
            case '0': return ZERO;
            case '1': return ONE;
            default:
                return NO_DIGIT;
        }
    }

    public static Signal valueOf(int i) {
        switch (i) {
            case 0: return ZERO;
            case 1: return ONE;
            default:
                return NO_DIGIT;
        }
    }

    public int intValue() {
        switch (this) {
            case ZERO: return 0;
            case ONE: return 1;
            case NO_DIGIT: return -1;
            default:
                assert false;
                return -1;
        }
    }

    @Override
    public String toString() {
        switch (this) {
            case ZERO: return "0";
            case ONE: return "1";
            case NO_DIGIT: return NO_DIGIT_STRING;
            default:
                assert false;
                return NO_DIGIT_STRING;
        }
    }
}
