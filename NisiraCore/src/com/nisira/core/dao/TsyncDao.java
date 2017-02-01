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
public class TsyncDao extends BaseDao<Tsync> {
	public TsyncDao() {
		super(Tsync.class);
	}
	public TsyncDao(boolean usaCnBase) throws NisiraORMException {
		super(Tsync.class, usaCnBase);
	}

}