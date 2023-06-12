package com.moustafa.ecommerce;
import java.util.*;


public class Warehouse{
    private ProductList prodList;
    private IdServer productIdServer;
    private ArrayList<Product> order;

    
    
    public Warehouse() {
    	prodList = new ProductList();
    	productIdServer = new IdServer("P");
    	order = new ArrayList();
    }
    
    public void acceptShipment(ArrayList<Product> shipment) {
    	for(Product product : shipment) {
        	Object obj = prodList.getObject(product.getId());
        	if(obj.isNul())
        	{
        		prodList.addToList(product);
        	}
        	else {
            	Product existingProduct = (Product) obj;
            	int newQuantity = existingProduct.getQuantity() + product.getQuantity();
            	existingProduct.setQuantity(newQuantity);
        	}

    	}

    }
    
    public void printProductList() {
    	prodList.printList();
    }
    
    public int getProductListSize() {
    	return prodList.getSize();
    }
    
    public ArrayList<Object> getProductList(){
    	return prodList.getList();
    }
    
    public String createId() {
    	return productIdServer.createId();
    }
    
    public void removeProduct(String id) {
    	Object obj = prodList.getObject(id);
    	if(!obj.isNul())
    	{
    		prodList.removeFromList(obj);
    	}
    	productIdServer.removeId(id);
    }
    
    public Object getProduct(String id) {
    	return (Product) prodList.getObject(id);
    }
    
    public void addToOrder(String id, int quantity) {
    	Object productObj = prodList.getObject(id);
    	if(productObj.isNul()) {
    		System.out.println(productObj);
    		return;
    	}
    	
    	Product product = (Product) productObj;
    	
    	if(product.getQuantity() < quantity) {
    		System.out.println("Quantity of order exceeds available products.");
    		return;
    	}
    	
    	int newQuantity = updateQuantity(product, quantity);
    	
    	Product orderProduct = new Product(id, product.getName(), quantity, product.getSalePrice());
    	
    	product.setQuantity(newQuantity);
    	
    	order.add(orderProduct);
    	
    }
    
    public int updateQuantity(Product product, int quantity) {
    	return product.getQuantity() - quantity;
    }
    
    public void completeOrder(Client client) {
    	double sum;
    	for(Product item : order) {
    		sum = calculateProduct(item);
    		client.creditClient(sum);
    		client.addToHistory(item.getId(), item.getName(), item.getQuantity(), sum);
    	}
    	client.submitNewHistory();
    	order.clear();
    }
    
    private double calculateProduct(Product product) {
    	return product.getSalePrice() * product.getQuantity();
    }
    
    
}