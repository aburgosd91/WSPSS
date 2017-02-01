package nisira.com.pe.tomapedido.dao;

import com.nisira.core.BaseDao;
import nisira.com.pe.tomapedido.entity.Dpedidomovil;
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
public class DpedidomovilDao{

	public Boolean insert(Dpedidomovil dpedidomovil) {
		Boolean resultado = false;
		SQLiteDatabase mDb  = SQLiteDatabase.openDatabase(DataBaseClass.PATH_DATABASE,null, SQLiteDatabase.NO_LOCALIZED_COLLATORS);
		try{
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			ContentValues initialValues = new ContentValues();
			initialValues.put("IDBASEDATOS",dpedidomovil.getIdbasedatos()); 
			initialValues.put("IDEMPRESA",dpedidomovil.getIdempresa()); 
			initialValues.put("IDPEDIDO",dpedidomovil.getIdpedido()); 
			initialValues.put("ITEM",dpedidomovil.getItem()); 
			initialValues.put("IDSUCURSAL",dpedidomovil.getIdsucursal()); 
			initialValues.put("DESCSUCURSAL",dpedidomovil.getDescsucursal()); 
			initialValues.put("IDALMACEN",dpedidomovil.getIdalmacen()); 
			initialValues.put("DESCALMACEN",dpedidomovil.getDescalmacen()); 
			initialValues.put("IDPRODUCTO",dpedidomovil.getIdproducto()); 
			initialValues.put("DESCPRODUCTO",dpedidomovil.getDescproducto()); 
			initialValues.put("IDMEDIDA",dpedidomovil.getIdmedida()); 
			initialValues.put("CANTIDAD",dpedidomovil.getCantidad()); 
			initialValues.put("PRECIO",dpedidomovil.getPrecio()); 
			initialValues.put("IMPORTE",dpedidomovil.getImporte()); 
			resultado = mDb.insert("DPEDIDOMOVIL",null,initialValues)>0; 
		} catch (Exception e) {
		}finally {
			mDb.close();
		} 
		return resultado; 
	} 

	public Boolean update(Dpedidomovil dpedidomovil,String where) {
		Boolean resultado = false;
		SQLiteDatabase mDb  = SQLiteDatabase.openDatabase(DataBaseClass.PATH_DATABASE,null, SQLiteDatabase.NO_LOCALIZED_COLLATORS);
		try{
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			ContentValues initialValues = new ContentValues();
			initialValues.put("IDBASEDATOS",dpedidomovil.getIdbasedatos()) ; 
			initialValues.put("IDEMPRESA",dpedidomovil.getIdempresa()) ; 
			initialValues.put("IDPEDIDO",dpedidomovil.getIdpedido()) ; 
			initialValues.put("ITEM",dpedidomovil.getItem()) ; 
			initialValues.put("IDSUCURSAL",dpedidomovil.getIdsucursal()) ; 
			initialValues.put("DESCSUCURSAL",dpedidomovil.getDescsucursal()) ; 
			initialValues.put("IDALMACEN",dpedidomovil.getIdalmacen()) ; 
			initialValues.put("DESCALMACEN",dpedidomovil.getDescalmacen()) ; 
			initialValues.put("IDPRODUCTO",dpedidomovil.getIdproducto()) ; 
			initialValues.put("DESCPRODUCTO",dpedidomovil.getDescproducto()) ; 
			initialValues.put("IDMEDIDA",dpedidomovil.getIdmedida()) ; 
			initialValues.put("CANTIDAD",dpedidomovil.getCantidad()) ; 
			initialValues.put("PRECIO",dpedidomovil.getPrecio()) ; 
			initialValues.put("IMPORTE",dpedidomovil.getImporte()) ; 
			resultado = mDb.update("DPEDIDOMOVIL",initialValues,where,null)>0; 
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
			resultado = mDb.delete("DPEDIDOMOVIL",where,null)>0; 
		} catch (Exception e) {
		}finally {
			mDb.close();
		} 
		return resultado; 
	} 

	public ArrayList<Dpedidomovil> listar(String where,String order,String limit) {
		ArrayList<Dpedidomovil> lista  = new ArrayList<Dpedidomovil>();
		SQLiteDatabase mDb  = SQLiteDatabase.openDatabase(DataBaseClass.PATH_DATABASE,null, SQLiteDatabase.NO_LOCALIZED_COLLATORS);
		try{
			Cursor cur =  mDb.query("DPEDIDOMOVIL",
					new String[] {
							 "IDBASEDATOS" ,
							 "IDEMPRESA" ,
							 "IDPEDIDO" ,
							 "ITEM" ,
							 "IDSUCURSAL" ,
							 "DESCSUCURSAL" ,
							 "IDALMACEN" ,
							 "DESCALMACEN" ,
							 "IDPRODUCTO" ,
							 "DESCPRODUCTO" ,
							 "IDMEDIDA" ,
							 "CANTIDAD" ,
							 "PRECIO" ,
							 "IMPORTE" 
					},
			where, null, null, order, limit);
			if (cur!=null){
				cur.moveToFirst();
				int j=0;
				while (cur.isAfterLast() == false) {
					Dpedidomovil dpedidomovil = new Dpedidomovil() ;
					dpedidomovil.setIdbasedatos(cur.getString(j++));
					dpedidomovil.setIdempresa(cur.getString(j++));
					dpedidomovil.setIdpedido(cur.getString(j++));
					dpedidomovil.setItem(cur.getInt(j++));
					dpedidomovil.setIdsucursal(cur.getString(j++));
					dpedidomovil.setDescsucursal(cur.getString(j++));
					dpedidomovil.setIdalmacen(cur.getString(j++));
					dpedidomovil.setDescalmacen(cur.getString(j++));
					dpedidomovil.setIdproducto(cur.getString(j++));
					dpedidomovil.setDescproducto(cur.getString(j++));
					dpedidomovil.setIdmedida(cur.getString(j++));
					dpedidomovil.setCantidad(cur.getDouble(j++));
					dpedidomovil.setPrecio(cur.getDouble(j++));
					dpedidomovil.setImporte(cur.getDouble(j++));

					lista.add(dpedidomovil); 
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