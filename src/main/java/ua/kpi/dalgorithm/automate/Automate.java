package ua.kpi.dalgorithm.automate;

import ua.kpi.dalgorithm.exceptions.NoOutputsException;
import ua.kpi.dalgorithm.logic_component.InputComponent;
import ua.kpi.dalgorithm.logic_component.LogicComponent;
import ua.kpi.dalgorithm.logic_component.LogicElement;
import ua.kpi.dalgorithm.signal.Signal;
import ua.kpi.dalgorithm.util.ListUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on 10.03.2015
 *
 * @author Bohdan Vanchuhov
 */
public class Automate {
    private List<InputComponent> inputs;
    private List<LogicComponent> outputs;

    private List<LogicElement> logicElements = new ArrayList<>();

    public Automate() {
    }

    public Automate(int inputsQuantity, int outputsQuantity) {
        setInputsQuantity(inputsQuantity);
        setOutputsQuantity(outputsQuantity);
    }

    public int getInputsQuantity() {
        return inputs.size();
    }

    public void setInputsQuantity(int inputsQuantity) {
        inputs = org.apache.commons.collections4.ListUtils.fixedSizeList(
                ListUtils.createConstructedList(inputsQuantity, InputComponent::new));
    }

    public int getOutputsQuantity() {
        return outputs.size();
    }

    public void setOutputsQuantity(int outputsQuantity) {
        outputs = org.apache.commons.collections4.ListUtils.fixedSizeList(
                ListUtils.createFilledList(outputsQuantity, null));
    }

    public void execute() {
        checkOutputs();

        for (LogicComponent output : outputs) {
            if (output != null) {
                output.execute();
            }
        }
    }

    private void checkOutputs() {
        if (outputs == null || outputs.isEmpty()) {
            throw new NoOutputsException("Outputs are not existed");
        }
    }

    public Signal getOutput(int outputIndex) {
        LogicComponent output = outputs.get(outputIndex);

        return output == null ? Signal.UNDEFINED : output.getOutput();
    }

    public int addLogicElement(LogicElement logicElement) {
        logicElements.add(logicElement);

        return getLogicElementsQuantity() - 1;
    }

    public int getLogicElementsQuantity() {
        return logicElements.size();
    }

    public LogicElement getLogicElement(int index) {
        return logicElements.get(index);
    }

    public Automate bindInput(int inputIndex, int logicElementIndex) {
        InputComponent inputComponent = getInputComponent(inputIndex);
        LogicElement logicElement = getLogicElement(logicElementIndex);

        logicElement.addInput(inputComponent);

        return this;
    }

    private InputComponent getInputComponent(int index) {
        return inputs.get(index);
    }

    public Automate bindOutput(int outputIndex, int elementIndex) {
        LogicElement logicElement = getLogicElement(elementIndex);

        outputs.set(outputIndex, logicElement);

        return this;
    }

    public Automate setInput(int inputIndex, Signal signal) {
        InputComponent inputComponent = getInputComponent(inputIndex);
        inputComponent.setInput(signal);

        return this;
    }

    public Automate bindLogicElements(int outElementIndex, int inElementIndex) {
        checkElementIndex(outElementIndex);
        checkElementIndex(inElementIndex);

        LogicElement outElement = logicElements.get(outElementIndex);
        LogicElement inElement = logicElements.get(inElementIndex);

        inElement.addInput(outElement);

        return this;
    }

    private void checkElementIndex(int elementIndex) {
        if (elementIndex < 0 && elementIndex >= logicElements.size()) {
            throw new ArrayIndexOutOfBoundsException(String.format(
                    "Element index should be in the range [0, %d], but actually is",
                    logicElements.size() - 1,
                    elementIndex));
        }
    }
}
