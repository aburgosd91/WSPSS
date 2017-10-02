import com.nisira.core.CoreUtil;
import com.nisira.core.EConexion;
import com.nisira.generator.ClaveForanea;
import com.nisira.generator.Columna;
import com.nisira.generator.ConexionGen;
import com.nisira.generator.Tabla;

import java.io.File;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;
import java.util.Scanner;


import java.io.BufferedReader;
import java.io.BufferedWriter;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import static com.nisira.generator.MainEje.TipoBD;


public class RunGenerador {


	public static String ANDROID = "ANDROID";
	public static String JAVA = "JAVA";

	public static String RAIZ_ANDROIDSTUDIO = "app/src/main/java/";
	public static String RAIZ_INTELLIJIDEA= "src/";
	public static String RAIZ_NETBEANS= "src/";

	String PAQUETEENTIDAD = "";
	String PAQUETEENTIDADSERVICES = "";
	String PAQUETEDAO = "";
        String PAQUETEDATABASE = "";
	String PAQUETEVISTA = "";
	String PAQUETEADAPTER =  "";
	String PAQUETEUTIL =  "";

	String RUTAENTIDAD = "";
	String RUTAENTIDADSERVICES = "";
	String RUTADAO = "";
        String RUTADATABASE = "";
	String RUTAVISTA = "";
	String RUTAADAPTER =  "";
	String RUTAUTIL =  "";
	
	String TIPOLENGUAJE = "ANDROID";
	
	public RunGenerador(String RAIZ,String PAQUETEBASE,String TIPOLENGUAJE){
		this.TIPOLENGUAJE = TIPOLENGUAJE;
		PAQUETEENTIDAD = PAQUETEBASE+"entity";
		PAQUETEDAO = PAQUETEBASE+"dao";
		PAQUETEDATABASE = PAQUETEBASE+"database";
		PAQUETEVISTA = PAQUETEBASE+"view";
		PAQUETEADAPTER = PAQUETEBASE+"adapter";
		PAQUETEUTIL = PAQUETEBASE+"util";
		PAQUETEENTIDADSERVICES = PAQUETEBASE+"entityservices";

		String RUTABASE = RAIZ+PAQUETEBASE.replace(".","/");        //"src/com/nisira/";

		RUTAENTIDAD = RUTABASE+"entity/";
		RUTADAO = RUTABASE+"dao/";
		RUTADATABASE = RUTABASE+"database/";
		RUTAVISTA = RUTABASE+"view/";
		RUTAADAPTER = RUTABASE+"adapter/";
		RUTAUTIL = RUTABASE+"util/";
		RUTAENTIDADSERVICES = RUTABASE+"entityservices/";

		File creardirectorio_entidad = new File(RUTAENTIDAD);
		File creardirectorio_dao = new File(RUTADAO);
		File creardirectorio_entidadservices = new File(RUTAENTIDADSERVICES);
		creardirectorio_entidad.mkdirs();
		creardirectorio_dao.mkdirs();
		creardirectorio_entidadservices.mkdirs();

		if(this.TIPOLENGUAJE.trim().equals("ANDROID")){
			File creardirectorio_database = new File(RUTADATABASE);
			File creardirectorio_view = new File(RUTAVISTA);
			File creardirectorio_adapter = new File(RUTAADAPTER);
			File creardirectorio_util= new File(RUTAUTIL);

			creardirectorio_database.mkdirs();
			creardirectorio_view.mkdirs();
			creardirectorio_adapter.mkdirs();
			creardirectorio_util.mkdirs();
		}
	}

