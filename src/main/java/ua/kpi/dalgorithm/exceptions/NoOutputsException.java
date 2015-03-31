package ua.kpi.dalgorithm.exceptions;

/**
 * Created on 10.03.2015
 *
 * @author Bohdan Vanchuhov
 */
public class NoOutputsException extends RuntimeException {
    public NoOutputsException() {
    }

    public NoOutputsException(String message) {
        super(message);
    }
}
