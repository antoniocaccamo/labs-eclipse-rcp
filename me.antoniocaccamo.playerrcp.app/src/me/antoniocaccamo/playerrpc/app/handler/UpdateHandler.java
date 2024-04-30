package me.antoniocaccamo.playerrpc.app.handler;

import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.di.UISynchronize;
import org.eclipse.e4.ui.workbench.IWorkbench;
import org.eclipse.equinox.p2.core.IProvisioningAgent;
import org.eclipse.nebula.widgets.opal.notifier.Notifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UpdateHandler {
	
	private static final Logger logger = LoggerFactory.getLogger(UpdateHandler.class);
	
	
	@Execute
    public void execute(
            IProvisioningAgent agent, 
            UISynchronize sync, 
            IWorkbench workbench) {

		Notifier.notify("New Mail message", "Laurent CARON (lcaron@...");
    }

}
