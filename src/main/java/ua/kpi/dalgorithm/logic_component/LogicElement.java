package ua.kpi.dalgorithm.logic_component;

import ua.kpi.dalgorithm.signal.Signal;

/**
 * Created on 01.04.2015
 *
 * @author Bohdan Vanchuhov
 */
public interface LogicElement extends LogicComponent {
    void addInput(LogicComponent inputComponent);

    void addInput(Signal inputSignal);

    void setInput(int index, LogicComponent inputComponent);

    void setInput(int index, Signal inputSignal);

    boolean isLimitedInputs();
}
