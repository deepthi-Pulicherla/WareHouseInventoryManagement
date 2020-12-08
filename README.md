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
 Following are the outputs and  the webservice implemented
 getInventory and output from postmantool
 
  @GET
 warehouse/inventry
 getInventory()
 
	  
 http://localhost:8080/inventory/webresources/warehouse/inventry
 
 
 
 {
    "inventory": [
        {
            "art_id": "1",
            "name": "leg",
            "stock": "8"
        },
        {
            "art_id": "2",
            "name": "screw",
            "stock": "9"
        },
        {
            "art_id": "3",
            "name": "seat",
            "stock": "2"
        },
        {
            "art_id": "4",
            "name": "table top",
            "stock": "0"
        }
    ]
}

@GET 
warehouse/allproducts
getAllProducts() 


http://localhost:8080/inventory/webresources/warehouse/allproducts


{
    "products": [
        {
            "contain_articles": [
                {
                    "amount_of": "4",
                    "art_id": "1"
                },
                {
                    "amount_of": "8",
                    "art_id": "2"
                },
                {
                    "amount_of": "1",
                    "art_id": "3"
                }
            ],
            "name": "Dining Chair"
        },
        {
            "contain_articles": [
                {
                    "amount_of": "4",
                    "art_id": "1"
                },
                {
                    "amount_of": "8",
                    "art_id": "2"
                },
                {
                    "amount_of": "1",
                    "art_id": "4"
                }
            ],
            "name": "Dinning Table"
        }
    ]
}

@GET
warehouse/allproductdetails
getAllProductDetails() 


http://localhost:8080/inventory/webresources/warehouse/allproductdetails



{
    "productDetail": [
        {
            "articlesAndAmount": {
                "entry": [
                    {
                        "key": "seat",
                        "value": "1"
                    },
                    {
                        "key": "screw",
                        "value": "8"
                    },
                    {
                        "key": "leg",
                        "value": "4"
                    }
                ]
            },
            "price": "500",
            "productName": "Dining Chair"
        },
        {
            "articlesAndAmount": {
                "entry": [
                    {
                        "key": "table top",
                        "value": "1"
                    },
                    {
                        "key": "screw",
                        "value": "8"
                    },
                    {
                        "key": "leg",
                        "value": "4"
                    }
                ]
            },
            "price": "1000",
            "productName": "Dinning Table"
        }
    ]
}
 

@GET 
warehouse/{<name of product>} 
buyProduct( ) 
	
 if Dining Table was sold
 
 
 http://localhost:8080/inventory/webresources/warehouse/Dinning Table
 
 
 
 {
    "articlesAndAmount": {
        "entry": [
            {
                "key": "table top",
                "value": "1"
            },
            {
                "key": "screw",
                "value": "8"
            },
            {
                "key": "leg",
                "value": "4"
            }
        ]
    },
    "price": "1000",
    "productName": "Dinning Table"
}
 
 Updated Inventory after selling Dinning table
 
 
 http://localhost:8080/inventory/webresources/warehouse/inventry
 
 
 {
    "inventory": [
        {
            "art_id": "1",
            "name": "leg",
            "stock": "4"
        },
        {
            "art_id": "2",
            "name": "screw",
            "stock": "1"
        },
        {
            "art_id": "3",
            "name": "seat",
            "stock": "2"
        },
        {
            "art_id": "4",
            "name": "table top",
            "stock": "-1"
        }
    ]
}

buyProduct( ) 


 if Dining chair was sold
 
 http://localhost:8080/inventory/webresources/warehouse/Dining Chair
 
 

{
    "articlesAndAmount": {
        "entry": [
            {
                "key": "seat",
                "value": "1"
            },
            {
                "key": "screw",
                "value": "8"
            },
            {
                "key": "leg",
                "value": "4"
            }
        ]
    },
    "price": "500",
    "productName": "Dining Chair"
}

Udated inventory after Dining chair sold


http://localhost:8080/inventory/webresources/warehouse/inventry


{
    "inventory": [
        {
            "art_id": "1",
            "name": "leg",
            "stock": "0"
        },
        {
            "art_id": "2",
            "name": "screw",
            "stock": "-7"
        },
        {
            "art_id": "3",
            "name": "seat",
            "stock": "1"
        },
        {
            "art_id": "4",
            "name": "table top",
            "stock": "-1"
        }
    ]
}
