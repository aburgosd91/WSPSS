/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.nisira.movil.view.action;

import com.nisira.core.dao.ClienteJuridicoDao;
import com.nisira.core.dao.ClienteNaturalDao;
import com.nisira.core.dao.ContactoDao;
import com.nisira.core.dao.ContactosclieprovDao;
import com.nisira.core.dao.DocIdentidadDao;
import com.nisira.core.dao.Regcliente_cuenta_depositoDao;
import com.nisira.core.dao.RepresentanteDao;
import com.nisira.core.entity.ClienteJuridico;
import com.nisira.core.entity.ClienteNatural;
import com.nisira.core.entity.Contacto;
import com.nisira.core.entity.Contactosclieprov;
import com.nisira.core.entity.Regcliente_cuenta_deposito;
import com.nisira.core.entity.Representante;
import com.nisira.core.util.CoreUtil;
import static com.pe.nisira.movil.view.bean.ConsultaWeb.ConsultaRUC_FOX;
import com.pe.nisira.movil.view.bean.UsuarioBean;
import com.pe.nisira.movil.view.util.Constantes;
import com.pe.nisira.movil.view.util.WebUtil;
import com.sun.xml.registry.uddi.bindings_v2_2.Contact;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.primefaces.context.RequestContext;

/**
 *
 * @author alejndro zamora
 */
@ManagedBean(name = "RegistroAction")
@SessionScoped
public class RegistroAction {
    private int tiporegistro;
    private ClienteNatural clienteNatural;
    private ClienteJuridico clienteJuridico;
    private List<Representante> lstRepLegales;
    private List<Contacto> conRecojo;
    private List<Contacto> conEntrega;
    private List<Regcliente_cuenta_deposito> lstRegcliente_cuenta_deposito;
    private List<Contactosclieprov> lstContactosclieprov;
    private Contacto objRecojo;
    private Contacto objEntrega;
    private Contacto selectRecojo;
    private Contacto selectEntrega;
    private Contactosclieprov objContactosclieprov;
    private Contactosclieprov selectContactosclieprov;
    private Regcliente_cuenta_deposito objRegcliente_cuenta_deposito;
    private String idcodigo;
    private int fobjRecojo;
    private int fobjEntrega;
    private int fobjContactosclieprov;
    private String iddepartamento;
    private String idprovincia;
    private String iddistrito;
    private boolean faprobar;
    private List<Object[]> lstDept;
    private List<Object[]> lstProv;
    private List<Object[]> lstDist;
    private ContactosclieprovDao contactosclieprovDao;
    
