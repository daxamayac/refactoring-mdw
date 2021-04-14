package usantatecla.movies.v25;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CustomerWithoutRentalTest {

    String customerName = "customerName";
    private Customer customer;

    @Before
    public void before() {
        customer = new CustomerBuilder().name(customerName).build();
    }

    @Test
    public void withoutRentalsCustomerNameTest() {
        String statement = customer.statement();
        assertEquals(customer.getName(), new StatementDecompose(statement).getCustomerName());
    }

    @Test
    public void  withoutRentalsTotalAmountTest() {
        String statement = customer.statement();
        assertEquals(0, new StatementDecompose(statement).getTotalAmount(), 0.000001);
    }

    @Test
    public void withoutRentalsMoviesTest() {
        String statement = customer.statement();
        assertEquals("", new StatementDecompose(statement).getMovies());
    }

    @Test
    public void withoutRentalsFrequentRenterPointsTest() {
        String statement = customer.statement();
        assertEquals(0, new StatementDecompose(statement).getFrequentRenterPoints());
    }

    @Test
    public void withoutRentalsFormatStatementTest() {
        String statement = customer.statement();
        String result = new StatementBuilder().customerName(customerName)
                .totalAmount(0).frequentRenterPoints(0).build();
        assertEquals(result, statement);
    }

}
