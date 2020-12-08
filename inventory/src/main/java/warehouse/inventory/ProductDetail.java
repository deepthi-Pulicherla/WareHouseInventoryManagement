package warehouse.inventory;

import java.util.ArrayList;
import java.util.HashMap;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ProductDetail {

	private String productName ;
	
	private HashMap<String, String> articlesAndAmount ;
	
	@Override
	public String toString() {
		return "ProductDetail [productName=" + productName + ", articlesAndAmount=" + articlesAndAmount + ", price="
				+ price + "]";
	}

	private int price;

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public HashMap<String, String> getArticlesAndAmount() {
		return articlesAndAmount;
	}

	public void setArticlesAndAmount(HashMap<String, String> articlesAndAmount) {
		this.articlesAndAmount = articlesAndAmount;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
}
