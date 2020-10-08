package implementation;

import java.util.Map;

public class Menu {
	private String creationDate;
	private int totalItemTypes;
	private Map<String, String[]> itemCateogries;
	private Map<String, String[]> itemUpdatedDate;
	public String getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}
	public Map<String, String[]> getItemCateogries() {
		return itemCateogries;
	}
	public void setItemCateogries(Map<String, String[]> itemCateogries) {
		this.itemCateogries = itemCateogries;
	}
	public int getTotalItemTypes() {
		return totalItemTypes;
	}
	public void setTotalItemTypes(int totalItemTypes) {
		this.totalItemTypes = totalItemTypes;
	}
	public Map<String, String[]> getItemUpdatedDate() {
		return itemUpdatedDate;
	}
	public void setItemUpdatedDate(Map<String, String[]> itemUpdatedDate) {
		this.itemUpdatedDate = itemUpdatedDate;
	}
}
