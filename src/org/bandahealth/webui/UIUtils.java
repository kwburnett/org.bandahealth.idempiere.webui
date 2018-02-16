package org.bandahealth.webui;

import org.adempiere.webui.component.Label;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Div;

public class UIUtils {

	public static void initDivButton(Div div, EventListener<Event> eventListener, String divID, String tooltipText,
			String classNames, String iconClassName, String buttonText) {
		
		div.addEventListener(Events.ON_CLICK, eventListener);
		div.setId(divID);
		div.setTooltiptext(tooltipText);
		div.setClass(classNames);
		
		Div icon = new Div();
		icon.setClass(iconClassName + " i");
		div.appendChild(icon);
		
		Label label = new Label(buttonText);
		div.appendChild(label);
	}
}
