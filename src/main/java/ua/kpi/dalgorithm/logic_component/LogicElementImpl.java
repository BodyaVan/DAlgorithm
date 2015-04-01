package ua.kpi.dalgorithm.logic_component;

import org.apache.commons.collections4.ListUtils;
import ua.kpi.dalgorithm.exceptions.NoMoreInputException;
import ua.kpi.dalgorithm.logic_op.LogicOperation;
import ua.kpi.dalgorithm.signal.Signal;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created on 08.03.2015
 *
 * @author Bohdan Vanchuhov
 */
public class LogicElementImpl implements LogicElement {
    private int index;

    private LogicOperation operation;

    private List<LogicComponent> inputs = new ArrayList<>();
    private int currentInputIndex = 0;
    private boolean isLimitedInputs = false;

    private Signal output = Signal.UNDEFINED;

    public LogicElementImpl(LogicOperation operation) {
        this.operation = operation;
    }

    public LogicElementImpl(LogicOperation operation, int inputsQuantity) {
        this.operation = operation;
        setInputsQuantity(inputsQuantity);
    }

    @Override
    public int getInputsQuantity() {
        return inputs.size();
    }

    @Override
    public void setInputsQuantity(int inputsQuantity) {
        checkInputsQuantity(inputsQuantity);

        inputs = ListUtils.fixedSizeList(
                ua.kpi.dalgorithm.util.ListUtils.createFilledList(inputsQuantity, null));
        isLimitedInputs = true;
    }

    private void checkInputsQuantity(int inputsQuantity) {
        if (inputsQuantity <= 0) {
            throw new IllegalArgumentException(
                    String.format("Inputs quantity should be positive, but actually %d", inputsQuantity));
        }
    }

    //--------------------------------------------------

    @Override
    public void execute() {
        List<Signal> inputSignals = inputs.stream().map(input -> {
            if (input == null) return Signal.UNDEFINED;

            input.execute();
            return input.getOutput();
        }).collect(Collectors.toList());

        output = operation.execute(inputSignals);
    }

    @Override
    public Signal getOutput() {
        return output;
    }

    @Override
    public void addInput(LogicComponent inputLogicComponent) {
        if (isLimitedInputs()) {
            addInputIfLimitedInputs(inputLogicComponent);
        } else {
            addInputIfUnlimitedInputs(inputLogicComponent);
        }
    }

    private void addInputIfLimitedInputs(LogicComponent inputLogicComponent) {
        checkHasFreeInput();

        inputs.set(currentInputIndex++, inputLogicComponent);
    }

    private void checkHasFreeInput() {
        if (currentInputIndex >= getInputsQuantity()) {
            throw new NoMoreInputException();
        }
    }

    private void addInputIfUnlimitedInputs(LogicComponent inputLogicComponent) {
        inputs.add(inputLogicComponent);
    }

    @Override
    public void addInput(Signal inputSignal) {
        InputComponent inputLogicComponent = new InputComponent(inputSignal);
        addInput(inputLogicComponent);
    }

    @Override
    public boolean isLimitedInputs() {
        return isLimitedInputs;
    }

    //--------------------------------------------------

    @Override
    public void setInput(int inputIndex, LogicComponent inputComponent) {
        checkInputIndex(inputIndex);

        inputs.set(inputIndex, inputComponent);
    }

    private void checkInputIndex(int inputIndex) {
        if (inputIndex < 0 || inputIndex >= getInputsQuantity()) {
            throw new IllegalArgumentException(
                    String.format("Input index should be in the range [0, %d], but actually is %d",
                            getInputsQuantity() - 1,
                            inputIndex));
        }
    }

    @Override
    public void setInput(int inputIndex, Signal inputSignal) {
        InputComponent inputComponent = new InputComponent(inputSignal);
        setInput(inputIndex, inputComponent);
    }

    //--------------------------------------------------

    @Override
    public int getIndex() {
        return index;
    }

    @Override
    public void setIndex(int index) {
        this.index = index;
    }
}
