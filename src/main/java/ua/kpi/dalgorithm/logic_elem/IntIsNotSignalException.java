package ua.kpi.dalgorithm.logic_elem;

/**
 * Created on 07.03.2015
 *
 * @author Bohdan Vanchuhov
 */
public class IntIsNotSignalException extends RuntimeException {
    public IntIsNotSignalException() {
    }

    public IntIsNotSignalException(String message) {
        super(message);
    }
}
