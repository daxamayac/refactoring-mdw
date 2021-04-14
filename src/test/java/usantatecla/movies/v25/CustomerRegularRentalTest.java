package usantatecla.movies.v25;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class CustomerRegularRentalTest {

    String customerName = "customerName";
    String movieName = "movieName";


    @Test
    public void regularRental1DayTotalAmountTest() {
        String movieName = "movieName";
        Movie movie = new MovieBuilder().title(movieName).regular().build();
        Rental rental = new RentalBuilder().movie(movie).daysRented(1).build();
        String customerName = "customerName";
        Customer customer = new CustomerBuilder().name(customerName).rental(rental).build();

        String statement = customer.statement();

        assertEquals(2, new StatementDecompose(statement).getTotalAmount(),0.000001);
    }


    @Test
    public void regularRental1DayFrequentRenterPointsTest() {
        String movieName = "movieName";
        Movie movie = new MovieBuilder().title(movieName).regular().build();
        Rental rental = new RentalBuilder().movie(movie).daysRented(1).build();
        String customerName = "customerName";
        Customer customer = new CustomerBuilder().name(customerName).rental(rental).build();

        String statement = customer.statement();

        assertEquals(1, new StatementDecompose(statement).getFrequentRenterPoints());
    }



    @Test
    public void regularRental2DayTotalAmountTest() {
        Movie movie = new MovieBuilder().title(movieName).regular().build();
        Rental rental = new RentalBuilder().movie(movie).daysRented(2).build();
        Customer customer = new CustomerBuilder().name(customerName).rental(rental).build();

        String statement = customer.statement();
        assertEquals(2, new StatementDecompose(statement).getTotalAmount(),0.000001);
    }

    @Test
    public void regularRental2DayFrequentRenterPointsTest() {
        Movie movie = new MovieBuilder().title(movieName).regular().build();
        Rental rental = new RentalBuilder().movie(movie).daysRented(2).build();
        Customer customer = new CustomerBuilder().name(customerName).rental(rental).build();

        String statement = customer.statement();


        assertEquals(1, new StatementDecompose(statement).getFrequentRenterPoints());
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


}
