package ua.kpi.dalgorithm;

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
}
