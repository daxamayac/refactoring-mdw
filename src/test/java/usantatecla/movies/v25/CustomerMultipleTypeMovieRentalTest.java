package usantatecla.movies.v25;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CustomerMultipleTypeMovieRentalTest {

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

        String customerName = "customerName";
        Customer customer = new CustomerBuilder().name(customerName)
                .rental(regularRental).rental(newReleaseRental).rental(childrensRental).build();

        String statement = customer.statement();

        assertEquals(32, new StatementDecompose(statement).getTotalAmount(), 0.000001);
        assertEquals(4, new StatementDecompose(statement).getFrequentRenterPoints());
    }
}
