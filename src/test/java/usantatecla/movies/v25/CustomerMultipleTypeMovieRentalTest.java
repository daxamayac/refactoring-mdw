package usantatecla.movies.v25;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class CustomerMultipleTypeMovieRentalTest {

    String customerName = "customerName";
    String movieName = "movieName";


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
