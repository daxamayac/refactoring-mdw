package usantatecla.movies.v25;

import java.util.Arrays;
import java.util.stream.Collectors;

public class StatementDecompose {

    private String statement;

    public StatementDecompose(String statement) {
        this.statement = statement;
    }

    public String getCustomerName() {
        return this.statement
                .split("Rental Record for")[1]
                .split("\n")[0]
                .trim();
    }

    public String getMovies() {
        String[] statement = this.statement.split(("\n"));
        return Arrays.stream(statement)
                .filter(s -> s.startsWith("\t"))
                .map(s -> s.trim().replace("\t", ":"))
                .collect(Collectors.joining(";"));
    }

    public double getTotalAmount() {
        return Double.parseDouble(this.statement
                .split("Amount owed is")[1]
                .split("\n")[0]
                .trim());
    }

    public int getFrequentRenterPoints() {
        return Integer.parseInt(this.statement
                .split("You earned")[1]
                .split("frequent")[0]
                .trim());
    }
}
