package ua.kpi.dalgorithm;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.is;
import static ua.kpi.dalgorithm.Signal.*;

/**
 * Created on 08.03.2015
 *
 * @author Bohdan Vanchuhov
 */
public class SignalsWordTest {
    private SignalsWord signalsWord;

    @Before
    public void setUp() throws Exception {
        signalsWord = SignalsWord.parse("01_d_D0");
    }

    @Test
    public void createListFromString() throws Exception {
        assertThat(signalsWord, is(hasItems(ZERO, ONE, UNDEFINED, NOT_D, UNDEFINED, D, ZERO)));
    }

    @Test
    public void testSize() throws Exception {
        assertThat(signalsWord.size(), is(7));
    }

    @Test
    public void testSetAndGet() throws Exception {
        signalsWord.set(3, D);
        assertThat(signalsWord.get(3), is(D));
    }

    @Test
    public void testToString() throws Exception {
        assertThat(signalsWord.toString(), is("01-d-D0"));
    }
}
