package nisira.com.pe.tomapedido.entityservices;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import com.thoughtworks.xstream.annotations.XStreamAlias;


@XStreamAlias("ResponseWebService3")

public class ResponseWebService3<T1,T2,T3> {
	@SerializedName("lista1") 
	@XStreamAlias("lista1") 
	private ArrayList<T1> lista1;
	@SerializedName("lista2") 
	@XStreamAlias("lista2") 
	private ArrayList<T2> lista2;
	@SerializedName("lista3") 
	@XStreamAlias("lista3") 
	private ArrayList<T3> lista3;

	public ResponseWebService3(ArrayList<T1> lista1 , ArrayList<T2> lista2 , ArrayList<T3> lista3) {
		this.lista1 = lista1;
		this.lista2 = lista2;
		this.lista3 = lista3;

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


}