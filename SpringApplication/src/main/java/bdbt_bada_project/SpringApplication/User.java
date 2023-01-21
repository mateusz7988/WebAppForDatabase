package bdbt_bada_project.SpringApplication;

public class User {
	private int id;
	private String router;
	private int quantity;
	private float ammount;

	public User(int id, String router, int quantity, float ammount) {
		super();
		this.id = id;
		this.router = router;
		this.quantity = quantity;
		this.ammount = ammount;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRouter() {
		return router;
	}

	public void setRouter(String router) {
		this.router = router;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public float getAmmount() {
		return ammount;
	}

	public void setAmmount(float ammount) {
		this.ammount = ammount;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", router=" + router + ", quantity=" + quantity + ", ammount=" + ammount + "]";
	}



}

