# WareHouseInventoryManagement




## The Task
The assignment is to implement a warehouse software. This software should hold articles, and the articles should contain an identification number, a name and available stock. It should be possible to load articles into the software from a file, see the attached inventory.json.
The warehouse software should also have products, products are made of different articles. Products should have a name, price and a list of articles of which they are made from with a quantity. The products should also be loaded from a file, see the attached products.json. 
 
The warehouse should have at least the following functionality;
* Get all products and quantity of each that is an available with the current inventory
* Remove(Sell) a product and update the inventory accordingly

Solution :

Implemented the code using the below softwares
RestWebServices
Java
ApacheTomcat web server
PostMantool To test Webservice
Maven as build Tool


Loads all the existing Productdetails based on the information provided in the products.json and inventry.json files
 ProductDetails have below parameters
 productName
 Price
 articles and amount of used
 
 Updates the inventry json file after selling a product
 
 Attached screen shots which are tested using postmanTool
 





