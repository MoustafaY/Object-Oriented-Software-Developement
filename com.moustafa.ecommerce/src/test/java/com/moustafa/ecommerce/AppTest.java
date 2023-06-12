package com.moustafa.ecommerce;

import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;


/**
 * Unit test for simple App.
 */
class AppTest {
    /**
     * Rigorous Test.
     */

     Manager manager= new Manager();



    @Test
    void clientIsCreated(){
        Object client = manager.createObject("client", "Moustafa");        
        char identifier = client.getId().charAt(0);
        
        assertEquals('C', identifier);
    }
    
    @Test
    void clientCountsAsOne() {
    	Object client1 = manager.createObject("client", "moustafa");
    	
    	int size = manager.getSize("client");
    	assertEquals(1, size);
    }

    @Test
    void productCountsAsOne() {
    	Supplier supplier = (Supplier) manager.createObject("supplier", "moustafa");
    	Object product = supplier.createProduct("mango flag", 5, 12.00);
    	
    	
    	int size = supplier.getSizeOfProductList();
    	assertEquals(1, size);
    }
    
    @Test
    void supplierCountsAsOne() {
    	Object supplier1 = manager.createObject("supplier", "moustafa");
    	
    	int size = manager.getSize("supplier");
    	assertEquals(1, size);
    }
    
    @Test
    void productIsCreated(){
        Supplier supplier = (Supplier) manager.createObject("supplier", "Moustafa");   
        Object product = supplier.createProduct("mango", 7, 13.00);
        char identifier = product.getId().charAt(0);

        assertEquals('P', identifier);
    }

    @Test
    void supplierIsCreated(){
        Object supplier = manager.createObject("supplier", "Moustafa");        
        char identifier = supplier.getId().charAt(0);

        assertEquals('S', identifier);
    }
    
    @Test
    void clientListCreated() {
    	Object client1 = manager.createObject("client", "mustafa");
    	Object client2 = manager.createObject("client", "Yusef");
    	
    	
    	int size = manager.getSize("client");
    	assertEquals(2, size);
    }
    
    @Test
    void productListCreated() {
    	Supplier supplier = (Supplier) manager.createObject("supplier", "Moustafa");
    	Object prod1 = supplier.createProduct("mango", 3, 14.00);
    	Object prod2 = supplier.createProduct("kiwi", 6, 19.00);
    	
    	
    	int size = supplier.getSizeOfProductList();
    	assertEquals(2, size);
    }
    
    @Test
    void supplierListCreated() {
    	Object supplier1 = manager.createObject("supplier", "moustafa");
    	Object supplier2 = manager.createObject("supplier", "yousef");
    	
    	
    	int size = manager.getSize("supplier");
    	assertEquals(2, size);
    }
    
    @Test
    void clientIsRemoved() {
    	Object client1 = manager.createObject("client", "Moustafa");
    	Object client2 = manager.createObject("client", "yousef to remove");
    	
    	manager.removeObject("C2");
    	
    	int size = manager.getSize("client");
    	assertEquals(1, size);
    }
    
    @Test
    void ProductIsRemoved() {
    	Supplier supplier = (Supplier) manager.createObject("supplier", "Moustafa");
    	Object prod1 = supplier.createProduct("mango", 4, 13.00);
    	Object prod2 = supplier.createProduct("kiwi", 11, 8.0);
    	
    	supplier.removeProduct("P1");
    	    	
    	int size = supplier.getSizeOfProductList();
    	assertEquals(1, size);
    }
    
    @Test
    void SupplierIsRemoved() {
    	Object supplier1 = manager.createObject("supplier", "Moustafa");
    	Object supplier = manager.createObject("supplier", "yousef to remove");
    	
    	manager.removeObject("S2");
    	
    	int size = manager.getSize("supplier");
    	assertEquals(1, size);
    }
   @Test
    void clientListIsSorted() {
    	Object client1 = manager.createObject("client", "Moustafa");
    	Object client2 = manager.createObject("client", "Yousef to remove");
    	Object client3 = manager.createObject("client", "kebz to sort");
    	
    	manager.removeObject("C2");
    	Object client4 = manager.createObject("client", "Yousef just added");
    	
    	assertTrue(client4.getId().equals("C2"));
    }
    
    @Test
    void productListIsSorted() {
    	Supplier supplier = (Supplier) manager.createObject("supplier", "Moustafa");
    	Object prod1 = supplier.createProduct("mango", 4, 13.00);
    	Object prod2 = supplier.createProduct("kiwi", 11, 8.0);
    	Object prod3 = supplier.createProduct("banana", 6, 14.00);
    	
    	supplier.removeProduct("P2");
    	Object prod4 = supplier.createProduct("Kiwi", 1, 4.00);
    	
    	assertTrue(prod4.getId().equals("P2"));
    }
    
