package me.antoniocaccamo.playerrpc.logview.part;

import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.ui.di.UIEventTopic;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.swt.widgets.Composite;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jakarta.annotation.PostConstruct;
import jakarta.inject.Inject;

public class LogViewPart {
	
	private static final Logger logger = LoggerFactory.getLogger(LogViewPart.class);
 
    ListViewer viewer;
 
    @PostConstruct
    public void postConstruct(Composite parent) {
        viewer = new ListViewer(parent);
    }
 
    @Inject
    @Optional
    void logging(@UIEventTopic("TOPIC_LOGGING") String message) {
    	logger.info("message: {}", message);
        viewer.add(message);
    }
 
}