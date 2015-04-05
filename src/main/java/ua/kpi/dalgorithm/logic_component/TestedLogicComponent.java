package ua.kpi.dalgorithm.logic_component;

import ua.kpi.dalgorithm.signal.Signal;

import java.util.List;

/**
 * Created on 01.04.2015
 *
 * @author Bohdan Vanchuhov
 */
public interface TestedLogicComponent<RealType extends TestedLogicComponent> extends LogicComponent {
    List<TestedLogicComponent> getNextComponents();

    RealType addNextComponent(TestedLogicComponent nextComponent);

    Signal getUnimportantInput();

    RealType setOutput(Signal output);

    boolean hasFault();

    Signal getFault();

    RealType setFault(Signal fault);
}
