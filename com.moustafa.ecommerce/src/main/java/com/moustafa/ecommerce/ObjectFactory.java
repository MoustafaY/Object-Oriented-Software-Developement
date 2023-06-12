package com.moustafa.ecommerce;


public class ObjectFactory {
	
    public Object create(String type,String name, Warehouse warehouse){
    	
    	if(compareIgnoreCase(type, "client")) {
    		Object client = new Client(name, warehouse);
    		return client;
    	}
    	else if(compareIgnoreCase(type, "supplier")) {
    		Object supplier = new Supplier(name, warehouse);
    		return supplier;
    	}
    	
    	return new NullObject("Invalid person type.");
    	
    }
    
    private boolean compareIgnoreCase(String str1, String str2) {
    	return str1.equalsIgnoreCase(str2);
    }

    

}
