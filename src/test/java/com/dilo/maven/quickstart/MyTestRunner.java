package com.dilo.maven.quickstart;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class MyTestRunner {

	public static void main(String[] args) {
		Result result = JUnitCore.runClasses(FileHandlerTest.class, JsonHandlerTest.class, LoggingInDBTest.class, CreateSampleLogFileTest.class);
	    for (Failure failure : result.getFailures()) {
	      System.out.println(failure.toString());
	    }
	}

}
