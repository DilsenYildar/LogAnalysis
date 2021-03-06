package com.dilo.maven.quickstart;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.http.HttpStatus;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.handler.AbstractHandler;

/**
 * When the /path is equal to the /update/ this class runs. The log to be
 * updated is fetched from the database.
 *
 */
public class UpdateReqContext extends AbstractHandler {
	String logAttr;
	String logAttrType;

	public void handle(String target, Request baseRequest, HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		// LoggingInDB lidb = new LoggingInDB();

		Enumeration<String> parameterNames = request.getParameterNames();
		while (parameterNames.hasMoreElements()) {
			logAttr = (String) parameterNames.nextElement();
			logAttrType = request.getParameter(logAttr).toString();
		}
		if (logAttr.equals("logmessage") && logAttrType.equals("Fixed.")) {
			// lidb.updateOp("logmessage", "Fixed."); //UPDATE problemli
		}
		response.getWriter().write("<h1>Güncellendi.</h1>");
		response.setContentType("text/html;charset=utf-8");
		response.setStatus(HttpStatus.OK_200);
		baseRequest.setHandled(true);
	}
}
