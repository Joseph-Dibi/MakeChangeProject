package com.skilldistillery.makechange;

import java.text.DecimalFormat;
import java.util.Scanner;

public class ChangeMaker {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		double cost = itemPrice(); //Asks item price
		System.out.println("$" + cost);

		moneyTendered(cost); //Takes price in and basically does the rest.
		//System.out.printf("\n" + "CHANGE OWED: %.2f%n"); <- potential format way

	}

//	private static double decimalFormatter(double num);{
//		double num1 = num;
//		new DecimalFormat("$#.00").format(num1);
//		
//		return num;
//		
//	}
	
	private static void moneyTendered(double cost) {
		System.out.println("How much did the customer pay you? ");
		double moneyPaid = sc.nextDouble();
		double moreMoney = 0;
		double change = 0;
		double dollar = 1;
		double quarter = .25;
		double dime = .10;
		double nickel = .05;
		double pennies = .01;
		double tenDollar = 10;
		double fiveDollar = 5;
		
		if (cost < moneyPaid) {
			System.out.println("You paid: $" + moneyPaid);
			change = moneyPaid - cost;
			//new DecimalFormat("$#.00").format(change);
			//I can't figure out the format for decimals. Try to fix formatter/try new one.
			System.out.println("Your change is $" + change);
			
			tenDollar = (int)Math.floor(change/tenDollar);
			fiveDollar = (int)Math.floor((change-(tenDollar*10))/fiveDollar);
			dollar = (int)Math.floor((change-(tenDollar*10)-(fiveDollar*5))/dollar);
			double changeLeft = change-(tenDollar*10)-(fiveDollar*5)-dollar;
			System.out.println("Your bills are: ");
			if (tenDollar > 1) {
				System.out.print("" + tenDollar + " ten dollar bills, ");
			} else if (tenDollar == 1) {
				System.out.print("1 ten dollar bill, ");
			}
			if (fiveDollar > 1) {
				System.out.print("" + fiveDollar + " five dollar bills, ");
			} else if (fiveDollar == 1) {
				System.out.print("1 five dollar bill, ");
			}
			if (dollar > 1) {
				System.out.print("and " + dollar + " dollars. ");
			} else if (dollar == 1) {
				System.out.print("and 1 Dollar. ");
			}
			System.out.println("Your coins are ");
			
			//going to split change from dollars and add other bills
			quarter = (int)Math.floor((changeLeft)/quarter);
			dime = (int)Math.floor((changeLeft-(quarter*.25))/dime);
			nickel = (int)Math.floor((changeLeft-(quarter*.25)-(dime*.1))/nickel);
			pennies = (int)Math.floor((changeLeft-(quarter*.25)-(dime*.1)-(nickel*.05))/pennies+.01);
			//tiny numbers go crazy. I think this happens because I am casting to ints.
			System.out.print("Your change today is ");
		
			if (quarter > 1) {
				System.out.print("" + quarter + " Quarters,");
			} else if (quarter == 1) {
				System.out.print(" one Quarter, ");
			}
			if (dime > 1) {
				System.out.print("" + dime + " dimes,");
			} else if(dime == 1) {
				System.out.print(" one Dime, ");
			}
			if (nickel > 1) {
				System.out.print("" + nickel + " Nickels,");
			} else if (nickel == 1) {
				System.out.print(" one Nickel, ");
			}
			if (pennies > 1) {
				System.out.println(" and " + pennies + " Pennies.");
			} else if (pennies == 1) {
				System.out.println("and one Penny!");
			}
			
			
			
			
			
			
			// if They need to pay more. Can flesh out later. functions for now.
		} else if (cost > moneyPaid) {
			moreMoney = Math.abs(moneyPaid - cost);
			System.out.println("I am sorry, but we need $" + moreMoney
					+ " to complete this transaction. Please pay the difference.");
			double addingCorrectChange = sc.nextDouble();

			while (!(cost == moneyPaid + addingCorrectChange)) {
				System.out.println("That is not the full amount, please pay the full amount.");
				addingCorrectChange = sc.nextDouble();
			}
			System.out.println("Thank you for paying the full amount.");
		} else {
			System.out.println("Thank you for paying the full amount, Have a nice day.");
		} //if customer pays the full amount the first time, we're done. I wish more customers were like this.

	}
//asks for cost of customers items, returns it. Works great. Only thing at this point ha
	private static double itemPrice() {
		double itemCost = 0;
		System.out.println("What was the cost of the customer's items today? ");
		itemCost = sc.nextDouble();

		return itemCost;
	}

}