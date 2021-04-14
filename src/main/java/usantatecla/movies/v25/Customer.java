package usantatecla.movies.v25;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Customer {

    private String name;

    private List<Rental> rentals;

    public Customer(String name) {
        this.name = name;
        rentals = new ArrayList<Rental>();
    }

    public void addRental(Rental rental) {
        rentals.add(rental);
    }

    public String getName() {
        return name;
    }

    public String statement() {
        return "Rental Record for " + this.getName() + "\n" +
                this.rentals.stream()
                        .map(rent -> "\t" + rent.getTitle() + "\t" + String.valueOf(rent.getCharge()) + "\n")
                        .collect(Collectors.joining()) +
                "Amount owed is " + String.valueOf(this.getTotalCharge()) + "\n" +
                "You earned " + String.valueOf(this.getTotalFrequentRenterPoints()) + " frequent renter points";
    }

    private double getTotalCharge() {
        return this.rentals.stream()
                .mapToDouble(Rental::getCharge)
                .sum();
    }

    private int getTotalFrequentRenterPoints() {
        return this.rentals.stream()
                .mapToInt(Rental::getFrequentRenterPoints)
                .sum();
    }
}
