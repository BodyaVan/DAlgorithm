package ua.kpi.dalgorithm.logic_component;

import ua.kpi.dalgorithm.signal.Signal;

/**
 * Created on 08.03.2015
 *
 * @author Bohdan Vanchuhov
 */
public interface LogicComponent extends Identifiable {
    void execute();

    Signal getOutput();

    int getInputsQuantity();
    void setInputsQuantity(int inputsQuantity);
}
