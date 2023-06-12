package com.moustafa.ecommerce;

import java.io.*;

/**
 * Hello world!
 */
public final class App {


	
    private App() {
    	
    }
	

    public static void main(String[] args) throws IOException{
    	
    	StartMenu startMenu = new StartMenu();
    	System.out.println("Welcome to ecommerce simulator!");
    	startMenu.openStartMenu();
    	
    }
    
}
