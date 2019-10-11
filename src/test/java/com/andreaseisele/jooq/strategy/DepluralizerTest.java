package com.andreaseisele.jooq.strategy;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

import static com.google.common.truth.Truth.assertThat;

@RunWith(Parameterized.class)
public class DepluralizerTest {

    @Parameters(name = "{index}: ({0}) = {1}, success = {2}")
    public static Collection<Object[]> testTerms() {
        return Arrays.asList(new Object[][]{
                {"customers", "customer", true},
                {"orders", "order", true},
                {"ITEMS", "ITEMS", false},
                {"Sauerkraut", "Sauerkraut", false}
        });
    }

    private String term;
    private String expected;
    private boolean successful;

    public DepluralizerTest(String term, String expected, boolean successful) {
        this.term = term;
        this.expected = expected;
        this.successful = successful;
    }

    @Test
    public void depluralize() {
        String depluralized = Depluralizer.depluralize(term);

        assertThat(depluralized).isEqualTo(expected);

        if (successful) {
            assertThat(term).isNotEqualTo(depluralized);
        }
    }

}