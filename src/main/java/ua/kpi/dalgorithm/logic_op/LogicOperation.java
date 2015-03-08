package ua.kpi.dalgorithm.logic_op;

import ua.kpi.dalgorithm.Signal;

/**
 * Created on 07.03.2015
 *
 * @author Bohdan Vanchuhov
 */
public interface LogicOperation {
    int execute(int... inputSignals);
    Signal execute(Signal... inputSignals);

    Signal getUnimportantInput();
}
