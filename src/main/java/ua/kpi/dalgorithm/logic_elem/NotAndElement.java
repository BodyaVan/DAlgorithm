package ua.kpi.dalgorithm.logic_elem;

/**
 * Created on 07.03.2015
 *
 * @author Bohdan Vanchuhov
 */
public class NotAndElement extends InvertingLogicElement {
    @Override
    protected LogicElement getNotInvertingLogicElement() {
        return LogicElements.AND;
    }
}
