package usantatecla.movies.v25;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CustomerNewReleaseRentalTest {

    private final String customerName = "customerName";
    private final String movieName = "movieName";
    private Movie movie;

    @Before
    public void before() {
        movie = new MovieBuilder().title(movieName).newRelease().build();
    }


    @Test
    public void newReleaseRental1DayTest() {
        Rental rental = new RentalBuilder().movie(movie).daysRented(1).build();
        Customer customer = new CustomerBuilder().name(customerName).rental(rental).build();
        String statement = customer.statement();
        assertEquals(3, new StatementDecompose(statement).getTotalAmount(), 0.000001);
        assertEquals(1, new StatementDecompose(statement).getFrequentRenterPoints());
    }


    @Test
    public void newReleaseRental2DayTest() {
        Rental rental = new RentalBuilder().movie(movie).daysRented(2).build();
        Customer customer = new CustomerBuilder().name(customerName).rental(rental).build();
        String statement = customer.statement();
        assertEquals(3, new StatementDecompose(statement).getTotalAmount(), 0.000001);
        assertEquals(2, new StatementDecompose(statement).getFrequentRenterPoints());
    }


    @Test
    public void newReleaseRental3DayTest() {
        Rental rental = new RentalBuilder().movie(movie).daysRented(3).build();
        Customer customer = new CustomerBuilder().name(customerName).rental(rental).build();
        String statement = customer.statement();
        assertEquals(3, new StatementDecompose(statement).getTotalAmount(), 0.000001);
        assertEquals(2, new StatementDecompose(statement).getFrequentRenterPoints());
    }


}
