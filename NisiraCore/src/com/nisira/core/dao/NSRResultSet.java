package com.nisira.core.dao;

import com.nisira.core.NisiraORMException;
import com.nisira.core.util.NisiraUtils2;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class NSRResultSet {
	private List<Object[]> data;
	private String[] name;

	private Class<?>[] clases;

	public Class<?> getClassFormColumn(String column) {
		int idxcolumn = getColumnIndex(column);
		if (idxcolumn == -1) {
			return null;
		}
		return clases[idxcolumn];
	}

	public int columnCount() {
		return name.length;
	}

	public String getColumnName(int index) {
		return name[index];
	}

	public Class<?> getColumnClass(int index) {
		return clases[index];
	}

	public Object[] getRow(int index) {
		return data.get(index);
	}

	public int size() {
		return data.size();
	}

	public void setData(List<Object[]> data, String[] name) {
		this.data = data;
		this.name = name;

		if (data.size() > 0) {
			clases = new Class<?>[this.name.length];
			for (int i = 0; i < this.name.length; i++) {
				if (this.data.get(0)[i] instanceof String) {
					clases[i] = String.class;

				} else if (this.data.get(0)[i] instanceof BigDecimal) {
					clases[i] = BigDecimal.class;

				} else if (this.data.get(0)[i] instanceof Double) {
					clases[i] = Double.class;

				} else if (this.data.get(0)[i] instanceof Float) {
					clases[i] = Float.class;

				} else if (this.data.get(0)[i] instanceof Integer) {
					clases[i] = Integer.class;

				} else if (this.data.get(0)[i] instanceof Date || this.data.get(0)[i] instanceof java.sql.Timestamp
						|| this.data.get(0)[i] instanceof java.sql.Date) {
					clases[i] = Date.class;

				} else {
					clases[i] = Object.class;
				}
			}
		} else {
			clases = new Class<?>[this.name.length];
			for (int i = 0; i < this.name.length; i++) {
				clases[i] = Object.class;
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
		return data.get(row)[column];
	}

	public String getString(int row, int column) throws NisiraORMException {
		Object value = data.get(row)[column];

		if (value == null) {
			return null;
		}

		if (value instanceof String) {
			return (String) value;
		}
		return String.valueOf(value);
	}

	public BigDecimal getBigDecimal(int row, int column) throws NisiraORMException {
		Object value = data.get(row)[column];

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
		Object value = data.get(row)[column];

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
		Object value = data.get(row)[column];

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
		Object value = data.get(row)[column];

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
		Object value = data.get(row)[column];

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
		for (int i = 0; i < name.length; i++) {
			if (columname.trim().equalsIgnoreCase(name[i].trim())) {
				return i;
			}
		}
		return -1;
	}
}
