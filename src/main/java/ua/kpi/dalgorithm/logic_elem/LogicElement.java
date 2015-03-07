package ua.kpi.dalgorithm.logic_elem;

import ua.kpi.dalgorithm.Signal;

/**
 * Created on 07.03.2015
 *
 * @author Bohdan Vanchuhov
 */
public interface LogicElement {
    int execute(int... inputSignals);
    Signal execute(Signal... inputSignals);
}
