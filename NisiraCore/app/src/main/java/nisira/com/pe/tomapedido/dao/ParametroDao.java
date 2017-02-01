package nisira.com.pe.tomapedido.dao;

import com.nisira.core.BaseDao;
import nisira.com.pe.tomapedido.entity.Parametro;
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
public class ParametroDao{

	public Boolean insert(Parametro parametro) {
		Boolean resultado = false;
		SQLiteDatabase mDb  = SQLiteDatabase.openDatabase(DataBaseClass.PATH_DATABASE,null, SQLiteDatabase.NO_LOCALIZED_COLLATORS);
		try{
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			ContentValues initialValues = new ContentValues();
			initialValues.put("IDBASEDATOS",parametro.getIdbasedatos()); 
			initialValues.put("IDEMPRESA",parametro.getIdempresa()); 
			initialValues.put("IDPARAMETRO",parametro.getIdparametro()); 
			initialValues.put("DESCRIPCION",parametro.getDescripcion()); 
			initialValues.put("TIPOPARAMETRO",parametro.getTipoparametro()); 
			initialValues.put("VALOR",parametro.getValor()); 
			initialValues.put("VALORXDEFECTO",parametro.getValorxdefecto()); 
			initialValues.put("ESTADO",parametro.getEstado()); 
			resultado = mDb.insert("PARAMETRO",null,initialValues)>0; 
		} catch (Exception e) {
		}finally {
			mDb.close();
		} 
		return resultado; 
	} 

	public Boolean update(Parametro parametro,String where) {
		Boolean resultado = false;
		SQLiteDatabase mDb  = SQLiteDatabase.openDatabase(DataBaseClass.PATH_DATABASE,null, SQLiteDatabase.NO_LOCALIZED_COLLATORS);
		try{
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			ContentValues initialValues = new ContentValues();
			initialValues.put("IDBASEDATOS",parametro.getIdbasedatos()) ; 
			initialValues.put("IDEMPRESA",parametro.getIdempresa()) ; 
			initialValues.put("IDPARAMETRO",parametro.getIdparametro()) ; 
			initialValues.put("DESCRIPCION",parametro.getDescripcion()) ; 
			initialValues.put("TIPOPARAMETRO",parametro.getTipoparametro()) ; 
			initialValues.put("VALOR",parametro.getValor()) ; 
			initialValues.put("VALORXDEFECTO",parametro.getValorxdefecto()) ; 
			initialValues.put("ESTADO",parametro.getEstado()) ; 
			resultado = mDb.update("PARAMETRO",initialValues,where,null)>0; 
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
			resultado = mDb.delete("PARAMETRO",where,null)>0; 
		} catch (Exception e) {
		}finally {
			mDb.close();
		} 
		return resultado; 
	} 

	public ArrayList<Parametro> listar(String where,String order,String limit) {
		ArrayList<Parametro> lista  = new ArrayList<Parametro>();
		SQLiteDatabase mDb  = SQLiteDatabase.openDatabase(DataBaseClass.PATH_DATABASE,null, SQLiteDatabase.NO_LOCALIZED_COLLATORS);
		try{
			Cursor cur =  mDb.query("PARAMETRO",
					new String[] {
							 "IDBASEDATOS" ,
							 "IDEMPRESA" ,
							 "IDPARAMETRO" ,
							 "DESCRIPCION" ,
							 "TIPOPARAMETRO" ,
							 "VALOR" ,
							 "VALORXDEFECTO" ,
							 "ESTADO" 
					},
			where, null, null, order, limit);
			if (cur!=null){
				cur.moveToFirst();
				int j=0;
				while (cur.isAfterLast() == false) {
					Parametro parametro = new Parametro() ;
					parametro.setIdbasedatos(cur.getString(j++));
					parametro.setIdempresa(cur.getString(j++));
					parametro.setIdparametro(cur.getString(j++));
					parametro.setDescripcion(cur.getString(j++));
					parametro.setTipoparametro(cur.getString(j++));
					parametro.setValor(cur.getString(j++));
					parametro.setValorxdefecto(cur.getString(j++));
					parametro.setEstado(cur.getDouble(j++));

					lista.add(parametro); 
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