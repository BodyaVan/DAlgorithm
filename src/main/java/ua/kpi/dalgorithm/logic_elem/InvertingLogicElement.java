package ua.kpi.dalgorithm.logic_elem;

import ua.kpi.dalgorithm.Signal;
import ua.kpi.dalgorithm.SignalMath;

/**
 * Created on 07.03.2015
 *
 * @author Bohdan Vanchuhov
 */
public abstract class InvertingLogicElement implements LogicElement {
    @Override
    public int execute(int... inputSignals) {
        LogicElement notInvertingLogicElement = getNotInvertingLogicElement();
        return inverse(notInvertingLogicElement.execute(inputSignals));
    }

    private int inverse(int signal) {
        return signal == 0 ? 1 : 0;
    }

    protected abstract LogicElement getNotInvertingLogicElement();

    @Override
    public Signal execute(Signal... inputSignals) {
        LogicElement notInvertingLogicElement = getNotInvertingLogicElement();
        return inverse(notInvertingLogicElement.execute(inputSignals));
    }

    private Signal inverse(Signal signal) {
        return SignalMath.not(signal);
    }
}
