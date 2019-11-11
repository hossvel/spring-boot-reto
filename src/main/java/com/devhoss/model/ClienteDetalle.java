package com.devhoss.model;

import java.util.Date;

public class ClienteDetalle  extends Cliente {
	
	private Date fechaProbableMuerte;

	public Date getFechaProbableMuerte() {
		return fechaProbableMuerte;
	}

	public void setFechaProbableMuerte(Date fechaProbableMuerte) {
		this.fechaProbableMuerte = fechaProbableMuerte;
	}
	
	
}
