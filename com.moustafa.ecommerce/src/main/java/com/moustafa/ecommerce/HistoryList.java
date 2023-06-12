package com.moustafa.ecommerce;
import java.util.*;


public class HistoryList{
	private ArrayList<String> itemList;
	private ArrayList<ArrayList<String>> history;
	
	public HistoryList() {
		history = new ArrayList();
		itemList = new ArrayList();
	}
	
	
	public void addToHistory(String id, String name, int quantity, double price) {
		String currentItem = "Id: " + id + " Name: " + name + " Quantity: " + quantity + " Price: " + price;
		itemList.add(currentItem);
	}
	
	public void submitHistory() {
		history.add(itemList);
		itemList = null;
		itemList = new ArrayList();
	}
	
	
	public int getSize() {
		return history.size();
	}
	
	public void printHistory(String type) {
		System.out.println(type + " history: ");
		int count = 1;
		for(ArrayList<String> list : history) {
			System.out.println(type + " #" + String.valueOf(count));
			for(String item : list) {
				System.out.println(item);
			}
			System.out.println("");
			count++;
		}
		
		System.out.println("");
	}
}