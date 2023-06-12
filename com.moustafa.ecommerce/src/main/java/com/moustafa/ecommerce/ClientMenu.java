package com.moustafa.ecommerce;


public class ClientMenu extends UserInterface{
	
	public void openClientMenu(Client client) {
		int command;
		while((command = getCommand()) != 0) {
			switch(command) {
			case 1: changeClientName(client);
					break;
			case 2: getClientBalance(client);
					break;
			case 3: clientMakeTransaction(client);
					break;
			case 4: startClientOrder(client);
					break;
			case 5: printTransactionHistory(client);
					break;
			default:
				System.out.println("Please enter a number that within menu commands");
			}
		}
	}
	
	public void changeClientName(Client client) {
		String name = getInput("Enter new client name: ");
		client.setName(name);
		System.out.println(client);
	}
	
	public void getClientBalance(Client client) {
		System.out.println(client.getBalance());
	}
	
	
	public void startClientOrder(Client client) {
		String prompt;
		int quantity;
		boolean itemInOrder = false;
		while(true) {
			System.out.println("Here is the available products: ");
			System.out.println("");
			client.printWarehouseList();
			System.out.println("");
			prompt = getInput("Please enter Id of product you wish to order or (done) to submit your order: ");
			if(prompt.equalsIgnoreCase("done")) {
				break;
			}
			quantity = getInt("Enter the amount: ");
			System.out.println("");
			client.addToDeal(prompt, quantity);
			itemInOrder = true;
		}
		if(itemInOrder) {
			client.completeDeal();
		}
		
		
	}
	
	public void clientMakeTransaction(Client client) {
		double payment = clientPaymentPrompt();
		manager.creditClient(client, payment);
	}
	
	public double clientPaymentPrompt() {
		double payment = getInt("Enter payment amount: ");
		return payment;
	}
	
	public void printTransactionHistory(Client client) {
		client.printHistory();
	}

	@Override
	public void printMenu() {
		System.out.println("");
		System.out.println("Enter one of the following commands:");
		System.out.println("(1) Change your name.");
		System.out.println("(2) Get your balance.");
		System.out.println("(3) Make a transaction.");
		System.out.println("(4) Make an order.");
		System.out.println("(5) Print transaction history of client.");
		System.out.println("(0) To log out as client.");
		System.out.println("");
	}
	
}