package com.moustafa.ecommerce;


public class Manager{
	private ClientList cliList;
	private SupplierList suppList;
    private IdServer clientIdServer;
    private IdServer supplierIdServer;
	private ObjectFactory factory;
	private Warehouse warehouse;
	
	public Manager() {
		cliList = new ClientList();
		suppList = new SupplierList();
		factory = new ObjectFactory();
		warehouse = new Warehouse();
		clientIdServer = new IdServer("C");
		supplierIdServer = new IdServer("S");
	}
	
    public Object createObject(String type, String name) {
    	Object obj = factory.create(type, name, warehouse);
    	addObjectToList(obj);
    	return obj;
    }
    
    
    public void addObjectToList(Object obj) {
    	String type = obj.getType();
    	String id;
    	if(type.equalsIgnoreCase("client")) {
    		id = clientIdServer.createId();
    		obj.setId(id);
    		cliList.addToList(obj);
    	}
    	else if(type.equalsIgnoreCase("supplier")) {
    		id = supplierIdServer.createId();
    		obj.setId(id);
    		suppList.addToList(obj);
    	}
    	
    }
    
    
    public void removeObject(String id){
    	char type = getTypeFromId(id);
    	type = Character.toUpperCase(type);
    	Object obj;

    	
        if(type == 'C'){
        	clientIdServer.removeId(id);
        	obj = cliList.getObject(id);
            cliList.removeFromList(obj);
        }
        else if(type == 'S'){
        	supplierIdServer.removeId(id);
        	obj = suppList.getObject(id);
            suppList.removeFromList(obj);
        }
        else {
        	System.out.println("Invalid ID");
        }
    }
    
    public Object getObject(String id) {
    	char type = getTypeFromId(id);
    	type = Character.toUpperCase(type);
    	
    	if(type == 'C') {
    		return cliList.getObject(id);
    	}
    	else if(type == 'S'){
    		return suppList.getObject(id);
    	}else {
    		return new NullObject("Invalid ID");
    	}
    }
    
    

    public void printList(String type){
        if(type.equalsIgnoreCase("CLIENT")){
            cliList.printList();
        }
        else{
            suppList.printList();
        }
    }
    
    public int getSize(String type) {
    	if(type.equalsIgnoreCase("CLIENT")){
            return cliList.getSize();
        }
        else{
            return suppList.getSize();
        }
    }
    
    public void creditClient(Client client, double balance) {
    	double newBalance = client.getBalance() - balance;
    	client.setBalance(newBalance);
    }
    
    public void printUnpaidClients(){
    	cliList.printUnpaidClients();
    }
    
    public double getBalance(Client client) {
    	return client.getBalance();
    	
    }

    
    
    private char getTypeFromId(String id) {
    	return id.charAt(0);
    }
    

}