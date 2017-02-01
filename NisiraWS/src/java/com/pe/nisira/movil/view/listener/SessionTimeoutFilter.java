/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pe.nisira.movil.view.listener;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.util.logging.Level;
import java.util.logging.Logger;
import static com.pe.nisira.movil.view.util.NisiraWebLog.log;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
//import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author azamora
 */
@WebFilter()
public class SessionTimeoutFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException,
            ServletException {
        System.out.println("filter called");
        final HttpServletRequest req = (HttpServletRequest) request;
        final HttpSession session = req.getSession(false);
        if (session != null && !session.isNew()) {
            chain.doFilter(request, response);
        } else {
            System.out.println("Has timed out");
            req.getRequestDispatcher("/index.xthml").forward(request, response);
        }
    }

    @Override
    public void destroy() {
    }
}
