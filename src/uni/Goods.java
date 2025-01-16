package uni;

public class Goods {
	 	 private String name;
		 private String category;
		 private int quantity;
		 private float price;
		 private String producer;
		 
		public Goods(String name, String category, int quantity, float price, String producer) {
			super();
			this.name = name;
			this.category = category;
			this.quantity = quantity;
			this.price = price;
			this.producer = producer;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getCategory() {
			return category;
		}

		public void setCategory(String category) {
			this.category = category;
		}

		public int getQuantity() {
			return quantity;
		}

		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}

		public float getPrice() {
			return price;
		}

		public void setPrice(float price) {
			this.price = price;
		}

		public String getProducer() {
			return producer;
		}

		public void setProducer(String producer) {
			this.producer = producer;
		}
		@Override
	    public String toString() {
	        return this.name;
		}
		}

