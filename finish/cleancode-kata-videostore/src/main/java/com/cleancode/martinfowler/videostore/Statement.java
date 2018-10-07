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

    public String getCustomerName() {
        return customerName;
    }

    public String generate() {
        initialize();
        String statementText = createHeader();

        statementText += createRentalLines();

        statementText += "You owed " + String.valueOf(totalAmount) + "\n";
        statementText += "You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points\n";


        return statementText;
    }

    private String createRentalLines() {
        String statementText = "";
        for (Rental rental : rentals) {
            double thisAmount = 0;

            // determines the amount for each line
            switch (rental.getMovie().getPriceCode()) {
                case Movie.REGULAR:
                    thisAmount += 2;
                    if (rental.getDaysRented() > 2)
                        thisAmount += (rental.getDaysRented() - 2) * 1.5;
                    break;
                case Movie.NEW_RELEASE:
                    thisAmount += rental.getDaysRented() * 3;
                    break;
                case Movie.CHILDRENS:
                    thisAmount += 1.5;
                    if (rental.getDaysRented() > 3)
                        thisAmount += (rental.getDaysRented() - 3) * 1.5;
                    break;
            }

            frequentRenterPoints++;

            if (rental.getMovie().getPriceCode() == Movie.NEW_RELEASE
                    && rental.getDaysRented() > 1)
                frequentRenterPoints++;

            statementText += "\t" + rental.getMovie().getTitle() + "\t"
                    + String.valueOf(thisAmount) + "\n";
            totalAmount += thisAmount;

        }
        return statementText;
    }

    private String createHeader() {
        return String.format("Rental Record for %s\n", customerName);
    }

    private void initialize() {
        totalAmount = 0;
        frequentRenterPoints = 0;
    }

    public double getTotal() {
        return totalAmount;
    }

    public int getFrequentRenterPoints() {
        return frequentRenterPoints;
    }
}