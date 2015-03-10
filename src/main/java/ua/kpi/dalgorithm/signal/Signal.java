package ua.kpi.dalgorithm.signal;

import java.io.Serializable;

/**
 * Created on 09.11.2014
 *
 * @author Bohdan Vanchuhov
 */
public enum Signal implements Serializable {
    ZERO('0', 0, false),
    ONE('1', 1, false),
    D('D', -1, true),
    NOT_D('d', -1, true),
    UNDEFINED('-', -1, true);

    private char charRepresentation;
    private int intValue;
    private boolean isFault;

    Signal(char charRepresentation, int intValue, boolean isFault) {
        this.charRepresentation = charRepresentation;
        this.intValue = intValue;
        this.isFault = isFault;
    }

    public static Signal valueOf(char c) {
        if (c == ZERO.charRepresentation) return ZERO;
        if (c == ONE.charRepresentation) return ONE;
        if (c == D.charRepresentation) return D;
        if (c == NOT_D.charRepresentation) return NOT_D;
        return UNDEFINED;
    }

    public static Signal valueOf(int i) {
        if (i == ZERO.intValue) return ZERO;
        if (i == ONE.intValue) return ONE;
        return UNDEFINED;
    }

    public int intValue() {
        return intValue;
    }

    @Override
    public String toString() {
        return Character.toString(charRepresentation);
    }

    public boolean isFault() {
        return isFault;
    }
}
