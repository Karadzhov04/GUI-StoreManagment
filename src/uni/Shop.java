package uni;

public class Shop {
	private String nameOfShop;
	private String adress;
	
	public Shop(String nameOfShop, String adress) {
		super();
		this.nameOfShop = nameOfShop;
		this.adress = adress;
	}
	
	public String getNameOfShop() {
		return nameOfShop;
	}

	public void setNameOfShop(String nameOfShop) {
		this.nameOfShop = nameOfShop;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}
	@Override
    public String toString() {
        return this.nameOfShop;
	}
}

