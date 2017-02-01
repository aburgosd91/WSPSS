package nisira.com.pe.tomapedido.entityservices;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import com.thoughtworks.xstream.annotations.XStreamAlias;


@XStreamAlias("ResponseWebService2")

public class ResponseWebService2<T1,T2> {
	@SerializedName("lista1") 
	@XStreamAlias("lista1") 
	private ArrayList<T1> lista1;
	@SerializedName("lista2") 
	@XStreamAlias("lista2") 
	private ArrayList<T2> lista2;

	public ResponseWebService2(ArrayList<T1> lista1 , ArrayList<T2> lista2) {
		this.lista1 = lista1;
		this.lista2 = lista2;

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


}