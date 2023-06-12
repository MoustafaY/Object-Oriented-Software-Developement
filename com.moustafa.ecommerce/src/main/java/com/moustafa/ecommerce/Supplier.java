package com.moustafa.ecommerce;

import java.util.*;

public class Supplier extends Object{
	
	protected Supplier next;
	protected ProductList prodList;
	protected ArrayList<Product> shipment;

    public Supplier(String name, Warehouse warehouse) {
        super(name, warehouse);
        this.next = null;
        this.warehouse = warehouse;
        prodList = new ProductList();
        shipment = new ArrayList();
    }
    
    public void setNext(Supplier next) {
    	this.next = next;
    }
    
    public Supplier getNext() {
    	return this.next;
    }
    
    public Object createProduct(String name, int quantity, double salePrice) {
    	Product product = new Product(name, quantity, salePrice);
    	String id = warehouse.createId();
    	product.setId(id);
    	prodList.addToList(product);
    	return product;
    }
    
    
    public void removeProduct(String id) {
    	Object product = prodList.getObject(id);
    	warehouse.removeProduct(id);
    	prodList.removeFromList(product);
    }
    
    public int getWarehouseListSize() {
    	return warehouse.getProductListSize();
    }
    
    public Product getProductFromWarehouse(String id) {
    	return (Product) warehouse.getProduct(id);
    }
    
    @Override
    public void addToDeal(String id, int quantity) {
    	Object obj = prodList.getObject(id);
    	if(obj.isNul()) {
    		System.out.println(obj);
    		return;
    	}
    	
    	Product product = (Product) obj;
    	
    	if(product.getQuantity() < quantity) {
    		System.out.println("Quantity of shipment exceeds available products.");
    		return;
    	}
    	
    	int newQuantity = product.getQuantity() - quantity;
    	product.setQuantity(newQuantity);
    	String shippedId = product.getId();
    	String shippedName = product.getName();
    	double shippedPrice = product.getSalePrice();
    	Product shippedProduct = new Product(shippedId, shippedName, quantity, shippedPrice);
    	addToHistory(shippedId, shippedName, quantity, shippedPrice);
    	shipment.add(shippedProduct);
    }
    
    @Override
    public void completeDeal() {
    	submitNewHistory();
    	warehouse.acceptShipment(shipment);
    	shipment.clear();
    }
    
    public int getSizeOfProductList() {
    	return prodList.getSize();
    }
    
    public Object getProduct(String id) {
    	return prodList.getObject(id);
    }
    
    public void printListOfProducts() {
    	prodList.printList();
    }
    
    @Override
    public void printHistory() {
    	historyList.printHistory("Shipping");
    }
    
    public int shipmentHistorySize() {
    	return historySize();
    }
    
    @Override
    public String toString(){
        return "Supplier ID: " + getId() + " Supplier name: " + getName();
    }
    
    @Override
    public String getType() {
    	return "supplier";
    }
    
    @Override
    public boolean isNul() {
    	return false;
    }
}
