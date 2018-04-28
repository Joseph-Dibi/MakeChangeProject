package com.skilldistillery.makechange;

import java.util.Scanner;

public class MakeChangeApp {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		double cost = itemPrice();
		System.out.println("$" + cost);

		double cashPaid = moneyTendered(cost);
		System.out.println("$" + cashPaid);

	}

	private static double moneyTendered(double cost) {
		double moneyPaid = 0;
		System.out.println("How much did the customer pay you? ");
		
		moneyPaid = sc.nextDouble();
		
		return moneyPaid;
		
		
//		if (cost == moneyPaid) {
//			System.out.println("Thank you, that is correct change. Have a nice day.");
//		}
//		else if ( cost > moneyPaid) {
//			moreMoney = Math.abs(moneyPaid - cost);
//			System.out.println("I am sorry, but we need $" + moreMoney + " to complete this transaction. Please pay the difference.");
//			double addingCorrectChange = sc.nextDouble();
//			
//			while (!(cost == moneyPaid + addingCorrectChange)) {
//				System.out.println("That is not the full amount, please pay the full amount.");
//				addingCorrectChange = sc.nextDouble();
//			}
//			System.out.println("Thank you for paying the full amount. Have a nice day.");	
//		}
////		else {
//			changeToGive = moneyPaid - cost;
//			System.out.println("Thank you, your change is " + changeToGive);
//			for (int dollar = 0; dollar < changeToGive; dollar++) {
//				for (int quarter = 0; quarter < changeToGive; quarter++) {
//					for (int dime = 0; dime < changeToGive; dime++) {
//						for (int nickel = 0; nickel < changeToGive; nickel++) {
//							for (int pennies = 0; pennies < changeToGive; pennies++) {
//								if ( dollar + quarter + dime + nickel + pennies == changeToGive && 1.00*dollar + .25*quarter + .1*dime + .05*nickel + .01*pennies == changeToGive ) {
//									System.out.print(dollar + "\t" + quarter + "\t" + dime + "\t" + nickel + "\t" + pennies);
//									System.out.println("Is this printing?");
//								}
//							}
//						}
//					}
//				}
//			}
////
//		else {
//			double change = moneyPaid % cost;
//			System.out.println(moneyPaid);
//		}
//		return moreMoney;
	}

	private static double itemPrice() {
		double itemCost = 0;
		System.out.println("What was the cost of the customer's items today? ");
		itemCost = sc.nextDouble();

		return itemCost;
	}
	//// for ( int s = 1 ; s <= 100 ; s++ ) { for ( int g = 1 ; g <= 100 ; g++ ) {
	// for ( int c = 1 ; c <= 100 ; c++ ) {
	// if ( s+g+c == 100 && 10.00*s + 3.50*g + 0.50*c == 100.00 ) {
	// System.out.print( s + " sheep, " );
	// System.out.print( g + " goats, and " );
	// System.out.println( c + " chickens." );
}
