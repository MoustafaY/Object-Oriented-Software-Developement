package com.moustafa.ecommerce;

import java.util.*;

import java.io.*;

public abstract class UserInterface{
	protected BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	protected Manager manager;
	
	public UserInterface() {
		manager = new Manager();
	}
	
	public int getInt(String prompt) {
		do {
			try {
				String input = getInput(prompt);
				Integer num = Integer.parseInt(input);
				return num.intValue();
			}catch(NumberFormatException nfe) {
				System.out.println("Please enter a number");
			}
		}while(true);
	}
	
	
	public String getInput(String prompt) {
		do {
			try {
				System.out.print(prompt);
				String line = reader.readLine();
				StringTokenizer tokenizer = new StringTokenizer(line, "\n\r\f");
				if(tokenizer.hasMoreTokens()) {
					return tokenizer.nextToken();
				}
			}catch(IOException ioe) {
				System.exit(0);
			}
		}while(true);
	}
	
	public int getCommand() {
		printMenu();
		do {
			try {
				int value = getInt("Enter command: ");
				System.out.println("");
				if(value >= 0) {
					return value;
				}
			}catch(NumberFormatException nfe) {
				System.out.print("Please enter a number");
			}
		}while(true);
	}
	
	public abstract void printMenu();
	
}