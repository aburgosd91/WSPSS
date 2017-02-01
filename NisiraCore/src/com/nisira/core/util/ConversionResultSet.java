package com.nisira.core.util;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.apache.commons.dbutils.BeanProcessor;

public class ConversionResultSet {
    private Class clase;

    public ConversionResultSet() {
        
    }

    public ConversionResultSet(Class clase) {
        this.clase = clase;
    }
    
    public Class getClase() {
        return clase;
    }

    public void setClase(Class clase) {
        this.clase = clase;
    }

    public ArrayList resultSetToArrayList(ResultSet rs){
        ArrayList results = new ArrayList();
        try {
            ResultSetMetaData md = rs.getMetaData();
            int columns = md.getColumnCount();
            while (rs.next()){
                HashMap row = new HashMap();
                results.add(row);
                for(int i=1; i<=columns; i++){
                    row.put(md.getColumnName(i).toLowerCase(),rs.getObject(i));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return results;
    }

    public Object resultSetToBean(ResultSet rs){
        BeanProcessor bp = new BeanProcessor();
        try{
            return bp.toBean(rs, clase);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public List resultSetToBeanList(ResultSet rs){
        BeanProcessor bp = new BeanProcessor();
        try {
            return bp.toBeanList(rs, clase);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
