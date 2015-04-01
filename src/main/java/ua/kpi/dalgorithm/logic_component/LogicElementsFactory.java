package ua.kpi.dalgorithm.logic_component;

import ua.kpi.dalgorithm.logic_op.LogicOperations;

/**
 * Created on 30.03.2015
 *
 * @author Bohdan Vanchuhov
 */
public final class LogicElementsFactory {
    private LogicElementsFactory() {
    }

    public static LogicElement createAndLogicElement() {
        return new LogicElementImpl(LogicOperations.AND);
    }

    public static LogicElement createOrLogicElement() {
        return new LogicElementImpl(LogicOperations.OR);
    }

    public static LogicElement createNotAndLogicElement() {
        return new LogicElementImpl(LogicOperations.NOT_AND);
    }

    public static LogicElement createNotOrLogicElement() {
        return new LogicElementImpl(LogicOperations.NOT_OR);
    }

    public static LogicElement createAndLogicElement(int inputsQuantity) {
        return new LogicElementImpl(LogicOperations.AND, inputsQuantity);
    }

    public static LogicElement createOrLogicElement(int inputsQuantity) {
        return new LogicElementImpl(LogicOperations.OR, inputsQuantity);
    }

    public static LogicElement createNotAndLogicElement(int inputsQuantity) {
        return new LogicElementImpl(LogicOperations.NOT_AND, inputsQuantity);
    }

    public static LogicElement createNotOrLogicElement(int inputsQuantity) {
        return new LogicElementImpl(LogicOperations.NOT_OR, inputsQuantity);
    }
}
