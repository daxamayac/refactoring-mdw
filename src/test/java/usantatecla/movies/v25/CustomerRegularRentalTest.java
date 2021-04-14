package usantatecla.movies.v25;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CustomerRegularRentalTest {

    private final String customerName = "customerName";
    private final String movieName = "movieName";
    private Movie movie;

    @Before
    public void before() {
        movie = new MovieBuilder().title(movieName).regular().build();
    }

    @Test
    public void regularRental1DayTotalAmountTest() {
        Rental rental = new RentalBuilder().movie(movie).daysRented(1).build();
        Customer customer = new CustomerBuilder().name(customerName).rental(rental).build();
        String statement = customer.statement();

        assertEquals(2, new StatementDecompose(statement).getTotalAmount(), 0.000001);
    }


    @Test
    public void regularRental1DayFrequentRenterPointsTest() {
        Rental rental = new RentalBuilder().movie(movie).daysRented(1).build();
        Customer customer = new CustomerBuilder().name(customerName).rental(rental).build();
        String statement = customer.statement();

        assertEquals(1, new StatementDecompose(statement).getFrequentRenterPoints());
    }


    @Test
    public void regularRental2DayTotalAmountTest() {
        Rental rental = new RentalBuilder().movie(movie).daysRented(2).build();
        Customer customer = new CustomerBuilder().name(customerName).rental(rental).build();
        String statement = customer.statement();

        assertEquals(2, new StatementDecompose(statement).getTotalAmount(), 0.000001);
    }

    @Test
    public void regularRental2DayFrequentRenterPointsTest() {
        Rental rental = new RentalBuilder().movie(movie).daysRented(2).build();
        Customer customer = new CustomerBuilder().name(customerName).rental(rental).build();
        String statement = customer.statement();

        assertEquals(1, new StatementDecompose(statement).getFrequentRenterPoints());
    }


    @Test
    public void regularRental3DayTotalAmountTest() {
        Rental rental = new RentalBuilder().movie(movie).daysRented(3).build();
        Customer customer = new CustomerBuilder().name(customerName).rental(rental).build();
        String statement = customer.statement();

        assertEquals(3.5, new StatementDecompose(statement).getTotalAmount(), 0.000001);
    }

    @Test
    public void regularRental3DayFrequentRenterPointsTest() {
        Rental rental = new RentalBuilder().movie(movie).daysRented(3).build();
        Customer customer = new CustomerBuilder().name(customerName).rental(rental).build();
        String statement = customer.statement();

        assertEquals(1, new StatementDecompose(statement).getFrequentRenterPoints());
    }

}
