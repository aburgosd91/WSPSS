package com.nisira.core.dao;

import com.nisira.core.NisiraORMException;
import com.nisira.core.util.NisiraUtils2;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class NSRResultSet implements Serializable{
	private List<Object[]> data;
	private String[] name;

	private Class<?>[] clases;

	public Class<?> getClassFormColumn(String column) {
		int idxcolumn = getColumnIndex(column);
		if (idxcolumn == -1) {
			return null;
		}
		return getClases()[idxcolumn];
	}

	public int columnCount() {
		return getName().length;
	}

	public String getColumnName(int index) {
		return getName()[index];
	}

	public Class<?> getColumnClass(int index) {
		return getClases()[index];
	}

	public Object[] getRow(int index) {
		return getData().get(index);
	}

	public int size() {
		return getData().size();
	}

	public void setData(List<Object[]> data, String[] name) {
            this.setData(data);
            this.setName(name);

		if (data.size() > 0) {
			setClases(new Class<?>[this.getName().length]);
                        
                        
			for (int i = 0; i < this.getName().length; i++) {
                            
                                if (this.getData().get(0)[i] instanceof String) {
					getClases()[i] = String.class;

				} else if (this.getData().get(0)[i] instanceof BigDecimal) {
					getClases()[i] = BigDecimal.class;

				} else if (this.getData().get(0)[i] instanceof Double) {
					getClases()[i] = Double.class;

				} else if (this.getData().get(0)[i] instanceof Float) {
					getClases()[i] = Float.class;

				} else if (this.getData().get(0)[i] instanceof Integer) {
					getClases()[i] = Integer.class;

				} else if (this.getData().get(0)[i] instanceof Date || this.getData().get(0)[i] instanceof java.sql.Timestamp
						|| this.getData().get(0)[i] instanceof java.sql.Date) {
					getClases()[i] = Date.class;

				} else {
					getClases()[i] = Object.class;
				}
			}
		} else {
			setClases(new Class<?>[this.getName().length]);
			for (int i = 0; i < this.getName().length; i++) {
				getClases()[i] = Object.class;
			}
		}
	}

	public Object getObject(int row, String column) throws NisiraORMException {
		int idxcolumn = getColumnIndex(column);
		if (idxcolumn == -1) {
			throw new NisiraORMException("No se encontró la columna: " + column);
		}
		return getString(row, idxcolumn);
	}

	public String getString(int row, String column) throws NisiraORMException {
		int idxcolumn = getColumnIndex(column);
		if (idxcolumn == -1) {
			throw new NisiraORMException("No se encontró la columna: " + column);
		}
		return getString(row, idxcolumn);
	}

	public BigDecimal getBigDecimal(int row, String column) throws NisiraORMException {
		int idxcolumn = getColumnIndex(column);
		if (idxcolumn == -1) {
			throw new NisiraORMException("No se encontró la columna: " + column);
		}
		return getBigDecimal(row, idxcolumn);
	}

	public Double getDouble(int row, String column) throws NisiraORMException {
		int idxcolumn = getColumnIndex(column);
		if (idxcolumn == -1) {
			throw new NisiraORMException("No se encontró la columna: " + column);
		}
		return getDouble(row, idxcolumn);
	}

	public Float getFloat(int row, String column) throws NisiraORMException {
		int idxcolumn = getColumnIndex(column);
		if (idxcolumn == -1) {
			throw new NisiraORMException("No se encontró la columna: " + column);
		}
		return getFloat(row, idxcolumn);
	}

	public Integer getInteger(int row, String column) throws NisiraORMException {
		int idxcolumn = getColumnIndex(column);
		if (idxcolumn == -1) {
			throw new NisiraORMException("No se encontró la columna: " + column);
		}
		return getInteger(row, idxcolumn);
	}

	public Date getDate(int row, String column) throws NisiraORMException {
		int idxcolumn = getColumnIndex(column);
		if (idxcolumn == -1) {
			throw new NisiraORMException("No se encontró la columna: " + column);
		}
		return getDate(row, idxcolumn);
	}

	public Object getObject(int row, int column) throws NisiraORMException {
		return getData().get(row)[column];
	}

	public String getString(int row, int column) throws NisiraORMException {
		Object value = getData().get(row)[column];

		if (value == null) {
			return null;
		}

		if (value instanceof String) {
			return (String) value;
		}
		return String.valueOf(value);
	}

	public BigDecimal getBigDecimal(int row, int column) throws NisiraORMException {
		Object value = getData().get(row)[column];

		if (value == null) {
			return null;
		}

		if (value instanceof BigDecimal) {
			return (BigDecimal) value;
		}

		if (value instanceof Double || value instanceof Integer || value instanceof Float || value instanceof String) {
			try {
				return NisiraUtils2.getBigDecimalValue(value);
			} catch (Exception e) {
				throw new NisiraORMException(value + " No se puede castear a BigDecimal");
			}
		}
		throw new NisiraORMException(value.getClass() + " No se puede castear a BigDecimal");
	}

	public Double getDouble(int row, int column) throws NisiraORMException {
		Object value = getData().get(row)[column];

		if (value == null) {
			return null;
		}

		if (value instanceof Double) {
			return (Double) value;
		}

		if (value instanceof Double || value instanceof Integer || value instanceof Float || value instanceof String) {
			try {
				return NisiraUtils2.getBigDecimalValue(value).doubleValue();
			} catch (Exception e) {
				throw new NisiraORMException(value + " No se puede castear a Double");
			}
		}
		throw new NisiraORMException(value.getClass() + " No se puede castear a Double");
	}

	public Float getFloat(int row, int column) throws NisiraORMException {
		Object value = getData().get(row)[column];

		if (value == null) {
			return null;
		}

		if (value instanceof Float) {
			return (Float) value;
		}

		if (value instanceof Double || value instanceof Integer || value instanceof Float || value instanceof String) {
			try {
				return NisiraUtils2.getBigDecimalValue(value).floatValue();
			} catch (Exception e) {
				throw new NisiraORMException(value + " No se puede castear a Float");
			}
		}
		throw new NisiraORMException(value.getClass() + " No se puede castear a Float");
	}

	public Integer getInteger(int row, int column) throws NisiraORMException {
		Object value = getData().get(row)[column];

		if (value == null) {
			return null;
		}

		if (value instanceof Integer) {
			return (Integer) value;
		}

		if (value instanceof Double || value instanceof Integer || value instanceof Float || value instanceof String) {
			try {
				return NisiraUtils2.getBigDecimalValue(value).intValue();
			} catch (Exception e) {
				throw new NisiraORMException(value + " No se puede castear a Integer");
			}
		}
		throw new NisiraORMException(value.getClass() + " No se puede castear a Integer");
	}

	public Date getDate(int row, int column) throws NisiraORMException {
		Object value = getData().get(row)[column];

		if (value == null) {
			return null;
		}

		if (value instanceof Date) {
			return (Date) value;
		}

		if (value instanceof java.sql.Timestamp) {
			return new Date(((java.sql.Timestamp) value).getTime());
		}

		if (value instanceof java.sql.Date) {
			return new Date(((java.sql.Date) value).getTime());
		}

		throw new NisiraORMException(value.getClass() + " No se puede castear a Integer");
	}

	public int getColumnIndex(String columname) {
		for (int i = 0; i < getName().length; i++) {
			if (columname.trim().equalsIgnoreCase(getName()[i].trim())) {
				return i;
			}
		}
		return -1;
	}

    /**
     * @return the data
     */
    public List<Object[]> getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(List<Object[]> data) {
        this.data = data;
    }

    /**
     * @return the name
     */
    public String[] getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String[] name) {
        this.name = name;
    }

    /**
     * @return the clases
     */
    public Class<?>[] getClases() {
        return clases;
    }

    /**
     * @param clases the clases to set
     */
    public void setClases(Class<?>[] clases) {
        this.clases = clases;
    }
}