    @Test
    void supplierListIsSorted() {
    	Object supplier1 = manager.createObject("supplier", "Moustafa");
    	Object supplier2 = manager.createObject("supplier", "Yousef to remove");
    	Object supplier3 = manager.createObject("supplier", "kebz to sort");
    	
    	manager.removeObject("S2");
    	Object supplier4 = manager.createObject("supplier", "Yousef just added");
    	
    	assertTrue(supplier4.getId().equals("S2"));
    }
    
    @Test
    void clientFound() {
    	Object client1 = manager.createObject("client", "moustafa");
    	Object client2 = manager.createObject("client", "yousef");
    	Object client3 = manager.createObject("client", "kebz");
    	
    	Object foundClient = manager.getObject("c3");
    	
    	assertTrue(client3.getId().equals(foundClient.getId()));
    }
    
    @Test
    void supplierFound() {
    	Object supplier1 = manager.createObject("supplier", "moustafa");
    	Object supplier2 = manager.createObject("supplier", "yousef");
    	Object supplier3 = manager.createObject("supplier", "kebz");
    	
    	Object foundSupplier = manager.getObject("s3");
    	
    	assertTrue(supplier3.getId().equals(foundSupplier.getId()));
    }
    
    @Test
    void productFound() {
    	Object supplierObj = manager.createObject("supplier", "moustafa");
    	Supplier supplier = (Supplier) supplierObj;
    	
    	supplier.createProduct("kiwi", 23, 1);
    	supplier.createProduct("meat", 3, 12);
    	supplier.createProduct("gum", 6, 9);
    	
    	Object product = supplier.getProduct("p3");
    	
    	assertEquals(product.getId(), "P3");
    	
    }
    
    @Test
    void clientNotFound() {
    	Object client = manager.createObject("client", "moustafa");
    	
    	Object dummy = manager.getObject("c5");
    	
    	assertTrue(dummy.isNul());
    }
    
    @Test
    void productNotFound() {
    	Supplier supplier = (Supplier) manager.createObject("supplier", "Moustafa");
    	Object prod1 = supplier.createProduct("mango", 4, 13.00);
    	
    	Object dummy = supplier.getProduct("p5");
    	
    	assertTrue(dummy.isNul());
    }
    
    @Test
    void supplierNotFound() {
    	Object supplier = manager.createObject("supplier", "moustafa");
    	
    	Object dummy = manager.getObject("s5");
    	
    	assertTrue(dummy.isNul());
    }
    
    @Test
    void multipleSupplierProductsIdSynchronize() {
    	Supplier supplier1 = (Supplier) manager.createObject("supplier", "Moustafa");
    	Supplier supplier2 = (Supplier) manager.createObject("supplier", "yousef");
    	
    	supplier1.createProduct("kiwi", 13, 1);
    	supplier2.createProduct("soda", 8, 11);
    	
    	Object product = supplier2.getProduct("p2");
    	
    	assertEquals(product.getId(), "P2");
    }
    
    @Test
    void productIdSynchFromDifferentSuppliers() {
    	Supplier supplier1 = (Supplier) manager.createObject("supplier", "Moustafa");
    	Supplier supplier2 = (Supplier) manager.createObject("supplier", "yousef");
    	
    	Object product1 = supplier1.createProduct("kiwi", 13, 1);
    	Object product2 = supplier2.createProduct("soda", 8, 11);
    	
    	
    	Supplier supplier3 = (Supplier) manager.createObject("supplier", "kebz");
    	
    	supplier2.removeProduct("P2");
    	Object product3 = supplier3.createProduct("gum", 90, 2);
    	

    	
    	assertEquals(product3.getId(), "P2");
    	
    }
    
    @Test
    void productIdDoesNotExistInDifferentSupplier() {
    	Supplier supplier1 = (Supplier) manager.createObject("supplier", "Moustafa");
    	Supplier supplier2 = (Supplier) manager.createObject("supplier", "yousef");
    	
    	Object product1 = supplier1.createProduct("kiwi", 13, 1);
    	Object product2 = supplier2.createProduct("soda", 8, 11);
    	
    	Object dummy = supplier2.getProduct("p1");
    	
    	assertTrue(dummy.isNul());
    }
    
    @Test
    void warehouseAcceptsShipmentOfNewProduct() {
    	Supplier supplier = (Supplier) manager.createObject("supplier", "Moustafa");
    	Product product = (Product) supplier.createProduct("kiwi", 13, 1);
    	
    	supplier.addToDeal("p1", 12);
    	supplier.completeDeal();
    	
    	
    	int size = supplier.getWarehouseListSize();
    	
    	assertEquals(size, 1);
    }
    
