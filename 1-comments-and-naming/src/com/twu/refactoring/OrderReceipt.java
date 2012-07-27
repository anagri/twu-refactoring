package com.twu.refactoring;

/**
 * OrderReceipt prints the details of order including customer name, address, description, quantity,
 * price and amount. It also calculates the sales tax @ 10% and prints as part
 * of order. It computes the total order amount (amount of individual lineItems +
 * total sales tax) and prints it.
 */
public class OrderReceipt {
    private Order order;

    public OrderReceipt(Order order) {
        this.order = order;
    }

    public String printReceipt() {
        StringBuilder output = new StringBuilder();

        output.append(generateHeader());
        output.append(generateLineItemDetails());

        double totalSalesTax = 0d;
        double totalAmount = 0d;
        for (LineItem lineItem : order.getLineItems()) {
            // calculate sales tax @ rate of 10%
            double salesTax = lineItem.totalAmount() * .10;
            totalSalesTax += salesTax;

            // calculate total amount of lineItem = price * quantity + 10 % sales tax
            totalAmount += lineItem.totalAmount() + salesTax;
        }

        output.append("Sales Tax").append('\t').append(totalSalesTax);

        // print total amount
        output.append("Total Amount").append('\t').append(totalAmount);
        return output.toString();
    }

    private String generateLineItemDetails() {
        StringBuilder output = new StringBuilder();
        for (LineItem lineItem : order.getLineItems()) {
            output.append(lineItem.toString());
        }
        return output.toString();
    }

    private String generateHeader() {
        StringBuilder output = new StringBuilder();
        output.append("======Printing Orders======\n");
        output.append(order.getCustomerName());
        output.append(order.getCustomerAddress());
        return output.toString();
    }
}