package nisira.com.pe.tomapedido.dao;

import com.nisira.core.BaseDao;
import nisira.com.pe.tomapedido.entity.Pedidomovil;
import java.util.List;
import android.database.sqlite.SQLiteDatabase;
import nisira.com.pe.tomapedido.database.DataBaseClass;
import android.content.ContentValues;
import android.database.Cursor;
import nisira.com.pe.tomapedido.util.Clave;
import java.util.ArrayList;
import java.util.LinkedList;
import java.text.SimpleDateFormat;
import java.util.Date;
import com.nisira.core.NisiraORMException;
public class PedidomovilDao{

	public Boolean insert(Pedidomovil pedidomovil) {
		Boolean resultado = false;
		SQLiteDatabase mDb  = SQLiteDatabase.openDatabase(DataBaseClass.PATH_DATABASE,null, SQLiteDatabase.NO_LOCALIZED_COLLATORS);
		try{
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			ContentValues initialValues = new ContentValues();
			initialValues.put("IDBASEDATOS",pedidomovil.getIdbasedatos()); 
			initialValues.put("IDEMPRESA",pedidomovil.getIdempresa()); 
			initialValues.put("IDPEDIDO",pedidomovil.getIdpedido()); 
			initialValues.put("FECHA",dateFormat.format(pedidomovil.getFecha() ) ); 
			initialValues.put("HORA",pedidomovil.getHora()); 
			initialValues.put("IDVENDEDOR",pedidomovil.getIdvendedor()); 
			initialValues.put("DESCVENDEDOR",pedidomovil.getDescvendedor()); 
			initialValues.put("IDCLIEPROV",pedidomovil.getIdclieprov()); 
			initialValues.put("DESCCLIEPROV",pedidomovil.getDescclieprov()); 
			initialValues.put("SERIE",pedidomovil.getSerie()); 
			initialValues.put("NUMERO",pedidomovil.getNumero()); 
			initialValues.put("ESTADO",pedidomovil.getEstado()); 
			resultado = mDb.insert("PEDIDOMOVIL",null,initialValues)>0; 
		} catch (Exception e) {
		}finally {
			mDb.close();
		} 
		return resultado; 
	} 

	public Boolean update(Pedidomovil pedidomovil,String where) {
		Boolean resultado = false;
		SQLiteDatabase mDb  = SQLiteDatabase.openDatabase(DataBaseClass.PATH_DATABASE,null, SQLiteDatabase.NO_LOCALIZED_COLLATORS);
		try{
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			ContentValues initialValues = new ContentValues();
			initialValues.put("IDBASEDATOS",pedidomovil.getIdbasedatos()) ; 
			initialValues.put("IDEMPRESA",pedidomovil.getIdempresa()) ; 
			initialValues.put("IDPEDIDO",pedidomovil.getIdpedido()) ; 
			initialValues.put("FECHA",dateFormat.format(pedidomovil.getFecha() ) ) ; 
			initialValues.put("HORA",pedidomovil.getHora()) ; 
			initialValues.put("IDVENDEDOR",pedidomovil.getIdvendedor()) ; 
			initialValues.put("DESCVENDEDOR",pedidomovil.getDescvendedor()) ; 
			initialValues.put("IDCLIEPROV",pedidomovil.getIdclieprov()) ; 
			initialValues.put("DESCCLIEPROV",pedidomovil.getDescclieprov()) ; 
			initialValues.put("SERIE",pedidomovil.getSerie()) ; 
			initialValues.put("NUMERO",pedidomovil.getNumero()) ; 
			initialValues.put("ESTADO",pedidomovil.getEstado()) ; 
			resultado = mDb.update("PEDIDOMOVIL",initialValues,where,null)>0; 
		} catch (Exception e) {
		}finally {
			mDb.close();
		} 
		return resultado; 
	} 
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	public Boolean delete(String where) {
		Boolean resultado = false;
		SQLiteDatabase mDb  = SQLiteDatabase.openDatabase(DataBaseClass.PATH_DATABASE,null, SQLiteDatabase.NO_LOCALIZED_COLLATORS);
		try{
			resultado = mDb.delete("PEDIDOMOVIL",where,null)>0; 
		} catch (Exception e) {
		}finally {
			mDb.close();
		} 
		return resultado; 
	} 

	public ArrayList<Pedidomovil> listar(String where,String order,String limit) {
		ArrayList<Pedidomovil> lista  = new ArrayList<Pedidomovil>();
		SQLiteDatabase mDb  = SQLiteDatabase.openDatabase(DataBaseClass.PATH_DATABASE,null, SQLiteDatabase.NO_LOCALIZED_COLLATORS);
		try{
			Cursor cur =  mDb.query("PEDIDOMOVIL",
					new String[] {
							 "IDBASEDATOS" ,
							 "IDEMPRESA" ,
							 "IDPEDIDO" ,
							 "FECHA" ,
							 "HORA" ,
							 "IDVENDEDOR" ,
							 "DESCVENDEDOR" ,
							 "IDCLIEPROV" ,
							 "DESCCLIEPROV" ,
							 "SERIE" ,
							 "NUMERO" ,
							 "ESTADO" 
					},
			where, null, null, order, limit);
			if (cur!=null){
				cur.moveToFirst();
				int j=0;
				while (cur.isAfterLast() == false) {
					Pedidomovil pedidomovil = new Pedidomovil() ;
					pedidomovil.setIdbasedatos(cur.getString(j++));
					pedidomovil.setIdempresa(cur.getString(j++));
					pedidomovil.setIdpedido(cur.getString(j++));
					pedidomovil.setFecha(dateFormat.parse(cur.getString(j++)) );
					pedidomovil.setHora(cur.getString(j++));
					pedidomovil.setIdvendedor(cur.getString(j++));
					pedidomovil.setDescvendedor(cur.getString(j++));
					pedidomovil.setIdclieprov(cur.getString(j++));
					pedidomovil.setDescclieprov(cur.getString(j++));
					pedidomovil.setSerie(cur.getString(j++));
					pedidomovil.setNumero(cur.getString(j++));
					pedidomovil.setEstado(cur.getString(j++));

					lista.add(pedidomovil); 
					cur.moveToNext(); 
				} 
				cur.close(); 
			} 
		} catch (Exception e) {
		}finally {
			mDb.close();
		} 
		return lista; 
	} 
}