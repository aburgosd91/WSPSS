
package com.nisira.core.dao;
 


import java.util.List;

/**
 * 
 * @author jcuzco 
 *         
 */
public abstract class BaseDao<E> extends Conexion{

   public abstract E insert(E e) throws Exception;

    public abstract E update(E e) throws Exception;

    public abstract E delete(E e) throws Exception;

    public abstract E find(E e) throws Exception;

    public abstract List<E> findAll(Object e) throws Exception;
    
    public abstract List<E> findAll() throws Exception;
    
}

