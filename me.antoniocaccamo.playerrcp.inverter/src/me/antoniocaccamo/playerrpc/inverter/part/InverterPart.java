package me.antoniocaccamo.playerrpc.inverter.part;

import org.eclipse.e4.core.di.extensions.Service;
import org.eclipse.e4.core.services.events.IEventBroker;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import me.antoniocaccamo.playerrpc.service.inverter.InverterService;

import jakarta.annotation.PostConstruct;
import jakarta.inject.Inject;

public class InverterPart {
	
	private static final Logger logger = LoggerFactory.getLogger(InverterPart.class);
	 
	
	@Inject
	@Service
	private InverterService inverter;
	
	@Inject
    IEventBroker broker;
	
	@PostConstruct
	public void postConstruct(Composite parent) {
		parent.setLayout(new GridLayout(3, true));
		
		Label inputLabel = new Label(parent, SWT.NONE);
		inputLabel.setText("String to revert:");
		GridDataFactory.fillDefaults().applyTo(inputLabel);
		
		final Text input = new Text(parent, SWT.BORDER);
		GridDataFactory.fillDefaults().grab(true, false).applyTo(input);
		
		Button button = new Button(parent, SWT.PUSH);
		button.setText("Revert");
		GridDataFactory.defaultsFor(button).applyTo(button);
		
		Label outputLabel = new Label(parent, SWT.NONE);
		outputLabel.setText("Inverted String:");
		GridDataFactory.fillDefaults().applyTo(outputLabel);
		
		final Text output = new Text(parent, SWT.READ_ONLY | SWT.WRAP);
		GridDataFactory.fillDefaults().grab(true, true).span(2, 1).applyTo(output);
		
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				output.setText(inverter.invert(input.getText()));
				broker.post("TOPIC_LOGGING", "triggered via button");
				logger.info("via button");
			}
		});

		input.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.keyCode == SWT.CR
						|| e.keyCode == SWT.KEYPAD_CR) {
					output.setText(inverter.invert(input.getText()));
					broker.post("TOPIC_LOGGING", "triggered via field");
					logger.info("via field");
				}
			}
		});
	}
}