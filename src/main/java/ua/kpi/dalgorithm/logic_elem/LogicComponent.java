package ua.kpi.dalgorithm.logic_elem;

import ua.kpi.dalgorithm.signal.Signal;

/**
 * Created on 08.03.2015
 *
 * @author Bohdan Vanchuhov
 */
public interface LogicComponent {
    int getInputsQuantity();

    void setInputsQuantity(int inputsQuantity);

    boolean hasFault();

    Signal getFault();

    void setFault(Signal fault);

    void execute();

    Signal getOutput();
}
