package nisira.com.pe.tomapedido.dao;

import com.nisira.core.BaseDao;
import nisira.com.pe.tomapedido.entity.Clieprov;
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
public class ClieprovDao{

	public Boolean insert(Clieprov clieprov) {
		Boolean resultado = false;
		SQLiteDatabase mDb  = SQLiteDatabase.openDatabase(DataBaseClass.PATH_DATABASE,null, SQLiteDatabase.NO_LOCALIZED_COLLATORS);
		try{
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			ContentValues initialValues = new ContentValues();
			initialValues.put("IDBASEDATOS",clieprov.getIdbasedatos()); 
			initialValues.put("IDEMPRESA",clieprov.getIdempresa()); 
			initialValues.put("IDCLIEPROV",clieprov.getIdclieprov()); 
			initialValues.put("RAZONSOCIAL",clieprov.getRazonsocial()); 
			initialValues.put("ESTADO",clieprov.getEstado()); 
			resultado = mDb.insert("CLIEPROV",null,initialValues)>0; 
		} catch (Exception e) {
		}finally {
			mDb.close();
		} 
		return resultado; 
	} 

	public Boolean update(Clieprov clieprov,String where) {
		Boolean resultado = false;
		SQLiteDatabase mDb  = SQLiteDatabase.openDatabase(DataBaseClass.PATH_DATABASE,null, SQLiteDatabase.NO_LOCALIZED_COLLATORS);
		try{
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			ContentValues initialValues = new ContentValues();
			initialValues.put("IDBASEDATOS",clieprov.getIdbasedatos()) ; 
			initialValues.put("IDEMPRESA",clieprov.getIdempresa()) ; 
			initialValues.put("IDCLIEPROV",clieprov.getIdclieprov()) ; 
			initialValues.put("RAZONSOCIAL",clieprov.getRazonsocial()) ; 
			initialValues.put("ESTADO",clieprov.getEstado()) ; 
			resultado = mDb.update("CLIEPROV",initialValues,where,null)>0; 
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
			resultado = mDb.delete("CLIEPROV",where,null)>0; 
		} catch (Exception e) {
		}finally {
			mDb.close();
		} 
		return resultado; 
	} 

	public ArrayList<Clieprov> listar(String where,String order,String limit) {
		ArrayList<Clieprov> lista  = new ArrayList<Clieprov>();
		SQLiteDatabase mDb  = SQLiteDatabase.openDatabase(DataBaseClass.PATH_DATABASE,null, SQLiteDatabase.NO_LOCALIZED_COLLATORS);
		try{
			Cursor cur =  mDb.query("CLIEPROV",
					new String[] {
							 "IDBASEDATOS" ,
							 "IDEMPRESA" ,
							 "IDCLIEPROV" ,
							 "RAZONSOCIAL" ,
							 "ESTADO" 
					},
			where, null, null, order, limit);
			if (cur!=null){
				cur.moveToFirst();
				int j=0;
				while (cur.isAfterLast() == false) {
					Clieprov clieprov = new Clieprov() ;
					clieprov.setIdbasedatos(cur.getString(j++));
					clieprov.setIdempresa(cur.getString(j++));
					clieprov.setIdclieprov(cur.getString(j++));
					clieprov.setRazonsocial(cur.getString(j++));
					clieprov.setEstado(cur.getDouble(j++));

					lista.add(clieprov); 
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