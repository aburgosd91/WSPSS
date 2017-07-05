package com.pe.nisira.movil.view.bean;

import java.io.IOException;

import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;

@ManagedBean(name="errorBean")
public class ErrorBean {
	
	public void redirectIndex() throws IOException {
		ExternalContext ctx = 
				FacesContext.getCurrentInstance().getExternalContext();
		String ctxPath = 
			      ((ServletContext) ctx.getContext()).getContextPath();
		ctx.redirect(ctxPath + "/");
	}
}