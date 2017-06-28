/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.nisira.movil.view.action;

import com.nisira.core.EConexion;
import com.nisira.core.dao.EmpresaDao;
import com.nisira.core.dao.UsuarioDao;
import com.nisira.core.entity.Empresa;
import com.nisira.core.entity.Usuario;
import com.nisira.core.service.EmpresaService;
import com.nisira.core.service.PrivilegiosService;
import com.nisira.core.service.UsuarioService;
import com.nisira.core.util.ConstantesBD;
import com.nisira.core.util.CoreUtil;
import com.pe.nisira.movil.view.bean.MensajeBean;
import com.pe.nisira.movil.view.bean.UsuarioBean;
import com.pe.nisira.movil.view.util.Clave;
import com.pe.nisira.movil.view.util.ClaveMovil;
import com.pe.nisira.movil.view.util.Constantes;
import java.io.Serializable;
import static com.pe.nisira.movil.view.util.WebLog.log;
import com.pe.nisira.movil.view.util.WebUtil;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import org.primefaces.context.RequestContext;
/**
 *
 * @author Eliseo
 */
@ManagedBean(name = "logueoAction")
@ViewScoped
public class LogueoAction implements Serializable {

    private UsuarioService usuarioService = new UsuarioService();
    private EmpresaService empresaService = new EmpresaService();
    private PrivilegiosService privilegiosService = new PrivilegiosService();
    private UsuarioBean usuarioBean = new UsuarioBean();
    private String mensaje;
    public String conexion;
    public String idempresa;
    private List<Empresa> listEmpresa;
    
    private List<String> hashmap_empresas;
    private List<String> hashmap_basedatos;
    private String h;
    private String w;

    public LogueoAction() throws IOException {
        usuarioService = new UsuarioService();
        empresaService = new EmpresaService();
        privilegiosService = new PrivilegiosService();
        usuarioBean = new UsuarioBean();
        listEmpresa=new ArrayList<Empresa>();
//        es_movil();
    }

    public void Iniciar(){
        mensaje= "";
        conexion = "";
        idempresa  ="";
        setHashmap_empresas(new ArrayList<>());    
        setHashmap_basedatos(new ArrayList<>());    
        cargarBaseDatos(); 
    }
    
