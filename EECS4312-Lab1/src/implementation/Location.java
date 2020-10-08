package implementation;

public class Location {
	private int addressNumber;
	private String country;
	private String city;
	private String poscalCode;
	public int getAddressNumber() {
		return addressNumber;
	}
	public void setAddressNumber(int addressNumber) {
		this.addressNumber = addressNumber;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPoscalCode() {
		return poscalCode;
	}
	public void setPoscalCode(String postalCode) {
		this.poscalCode = poscalCode;
	}
}
