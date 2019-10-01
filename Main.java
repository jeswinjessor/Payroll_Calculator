/*
 * Jeswin K Jessor
 * 991498429
 * Assignment 3 
 * 25-Nov-2018
 */
package paytime;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner k = new Scanner(System.in);
        DecimalFormat d = new DecimalFormat("$#,##0.00");

        System.out.print("Enter Y to process a worker or any other key to end: ");
        char enter = k.next().charAt(0);
        int tot = 0; //to calculate the total number of employees processed
        while (enter == 'y' || enter == 'Y') {

            Employee number = new Employee();

            System.out.print("Enter Employee Number: ");
            int empNum = k.nextInt();
            int checkEmp = number.checkEmp(empNum);

            while (checkEmp < 0) {
                System.out.println("Invalid! Enter Proper Employee Number: ");
                empNum = k.nextInt();
                checkEmp = number.checkEmp(empNum);
            }

            System.out.print("Enter First Name: ");
            String firstName = k.next();
            k.nextLine(); // to print a line. Will helps to take only the first word (if someone enter the whole name).

            System.out.print("Enter Last Name: ");
            String lastName = k.nextLine();

            System.out.print("Enter Hours Worked: ");
            double workedHours = k.nextDouble();
            while (workedHours < 0) {
                System.out.print("Negative Hours Not Allowed: ");
                workedHours = k.nextDouble();
            }

            System.out.print("Enter Hourly Wage: ");
            double hourlyWage = k.nextDouble();
            while (hourlyWage < 0) {
                System.out.print("Negative Hourly Wage Not Allowed: ");
                hourlyWage = k.nextDouble();
            }

            // <=40
            System.out.println("\nWorker " + empNum + " Paycheck Information: ");

            System.out.println("\tName: " + firstName + " " + lastName);
            double weeklyPay;
            if (workedHours > 40) {
                double regular = 40;
                weeklyPay = number.regularPay(regular, hourlyWage);
                String sWeeklyPay = d.format(weeklyPay);
                System.out.println("\tWeekly Pay is: " + sWeeklyPay);
            } else {
                weeklyPay = number.regularPay(workedHours, hourlyWage);
                String sWeeklyPay = d.format(weeklyPay);
                System.out.println("\tWeekly Pay is: " + sWeeklyPay);
            }
            double incomeTax = number.regularTax(weeklyPay);
            String sIncomeTax = d.format(incomeTax);
            System.out.println("\tIncome Taxes is: " + sIncomeTax);

            double netPay = number.netPay(weeklyPay, incomeTax);
            String sNetPay = d.format(netPay);
            System.out.println("\tNet Pay is: " + sNetPay);

            // >40
            while (workedHours > 40) {
                System.out.println("\nWorker " + empNum + " Overtime Calculation:");

                double overTimePay = number.overTimePay(workedHours, hourlyWage);
                String sOverTimePay = d.format(overTimePay);
                System.out.println("\tOvertime Pay is: " + sOverTimePay);

                double overTimeTax = number.overTimeTax(overTimePay);
                String sOverTimeTax = d.format(overTimeTax);
                System.out.println("\tOvertime Tax is: " + sOverTimeTax);

                double overTimeNetPay = number.overTimeNetPay(overTimePay, overTimeTax);
                String sOverTimeNetPay = d.format(overTimeNetPay);
                System.out.println("\tOvertime Netpay is: " + sOverTimeNetPay);

                double totalNetPay = number.totalNetPay(netPay, overTimeNetPay);
                String sTotalNetPay = d.format(totalNetPay);
                System.out.println("\tTotal Net Pay is: " + sTotalNetPay);

                workedHours = 0;
            }

            //end of >40
            System.out.print("\nEnter Y to process another worker or any other key to end: ");
            enter = k.next().charAt(0);
            tot++;

        }

        System.out.println("\nTotal number of employees processed : " + tot);
        System.out.println("End of Program.");
    }

}
