# Object-Oriented-Software-Developement
For this project I applied all what I learned from this class. Including the process of designing a system, designing a class, and assigning responsibilities to these classes.
This project also uses some java design patterns such as the factory pattern and the null object design pattern.
The project was made using maven and has a junit test file name "AppTest.java".

## Project name: Ecommerce Simulator
This project simulates a simple ecommerce business where a supplier creates a product, ships that product to the warehouse for a client to make orders later on.
The main components of this project are named "Object", these components have similar structure but behave differently. The name of these objects are:
- Client
- Supplier 
- Product
And they all have 2 strings to represent their IDs and names, and an reference to another Object named "next".

### Client
A client has a balance that represents what they are owed, if the balance is positive then that value is what they are owed, if the balance is negative that means the cient has extra balance in their account.
A client can make an order and make a transaction.

### Supplier
A supplier has a list of products that represent what they have to offer to the warehouse when making a shipment.
A supplier can create a product, change a product's quantity, remove a product from their supply and the warehouse, and make a shipment to the warehouse.

### Product
A product has an integer to represent the quantity available of it, and has a double to represent the sale price of this product.

## Warehouse and Manager
The warehouse is responsible for the relationship of products between itself, the supplier and the client. The warehouse has a list of products to represent what is available in stock.
The warehouse's responsibilites are:
- Creating a unique ID for every new product created by a supplier
- Updating the list of products withing it whenever a supplier makes a shipment to it
- Updating the list of products within it whenever a client makes an order.

The manager is responsible for the creation, removal and storing of the client and supplier objects. The manager has a list of clients and suppliers.
The manager's responsibilities are:
- Creating suppliers and clients
- removing supplier and clients
- retrieving supplier or clients
- printing the available suppliers or clients

## How does the program work
The program prints several menus in a console, and uses numbers to represent each choice. Depending on these inputs several menus appear to navigate the user through the available options. Creating clients and suppliers is the first step of the process, logging in as a supplier allows the user to create products and make shipments for the client to order them later on. Clients and supplier have a printable receipt of their transactions and shipments to view.

## How to run this program
Download the .jar file named "ecommerceSim" and the .bat file named "run" in the same directory. Open the "run" file and a console will appear with the main menu of the project.

## What I learned from this project
Abstraction would be what I learned from the most during this project. Now I can see more opportunities at minimizing repeated code and have a better understanding of abstract objects
