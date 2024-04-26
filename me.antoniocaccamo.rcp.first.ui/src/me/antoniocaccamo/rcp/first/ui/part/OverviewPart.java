/**
 * 
 */
package me.antoniocaccamo.rcp.first.ui.part;

import org.eclipse.jface.layout.FillLayoutFactory;
import org.eclipse.jface.widgets.TextFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.slf4j.LoggerFactory;

import jakarta.annotation.*;

/**
 * 
 */
public class OverviewPart {

	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(OverviewPart.class);
	
	
	public OverviewPart() {
		
		System.out.println(String.format("%s constructed", getClass().getCanonicalName()));
		logger.info("{} constructed", getClass().getCanonicalName());
	}
	
	@PostConstruct
    public void postConstruct(Composite parent) {
		System.out.println(String.format("%s#postConstruct", getClass().getCanonicalName()));
		logger.info("{}#postConstruct()", getClass().getCanonicalName());
		FillLayoutFactory.fillDefaults().applyTo(parent);
        
		TextFactory.newText(SWT.BORDER |SWT.MULTI)
		.text("bella lì")
			.create(parent);
    }
}
