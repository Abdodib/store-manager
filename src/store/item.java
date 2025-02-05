package store;

public class item {

	private String itemName;
	private double price;
	private String pic;
	
	
	public item() {
		
	}
	
	public item(String itemName, double price, String pic) {
		super();
		this.itemName = itemName;
		this.price = price;
		this.pic = pic;
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
