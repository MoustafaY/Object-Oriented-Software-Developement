package com.moustafa.ecommerce;

public class Client extends Object{
    
    private double balance;
    protected Client next;
    
    
    
    public Client(String name, Warehouse warehouse){
        super(name, warehouse);
        this.balance = 0;
        this.next = null;
    }

    public double getBalance(){
        return balance;
    }

    public void setBalance(double balance){
        this.balance = balance;
    }
    
    public void creditClient(double amount) {
    	balance += amount;
    }
    
    public void makePayment(double amount) {
    	balance -= amount;
    }
    
    
    public void printWarehouseList() {
    	warehouse.printProductList();
    }
    
    @Override
    public void printHistory() {
    	historyList.printHistory("Transaction");
    }
    
    @Override
    public void addToDeal(String prompt, int quantity) {
    	warehouse.addToOrder(prompt, quantity);
    }
    
    @Override
    public void completeDeal() {
    	warehouse.completeOrder(this);
    }
    
    
    @Override
    public String toString(){
        return "Client ID: " + getId() + " Client name: " + getName();
    }
    
    @Override
    public String getType() {
    	return "client";
    }
    
    @Override
    public boolean isNul() {
    	return false;
    }
    
}
