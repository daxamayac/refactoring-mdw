package usantatecla.movies.v25;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CustomerChildrenRentalTest {

    String movieName = "movieName";
    String customerName = "customerName";
    private Movie movie;

    @Before
    public void before() {
        movie = new MovieBuilder().title(movieName).childrens().build();
    }

    @Test
    public void childrensRental1DayTest() {
        Rental rental = new RentalBuilder().movie(movie).daysRented(1).build();
        Customer customer = new CustomerBuilder().name(customerName).rental(rental).build();
        String statement = customer.statement();
        assertEquals(1.5, new StatementDecompose(statement).getTotalAmount(), 0.000001);
        assertEquals(1, new StatementDecompose(statement).getFrequentRenterPoints());
    }

    @Test
    public void childrensRental3DayTest() {
        Rental rental = new RentalBuilder().movie(movie).daysRented(3).build();
        Customer customer = new CustomerBuilder().name(customerName).rental(rental).build();
        String statement = customer.statement();
        assertEquals(1.5, new StatementDecompose(statement).getTotalAmount(), 0.000001);
        assertEquals(1, new StatementDecompose(statement).getFrequentRenterPoints());
    }

    @Test
    public void childrensRental4DayTest() {
        Rental rental = new RentalBuilder().movie(movie).daysRented(4).build();
        Customer customer = new CustomerBuilder().name(customerName).rental(rental).build();
        String statement = customer.statement();
        assertEquals(6.0, new StatementDecompose(statement).getTotalAmount(), 0.000001);
        assertEquals(1, new StatementDecompose(statement).getFrequentRenterPoints());

    }

}
