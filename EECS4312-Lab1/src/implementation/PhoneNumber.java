package implementation;

public class PhoneNumber {
	private int areaCode = 123;
	private int threeDigits = 456;
	private int fourDigits = 7890;
	public int getAreaCode() {
		return areaCode;
	}
	public void setAreaCode(int areaCode) {
		this.areaCode = areaCode;
	}
	public int getThreeDigits() {
		return threeDigits;
	}
	public void setThreeDigits(int threeDigits) {
		this.threeDigits = threeDigits;
	}
	public int getFourDigits() {
		return fourDigits;
	}
	public void setFourDigits(int fourDigits) {
		this.fourDigits = fourDigits;
	}
}
