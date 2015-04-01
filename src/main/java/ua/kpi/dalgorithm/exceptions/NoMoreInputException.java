package ua.kpi.dalgorithm.exceptions;

/**
 * Created on 01.04.2015
 *
 * @author Bohdan Vanchuhov
 */
public class NoMoreInputException extends RuntimeException {
    public NoMoreInputException() {
    }

    public NoMoreInputException(String message) {
        super(message);
    }
}
