package com.skilldistillery.makechange;

import java.text.DecimalFormat;
import java.util.Scanner;

public class ChangeMaker {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		double cost = itemPrice(); //Asks item price
		System.out.println("$" + cost);

		moneyTendered(cost); //Takes price in
		//System.out.printf("\n" + "CHANGE OWED: %.2f%n");

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
		double dime = .1;
		double nickel = .05;
		double pennies = .01;
		
		if (cost < moneyPaid) {
			System.out.println("You paid: $" + moneyPaid);
			change = moneyPaid - cost;
			System.out.println("Your change is $" + change);
			dollar = (int)Math.floor(change/dollar);
			quarter = (int)Math.floor((change-dollar)/quarter);
			dime = (int)Math.floor((change-dollar-quarter)/dime);
			nickel = (int)Math.floor((change-dollar-quarter-dime)/nickel);
			pennies = (int)Math.floor((change-dollar-quarter-dime-nickel)/pennies);
			
			System.out.println("" + dollar + "\t" + quarter + "\t" + dime + "\t" + nickel + "\t" + pennies);
			
			
			
			
			
			
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
		}

	}

	private static double itemPrice() {
		double itemCost = 0;
		System.out.println("What was the cost of the customer's items today? ");
		itemCost = sc.nextDouble();

		return itemCost;
	}

}