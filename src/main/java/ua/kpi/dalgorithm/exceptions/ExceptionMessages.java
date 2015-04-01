package ua.kpi.dalgorithm.exceptions;

/**
 * Created on 01.04.2015
 *
 * @author Bohdan Vanchuhov
 */
public final class ExceptionMessages {
    public static final String NAME_EXISTS_TEMPLATE = "The item with name \"%s\" exists";
    public static final String NAME_NOT_EXISTS_TEMPLATE = "The item with name \"%s\" does not exist";
    public static final String ILLEGAL_INDEX_TEMPLATE = "The item index should be in a range [0, %d], but actually is %d";
    public static final String SIGNAL_NOT_FAULT_TEMPLATE = "The signal %s is not fault";
    public static final String NO_OUTPUT = "Outputs are not existed";

    private ExceptionMessages() {
    }
}
