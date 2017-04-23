package com.pe.nisira.movil.view.util;

import com.auxClass.auxPrivilegioMenu;
import com.auxClass.auxPrivilegioModulo;
import com.auxClass.auxPrivilegioSucursal;
import com.nisira.core.dao.Conexion;
import com.pe.nisira.movil.view.bean.UsuarioBean;
import com.pe.nisira.movil.view.util.UtilitariosLocal;
import com.pe.nisira.movil.view.util.Constantes;
import com.pe.nisira.movil.view.util.ManejadorFechas;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class menuDao extends Conexion {

    private static menuDao u;

    public static menuDao getInstance() {
        if (u == null) {
            u = new menuDao();
        }
        return u;
    }

    public String[] buscar_contenido_pagina(Object pagina, Object tipo) throws Exception { //no funciona,no se usa
        String[] array = null;
        boolean datos = false;
        try {
            String sql = "web_buscar_contenido_pagina";
            //  cn = obtenerConexionJTDS();
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + " (?,?)}");
            cl.setObject(1, pagina);
            cl.setObject(2, tipo);

            rs = cl.executeQuery();
            ResultSetMetaData rm = rs.getMetaData();
            int numCols = rm.getColumnCount();

            String[] titCols = new String[numCols];
            for (int i = 0; i < numCols; ++i) {
                titCols[i] = rm.getColumnName(i + 1);
            }

            //   lista.add(titCols);
            while (rs.next()) {
                datos = true;
                array = new String[numCols];

                for (int i = 0; i < numCols; i++) {
                    array[i] = rs.getString(i + 1);
                }

            }
            if (!datos) {
                array = new String[numCols];
                for (int i = 0; i < numCols; i++) {
                    array[i] = " ";
                }
            }

        } finally {
            cerrar(cn, cl, rs);
        }
        return array;
    }

    public List<String[]> buscar_contenido_pagina_tab(Object pagina, Object tipo) throws Exception {//no funciona no se usa
        List<String[]> lista = new ArrayList<String[]>();
        boolean datos = false;
        try {
            String sql = "web_buscar_contenido_pagina_tab";
            //  cn = obtenerConexionJTDS();
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + " (?,?)}");
            cl.setObject(1, pagina);
            cl.setObject(2, tipo);

            rs = cl.executeQuery();

            ResultSetMetaData rm = rs.getMetaData();
            int numCols = rm.getColumnCount();

            String[] titCols = new String[numCols];
            for (int i = 0; i < numCols; ++i) {
                titCols[i] = rm.getColumnName(i + 1);
            }

            //   lista.add(titCols);
            while (rs.next()) {
                datos = true;
                String[] reg = new String[numCols];

                for (int i = 0; i < numCols; i++) {
                    reg[i] = rs.getString(i + 1);
                }
                lista.add(reg);
            }
            if (!datos) {
                String[] reg = new String[numCols];
                for (int i = 0; i < numCols; i++) {
                    reg[i] = " ";
                }
                lista.add(reg);
            }

        } finally {
            cerrar(cn, cl, rs);
        }
        return lista;
    }

    public List<String[]> buscar_tg30wbmenu_edt(Object tipo) throws Exception {
        List<String[]> lista = new ArrayList<String[]>();
        boolean datos = false;
        try {
            String sql = "web_buscar_tg30wbmenu_edt";
            //  cn = obtenerConexionJTDS();
//            cn = obtenerConexionJTDS();
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + " (?)}");
            cl.setObject(1, tipo);

            rs = cl.executeQuery();

            ResultSetMetaData rm = rs.getMetaData();
            int numCols = rm.getColumnCount();

            String[] titCols = new String[numCols];
            for (int i = 0; i < numCols; ++i) {
                titCols[i] = rm.getColumnName(i + 1);
            }

            //   lista.add(titCols);
            while (rs.next()) {
                datos = true;
                String[] reg = new String[numCols];

                for (int i = 0; i < numCols; i++) {
                    reg[i] = rs.getString(i + 1);
                }
                lista.add(reg);
            }
            if (!datos) {
                String[] reg = new String[numCols];
                for (int i = 0; i < numCols; i++) {
                    reg[i] = " ";
                }
                lista.add(reg);
            }

        } finally {
            cerrar(cn, cl, rs);
        }
        return lista;
    }

    public List<String[]> buscar_tg30wbmodulo_all() throws Exception {
        List<String[]> l = new ArrayList<String[]>();
        l.add(new String[]{"", ""});
        try {
//            cn = obtenerConexionJTDS();
            cn = obtenerConexionJTDS();
            pr = cn.prepareStatement("select * from tg30wbmodulo (nolock) where habilitado =1; ");
            rs = pr.executeQuery();
            while (rs.next()) {
                String[] s = new String[6];
                s[0] = (rs.getString("idmodulo_web"));
                s[1] = (rs.getString("titulo"));
                s[2] = (rs.getString("descripcion"));
                s[3] = (rs.getString("icono"));
                s[4] = (rs.getString("rutaimagen"));
                s[5] = (rs.getString("comando"));
                l.add(s);
            }
        } finally {
            cerrar(cn, pr, rs);
        }
        return l;
    }

    public List<String[]> buscar_tg30wbmodulo_all2() throws Exception {
        List<String[]> l = new ArrayList<String[]>();
        try {
//            cn = obtenerConexionJTDS();
            cn = obtenerConexionJTDS();
            pr = cn.prepareStatement("select * from tg30wbmodulo(nolock)");
            rs = pr.executeQuery();
            while (rs.next()) {
                String[] s = new String[7];
                s[0] = (rs.getString("idmodulo_web"));
                s[1] = (rs.getString("titulo"));
                s[2] = (rs.getString("descripcion"));
                s[3] = (rs.getString("habilitado"));
                s[4] = (rs.getString("icono"));
                s[5] = (rs.getString("rutaImagen"));
                s[6] = (rs.getString("comando"));
                l.add(s);
            }
        } finally {
            cerrar(cn, pr, rs);
        }
        return l;
    }

    public List<String[]> buscar_tg30wbmodulo(String idusuario) throws Exception {
        List<String[]> l = new ArrayList<String[]>();
        try {
            String sql = "nsp_web_usuario_tg30wbmodulo_S";
//            cn = obtenerConexionJTDS();
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + " (?,?)}");
            cl.setObject(1, Constantes.IDEMPRESAGENERAL);
            cl.setObject(2, idusuario);
            rs = cl.executeQuery();
            while (rs.next()) {
                String[] s = new String[6];
                s[0] = (rs.getString("idmodulo_web"));
                s[1] = (rs.getString("titulo"));
                s[2] = (rs.getString("descripcion"));
                s[3] = (rs.getString("icono"));
                s[4] = (rs.getString("rutaimagen"));
                s[5] = (rs.getString("comando"));
                l.add(s);
            }
        } finally {
            cerrar(cn, cl, rs);
        }
        return l;
    }

    public Double objtablas_returnimpuestoxproducto(Object idcod, Date dfecha) throws Exception { //no se usa
        Double impuesto = 0.00;
        try {

            String sql = "OBJTABLAS_RETURNIMPUESTOXPRODUCTO";
            cn = obtenerConexionJTDS();
//            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + " (?,?,?)}");
            cl.setObject(1, Constantes.getIDEMPRESAGENERAL());
            cl.setObject(2, idcod);
            cl.setObject(3, ManejadorFechas.getFechaFormateada(dfecha, "yyyyMMdd"));
            rs = cl.executeQuery();

            while (rs.next()) {
                impuesto = impuesto + UtilitariosLocal.parseDouble_Null(rs.getString("valor"));
            }
        } finally {
            cerrar(cn, cl, rs);
        }
        return impuesto;
    }

    public Double objTablas_precioVenta(String idclieprov, Object suc, Object idcodpro, Object moneda, Date dfecha) throws Exception { //no se usa
        Double l = 0.00;
        String lcPrecio_Aplicado = "PE";

        try {
//            cn = obtenerConexionJTDS();
            cn = obtenerConexionJTDS();
            pr = cn.prepareStatement("SELECT isnull(PRECIO_APLICADO,'PE') PRECIO_APLICADO FROM CLIEPROV (nolock) WHERE IDCLIEPROV = '" + idclieprov + "' AND IDEMPRESA = '" + Constantes.getIDEMPRESAGENERAL() + "' and estado =1; ");
            rs = pr.executeQuery();
            while (rs.next()) {
                lcPrecio_Aplicado = (rs.getString("PRECIO_APLICADO"));
            }
        } finally {
            cerrar(cn, pr, rs);
        }

        try {

            String sql = "objTablas_precioVenta";
            cn = obtenerConexionJTDS();
//            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + " (?,?,?,?,?)}");
            cl.setObject(1, Constantes.getIDEMPRESAGENERAL());
            cl.setObject(2, suc);
            cl.setObject(3, idcodpro);
            cl.setObject(4, moneda);
            cl.setObject(5, ManejadorFechas.getFechaFormateada(dfecha, "yyyyMMdd"));
            rs = cl.executeQuery();

            while (rs.next()) {
                if (lcPrecio_Aplicado.equalsIgnoreCase("PE")) {
                    l = UtilitariosLocal.parseDouble_Null(rs.getString("precio_stk"));
                }
                if (lcPrecio_Aplicado.equalsIgnoreCase("P1")) {
                    l = UtilitariosLocal.parseDouble_Null(rs.getString("precio1"));
                }
                if (lcPrecio_Aplicado.equalsIgnoreCase("P2")) {
                    l = UtilitariosLocal.parseDouble_Null(rs.getString("precio2"));
                }
                if (lcPrecio_Aplicado.equalsIgnoreCase("P3")) {
                    l = UtilitariosLocal.parseDouble_Null(rs.getString("precio3"));
                }
                if (lcPrecio_Aplicado.equalsIgnoreCase("P4")) {
                    l = UtilitariosLocal.parseDouble_Null(rs.getString("precio4"));
                }
                if (lcPrecio_Aplicado.equalsIgnoreCase("P5")) {
                    l = UtilitariosLocal.parseDouble_Null(rs.getString("precio5"));
                }
            }
        } finally {
            cerrar(cn, cl, rs);
        }
        return l;
    }

    public List<String[]> buscar_empresa(String idusuario) throws Exception {
        List<String[]> l = new ArrayList<String[]>();
        try {
            String sql = "nsp_web_usuario_empresa_S";
            cn = obtenerConexionJTDS();
//            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + " (?)}");
            cl.setObject(1, idusuario);
            rs = cl.executeQuery();
            while (rs.next()) {
                String[] s = new String[3];
                s[0] = (rs.getString("idempresa"));
                s[1] = (rs.getString("razon_social"));
                s[2] = (rs.getString("ruc"));
                l.add(s);
            }
        } finally {
            cerrar(cn, cl, rs);
        }
        return l;
    }

    public List<String[]> buscar_sucursal(String idusuario) throws Exception {

        List<String[]> l = new ArrayList<String[]>();
        try {
            String sql = "nsp_web_usuario_sucursal_S";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + " (?,?)}");
            cl.setObject(1, Constantes.IDEMPRESAGENERAL);
            cl.setObject(2, idusuario);
            rs = cl.executeQuery();
            while (rs.next()) {
                String[] s = new String[2];
                s[0] = (rs.getString("idsucursal"));
                s[1] = (rs.getString("descripcion"));
                l.add(s);
            }
        } finally {
            cerrar(cn, cl, rs);
        }
        return l;

    }

    public String buscar_vendedor_usuario(String idusuario) throws Exception { //no se usa
        String l = "";
        try {
            cn = obtenerConexionJTDS();
            pr = cn.prepareStatement("select idvendedor from vendedor where idusuario= '" + idusuario + "' and idempresa = '" + Constantes.getIDEMPRESAGENERAL() + "' and ISNULL(ESTADO,0) = 1; ");
            rs = pr.executeQuery();
            while (rs.next()) {
                l = (rs.getString("idvendedor"));
            }
        } finally {
            cerrar(cn, pr, rs);
        }
        return l;
    }

    public List<String[]> buscar_colores() throws Exception {//no se usa
        List<String[]> l = new ArrayList<String[]>();
        l.add(new String[]{"", ""});
        try {
            cn = obtenerConexionJTDS();
            pr = cn.prepareStatement("select * from colores (nolock) where estado =1; ");
            rs = pr.executeQuery();
            while (rs.next()) {
                String[] s = new String[2];
                s[0] = (rs.getString("idcolor"));
                s[1] = (rs.getString("descripcion"));
                l.add(s);
            }
        } finally {
            cerrar(cn, pr, rs);
        }
        return l;
    }

    public List<String[]> buscar_colores_vehiculo(String idmodelo) throws Exception {//no se usa
        List<String[]> l = new ArrayList<String[]>();
        l.add(new String[]{"", ""});
        try {
            cn = obtenerConexionJTDS();
            pr = cn.prepareStatement("select d.idcolor,c.descripcion "
                    + " from DMODELOVEHICULOCOLOR d (nolock)  "
                    + " inner join colores c on d.idcolor=c.idcolor  "
                    + " where d.IDMODELOVEHICULO= '" + idmodelo + "'  and d.idempresa = '" + Constantes.getIDEMPRESAGENERAL() + "' and c.estado =1; ");
            rs = pr.executeQuery();
            while (rs.next()) {
                String[] s = new String[2];
                s[0] = (rs.getString("idcolor"));
                s[1] = (rs.getString("descripcion"));
                l.add(s);
            }
        } finally {
            cerrar(cn, pr, rs);
        }
        return l;
    }

    public List<String[]> buscar_Fpago() throws Exception { //No se usa
        List<String[]> l = new ArrayList<String[]>();
        //    l.add(new String[]{"", "",""});
        try {
            cn = obtenerConexionJTDS();
            pr = cn.prepareStatement("select * from forma_pago (nolock) where idempresa = '" + Constantes.getIDEMPRESAGENERAL() + "' and estado =1; ");
            rs = pr.executeQuery();
            while (rs.next()) {
                String[] s = new String[3];
                s[0] = (rs.getString("idfpago"));
                s[1] = (rs.getString("descripcion"));
                s[2] = (rs.getString("contado"));
                l.add(s);
            }
        } finally {
            cerrar(cn, pr, rs);
        }
        return l;
    }

    public List<String[]> buscar_Bancos() throws Exception { //no se Usa

        List<String[]> l = new ArrayList<String[]>();
        l.add(new String[]{"", ""});
        try {
            String sql = "GETTABLES_RETURNBANCO_PRIORIDAD";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + " (?)}");
            cl.setObject(1, Constantes.getIDEMPRESAGENERAL());
            rs = cl.executeQuery();
            while (rs.next()) {
                String[] s = new String[4];
                s[0] = (rs.getString("idbanco"));
                s[1] = (rs.getString("descripcion"));
                s[2] = (rs.getString("dscto_cotizacion"));
                s[3] = (rs.getString("idmoneda_dscto"));
                l.add(s);
            }
        } finally {
            cerrar(cn, cl, rs);
        }
        return l;

    }

    public List<String[]> buscar_docidentidad() throws Exception {//no se usa
        List<String[]> l = new ArrayList<String[]>();
        l.add(new String[]{"", ""});
        try {
            cn = obtenerConexionJTDS();
            pr = cn.prepareStatement("select iddocidentidad,descripcion from doc_identidad  (nolock)  where estado =1; ");
            rs = pr.executeQuery();
            while (rs.next()) {
                String[] s = new String[2];
                s[0] = (rs.getString("iddocidentidad"));
                s[1] = (rs.getString("descripcion"));
                l.add(s);
            }
        } finally {
            cerrar(cn, pr, rs);
        }
        return l;
    }

    public List<String[]> buscar_estadoCivil() throws Exception {//no se usa
        List<String[]> l = new ArrayList<String[]>();
        l.add(new String[]{"", ""});
        try {
            cn = obtenerConexionJTDS();
            pr = cn.prepareStatement("select idestadocivil,descripcion from estado_civil  (nolock)  where estado =1; ");
            rs = pr.executeQuery();
            while (rs.next()) {
                String[] s = new String[2];
                s[0] = (rs.getString("idestadocivil"));
                s[1] = (rs.getString("descripcion"));
                l.add(s);
            }
        } finally {
            cerrar(cn, pr, rs);
        }
        return l;
    }

    public List<String[]> buscar_monedas() throws Exception {//no se usa
        List<String[]> l = new ArrayList<String[]>();

        try {
            cn = obtenerConexionJTDS();
            pr = cn.prepareStatement("select idmoneda,descripcion from monedas (nolock) where estado =1; ");
            rs = pr.executeQuery();
            while (rs.next()) {
                String[] s = new String[2];
                s[0] = (rs.getString("idmoneda"));
                s[1] = (rs.getString("descripcion"));
                l.add(s);
            }
        } finally {
            cerrar(cn, pr, rs);
        }
        return l;
    }

    public List<String[]> buscar_tipo_credito() throws Exception {//no se usa
        List<String[]> l = new ArrayList<String[]>();
        l.add(new String[]{"", ""});
        try {
            cn = obtenerConexionJTDS();
            pr = cn.prepareStatement("select idtipocredito,descripcion from tipo_credito (nolock) where estado =1; ");
            rs = pr.executeQuery();
            while (rs.next()) {
                String[] s = new String[2];
                s[0] = (rs.getString("idtipocredito"));
                s[1] = (rs.getString("descripcion"));
                l.add(s);
            }
        } finally {
            cerrar(cn, pr, rs);
        }
        return l;
    }

    public List<String[]> buscar_tipo_credito_cuota(String tipo) throws Exception { //no se usa
        List<String[]> l = new ArrayList<String[]>();

        try {
            cn = obtenerConexionJTDS();
            pr = cn.prepareStatement("select cuota from tipo_credito_cuota (nolock)  where idtipocredito = '" + tipo + "' and estado =1; ");
            rs = pr.executeQuery();
            while (rs.next()) {
                String[] s = new String[1];
                s[0] = (rs.getString("cuota"));
                l.add(s);
            }
        } finally {
            cerrar(cn, pr, rs);
        }
        return l;
    }

    public List<String[]> buscar_condicionlaboral() throws Exception { //no se usa
        List<String[]> l = new ArrayList<String[]>();
        l.add(new String[]{"", ""});
        try {
            cn = obtenerConexionJTDS();
            pr = cn.prepareStatement("select idcondicionlaboral,descripcion from condicionlaboral (nolock) where estado =1 and copropietario=0; ");
            rs = pr.executeQuery();
            while (rs.next()) {
                String[] s = new String[2];
                s[0] = (rs.getString("idcondicionlaboral"));
                s[1] = (rs.getString("descripcion"));
                l.add(s);
            }
        } finally {
            cerrar(cn, pr, rs);
        }
        return l;
    }

    public List<String[]> buscar_condicionlaboralCopro() throws Exception {//no se usa
        List<String[]> l = new ArrayList<String[]>();
        l.add(new String[]{"", ""});
        try {
            cn = obtenerConexionJTDS();
            pr = cn.prepareStatement("select idcondicionlaboral,descripcion from condicionlaboral (nolock) where estado =1; ");
            rs = pr.executeQuery();
            while (rs.next()) {
                String[] s = new String[2];
                s[0] = (rs.getString("idcondicionlaboral"));
                s[1] = (rs.getString("descripcion"));
                l.add(s);
            }
        } finally {
            cerrar(cn, pr, rs);
        }
        return l;
    }

    public List<String[]> buscar_categorialaboral(String cond) throws Exception {//no se usa
        List<String[]> l = new ArrayList<String[]>();

        try {
            cn = obtenerConexionJTDS();
            pr = cn.prepareStatement("select idcategorialaboral,descripcion from categorialaboral (nolock) where idcondicionlaboral = '" + cond + "' and estado =1; ");
            rs = pr.executeQuery();
            while (rs.next()) {
                String[] s = new String[2];
                s[0] = (rs.getString("idcategorialaboral"));
                s[1] = (rs.getString("descripcion"));
                l.add(s);
            }
        } finally {
            cerrar(cn, pr, rs);
        }
        return l;
    }

    public List<String[]> buscar_categorialaboral() throws Exception {//no se usa
        List<String[]> l = new ArrayList<String[]>();

        try {
            cn = obtenerConexionJTDS();
            pr = cn.prepareStatement("select idcondicionlaboral,idcategorialaboral,descripcion from categorialaboral (nolock) where estado =1; ");
            rs = pr.executeQuery();
            while (rs.next()) {
                String[] s = new String[3];
                s[0] = (rs.getString("idcondicionlaboral"));
                s[1] = (rs.getString("idcategorialaboral"));
                s[2] = (rs.getString("descripcion"));
                l.add(s);
            }
        } finally {
            cerrar(cn, pr, rs);
        }
        return l;
    }

    public List<String[]> buscar_categorialaboralCopro(String cond) throws Exception {//no se usa
        List<String[]> l = new ArrayList<String[]>();

        try {
            cn = obtenerConexionJTDS();
            pr = cn.prepareStatement("select idcategorialaboral,descripcion from categorialaboral (nolock) where idcondicionlaboral = '" + cond + "' and estado =1; ");
            rs = pr.executeQuery();
            while (rs.next()) {
                String[] s = new String[2];
                s[0] = (rs.getString("idcategorialaboral"));
                s[1] = (rs.getString("descripcion"));
                l.add(s);
            }
        } finally {
            cerrar(cn, pr, rs);
        }
        return l;
    }

    public List<Object[]> buscar_tg30campaniaveh() throws Exception {//no se usa
        List<Object[]> l = new ArrayList<Object[]>();
        // l.add(new Object[]{null,""});
        try {
            cn = obtenerConexionJTDS();
            pr = cn.prepareStatement("select idtg30campaniaveh,cdescripcion,dfechainicio,dfechafin from tg30campaniaveh (nolock) where idempresa = '" + Constantes.getIDEMPRESAGENERAL() + "' and  iestado = 1; ");
            rs = pr.executeQuery();
            while (rs.next()) {
                Object[] s = new Object[4];
                s[0] = UtilitariosLocal.parseInteger_Null(rs.getString("idtg30campaniaveh"));
                s[1] = (rs.getString("cdescripcion"));
                s[2] = (rs.getTimestamp("DFECHAINICIO"));
                s[3] = (rs.getTimestamp("DFECHAFIN"));

                l.add(s);
            }
        } finally {
            cerrar(cn, pr, rs);
        }
        return l;
    }

    public List<String[]> buscar_listaprecioveh(String idcampaniaveh, String idsucursal) throws Exception {//no se usa
        List<String[]> l = new ArrayList<String[]>();

        try {
            cn = obtenerConexionJTDS();
            pr = cn.prepareStatement("select idtg10listaprecioveh,iddocumento+' '+serie+'-'+numero doc from tg10listaprecioveh (nolock) "
                    + " where idempresa = '" + Constantes.getIDEMPRESAGENERAL() + "' and "
                    + " idtg30campaniaveh = '" + idcampaniaveh + "' and "
                    + " idsucursal = '" + idsucursal + "' ;");
            rs = pr.executeQuery();
            while (rs.next()) {
                String[] s = new String[2];
                s[0] = rs.getString("idtg10listaprecioveh");
                s[1] = rs.getString("doc");

                l.add(s);
            }
        } finally {
            cerrar(cn, pr, rs);
        }
        return l;
    }

    public Double buscar_tcambio(String fecha) throws Exception {//no se ua
        Double l = 0.00;
        // l.add(new Object[]{null,""});
        try {
            cn = obtenerConexionJTDS();
            pr = cn.prepareStatement("select t_compra, t_venta from tcambio_interno (nolock) where convert(varchar(8),fecha,112)=" + fecha + "; ");
            rs = pr.executeQuery();
            while (rs.next()) {
                l = UtilitariosLocal.parseDouble_Null(rs.getString("t_venta"));

            }
        } finally {
            cerrar(cn, pr, rs);
        }
        return l;
    }

    public List<String[]> buscar_tipovehiculo() throws Exception {//no se usa
        List<String[]> l = new ArrayList<String[]>();
        l.add(new String[]{"", ""});
        try {
            String sql = "nsp_modelo_vehiculo_tipovehiculo_S";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + " (?)}");
            cl.setObject(1, Constantes.getIDEMPRESAGENERAL());
            rs = cl.executeQuery();
            while (rs.next()) {
                String[] s = new String[2];
                s[0] = (rs.getString("idclasevehiculo"));
                s[1] = (rs.getString("descripcion"));

                l.add(s);
            }
        } finally {
            cerrar(cn, cl, rs);
        }
        return l;
    }

    public List<String[]> buscar_vendedores(String usuario) throws Exception {//no se usa
        List<String[]> l = new ArrayList<String[]>();
        try {
            String sql = "OBTENER_VENDEDORES_POR_USUARIO";
            cn = obtenerConexionJTDS();

            cl = cn.prepareCall("{CALL " + sql + " (?,?)}");
            cl.setObject(1, Constantes.getIDEMPRESAGENERAL());
            cl.setObject(2, usuario);

            rs = cl.executeQuery();
            while (rs.next()) {
                String[] s = new String[2];
                s[0] = (rs.getString("codigo"));
                s[1] = (rs.getString("descripcion"));

                l.add(s);
            }
        } finally {
            cerrar(cn, cl, rs);
        }
        return l;
    }

    public List<String[]> buscar_tipocotizacion() throws Exception {//no se us
        List<String[]> l = new ArrayList<String[]>();

        try {
            String sql = "GETTABLES_RETURNTG10TIPOCOTIZACION";
            cn = obtenerConexionJTDS();

            cl = cn.prepareCall("{CALL " + sql + " (?)}");
            cl.setObject(1, Constantes.getIDEMPRESAGENERAL());

            rs = cl.executeQuery();
            while (rs.next()) {
                String[] s = new String[2];
                s[0] = (rs.getString("idtg10tipocotizacion"));
                s[1] = (rs.getString("descripcion"));

                l.add(s);
            }
        } finally {
            cerrar(cn, cl, rs);
        }
        return l;
    }

    public List<String[]> buscar_almacenes() throws Exception {//no se usa
        List<String[]> l = new ArrayList<String[]>();
        try {
            String sql = "GETRECORD_RETURNALMACEN";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + " (?,?,?)}");
            cl.setObject(1, Constantes.getIDEMPRESAGENERAL());
            cl.setObject(2, Constantes.getIDSUCURSALGENERAL());
            cl.setObject(3, "");
            rs = cl.executeQuery();
            while (rs.next()) {
                String[] s = new String[2];
                s[0] = (rs.getString("idalmacen"));
                s[1] = (rs.getString("descripcion"));
                l.add(s);
            }
        } finally {
            cerrar(cn, cl, rs);
        }
        return l;
    }

    public List<String[]> buscar_marcavehiculo(Object idtipo) throws Exception {//no se usa
        List<String[]> l = new ArrayList<String[]>();
        l.add(new String[]{"", ""});
        try {
            String sql = "nsp_modelo_vehiculo_idmarca_S";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + " (?,?)}");
            cl.setObject(1, Constantes.getIDEMPRESAGENERAL());
            cl.setObject(2, idtipo);
            rs = cl.executeQuery();
            while (rs.next()) {
                String[] s = new String[2];
                s[0] = (rs.getString("idmarca"));
                s[1] = (rs.getString("descripcion"));
                l.add(s);
            }
        } finally {
            cerrar(cn, cl, rs);
        }
        return l;
    }

    public List<String[]> buscar_modelovehiculo(Object idmarca) throws Exception {//no se usa
        List<String[]> l = new ArrayList<String[]>();
        l.add(new String[]{"", ""});
        try {
            String sql = "nsp_modelo_vehiculo_idmodelo_S";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + " (?,?)}");
            cl.setObject(1, Constantes.getIDEMPRESAGENERAL());
            cl.setObject(2, idmarca);
            rs = cl.executeQuery();
            while (rs.next()) {
                String[] s = new String[2];
                s[0] = (rs.getString("idmodelo"));
                s[1] = (rs.getString("descripcion"));
                l.add(s);
            }
        } finally {
            cerrar(cn, cl, rs);
        }
        return l;
    }

    public List<String[]> buscar_versionvehiculo(Object idmodelo) throws Exception {//no se usa
        List<String[]> l = new ArrayList<String[]>();
        l.add(new String[]{"", ""});
        try {
            String sql = "nsp_modelo_vehiculo_idversion_S";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + " (?,?)}");
            cl.setObject(1, Constantes.getIDEMPRESAGENERAL());
            cl.setObject(2, idmodelo);
            rs = cl.executeQuery();
            while (rs.next()) {
                String[] s = new String[2];
                s[0] = (rs.getString("FK_IDTG20VERSIONVEH"));
                s[1] = (rs.getString("cdescripcion"));
                l.add(s);
            }
        } finally {
            cerrar(cn, cl, rs);
        }
        return l;
    }

    public List<Object[]> buscar_modeloVehiculoGeneral(Object idtipo, Object idmarca, Object idmodelo, Object idversion, Object anio, Object filtromodelo, Object idcampania, Object idformapago, Object idmoneda, Object fecha) throws Exception {//no se usa
        List<Object[]> l = new ArrayList<Object[]>();

        try {
            String sql = "nsp_modelo_vehiculo_filtro_S";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + " (?,?,?,?,?,?,?,?,?,?,?,?)}");
            cl.setObject(1, Constantes.getIDEMPRESAGENERAL());
            cl.setObject(2, idtipo);
            cl.setObject(3, idmarca);
            cl.setObject(4, idmodelo);
            cl.setObject(5, idversion);
            cl.setObject(6, anio);
            cl.setObject(7, filtromodelo);
            cl.setObject(8, idcampania);
            cl.setObject(9, Constantes.getIDSUCURSALGENERAL());
            cl.setObject(10, idformapago);
            cl.setObject(11, idmoneda);
            cl.setObject(12, fecha);
            rs = cl.executeQuery();
            while (rs.next()) {
                Object[] s = new Object[13];
                s[0] = (rs.getString("idmodelovehiculo"));
                s[1] = (rs.getString("modelovehiculo"));
                s[2] = (rs.getString("tipo"));
                s[3] = (rs.getString("marca"));
                s[4] = (rs.getString("modelo"));
                s[5] = (rs.getString("version"));
                s[6] = (rs.getString("anio"));
                s[7] = (rs.getString("idmedida"));
                s[8] = UtilitariosLocal.parseDouble_Null(rs.getString("nimporteventapublico"));
                s[9] = UtilitariosLocal.parseDouble_Null(rs.getString("NDESCUENTO_IMPORTADOR"));
                s[10] = UtilitariosLocal.parseDouble_Null(rs.getString("NDESCUENTO_MAX_AUTORIZADO"));
                s[11] = (rs.getString("aniofab"));
                s[12] = UtilitariosLocal.parseInteger_Null(rs.getString("FK_IDTG20VERSIONVEH"));

                l.add(s);
            }
        } finally {
            cerrar(cn, cl, rs);
        }
        return l;
    }

    public List<String[]> buscar_Departamento() throws Exception {//no se usa
        List<String[]> l = new ArrayList<String[]>();
        l.add(new String[]{"", ""});
        try {
            cn = obtenerConexionJTDS();
            pr = cn.prepareStatement("select iddepartamento,descripcion from departamento (nolock) ; ");
            rs = pr.executeQuery();
            while (rs.next()) {
                String[] s = new String[2];
                s[0] = (rs.getString("iddepartamento"));
                s[1] = (rs.getString("descripcion"));
                l.add(s);
            }
        } finally {
            cerrar(cn, pr, rs);
        }
        return l;
    }

    public List<String[]> buscar_Provincia(String iddepa) throws Exception {//no se usa
        List<String[]> l = new ArrayList<String[]>();
        l.add(new String[]{"", ""});
        try {
            cn = obtenerConexionJTDS();
            pr = cn.prepareStatement("select idprovincia,descripcion from provincias (nolock) where iddepartamento = '" + iddepa + "' ; ");
            rs = pr.executeQuery();
            while (rs.next()) {
                String[] s = new String[2];
                s[0] = (rs.getString("idprovincia"));
                s[1] = (rs.getString("descripcion"));
                l.add(s);
            }
        } finally {
            cerrar(cn, pr, rs);
        }
        return l;
    }

    public List<String[]> buscar_Distrito(String iddepa, String idprov) throws Exception {//no se usa
        List<String[]> l = new ArrayList<String[]>();
        l.add(new String[]{"", ""});
        try {
            cn = obtenerConexionJTDS();
            pr = cn.prepareStatement("select idubigeo,descripcion from ubigeo (nolock) where iddepartamento = '" + iddepa + "' and  idprovincia = '" + idprov + "' ; ");
            rs = pr.executeQuery();
            while (rs.next()) {
                String[] s = new String[2];
                s[0] = (rs.getString("idubigeo"));
                s[1] = (rs.getString("descripcion"));
                l.add(s);
            }
        } finally {
            cerrar(cn, pr, rs);
        }
        return l;
    }

    public List<Object[]> buscar_wbprivilegio_sucursal(Object idusuario) throws Exception {
        List<Object[]> l = new ArrayList<Object[]>();
        try {

            String sql = "web_privilegio_sucursal";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + " (?)}");
            cl.setObject(1, idusuario);
            rs = cl.executeQuery();
            while (rs.next()) {
                Object[] s = new Object[5];
                s[0] = (boolean) (rs.getString("elegido")).equalsIgnoreCase("1") ? true : false;
                s[1] = (rs.getString("idempresa"));
                s[2] = (rs.getString("empresa"));
                s[3] = (rs.getString("idsucursal"));
                s[4] = (rs.getString("sucursal"));

                l.add(s);
            }
        } finally {
            cerrar(cn, cl, rs);
        }
        return l;
    }

    public List<Object[]> buscar_wbprivilegio_modulo(Object idusuario, String idemprsa) throws Exception {
        List<Object[]> l = new ArrayList<Object[]>();
        try {

            String sql = "web_privilegio_Modulo";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + " (?,?)}");
            cl.setObject(1, idusuario);
            cl.setString(2, idemprsa);
            rs = cl.executeQuery();
            while (rs.next()) {
                Object[] s = new Object[5];
                s[0] = (boolean) (rs.getString("elegido")).equalsIgnoreCase("1") ? true : false;
                s[1] = (rs.getString("idempresa"));
                s[2] = (rs.getString("Empresa"));
                s[3] = (rs.getString("idmodulo_web"));
                s[4] = (rs.getString("Modulo"));

                l.add(s);
            }
        } finally {
            cerrar(cn, cl, rs);
        }
        return l;
    }

    public List<Object[]> buscar_wbprivilegio_menu(int idcontenido, String idusuario, String idemprsa) throws Exception {
        List<Object[]> l = new ArrayList<Object[]>();
        try {

            String sql = "web_privilegio_Menu";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + " (?,?,?)}");
            cl.setInt(1, idcontenido);
            cl.setString(2, idusuario);
            cl.setString(3, idemprsa);
            rs = cl.executeQuery();
            while (rs.next()) {
                Object[] s = new Object[10];
                s[0] = (boolean) (rs.getString("elegido")).equalsIgnoreCase("1") ? true : false;
                s[1] = (rs.getInt("idcontenido"));
                s[2] = (rs.getString("idempresa"));
                s[3] = (boolean) (rs.getString("Nuevo")).equalsIgnoreCase("1") ? true : false;
                s[4] = (boolean) (rs.getString("Editar")).equalsIgnoreCase("1") ? true : false;
                s[5] = (boolean) (rs.getString("Eliminar")).equalsIgnoreCase("1") ? true : false;
                s[6] = (boolean) (rs.getString("Anular")).equalsIgnoreCase("1") ? true : false;
                s[7] = (boolean) (rs.getString("Grabar")).equalsIgnoreCase("1") ? true : false;
                s[8] = (boolean) (rs.getString("Cerrar")).equalsIgnoreCase("1") ? true : false;
                s[9] = (boolean) (rs.getString("Aprobar")).equalsIgnoreCase("1") ? true : false;
                l.add(s);
            }
        } finally {
            cerrar(cn, cl, rs);
        }
        return l;
    }

    public List<Object[]> buscar_seguimientoBancos(Object idcotizacion) throws Exception {//no se usa
        List<Object[]> l = new ArrayList<Object[]>();
        try {
            String sql = "nsp_seguimientoBancos_S";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + " (?,?)}");
            cl.setObject(1, Constantes.getIDEMPRESAGENERAL());
            cl.setObject(2, idcotizacion);
            rs = cl.executeQuery();
            while (rs.next()) {
                Object[] s = new Object[10];
                s[0] = (rs.getString("IDBANCO"));
                s[1] = (rs.getString("BANCO"));
                s[2] = (rs.getString("IDUSUARIO_BANCO"));
                s[3] = (rs.getString("ESTADOBANCO"));
                s[4] = (rs.getString("ESTADORECHAZO"));
                s[5] = (rs.getString("MENSAJE"));
                s[6] = (rs.getTimestamp("FECHA"));
                s[7] = (rs.getTimestamp("FECHA_ASIGNACION"));
                s[8] = (rs.getTimestamp("FECHA_CIERRE"));
                s[9] = (rs.getTimestamp("FECHA_SEPARACION"));

                l.add(s);
            }
        } finally {
            cerrar(cn, cl, rs);
        }
        return l;
    }

    public List<String[]> buscar_wbprivilegio_usuario() throws Exception {
        List<String[]> l = new ArrayList<String[]>();
        try {

            String sql = "web_privilegio_usuario";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "}");
            rs = cl.executeQuery();
            while (rs.next()) {
                String[] s = new String[3];
                s[0] = (rs.getString("idusuario"));
                s[1] = (rs.getString("usr_nombres"));
                s[2] = (rs.getString("usr_iniciales"));

                l.add(s);
            }
        } finally {
            cerrar(cn, cl, rs);
        }
        return l;
    }

    public List<String[]> buscar_wbmodulo_usuario(String idusuario, String idempresa) throws Exception {
        List<String[]> l = new ArrayList<String[]>();
        try {

            String sql = "web_privilegio_Modulo_Usuario";
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + "(?,?)}");
            cl.setString(1, idusuario);
            cl.setString(2, idempresa);
            rs = cl.executeQuery();
            while (rs.next()) {
                String[] s = new String[2];
                s[0] = (rs.getString("idmodulo_web"));
                s[1] = (rs.getString("descripcion"));
                l.add(s);
            }
        } finally {
            cerrar(cn, cl, rs);
        }
        return l;
    }

    public List<String[]> buscar_contenido_pagina_menu(Object pagina, Object tipo,String idusuario ,Object jerarquia) throws Exception {
        List<String[]> lista = new ArrayList<String[]>();
        boolean datos = false;
        try {
            String sql = "web_buscar_tg30wbmenu_pss";
            //  cn = obtenerConexionJTDS();
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + " (?,?,?,?)}");
            cl.setObject(1, pagina);
            cl.setObject(2, tipo);
            cl.setString(3,idusuario);
            cl.setObject(4, jerarquia);

            rs = cl.executeQuery();

            ResultSetMetaData rm = rs.getMetaData();
            int numCols = rm.getColumnCount();

            String[] titCols = new String[numCols];
            for (int i = 0; i < numCols; ++i) {
                titCols[i] = rm.getColumnName(i + 1);
            }

            //   lista.add(titCols);
            while (rs.next()) {
                datos = true;
                String[] reg = new String[numCols];

                for (int i = 0; i < numCols; i++) {
                    reg[i] = rs.getString(i + 1);
                }
                lista.add(reg);
            }
            if (!datos) {
                String[] reg = new String[numCols];
                for (int i = 0; i < numCols; i++) {
                    reg[i] = " ";
                }
                //  lista.add(reg); 
            }

        } finally {
            cerrar(cn, cl, rs);
        }
        return lista;
    }

    public List<String[]> buscar_contenido_pagina_menu_prib(Object pagina, Object tipo, Object jerarquia, Object idusuario) throws Exception {
        List<String[]> lista = new ArrayList<String[]>();
        boolean datos = false;
        try {
            String sql = "web_buscar_tg30wbmenu_priv";
            //  cn = obtenerConexionJTDS();
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + " (?,?,?)}");
            cl.setObject(1, pagina);
            cl.setObject(2, tipo);
            cl.setObject(3, jerarquia);

            rs = cl.executeQuery();

            ResultSetMetaData rm = rs.getMetaData();
            int numCols = rm.getColumnCount();

            String[] titCols = new String[numCols];
            for (int i = 0; i < numCols; ++i) {
                titCols[i] = rm.getColumnName(i + 1);
            }

            //   lista.add(titCols);
            while (rs.next()) {
                datos = true;
                String[] reg = new String[numCols];

                for (int i = 0; i < numCols; i++) {
                    reg[i] = rs.getString(i + 1);
                }
                lista.add(reg);
            }
            if (!datos) {
                String[] reg = new String[numCols];
                for (int i = 0; i < numCols; i++) {
                    reg[i] = " ";
                }
                //  lista.add(reg); 
            }

        } finally {
            cerrar(cn, cl, rs);
        }
        return lista;
    }

    public List<String[]> buscar_modulo_web(Object pagina, Object tipo, Object jerarquia) throws Exception {//no se usa
        List<String[]> lista = new ArrayList<String[]>();
        boolean datos = false;
        try {
            String sql = "web_buscar_contenido_pagina_menu";
            //  cn = obtenerConexionJTDS();
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + " (?,?,?)}");
            cl.setObject(1, pagina);
            cl.setObject(2, tipo);
            cl.setObject(3, jerarquia);

            rs = cl.executeQuery();

            ResultSetMetaData rm = rs.getMetaData();
            int numCols = rm.getColumnCount();

            String[] titCols = new String[numCols];
            for (int i = 0; i < numCols; ++i) {
                titCols[i] = rm.getColumnName(i + 1);
            }

            //   lista.add(titCols);
            while (rs.next()) {
                datos = true;
                String[] reg = new String[numCols];

                for (int i = 0; i < numCols; i++) {
                    reg[i] = rs.getString(i + 1);
                }
                lista.add(reg);
            }
            if (!datos) {
                String[] reg = new String[numCols];
                for (int i = 0; i < numCols; i++) {
                    reg[i] = " ";
                }
                //  lista.add(reg); 
            }

        } finally {
            cerrar(cn, cl, rs);
        }
        return lista;
    }

    public List<String[]> buscar_contenido_pagina_descripcion(Object pagina, Object tipo) throws Exception {//no se usa
        List<String[]> lista = new ArrayList<String[]>();
        boolean datos = false;
        try {
            String sql = "web_buscar_contenido_pagina_descripcion";
            //  cn = obtenerConexionJTDS();
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + " (?,?)}");
            cl.setObject(1, pagina);
            cl.setObject(2, tipo);

            rs = cl.executeQuery();

            ResultSetMetaData rm = rs.getMetaData();
            int numCols = rm.getColumnCount();

//            String[] titCols = new String[numCols];
//            for (int i = 0; i < numCols; ++i) {
//                titCols[i] = rm.getColumnName(i + 1);
//            }
            //   lista.add(titCols);
            while (rs.next()) {
                datos = true;
                String[] reg = new String[numCols];

                for (int i = 0; i < numCols; i++) {
                    reg[i] = rs.getString(i + 1);
                }
                lista.add(reg);
            }
            if (!datos) {
                String[] reg = new String[numCols];
                for (int i = 0; i < numCols; i++) {
                    reg[i] = " ";
                }
                lista.add(reg);
            }

        } finally {
            cerrar(cn, cl, rs);
        }
        return lista;
    }

    public void grabar_contenido_pagina_tab(Object pagina, Object id, Object contenido) throws Exception {//no se usa
        try {
            String sql = "web_grabar_contenido_pagina_tab";
            //  cn = obtenerConexionJTDS();
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + " (?,?,?)}");
            cl.setObject(1, pagina);
            cl.setObject(2, id);
            cl.setObject(3, contenido);

            cl.executeUpdate();

        } finally {
            cerrar(cn, cl);
        }

    }

    public void grabar_web_usuario_sucursal(Object idusuario, List<Object[]> contenido) throws Exception {
        try {
            List<auxPrivilegioSucursal> l = lista_clase(contenido);
            XStream xstream = new XStream(new DomDriver());
            xstream.alias("auxPrivilegioSucursal", auxPrivilegioSucursal.class);
            String xml = xstream.toXML(l);

            //   System.out.println("xml : " + xml);
            String sql = "web_grabar_usuario_sucursal";
            //  cn = obtenerConexionJTDS();
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + " (?,?)}");
            cl.setObject(1, idusuario);
            cl.setObject(2, xml);

            cl.executeUpdate();

        } finally {
            cerrar(cn, cl);
        }

    }

    public void grabar_web_usuario_modulo(Object idusuario, List<Object[]> contenido) throws Exception {
        try {
            List<auxPrivilegioModulo> l = lista_claseM(contenido);
            XStream xstream = new XStream(new DomDriver());
            xstream.alias("auxPrivilegioModulo", auxPrivilegioModulo.class);
            String xml = xstream.toXML(l);

            //   System.out.println("xml : " + xml);
            String sql = "web_grabar_usuario_modulo";
            //  cn = obtenerConexionJTDS();
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + " (?,?)}");
            cl.setObject(1, idusuario);
            cl.setObject(2, xml);

            cl.executeUpdate();

        } finally {
            cerrar(cn, cl);
        }

    }

    public void grabar_web_usuario_Menu(Object idusuario,Object idcontenido ,List<Object[]> contenido) throws Exception {
        try {
            List<auxPrivilegioMenu> l = lista_claseMe(contenido);
            XStream xstream = new XStream(new DomDriver());
            xstream.alias("auxPrivilegioMenu", auxPrivilegioMenu.class);
            String xml = xstream.toXML(l);

            //   System.out.println("xml : " + xml);
            String sql = "web_grabar_usuario_menu";
            //  cn = obtenerConexionJTDS();
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + " (?,?,?)}");
            cl.setObject(1, idusuario);
            cl.setObject(2,  idcontenido);
            cl.setObject(3, xml);

            cl.executeUpdate();

        } finally {
            cerrar(cn, cl);
        }

    }

    public void grabar_tg30wbmenu(String[] contenido) throws Exception {
        try {
// idcontenido,jerarquia,tipo,titulo,contenido,rutaImagen,pagina,icono,fechaCreacion,
// usuario,habilitado,orden,url,comando,actualiza,style,styleClass,sub_menu
            String sql = "web_grabar_tg30wbmenu";
            //  cn = obtenerConexionJTDS();
            int i=1;
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + " (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
            cl.setObject(i++, contenido[0]);
            cl.setObject(i++, contenido[1]);
            cl.setObject(i++, contenido[2]);
            cl.setObject(i++, contenido[3]);
            cl.setObject(i++, contenido[4]);
            cl.setObject(i++, contenido[5]);
            cl.setObject(i++, contenido[6]);
            cl.setObject(i++, contenido[7]);
            cl.setObject(i++, "");
            cl.setObject(i++, contenido[9]);
            cl.setObject(i++, contenido[10].length() > 0 ? Integer.valueOf(contenido[10]) : null);
            cl.setObject(i++, contenido[11].length() > 0 ? Integer.valueOf(contenido[11]) : null);
            cl.setObject(i++, contenido[12]);
            cl.setObject(i++, contenido[13]);
            cl.setObject(i++, contenido[14]);
            cl.setObject(i++, contenido[15]);
            cl.setObject(i++, contenido[16]);
            cl.setObject(i++, contenido[17]);
            cl.setObject(i++, contenido[18]);

            cl.executeUpdate();

        } finally {
            cerrar(cn, cl);
        }

    }

    public void grabar_tg30wbmodulo(String[] contenido) throws Exception {
        try {
// idcontenido,jerarquia,tipo,titulo,contenido,rutaImagen,pagina,icono,fechaCreacion,
// usuario,habilitado,orden,url,comando,actualiza,style,styleClass,sub_menu
            String sql = "web_grabar_tg30wbmodulo";
            //  cn = obtenerConexionJTDS();
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + " (?,?,?,?,?,?,?)}");
            cl.setObject(1, contenido[0]);
            cl.setObject(2, contenido[1]);
            cl.setObject(3, contenido[2]);
            cl.setObject(4, contenido[3]);
            cl.setObject(5, contenido[4]);
            cl.setObject(6, contenido[5]);
            cl.setObject(7, contenido[6]);

            cl.executeUpdate();

        } finally {
            cerrar(cn, cl);
        }

    }

    public void borrar_contenido_pagina_productos(String[] contenido) throws Exception { //
        try {
// idcontenido,jerarquia,tipo,titulo,contenido,rutaImagen,pagina,icono,fechaCreacion,
// usuario,habilitado,orden,url,comando,actualiza,style,styleClass,sub_menu
            String sql = "web_borrar_item_menu";
            //  cn = obtenerConexionJTDS();
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + " (?)}");
            cl.setObject(1, contenido[0]);

            cl.executeUpdate();

        } finally {
            cerrar(cn, cl);
        }

    }

    public List<String[]> buscar_contenido_pagina_acc(Object tipo) throws Exception {
        UsuarioBean ub = new UsuarioBean();
        List<String[]> lista = new ArrayList<String[]>();
        boolean datos = false;
        try {
            String sql = "web_buscar_tg30wbmenuacc";
            //  cn = obtenerConexion();
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + " (?,?)}");
            cl.setObject(1, tipo);
            cl.setObject(2, ((UsuarioBean) WebUtil.getObjetoSesion(Constantes.SESION_USUARIO)).getIDUSUARIO());

            rs = cl.executeQuery();

            ResultSetMetaData rm = rs.getMetaData();
            int numCols = rm.getColumnCount();

            String[] titCols = new String[numCols];
            for (int i = 0; i < numCols; ++i) {
                titCols[i] = rm.getColumnName(i + 1);
            }

            //   lista.add(titCols);
            while (rs.next()) {
                datos = true;
                String[] reg = new String[numCols];

                for (int i = 0; i < numCols; i++) {
                    reg[i] = rs.getString(i + 1);
                }
                lista.add(reg);
            }
            if (!datos) {
                String[] reg = new String[numCols];
                for (int i = 0; i < numCols; i++) {
                    reg[i] = " ";
                }
                //  lista.add(reg); 
            }

        } finally {
            cerrar(cn, cl, rs);
        }
        return lista;
    }

    public void borrar_contenido_mdoulo(String[] contenido) throws Exception {
        try {
// idcontenido,jerarquia,tipo,titulo,contenido,rutaImagen,pagina,icono,fechaCreacion,
// usuario,habilitado,orden,url,comando,actualiza,style,styleClass,sub_menu
            String sql = "web_borrar_modulo";
            //  cn = obtenerConexionJTDS();
            cn = obtenerConexionJTDS();
            cl = cn.prepareCall("{CALL " + sql + " (?)}");
            cl.setObject(1, contenido[0]);

            cl.executeUpdate();

        } finally {
            cerrar(cn, cl);
        }

    }

    public List<auxPrivilegioSucursal> lista_clase(List<Object[]> aux) {

        List<auxPrivilegioSucursal> l = new ArrayList<auxPrivilegioSucursal>();

        for (Object[] ls : aux) {
            if (ls[0].toString().equalsIgnoreCase("true")) {
                auxPrivilegioSucursal ax = new auxPrivilegioSucursal();
                ax.setElegido(true);
                ax.setIdempresa(ls[1].toString());
                ax.setIdsucursal(ls[3].toString());
                l.add(ax);
            }
        }

        return l;
    }

    public List<auxPrivilegioModulo> lista_claseM(List<Object[]> aux) {

        List<auxPrivilegioModulo> l = new ArrayList<auxPrivilegioModulo>();

        for (Object[] ls : aux) {
            if (ls[0].toString().equalsIgnoreCase("true")) {
                auxPrivilegioModulo ax = new auxPrivilegioModulo();
                ax.setElegido(true);
                ax.setIdempresa(ls[1].toString());
                ax.setIdmodulo_web(ls[3].toString());
                l.add(ax);
            }
        }

        return l;
    }

    public List<auxPrivilegioMenu> lista_claseMe(List<Object[]> aux) {

        List<auxPrivilegioMenu> l = new ArrayList<auxPrivilegioMenu>();

        for (Object[] ls : aux) {
            if (ls[0].toString().equalsIgnoreCase("true")) {
                auxPrivilegioMenu ax = new auxPrivilegioMenu();
                ax.setElegido(true);
                ax.setIdcontenido(ls[1].toString());
                ax.setIdempresa(ls[2].toString());
                ax.setNuevo(ls[3].toString().equalsIgnoreCase("true") ? 1 : 0);
                ax.setEditar(ls[4].toString().equalsIgnoreCase("true") ? 1 : 0);
                ax.setEliminar(ls[5].toString().equalsIgnoreCase("true") ? 1 : 0);
                ax.setAnular(ls[6].toString().equalsIgnoreCase("true") ? 1 : 0);
                ax.setGrabar(ls[7].toString().equalsIgnoreCase("true") ? 1 : 0);
                ax.setCerrar(ls[8].toString().equalsIgnoreCase("true") ? 1 : 0);
                ax.setAprobar(ls[9].toString().equalsIgnoreCase("true") ? 1 : 0);
                l.add(ax);
            }
        }

        return l;
    }
    
    public String buscar_Titulo(String url) throws Exception{
        String t = "";
        try {
//            cn = obtenerConexionJTDS();
            cn = obtenerConexionJTDS();
            pr = cn.prepareStatement("select * from TG30WBMENU (nolock) where url like ? and habilitado=1; ");
            pr.setString(1,"%"+ url+".xhtml%");
            rs = pr.executeQuery();
            while (rs.next()) {
                t = rs.getString("titulo");
            }
        } finally {
            cerrar(cn, pr, rs);
        }
        return t;
    }
}