    @Test
    void warehouseAcceptShipmentOfExistingProduct() {
    	Supplier supplier = (Supplier) manager.createObject("supplier", "Moustafa");
    	Product product = (Product) supplier.createProduct("kiwi", 13, 1);
    	
    	supplier.addToDeal("p1", 5);
    	supplier.addToDeal("p1", 3);
    	supplier.completeDeal();
    	
    	int size = supplier.getWarehouseListSize();
    	
    	assertEquals(size, 1);
    }
    
    @Test
    void clientMakesOrderTest() {
    	Client client = (Client) manager.createObject("client", "Moustafa");
    	Supplier supplier = (Supplier) manager.createObject("supplier", "Moustafa");
    	Product product = (Product) supplier.createProduct("kiwi", 10, 2);
    	
    	supplier.addToDeal("p1", 5);
    	supplier.completeDeal();
    	
    	client.addToDeal("p1", 3);
    	client.completeDeal();
    	
    	double credit = client.getBalance();
    	assertEquals(credit, 6);
    }
    
    @Test
    void clientMakesOrderWithMultipleProductsTest() {
    	Client client = (Client) manager.createObject("client", "Moustafa");
    	Supplier supplier = (Supplier) manager.createObject("supplier", "Moustafa");
    	Product product = (Product) supplier.createProduct("kiwi flag", 10, 2);
    	Product product2 = (Product) supplier.createProduct("gum flag", 20, 1);
    	
    	supplier.addToDeal("p1", 5);
    	supplier.addToDeal("p2", 4);
    	supplier.completeDeal();
    	
    	
    	client.addToDeal("p1", 3);
    	client.addToDeal("p2", 4);
    	client.completeDeal();
    	
    	double credit = client.getBalance();
    	assertEquals(credit, 10);
    }
    
    @Test
    void supplierQuantityUpdatesAfterShipmentTest() {
    	Supplier supplier = (Supplier) manager.createObject("supplier", "Moustafa");
    	Product product = (Product) supplier.createProduct("kiwi", 10, 2);
    	supplier.addToDeal("p1", 3);
    	supplier.completeDeal();
    	
    	int quantity = product.getQuantity();
    	
    	assertEquals(quantity, 7);
    }
    
    @Test
    void warehouseQuantityUpdatesAfterOrderTest() {
    	Client client = (Client) manager.createObject("client", "Moustafa");
    	Supplier supplier = (Supplier) manager.createObject("supplier", "Moustafa");
    	Product product = (Product) supplier.createProduct("kiwi", 10, 2);
    	
    	supplier.addToDeal("p1", 9);
    	supplier.completeDeal();
    	client.addToDeal("p1", 6);
    	client.completeDeal();
    	
    	Product warehouseProduct = supplier.getProductFromWarehouse("p1");
    	
    	int quantity = warehouseProduct.getQuantity();
    	
    	assertEquals(quantity, 3);
    }
    
    @Test
    void clientOrderHistoryCheck() {
    	Client client = (Client) manager.createObject("client", "Moustafa");
    	Supplier supplier = (Supplier) manager.createObject("supplier", "Moustafa");
    	Product product = (Product) supplier.createProduct("kiwi", 10, 2);
    	Product product1 = (Product) supplier.createProduct("gum", 20, 3);
    	
    	supplier.addToDeal("p1", 5);
    	supplier.addToDeal("p2", 10);
    	supplier.completeDeal();
    	
    	client.addToDeal("p1", 3);
    	client.completeDeal();
    	
    	client.addToDeal("p2", 7);
    	client.completeDeal();
    	
    	
    	int size = client.historySize();
    	assertEquals(size, 2);
    }
    
    @Test
    void supplierShipmentHistoryTest() {
    	Supplier supplier = (Supplier) manager.createObject("supplier", "Moustafa");
    	Product product = (Product) supplier.createProduct("kiwi", 10, 2);
    	Product product1 = (Product) supplier.createProduct("gum", 20, 3);
    	
    	supplier.addToDeal("p1", 5);
    	supplier.completeDeal();
    	supplier.addToDeal("p2", 10);
    	supplier.completeDeal();
    	
    	int size = supplier.shipmentHistorySize();
    	assertEquals(size, 2);
    }
    
    @Test
    void warehouseRemoveProductAfterSupplierTest() {
    	Supplier supplier = (Supplier) manager.createObject("supplier", "Moustafa");
    	Product product = (Product) supplier.createProduct("kiwi", 10, 2);
    	Product product1 = (Product) supplier.createProduct("gum", 20, 3);
    	
    	supplier.addToDeal("p1", 5);
    	supplier.completeDeal();
    	supplier.addToDeal("p2", 10);
    	supplier.completeDeal();
    	
    	supplier.removeProduct("p1");
    	
    	int size = supplier.getWarehouseListSize();
    	assertEquals(size, 1);
    }
    

}
