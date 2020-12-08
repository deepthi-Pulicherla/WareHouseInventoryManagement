
package warehouse.inventory;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("/warehouse")
public class InventoryResource {
    
   InventoryRepo ir = new InventoryRepo();
   
   @GET 
   @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
   @Path("/allproducts")
    public ArrayList<Products> getAllProducts() {
	   
        return ir.getAllProducts();
    }
   
   @GET
   @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
   @Path("/inventry")
    public ArrayList<Inventory> getInventory() {
	   
        return ir.getInventory();
    }
   
   @GET 
   @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
   @Path("{name}")
    public ProductDetail buyProduct(@PathParam ("name") String name) {
        return ir.buyProduct(name);
    }
   
   @GET 
   @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
   @Path("/allproductdetails")
    public ArrayList<ProductDetail> getAllProductDetails() {
	     ir.modifyJson();
        return ir.getAllAvailableProducts();
    }
   
  
}
