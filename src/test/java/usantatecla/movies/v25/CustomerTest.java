package usantatecla.movies.v25;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CustomerTest {

    String customerName = "customerName";
    String movieName = "movieName";

    @Test
    public void withoutRentalsCustomerNameTest() {
        Customer customer = new CustomerBuilder().name(customerName).build();
        String statement = customer.statement();
        assertEquals(customer.getName(), new StatementDecompose(statement).getCustomerName());
    }

    @Test
    public void withoutRentalsMoviesTest() {
        Customer customer = new CustomerBuilder().name(customerName).build();
        String statement = customer.statement();
        assertEquals(0, new StatementDecompose(statement).getTotalAmount(),0.000001);
    }

    @Test
    public void withoutRentalsTotalAmountTest() {
        Customer customer = new CustomerBuilder().name(customerName).build();
        String statement = customer.statement();
        assertEquals("", new StatementDecompose(statement).getMovies());
    }

    @Test
    public void withoutRentalsFrequentRenterPointsTest() {
        Customer customer = new CustomerBuilder().name(customerName).build();
        String statement = customer.statement();
        assertEquals(0, new StatementDecompose(statement).getFrequentRenterPoints());
    }

    @Test
    public void regularRental1DayTest() {

        Movie movie = new MovieBuilder().title(movieName).regular().build();
        Rental rental = new RentalBuilder().movie(movie).daysRented(1).build();
        Customer customer = new CustomerBuilder().name(customerName).rental(rental).build();

        /* String statement = customer.statement();

        String result = new StatementBuilder().customerName(customerName).movie(movieName, 2)
                .totalAmount(2).frequentRenterPoints(1).build();
        assertEquals(result, statement);
         */

        assertEquals(customer.getName(), customerName);
        assertEquals(movie.getTitle(), movieName);
        assertEquals(rental.getDaysRented(), 1);
        assertEquals(rental.getMovie(), movie);
    }

    @Test
    public void regularRental2DayTest() {
        Movie movie = new MovieBuilder().title(movieName).regular().build();
        Rental rental = new RentalBuilder().movie(movie).daysRented(2).build();
        Customer customer = new CustomerBuilder().name(customerName).rental(rental).build();

        String statement = customer.statement();

        String result = new StatementBuilder().customerName(customerName).movie(movieName, 2)
                .totalAmount(2).frequentRenterPoints(1).build();
        assertEquals(result, statement);
    }

    @Test
    public void regularRental3DayTest() {

        Movie movie = new MovieBuilder().title(movieName).regular().build();
        Rental rental = new RentalBuilder().movie(movie).daysRented(3).build();
        Customer customer = new CustomerBuilder().name(customerName).rental(rental).build();

        String statement = customer.statement();

        String result = new StatementBuilder().customerName(customerName).movie(movieName, 3.5)
                .totalAmount(3.5).frequentRenterPoints(1).build();
        assertEquals(result, statement);
    }

    @Test
    public void newReleaseRental1DayTest() {

        Movie movie = new MovieBuilder().title(movieName).newRelease().build();
        Rental rental = new RentalBuilder().movie(movie).daysRented(1).build();
        Customer customer = new CustomerBuilder().name(customerName).rental(rental).build();

        String statement = customer.statement();

        String result = new StatementBuilder().customerName(customerName).movie(movieName, 3)
                .totalAmount(3).frequentRenterPoints(1).build();
        assertEquals(result, statement);
    }

    @Test
    public void newReleaseRental2DayTest() {

        Movie movie = new MovieBuilder().title(movieName).newRelease().build();
        Rental rental = new RentalBuilder().movie(movie).daysRented(2).build();
        Customer customer = new CustomerBuilder().name(customerName).rental(rental).build();

        String statement = customer.statement();

        String result = new StatementBuilder().customerName(customerName).movie(movieName, 3)
                .totalAmount(3).frequentRenterPoints(2).build();
        assertEquals(result, statement);
    }

    @Test
    public void newReleaseRental3DayTest() {

        Movie movie = new MovieBuilder().title(movieName).newRelease().build();
        Rental rental = new RentalBuilder().movie(movie).daysRented(3).build();
        Customer customer = new CustomerBuilder().name(customerName).rental(rental).build();

        String statement = customer.statement();

        String result = new StatementBuilder().customerName(customerName).movie(movieName, 3)
                .totalAmount(3).frequentRenterPoints(2).build();
        assertEquals(result, statement);
    }

    @Test
    public void childrensRental1DayTest() {

        Movie movie = new MovieBuilder().title(movieName).childrens().build();
        Rental rental = new RentalBuilder().movie(movie).daysRented(1).build();
        Customer customer = new CustomerBuilder().name(customerName).rental(rental).build();

        String statement = customer.statement();

        String result = new StatementBuilder().customerName(customerName).movie(movieName, 1.5)
                .totalAmount(1.5).frequentRenterPoints(1).build();
        assertEquals(result, statement);
    }

    @Test
    public void childrensRental3DayTest() {

        Movie movie = new MovieBuilder().title(movieName).childrens().build();
        Rental rental = new RentalBuilder().movie(movie).daysRented(3).build();
        Customer customer = new CustomerBuilder().name(customerName).rental(rental).build();

        String statement = customer.statement();

        String result = new StatementBuilder().customerName(customerName).movie(movieName, 1.5)
                .totalAmount(1.5).frequentRenterPoints(1).build();
        assertEquals(result, statement);
    }

    @Test
    public void childrensRental4DayTest() {

        Movie movie = new MovieBuilder().title(movieName).childrens().build();
        Rental rental = new RentalBuilder().movie(movie).daysRented(4).build();
        Customer customer = new CustomerBuilder().name(customerName).rental(rental).build();

        String statement = customer.statement();

        String result = new StatementBuilder().customerName(customerName).movie(movieName, 6)
                .totalAmount(6).frequentRenterPoints(1).build();
        assertEquals(result, statement);
    }

    @Test
    public void rentalTest() {
        String regularMovieName = "regularMovieName";
        Movie regularMovie = new MovieBuilder().title(regularMovieName).regular().build();
        Rental regularRental = new RentalBuilder().movie(regularMovie).daysRented(10).build();

        String newReleaseMovieName = "newReleaseMovieName";
        Movie newReleaseMovie = new MovieBuilder().title(newReleaseMovieName).newRelease().build();
        Rental newReleaseRental = new RentalBuilder().movie(newReleaseMovie).daysRented(10).build();

        String childrensMovieName = "childrensMovieName";
        Movie childrensMovie = new MovieBuilder().title(childrensMovieName).childrens().build();
        Rental childrensRental = new RentalBuilder().movie(childrensMovie).daysRented(10).build();

        Customer customer = new CustomerBuilder().name(customerName)
                .rental(regularRental).rental(newReleaseRental).rental(childrensRental).build();

        String statement = customer.statement();

        String result = new StatementBuilder().customerName(customerName)
                .movie(regularMovieName, 14).movie(newReleaseMovieName, 3).movie(childrensMovieName, 15)
                .totalAmount(32).frequentRenterPoints(4).build();

        assertEquals(result, statement);
    }


}
