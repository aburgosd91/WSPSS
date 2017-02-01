package nisira.com.pe.tomapedido.dao;

import com.nisira.core.BaseDao;
import nisira.com.pe.tomapedido.entity.Usuario;
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
public class UsuarioDao{

	public Boolean insert(Usuario usuario) {
		Boolean resultado = false;
		SQLiteDatabase mDb  = SQLiteDatabase.openDatabase(DataBaseClass.PATH_DATABASE,null, SQLiteDatabase.NO_LOCALIZED_COLLATORS);
		try{
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			ContentValues initialValues = new ContentValues();
			initialValues.put("IDBASEDATOS",usuario.getIdbasedatos()); 
			initialValues.put("IDEMPRESA",usuario.getIdempresa()); 
			initialValues.put("IDUSUARIO",usuario.getIdusuario()); 
			initialValues.put("IDVENDEDOR",usuario.getIdvendedor()); 
			initialValues.put("PASSWORD",usuario.getPassword()); 
			initialValues.put("ESTADO",usuario.getEstado()); 
			resultado = mDb.insert("USUARIO",null,initialValues)>0; 
		} catch (Exception e) {
		}finally {
			mDb.close();
		} 
		return resultado; 
	} 

	public Boolean update(Usuario usuario,String where) {
		Boolean resultado = false;
		SQLiteDatabase mDb  = SQLiteDatabase.openDatabase(DataBaseClass.PATH_DATABASE,null, SQLiteDatabase.NO_LOCALIZED_COLLATORS);
		try{
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			ContentValues initialValues = new ContentValues();
			initialValues.put("IDBASEDATOS",usuario.getIdbasedatos()) ; 
			initialValues.put("IDEMPRESA",usuario.getIdempresa()) ; 
			initialValues.put("IDUSUARIO",usuario.getIdusuario()) ; 
			initialValues.put("IDVENDEDOR",usuario.getIdvendedor()) ; 
			initialValues.put("PASSWORD",usuario.getPassword()) ; 
			initialValues.put("ESTADO",usuario.getEstado()) ; 
			resultado = mDb.update("USUARIO",initialValues,where,null)>0; 
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
			resultado = mDb.delete("USUARIO",where,null)>0; 
		} catch (Exception e) {
		}finally {
			mDb.close();
		} 
		return resultado; 
	} 

	public ArrayList<Usuario> listar(String where,String order,String limit) {
		ArrayList<Usuario> lista  = new ArrayList<Usuario>();
		SQLiteDatabase mDb  = SQLiteDatabase.openDatabase(DataBaseClass.PATH_DATABASE,null, SQLiteDatabase.NO_LOCALIZED_COLLATORS);
		try{
			Cursor cur =  mDb.query("USUARIO",
					new String[] {
							 "IDBASEDATOS" ,
							 "IDEMPRESA" ,
							 "IDUSUARIO" ,
							 "IDVENDEDOR" ,
							 "PASSWORD" ,
							 "ESTADO" 
					},
			where, null, null, order, limit);
			if (cur!=null){
				cur.moveToFirst();
				int j=0;
				while (cur.isAfterLast() == false) {
					Usuario usuario = new Usuario() ;
					usuario.setIdbasedatos(cur.getString(j++));
					usuario.setIdempresa(cur.getString(j++));
					usuario.setIdusuario(cur.getString(j++));
					usuario.setIdvendedor(cur.getString(j++));
					usuario.setPassword(cur.getString(j++));
					usuario.setEstado(cur.getDouble(j++));

					lista.add(usuario); 
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