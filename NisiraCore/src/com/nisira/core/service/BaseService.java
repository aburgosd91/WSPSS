/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nisira.core.service;

import com.nisira.core.business.BaseBusiness;

import java.util.List;

/**
 * 
 * @author  Henry Joe Wong Urquiza
 *          hwongu@gmail.com
 * @version 1.0         
 */
public abstract class BaseService<E> {

    private BaseBusiness<E> baseBusiness;

    public E insertar(E e) throws Exception {
        return baseBusiness.insertar(e);
    }

    public E eliminar(E e) throws Exception {
        return baseBusiness.eliminar(e);
    }

    public E actualizar(E e) throws Exception {
        return baseBusiness.actualizar(e);
    }

    public List<E> filtrar(Object filtro) throws Exception {
        return baseBusiness.filtrar(filtro);
    }
    public List<E> filtrar() throws Exception {
        return baseBusiness.filtrar();
    }

    public E obtener(E e) throws Exception {
        return baseBusiness.obtener(e);
    }

    public void setBaseBusiness(BaseBusiness<E> baseBusiness) {
        this.baseBusiness = baseBusiness;
    }
}
