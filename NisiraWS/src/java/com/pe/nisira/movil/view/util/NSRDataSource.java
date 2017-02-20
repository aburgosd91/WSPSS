package com.pe.nisira.movil.view.util;

import java.math.BigDecimal;
import java.util.Date;

import com.nisira.core.dao.NSRResultSet;
import com.nisira.core.NisiraORMException;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;

public class NSRDataSource implements JRDataSource {

	private int counter = -1;

	private NSRResultSet nsrresulset = new NSRResultSet();

	public NSRDataSource(NSRResultSet nsrresulset) {
		this.nsrresulset = nsrresulset;
	}

	@Override
	public Object getFieldValue(JRField jrf) throws JRException {
		
		int idx = nsrresulset.getColumnIndex(jrf.getName());

		Class<?> clase = nsrresulset.getClassFormColumn(jrf.getName());

		if (clase == String.class) {
			try {
				return nsrresulset.getString(counter, idx);
			} catch (NisiraORMException e) {
				throw new JRException(e.getMessage());
			}
		} else if (clase == BigDecimal.class) {
			try {
				return nsrresulset.getBigDecimal(counter, idx);
			} catch (NisiraORMException e) {
				throw new JRException(e.getMessage());
			}
		} else if (clase == Double.class) {
			try {
				return nsrresulset.getDouble(counter, idx);
			} catch (NisiraORMException e) {
				throw new JRException(e.getMessage());
			}
		} else if (clase == Float.class) {
			try {
				return nsrresulset.getFloat(counter, idx);
			} catch (NisiraORMException e) {
				throw new JRException(e.getMessage());
			}
		} else if (clase == Integer.class) {
			try {
				return nsrresulset.getInteger(counter, idx);
			} catch (NisiraORMException e) {
				throw new JRException(e.getMessage());
			}
		} else if (clase == Date.class) {
			try {
				return nsrresulset.getDate(counter, idx);
			} catch (NisiraORMException e) {
				throw new JRException(e.getMessage());
			}
		} else {
			try {
				return nsrresulset.getObject(counter, idx);
			} catch (NisiraORMException e) {
				throw new JRException(e.getMessage());
			}
		}

	}

	@Override
	public boolean next() throws JRException {
		counter++;
		if (nsrresulset != null && counter < nsrresulset.size()) {
			return true;
		}
		return false;
	}
}
