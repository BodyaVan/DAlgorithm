package ua.kpi.dalgorithm;

import java.io.Serializable;

/**
 * Created on 09.11.2014
 *
 * @author Bohdan Vanchuhov
 */
public enum Signal implements Serializable {
    ZERO('0', 0),
    ONE('1', 1),
    D('D', -1),
    NOT_D('d', -1),
    UNDEFINED('-', -1);

    private char charRepresentation;
    private int intValue;

    Signal(char charRepresentation, int intValue) {
        this.charRepresentation = charRepresentation;
        this.intValue = intValue;
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
}
