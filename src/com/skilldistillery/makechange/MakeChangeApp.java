package com.skilldistillery.makechange;

import java.util.Scanner;

public class MakeChangeApp {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		double cost = itemPrice();
		System.out.println("$" + cost);

		double difference = moneyTendered(cost);
		System.out.println(difference);
		

	}

	private static double moneyTendered(double cost) {
		System.out.println("How much did the customer pay you? ");
		double moneyPaid = sc.nextDouble();
		double moreMoney = 0;
		if (cost == moneyPaid) {
			System.out.println("Thank you, that is correct change. Have a nice day.");
		}
		else if ( cost > moneyPaid) {
			moreMoney = Math.abs(moneyPaid - cost);
			System.out.println("I am sorry, but we need $" + moreMoney + " to complete this transaction. Please pay the difference.");
			double addingCorrectChange = sc.nextDouble();
			
			while (!(cost == moneyPaid + addingCorrectChange)) {
				System.out.println("That is not the full amount, please pay the full amount.");
				addingCorrectChange = sc.nextDouble();
			}
			System.out.println("Thank you for paying the full amount.");	
		}
		else {
			System.out.println("I need to give change, this is a placeholder.");
		}
		return moreMoney;
	}

	private static double itemPrice() {
		double itemCost = 0;
		System.out.println("What was the cost of the customer's items today? ");
		itemCost = sc.nextDouble();

		return itemCost;
	}

}
