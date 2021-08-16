package com.stockexchange.joedonedata.Exception;

public class DataException  extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public DataException() {

	}
	
	public DataException(String errorDesc) {
		super(errorDesc);
	}

	
}
