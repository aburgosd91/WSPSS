package nisira.com.pe.tomapedido.dao;

import com.nisira.core.BaseDao;
import nisira.com.pe.tomapedido.entity.Almacen;
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
public class AlmacenDao{

	public Boolean insert(Almacen almacen) {
		Boolean resultado = false;
		SQLiteDatabase mDb  = SQLiteDatabase.openDatabase(DataBaseClass.PATH_DATABASE,null, SQLiteDatabase.NO_LOCALIZED_COLLATORS);
		try{
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			ContentValues initialValues = new ContentValues();
			initialValues.put("IDBASEDATOS",almacen.getIdbasedatos()); 
			initialValues.put("IDEMPRESA",almacen.getIdempresa()); 
			initialValues.put("IDSUCURSAL",almacen.getIdsucursal()); 
			initialValues.put("IDALMACEN",almacen.getIdalmacen()); 
			initialValues.put("DESCALMACEN",almacen.getDescalmacen()); 
			initialValues.put("ESTADO",almacen.getEstado()); 
			resultado = mDb.insert("ALMACEN",null,initialValues)>0; 
		} catch (Exception e) {
		}finally {
			mDb.close();
		} 
		return resultado; 
	} 

	public Boolean update(Almacen almacen,String where) {
		Boolean resultado = false;
		SQLiteDatabase mDb  = SQLiteDatabase.openDatabase(DataBaseClass.PATH_DATABASE,null, SQLiteDatabase.NO_LOCALIZED_COLLATORS);
		try{
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			ContentValues initialValues = new ContentValues();
			initialValues.put("IDBASEDATOS",almacen.getIdbasedatos()) ; 
			initialValues.put("IDEMPRESA",almacen.getIdempresa()) ; 
			initialValues.put("IDSUCURSAL",almacen.getIdsucursal()) ; 
			initialValues.put("IDALMACEN",almacen.getIdalmacen()) ; 
			initialValues.put("DESCALMACEN",almacen.getDescalmacen()) ; 
			initialValues.put("ESTADO",almacen.getEstado()) ; 
			resultado = mDb.update("ALMACEN",initialValues,where,null)>0; 
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
			resultado = mDb.delete("ALMACEN",where,null)>0; 
		} catch (Exception e) {
		}finally {
			mDb.close();
		} 
		return resultado; 
	} 

	public ArrayList<Almacen> listar(String where,String order,String limit) {
		ArrayList<Almacen> lista  = new ArrayList<Almacen>();
		SQLiteDatabase mDb  = SQLiteDatabase.openDatabase(DataBaseClass.PATH_DATABASE,null, SQLiteDatabase.NO_LOCALIZED_COLLATORS);
		try{
			Cursor cur =  mDb.query("ALMACEN",
					new String[] {
							 "IDBASEDATOS" ,
							 "IDEMPRESA" ,
							 "IDSUCURSAL" ,
							 "IDALMACEN" ,
							 "DESCALMACEN" ,
							 "ESTADO" 
					},
			where, null, null, order, limit);
			if (cur!=null){
				cur.moveToFirst();
				int j=0;
				while (cur.isAfterLast() == false) {
					Almacen almacen = new Almacen() ;
					almacen.setIdbasedatos(cur.getString(j++));
					almacen.setIdempresa(cur.getString(j++));
					almacen.setIdsucursal(cur.getString(j++));
					almacen.setIdalmacen(cur.getString(j++));
					almacen.setDescalmacen(cur.getString(j++));
					almacen.setEstado(cur.getDouble(j++));

					lista.add(almacen); 
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