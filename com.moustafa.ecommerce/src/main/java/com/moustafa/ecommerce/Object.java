package com.moustafa.ecommerce;


public abstract class Object{
    protected String id;
    protected String name;
    protected Warehouse warehouse;
    protected Object next;
    protected HistoryList historyList;
    
    
    public Object(String name, Warehouse warehouse){
        this.id = null;
        this.name = name;
        this.next = null;
        this.warehouse = warehouse;
        this.historyList = new HistoryList();
    }

    public String getName(){
        return name;
    }
    
    public String getId(){
        return id;
    }

    public void setName(String name){
        this.name = name;
    }
    
    public void setId(String id){
        this.id = id;
    }
    
    public void submitNewHistory() {
    	historyList.submitHistory();
    }
    
    public void addToHistory(String productId, String productName, int quantity, double sum){
    	historyList.addToHistory(productId, productName, quantity, sum);
    }
    
    
    public abstract void printHistory();
    
    public int historySize() {
    	return historyList.getSize();
    }
    
    public abstract void addToDeal(String prompt, int quantity);
    
    public abstract void completeDeal();
    

    public abstract String toString();
    
    public abstract String getType();
    
    public abstract boolean isNul();


}
