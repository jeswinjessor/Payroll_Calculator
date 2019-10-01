/*
 * Jeswin K Jessor
 * 991498429
 * Assignment 3 
 * 25-Nov-2018
 */
package paytime;

import java.util.Arrays;

public class Employee {

    public int[] empNumbers = {101, 103, 106, 109, 110, 113, 116, 118, 120};

    public int checkEmp(int empNum) {
        Arrays.sort(empNumbers);
        int checkEmp = Arrays.binarySearch(empNumbers, empNum);
        return checkEmp;
    }

    public double regularPay(double hoursWorked, double hourlyWage) {
        double weeklyPay = hoursWorked * hourlyWage;
        return weeklyPay;
    }

    public double regularTax(double weeklyPay) {
        double incomeTax;
        if (weeklyPay >= 0 && weeklyPay <= 300) {
            incomeTax = weeklyPay * 0.10;
            return incomeTax;
        } else if (weeklyPay >= 300.01 && weeklyPay <= 400.00) {
            incomeTax = weeklyPay * 0.12;
            return incomeTax;
        } else if (weeklyPay >= 400.01 && weeklyPay <= 500.00) {
            incomeTax = weeklyPay * 0.15;
            return incomeTax;
        } else {
            incomeTax = weeklyPay * 0.20;
            return incomeTax;
        }

    }

    public double netPay(double weeklyPay, double incomeTax) {

        double netPay = weeklyPay - incomeTax;
        return netPay;
    }

    public double overTimePay(double workedHours, double hourlyWage) {
        double overTimePay = (workedHours - 40) * (hourlyWage * 1.5);
        return overTimePay;
    }

    public double overTimeTax(double overTimePay) {
        double overTimeTax = overTimePay * 0.25;
        return overTimeTax;
    }

    public double overTimeNetPay(double overTimePay, double overTimeTax) {
        double overTimeNetPay = overTimePay - overTimeTax;
        return overTimeNetPay;
    }

    public double totalNetPay(double netPay, double overTimeNetPay) {
        double totalNetPay = netPay + overTimeNetPay;
        return totalNetPay;
    }
}
