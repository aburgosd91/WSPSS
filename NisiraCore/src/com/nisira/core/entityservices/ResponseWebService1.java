package com.nisira.core.entityservices;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import java.io.Serializable;


@XStreamAlias("ResponseWebService1")

public class ResponseWebService1<T1> implements Serializable{
	@SerializedName("lista1") 
	@XStreamAlias("lista1") 
	private ArrayList<T1> lista1;

	public ResponseWebService1(ArrayList<T1> lista1) {
		this.lista1 = lista1;

	}

	/* Sets & Gets */
	public void setLista1(ArrayList<T1> lista1) {
		this.lista1 = lista1;
	}

	public ArrayList<T1> getLista1() {
		return this.lista1;
	}


}