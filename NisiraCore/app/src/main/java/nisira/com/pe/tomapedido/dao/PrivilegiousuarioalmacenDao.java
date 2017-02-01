package nisira.com.pe.tomapedido.dao;

import com.nisira.core.BaseDao;
import nisira.com.pe.tomapedido.entity.Privilegiousuarioalmacen;
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
public class PrivilegiousuarioalmacenDao{

	public Boolean insert(Privilegiousuarioalmacen privilegiousuarioalmacen) {
		Boolean resultado = false;
		SQLiteDatabase mDb  = SQLiteDatabase.openDatabase(DataBaseClass.PATH_DATABASE,null, SQLiteDatabase.NO_LOCALIZED_COLLATORS);
		try{
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			ContentValues initialValues = new ContentValues();
			initialValues.put("IDBASEDATOS",privilegiousuarioalmacen.getIdbasedatos()); 
			initialValues.put("IDEMPRESA",privilegiousuarioalmacen.getIdempresa()); 
			initialValues.put("IDUSUARIO",privilegiousuarioalmacen.getIdusuario()); 
			initialValues.put("IDSUCURSAL",privilegiousuarioalmacen.getIdsucursal()); 
			initialValues.put("IDALMACEN",privilegiousuarioalmacen.getIdalmacen()); 
			initialValues.put("ESTADO",privilegiousuarioalmacen.getEstado()); 
			resultado = mDb.insert("PRIVILEGIOUSUARIOALMACEN",null,initialValues)>0; 
		} catch (Exception e) {
		}finally {
			mDb.close();
		} 
		return resultado; 
	} 

	public Boolean update(Privilegiousuarioalmacen privilegiousuarioalmacen,String where) {
		Boolean resultado = false;
		SQLiteDatabase mDb  = SQLiteDatabase.openDatabase(DataBaseClass.PATH_DATABASE,null, SQLiteDatabase.NO_LOCALIZED_COLLATORS);
		try{
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			ContentValues initialValues = new ContentValues();
			initialValues.put("IDBASEDATOS",privilegiousuarioalmacen.getIdbasedatos()) ; 
			initialValues.put("IDEMPRESA",privilegiousuarioalmacen.getIdempresa()) ; 
			initialValues.put("IDUSUARIO",privilegiousuarioalmacen.getIdusuario()) ; 
			initialValues.put("IDSUCURSAL",privilegiousuarioalmacen.getIdsucursal()) ; 
			initialValues.put("IDALMACEN",privilegiousuarioalmacen.getIdalmacen()) ; 
			initialValues.put("ESTADO",privilegiousuarioalmacen.getEstado()) ; 
			resultado = mDb.update("PRIVILEGIOUSUARIOALMACEN",initialValues,where,null)>0; 
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
			resultado = mDb.delete("PRIVILEGIOUSUARIOALMACEN",where,null)>0; 
		} catch (Exception e) {
		}finally {
			mDb.close();
		} 
		return resultado; 
	} 

	public ArrayList<Privilegiousuarioalmacen> listar(String where,String order,String limit) {
		ArrayList<Privilegiousuarioalmacen> lista  = new ArrayList<Privilegiousuarioalmacen>();
		SQLiteDatabase mDb  = SQLiteDatabase.openDatabase(DataBaseClass.PATH_DATABASE,null, SQLiteDatabase.NO_LOCALIZED_COLLATORS);
		try{
			Cursor cur =  mDb.query("PRIVILEGIOUSUARIOALMACEN",
					new String[] {
							 "IDBASEDATOS" ,
							 "IDEMPRESA" ,
							 "IDUSUARIO" ,
							 "IDSUCURSAL" ,
							 "IDALMACEN" ,
							 "ESTADO" 
					},
			where, null, null, order, limit);
			if (cur!=null){
				cur.moveToFirst();
				int j=0;
				while (cur.isAfterLast() == false) {
					Privilegiousuarioalmacen privilegiousuarioalmacen = new Privilegiousuarioalmacen() ;
					privilegiousuarioalmacen.setIdbasedatos(cur.getString(j++));
					privilegiousuarioalmacen.setIdempresa(cur.getString(j++));
					privilegiousuarioalmacen.setIdusuario(cur.getString(j++));
					privilegiousuarioalmacen.setIdsucursal(cur.getString(j++));
					privilegiousuarioalmacen.setIdalmacen(cur.getString(j++));
					privilegiousuarioalmacen.setEstado(cur.getDouble(j++));

					lista.add(privilegiousuarioalmacen); 
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