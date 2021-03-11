package com.wipro.controller;

import java.util.Scanner;

import com.wipro.customExcep.InvalidAmountException;
import com.wipro.serviceProvider.Airtel;
import com.wipro.serviceProvider.Idea;
import com.wipro.serviceProvider.Jio;
import com.wipro.serviceProvider.Vodafone;

public class TestPayTM {
	public static void main(String[] args) {
		int bal = 0;
		Scanner scn = new Scanner(System.in);
		int option;
		printMenu();
		option = scn.nextInt();

		while (option != 3) {

			if (option == 1) {
				bal += recharge(scn);
			} else if (option == 2)
				showBal(bal, scn);

			printMenu();
			option = scn.nextInt();
		}

		System.exit(0);
		scn.close();
	}

	private static void showBal(int bal, Scanner scn) {

		System.out.println("Your total balance is : " + bal);
		System.out.println("\n\n<<Enter 1 to show more details>>\n<<Enter 2 for Main Menu>>");
		int option = scn.nextInt();
		if (option == 1)
			detailBalance();
		else if (option == 2)
			return;
	}

	private static void detailBalance() {

		try {
			System.out.println("Transactions done on Jio \n");
			Jio.balEnquiry().forEach((mobNo, amt) -> {
				System.out.println("\tMobile no. " + mobNo + " -- Amt. Paid " + amt);
			});
		} catch (NullPointerException e) {
			System.out.println("\tNo transaction available");
		}
		try {
			System.out.println("Transactions done on Idea \n");
			Idea.balEnquiry().forEach((mobNo, amt) -> {
				System.out.println("\tMobile no. " + mobNo + " -- Amt. Paid " + amt);
			});
		} catch (NullPointerException e) {
			System.out.println("\tNo transaction available");
		}
		try {
			System.out.println("Transactions done on Vodafone \n");
			Vodafone.balEnquiry().forEach((mobNo, amt) -> {
				System.out.println("\tMobile no. " + mobNo + " -- Amt. Paid " + amt);
			});
		} catch (NullPointerException e) {
			System.out.println("\tNo transaction available");
		}
		try {
			System.out.println("Transactions done on Airtel \n");
			Airtel.balEnquiry().forEach((mobNo, amt) -> {
				System.out.println("\tMobile no. " + mobNo + " -- Amt. Paid " + amt);
			});
		} catch (NullPointerException e) {
			System.out.println("\tNo transaction available");
		}

	}

	private static void printMenu() {

		printPattern(100, "*");
		System.out.println();
		printPattern(5, "\t");
		System.out.println("<<Menu>>");
		printPattern(9, "\t");
		System.out.println("~~Choose an option");
		printPattern(5, "\t");
		System.out.println("1. Recharge a number");
		printPattern(5, "\t");
		System.out.println("2. Check Balance");
		printPattern(5, "\t");
		System.out.println("3. Exit");
		printPattern(100, "*");
		System.out.println();
	}

	private static void printPattern(int i, String pattern) {

		for (int j = 0; j < i; j++) {
			System.out.print(pattern);
		}
	}

	private static int recharge(Scanner scn) {

		System.out.println("Enter a 10 digit Mobile number");
		long mobNo = scn.nextLong();

		try {

			TestImplementation.validateMobileNumber(mobNo);
		} catch (InvalidAmountException e) {
			System.err.println(e.getMessage());
			System.out.println("Returning to Main Menu");
			return 0;
		}

		System.out.println("Choose your Service Provider\n\t->Jio\n\t->Airtel\n\t->Vodafone\n\t->Idea");
		String serviceProvider = scn.next();

		System.out.println("Choose a plan, by specifying the amount (in rupees)");
		int bal = 0;
		if (serviceProvider.equalsIgnoreCase("Jio")) {

			Jio jio = new Jio();
			jio.denomination();
			int amt = scn.nextInt();
			try {

				TestImplementation.recharge(jio, amt, mobNo);
				bal += amt;
			} catch (InvalidAmountException e) {
				System.err.println(e.getMessage());
				System.out.println("Returning to Main Menu");
				return 0;
			}
		}
		if (serviceProvider.equalsIgnoreCase("Idea")) {

			Idea idea = new Idea();
			idea.denomination();
			int amt = scn.nextInt();
			try {

				TestImplementation.recharge(idea, amt, mobNo);
				bal += amt;
			} catch (InvalidAmountException e) {
				System.err.println(e.getMessage());
				System.out.println("Returning to Main Menu");
				return 0;
			}
		}
		if (serviceProvider.equalsIgnoreCase("Airtel")) {

			Airtel airtel = new Airtel();
			airtel.denomination();
			int amt = scn.nextInt();
			try {

				TestImplementation.recharge(airtel, amt, mobNo);
				bal += amt;
			} catch (InvalidAmountException e) {
				System.err.println(e.getMessage());
				System.out.println("Returning to Main Menu");
				return 0;
			}

		} else if (serviceProvider.equalsIgnoreCase("Vodafone")) {

			Vodafone voda = new Vodafone();
			voda.denomination();
			int amt = scn.nextInt();
			try {

				TestImplementation.recharge(voda, amt, mobNo);
				bal += amt;
			} catch (InvalidAmountException e) {
				System.err.println(e.getMessage());
				System.out.println("Returning to Main Menu");
				return 0;
			}
		}
		return bal;
	}
}
