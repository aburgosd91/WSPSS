
package com.nisira.core.business;

import com.nisira.core.dao.BaseDao;
import java.util.List;



/**
 * 
 * @author jcuzco       
 */
public abstract class BaseBusiness<E> {
    
     private BaseDao<E> baseDao;

    public E insertar(E e) throws Exception {
        return baseDao.insert(e);
    }

    public E eliminar(E e) throws Exception {
        return baseDao.delete(e);
    }

    public E actualizar(E e) throws Exception {
        return baseDao.update(e);
    }

    public List<E> filtrar(Object filtro) throws Exception {
        return baseDao.findAll(filtro);
    }
    public List<E> filtrar() throws Exception {
        return baseDao.findAll();
    }

    public E obtener(E e) throws Exception {
        return baseDao.find(e);
    }

    public void setBaseDao(BaseDao<E> baseDao) {
        this.baseDao = baseDao;
    }
}
