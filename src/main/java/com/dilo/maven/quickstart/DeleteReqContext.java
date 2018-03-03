package com.dilo.maven.quickstart;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.eclipse.jetty.http.HttpStatus;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.handler.AbstractHandler;

/**
 *
 * @author Dilsen Yildar <dilsenyldr@yandex.com>
 */
public class DeleteReqContext extends AbstractHandler {
	
	private Logger logger = LogManager.getLogger();
	String logAttr;
	String logAttrType;
	public void handle(String target, Request baseRequest, HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		
		LoggingInDB lidb = new LoggingInDB();
		
		Enumeration<String> parameterNames = request.getParameterNames();
		while(parameterNames.hasMoreElements()) {
			logAttr = (String) parameterNames.nextElement();
			logAttrType = request.getParameter(logAttr).toString();
			
			response.getWriter().write(String.format("Logs that you want to delete:%s%s\n", logAttr, logAttrType));
		}
		try {
			lidb.deleteOp(logAttr,logAttrType);
		}catch (IOException | SQLException e) {
			logger.warn(e);
			e.printStackTrace();
		}
		response.setContentType("text/html;charset=utf-8"); 
		response.setStatus(HttpStatus.FORBIDDEN_403);;
		baseRequest.setHandled(true);
	}
}

