package ua.kpi.dalgorithm.automate;

import com.sun.istack.internal.NotNull;
import ua.kpi.dalgorithm.exceptions.NoOutputsException;
import ua.kpi.dalgorithm.logic_component.InputComponent;
import ua.kpi.dalgorithm.logic_component.LogicComponent;
import ua.kpi.dalgorithm.logic_component.LogicElement;
import ua.kpi.dalgorithm.signal.Signal;

import java.util.List;

import static ua.kpi.dalgorithm.exceptions.ExceptionMessages.NO_OUTPUT;

/**
 * Created on 10.03.2015
 *
 * @author Bohdan Vanchuhov
 */
public class Automate {
    private IdentifiableNamedList<InputComponent> inputs = new IdentifiableNamedList<>(InputComponent::new);
    private IdentifiableNamedList<LogicElement> elements = new IdentifiableNamedList<>();
    private NamedList<LogicComponent> outputs = new NamedList<>();

    public Automate() {
    }

    public Automate(int inputsQuantity, int outputsQuantity) {
        setInputsQuantity(inputsQuantity);
        setOutputsQuantity(outputsQuantity);
    }

    public int getInputsQuantity() {
        return inputs.getSize();
    }

    public Automate setInputsQuantity(int inputsQuantity) {
        inputs.setSize(inputsQuantity);
        return this;
    }

    public int getOutputsQuantity() {
        return outputs.getSize();
    }

    public Automate setOutputsQuantity(int outputsQuantity) {
        outputs.setSize(outputsQuantity);
        return this;
    }

    public int getElementsQuantity() {
        return elements.getSize();
    }

    public Automate execute() {
        checkOutputs();

        for (LogicComponent output : outputs) {
            if (output != null) {
                output.execute();
            }
        }

        return this;
    }

    private void checkOutputs() {
        if (outputs.isEmpty()) {
            throw new NoOutputsException(NO_OUTPUT);
        }
    }

    //--------------------------------------------------

    public LogicElement getElement(int index) {
        return elements.get(index);
    }

    public LogicElement getElement(String name) {
        return elements.get(name);
    }

    public Signal getOutput(int index) {
        LogicComponent output = outputs.get(index);

        return output == null ? Signal.UNDEFINED : output.getOutput();
    }

    public Signal getOutput(String outputName) {
        int index = outputs.getIndexByName(outputName);

        return getOutput(index);
    }

    //--------------------------------------------------

    public int addElement(@NotNull LogicElement logicElement) {
        elements.add(logicElement);

        return getElementsQuantity() - 1;
    }

    public Automate addElement(@NotNull LogicElement element, String elementName) {
        elements.add(element, elementName);

        return this;
    }

    //--------------------------------------------------

    public Automate setInputName(int index, String name) {
        inputs.setName(index, name);
        return this;
    }

    public Automate setElementName(int index, String name) {
        elements.setName(index, name);
        return this;
    }

    public Automate setOutputName(int index, String name) {
        outputs.setName(index, name);
        return this;
    }

    //--------------------------------------------------

    public Automate bindInput(int inputIndex, int elementIndex) {
        InputComponent inputComponent = getInputComponent(inputIndex);
        LogicElement logicElement = getElement(elementIndex);

        logicElement.addInput(inputComponent);

        return this;
    }

    private InputComponent getInputComponent(int index) {
        return inputs.get(index);
    }

    public Automate bindInput(String inputName, String elementName) {
        InputComponent inputComponent = inputs.get(inputName);
        LogicElement element = elements.get(elementName);

        element.addInput(inputComponent);

        return this;
    }

    public Automate bindElements(int outElementIndex, int inElementIndex) {
        LogicElement outElement = elements.get(outElementIndex);
        LogicElement inElement = elements.get(inElementIndex);

        bindElements(inElement, outElement);

        return this;
    }

    public Automate bindElements(String outElementName, String inElementName) {
        LogicElement outElement = elements.get(outElementName);
        LogicElement inElement = elements.get(inElementName);

        bindElements(inElement, outElement);

        return this;
    }

    private void bindElements(LogicElement inElement, LogicElement outElement) {
        inElement.addInput(outElement);
    }

    public Automate bindOutput(int outputIndex, int elementIndex) {
        LogicElement logicElement = getElement(elementIndex);
        outputs.set(outputIndex, logicElement);

        return this;
    }

    public Automate bindOutput(String outputName, String elementName) {
        LogicElement element = elements.get(elementName);
        outputs.set(outputName, element);

        return this;
    }

    //--------------------------------------------------

    public Automate setInput(int inputIndex, Signal signal) {
        InputComponent inputComponent = getInputComponent(inputIndex);
        setInput(inputComponent, signal);

        return this;
    }

    public Automate setInput(String inputName, Signal signal) {
        InputComponent inputComponent = inputs.get(inputName);
        setInput(inputComponent, signal);

        return this;
    }

    private void setInput(InputComponent inputComponent, Signal signal) {
        inputComponent.setInput(signal);
    }

    //--------------------------------------------------

    public List<InputComponent> getInputs() {
        return inputs.getItems();
    }

    public List<LogicElement> getElements() {
        return elements.getItems();
    }

    public List<LogicComponent> getOutputs() {
        return outputs.getItems();
    }

    //--------------------------------------------------

    public List<String> getInputNames() {
        return inputs.getNames();
    }

    public List<String> getElementNames() {
        return elements.getNames();
    }

    public List<String> getOutputNames() {
        return outputs.getNames();
    }
}
