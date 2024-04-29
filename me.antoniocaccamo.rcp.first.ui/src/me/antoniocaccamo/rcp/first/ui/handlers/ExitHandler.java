package me.antoniocaccamo.rcp.first.ui.handlers;

import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.workbench.IWorkbench;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExitHandler {
	
	private static final Logger logger = LoggerFactory.getLogger(ExitHandler.class); 
	
	
	@Execute
	public void execute(IWorkbench workbench) {
		logger.info("exiting ...");
		System.out.println("closing ...");
		workbench.close();
	}

}
