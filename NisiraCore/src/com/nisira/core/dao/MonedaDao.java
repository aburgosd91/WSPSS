package com.nisira.core.dao;

import com.nisira.core.BaseDao;
import com.nisira.core.entity.*;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.text.SimpleDateFormat;
import java.util.Date;
import com.nisira.core.NisiraORMException;
import com.nisira.core.entityservices.*;import java.sql.ResultSet;
public class MonedaDao extends BaseDao<Moneda> {
	public MonedaDao() {
		super(Moneda.class);
	}
	public MonedaDao(boolean usaCnBase) throws NisiraORMException {
		super(Moneda.class, usaCnBase);
	}
}