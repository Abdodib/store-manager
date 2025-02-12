package store;

public class item {

	private String itemName;
	private double price;
	private String pic;
	 private String quantity;
	
	public item() {
		
	}
	
	public item(String itemName, double price, String pic,String quantity) {
		super();
		this.itemName = itemName;
		this.price = price;
		this.pic = pic;
		this.quantity = quantity;
	}
	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	
	
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
