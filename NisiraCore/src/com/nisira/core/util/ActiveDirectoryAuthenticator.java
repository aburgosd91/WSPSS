package com.nisira.core.util;

import java.util.Hashtable;

import javax.naming.AuthenticationException;

import javax.naming.CommunicationException;

import javax.naming.Context;

import javax.naming.NamingException;

import javax.naming.directory.DirContext;

import javax.naming.directory.InitialDirContext;

public class ActiveDirectoryAuthenticator {

    private String userDn;
    private String server;
    private String port;
    private String errorMsg;

    public ActiveDirectoryAuthenticator() {

        port = "3268";

    }

    public String getErrorMsg() {

        return errorMsg;

    }

    public boolean authenticate(String password) {

        errorMsg = "";

        try {

            Hashtable env = new Hashtable();

            env.put(Context.INITIAL_CONTEXT_FACTORY,
                    "com.sun.jndi.ldap.LdapCtxFactory");

            env.put(Context.PROVIDER_URL,
                    "ldap://" + this.getServer() + ":" + this.getPort());

            env.put(Context.SECURITY_AUTHENTICATION, "simple");

            env.put(Context.SECURITY_PRINCIPAL, this.getUserDn());

            env.put(Context.SECURITY_CREDENTIALS, password);

            DirContext ctx = new InitialDirContext(env);

            ctx.close();

        } catch (CommunicationException comEx) {

            errorMsg = "CommunicationException: " + comEx.getMessage();

            return false;

        } catch (AuthenticationException authEx) {

            errorMsg = "AuthenticationException: " + authEx.getMessage();

            return false;

        } catch (NamingException nameEx) {

            errorMsg = "NamingException: " + nameEx.toString();

            return false;

        }

        return true;

    }

    public String getUserDn() {

        return userDn;

    }

    public void setUserDn(String user_rdn) {

        this.userDn = user_rdn;

    }

    public String getServer() {

        return server;

    }

    public void setServer(String server) {

        this.server = server;

    }

    public String getPort() {

        return port;

    }

    public void setPort(String port) {

        this.port = port;

    }
}