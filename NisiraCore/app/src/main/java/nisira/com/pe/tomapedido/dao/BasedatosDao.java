package nisira.com.pe.tomapedido.dao;

import com.nisira.core.BaseDao;
import nisira.com.pe.tomapedido.entity.Basedatos;
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
public class BasedatosDao{

	public Boolean insert(Basedatos basedatos) {
		Boolean resultado = false;
		SQLiteDatabase mDb  = SQLiteDatabase.openDatabase(DataBaseClass.PATH_DATABASE,null, SQLiteDatabase.NO_LOCALIZED_COLLATORS);
		try{
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			ContentValues initialValues = new ContentValues();
			initialValues.put("IDBASEDATOS",basedatos.getIdbasedatos()); 
			initialValues.put("IDBASEDATOSCONEXION",basedatos.getIdbasedatosconexion()); 
			initialValues.put("WSURL",basedatos.getWsurl()); 
			initialValues.put("ES_WSNISIRA",basedatos.getEs_wsnisira()); 
			initialValues.put("HABILITADO",basedatos.getHabilitado()); 
			resultado = mDb.insert("BASEDATOS",null,initialValues)>0; 
		} catch (Exception e) {
		}finally {
			mDb.close();
		} 
		return resultado; 
	} 

	public Boolean update(Basedatos basedatos,String where) {
		Boolean resultado = false;
		SQLiteDatabase mDb  = SQLiteDatabase.openDatabase(DataBaseClass.PATH_DATABASE,null, SQLiteDatabase.NO_LOCALIZED_COLLATORS);
		try{
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			ContentValues initialValues = new ContentValues();
			initialValues.put("IDBASEDATOS",basedatos.getIdbasedatos()) ; 
			initialValues.put("IDBASEDATOSCONEXION",basedatos.getIdbasedatosconexion()) ; 
			initialValues.put("WSURL",basedatos.getWsurl()) ; 
			initialValues.put("ES_WSNISIRA",basedatos.getEs_wsnisira()) ; 
			initialValues.put("HABILITADO",basedatos.getHabilitado()) ; 
			resultado = mDb.update("BASEDATOS",initialValues,where,null)>0; 
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
			resultado = mDb.delete("BASEDATOS",where,null)>0; 
		} catch (Exception e) {
		}finally {
			mDb.close();
		} 
		return resultado; 
	} 

	public ArrayList<Basedatos> listar(String where,String order,String limit) {
		ArrayList<Basedatos> lista  = new ArrayList<Basedatos>();
		SQLiteDatabase mDb  = SQLiteDatabase.openDatabase(DataBaseClass.PATH_DATABASE,null, SQLiteDatabase.NO_LOCALIZED_COLLATORS);
		try{
			Cursor cur =  mDb.query("BASEDATOS",
					new String[] {
							 "IDBASEDATOS" ,
							 "IDBASEDATOSCONEXION" ,
							 "WSURL" ,
							 "ES_WSNISIRA" ,
							 "HABILITADO" 
					},
			where, null, null, order, limit);
			if (cur!=null){
				cur.moveToFirst();
				int j=0;
				while (cur.isAfterLast() == false) {
					Basedatos basedatos = new Basedatos() ;
					basedatos.setIdbasedatos(cur.getString(j++));
					basedatos.setIdbasedatosconexion(cur.getString(j++));
					basedatos.setWsurl(cur.getString(j++));
					basedatos.setEs_wsnisira(cur.getDouble(j++));
					basedatos.setHabilitado(cur.getDouble(j++));

					lista.add(basedatos); 
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