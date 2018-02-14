package org.bandahealth.webui;

import java.util.List;

import org.adempiere.util.Callback;
import org.adempiere.webui.adwindow.ADTabpanel;
import org.adempiere.webui.adwindow.ADWindow;
import org.adempiere.webui.apps.AEnv;
import org.adempiere.webui.component.Button;
import org.adempiere.webui.component.Checkbox;
import org.adempiere.webui.component.Label;
import org.adempiere.webui.dashboard.DashboardPanel;
import org.adempiere.webui.exception.ApplicationException;
import org.adempiere.webui.session.SessionManager;
import org.compiere.model.I_AD_SearchDefinition;
import org.compiere.model.I_AD_Window;
import org.compiere.model.MMenu;
import org.compiere.model.MQuery;
import org.compiere.model.MSearchDefinition;
import org.compiere.model.Query;
import org.compiere.util.CLogger;
import org.compiere.util.Env;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Div;
import org.zkoss.zul.Vbox;
import org.zkoss.zul.Vlayout;

public class DPInventory extends DashboardPanel implements EventListener<Event> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6551363849191595411L;
	private final String CREATE_OPERATION_ID = "CreateOperationButton";
	private final String VIEW_STOCK_OPERATIONS_ID = "ViewStockOperationsButton";
	private final String STOCK_TAKE_ID = "StockTakeButton";
	private final String INVENTORY_REPORTS_ID = "InventoryReportsButton";
	
	private CLogger log = CLogger.getCLogger(DPInventory.class);
	
	private Vlayout layout = new Vlayout();
	private Div contentArea = new Div();
	
	private Div createOperation = new Div();
	private Div viewStockOperations = new Div();
	private Div stockTake = new Div();
	private Div inventoryReports = new Div();
	
	public DPInventory() {
		super();
		
		this.setSclass("openmrs");
		
		initLayout();
		initComponent();
	}

	private void initComponent() {
		
		String buttonClass = "button app big";
		initDivButton(createOperation, CREATE_OPERATION_ID, "Navigate to Create Operation", buttonClass,
				"fa fa-folder-open", "Create Operation");
		initDivButton(viewStockOperations, VIEW_STOCK_OPERATIONS_ID, "Navigate to View Stock Operations", buttonClass,
				"fa fa-list", "View Stock Operations");
		initDivButton(stockTake, STOCK_TAKE_ID, "Navigate to Stock Take", buttonClass,
				"far fa-list-alt", "Stock Take");
		initDivButton(inventoryReports, INVENTORY_REPORTS_ID, "Navigate to Inventory Reports", buttonClass,
				"far fa-file-alt", "Inventory Reports");
		
		contentArea.appendChild(createOperation);
		contentArea.appendChild(viewStockOperations);
		contentArea.appendChild(stockTake);
		contentArea.appendChild(inventoryReports);
	}

	private void initDivButton(Div div, String divID, String tooltipText, String classNames, String iconClassName,
			String buttonText) {
		
		div.addEventListener(Events.ON_CLICK, this);
		div.setId(divID);
		div.setTooltiptext(tooltipText);
		div.setClass(classNames);
		
		Div icon = new Div();
		icon.setClass(iconClassName + " i");
		div.appendChild(icon);
		
		Label label = new Label(buttonText);
		div.appendChild(label);
	}

	private void initLayout() {

		layout.setParent(this);
		layout.setSclass("inventory-layout");
		layout.setSpacing("0px");
		layout.setStyle("height: 100%); width 100%");
		
		contentArea.setParent(layout);
		contentArea.setVflex("1");
		contentArea.setHflex("1");
		contentArea.setStyle("margin: 5px 5px; overflow: auto;");
	}

	@Override
	public void onEvent(Event event) throws Exception {
		
		Component component = event.getTarget();
		String eventName = event.getName();
		
		if (eventName.equals(Events.ON_CLICK)) {
			if (component instanceof Div && ((Div) component).getId().equals(CREATE_OPERATION_ID)) {
				try
	            {
//					Query query = new Query(Env.getCtx(), I_AD_Window.Table_Name, "name = 'Inventory Income'", null);
//					query.
//					
//					MMenu menu = new MMenu(Env.getCtx(), menuId, null);
//					
//					
//					
		    		MQuery windowQuery = new MQuery("");
		    		windowQuery.addRestriction("1=2");
		    		windowQuery.setRecordCount(0);
		
					SessionManager.getAppDesktop().openWindow(1000001, windowQuery, new Callback<ADWindow>() {
						
						@Override
						public void onCallback(ADWindow result) {
							if(result == null)
			    				return;
			        		
							result.getADWindowContent().onNew();
							ADTabpanel adtabpanel = (ADTabpanel) result.getADWindowContent().getADTab().getSelectedTabpanel();
							adtabpanel.focusToFirstEditor(false);
						}
					});	
	            }
				catch (Exception ex) {
	                throw new ApplicationException(ex.getMessage(), ex);
	            }
			}
		}
	}

}
