package modelbean;

public class ArtistaBean {
	public ArtistaBean() {
		nomeArte = "";
		numeroBrani = 0;
		//tipologia = true;
		ascolti = 0;
	}
	
	
	public String getNomeArte() {
		return nomeArte;
	}
	
	
	public void setNomeArte(String nomeArte) {
		this.nomeArte = nomeArte;
	}
	
	
	public int getNumeroBrani() {
		return numeroBrani;
	}
	
	
	public void setNumeroBrani(int numeroBrani) {
		this.numeroBrani = numeroBrani;
	}
	
	/*
	public boolean isTipologia() {
		return tipologia;
	}
	
	
	public void setTipologia(boolean tipologia) {
		this.tipologia = tipologia;
	}
	*/
	public int getAscolti() {
		return ascolti;
	}
	
	public void setAscolti(int ascolti) {
		this.ascolti = ascolti;
	}

	
	public String toString() {
		return getClass().getName() + "Nome D'Arte" + nomeArte + "numero di brani" + numeroBrani;
	}

	public boolean equals(Object object) {
		if(object == null || object.getClass() != getClass())
			return false;
		else
			return true;
	}
	
	public ArtistaBean clone() {
		ArtistaBean artista;
		try {
			artista = (ArtistaBean) super.clone();
		} catch (CloneNotSupportedException e){
			return null;
		}
		return artista;
	}

	private String nomeArte;
	private int numeroBrani;
	//private boolean tipologia;
	private int ascolti;
}
