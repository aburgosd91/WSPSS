
import com.nisira.core.CoreUtil;
import com.nisira.core.EConexion;
import com.nisira.generator.FrmGeneraEntidades;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Alex Burgos <aburgosd91@gmail.com>
 */
public class RunGeneradorWeb {
    public static void main(String[] args) {
		EConexion e = new EConexion();
		e.BASEDATOS = "PSS_SQLITE";
		e.CLAVE = "amadeus2010";
		e.INSTANCIA = "";
		e.USUARIO = "sa";
		e.SERVIDOR = "ABURGOS";
		e.TIPO = "MSSQL";
                CoreUtil.conexiones.put("default", e);
		new com.nisira.generator.FrmGeneraEntidades(e.TIPO, e.BASEDATOS).setVisible(true);
	}
}
