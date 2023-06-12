package com.moustafa.ecommerce;
import java.util.*;


public abstract class ObjectList {
    protected Object head;
    
    public ObjectList(){
    	this.head = null;
    	
    }

    public void addToList(Object obj){
        if(head == null) {
        	head = obj;
        	return;
        }
    	Object pointer = head;
    	while(pointer.next != null) {
    		pointer = pointer.next;
    	}
    	pointer.next = obj;
    
    	sortList();
    }
    
    public void removeFromList(Object obj){
    	
    	if(obj.isNul()) {
    		System.out.println(obj);
    		return;
    	}
    	
        if(head == null) {
        	return;
        }
       
     
        Object pointer = head;
        String pointerId = head.getId();
        

        
        if(pointerId.equals(obj.getId())) {
        	head = head.next;
        	return;
        }
        
        Object runner = pointer.next;
        if(runner == null) {
        	return;
        }
        String runnerId = runner.getId();
        
        
        while(runner != null) {
        	if(runnerId.equals(obj.getId())) {
        		pointer.next = obj.next;
        		obj = null;
        		sortList();
        		return;
        	}
        	pointer = pointer.next;
        	runner = runner.next;
        	runnerId = runner.getId();
        }
        
        System.out.println("Id does not exist");
        
    }
    
    public Object getObject(String id){
    	if(head == null) {
    		return new NullObject("Invalid ID.");
    	}
    	
    	Object pointer = head;
    	
    	while(pointer != null) {
    		if(pointer.getId().equalsIgnoreCase(id)) {
    			return pointer;
    		}
    		pointer = pointer.next;
    	}
    	
    	return new NullObject("Id does not exist.");
    }
    
    
    public ArrayList<Object> getList() {
    	ArrayList<Object> arrayList = new ArrayList<>();
    	Object pointer = head;
    	while(pointer != null) {
    		arrayList.add(pointer);
    		pointer = pointer.next;
    	}
    	
    	return arrayList;
    }

    public void printList(){
        if(head == null) {
        	System.out.println("No list");
        }
        
        Object pointer = head;
        
        while(pointer != null) {
        	System.out.println(pointer.toString());
        	pointer = pointer.next;
        }
    }
    
    public int getSize() {
    	if(head == null) {
    		return 0;
    	}
    	
    	Object pointer = head;
    	
    	int count = 0;
    	while(pointer != null) {
    		count++;
    		pointer = pointer.next;
    	}
    	
    	return count;
    }
    
    private void sortList() {
    	mergeSort(head);
    }
    
    public Object mergeSort(Object headNode) {
    	if(headNode == null || headNode.next == null) {
    		return headNode;
    	}
    	
    	
    	Object middleNode = getMiddle(headNode);
    	Object nextOfMiddle = middleNode.next;
    	
    	middleNode.next = null;
    	
    	Object leftNode = mergeSort(headNode);
    	Object rightNode = mergeSort(nextOfMiddle);
    	
    	Object sortedList = merge(leftNode, rightNode);
    	return sortedList;
    }
    
    public Object merge(Object leftNode, Object rightNode) {
    	Object result = null;
    	
    	if(leftNode == null) {
    		return rightNode;
    	}
    	if(rightNode == null) {
    		return leftNode;
    	}
    	
    	int leftValue = getIntFromId(leftNode.getId());
    	int rightValue = getIntFromId(rightNode.getId());
    	
    	if(leftValue <= rightValue) {
    		result = leftNode;
    		result.next = merge(leftNode.next, rightNode);
    	}else {
    		result = rightNode;
    		result.next = merge(leftNode, rightNode.next);
    	}
    	
    	return result;
    }
    
    public Object getMiddle(Object headNode) {
    	if(headNode == null) {
    		return headNode;
    	}
    	
    	
    	Object pointer = headNode;
    	Object runner = headNode;
    	
    	while(runner.next != null && runner.next.next != null) {
    		pointer = pointer.next;
    		runner = runner.next.next;
    	}
    	

    	return pointer;
    }
    
    private int getIntFromId(String id) {
    	char number = id.charAt(1);
    	return Character.getNumericValue(number);
    }
    

    
}
