package ua.kpi.dalgorithm.signal;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created on 08.03.2015
 *
 * @author Bohdan Vanchuhov
 */
public class SignalsWord implements Iterable<Signal> {
    private List<Signal> signals;

    private SignalsWord() {
    }

    public static SignalsWord parse(String s) {
        SignalsWord signalsWord = new SignalsWord();
        List<Signal> signals = parseIntoList(s);
        signalsWord.setSignals(signals);

        return signalsWord;
    }

    private static List<Signal> parseIntoList(String s) {
        List<Signal> signals = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            Signal currentSignal = Signal.valueOf(currentChar);
            signals.add(currentSignal);
        }

        return signals;
    }

    private void setSignals(List<Signal> signals) {
        this.signals = signals;
    }

    public int size() {
        return signals.size();
    }

    public Iterator<Signal> iterator() {
        return signals.iterator();
    }

    public Signal get(int index) {
        return signals.get(index);
    }

    public Signal set(int index, Signal element) {
        return signals.set(index, element);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Signal signal : signals) {
            stringBuilder.append(signal.toString());
        }
        return stringBuilder.toString();
    }

    public SignalsWord intersect(SignalsWord other) {
        checkSize(other);

        for (int i = 0; i < signals.size(); i++) {
            Signal newSignal = SignalMath.intersection(signals.get(i), other.signals.get(i));
            signals.set(i, newSignal);
        }

        return this;
    }

    private void checkSize(SignalsWord other) {
        if (other.signals.size() != signals.size()) {
            throw new IllegalArgumentException(
                    String.format("The sizes are not same. Expected %d, but actual is %d",
                            signals.size(), other.signals.size())
            );
        }
    }

    public void intersect(String s) {
        SignalsWord other = SignalsWord.parse(s);
        intersect(other);
    }
}
