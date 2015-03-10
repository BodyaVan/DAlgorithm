package ua.kpi.dalgorithm.automate;

import ua.kpi.dalgorithm.signal.Signal;
import ua.kpi.dalgorithm.logic_elem.InputComponent;
import ua.kpi.dalgorithm.logic_elem.LogicComponent;
import ua.kpi.dalgorithm.util.Util;

import java.util.List;

/**
 * Created on 10.03.2015
 *
 * @author Bohdan Vanchuhov
 */
public class Automate {
    private List<InputComponent> inputs;
    private List<LogicComponent> outputs;

    public int getInputsQuantity() {
        return inputs.size();
    }

    public void setInputsQuantity(int inputsQuantity) {
        inputs = Util.createConstructedList(inputsQuantity, InputComponent::new);
    }

    public int getOutputsQuantity() {
        return outputs.size();
    }

    public void setOutputsQuantity(int outputsQuantity) {
        outputs = Util.createFilledList(outputsQuantity, null);
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
        if (outputs == null) {
            throw new NoOutputsException("Outputs are not existed");
        }
    }

    public Signal getOutput(int outputIndex) {
        LogicComponent output = outputs.get(outputIndex);

        return output == null ? Signal.UNDEFINED : output.getOutput();
    }
}
