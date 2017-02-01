package nisira.com.pe.tomapedido.dao;

import com.nisira.core.BaseDao;
import nisira.com.pe.tomapedido.entity.Sucursal;
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
public class SucursalDao{

	public Boolean insert(Sucursal sucursal) {
		Boolean resultado = false;
		SQLiteDatabase mDb  = SQLiteDatabase.openDatabase(DataBaseClass.PATH_DATABASE,null, SQLiteDatabase.NO_LOCALIZED_COLLATORS);
		try{
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			ContentValues initialValues = new ContentValues();
			initialValues.put("IDBASEDATOS",sucursal.getIdbasedatos()); 
			initialValues.put("IDEMPRESA",sucursal.getIdempresa()); 
			initialValues.put("IDSUCURSAL",sucursal.getIdsucursal()); 
			initialValues.put("DESCSUCURSAL",sucursal.getDescsucursal()); 
			initialValues.put("ESTADO",sucursal.getEstado()); 
			resultado = mDb.insert("SUCURSAL",null,initialValues)>0; 
		} catch (Exception e) {
		}finally {
			mDb.close();
		} 
		return resultado; 
	} 

	public Boolean update(Sucursal sucursal,String where) {
		Boolean resultado = false;
		SQLiteDatabase mDb  = SQLiteDatabase.openDatabase(DataBaseClass.PATH_DATABASE,null, SQLiteDatabase.NO_LOCALIZED_COLLATORS);
		try{
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			ContentValues initialValues = new ContentValues();
			initialValues.put("IDBASEDATOS",sucursal.getIdbasedatos()) ; 
			initialValues.put("IDEMPRESA",sucursal.getIdempresa()) ; 
			initialValues.put("IDSUCURSAL",sucursal.getIdsucursal()) ; 
			initialValues.put("DESCSUCURSAL",sucursal.getDescsucursal()) ; 
			initialValues.put("ESTADO",sucursal.getEstado()) ; 
			resultado = mDb.update("SUCURSAL",initialValues,where,null)>0; 
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
			resultado = mDb.delete("SUCURSAL",where,null)>0; 
		} catch (Exception e) {
		}finally {
			mDb.close();
		} 
		return resultado; 
	} 

	public ArrayList<Sucursal> listar(String where,String order,String limit) {
		ArrayList<Sucursal> lista  = new ArrayList<Sucursal>();
		SQLiteDatabase mDb  = SQLiteDatabase.openDatabase(DataBaseClass.PATH_DATABASE,null, SQLiteDatabase.NO_LOCALIZED_COLLATORS);
		try{
			Cursor cur =  mDb.query("SUCURSAL",
					new String[] {
							 "IDBASEDATOS" ,
							 "IDEMPRESA" ,
							 "IDSUCURSAL" ,
							 "DESCSUCURSAL" ,
							 "ESTADO" 
					},
			where, null, null, order, limit);
			if (cur!=null){
				cur.moveToFirst();
				int j=0;
				while (cur.isAfterLast() == false) {
					Sucursal sucursal = new Sucursal() ;
					sucursal.setIdbasedatos(cur.getString(j++));
					sucursal.setIdempresa(cur.getString(j++));
					sucursal.setIdsucursal(cur.getString(j++));
					sucursal.setDescsucursal(cur.getString(j++));
					sucursal.setEstado(cur.getDouble(j++));

					lista.add(sucursal); 
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