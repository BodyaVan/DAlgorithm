package ua.kpi.dalgorithm;

import static ua.kpi.dalgorithm.Signal.*;

/**
 * Created on 07.03.2015
 *
 * @author Bohdan Vanchuhov
 */
public final class SignalMath {
    private SignalMath() {}

    public static Signal and(Signal s1, Signal s2) {
        if (s1 == ZERO || s2 == ZERO) {
            return ZERO;
        }
        return ONE;
    }

    public static Signal or(Signal s1, Signal s2) {
        if (s1 == ONE || s2 == ONE) {
            return ONE;
        }
        return ZERO;
    }

    public static Signal not(Signal s) {
        if (s == ZERO) {
            return ONE;
        }
        return ZERO;
    }
}