    private List<Object[]> lstDept_global;
    private List<Object[]> lstProv_global;
    private List<Object[]> lstDist_global;
    /***************** ************************/
    private String iddepartamento_recojodinero;
    private String idprovincia_recojodinero;
    private String iddistrito_recojodinero;
    /***************** ************************/
    private String iddepartamento_entregadinero;
    private String idprovincia_entregadinero;
    private String iddistrito_entregadinero;
    private UsuarioBean user;
    private Boolean baprobar;
    public RegistroAction() {
        tiporegistro = 1;
        selectContactosclieprov = new Contactosclieprov();
        contactosclieprovDao = new ContactosclieprovDao();
        clienteNatural = new ClienteNatural();
        clienteJuridico = new ClienteJuridico();
        lstContactosclieprov = new ArrayList<>();
        lstRepLegales = new ArrayList<Representante>();
        conRecojo = new ArrayList<Contacto>();
        conEntrega = new ArrayList<Contacto>();
        lstRegcliente_cuenta_deposito = new ArrayList<Regcliente_cuenta_deposito>();
        idcodigo = new String("");
        lstDept = new ArrayList<Object[]>();
        lstProv = new ArrayList<Object[]>();
        lstDist = new ArrayList<Object[]>();
        objRecojo = new Contacto();
        objEntrega = new Contacto();
        objContactosclieprov = new Contactosclieprov();
        objRegcliente_cuenta_deposito = new Regcliente_cuenta_deposito();
        faprobar = false;
        baprobar = true;
        user = (UsuarioBean) WebUtil.getObjetoSesion(Constantes.SESION_USUARIO);
    }
    public void getInicio() {
        try {
            //        tiporegistro = 1;
            idcodigo = new String("");
            clienteNatural = new ClienteNatural();
            clienteJuridico = new ClienteJuridico();
            lstRepLegales = new ArrayList<Representante>();
            conRecojo = new ArrayList<Contacto>();
            conEntrega = new ArrayList<Contacto>();
            lstRegcliente_cuenta_deposito = new ArrayList<>();
            lstContactosclieprov = new ArrayList<>();
            idcodigo = new String();
            lstDept = new ArrayList<Object[]>();
            lstProv = new ArrayList<Object[]>();
            lstDist = new ArrayList<Object[]>();
            lstDept = (new DocIdentidadDao()).lstDepartamentos();
            lstDept_global = (new DocIdentidadDao()).lstDepartamentos();
            if(!lstDept.isEmpty()){
                lstProv = (new DocIdentidadDao()).lstProvincia(lstDept.get(0)[0]);
                clienteNatural.setDEPARTAMENTO(lstDept.get(0)[0].toString());
                clienteJuridico.setDEPARTAMENTO(lstDept.get(0)[0].toString());
                if(!lstProv.isEmpty()){
                    lstDist = (new DocIdentidadDao()).lstCiudad(lstDept.get(0)[0],
                                lstProv.get(0)[0]);
                }
            }
            faprobar = false;
            if(tiporegistro==1){
                baprobar = true;
            }    
            else{
                baprobar = false;
            }
        } catch (Exception ex) {
            WebUtil.error(ex.getMessage());
            RequestContext.getCurrentInstance().update("form:growl");
            Logger.getLogger(RegistroAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void verificarNatural(){
        try {
            List<ClienteNatural>lst = (new ClienteNaturalDao()).findAll(clienteNatural.getIDDOCIDENTIDAD());
            if(!lst.isEmpty()){
                clienteNatural = lst.get(0);
                lstProv = (new DocIdentidadDao()).lstProvincia(clienteNatural.getDEPARTAMENTO());
                lstDist = (new DocIdentidadDao()).lstCiudad(clienteNatural.getDEPARTAMENTO(),clienteNatural.getPROVINCIA());
                RequestContext.getCurrentInstance().update("form");   
            }
        }catch(Exception ex){
            WebUtil.error(ex.getMessage());
            RequestContext.getCurrentInstance().update("form:growl");
            Logger.getLogger(RegistroAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void verificarJuridico(){
        try {
            List<ClienteJuridico>lst = (new ClienteJuridicoDao()).findAll(clienteJuridico.getIDDOCIDENTIDAD());
            if(!lst.isEmpty()){
                clienteJuridico = lst.get(0);
                lstProv = (new DocIdentidadDao()).lstProvincia(clienteJuridico.getDEPARTAMENTO());
                lstDist = (new DocIdentidadDao()).lstCiudad(clienteJuridico.getDEPARTAMENTO(),clienteJuridico.getPROVINCIA());
                List<Representante> lstRepresentante = (new RepresentanteDao()).findAll(clienteJuridico.getIDDOCIDENTIDAD());
                List<Contacto> lstContactos = (new ContactoDao()).findAll(clienteJuridico.getIDDOCIDENTIDAD());
                List<Regcliente_cuenta_deposito> lstRegcliente_cuenta_deposito_local = (new Regcliente_cuenta_depositoDao()).findAll(clienteJuridico.getIDDOCIDENTIDAD());
                List<Contactosclieprov> lstContactoscliente = contactosclieprovDao.listarPorEmpresaClienteContactoWeb(user.getIDEMPRESA(),clienteJuridico.getIDDOCIDENTIDAD());
                if(!lstRepresentante.isEmpty()){
                    lstRepLegales = new ArrayList<>();
                    lstRepLegales.addAll(lstRepresentante);
                }
                if(!lstContactos.isEmpty()){
                    List<Contacto> lstRecojo = (List<Contacto>)lstContactos.stream().filter(recojo -> 1 == recojo.getIDTIPO()).collect(Collectors.toList()); ;
                    List<Contacto> lstEntrega = (List<Contacto>)lstContactos.stream().filter(recojo -> 2 == recojo.getIDTIPO()).collect(Collectors.toList()); ;
                    if(!lstRecojo.isEmpty()){
                        conRecojo = new ArrayList<>();
                        conRecojo.addAll(lstRecojo);
                    }
                    if(!lstEntrega.isEmpty()){
                        conEntrega = new ArrayList<>();
                        conEntrega.addAll(lstEntrega);
                    }
                }
                if(!lstRegcliente_cuenta_deposito_local.isEmpty()){
                    lstRegcliente_cuenta_deposito = new ArrayList<>();
                    lstRegcliente_cuenta_deposito.addAll(lstRegcliente_cuenta_deposito_local);
                }
                if(!lstContactoscliente.isEmpty()){
                    lstContactosclieprov = new ArrayList<>();
                    lstContactosclieprov.addAll(lstContactoscliente);
                }   
                RequestContext.getCurrentInstance().update("form");    
            }
        }catch(Exception ex){
            WebUtil.error(ex.getMessage());
            RequestContext.getCurrentInstance().update("form:growl");
            Logger.getLogger(RegistroAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void newRepLegal() throws Exception {
        if (clienteJuridico.getIDDOCIDENTIDAD().trim().isEmpty() && clienteJuridico.getIDDOCIDENTIDAD().length() != 3) {
            WebUtil.MensajeError("El Cód. del Documento es Obligatorio para poder crear Representantes");
        } else {
            Representante neb = new Representante();
            neb.setIDREP(lstRepLegales.size() + 1);
            neb.setIDREGISTRO(clienteJuridico.getIDDOCIDENTIDAD().trim());
            lstRepLegales.add(neb);
        }

    }

    public void delRepLegal() {
        lstRepLegales.remove(lstRepLegales.size() - 1);
    }
    
    public void grabarConRecoje(){
        if(WebUtil.isnull(objRecojo.getIDREGISTRO(),"").equals("") ){
            WebUtil.MensajeError("Ingresar Ruc *");
            RequestContext.getCurrentInstance().update("form:growl");
        }else{
            if(fobjRecojo == 1){
                conRecojo.add(objRecojo);
            }else if(fobjRecojo == 2){
                int pos = conRecojo.indexOf(selectRecojo);
                conRecojo.set(pos, objRecojo);
            }
            RequestContext.getCurrentInstance().update("form:tblConRecoje");
            RequestContext.getCurrentInstance().execute("PF('dialog_recojodinero').hide()");
        }
    }
    public void grabarConEntrega(){
        if(WebUtil.isnull(objEntrega.getIDREGISTRO(),"").equals("") ){
            WebUtil.MensajeError("Ingresar Ruc *");
            RequestContext.getCurrentInstance().update("form:growl");
        }else{
            if(fobjEntrega == 1){
                conEntrega.add(objEntrega);
            }else if(fobjEntrega == 2){
                int pos = conEntrega.indexOf(selectEntrega);
                conEntrega.set(pos, objEntrega);
            }
            RequestContext.getCurrentInstance().update("form:tblConEntrega");
            RequestContext.getCurrentInstance().execute("PF('dialog_entregadinero').hide()");
        }
    }
    public void newConRecoje() throws Exception {
        if (clienteJuridico.getIDDOCIDENTIDAD().trim().isEmpty() && clienteJuridico.getIDDOCIDENTIDAD().length() != 3) {
            WebUtil.MensajeError("El Cód. del Documento es Obligatorio para poder crear Contacto de Recojo");
            RequestContext.getCurrentInstance().update("datos:growl");
        } else {
            objRecojo = new Contacto();
            objRecojo.setIDCONT(conRecojo.size() + 1);
            objRecojo.setIDTIPO(1);
            objRecojo.setIDREGISTRO(clienteJuridico.getIDDOCIDENTIDAD().trim());
            fobjRecojo=1;
            RequestContext.getCurrentInstance().update("form:dialog_recojodinero");
            RequestContext.getCurrentInstance().execute("PF('dialog_recojodinero').show()");
        }
    }
    public void editConRecoje(){
        try {
            if(selectRecojo != null){
                objRecojo = new Contacto();
                objRecojo.setAPELLIDOMATERNO(selectRecojo.getAPELLIDOMATERNO());
                objRecojo.setAPELLIDOPATERNO(selectRecojo.getAPELLIDOPATERNO());
                objRecojo.setCORREO(selectRecojo.getCORREO());
                objRecojo.setDCODIGOPOSTAL(selectRecojo.getDCODIGOPOSTAL());
                objRecojo.setDEPARTAMENTO(selectRecojo.getDEPARTAMENTO());
                objRecojo.setDIRECCION(selectRecojo.getDIRECCION());
                objRecojo.setDIRTELFCEL(selectRecojo.getDIRTELFCEL());
                objRecojo.setDIRTELFFIJO(selectRecojo.getDIRTELFFIJO());
                objRecojo.setDISTRITO(selectRecojo.getDISTRITO());
                objRecojo.setDepartamento_descripcion(selectRecojo.getDepartamento_descripcion());
                objRecojo.setDistrito_descripcio(selectRecojo.getDistrito_descripcio());
                objRecojo.setIDCONT(selectRecojo.getIDCONT());
                objRecojo.setIDREGISTRO(selectRecojo.getIDREGISTRO());
                objRecojo.setIDTIPO(selectRecojo.getIDTIPO());
                objRecojo.setNOMBRES(selectRecojo.getNOMBRES());
                objRecojo.setNRODOCUMENTO(selectRecojo.getNRODOCUMENTO());
                objRecojo.setPROVINCIA(selectRecojo.getPROVINCIA());
                objRecojo.setProvincia_descripcion(selectRecojo.getProvincia_descripcion());
                objRecojo.setTELFCEL(selectRecojo.getTELFCEL());
                fobjRecojo=2;
                lstProv_global = (new DocIdentidadDao()).lstProvincia(objRecojo.getDEPARTAMENTO());
                lstDist_global = (new DocIdentidadDao()).lstCiudad(objRecojo.getDEPARTAMENTO(),objRecojo.getPROVINCIA());
                RequestContext.getCurrentInstance().update("form:dialog_recojodinero");
                RequestContext.getCurrentInstance().execute("PF('dialog_recojodinero').show()");
            }
        }
        catch(Exception ex){
            WebUtil.error(ex.getMessage());
            RequestContext.getCurrentInstance().update("form:growl");
            Logger.getLogger(RegistroAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void delConRecoje() {
        if(selectRecojo != null){
            int pos = conRecojo.indexOf(selectRecojo);
            conRecojo.remove(pos);
            reordenarConRecoje();
        }
    }
    public void reordenarConRecoje(){
        for(int i=0;i<conRecojo.size();i++){
            conRecojo.get(i).setIDCONT(i);
        }
    }
    public void reordenarContactoscliente(){
        for(int i=0;i<lstContactosclieprov.size();i++){
            lstContactosclieprov.get(i).setItem(WebUtil.idGeneradoTres(i));
        }
    }
    public void reordenarConEntrega(){
        for(int i=0;i<conEntrega.size();i++){
            conEntrega.get(i).setIDCONT(i);
        }
    }
    public void newConEntrega() throws Exception {
        if (clienteJuridico.getIDDOCIDENTIDAD().trim().isEmpty() && clienteJuridico.getIDDOCIDENTIDAD().length() != 3) {
            WebUtil.MensajeError("El Cód. del Documento es Obligatorio para poder crear Contacto de Entrega");
        } else {
            objEntrega = new Contacto();
            objEntrega.setIDCONT(conEntrega.size() + 1);
            objEntrega.setIDTIPO(2);
            objEntrega.setIDREGISTRO(clienteJuridico.getIDDOCIDENTIDAD().trim());
            fobjEntrega = 1;
            RequestContext.getCurrentInstance().update("form:dialog_entregadinero");
            RequestContext.getCurrentInstance().execute("PF('dialog_entregadinero').show()");
        }

    }
    public void editConEntrega(){
        try {
            if(selectEntrega != null){
                objEntrega = new Contacto();
                objEntrega.setAPELLIDOMATERNO(selectEntrega.getAPELLIDOMATERNO());
                objEntrega.setAPELLIDOPATERNO(selectEntrega.getAPELLIDOPATERNO());
                objEntrega.setCORREO(selectEntrega.getCORREO());
                objEntrega.setDCODIGOPOSTAL(selectEntrega.getDCODIGOPOSTAL());
                objEntrega.setDEPARTAMENTO(selectEntrega.getDEPARTAMENTO());
                objEntrega.setDIRECCION(selectEntrega.getDIRECCION());
                objEntrega.setDIRTELFCEL(selectEntrega.getDIRTELFCEL());
                objEntrega.setDIRTELFFIJO(selectEntrega.getDIRTELFFIJO());
                objEntrega.setDISTRITO(selectEntrega.getDISTRITO());
                objEntrega.setDepartamento_descripcion(selectEntrega.getDepartamento_descripcion());
                objEntrega.setDistrito_descripcio(selectEntrega.getDistrito_descripcio());
                objEntrega.setIDCONT(selectEntrega.getIDCONT());
                objEntrega.setIDREGISTRO(selectEntrega.getIDREGISTRO());
                objEntrega.setIDTIPO(selectEntrega.getIDTIPO());
                objEntrega.setNOMBRES(selectEntrega.getNOMBRES());
                objEntrega.setNRODOCUMENTO(selectEntrega.getNRODOCUMENTO());
                objEntrega.setPROVINCIA(selectEntrega.getPROVINCIA());
                objEntrega.setProvincia_descripcion(selectEntrega.getProvincia_descripcion());
                objEntrega.setTELFCEL(selectEntrega.getTELFCEL());
                fobjEntrega = 2;
                lstProv_global = (new DocIdentidadDao()).lstProvincia(objEntrega.getDEPARTAMENTO());
                lstDist_global = (new DocIdentidadDao()).lstCiudad(objEntrega.getDEPARTAMENTO(),objEntrega.getPROVINCIA());
                RequestContext.getCurrentInstance().update("form:dialog_entregadinero");
                RequestContext.getCurrentInstance().execute("PF('dialog_entregadinero').show()");
            }
        }
        catch(Exception ex){
            WebUtil.error(ex.getMessage());
            RequestContext.getCurrentInstance().update("form:growl");
            Logger.getLogger(RegistroAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void delConEntrega() {
        if(selectEntrega != null){
            int pos = conEntrega.indexOf(selectEntrega);
            conEntrega.remove(pos);
            reordenarConEntrega();
        }
    }
    public void grabar() throws Exception{
        try{
            if(tiporegistro == 1){
                if(CoreUtil.isNull(clienteNatural.getIDDOCIDENTIDAD(), "").trim().equals("")){
                    WebUtil.error("Ingresar Documento de Identidad");
                    RequestContext.getCurrentInstance().update("form:growl");
                }else if(CoreUtil.isNull(clienteNatural.getAPELLIDOPATERNO(),"").trim().equals("")){
                    WebUtil.error("Ingresar Apellido Paterno");
                    RequestContext.getCurrentInstance().update("form:growl");
                }else if(CoreUtil.isNull(clienteNatural.getAPELLIDOMATERNO(),"").trim().equals("")){
                    WebUtil.error("Ingresar Apellido Materno");
                    RequestContext.getCurrentInstance().update("form:growl");
                }else if(CoreUtil.isNull(clienteNatural.getNOMBRES(),"").trim().equals("")){
                    WebUtil.error("Ingresar Nombres");
                    RequestContext.getCurrentInstance().update("form:growl");
                }else if(CoreUtil.isNull(clienteNatural.getDIRECCION(),"").trim().equals("")){
                    WebUtil.error("Ingresar Dirección");
                    RequestContext.getCurrentInstance().update("form:growl");
                }else if(CoreUtil.isNull(clienteNatural.getEMAIL(),"").trim().equals("")){
                    WebUtil.error("Ingresar Email");
                    RequestContext.getCurrentInstance().update("form:growl");
                }else{
                    (new ClienteNaturalDao()).grabar(clienteNatural);
                    WebUtil.MensajeAlerta(WebUtil.exitoRegistrar("Cliente :", 
                            clienteNatural.getIDDOCIDENTIDAD()+" "+ clienteNatural.getAPELLIDOPATERNO() +" "+
                                    clienteNatural.getAPELLIDOMATERNO()+" "+clienteNatural.getNOMBRES()
                    ));
                    RequestContext.getCurrentInstance().update("form:growl");
                }
            }else if(tiporegistro == 2){
//                if(lstRepLegales.isEmpty()){
//                    WebUtil.error("Ingresar Representante Legal");
//                    RequestContext.getCurrentInstance().update("form:growl");
//                }else if(conRecojo.isEmpty()){
//                    WebUtil.error("Ingresar Contacto y ubicación de recojo de dinero");
//                    RequestContext.getCurrentInstance().update("form:growl");
//                }else if(conEntrega.isEmpty()){
//                    WebUtil.error("Ingresar Contacto y ubicación de entrega de dinero");
//                    RequestContext.getCurrentInstance().update("form:growl");
//                }else if(lstRegcliente_cuenta_deposito.isEmpty()){
//                    WebUtil.error("Ingresar Banco y cuenta de depósito");
//                    RequestContext.getCurrentInstance().update("form:growl");
//                }else{

                    (new ClienteJuridicoDao()).grabar(clienteJuridico,lstRepLegales,
                            conRecojo,conEntrega,lstRegcliente_cuenta_deposito,(faprobar?1:0),user.getIDEMPRESA(),lstContactosclieprov);
                    WebUtil.MensajeAlerta(WebUtil.exitoRegistrar("Cliente :", 
                            clienteJuridico.getIDDOCIDENTIDAD()+" "+ clienteJuridico.getRAZON_SOCIAL()));
                    RequestContext.getCurrentInstance().update("form:growl");
//                }
            }
        }catch(Exception ex){
            WebUtil.error(ex.getMessage());
            RequestContext.getCurrentInstance().update("form:growl");
        }
    }
    public void newBanco_cuenta() throws Exception {
        objRegcliente_cuenta_deposito = new Regcliente_cuenta_deposito();
        objRegcliente_cuenta_deposito.setIDREGISTRO(clienteJuridico.getIDDOCIDENTIDAD().trim());
        objRegcliente_cuenta_deposito.setITEM(lstRegcliente_cuenta_deposito.size()+1);
        lstRegcliente_cuenta_deposito.add(objRegcliente_cuenta_deposito);
        RequestContext.getCurrentInstance().update("form:tblConRecoje");
    }
    public void delBanco_cuenta() {
        if(!lstRegcliente_cuenta_deposito.isEmpty())
            lstRegcliente_cuenta_deposito.remove(lstRegcliente_cuenta_deposito.size() - 1);
        RequestContext.getCurrentInstance().update("form:tblConRecoje");
    }
    public void grabarBanco_cuenta(){
        if(WebUtil.isnull(objRecojo.getIDREGISTRO(),"").equals("") ){
            WebUtil.MensajeError("Ingresar Documento *");
            RequestContext.getCurrentInstance().update("form:growl");
        }else{
            conRecojo.add(objRecojo);
            RequestContext.getCurrentInstance().update("form:tblConRecoje");
            RequestContext.getCurrentInstance().execute("PF('dialog_recojodinero').hide()");
        }
    }
    public void buscarTodo() {
        try {
            getInicio();
        } catch (Exception ex) {
            WebUtil.error(ex.getMessage());
            RequestContext.getCurrentInstance().update("form:growl");
            Logger.getLogger(RegistroAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /*Clientes - contactos*/
    public void newContactosclientes() throws Exception {
        if (clienteJuridico.getIDDOCIDENTIDAD().trim().isEmpty() && clienteJuridico.getIDDOCIDENTIDAD().length() != 3) {
            WebUtil.MensajeError("El Cód. del Documento es Obligatorio para poder crear Contactos de cliente");
            RequestContext.getCurrentInstance().update("datos:growl");
        } else {
            setObjContactosclieprov(new Contactosclieprov());
            getObjContactosclieprov().setIdempresa(user.getIDEMPRESA());
            getObjContactosclieprov().setIdclieprov(clienteJuridico.getIDDOCIDENTIDAD());
            getObjContactosclieprov().setItem(WebUtil.idGeneradoTres(lstContactosclieprov.size()+1));
            getObjContactosclieprov().setNombre("");
            getObjContactosclieprov().setDireccion("");
            getObjContactosclieprov().setTelefono1("");
            getObjContactosclieprov().setTelefono2("");
            getObjContactosclieprov().setTelefono3("");
            getObjContactosclieprov().setEmail("");
            getObjContactosclieprov().setCargo("");
            fobjContactosclieprov = 1;
            RequestContext.getCurrentInstance().update("form:dialog_contactoscliente");
            RequestContext.getCurrentInstance().execute("PF('dialog_contactoscliente').show()");
        }
    }
    public void editContactosclientes(){
        try {
            if(selectContactosclieprov != null){
                setObjContactosclieprov(new Contactosclieprov());
                getObjContactosclieprov().setIdempresa(selectContactosclieprov.getIdempresa());
                getObjContactosclieprov().setIdclieprov(selectContactosclieprov.getIdclieprov());
                getObjContactosclieprov().setItem(selectContactosclieprov.getItem());
                getObjContactosclieprov().setNombre(selectContactosclieprov.getNombre());
                getObjContactosclieprov().setDireccion(selectContactosclieprov.getDireccion());
                getObjContactosclieprov().setTelefono1(selectContactosclieprov.getTelefono1());
                getObjContactosclieprov().setTelefono2(selectContactosclieprov.getTelefono2());
                getObjContactosclieprov().setTelefono3(selectContactosclieprov.getTelefono3());
                getObjContactosclieprov().setEmail(selectContactosclieprov.getEmail());
                getObjContactosclieprov().setCargo(selectContactosclieprov.getCargo());
                fobjContactosclieprov = 2;
                RequestContext.getCurrentInstance().update("form:dialog_contactoscliente");
                RequestContext.getCurrentInstance().execute("PF('dialog_contactoscliente').show()");
            }
        }
        catch(Exception ex){
            WebUtil.error(ex.getMessage());
            RequestContext.getCurrentInstance().update("form:growl");
            Logger.getLogger(RegistroAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void delContactosclientes() {
        if(selectContactosclieprov != null){
            int pos = lstContactosclieprov.indexOf(selectContactosclieprov);
            lstContactosclieprov.remove(pos);
            reordenarContactoscliente();
        }
    }
    public void grabarContactosclientes(){
        if(WebUtil.isnull(objContactosclieprov.getIdclieprov(),"").equals("") ){
            WebUtil.MensajeError("Ingresar Ruc *");
            RequestContext.getCurrentInstance().update("form:growl");
        }else{
            if(fobjContactosclieprov == 1){
                lstContactosclieprov.add(objContactosclieprov);
            }else if(fobjContactosclieprov == 2){
                int pos = lstContactosclieprov.indexOf(selectContactosclieprov);
                lstContactosclieprov.set(pos, objContactosclieprov);
            }
            RequestContext.getCurrentInstance().update("form:tblContactoscliente");
            RequestContext.getCurrentInstance().execute("PF('dialog_contactoscliente').hide()");
        }
    }
    public void onDeptSelect() throws Exception{
        if(tiporegistro==1){
            lstProv = (new DocIdentidadDao()).lstProvincia(clienteNatural.getDEPARTAMENTO());
        }else if(tiporegistro==2){
            lstProv = (new DocIdentidadDao()).lstProvincia(clienteJuridico.getDEPARTAMENTO());
        }
    }
    public void onProvSelect() throws Exception{
        if(tiporegistro==1){
            lstDist = (new DocIdentidadDao()).lstCiudad(clienteNatural.getDEPARTAMENTO(),clienteNatural.getPROVINCIA());
        }else if(tiporegistro==2){
            lstDist = (new DocIdentidadDao()).lstCiudad(clienteJuridico.getDEPARTAMENTO(),clienteJuridico.getPROVINCIA());
        }
    }
    
    public void onDeptSelect_ConRecoje() throws Exception{
        lstProv_global = (new DocIdentidadDao()).lstProvincia(objRecojo.getDEPARTAMENTO());
        objRecojo.setDepartamento_descripcion(descripcion_ubigeo(lstDept_global,objRecojo.getDEPARTAMENTO()));
    }
    public void onProvSelect_ConRecoje() throws Exception{
        lstDist_global = (new DocIdentidadDao()).lstCiudad(objRecojo.getDEPARTAMENTO(),objRecojo.getPROVINCIA());
        objRecojo.setProvincia_descripcion(descripcion_ubigeo(lstProv_global,objRecojo.getPROVINCIA()));
    }
    public void onDistrSelect_ConRecoje() throws Exception{
        objRecojo.setDistrito_descripcio(descripcion_ubigeo(lstDist_global,objRecojo.getDEPARTAMENTO()));
    }
    
    public void onDeptSelect_ConEntrega() throws Exception{
        lstProv_global = (new DocIdentidadDao()).lstProvincia(objEntrega.getDEPARTAMENTO());
        objEntrega.setDepartamento_descripcion(descripcion_ubigeo(lstDept_global,objEntrega.getDEPARTAMENTO()));
    }
    public void onProvSelect_ConEntrega() throws Exception{
        lstDist_global = (new DocIdentidadDao()).lstCiudad(objEntrega.getDEPARTAMENTO(),objEntrega.getPROVINCIA());
        objEntrega.setProvincia_descripcion(descripcion_ubigeo(lstProv_global,objEntrega.getPROVINCIA()));
    }
    public void onDistrSelect_ConEntrega() throws Exception{
        objEntrega.setDistrito_descripcio(descripcion_ubigeo(lstDist_global,objEntrega.getDEPARTAMENTO()));
    }
    
    public String descripcion_ubigeo(List<Object[]> lst , String id){
        String msj="";
        for(Object[] ob : lst){
            if(ob[0].toString().trim().equals(id)){
                msj = ob[1].toString();
                break;
            }
        }
        return msj;
    }
    public void consultar_ruc() {
        try {
            if(this.idcodigo!=null){
                if(this.idcodigo.trim().length()==11){
                    List<ClienteJuridico>lst = (new ClienteJuridicoDao()).findAll(this.idcodigo.trim());
                    if(!lst.isEmpty()){
                        tiporegistro = 2;
                        baprobar = false;
                        clienteJuridico = lst.get(0);
                        lstProv = (new DocIdentidadDao()).lstProvincia(clienteJuridico.getDEPARTAMENTO());
                        lstDist = (new DocIdentidadDao()).lstCiudad(clienteJuridico.getDEPARTAMENTO(),clienteJuridico.getPROVINCIA());
                        List<Representante> lstRepresentante = (new RepresentanteDao()).findAll(clienteJuridico.getIDDOCIDENTIDAD());
                        List<Contacto> lstContactos = (new ContactoDao()).findAll(clienteJuridico.getIDDOCIDENTIDAD());
                        List<Regcliente_cuenta_deposito> lstRegcliente_cuenta_deposito_local = (new Regcliente_cuenta_depositoDao()).findAll(clienteJuridico.getIDDOCIDENTIDAD());
                        List<Contactosclieprov> lstContactoscliente = contactosclieprovDao.listarPorEmpresaClienteContactoWeb(user.getIDEMPRESA(),clienteJuridico.getIDDOCIDENTIDAD());
                        if(!lstRepresentante.isEmpty()){
                            lstRepLegales = new ArrayList<>();
                            lstRepLegales.addAll(lstRepresentante);
                        }
                        if(!lstContactos.isEmpty()){
                            List<Contacto> lstRecojo = (List<Contacto>)lstContactos.stream().filter(recojo -> 1 == recojo.getIDTIPO()).collect(Collectors.toList()); ;
                            List<Contacto> lstEntrega = (List<Contacto>)lstContactos.stream().filter(recojo -> 2 == recojo.getIDTIPO()).collect(Collectors.toList()); ;
                            if(!lstRecojo.isEmpty()){
                                conRecojo = new ArrayList<>();
                                conRecojo.addAll(lstRecojo);
                            }
                            if(!lstEntrega.isEmpty()){
                                conEntrega = new ArrayList<>();
                                conEntrega.addAll(lstEntrega);
                            }
                        }
                        if(!lstRegcliente_cuenta_deposito_local.isEmpty()){
                            lstRegcliente_cuenta_deposito = new ArrayList<>();
                            lstRegcliente_cuenta_deposito.addAll(lstRegcliente_cuenta_deposito_local);
                        }
                        if(!lstContactoscliente.isEmpty()){
                            lstContactosclieprov = new ArrayList<>();
                            lstContactosclieprov.addAll(lstContactoscliente);
                        }
                        RequestContext.getCurrentInstance().update("form");  
                    }else{
                        String[] datos;
                        datos = ConsultaRUC_FOX(this.idcodigo);
                        /*
                            - RUC [0]
                            - RAZON SOCIAL [1]
                            - DIRECCION [2]
                            - DEPARTAMENTO [3]
                            - PROVINCIA [4]
                            - DISTRITO [5]
                            - TIPOPERSONA[6] -> FIJO 2
                            - TIPO DOCUMENTO [7] -> FIJO 2
                            - NOMBRE COMERCIAL [8]
                            - ESTADO DE CONTRIBUYENTE [9]
                            - CONDICIÓN_SUNAT [10]
                            - DNI [11]
                            - CIIU [12]
                            - APELLIDOPATERNO[13]
                            - APELLIDOMATERNO[14]
                            - NOMBRES[15]
                        */
                        if (!(datos[0]==null?"":datos[0]).isEmpty()) {
                            tiporegistro = 2;
                            baprobar = false;
                            clienteJuridico = new ClienteJuridico();
                            clienteJuridico.setIDDOCIDENTIDAD(datos[0]);
                            clienteJuridico.setRAZON_SOCIAL(datos[1]);
                            clienteJuridico.setDIRECCION(datos[2]);
                            clienteJuridico.setDEPARTAMENTO((new DocIdentidadDao()).lstDepartamentos(datos[3])[0].toString());
                            lstProv = (new DocIdentidadDao()).lstProvincia(clienteJuridico.getDEPARTAMENTO());
                            clienteJuridico.setPROVINCIA(getProvinciaFiltro(datos[4]));
                            lstDist = (new DocIdentidadDao()).lstCiudad(clienteJuridico.getDEPARTAMENTO(),
                                    clienteJuridico.getPROVINCIA());
                            clienteJuridico.setDISTRITO(getDistritoFiltro(datos[5]));
                            /************ CONTENIDO SUNAT ************/
                            clienteJuridico.setTIPOPERSONA(Integer.parseInt(datos[6]));
                            clienteJuridico.setDDEPARTAMENTO((new DocIdentidadDao()).lstDepartamentos(datos[3])[1].toString());
                            clienteJuridico.setDPROVINCIA(datos[4]);
                            clienteJuridico.setDDISTRITO(datos[5]);
                            clienteJuridico.setIDDOCIDENTIDAD_SUNAT(datos[7]);
                            clienteJuridico.setDNI(datos[11]);
                            clienteJuridico.setNOMBRE_COMERCIAL(datos[8]);
                            clienteJuridico.setCIIU(datos[12]);
                            clienteJuridico.setESTADO_SUNAT(datos[9]);
                            clienteJuridico.setCONDICION_SUNAT(datos[10]);
                            
                            clienteJuridico.setAPELLIDOPATERNO(datos[13]);
                            clienteJuridico.setAPELLIDOMATERNO(datos[14]);
                            clienteJuridico.setNOMBRES(datos[15]);
                            /************ LIMPIAR **********/
                            lstRepLegales = new ArrayList<>();
                            conRecojo = new ArrayList<>();
                            conEntrega = new ArrayList<>();
                            lstRegcliente_cuenta_deposito = new ArrayList<>();
                            RequestContext.getCurrentInstance().update("form");
                        } else {
                            baprobar = true;
                            WebUtil.error("CONSULTA_SINRPTA");
                            RequestContext.getCurrentInstance().update("form:growl");
                        } 
                    }
                }else{
                    WebUtil.error("Ingresar 11 caracteres");
                    baprobar = true;
                    RequestContext.getCurrentInstance().update("form:growl");
                }
            }else{
                WebUtil.error("Ingresar 11 caracteres");
                baprobar = true;
                RequestContext.getCurrentInstance().update("form:growl");
            }
        } catch (Exception e) {
                WebUtil.error("Servicio Sunat - Inactivo");
                baprobar = true;
                RequestContext.getCurrentInstance().update("form:growl");
        }
    }
    public String getProvinciaFiltro(String descripcion){
        String cod="";
        for(int i=0;i<lstProv.size();i++){
            if(lstProv.get(i)[1].toString().trim().equals(descripcion)){
                cod = lstProv.get(i)[0].toString();break;
            }
        }
        return cod;
    }
    public String getDistritoFiltro(String descripcion){
        String cod="";
        for(int i=0;i<lstDist.size();i++){
            if(lstDist.get(i)[1].toString().trim().equals(descripcion)){
                cod = lstDist.get(i)[0].toString();break;
            }
        }
        return cod;
    }
    public int getTiporegistro() {
        return tiporegistro;
    }
     
    public void setTiporegistro(int tiporegistro) {
        this.tiporegistro = tiporegistro;
    }

    public ClienteNatural getClienteNatural() {
        return clienteNatural;
    }

    public void setClienteNatural(ClienteNatural clienteNatural) {
        this.clienteNatural = clienteNatural;
    }

    public ClienteJuridico getClienteJuridico() {
        return clienteJuridico;
    }

    public void setClienteJuridico(ClienteJuridico clienteJuridico) {
        this.clienteJuridico = clienteJuridico;
    }

    public List<Representante> getLstRepLegales() {
        return lstRepLegales;
    }

    public void setLstRepLegales(List<Representante> lstRepLegales) {
        this.lstRepLegales = lstRepLegales;
    }

    public List<Contacto> getConRecojo() {
        return conRecojo;
    }

    public void setConRecojo(List<Contacto> conRecojo) {
        this.conRecojo = conRecojo;
    }

    public List<Contacto> getConEntrega() {
        return conEntrega;
    }

    public void setConEntrega(List<Contacto> conEntrega) {
        this.conEntrega = conEntrega;
    }

    /**
     * @return the idcodigo
     */
    public String getIdcodigo() {
        return idcodigo;
    }

    /**
     * @param idcodigo the idcodigo to set
     */
    public void setIdcodigo(String idcodigo) {
        this.idcodigo = idcodigo;
    }

    /**
     * @return the lstDept
     */
    public List<Object[]> getLstDept() {
        return lstDept;
    }

    /**
     * @param lstDept the lstDept to set
     */
    public void setLstDept(List<Object[]> lstDept) {
        this.lstDept = lstDept;
    }

    /**
     * @return the lstProv
     */
    public List<Object[]> getLstProv() {
        return lstProv;
    }

    /**
     * @param lstProv the lstProv to set
     */
    public void setLstProv(List<Object[]> lstProv) {
        this.lstProv = lstProv;
    }

    /**
     * @return the lstDist
     */
    public List<Object[]> getLstDist() {
        return lstDist;
    }

    /**
     * @param lstDist the lstDist to set
     */
    public void setLstDist(List<Object[]> lstDist) {
        this.lstDist = lstDist;
    }

    /**
     * @return the lstDept_global
     */
    public List<Object[]> getLstDept_global() {
        return lstDept_global;
    }

    /**
     * @param lstDept_global the lstDept_global to set
     */
    public void setLstDept_global(List<Object[]> lstDept_global) {
        this.lstDept_global = lstDept_global;
    }

    /**
     * @return the lstProv_global
     */
    public List<Object[]> getLstProv_global() {
        return lstProv_global;
    }

    /**
     * @param lstProv_global the lstProv_global to set
     */
    public void setLstProv_global(List<Object[]> lstProv_global) {
        this.lstProv_global = lstProv_global;
    }

    /**
     * @return the lstDist_global
     */
    public List<Object[]> getLstDist_global() {
        return lstDist_global;
    }

    /**
     * @param lstDist_global the lstDist_global to set
     */
    public void setLstDist_global(List<Object[]> lstDist_global) {
        this.lstDist_global = lstDist_global;
    }

    /**
     * @return the iddepartamento
     */
    public String getIddepartamento() {
        return iddepartamento;
    }

    /**
     * @param iddepartamento the iddepartamento to set
     */
    public void setIddepartamento(String iddepartamento) {
        this.iddepartamento = iddepartamento;
    }

    /**
     * @return the idprovincia
     */
    public String getIdprovincia() {
        return idprovincia;
    }

    /**
     * @param idprovincia the idprovincia to set
     */
    public void setIdprovincia(String idprovincia) {
        this.idprovincia = idprovincia;
    }

    /**
     * @return the iddistrito
     */
    public String getIddistrito() {
        return iddistrito;
    }

    /**
     * @param iddistrito the iddistrito to set
     */
    public void setIddistrito(String iddistrito) {
        this.iddistrito = iddistrito;
    }

    /**
     * @return the iddepartamento_recojodinero
     */
    public String getIddepartamento_recojodinero() {
        return iddepartamento_recojodinero;
    }

    /**
     * @param iddepartamento_recojodinero the iddepartamento_recojodinero to set
     */
    public void setIddepartamento_recojodinero(String iddepartamento_recojodinero) {
        this.iddepartamento_recojodinero = iddepartamento_recojodinero;
    }

    /**
     * @return the idprovincia_recojodinero
     */
    public String getIdprovincia_recojodinero() {
        return idprovincia_recojodinero;
    }

    /**
     * @param idprovincia_recojodinero the idprovincia_recojodinero to set
     */
    public void setIdprovincia_recojodinero(String idprovincia_recojodinero) {
        this.idprovincia_recojodinero = idprovincia_recojodinero;
    }

    /**
     * @return the iddistrito_recojodinero
     */
    public String getIddistrito_recojodinero() {
        return iddistrito_recojodinero;
    }

    /**
     * @param iddistrito_recojodinero the iddistrito_recojodinero to set
     */
    public void setIddistrito_recojodinero(String iddistrito_recojodinero) {
        this.iddistrito_recojodinero = iddistrito_recojodinero;
    }

    /**
     * @return the iddepartamento_entregadinero
     */
    public String getIddepartamento_entregadinero() {
        return iddepartamento_entregadinero;
    }

    /**
     * @param iddepartamento_entregadinero the iddepartamento_entregadinero to set
     */
    public void setIddepartamento_entregadinero(String iddepartamento_entregadinero) {
        this.iddepartamento_entregadinero = iddepartamento_entregadinero;
    }

    /**
     * @return the idprovincia_entregadinero
     */
    public String getIdprovincia_entregadinero() {
        return idprovincia_entregadinero;
    }

    /**
     * @param idprovincia_entregadinero the idprovincia_entregadinero to set
     */
    public void setIdprovincia_entregadinero(String idprovincia_entregadinero) {
        this.idprovincia_entregadinero = idprovincia_entregadinero;
    }

    /**
     * @return the iddistrito_entregadinero
     */
    public String getIddistrito_entregadinero() {
        return iddistrito_entregadinero;
    }

    /**
     * @param iddistrito_entregadinero the iddistrito_entregadinero to set
     */
    public void setIddistrito_entregadinero(String iddistrito_entregadinero) {
        this.iddistrito_entregadinero = iddistrito_entregadinero;
    }

    /**
     * @return the objRecojo
     */
    public Contacto getObjRecojo() {
        return objRecojo;
    }

    /**
     * @param objRecojo the objRecojo to set
     */
    public void setObjRecojo(Contacto objRecojo) {
        this.objRecojo = objRecojo;
    }

    /**
     * @return the objEntrega
     */
    public Contacto getObjEntrega() {
        return objEntrega;
    }

    /**
     * @param objEntrega the objEntrega to set
     */
    public void setObjEntrega(Contacto objEntrega) {
        this.objEntrega = objEntrega;
    }

    /**
     * @return the lstRegcliente_cuenta_deposito
     */
    public List<Regcliente_cuenta_deposito> getLstRegcliente_cuenta_deposito() {
        return lstRegcliente_cuenta_deposito;
    }

    /**
     * @param lstRegcliente_cuenta_deposito the lstRegcliente_cuenta_deposito to set
     */
    public void setLstRegcliente_cuenta_deposito(List<Regcliente_cuenta_deposito> lstRegcliente_cuenta_deposito) {
        this.lstRegcliente_cuenta_deposito = lstRegcliente_cuenta_deposito;
    }

    /**
     * @return the objRegcliente_cuenta_deposito
     */
    public Regcliente_cuenta_deposito getObjRegcliente_cuenta_deposito() {
        return objRegcliente_cuenta_deposito;
    }

    /**
     * @param objRegcliente_cuenta_deposito the objRegcliente_cuenta_deposito to set
     */
    public void setObjRegcliente_cuenta_deposito(Regcliente_cuenta_deposito objRegcliente_cuenta_deposito) {
        this.objRegcliente_cuenta_deposito = objRegcliente_cuenta_deposito;
    }

    /**
     * @return the selectRecojo
     */
    public Contacto getSelectRecojo() {
        return selectRecojo;
    }

    /**
     * @param selectRecojo the selectRecojo to set
     */
    public void setSelectRecojo(Contacto selectRecojo) {
        this.selectRecojo = selectRecojo;
    }

    /**
     * @return the selectEntrega
     */
    public Contacto getSelectEntrega() {
        return selectEntrega;
    }

    /**
     * @param selectEntrega the selectEntrega to set
     */
    public void setSelectEntrega(Contacto selectEntrega) {
        this.selectEntrega = selectEntrega;
    }

    /**
     * @return the fobjRecojo
     */
    public int getFobjRecojo() {
        return fobjRecojo;
    }

    /**
     * @param fobjRecojo the fobjRecojo to set
     */
    public void setFobjRecojo(int fobjRecojo) {
        this.fobjRecojo = fobjRecojo;
    }

    /**
     * @return the fobjEntrega
     */
    public int getFobjEntrega() {
        return fobjEntrega;
    }

    /**
     * @param fobjEntrega the fobjEntrega to set
     */
    public void setFobjEntrega(int fobjEntrega) {
        this.fobjEntrega = fobjEntrega;
    }

    /**
     * @return the faprobar
     */
    public boolean isFaprobar() {
        return faprobar;
    }

    /**
     * @param faprobar the faprobar to set
     */
    public void setFaprobar(boolean faprobar) {
        this.faprobar = faprobar;
    }

    /**
     * @return the baprobar
     */
    public Boolean getBaprobar() {
        return baprobar;
    }

    /**
     * @param baprobar the baprobar to set
     */
    public void setBaprobar(Boolean baprobar) {
        this.baprobar = baprobar;
    }

    /**
     * @return the lstContactosclieprov
     */
    public List<Contactosclieprov> getLstContactosclieprov() {
        return lstContactosclieprov;
    }

    /**
     * @param lstContactosclieprov the lstContactosclieprov to set
     */
    public void setLstContactosclieprov(List<Contactosclieprov> lstContactosclieprov) {
        this.lstContactosclieprov = lstContactosclieprov;
    }

    /**
     * @return the contactosclieprovDao
     */
    public ContactosclieprovDao getContactosclieprovDao() {
        return contactosclieprovDao;
    }

    /**
     * @param contactosclieprovDao the contactosclieprovDao to set
     */
    public void setContactosclieprovDao(ContactosclieprovDao contactosclieprovDao) {
        this.contactosclieprovDao = contactosclieprovDao;
    }

    /**
     * @return the selectContactosclieprov
     */
    public Contactosclieprov getSelectContactosclieprov() {
        return selectContactosclieprov;
    }

    /**
     * @param selectContactosclieprov the selectContactosclieprov to set
     */
    public void setSelectContactosclieprov(Contactosclieprov selectContactosclieprov) {
        this.selectContactosclieprov = selectContactosclieprov;
    }

    /**
     * @return the objContactosclieprov
     */
    public Contactosclieprov getObjContactosclieprov() {
        return objContactosclieprov;
    }

    /**
     * @param objContactosclieprov the objContactosclieprov to set
     */
    public void setObjContactosclieprov(Contactosclieprov objContactosclieprov) {
        this.objContactosclieprov = objContactosclieprov;
    }
}
