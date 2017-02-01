package nisira.com.pe.tomapedido.dao;

import com.nisira.core.BaseDao;
import nisira.com.pe.tomapedido.entity.Stock;
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
public class StockDao{

	public Boolean insert(Stock stock) {
		Boolean resultado = false;
		SQLiteDatabase mDb  = SQLiteDatabase.openDatabase(DataBaseClass.PATH_DATABASE,null, SQLiteDatabase.NO_LOCALIZED_COLLATORS);
		try{
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			ContentValues initialValues = new ContentValues();
			initialValues.put("IDBASEDATOS",stock.getIdbasedatos()); 
			initialValues.put("IDEMPRESA",stock.getIdempresa()); 
			initialValues.put("IDALMACEN",stock.getIdalmacen()); 
			initialValues.put("DESCALMACEN",stock.getDescalmacen()); 
			initialValues.put("IDSUCURSAL",stock.getIdsucursal()); 
			initialValues.put("DESCSUCURSAL",stock.getDescsucursal()); 
			initialValues.put("IDPRODUCTO",stock.getIdproducto()); 
			initialValues.put("DESCPRODUCTO",stock.getDescproducto()); 
			initialValues.put("IDMEDIDA",stock.getIdmedida()); 
			initialValues.put("FECHA",dateFormat.format(stock.getFecha() ) ); 
			initialValues.put("STOCK",stock.getStock()); 
			resultado = mDb.insert("STOCK",null,initialValues)>0; 
		} catch (Exception e) {
		}finally {
			mDb.close();
		} 
		return resultado; 
	} 

	public Boolean update(Stock stock,String where) {
		Boolean resultado = false;
		SQLiteDatabase mDb  = SQLiteDatabase.openDatabase(DataBaseClass.PATH_DATABASE,null, SQLiteDatabase.NO_LOCALIZED_COLLATORS);
		try{
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			ContentValues initialValues = new ContentValues();
			initialValues.put("IDBASEDATOS",stock.getIdbasedatos()) ; 
			initialValues.put("IDEMPRESA",stock.getIdempresa()) ; 
			initialValues.put("IDALMACEN",stock.getIdalmacen()) ; 
			initialValues.put("DESCALMACEN",stock.getDescalmacen()) ; 
			initialValues.put("IDSUCURSAL",stock.getIdsucursal()) ; 
			initialValues.put("DESCSUCURSAL",stock.getDescsucursal()) ; 
			initialValues.put("IDPRODUCTO",stock.getIdproducto()) ; 
			initialValues.put("DESCPRODUCTO",stock.getDescproducto()) ; 
			initialValues.put("IDMEDIDA",stock.getIdmedida()) ; 
			initialValues.put("FECHA",dateFormat.format(stock.getFecha() ) ) ; 
			initialValues.put("STOCK",stock.getStock()) ; 
			resultado = mDb.update("STOCK",initialValues,where,null)>0; 
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
			resultado = mDb.delete("STOCK",where,null)>0; 
		} catch (Exception e) {
		}finally {
			mDb.close();
		} 
		return resultado; 
	} 

	public ArrayList<Stock> listar(String where,String order,String limit) {
		ArrayList<Stock> lista  = new ArrayList<Stock>();
		SQLiteDatabase mDb  = SQLiteDatabase.openDatabase(DataBaseClass.PATH_DATABASE,null, SQLiteDatabase.NO_LOCALIZED_COLLATORS);
		try{
			Cursor cur =  mDb.query("STOCK",
					new String[] {
							 "IDBASEDATOS" ,
							 "IDEMPRESA" ,
							 "IDALMACEN" ,
							 "DESCALMACEN" ,
							 "IDSUCURSAL" ,
							 "DESCSUCURSAL" ,
							 "IDPRODUCTO" ,
							 "DESCPRODUCTO" ,
							 "IDMEDIDA" ,
							 "FECHA" ,
							 "STOCK" 
					},
			where, null, null, order, limit);
			if (cur!=null){
				cur.moveToFirst();
				int j=0;
				while (cur.isAfterLast() == false) {
					Stock stock = new Stock() ;
					stock.setIdbasedatos(cur.getString(j++));
					stock.setIdempresa(cur.getString(j++));
					stock.setIdalmacen(cur.getString(j++));
					stock.setDescalmacen(cur.getString(j++));
					stock.setIdsucursal(cur.getString(j++));
					stock.setDescsucursal(cur.getString(j++));
					stock.setIdproducto(cur.getString(j++));
					stock.setDescproducto(cur.getString(j++));
					stock.setIdmedida(cur.getString(j++));
					stock.setFecha(dateFormat.parse(cur.getString(j++)) );
					stock.setStock(cur.getDouble(j++));

					lista.add(stock); 
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