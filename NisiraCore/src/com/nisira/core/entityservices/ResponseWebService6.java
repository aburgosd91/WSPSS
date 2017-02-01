package com.nisira.core.entityservices;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import java.io.Serializable;


@XStreamAlias("ResponseWebService6")

public class ResponseWebService6<T1,T2,T3,T4,T5,T6> implements Serializable{
	@SerializedName("lista1") 
	@XStreamAlias("lista1") 
	private ArrayList<T1> lista1;
	@SerializedName("lista2") 
	@XStreamAlias("lista2") 
	private ArrayList<T2> lista2;
	@SerializedName("lista3") 
	@XStreamAlias("lista3") 
	private ArrayList<T3> lista3;
	@SerializedName("lista4") 
	@XStreamAlias("lista4") 
	private ArrayList<T4> lista4;
	@SerializedName("lista5") 
	@XStreamAlias("lista5") 
	private ArrayList<T5> lista5;
	@SerializedName("lista6") 
	@XStreamAlias("lista6") 
	private ArrayList<T6> lista6;

	public ResponseWebService6(ArrayList<T1> lista1 , ArrayList<T2> lista2 , ArrayList<T3> lista3 , ArrayList<T4> lista4 , ArrayList<T5> lista5 , ArrayList<T6> lista6) {
		this.lista1 = lista1;
		this.lista2 = lista2;
		this.lista3 = lista3;
		this.lista4 = lista4;
		this.lista5 = lista5;
		this.lista6 = lista6;

	}

	/* Sets & Gets */
	public void setLista1(ArrayList<T1> lista1) {
		this.lista1 = lista1;
	}

	public ArrayList<T1> getLista1() {
		return this.lista1;
	}

	public void setLista2(ArrayList<T2> lista2) {
		this.lista2 = lista2;
	}

	public ArrayList<T2> getLista2() {
		return this.lista2;
	}

	public void setLista3(ArrayList<T3> lista3) {
		this.lista3 = lista3;
	}

	public ArrayList<T3> getLista3() {
		return this.lista3;
	}

	public void setLista4(ArrayList<T4> lista4) {
		this.lista4 = lista4;
	}

	public ArrayList<T4> getLista4() {
		return this.lista4;
	}

	public void setLista5(ArrayList<T5> lista5) {
		this.lista5 = lista5;
	}

	public ArrayList<T5> getLista5() {
		return this.lista5;
	}

	public void setLista6(ArrayList<T6> lista6) {
		this.lista6 = lista6;
	}

	public ArrayList<T6> getLista6() {
		return this.lista6;
	}


}