package ua.kpi.dalgorithm.exceptions;

/**
 * Created on 01.04.2015
 *
 * @author Bohdan Vanchuhov
 */
public class FixedSizeException extends RuntimeException {
    public FixedSizeException() {
    }

    public FixedSizeException(String message) {
        super(message);
    }
}
