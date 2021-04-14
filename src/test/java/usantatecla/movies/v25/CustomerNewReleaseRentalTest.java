package usantatecla.movies.v25;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CustomerNewReleaseRentalTest {

    @Test
    public void newReleaseRental1DayTest() {
        String movieName = "movieName";
        Movie movie = new MovieBuilder().title(movieName).newRelease().build();
        Rental rental = new RentalBuilder().movie(movie).daysRented(1).build();
        String customerName = "customerName";
        Customer customer = new CustomerBuilder().name(customerName).rental(rental).build();

        String statement = customer.statement();

        String result = new StatementBuilder().customerName(customerName).movie(movieName, 3)
                .totalAmount(3).frequentRenterPoints(1).build();
        assertEquals(result, statement);
    }

    @Test
    public void newReleaseRental2DayTest() {
        String movieName = "movieName";
        Movie movie = new MovieBuilder().title(movieName).newRelease().build();
        Rental rental = new RentalBuilder().movie(movie).daysRented(2).build();
        String customerName = "customerName";
        Customer customer = new CustomerBuilder().name(customerName).rental(rental).build();

        String statement = customer.statement();

        String result = new StatementBuilder().customerName(customerName).movie(movieName, 3)
                .totalAmount(3).frequentRenterPoints(2).build();
        assertEquals(result, statement);
    }

    @Test
    public void newReleaseRental3DayTest() {
        String movieName = "movieName";
        Movie movie = new MovieBuilder().title(movieName).newRelease().build();
        Rental rental = new RentalBuilder().movie(movie).daysRented(3).build();
        String customerName = "customerName";
        Customer customer = new CustomerBuilder().name(customerName).rental(rental).build();

        String statement = customer.statement();

        String result = new StatementBuilder().customerName(customerName).movie(movieName, 3)
                .totalAmount(3).frequentRenterPoints(2).build();
        assertEquals(result, statement);
    }
}
