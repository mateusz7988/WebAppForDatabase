package bdbt_bada_project.SpringApplication;

public class User {
	private int NIP;
	private int ID_Operatora;
	private String Nazwa;
	private int Numer_KRS;
	private int Numer_REGON;
	private String Data_zalozenia;

	public User(int ID_Operatora, String Nazwa, String Data_zalozenia, int NIP, int Numer_KRS, int Numer_REGON) {
		super();
		this.ID_Operatora = ID_Operatora;
		this.Nazwa = Nazwa;
		this.Data_zalozenia = Data_zalozenia;
		this.NIP = NIP;
		this.Numer_KRS = Numer_KRS;
		this.Numer_REGON = Numer_REGON;

	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getID_Operatora() {
		return ID_Operatora;
	}

	public void setID_Operatora(int ID_Operatora) {
		this.ID_Operatora = ID_Operatora;
	}

	public String getNazwa() {
		return Nazwa;
	}

	public void setNazwa(String nazwa) {
		this.Nazwa = nazwa;
	}

	public String getData_zalozenia() {
		return Data_zalozenia;
	}

	public void setData_zalozenia(String data) {
		this.Data_zalozenia = data;
	}

	public int getNIP() {
		return NIP;
	}

	public void setNIP(int NIP) {
		this.NIP = NIP;
	}

	public int getNumer_KRS() {
		return Numer_KRS;
	}

	public void setNumer_KRS(int Numer_KRS) {
		this.Numer_KRS = Numer_KRS;
	}

	public int getNumer_REGON() {
		return Numer_REGON;
	}

	public void setNumer_REGON(int Numer_REGON) {
		this.Numer_REGON = Numer_REGON;
	}


	@Override
	public String toString() {
		return "User [ID_Operatora=" + ID_Operatora + ", Nazwa=" + Nazwa + ", Data_zalozenia=" + Data_zalozenia + ", NIP=" + NIP + ", Numer_KRS=" + Numer_KRS + ", Numer_REGON=" + Numer_REGON + "]";
	}



}