	private void genEntidadServices(Integer cantidad) {
		String nombre = "ResponseWebService"+cantidad.toString();
		nombre = nombre.substring(0, 1).toUpperCase() + nombre.substring(1);

		File file = new File(RUTAENTIDADSERVICES + nombre + ".java");

		List<String> codigoPersiste = new ArrayList<String>();

		try {

			if (file.exists()) {
				// Buscar código persistente

				FileReader fr = new FileReader(file);
				BufferedReader br = null;
				br = new BufferedReader(fr);
				boolean inicio = false, fin = false;
				String linea;

				String codigo = "";
				while ((linea = br.readLine()) != null) {
					if (linea.trim().equalsIgnoreCase("/*-Inicio-*/")) {
						inicio = true;
						codigo = "";
					}

					if (linea.trim().equalsIgnoreCase("/*-Fin-*/")) {
						inicio = false;
						fin = true;
					}

					if (inicio) {
						codigo = codigo.concat(linea).concat("\n");
					}

					if (fin) {
						codigo = codigo.concat(linea).concat("\n");

						codigoPersiste.add(codigo);
						fin = false;
					}

				}
				br.close();

				file.delete();

			}

			FileWriter w = new FileWriter(file);

			BufferedWriter bw = new BufferedWriter(w);

			PrintWriter wr = new PrintWriter(bw);

			String paquete, imports, cabecera, campos = "", set = "\n\t/* Sets & Gets */\n";
			String camposRel = "", setRel = "\n\t/* Sets & Gets FK*/\n";

			boolean usaTimestamp = false, usaDate = false, usaReferencia = false;

			paquete = "package "+PAQUETEENTIDADSERVICES+";\n";
			imports = "import com.google.gson.annotations.SerializedName;\n" +
					"import java.util.ArrayList;\n"+
					"import com.thoughtworks.xstream.annotations.XStreamAlias;\n"+
					"import java.io.Serializable;\n\n";


			String generic = "";

			String constructor_cabecera = "";
			String constructor_detalle = "";
			for (Integer i= 0;i<cantidad;i++) {


				Integer indice = i+1;

				if(i==0){
					generic+="T"+indice.toString();
				}
				else{
					generic+=",T"+indice.toString();
				}


				String nombrecampo = "lista"+indice.toString();
				String tipo = "";
				String post = nombrecampo.toLowerCase();

				if (nombrecampo.length() > 1) {
					boolean m0, m1, may = true;
					m0 = Character.isUpperCase(post.charAt(0));
					m1 = Character.isUpperCase(post.charAt(1));

					if (!m0 && m1)
						may = false;

					post = ((!may) ? post.substring(0, 1).toLowerCase() : post.substring(0, 1).toUpperCase())
							.concat(post.substring(1));

				} else {
					post = nombrecampo.toUpperCase();
				}

				tipo = "ArrayList<T"+indice.toString()+">";

				if(i==0){
					constructor_cabecera +=""+tipo+" "+nombrecampo.toLowerCase();
				}
				else{
					constructor_cabecera +=" , "+tipo+" "+nombrecampo.toLowerCase();
				}
				constructor_detalle +="\t\tthis."+nombrecampo.toLowerCase()+" = "+nombrecampo.toLowerCase()+";\n";

				campos += "\t@SerializedName(\""+nombrecampo.toLowerCase()+"\") \n" +
						"\t@XStreamAlias(\"" +nombrecampo.toLowerCase()+"\") \n" +
						"\tprivate " + tipo + " " + nombrecampo.toLowerCase() +";\n";

				set += "\tpublic void set" + post + "(" + tipo + " " + nombrecampo.toLowerCase() + ") {\n";
				set += "\t\tthis." + nombrecampo.toLowerCase() + " = " + nombrecampo.toLowerCase() + ";\n";
				set += "\t}\n\n";

				set += "\tpublic " + tipo + " get" + post + "() {\n";
				set += "\t\treturn this." + nombrecampo.toLowerCase() + ";\n";
				set += "\t}\n\n";


			}

			cabecera = "@XStreamAlias(\""+ nombre + "\")\n" +
					"\n" +
					"public class " + nombre + "<"+generic+"> implements Serializable{\n";
			String constructor = "\tpublic "+nombre+"("+constructor_cabecera+") {\n" +
					constructor_detalle+"\n" +
					"\t}";



			wr.append(paquete);
			wr.append("\n");
			wr.append(imports);
			wr.append("\n");
			wr.append(cabecera);
			wr.append(campos);
			wr.append("\n");
			wr.append(constructor);
			wr.append("\n");
			wr.append(set);
			wr.append("\n");
			for (String cod : codigoPersiste) {
				wr.append(cod);
			}
			wr.append("}");

			wr.close();

			bw.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void genEntidad(Tabla tabla) {
		String nombre = tabla.getNombre().toLowerCase();
		nombre = nombre.substring(0, 1).toUpperCase() + nombre.substring(1);

		File file = new File(RUTAENTIDAD + nombre + ".java");

		List<String> codigoPersiste = new ArrayList<String>();

		try {

			if (file.exists()) {
				// Buscar código persistente

				FileReader fr = new FileReader(file);
				BufferedReader br = null;
				br = new BufferedReader(fr);
				boolean inicio = false, fin = false;
				String linea;

				String codigo = "";
				while ((linea = br.readLine()) != null) {
					if (linea.trim().equalsIgnoreCase("/*-Inicio-*/")) {
						inicio = true;
						codigo = "";
					}

					if (linea.trim().equalsIgnoreCase("/*-Fin-*/")) {
						inicio = false;
						fin = true;
					}

					if (inicio) {
						codigo = codigo.concat(linea).concat("\n");
					}

					if (fin) {
						codigo = codigo.concat(linea).concat("\n");

						codigoPersiste.add(codigo);
						fin = false;
					}

				}
				br.close();

				file.delete();

			}

			FileWriter w = new FileWriter(file);

			BufferedWriter bw = new BufferedWriter(w);

			PrintWriter wr = new PrintWriter(bw);

			String paquete, imports, cabecera, campos = "", set = "\n\t/* Sets & Gets */\n";
			String camposRel = "", setRel = "\n\t/* Sets & Gets FK*/\n";

			boolean usaTimestamp = false, usaDate = false, usaReferencia = false;

			paquete = "package "+PAQUETEENTIDAD+";\n";
			imports = "import com.nisira.annotation.ClavePrimaria;\n" +
					"import com.nisira.annotation.Columna;\n" +
					"import com.nisira.annotation.Tabla;\n" +
					"import com.google.gson.annotations.SerializedName;\n" +
					"import com.thoughtworks.xstream.annotations.XStreamAlias;\n"+
					"import java.io.Serializable;\n\n";

			cabecera = "@Tabla(nombre = \"" + tabla.getNombre() + "\")\n" +
					   "@XStreamAlias(\""+ tabla.getNombre() + "\")\n" +
					   "\n" +
					   "public class " + nombre + " implements Serializable {\n";

			for (Columna c : tabla.getColumnas()) {
				String tipo = "";
				String post = c.getNombre().toLowerCase();

				if (c.getNombre().length() > 1) {
					boolean m0, m1, may = true;
					m0 = Character.isUpperCase(post.charAt(0));
					m1 = Character.isUpperCase(post.charAt(1));

					if (!m0 && m1)
						may = false;

					post = ((!may) ? post.substring(0, 1).toLowerCase() : post.substring(0, 1).toUpperCase())
							.concat(post.substring(1));

				} else {
					post = c.getNombre().toUpperCase();
				}

				tipo = getJavaType(c.getTipo());

				if (tipo.equalsIgnoreCase("Date")) {
					usaDate = true;
				}

				String valordefecto = "";

				if(tipo.trim().equals("String")){
					valordefecto = " = \"\" ";
				}

				if(tipo.trim().equals("Double")){
					valordefecto = " = 0.00 ";
				}



				if (!c.getTipo().equalsIgnoreCase("time")) {
					// Buscar si es clave Primaria
					boolean esPK = false;
					if (tabla.getClavePrimaria() != null)
						for (String clave : tabla.getClavePrimaria().getCampos()) {
							if (clave.equalsIgnoreCase(c.getNombre())) {
								esPK = true;
								break;
							}
						}
					if (esPK) {
						campos += "\t@ClavePrimaria\n";
					}
					campos += "\t@Columna\n" +
							"\t@SerializedName(\""+c.getNombre().toLowerCase()+"\") \n" +
							"\t@XStreamAlias(\"" +c.getNombre().toLowerCase()+"\") \n" +
							"\tprivate " + tipo + " " + c.getNombre().toLowerCase() + valordefecto+";\n";

					set += "\tpublic void set" + post + "(" + tipo + " " + c.getNombre().toLowerCase() + ") {\n";
					set += "\t\tthis." + c.getNombre().toLowerCase() + " = " + c.getNombre().toLowerCase() + ";\n";
					set += "\t}\n\n";

					set += "\tpublic " + tipo + " get" + post + "() {\n";
					set += "\t\treturn this." + c.getNombre().toLowerCase() + ";\n";
					set += "\t}\n\n";

				}
			}

			// campos relacionados

			for (ClaveForanea fk : tabla.getClavesForaneas()) {
				usaReferencia = true;
				String clase = fk.getTablaForanea().toLowerCase(), instancia, relacion = "", nomCampo;

				clase = clase.substring(0, 1).toUpperCase().concat(clase.substring(1));

				instancia = fk.getTablaForanea().concat("_").concat(fk.getNombre()).toLowerCase();

				nomCampo = instancia.substring(0, 1).toUpperCase() + instancia.substring(1);

//				for (int i = 0 ; i < fk.getCampos().size(); i++) {
//					String[] r = fk.getCampos().get(i);
//					relacion += "{@RelacionTabla(campo=\"".concat(r[0]).concat("\"").concat(",")
//							.concat("campoRelacionado=\"").concat(r[1]).concat("\"").concat(")}");
//				}

				for (String[] r : fk.getCampos()) {
					relacion += (relacion.isEmpty()?"":", ") + "@RelacionTabla(campo=\"".concat(r[0]).concat("\"").concat(",")
							.concat("campoRelacionado=\"").concat(r[1]).concat("\"").concat(")");
				}

				camposRel += "\t@CampoRelacionado({" + relacion + "})\n";
				camposRel += "\tprivate ".concat(clase).concat(" ").concat(instancia.toLowerCase()).concat(";\n");

				setRel += "\tpublic void set".concat(nomCampo).concat("(").concat(clase).concat(" ").concat(instancia)
						.concat(") {\n");
				setRel += "\t\tthis.".concat(instancia).concat(" = ").concat(instancia).concat(";\n");
				setRel += "\t}\n\n";

				setRel += "\tpublic " + clase + " get".concat(nomCampo).concat("() {\n");
				setRel += "\t\treturn this.".concat(instancia).concat(";\n");
				setRel += "\t}\n\n";
			}

			if (usaTimestamp) {
				imports += "import java.sql.Timestamp;\n";
			}

			if (usaDate) {
				imports += "import java.util.Date;\n";
			}

			if (usaReferencia) {
				imports += "import com.nisira.annotation.RelacionTabla;\n";
				imports += "import com.nisira.annotation.CampoRelacionado;\n";
			}
			imports += "import java.util.ArrayList;\n";

			wr.append(paquete);
			wr.append("\n");
			wr.append(imports);
			wr.append("\n");
			wr.append(cabecera);
			wr.append(campos);
			wr.append("\n");
			wr.append(camposRel);
			wr.append("\n");
			wr.append(set);
			wr.append("\n");
			wr.append(setRel);
			wr.append("\n");
			for (String cod : codigoPersiste) {
				wr.append(cod);
			}
			wr.append("}");

			wr.close();

			bw.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void genDao(Tabla tabla) {


		String nombre = tabla.getNombre().toLowerCase();
		String nombreTabla = tabla.getNombre().toLowerCase();

		nombre = nombre.substring(0, 1).toUpperCase() + nombre.substring(1).concat("Dao");
		nombreTabla = nombreTabla.substring(0, 1).toUpperCase() + nombreTabla.substring(1);

		String subnombre = tabla.getNombre().toLowerCase().substring(0, 1).toUpperCase() + tabla.getNombre().toLowerCase().substring(1);

		File file = new File(RUTADAO + nombre + ".java");

		List<String> codigoPersiste = new ArrayList<String>();

		try {
			if (file.exists()) {
				// Buscar código persistente

				FileReader fr = new FileReader(file);
				BufferedReader br = null;
				br = new BufferedReader(fr);
				boolean inicio = false, fin = false;
				String linea;

				String codigo = "";
				while ((linea = br.readLine()) != null) {
					if (linea.trim().equalsIgnoreCase("/*-Inicio-*/")) {
						inicio = true;
						codigo = "";
					}

					if (linea.trim().equalsIgnoreCase("/*-Fin-*/")) {
						inicio = false;
						fin = true;
					}

					if (inicio) {
						codigo = codigo.concat(linea).concat("\n");
					}

					if (fin) {
						codigo = codigo.concat(linea).concat("\n");

						codigoPersiste.add(codigo);
						fin = false;
					}

				}
				br.close();

				file.delete();
			}

			FileWriter w;
			w = new FileWriter(file);

			BufferedWriter bw = new BufferedWriter(w);

			PrintWriter wr = new PrintWriter(bw);

			String paquete, imports, cabecera, buscarpor_pk,insert,update,delete,listar = "";

			paquete = "package ".concat(PAQUETEDAO).concat(";\n");
			imports = "import com.nisira.core.BaseDao;\nimport "+PAQUETEENTIDAD+".*;\n";
			boolean usaUtilList = false;
			//VAZLL


			if (TIPOLENGUAJE.trim().equals("ANDROID"))
			{
				cabecera = "public class " + nombre + "{\n";
			}
			else
			{
				cabecera = "public class " + nombre + " extends BaseDao<" + subnombre + "> {\n";

				cabecera += "\tpublic " + nombre + "() {\n";
				cabecera += "\t\tsuper(" + subnombre + ".class);\n";
				cabecera += "\t}\n";

				cabecera += "\tpublic " + nombre + "(boolean usaCnBase) throws NisiraORMException {\n";
				cabecera += "\t\tsuper(" + subnombre + ".class, usaCnBase);\n";
				cabecera += "\t}\n";
			}

			//METODO INSERT-----------------------------------------
			insert = "";
			insert += "\tpublic Boolean insert("+nombreTabla+" "+tabla.getNombre().toLowerCase()+") {\n";
			insert += "\t\tBoolean resultado = false;\n";
			insert += "\t\tSQLiteDatabase mDb  = SQLiteDatabase.openDatabase(DataBaseClass.PATH_DATABASE,null, SQLiteDatabase.NO_LOCALIZED_COLLATORS);\n";
			insert += "\t\ttry{\n";
			insert += "\t\t\tSimpleDateFormat dateFormat = new SimpleDateFormat(\"yyyy-MM-dd HH:mm:ss\");\n";
			insert += "\t\t\tContentValues initialValues = new ContentValues();\n";
			for (Columna c : tabla.getColumnas()) {
				String tipo = "";
				String post = c.getNombre().toLowerCase();

				if (c.getNombre().length() > 1) {
					boolean m0, m1, may = true;
					m0 = Character.isUpperCase(post.charAt(0));
					m1 = Character.isUpperCase(post.charAt(1));

					if (!m0 && m1)
						may = false;

					post = ((!may) ? post.substring(0, 1).toLowerCase() : post.substring(0, 1).toUpperCase())
							.concat(post.substring(1));

				} else {
					post = c.getNombre().toUpperCase();
				}
				if(c.getTipo().trim().toLowerCase().equals("date") || c.getTipo().trim().toLowerCase().equals("datetime") || c.getTipo().trim().toLowerCase().equals("timestamp")){
					insert += "\t\t\tinitialValues.put(\"" + c.getNombre().toUpperCase() + "\",dateFormat.format(" + tabla.getNombre().toLowerCase() + ".get" + post + "() ) ); \n";
				}
				else {
					insert += "\t\t\tinitialValues.put(\"" + c.getNombre().toUpperCase() + "\"," + tabla.getNombre().toLowerCase() + ".get" + post + "()); \n";
				}
			}
			insert += "\t\t\tresultado = mDb.insert(\""+tabla.getNombre().toUpperCase()+"\",null,initialValues)>0; \n";
			insert += "\t\t} catch (Exception e) {\n";
			insert += "\t\t}finally {\n";
			insert += "\t\t\tmDb.close();\n";
			insert += "\t\t} \n";
			insert += "\t\treturn resultado; \n";
			insert += "\t} \n";
			//------------------------------------------------------------



			//METODO UPDATE-----------------------------------------
			update = "";
			update += "\tpublic Boolean update("+nombreTabla+" "+tabla.getNombre().toLowerCase()+",String where) {\n";
			update += "\t\tBoolean resultado = false;\n";
			update += "\t\tSQLiteDatabase mDb  = SQLiteDatabase.openDatabase(DataBaseClass.PATH_DATABASE,null, SQLiteDatabase.NO_LOCALIZED_COLLATORS);\n";
			update += "\t\ttry{\n";
			update += "\t\t\tSimpleDateFormat dateFormat = new SimpleDateFormat(\"yyyy-MM-dd HH:mm:ss\");\n";
			update += "\t\t\tContentValues initialValues = new ContentValues();\n";
			for (Columna c : tabla.getColumnas()) {
				String tipo = "";
				String post = c.getNombre().toLowerCase();

				if (c.getNombre().length() > 1) {
					boolean m0, m1, may = true;
					m0 = Character.isUpperCase(post.charAt(0));
					m1 = Character.isUpperCase(post.charAt(1));

					if (!m0 && m1)
						may = false;

					post = ((!may) ? post.substring(0, 1).toLowerCase() : post.substring(0, 1).toUpperCase())
							.concat(post.substring(1));

				} else {
					post = c.getNombre().toUpperCase();
				}
				if(c.getTipo().trim().toLowerCase().equals("date") || c.getTipo().trim().toLowerCase().equals("datetime") || c.getTipo().trim().toLowerCase().equals("timestamp")){
					update += "\t\t\tinitialValues.put(\"" + c.getNombre().toUpperCase() + "\",dateFormat.format(" + tabla.getNombre().toLowerCase() + ".get" + post + "() ) ) ; \n";
				}
				else {
					update += "\t\t\tinitialValues.put(\"" + c.getNombre().toUpperCase() + "\"," + tabla.getNombre().toLowerCase() + ".get" + post + "()) ; \n";
				}
			}
			update += "\t\t\tresultado = mDb.update(\""+tabla.getNombre().toUpperCase()+"\",initialValues,where,null)>0; \n";
			update += "\t\t} catch (Exception e) {\n";
			update += "\t\t}finally {\n";
			update += "\t\t\tmDb.close();\n";
			update += "\t\t} \n";
			update += "\t\treturn resultado; \n";
			update += "\t} \n";
			//------------------------------------------------------------

			//METODO DELETE-----------------------------------------
			delete = "";
			delete += "\tpublic Boolean delete(String where) {\n";
			delete += "\t\tBoolean resultado = false;\n";
			delete += "\t\tSQLiteDatabase mDb  = SQLiteDatabase.openDatabase(DataBaseClass.PATH_DATABASE,null, SQLiteDatabase.NO_LOCALIZED_COLLATORS);\n";
			delete += "\t\ttry{\n";
			delete += "\t\t\tresultado = mDb.delete(\""+tabla.getNombre().toUpperCase()+"\",where,null)>0; \n";
			delete += "\t\t} catch (Exception e) {\n";
			delete += "\t\t}finally {\n";
			delete += "\t\t\tmDb.close();\n";
			delete += "\t\t} \n";
			delete += "\t\treturn resultado; \n";
			delete += "\t} \n";
			//------------------------------------------------------------

			//METODO LISTAR-----------------------------------------
			listar = "";
			String listar_select = "";
			String listar_setselect = "";
			listar += "\tpublic ArrayList<"+nombreTabla+"> listar(String where,String order,Integer limit) {\n";
			listar += "\t\tif(limit == null){\n";
			listar += "\t\t\tlimit =0;\n";
			listar += "\t\t}\n";
			listar += "\t\tArrayList<"+nombreTabla+"> lista  = new ArrayList<"+nombreTabla+">();\n";
			listar += "\t\tSQLiteDatabase mDb  = SQLiteDatabase.openDatabase(DataBaseClass.PATH_DATABASE,null, SQLiteDatabase.NO_LOCALIZED_COLLATORS);\n";
			listar += "\t\ttry{\n";
			update += "\t\t\tSimpleDateFormat dateFormat = new SimpleDateFormat(\"yyyy-MM-dd HH:mm:ss\");\n";
			listar += "\t\t\tCursor cur =  mDb.query(\""+tabla.getNombre().toUpperCase()+"\",\n";
			listar += "\t\t\t\t\tnew String[] {\n";
			int i= 0;
			for (Columna c : tabla.getColumnas()) {
				String tipo = "";
				String post = c.getNombre().toLowerCase();

				if (c.getNombre().length() > 1) {
					boolean m0, m1, may = true;
					m0 = Character.isUpperCase(post.charAt(0));
					m1 = Character.isUpperCase(post.charAt(1));

					if (!m0 && m1)
						may = false;

					post = ((!may) ? post.substring(0, 1).toLowerCase() : post.substring(0, 1).toUpperCase())
							.concat(post.substring(1));

				} else {
					post = c.getNombre().toUpperCase();
				}
				listar_select += (i==0?"":",\n")+"\t\t\t\t\t\t\t"+" \""+c.getNombre().toUpperCase()+"\" ";

				String tipometodo = getJavaType(c.getTipo());
				if(tipometodo.trim().equals("Integer")){
					tipometodo = "Int";
				}
				tipometodo = tipometodo.substring(0,1).toUpperCase()+tipometodo.substring(1);
				if(c.getTipo().trim().toLowerCase().equals("date") || c.getTipo().trim().toLowerCase().equals("datetime") || c.getTipo().trim().toLowerCase().equals("timestamp")){
					listar_setselect += "\t\t\t\t\t" + tabla.getNombre().toLowerCase() + ".set" + post + "(dateFormat.parse(cur.getString(j++)) );\n";
				}else {
					listar_setselect += "\t\t\t\t\t" + tabla.getNombre().toLowerCase() + ".set" + post + "(cur.get" + tipometodo + "(j++));\n";
				}
				i++;
			}
			listar += listar_select+"\n";
			listar += "\t\t\t\t\t},\n";
			listar += "\t\t\twhere, null, null, null, order);\n";
			listar += "\t\t\tif (cur!=null){\n";
			listar += "\t\t\t\tcur.moveToFirst();\n";
			listar += "\t\t\t\tint i=0;\n";
			listar += "\t\t\t\twhile (cur.isAfterLast() == false) {\n";
			listar += "\t\t\t\t\tint j=0;\n";

			listar += "\t\t\t\t\t"+nombreTabla+" "+tabla.getNombre().toLowerCase()+" = new "+nombreTabla+"() ;\n";
			listar += listar_setselect+"\n";
			listar += "\t\t\t\t\tlista.add("+tabla.getNombre().toLowerCase()+"); \n";
			listar += "\t\t\t\t\ti++; \n";
			listar += "\t\t\t\t\tif(i == limit){ \n";
			listar += "\t\t\t\t\t\tbreak; \n";
			listar += "\t\t\t\t\t} \n";
			listar += "\t\t\t\t\tcur.moveToNext(); \n";
			listar += "\t\t\t\t} \n";
			listar += "\t\t\t\tcur.close(); \n";
			listar += "\t\t\t} \n";

			listar += "\t\t} catch (Exception e) {\n";
			listar += "\t\t}finally {\n";
			listar += "\t\t\tmDb.close();\n";
			listar += "\t\t} \n";
			listar += "\t\treturn lista; \n";
			listar += "\t} \n";

			imports += "import java.util.List;\n";
			if(TIPOLENGUAJE.trim().equals("ANDROID"))
			{
				imports += "import android.database.sqlite.SQLiteDatabase;\n";
				imports += "import nisira.com.pe.tomapedido.database.DataBaseClass;\n";
				imports += "import android.content.ContentValues;\n";
				imports += "import android.database.Cursor;\n";
				imports += "import nisira.com.pe.tomapedido.util.Clave;\n";
			}
			imports += "import java.util.ArrayList;\n";
			imports += "import java.util.LinkedList;\n";
			imports += "import java.text.SimpleDateFormat;\n";
			imports += "import java.util.Date;\n";
			imports += "import com.nisira.core.NisiraORMException;\n";
			imports += "import "+PAQUETEENTIDADSERVICES.trim()+".*;";

			if(TIPOLENGUAJE.trim().equals("JAVA"))
			{
				imports += "import java.sql.ResultSet;";
			}


			wr.append(paquete);
			wr.append("\n");
			wr.append(imports);
			wr.append("\n");
			wr.append(cabecera);
			wr.append("\n");
			if(TIPOLENGUAJE.trim().equals("ANDROID")) {
				wr.append(insert);
				wr.append("\n");
				wr.append(update);
				wr.append("\n");
				wr.append(delete);
				wr.append("\n");
				wr.append(listar);
			}
			for (String cod : codigoPersiste) {
				wr.append(cod);
			}
			wr.append("}");

			wr.close();

			bw.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private String getJavaType(String sqlType) {
		String tipo = null;

		if(
				sqlType.trim().equals("date") || sqlType.trim().equals("datetime")
				)
		{
			tipo = "Date";
		}
		if(
				sqlType.trim().equals("varchar") || sqlType.trim().equals("char")||
						sqlType.trim().equals("text")|| sqlType.trim().equals("nvarchar")||
						sqlType.trim().equals("nchar")|| sqlType.trim().equals("ntext")||
						sqlType.trim().equals("xml")
				)
		{
			tipo = "String";
		}

		if(
				sqlType.trim().equals("int") || sqlType.trim().equals("bigint")||
						sqlType.trim().equals("smallint")
				)
		{
			tipo = "Integer";
		}

		if(
				sqlType.trim().equals("float")
				)
		{
			tipo = "Float";
		}
		if(
				sqlType.trim().equals("double") || sqlType.trim().equals("numeric")||
						sqlType.trim().equals("decimal")
				)
		{
			tipo = "Double";
		}
		if(
				sqlType.trim().equals("bit")
				)
		{
			tipo = "Short";
		}

		return tipo;
	}


	private void crearArchivoconEstructuraBD(String TipoDB,String basedatos,String ruta_archivo_sync) {

		ConexionGen cGen = new ConexionGen(TipoBD, basedatos);
		try {
                    System.out.println("\n" +"Cargando Estructura de Base de Datos");

                    List<Tabla> lista = cGen.retornaEstructura();
                    ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream(ruta_archivo_sync));

                    salida.writeObject(lista);
                    salida.close();
                    System.out.println("\n" +"Se creó el archivo file.nsrsync con la configuración de la base de datos");


		} catch (SQLException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	public static void main(String[] args) {
            String PAQUETEBASE = "com.nisira.sqlite."; //e1.printStackTrace();
            RunGenerador rgen = new RunGenerador(RunGenerador.RAIZ_NETBEANS,PAQUETEBASE,RunGenerador.JAVA);
            // ********************************************INICIO CONEXION*******************************************************
            EConexion e = new EConexion();
            e.BASEDATOS = "PSSTEST";
            e.CLAVE = "amadeus2010";
            e.INSTANCIA = "";
            e.USUARIO = "sa";
            e.SERVIDOR = "EQUIPONISIRA";
            e.TIPO = "MSSQL";
            CoreUtil.conexiones.put("default", e);
            // ********************************************FIN CONEXION*******************************************************
            
            Scanner scanner = new Scanner(System.in);
            System.out.println("Generar entidades y Dao desde base de datos (Y-N)");
            String entrada = scanner.next();
            if  (entrada.trim().equals("Y") ){
                
//                if( rgen.TIPOLENGUAJE.trim().equals(RunGenerador.ANDROID.trim()) ) {
                    String ruta_archivo_sync = "src/com/nisira/sqlite/file.nsrsync";
                    rgen.crearArchivoconEstructuraBD(e.TIPO, e.BASEDATOS, ruta_archivo_sync);
//                }
                
//				ConexionGen c = new ConexionGen(e.TIPO, e.BASEDATOS);
//				List<Tabla> lista = null;
//
//                                lista = c.retornaEstructura();
//
//				for (Tabla t : lista) {
//					if (t != null) {
//						rgen.genEntidad(t);
//						rgen.genDao(t);
//					}
//				}
//				Integer cantidad_entidades_services = 6;
//				for(Integer i=1;i<(cantidad_entidades_services+1);i++){
//					rgen.genEntidadServices(i);
//				}

                System.out.println("Termino el proceso y se generaron correctamente las clases entidades y Dao");
            }
            else{
                System.out.println("Termino el proceso sin generación de codigo");
            }

        }

}
