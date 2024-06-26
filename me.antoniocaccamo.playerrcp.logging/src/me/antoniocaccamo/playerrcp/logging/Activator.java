package me.antoniocaccamo.playerrcp.logging;

import java.net.URL;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Path;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.joran.JoranConfigurator;

public class Activator implements BundleActivator {

	private static BundleContext context;

	static BundleContext getContext() {
		return context;
	}

	public void start(BundleContext bundleContext) throws Exception {
		Activator.context = bundleContext;
		configureLogback(bundleContext.getBundle());
	}

	private void configureLogback(Bundle bundle) {
		try {
			LoggerContext context = (LoggerContext) LoggerFactory.getILoggerFactory();
	        JoranConfigurator jc = new JoranConfigurator();
	        jc.setContext(context);
	        context.reset();

	        // this assumes that the logback.xml file is in the root of the bundle.
	        URL logbackConfigFileUrl = FileLocator.find(bundle, new Path("logback.xml"),null);
	        jc.doConfigure(logbackConfigFileUrl.openStream());
	        LoggerFactory.getLogger(Activator.class).info("configuration logger done");
		} 
		catch (Throwable t) {
			System.err.println("error occurred: " + t.getCause());
		}
		
	}

	public void stop(BundleContext bundleContext) throws Exception {
		Activator.context = null;
	}

}
