/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gas;

import java.util.Calendar;
import java.text.SimpleDateFormat;

/**
 *
 * @author the owner
 */
public class Action {

    String username;
    String Package;
    String duration;
    String discountCode;
    String paymentTerm;
//    String[] bronze = {"", "6", "", "5", "", "4", "", "3"};
//    String[] Silver = {"", "8", "", "7", "", "6", "", "5"};
//    String[] Gold = {"", "9.99", "", "8.99", "", "7.99", "", "6.99"};
//    String[] Package1 = {"Bronze", "Silver", "Gold"};
    double amount;
    double discount = 0.05;

    Action() {
        username = "";
        Package = "";
        duration = "";
        discountCode = "";
        duration = "";
        paymentTerm = "";
        amount = 0;

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPackage() {
        return Package;
    }

    public void setPackage(String Package) {
        this.Package = Package;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getDiscountCode() {
        return discountCode;
    }

    public void setDiscountCode(String discountCode) {
        this.discountCode = discountCode;
    }

    public String getPaymentTerm() {
        return paymentTerm;
    }

    public void setPaymentTerm(String paymentTerm) {
        this.paymentTerm = paymentTerm;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    /**
     *
     * @param pkg
     * @param duration
     * @return
     *
     * this method validate package and assign duration to each package
     */
    public double Validate(String pkg, String duration) {

        if (pkg.equalsIgnoreCase("Bronze")) {

            if (duration.equalsIgnoreCase("one")) {
                setAmount(6.00);

            } else if (duration.equalsIgnoreCase("three")) {
                setAmount(6.00 - 1.00);

            } else if (duration.equalsIgnoreCase("six")) {
                setAmount(6.00 - 2.00);

            } else if (duration.equalsIgnoreCase("twelve")) {

                setAmount(6.00 - 3.00);
            }

        } else if (getPackage().equalsIgnoreCase("Silver")) {

            if (duration.equalsIgnoreCase("one")) {
                setAmount(8.00);

            } else if (duration.equalsIgnoreCase("three")) {
                setAmount(8.00 - 1.00);

            } else if (duration.equalsIgnoreCase("six")) {
                setAmount(8.00 - 2.00);

            } else if (duration.equalsIgnoreCase("twelve")) {

                setAmount(8.00 - 3.00);
            }

        } else if (getPackage().equalsIgnoreCase("Gold")) {

            if (duration.equalsIgnoreCase("one")) {
                setAmount(9.99);

            } else if (duration.equalsIgnoreCase("three")) {
                setAmount(9.99 - 1.00);

            } else if (duration.equalsIgnoreCase("six")) {
                setAmount(9.99 - 2.00);

            } else if (duration.equalsIgnoreCase("twelve")) {

                setAmount(9.99 - 3.00);
            }

        } else {
            System.out.println("Not Available");

        }

        return amount;
    }

    //this methods checks if name length is greater or equal 25 
    public boolean NameValidation(String name) {

        if (name.length() <= 25) {
            return true;
        }
        return false;
    }

    /**
     *
     * @param payment
     * @return this method validate payment type
     */
    public boolean paymentTermVal(String payment) {
        if (paymentTerm.equalsIgnoreCase("one-off")) {

            return true;

        } else if (paymentTerm.equalsIgnoreCase("monthly")) {
            return false;
        }

        return false;
    }

    //this method checks the payment input and validate
    public boolean PackageVal(String payment) {
        if (Package.isEmpty()) {

            return false;

        }

        return true;
    }

    /**
     *
     * @param name
     * @param pkg
     * @param DiscountCode
     * @param term
     * @param duration
     * @param amount
     * @param date this method display Summary of Subscriptions
     */
    public void displaySummary(String name, String pkg, String DiscountCode, String term, String duration, double amount, String date) {
        System.out.println("+================================================================+");
        System.out.println("|                       |");
        System.out.println("| Customer: " + name + "   |");
        System.out.println("| Date: " + date + "      Discount code " + DiscountCode + "|");

        System.out.println("| Package: " + pkg + "         Duration: " + duration + "|");

        System.out.println("| Terms: " + term + "                            |");

        System.out.println("|           " + term + " : " + amount + "           |");
        System.out.println("+================================================================+");

    }

    //this function  helps to check if a string elment is present in an array
    public static boolean checkPackage(String[] my, String ele) {

        for (String s : my) {
            if (s.contains(ele)) {
                return true;
            }
        }
        return false;

    }

    Action ob() {
        return this;

    }

}
