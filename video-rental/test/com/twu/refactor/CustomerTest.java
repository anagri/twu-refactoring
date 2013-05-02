package com.twu.refactor;

import org.junit.Before;
import org.junit.Test;

import java.io.*;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class CustomerTest {

    private static final String DATA_PATH = "/data/";

    private Customer dinsdale = new Customer("Dinsdale Pirhana");

    private Movie python = new Movie("Monty Python and the Holy Grail", Movie.REGULAR);
    private Movie ran = new Movie("Ran", Movie.REGULAR);
    private Movie la = new Movie("LA Confidential", Movie.NEW_RELEASE);
    private Movie trek = new Movie("Star Trek 13.2", Movie.NEW_RELEASE);
    private Movie wallace = new Movie("Wallace and Gromit", Movie.CHILDRENS);

    @Before
    public void setUpData() {
        dinsdale.addRental(new Rental(python, 3));
        dinsdale.addRental(new Rental(ran, 1));
        dinsdale.addRental(new Rental(la, 2));
        dinsdale.addRental(new Rental(trek, 1));
        dinsdale.addRental(new Rental(wallace, 6));
    }

    @Test
    public void shouldOutputEmptyStatement() throws Exception {
        Customer customer = new Customer("Golden Shark");
        verifyOutput(customer.statement(), "outputEmpty.txt");
    }

    @Test
    public void shouldOutputCustomerStatement() throws Exception {
        verifyOutput(dinsdale.statement(), "output1.txt");
    }

    @Test
    public void shouldOutputChangedStatement() throws Exception {
        la.setPriceCode(Movie.REGULAR);
        verifyOutput(dinsdale.statement(), "outputChange.txt");
    }

    /*
    public void testHtml() throws Exception {
        verifyOutput("1st Output", "outputHtml.txt", dinsdale.htmlStatement());
    }
    */

    protected void verifyOutput(String actualValue, String fileName) throws IOException {
        String s = DATA_PATH + fileName;

        BufferedInputStream resource = new BufferedInputStream(getClass().getResourceAsStream(s));
        String output = slurp(resource, 1024);
        resource.close();

        BufferedReader expectedValues = new BufferedReader(new StringReader(output));
        BufferedReader actualValues = new BufferedReader(new StringReader(actualValue));
        String thisFileLine;
        while ((thisFileLine = expectedValues.readLine()) != null) {
            assertThat("in file: " + fileName, actualValues.readLine(), equalTo(thisFileLine));
        }
    }

    public String slurp(final InputStream is, final int bufferSize) {
        final char[] buffer = new char[bufferSize];
        final StringBuilder out = new StringBuilder();
        try {
            final Reader in = new InputStreamReader(is, "UTF-8");
            try {
                for (; ; ) {
                    int rsz = in.read(buffer, 0, buffer.length);
                    if (rsz < 0)
                        break;
                    out.append(buffer, 0, rsz);
                }
            } finally {
                in.close();
            }
        } catch (UnsupportedEncodingException ex) {
            /* ... */
        } catch (IOException ex) {
            /* ... */
        }
        return out.toString();
    }

}