    public void cargarBaseDatos() {
       try {
           ArrayList<String> lista_solution=CoreUtil.valoresBase();
           String cadena_basedatos = lista_solution.get(4);
           cadena_basedatos = cadena_basedatos.replace("[", "");
           cadena_basedatos = cadena_basedatos.replace("]", "");
           cadena_basedatos = cadena_basedatos.replace("=", "");
           
           String[] lista_basedatos =  cadena_basedatos.split(",");
            setHashmap_basedatos(new ArrayList<>()); 
            for(String basedatos : lista_basedatos){
                getHashmap_basedatos().add(basedatos);
            }
            if(!getHashmap_basedatos().isEmpty()){
                conexion=getHashmap_basedatos().get(0);
                cargarEmpresas();
            }
            RequestContext.getCurrentInstance().update("page01:frmlogueo:cbobasedatos");
       } 
       catch (Exception ex) {
           log.error(ex, ex);
       }
    }
    public void cargarEmpresas() {
       try {
           Constantes.conexionORM=conexion;
           Constantes.setConexionORM(conexion);
           EmpresaDao empresadao = new EmpresaDao();
           listEmpresa=empresadao.listar();
           if(!listEmpresa.isEmpty())
               idempresa=listEmpresa.get(0).getIdempresa();
           RequestContext.getCurrentInstance().update("page01:frmlogueo:cboempresa");
       } 
       catch (Exception ex) {
           log.error(ex, ex);
       }
    }
    public String loguear() {
        try {
            if (usuarioBean.getIDUSUARIO().isEmpty()) {
                WebUtil.MensajeAlerta("Ingrese Nombre de Usuario");
                this.mensaje = "Ingrese Nombre de Usuario";
            } else if (usuarioBean.getPASSWORD().isEmpty()) {
                WebUtil.MensajeAlerta("Ingrese Clave");
                this.mensaje = "Ingrese Clave";
            } else if (conexion.equals("nada")) {
                WebUtil.MensajeAlerta("Seleccione una Base de Datos");
                this.mensaje = "Seleccione una Base de Datos";
            } else if (idempresa.equals("")) {
                WebUtil.MensajeAlerta("Seleccione una Empresa");
                this.mensaje = "Seleccione una Empresa";
            }
            else {
                this.mensaje = "";
                ConstantesBD.setBDCONECCION(conexion);
                ConstantesBD.setIDEMPRESA(idempresa);
                //Constantes.setConexionORM(Constantes.conexionORM);
                UsuarioDao usuariodao =new UsuarioDao(true);
                Usuario usuario= usuariodao.getSesionUsuario(idempresa,usuarioBean.getIDUSUARIO(),Clave.Encriptar(usuarioBean.getPASSWORD())); 
                if (usuario != null) {
                    log.info("Creando la sesion");
                    FacesContext.getCurrentInstance().getExternalContext().getSession(true);
                    WebUtil.getSesion().setMaxInactiveInterval(Constantes.SESION_MAX);
                    log.info("Tiempo de la sesion: " + WebUtil.getSesion().getMaxInactiveInterval());

                    UsuarioBean usuarioLogueadoBean = new UsuarioBean();
                    usuarioLogueadoBean.setTime(Constantes.SESION_MAX);
                    usuarioLogueadoBean.setIDUSUARIO(usuario.getIdusuario());
                    usuarioLogueadoBean.setPASSWORD(usuario.getPassword());
                    usuarioLogueadoBean.setIDEMPRESA(idempresa);
                    usuarioLogueadoBean.setTIPOSINCRO(CoreUtil.valoresBase().get(4));
                    usuarioLogueadoBean.setNombres(usuario.getUsr_nombres());
                    usuarioLogueadoBean.setIdcodigogeneral(usuario.getIdcodigogeneral());
                    WebUtil.setObjetoSesion(Constantes.SESION_USUARIO, usuarioLogueadoBean);

                    Constantes.IDEMPRESAGENERAL=idempresa;
                    Constantes.IDUSUARIO=usuario.getIdusuario();
                    Constantes.TIPOSINCRO=usuarioLogueadoBean.getTIPOSINCRO();

                    MensajeBean mensaje = new MensajeBean();
                    mensaje.setMensaje("");
                    WebUtil.setObjetoSesion(Constantes.SESION_MENSAJE, mensaje);
                    System.out.println(Constantes.getIDSESION());
                    ExternalContext ctx = FacesContext.getCurrentInstance().getExternalContext();
                    String ctxPath = ((ServletContext) ctx.getContext()).getContextPath();
                    try {
                        System.out.println("CONTEXPACHT---->: " + ctxPath + " " + ctx);
                        this.conexion = "";//para que el menú de seleccion de empresa se reinicie

                        ctx.redirect(ctxPath + "/sistema/principal.xhtml");

                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                    return "";
                } else {
                    this.mensaje = "Usuario no existe o clave incorrecta";
                    WebUtil.MensajeError(this.mensaje);
                }
            }
        } catch (Exception ex) {
            log.error(ex, ex);
            this.mensaje =ex.getMessage();
            WebUtil.MensajeError(this.mensaje);
        }

        return "";
    }

    public UsuarioBean getUsuarioBean() {
        return usuarioBean;
    }

    public void setUsuarioBean(UsuarioBean usuarioBean) {
        this.usuarioBean = usuarioBean;
    }

    public UsuarioService getUsuarioService() {
        return usuarioService;
    }

    public void setUsuarioService(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getConexion() {
        return conexion;
    }

    public void setConexion(String conexion) {
        this.conexion = conexion;
    }

    public String getIdempresa() {
        return idempresa;
    }

    public void setIdempresa(String idempresa) {
        this.idempresa = idempresa;
    }

    public void es_movil() throws IOException {
        ExternalContext ctx = FacesContext.getCurrentInstance().getExternalContext();
        String ctxPath = ((ServletContext) ctx.getContext()).getContextPath();
        if (navegador_es_movil()) {
//            ctx.redirect(ctxPath + "/faces/mindex.xhtml");
            ctx.redirect(ctxPath + "/faces/mindex.xhtml");
        }
        /*ESTO ES IN - NECESARIO -> YA QUE SE ENCUENTRA POR DEFECTO REDIRECCIONADO*/
//        else
//            ctx.redirect(ctxPath + "/faces/index.xhtml");
    }
    public Boolean navegador_es_movil() throws IOException {

        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        String userAgent = request.getHeader("user-agent");
        System.out.println("navegador: " + userAgent);
        if (userAgent.contains("iphone")
                || userAgent.contains("ipad")
                || userAgent.contains("ipod")
                || userAgent.contains("Android")
                || userAgent.contains("j2me")
                || userAgent.contains("Blackberry")
                || userAgent.contains("Opera mini")
                || userAgent.contains("IEMobile")
                || userAgent.contains("Mobile")
                || userAgent.contains("HTC")) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * @return the listEmpresa
     */
    public List<Empresa> getListEmpresa() {
        return listEmpresa;
    }

    /**
     * @param listEmpresa the listEmpresa to set
     */
    public void setListEmpresa(List<Empresa> listEmpresa) {
        this.listEmpresa = listEmpresa;
    }

    public String getH() {
        return h;
    }

    public void setH(String h) {
        this.h = h;
    }

    public String getW() {
        return w;
    }

    public void setW(String w) {
        this.w = w;
    }

    /**
     * @return the hashmap_empresas
     */
    public List<String> getHashmap_empresas() {
        return hashmap_empresas;
    }

    /**
     * @param hashmap_empresas the hashmap_empresas to set
     */
    public void setHashmap_empresas(List<String> hashmap_empresas) {
        this.hashmap_empresas = hashmap_empresas;
    }

    /**
     * @return the hashmap_basedatos
     */
    public List<String> getHashmap_basedatos() {
        return hashmap_basedatos;
    }

    /**
     * @param hashmap_basedatos the hashmap_basedatos to set
     */
    public void setHashmap_basedatos(List<String> hashmap_basedatos) {
        this.hashmap_basedatos = hashmap_basedatos;
    }

    
}
