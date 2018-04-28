package com.skilldistillery.makechange;

import java.util.Scanner;

public class ChangeMaker {


	public static void main(String[] args) {
		runProgram();

	}
//moneyTendered starts by initializing variable change amounts. 
	//change is also brought in from runProgram.
	private static void moneyTendered(double change) {

		double dollar = 1;
		double quarter = .25;
		double dime = .10;
		double nickel = .05;
		double pennies = .01;
		double tenDollar = 10;
		double fiveDollar = 5;
		double twentyDollar = 20;

		System.out.printf("Your Change: $ %.2f%n",change);
//these amount are then deducted from change if they are able to be divided at least once.
		//larger dollar amounts had to be reset to their value versus the amount before being deducted.
		twentyDollar = (int) Math.floor(change / twentyDollar);
		tenDollar = (int) Math.floor((change - (twentyDollar * 20)) / tenDollar);
		fiveDollar = (int) Math.floor((change - (twentyDollar * 20) - (tenDollar * 10)) / fiveDollar);
		dollar = (int) Math.floor((change - (twentyDollar * 20) - (tenDollar * 10) - (fiveDollar * 5)) / dollar);
		double changeLeft = change - (twentyDollar * 20) - (tenDollar * 10) - (fiveDollar * 5) - dollar;

		//this is so dollars only show if dollars are present
		if (tenDollar + fiveDollar + dollar + twentyDollar > 0) {
			System.out.print("Your bills are: ");
			if (twentyDollar > 1) {
				System.out.print("" + (int) twentyDollar + " twenty dollar bills, ");
			} else if (twentyDollar == 1) {
				System.out.print("1 twenty dollar bill, ");
			}
			if (tenDollar > 1) {
				System.out.print("" + (int) tenDollar + " ten dollar bills, ");
			} else if (tenDollar == 1) {
				System.out.print("1 ten dollar bill, ");
			}
			if (fiveDollar > 1) {
				System.out.print("" + (int) fiveDollar + " five dollar bills, ");
			} else if (fiveDollar == 1) {
				System.out.print("1 five dollar bill, ");
			}
			if (dollar > 1) {
				System.out.print((int) dollar + " dollars");
			} else if (dollar == 1) {
				System.out.print(" 1 Dollar");
			}
			System.out.println(".");
		}

		// coin change is split off dollars for simplicty and readibility, especially in adding larger dollars
		quarter = (int) Math.floor((changeLeft) / quarter);
		dime = (int) Math.floor((changeLeft - (quarter * .25)) / dime);
		nickel = (int) Math.floor((changeLeft - (quarter * .25) - (dime * .1)) / nickel);
		pennies = (int) Math.floor((changeLeft - (quarter * .25) - (dime * .1) - (nickel * .05)) / pennies + .01);
		// tiny numbers go crazy. I think this happens because I am casting to ints. 
		// this is fixed by the addition of .01. successful rounding of change before this may remove that need
		
		//this is so coins only show if coins are present
		if (changeLeft + quarter + dime + nickel + pennies > 0) {
			System.out.print("Your coins are:  ");
			if (quarter > 1) {
				System.out.print("" + (int) quarter + " Quarters,");
			} else if (quarter == 1) {
				System.out.print(" 1 Quarter, ");
			}
			if (dime > 1) {
				System.out.print("" + (int) dime + " dimes,");
			} else if (dime == 1) {
				System.out.print(" 1 Dime, ");
			}
			if (nickel > 1) {
				System.out.print("" + (int) nickel + " Nickels,");
			} else if (nickel == 1) {
				System.out.print(" 1 Nickel, ");
			}
			if (pennies > 1) {
				System.out.print((int) pennies + " Pennies");
			} else if (pennies == 1) {
				System.out.print(" 1 Penny");
			}
			System.out.println(".");
		}
	}

	//Run program asks the user for data input on item cost and amount they are paying.
	//if item cost > the cash they give the program will insist that they give the proper amount (You cant walk away without paying! you also can't choose not to buy it, but eh.)
	//if they pay exact change, the program finishes. regardless of it happened on one try or several.
	//if they pay over and need change then the moneyTendered program runs and they receive change.
	private static void runProgram() {
		double itemCost, moreMoney, moneyPaid, change = 0;
		Scanner sc = new Scanner(System.in);
		System.out.print("How much did your items cost? $");
		itemCost = sc.nextDouble();
		System.out.print("How much money are you going to give me? Keep in mind, I am excellent at making change. $");
		moneyPaid = sc.nextDouble();
		if (itemCost < moneyPaid) {
			System.out.printf("You paid: $ %.2f%n",moneyPaid);
			change = moneyPaid - itemCost;
			moneyTendered(change);
		} else if (itemCost > moneyPaid) {
			moreMoney = Math.abs(moneyPaid - itemCost);
			System.out.printf("I am sorry, but we need at least $ %.2f%n",moreMoney);
			System.out.print("$");
			double addingCorrectChange = sc.nextDouble();

			while (!(itemCost == moneyPaid + addingCorrectChange || itemCost < moneyPaid + addingCorrectChange)) {
				System.out.print("That is not the full amount, please pay at least the cost of the item.\n$");
				addingCorrectChange = sc.nextDouble();
			}

			if (itemCost == moneyPaid + addingCorrectChange) {
				System.out.println("You don't get a prize for paying exact change...");
			} else {
				System.out.printf("You paid: $ %.2f%n",moneyPaid+addingCorrectChange);
				change = moneyPaid + addingCorrectChange - itemCost;
				// call your tender method here
				moneyTendered(change);
			}
		} else {
			System.out.println("You don't get a prize for paying exact change...");
		}
		sc.close();
	}

}