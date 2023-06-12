package com.moustafa.ecommerce;

public class StartMenu extends UserInterface{
	ClientMenu clientMenu;
	SupplierMenu supplierMenu;
	
	public StartMenu() {
		clientMenu = new ClientMenu();
		supplierMenu = new SupplierMenu();
	}
	
	public void openStartMenu() {
		int command;
		while((command = getCommand()) != 0) {
			switch(command) {
			case 1: createClient();
					break;
			case 2: createSupplier();
					break;
			case 3: logInClient();
					break;
			case 4: logInSupplier();
					break;
			case 5: printClients();
					break;
			case 6: printUnpaidClients();
					break;
			case 7: printSuppliers();
					break;
			default:
				System.out.println("Please enter a number that within menu commands");
			}
		}
	}
	
	
	public void createClient() {
		String name = getInput("Enter name of new client: ");
		Object client = manager.createObject("client", name);
		System.out.println(client);
	}
	
	public void createSupplier() {
		String name = getInput("Enter name of new supplier: ");
		Object product = manager.createObject("supplier", name);
		System.out.println(product);
	}
	
	public void logInClient() {
		String id = getInput("Enter Id of client: ");
		Object obj = manager.getObject(id);
		System.out.println(obj);
		if(obj.isNul()) {
			return;
		}
		Client client = (Client) obj;
		clientMenu.openClientMenu(client);
	}
	
	
	public void logInSupplier() {
		String id = getInput("Enter Id of supplier: ");
		Object obj = manager.getObject(id);
		System.out.println(obj);
		if(obj.isNul()) {
			return;
		}
		Supplier supplier = (Supplier) obj;
		supplierMenu.openSupplierMenu(supplier);
	}
	
	public void printClients() {
		manager.printList("client");
	}
	
	public void printUnpaidClients() {
		manager.printUnpaidClients();
	}
	
	public void printSuppliers() {
		manager.printList("supplier");
	}


	@Override
	public void printMenu() {
		System.out.println("");
		System.out.println("Enter one of the following commands:");
		System.out.println("(1) Create a new client.");
		System.out.println("(2) Create a new supplier.");
		System.out.println("(3) Log in as a client.");
		System.out.println("(4) Log in as a supplier.");
		System.out.println("(5) Print existing clients.");
		System.out.println("(6) Print clients with unpaid balances.");
		System.out.println("(7) Print existing suppliers.");
		System.out.println("(0) To close simulator.");
		System.out.println("");
		
	}
}