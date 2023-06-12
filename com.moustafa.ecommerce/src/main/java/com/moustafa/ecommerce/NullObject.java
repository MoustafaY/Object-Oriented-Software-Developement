package com.moustafa.ecommerce;

public class NullObject extends Object{
	

	
	public NullObject(String name) {
		super(name, null);

	}

	@Override
	public String toString(){
		return name;
	}
	
	@Override 
	public String getType() {
		return "";
	}
	
	@Override
	public boolean isNul() {
		return true;
	}

	@Override
	public void printHistory() {
		
	}

	@Override
	public void addToDeal(String prompt, int quantity) {
		
	}

	@Override
	public void completeDeal() {
		// TODO Auto-generated method stub
		
	}
}