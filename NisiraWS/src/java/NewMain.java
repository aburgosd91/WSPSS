
import com.pe.nisira.movil.view.util.Encryption;
import com.pe.nisira.movil.view.util.EncryptionAnt;
import webservice.WebServiceNisira;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author vzavala
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
//        webservice.WebServiceNisira a = new WebServiceNisira();
//        String xmlbasedatos = "<?xml version=''1.0'' encoding=''ISO-8859-1'' ?><list><BASEDATOS><idbasedatos>PSS</idbasedatos></BASEDATOS></list>";
//        String resp = a.getEmpresasUsuariosVendedores("PSS",xmlbasedatos,"XML");
//        System.out.println(resp);
        System.out.println("Encryption: "+EncryptionAnt.encrypt("administrador"));
        System.out.println("Encryption: "+EncryptionAnt.decrypt("èìÿÆÖ"));
    }
    
}
