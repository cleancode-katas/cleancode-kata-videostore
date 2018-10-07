package com.cleancode.martinfowler.videostore;

import java.util.ArrayList;
import java.util.List;

public class Statement {

    private String customerName;
    private List<Rental> rentals = new ArrayList<>();
    private double totalAmount;
    private int frequentRenterPoints;

    public Statement(String customerName) {
        this.customerName = customerName;
    }

    public void addRental(Rental rental) {
        rentals.add(rental);
    }

    public double getTotal() {
        return totalAmount;
    }

    public int getFrequentRenterPoints() {
        return frequentRenterPoints;
    }

    public String generate() {
        clearTotals();
        String statementText = createHeader();
        statementText += createRentalLines();
        statementText += createFooter();
        return statementText;
    }

    private void clearTotals() {
        totalAmount = 0;
        frequentRenterPoints = 0;
    }

    private String createHeader() {
        return String.format("Rental Record for %s\n", customerName);
    }

    private String createRentalLines() {
        String rentalLinesText = "";
        for (Rental rental : rentals) {
            rentalLinesText += createRentalLine(rental);
        }
        return rentalLinesText;
    }

    private String createRentalLine(Rental rental) {
        String rentalLineText = "";
        double rentalAmount = determineAmount(rental);

        frequentRenterPoints += determineFrequentRenterPoints(rental);

        rentalLineText += "\t" + rental.getMovie().getTitle() + "\t"
                + String.valueOf(rentalAmount) + "\n";
        totalAmount += rentalAmount;
        return rentalLineText;
    }

    private int determineFrequentRenterPoints(Rental rental) {
        if (rental.getMovie().getPriceCode() == Movie.NEW_RELEASE
                && rental.getDaysRented() > 1)
            return 2;

        return 1;
    }

    private double determineAmount(Rental rental) {
        double rentalAmount = 0;
        switch (rental.getMovie().getPriceCode()) {
            case Movie.REGULAR:
                rentalAmount += 2;
                if (rental.getDaysRented() > 2)
                    rentalAmount += (rental.getDaysRented() - 2) * 1.5;
                break;
            case Movie.NEW_RELEASE:
                rentalAmount += rental.getDaysRented() * 3;
                break;
            case Movie.CHILDRENS:
                rentalAmount += 1.5;
                if (rental.getDaysRented() > 3)
                    rentalAmount += (rental.getDaysRented() - 3) * 1.5;
                break;
        }
        return rentalAmount;
    }

    private String createFooter() {
        return String.format(
                "You owed %.1f\n" +
                        "You earned %d frequent renter points\n",
                totalAmount, frequentRenterPoints);
    }
}