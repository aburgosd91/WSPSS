package nisira.com.pe.tomapedido.dao;

import com.nisira.core.BaseDao;
import nisira.com.pe.tomapedido.entity.Producto;
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
public class ProductoDao{

	public Boolean insert(Producto producto) {
		Boolean resultado = false;
		SQLiteDatabase mDb  = SQLiteDatabase.openDatabase(DataBaseClass.PATH_DATABASE,null, SQLiteDatabase.NO_LOCALIZED_COLLATORS);
		try{
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			ContentValues initialValues = new ContentValues();
			initialValues.put("IDBASEDATOS",producto.getIdbasedatos()); 
			initialValues.put("IDEMPRESA",producto.getIdempresa()); 
			initialValues.put("IDPRODUCTO",producto.getIdproducto()); 
			initialValues.put("DESCRIPCION",producto.getDescripcion()); 
			initialValues.put("IDMEDIDA",producto.getIdmedida()); 
			initialValues.put("IDGRUPO",producto.getIdgrupo()); 
			initialValues.put("IDSUBGRUPO",producto.getIdsubgrupo()); 
			initialValues.put("ESTADO",producto.getEstado()); 
			resultado = mDb.insert("PRODUCTO",null,initialValues)>0; 
		} catch (Exception e) {
		}finally {
			mDb.close();
		} 
		return resultado; 
	} 

	public Boolean update(Producto producto,String where) {
		Boolean resultado = false;
		SQLiteDatabase mDb  = SQLiteDatabase.openDatabase(DataBaseClass.PATH_DATABASE,null, SQLiteDatabase.NO_LOCALIZED_COLLATORS);
		try{
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			ContentValues initialValues = new ContentValues();
			initialValues.put("IDBASEDATOS",producto.getIdbasedatos()) ; 
			initialValues.put("IDEMPRESA",producto.getIdempresa()) ; 
			initialValues.put("IDPRODUCTO",producto.getIdproducto()) ; 
			initialValues.put("DESCRIPCION",producto.getDescripcion()) ; 
			initialValues.put("IDMEDIDA",producto.getIdmedida()) ; 
			initialValues.put("IDGRUPO",producto.getIdgrupo()) ; 
			initialValues.put("IDSUBGRUPO",producto.getIdsubgrupo()) ; 
			initialValues.put("ESTADO",producto.getEstado()) ; 
			resultado = mDb.update("PRODUCTO",initialValues,where,null)>0; 
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
			resultado = mDb.delete("PRODUCTO",where,null)>0; 
		} catch (Exception e) {
		}finally {
			mDb.close();
		} 
		return resultado; 
	} 

	public ArrayList<Producto> listar(String where,String order,String limit) {
		ArrayList<Producto> lista  = new ArrayList<Producto>();
		SQLiteDatabase mDb  = SQLiteDatabase.openDatabase(DataBaseClass.PATH_DATABASE,null, SQLiteDatabase.NO_LOCALIZED_COLLATORS);
		try{
			Cursor cur =  mDb.query("PRODUCTO",
					new String[] {
							 "IDBASEDATOS" ,
							 "IDEMPRESA" ,
							 "IDPRODUCTO" ,
							 "DESCRIPCION" ,
							 "IDMEDIDA" ,
							 "IDGRUPO" ,
							 "IDSUBGRUPO" ,
							 "ESTADO" 
					},
			where, null, null, order, limit);
			if (cur!=null){
				cur.moveToFirst();
				int j=0;
				while (cur.isAfterLast() == false) {
					Producto producto = new Producto() ;
					producto.setIdbasedatos(cur.getString(j++));
					producto.setIdempresa(cur.getString(j++));
					producto.setIdproducto(cur.getString(j++));
					producto.setDescripcion(cur.getString(j++));
					producto.setIdmedida(cur.getString(j++));
					producto.setIdgrupo(cur.getString(j++));
					producto.setIdsubgrupo(cur.getString(j++));
					producto.setEstado(cur.getDouble(j++));

					lista.add(producto); 
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