package nisira.com.pe.tomapedido.dao;

import com.nisira.core.BaseDao;
import nisira.com.pe.tomapedido.entity.Empresa;
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
public class EmpresaDao{

	public Boolean insert(Empresa empresa) {
		Boolean resultado = false;
		SQLiteDatabase mDb  = SQLiteDatabase.openDatabase(DataBaseClass.PATH_DATABASE,null, SQLiteDatabase.NO_LOCALIZED_COLLATORS);
		try{
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			ContentValues initialValues = new ContentValues();
			initialValues.put("IDBASEDATOS",empresa.getIdbasedatos()); 
			initialValues.put("IDEMPRESA",empresa.getIdempresa()); 
			initialValues.put("RAZONSOCIAL",empresa.getRazonsocial()); 
			initialValues.put("RUC",empresa.getRuc()); 
			initialValues.put("ESTADO",empresa.getEstado()); 
			resultado = mDb.insert("EMPRESA",null,initialValues)>0; 
		} catch (Exception e) {
		}finally {
			mDb.close();
		} 
		return resultado; 
	} 

	public Boolean update(Empresa empresa,String where) {
		Boolean resultado = false;
		SQLiteDatabase mDb  = SQLiteDatabase.openDatabase(DataBaseClass.PATH_DATABASE,null, SQLiteDatabase.NO_LOCALIZED_COLLATORS);
		try{
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			ContentValues initialValues = new ContentValues();
			initialValues.put("IDBASEDATOS",empresa.getIdbasedatos()) ; 
			initialValues.put("IDEMPRESA",empresa.getIdempresa()) ; 
			initialValues.put("RAZONSOCIAL",empresa.getRazonsocial()) ; 
			initialValues.put("RUC",empresa.getRuc()) ; 
			initialValues.put("ESTADO",empresa.getEstado()) ; 
			resultado = mDb.update("EMPRESA",initialValues,where,null)>0; 
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
			resultado = mDb.delete("EMPRESA",where,null)>0; 
		} catch (Exception e) {
		}finally {
			mDb.close();
		} 
		return resultado; 
	} 

	public ArrayList<Empresa> listar(String where,String order,String limit) {
		ArrayList<Empresa> lista  = new ArrayList<Empresa>();
		SQLiteDatabase mDb  = SQLiteDatabase.openDatabase(DataBaseClass.PATH_DATABASE,null, SQLiteDatabase.NO_LOCALIZED_COLLATORS);
		try{
			Cursor cur =  mDb.query("EMPRESA",
					new String[] {
							 "IDBASEDATOS" ,
							 "IDEMPRESA" ,
							 "RAZONSOCIAL" ,
							 "RUC" ,
							 "ESTADO" 
					},
			where, null, null, order, limit);
			if (cur!=null){
				cur.moveToFirst();
				int j=0;
				while (cur.isAfterLast() == false) {
					Empresa empresa = new Empresa() ;
					empresa.setIdbasedatos(cur.getString(j++));
					empresa.setIdempresa(cur.getString(j++));
					empresa.setRazonsocial(cur.getString(j++));
					empresa.setRuc(cur.getString(j++));
					empresa.setEstado(cur.getDouble(j++));

					lista.add(empresa); 
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