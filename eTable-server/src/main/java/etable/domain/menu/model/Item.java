package etable.domain.menu.model;

public class Item {
	private int citem;
	private String item;
	
	public Item() {
		
	}
	
	public Item(int citem, String item) {
		super();
		this.citem = citem;
		this.item = item;
	}
	
	public int getCitem() {
		return citem;
	}
	public void setCitem(int citem) {
		this.citem = citem;
	}
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	
}
