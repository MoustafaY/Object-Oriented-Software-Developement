package com.moustafa.ecommerce;


public class Product extends Object{

    private int quantity;
    private double salePrice;
    protected Product next;

    
    public Product(String name, int quantity, double salePrice){
        super(name, null);
        this.quantity = quantity;
        this.salePrice = salePrice;
        this.next = null;
    }
    
    public Product(String id, String name, int quantity, double salePrice) {
    	super(name, null);
    	this.id = id;
    	this.quantity = quantity;
    	this.salePrice = salePrice;
    	this.next = null;
    }

    public int getQuantity(){
        return quantity;
    }

    public double getSalePrice(){
        return salePrice;
    }


    public void setQuantity(int quantity){
        this.quantity = quantity;
    }

    public void setSalePrice(double salePrice){
        this.salePrice = salePrice;
    }
    
    public void setNext(Product next) {
    	this.next = next;
    }
    
    public Product getNext() {
    	return this.next;
    }

    @Override
    public String toString(){
        return "Product ID: " + getId() + " Product name: " + getName() + " Product quantity: " + getQuantity() + " Product sale price: " + getSalePrice();
    }
    
    @Override
    public String getType() {
    	return "product";
    }
    
    @Override
    public boolean isNul() {
    	return false;
    }

	@Override
	public void printHistory() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addToDeal(String prompt, int quantity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void completeDeal() {
		// TODO Auto-generated method stub
		
	}
    
}
