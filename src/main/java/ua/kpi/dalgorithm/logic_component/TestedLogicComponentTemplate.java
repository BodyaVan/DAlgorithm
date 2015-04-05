package ua.kpi.dalgorithm.logic_component;

import ua.kpi.dalgorithm.signal.Signal;

import java.util.ArrayList;
import java.util.List;

import static ua.kpi.dalgorithm.exceptions.ExceptionMessages.SIGNAL_NOT_FAULT_TEMPLATE;

/**
 * Created on 05.04.2015
 *
 * @author Bohdan Vanchuhov
 */
public abstract class TestedLogicComponentTemplate<RealType extends TestedLogicComponent>
        implements TestedLogicComponent<RealType> {
    protected int index;
    protected String name;

    protected Signal fault;
    protected Signal output = Signal.UNDEFINED;

    protected List<TestedLogicComponent> nextComponents = new ArrayList<>();

    @Override
    public int getIndex() {
        return index;
    }

    @Override
    public void setIndex(int index) {
        this.index = index;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean hasFault() {
        return fault != null;
    }

    @Override
    public Signal getFault() {
        return fault;
    }

    @Override
    public RealType setFault(Signal signal) {
        checkIsFault(signal);
        this.fault = signal;

        return (RealType) this;
    }

    private void checkIsFault(Signal signal) {
        if (!signal.isFault()) {
            throw new IllegalArgumentException(String.format(SIGNAL_NOT_FAULT_TEMPLATE, signal));
        }
    }

    @Override
    public Signal getOutput() {
        if (hasFault()) return fault;
        return output;
    }

    @Override
    public RealType setOutput(Signal output) {
        this.output = output;
        return (RealType) this;
    }

    @Override
    public List<TestedLogicComponent> getNextComponents() {
        return nextComponents;
    }

    @Override
    public RealType addNextComponent(TestedLogicComponent nextComponent) {
        nextComponents.add(nextComponent);
        return (RealType) this;
    }
}
