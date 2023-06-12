package com.moustafa.ecommerce;


public class ClientList extends ObjectList{
	
	

    
    public void printUnpaidClients(){

    	
    	if(head == null) {
    		System.out.println("There are no clients.");
    		return;
    	}
    	Client pointer = (Client) head;
    	boolean unpaidFlag = false;
    
    	
        while(pointer != null) {
        	if(getBalance(pointer) != 0) {
        		unpaidFlag = true;
        		System.out.println(pointer);
        		
        	}
        	pointer = pointer.next;
        }
        
        if(!unpaidFlag) {
        	System.out.println("All clients have no unpaid balances.");
        }
        
    }
    

    public double getBalance(Client client) {
    	return client.getBalance();
    }
    
    


}
