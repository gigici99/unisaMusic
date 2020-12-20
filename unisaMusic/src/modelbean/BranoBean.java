package modelbean;

import java.io.Serializable;

public class BranoBean implements Cloneable, Serializable {
	private static final long serialVersionUID = 1L;

	public BranoBean() {
		id = -1;
		title = "";
		time = "";
		nomeArtista = "";
		ascolti = 0;
	}
	
	public int getID() {
		return id;
	}
	
	public void setID(int id) {
		this.id = id;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getTime() {
		return time;
	}
	
	public void setTime(String time) {
		this.time = time;
	}
	
	public String getNomeArtista() {
		return nomeArtista;
	}
	
	public void setNomeArtista(String nomeArtista) {
		this.nomeArtista = nomeArtista;
	}
	
	public long getAscolti() {
		return ascolti;
	}
	
	public void setAscolti(int ascolti) {
		this.ascolti = ascolti;
	}

	public String toString() {
		return getClass().getName() + "ID" + id + "Titolo" + title + "Durata" + time + "Cantante" + nomeArtista;
	}

	public boolean equals(Object object) {
		if(object == null || object.getClass() != getClass())
			return false;
		else
		{
			BranoBean b=(BranoBean) object;
			if(b.getID()==this.id)
			{
				return true;
			}
			else 
				{
				return false;
				}
	}
	}
	
	public BranoBean clone() {
		BranoBean bn;
		try {
			bn = (BranoBean) super.clone();
		} catch (CloneNotSupportedException e){
			return null;
		}
		return bn;
	}
	

	private int id;
	private String title;
	private String time;
	private String nomeArtista;
	private int ascolti;
}
