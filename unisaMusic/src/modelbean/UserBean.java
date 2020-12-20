package modelbean;

import java.io.Serializable;


public class UserBean implements Serializable, Cloneable{
	
	private static final long serialVersionUID = 1L;
	
	public UserBean() {
		id = -1;
		username = "";
		email = "";
		nome = "";
		cognome = "";
		tipo = false;
		active = true;
		dataNascita = "";
		cf = "";
		password = "";
		abbonamento = false;
	}
	
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String user) {
		this.username = user;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getCognome() {
		return cognome;
	}


	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	
	public boolean getTipo() {
		return tipo;
	}
	
	
	public void setTipo(boolean tipo) {
		this.tipo = tipo;
	}
	
	
	public boolean isActive() {
		return active;
	}

	
	public void setActive(boolean active) {
		this.active = active;
	}
	
	
	public String getDataNascita() {
		return dataNascita;
	}


	public void setDataNascita(String dataNascita) {
		this.dataNascita = dataNascita;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public void setCf(String cf) {
		this.cf = cf;
	}


	public String getCf() {
		return cf;
	}
	
	public boolean getAbbonamento() {
		return abbonamento;
	}
	
	public void setAbbonamento(boolean abbonamento) {
		this.abbonamento = abbonamento;
	}
	
	public String toString() {
		return getClass().getName() + "id" + id + "username" + username + "email" + email +
				"nome" + nome + "cognome" + cognome + "data di nascita " + dataNascita +
				"codice fiscale" + cf + "passwrd" + password;
	}
	
	public boolean equals(Object obj) {
		if(obj == null || obj.getClass() != getClass())
			return false;
		UserBean other = (UserBean) obj;
		return other.id == id;
	}
	
	public UserBean clone() {
		UserBean bn;
		try {
			bn = (UserBean) super.clone();
		} catch (CloneNotSupportedException e){
			return null;
		}
		return bn;
	}
	

	
	private int id;
	private String username;
	private String email;
	private String nome;
	private String cognome;
	private boolean tipo;
	private boolean active;
	private String dataNascita;
	private String cf;
	private String password;
	private boolean abbonamento;
}
