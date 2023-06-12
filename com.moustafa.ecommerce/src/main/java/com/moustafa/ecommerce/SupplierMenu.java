package com.moustafa.ecommerce;


public class SupplierMenu extends UserInterface{
	
	ProductMenu productMenu;
	
	public SupplierMenu() {
		productMenu = new ProductMenu();
	}
	
	public void openSupplierMenu(Supplier supplier) {
		int command;
		while((command = getCommand()) != 0) {
			switch(command) {
			case 1: changeSupplierName(supplier);
					break;
			case 2: createProduct(supplier);
					break;
			case 3: getProduct(supplier);
					break;
			case 4: removeProduct(supplier);
					break;
			case 5: printProductList(supplier);
					break;
			case 6: startSupplierShipment(supplier);
					break;
			case 7: printShipmentHistory(supplier);
					break;
			default:
				System.out.println("Please enter a number that within menu commands");
			}
		}
	}
	
	public void getProduct(Supplier supplier) {
		String id = getInput("Enter id of product.");
		
		Object obj = supplier.getProduct(id);
		if(obj.isNul()) {
			return;
		}
		System.out.println(obj);
		Product product = (Product) obj;
		productMenu.openProductMenu(product);
	}
	
	public void printProductList(Supplier supplier) {
		supplier.printListOfProducts();
	}
	
	public void startSupplierShipment(Supplier supplier) {
		String prompt;
		int quantity;
		boolean itemInShipment = false;
		while(true) {
			System.out.println("These are the available products to ship:");
			System.out.println("");
			supplier.printListOfProducts();
			System.out.println("");
			prompt = getInput("Enter Id of product to ship or (done) to send shipment: ");
			if(prompt.equalsIgnoreCase("done")) {
				break;
			}
			quantity = getInt("Enter quantity of product to ship:");
			System.out.println("");
			supplier.addToDeal(prompt, quantity);
			itemInShipment = true;
		}
		
		if(itemInShipment) {
			supplier.completeDeal();
		}
			
	}
	
	public void createProduct(Supplier supplier) {
		String name = getInput("Enter name of product: ");
		int quantity = getInt("Enter quantity of product: ");
		double salePrice = getInt("Enter sale price of produce: ");
		
		Object product = supplier.createProduct(name, quantity, salePrice);
		System.out.println(product);
	}
	
	public void removeProduct(Supplier supplier) {
		String id = getInput("Enter id of product to remove.");
		supplier.removeProduct(id);
	}
	
	public void changeSupplierName(Supplier supplier) {
		String name = getInput("Enter new supplier name: ");
		supplier.setName(name);
		System.out.println(supplier);
	}
	
	public void printShipmentHistory(Supplier supplier) {
		supplier.printHistory();
	}

	@Override
	public void printMenu() {
		System.out.println("");
		System.out.println("Enter one of the following commands:");
		System.out.println("(1) Change your name.");
		System.out.println("(2) Create new product.");
		System.out.println("(3) View product.");
		System.out.println("(4) Remove product.");
		System.out.println("(5) View list of products.");
		System.out.println("(6) Make shipment to warehouse.");
		System.out.println("(7) Print shipment history.");
		System.out.println("(0) To log out as supplier.");
		System.out.println("");
		
	}
	
}