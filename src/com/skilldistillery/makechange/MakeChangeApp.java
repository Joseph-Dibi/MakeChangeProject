package com.skilldistillery.makechange;

import java.util.Scanner;

public class MakeChangeApp {

	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		
		double cost = itemPrice();
		System.out.println(cost);
		
		
		
			
	}

	private static double itemPrice() {
		double itemCost = 0;
		System.out.println("What was the price of your items today? ");
		itemCost = sc.nextDouble();
		
		return itemCost;
	}

}
