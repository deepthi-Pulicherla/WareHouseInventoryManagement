package warehouse.inventory;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.google.gson.Gson;
import com.google.gson.JsonElement;

public class InventoryRepo {

	ArrayList<Products> pList;
	ArrayList<Inventory> iList;
	FileWriter writer;
	FileReader reader;
	Object inobj ;
	JSONParser jsonParser;
	ArrayList<ProductDetail> allProductdetails ;
	
	

	public InventoryRepo() {
        
		iList = new ArrayList<Inventory>();
		try {
			 reader = new FileReader("C:\\Users\\MM\\Downloads\\Assignment\\assignment\\inventory.json");
		   } 
			catch (Exception e) {

				e.printStackTrace();
			}
			jsonParser = new JSONParser();
			try {
				inobj = jsonParser.parse(reader);
			} catch (Exception e2) {
				e2.printStackTrace();
			} 
			JSONObject inJson = (JSONObject) inobj;
			JSONArray inv = (JSONArray) inJson.get("inventory");
			Iterator<String> invIterator = inv.iterator();
			while (invIterator.hasNext()) {
				Inventory i = new Inventory();
				Object iJson = invIterator.next();
				JSONObject invenj = (JSONObject) iJson;
				i.setArt_id((String) invenj.get("art_id"));
				i.setName((String) invenj.get("name"));
				i.setStock((String) invenj.get("stock"));
				System.out.println("art_id is " + invenj.get("art_id"));
				System.out.println("name is " + invenj.get("name"));
				System.out.println("name is " + invenj.get("stock"));
				iList.add(i);
			}
			
			try {
				;
			} catch (Exception e2) {
				e2.printStackTrace();
			}finally {
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		

			
			
			
		pList = new ArrayList<Products>();
		try {
			 reader = new FileReader("C:\\Users\\MM\\Downloads\\Assignment\\assignment\\products.json");
		} catch (Exception e) {
			e.printStackTrace();
		}
		    jsonParser = new JSONParser();
			try {
				inobj = jsonParser.parse(reader);
			} catch (Exception e1) {
				e1.printStackTrace();
			} 
			JSONObject prodJson = (JSONObject) inobj;
			JSONArray products = (JSONArray) prodJson.get("products");
			Iterator<String> productsIterator = products.iterator();
			while (productsIterator.hasNext()) {
				Products p = new Products();
				Object pJson = productsIterator.next();
				JSONObject pj = (JSONObject) pJson;
				System.out.println("prodname = " + pj.get("name"));
				String prodname = (String) pj.get("name");
				p.setName(prodname);
				JSONArray calist = (JSONArray) pj.get("contain_articles");
				Iterator<String> caIterator = calist.iterator();
				ArrayList<Contain_articles> conartList = new ArrayList<Contain_articles>();
				while (caIterator.hasNext()) {
					Contain_articles cArt = new Contain_articles();
					Object caJson = caIterator.next();
					JSONObject caj = (JSONObject) caJson;
					System.out.println("article id = " + caj.get("art_id"));
					cArt.setArt_id((String) caj.get("art_id"));
					System.out.println("amount of = " + caj.get("amount_of"));
					cArt.setAmount_of((String) caj.get("amount_of"));
					conartList.add(cArt);
				}
				p.setContain_articles(conartList);
				pList.add(p);
			}
			try {
				
			} catch (Exception e) {
				
			}finally {
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
			
			
			allProductdetails = new ArrayList<ProductDetail>();
			for (Products p : pList) {
				HashMap<String, String> articlesAndAmount = new HashMap<String, String>();
				ProductDetail pd = new ProductDetail();
				for (Contain_articles ca : p.getContain_articles()) {
					for (Inventory in : iList) {
						if (in.getArt_id().equals(ca.getArt_id())) {
							pd.setProductName(p.getName());
						    System.out.println(in.getName());
						    System.out.println(ca.getAmount_of());
							articlesAndAmount.put(in.getName(), ca.getAmount_of());
							pd.setArticlesAndAmount(articlesAndAmount);
							if (p.getName().equals("Dining Chair")) {
								pd.setPrice(500);
							}
							if (p.getName().equals("Dinning Table")) {
								pd.setPrice(1000);
							}
						
						}
					}
				}
				allProductdetails.add(pd);
			}

		
	}


	
	public  ArrayList<ProductDetail> getAllAvailableProducts()
	 {
		return allProductdetails;
	 }
	
	

	public ArrayList<Products> getAllProducts() {
		return pList;
	}

	public ArrayList<Inventory> getInventory() {

		return iList;
	}

	public Products getProduct(String name) {
		Products requestedProd = null;
		pList = getAllProducts();

		for (Products p : pList) {
			if (p.getName().equals(name)) {
				requestedProd = p;
			}
		}
		return requestedProd;

	}
	
	public void updateInventory(ProductDetail pD)
	{ 
		try {
			 reader = new FileReader("C:\\Users\\MM\\Downloads\\Assignment\\assignment\\inventory.json");
		} catch (Exception e) {
			e.printStackTrace();
		}
			JSONParser jsonParser = new JSONParser();
			try {
				inobj = jsonParser.parse(reader);
			} catch (Exception e) {
			} 
			JSONObject jsonobj = (JSONObject)inobj;
		ProductDetail pde = pD;
		HashMap<String,String> listOfArticlesDetails = pde.getArticlesAndAmount();
		for (Map.Entry<String, String> set : listOfArticlesDetails.entrySet()) {
			for(int i=0;i<((JSONArray)jsonobj.get("inventory")).size();i++)
			{
				if(((JSONObject)(((JSONArray)jsonobj.get("inventory")).get(i))).get("name").equals(set.getKey()))
				{
					String s = (String)((JSONObject)(((JSONArray)jsonobj.get("inventory")).get(i))).get("stock");
					int exStockValue = Integer.parseInt(s);
					System.out.println("exStockValue value = "+exStockValue);
					int prodStockVlue = Integer.parseInt(set.getValue());
					System.out.println("prodStockVlue value = "+prodStockVlue);
					int modifiedStock = exStockValue - prodStockVlue ;
					Integer modst = new Integer(modifiedStock);
					String modStock =modst.toString();
					System.out.println("modStock value = "+modStock);
					((JSONObject)(((JSONArray)jsonobj.get("inventory")).get(i))).put("stock",modStock);
				}
			}
		}
		try {
			reader.close();
			writer = new FileWriter("C:\\Users\\MM\\Downloads\\Assignment\\assignment\\inventory.json");
			writer.write(jsonobj.toJSONString());
		} catch (IOException e) {
			e.printStackTrace();
		}	finally {
			try {
				writer.flush();
				writer.close();
				
			    reader.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		
	}
	
	public ProductDetail buyProduct(String name)
	{   
		ProductDetail pd = new ProductDetail();
			for (ProductDetail p : allProductdetails)
			{
				if(p.getProductName().equals(name)) 
				{
					pd=p;
				}
			}
			
			updateInventory(pd);
		return pd;
	}
	
	@SuppressWarnings("unchecked")
	public void modifyJson()
	{
		try {
			 reader = new FileReader("C:\\Users\\MM\\Downloads\\Assignment\\assignment\\inventory.json");
		} catch (Exception e) {
			e.printStackTrace();
		}
			JSONParser jsonParser = new JSONParser();
			try {
				inobj = jsonParser.parse(reader);
			} catch (Exception e) {
			} 
			JSONObject jsonobj = (JSONObject)inobj;
			((JSONObject)(((JSONArray)jsonobj.get("inventory")).get(0))).put("stock","9");
			for(int i=0;i<((JSONArray)jsonobj.get("inventory")).size();i++)
			{
				System.out.println("entered into first for of modify");
				if(((JSONObject)(((JSONArray)jsonobj.get("inventory")).get(i))).get("name").equals("screw"))
				{
					((JSONObject)(((JSONArray)jsonobj.get("inventory")).get(i))).put("stock","16");
					System.out.println("enterd into second for");
				}
			}
		try {
			reader.close();
			writer = new FileWriter("C:\\Users\\MM\\Downloads\\Assignment\\assignment\\inventory.json");
			writer.write(jsonobj.toJSONString());
		} catch (IOException e) {
			e.printStackTrace();
		}	finally {
			try {
				writer.flush();
				writer.close();
				
			    reader.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		
		
		
	}
	

}
