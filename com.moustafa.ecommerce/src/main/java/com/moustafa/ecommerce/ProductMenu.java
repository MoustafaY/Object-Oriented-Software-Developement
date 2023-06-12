package com.moustafa.ecommerce;


public class ProductMenu extends UserInterface{
	
	
	public void openProductMenu(Product product) {
		int command;
		while((command = getCommand()) != 0) {
			switch(command) {
			case 1: changeProductQuantity(product);
					break;
			default:
				System.out.println("Please enter a number that within menu commands");
			}
		}
	}
	
	
	public void changeProductQuantity(Product product) {
		int quantity = getInt("Enter new product quantity: ");
		product.setQuantity(quantity);
		System.out.println(product);
	}
	

	@Override
	public void printMenu() {
		System.out.println("");
		System.out.println("Enter one of the following commands:");
		System.out.println("(1) Change product quantity.");
		System.out.println("(0) To exit product view.");
		System.out.println("");
		
	}
}