package modelbean;

public class CanzoniAcquistateBean {
	public CanzoniAcquistateBean() {
		idCliente = idBrano = 0;
	}
	
	public int getIdCliente() {
		return idCliente;
	}
	
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	
	public int getIdBrano() {
		return idBrano;
	}
	
	public void setIdBrano(int idBrano) {
		this.idBrano = idBrano;
	}
	
	int idCliente;
	int idBrano;
}
