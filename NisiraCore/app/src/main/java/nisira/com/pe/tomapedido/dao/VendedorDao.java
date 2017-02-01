package nisira.com.pe.tomapedido.dao;

import com.nisira.core.BaseDao;
import nisira.com.pe.tomapedido.entity.Vendedor;
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
public class VendedorDao{

	public Boolean insert(Vendedor vendedor) {
		Boolean resultado = false;
		SQLiteDatabase mDb  = SQLiteDatabase.openDatabase(DataBaseClass.PATH_DATABASE,null, SQLiteDatabase.NO_LOCALIZED_COLLATORS);
		try{
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			ContentValues initialValues = new ContentValues();
			initialValues.put("IDBASEDATOS",vendedor.getIdbasedatos()); 
			initialValues.put("IDEMPRESA",vendedor.getIdempresa()); 
			initialValues.put("IDVENDEDOR",vendedor.getIdvendedor()); 
			initialValues.put("DESCRIPCION",vendedor.getDescripcion()); 
			initialValues.put("NOMBRECORTO",vendedor.getNombrecorto()); 
			initialValues.put("IDUSUARIO",vendedor.getIdusuario()); 
			initialValues.put("ESTADO",vendedor.getEstado()); 
			resultado = mDb.insert("VENDEDOR",null,initialValues)>0; 
		} catch (Exception e) {
		}finally {
			mDb.close();
		} 
		return resultado; 
	} 

	public Boolean update(Vendedor vendedor,String where) {
		Boolean resultado = false;
		SQLiteDatabase mDb  = SQLiteDatabase.openDatabase(DataBaseClass.PATH_DATABASE,null, SQLiteDatabase.NO_LOCALIZED_COLLATORS);
		try{
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			ContentValues initialValues = new ContentValues();
			initialValues.put("IDBASEDATOS",vendedor.getIdbasedatos()) ; 
			initialValues.put("IDEMPRESA",vendedor.getIdempresa()) ; 
			initialValues.put("IDVENDEDOR",vendedor.getIdvendedor()) ; 
			initialValues.put("DESCRIPCION",vendedor.getDescripcion()) ; 
			initialValues.put("NOMBRECORTO",vendedor.getNombrecorto()) ; 
			initialValues.put("IDUSUARIO",vendedor.getIdusuario()) ; 
			initialValues.put("ESTADO",vendedor.getEstado()) ; 
			resultado = mDb.update("VENDEDOR",initialValues,where,null)>0; 
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
			resultado = mDb.delete("VENDEDOR",where,null)>0; 
		} catch (Exception e) {
		}finally {
			mDb.close();
		} 
		return resultado; 
	} 

	public ArrayList<Vendedor> listar(String where,String order,String limit) {
		ArrayList<Vendedor> lista  = new ArrayList<Vendedor>();
		SQLiteDatabase mDb  = SQLiteDatabase.openDatabase(DataBaseClass.PATH_DATABASE,null, SQLiteDatabase.NO_LOCALIZED_COLLATORS);
		try{
			Cursor cur =  mDb.query("VENDEDOR",
					new String[] {
							 "IDBASEDATOS" ,
							 "IDEMPRESA" ,
							 "IDVENDEDOR" ,
							 "DESCRIPCION" ,
							 "NOMBRECORTO" ,
							 "IDUSUARIO" ,
							 "ESTADO" 
					},
			where, null, null, order, limit);
			if (cur!=null){
				cur.moveToFirst();
				int j=0;
				while (cur.isAfterLast() == false) {
					Vendedor vendedor = new Vendedor() ;
					vendedor.setIdbasedatos(cur.getString(j++));
					vendedor.setIdempresa(cur.getString(j++));
					vendedor.setIdvendedor(cur.getString(j++));
					vendedor.setDescripcion(cur.getString(j++));
					vendedor.setNombrecorto(cur.getString(j++));
					vendedor.setIdusuario(cur.getString(j++));
					vendedor.setEstado(cur.getDouble(j++));

					lista.add(vendedor); 
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