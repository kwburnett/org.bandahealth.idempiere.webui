package org.bandahealth.webui;

import org.adempiere.util.Callback;
import org.adempiere.webui.adwindow.ADTabpanel;
import org.adempiere.webui.adwindow.ADWindow;
import org.adempiere.webui.dashboard.DashboardPanel;
import org.adempiere.webui.exception.ApplicationException;
import org.adempiere.webui.session.SessionManager;
import org.compiere.model.I_AD_Window;
import org.compiere.model.MQuery;
import org.compiere.model.Query;
import org.compiere.util.CLogger;
import org.compiere.util.Env;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Div;
import org.zkoss.zul.Vlayout;

public class DPInventoryManagement extends DashboardPanel implements EventListener<Event> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3779537015695769160L;
	
	private final String CREATE_INVENTORY_ROLE_ID = "CreateInventoryRoleButton";
	private final String MANAGE_ITEMS_ID = "ManageItemsButton";
	private final String MANAGE_ITEM_ATTRIBUTE_TYPES_ID = "ManageItemAttributeTypesButton";
	private final String MANAGE_DEPARTMENTS_ID = "ManageDepartmentsButton";
	private final String MANAGE_INSTITUTIONS_ID = "ManageInstitutionsButton";
	private final String MANAGE_STOCKROOMS_ID = "ManageStockroomsButton";
	private final String MANAGE_OPERATION_TYPES_ID = "ManageOperationTypesButton";
	
	private CLogger log = CLogger.getCLogger(DPInventory.class);
	
	private Vlayout layout = new Vlayout();
	private Div contentArea = new Div();
	
	private Div createInventoryRole = new Div();
	private Div manageItems = new Div();
	private Div manageItemAttributeTypes = new Div();
	private Div manageDepartments = new Div();
	private Div manageInstitutions = new Div();
	private Div manageStockrooms = new Div();
	private Div manageOperationTypes = new Div();
	
	public DPInventoryManagement() {
		super();
		
		this.setSclass("openmrs");
		
		initLayout();
		initComponent();
	}

	private void initComponent() {
		
		String buttonClass = "button app big";
		UIUtils.initDivButton(createInventoryRole, this, CREATE_INVENTORY_ROLE_ID, "Navigate to Inventory Role Creation", buttonClass,
				"fas fa-user", "Inventory Role Creation");
		UIUtils.initDivButton(manageItems, this, MANAGE_ITEMS_ID, "Navigate to Manage Items", buttonClass,
				"fa fa-italic", "Manage Items");
		UIUtils.initDivButton(manageItemAttributeTypes, this, MANAGE_ITEM_ATTRIBUTE_TYPES_ID, "Navigate to Manage Item Attribute Types", buttonClass,
				"far fa-edit", "Manage Item Attribute Types");
		UIUtils.initDivButton(manageDepartments, this, MANAGE_DEPARTMENTS_ID, "Navigate to Manage Departments", buttonClass,
				"fas fa-briefcase", "Manage Departments");
		UIUtils.initDivButton(manageInstitutions, this, MANAGE_INSTITUTIONS_ID, "Navigate to Manage Institutions", buttonClass,
				"far fa-building", "Manage Institutions");
		UIUtils.initDivButton(manageStockrooms, this, MANAGE_STOCKROOMS_ID, "Navigate to Manage Stockrooms", buttonClass,
				"fas fa-home", "Manage Stockrooms");
		UIUtils.initDivButton(manageOperationTypes, this, MANAGE_OPERATION_TYPES_ID, "Navigate to Manage Operation Types", buttonClass,
				"far fa-edit", "Manage Operation Types");
		
		contentArea.appendChild(createInventoryRole);
		contentArea.appendChild(manageItems);
		contentArea.appendChild(manageItemAttributeTypes);
		contentArea.appendChild(manageDepartments);
		contentArea.appendChild(manageInstitutions);
		contentArea.appendChild(manageStockrooms);
		contentArea.appendChild(manageOperationTypes);
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
			
    		MQuery windowQuery = new MQuery("");
    		windowQuery.addRestriction("1=2");
    		windowQuery.setRecordCount(0);
    		
			if (component instanceof Div) {
				String divID = ((Div) component).getId();
				int windowID = -1;
				 
				try {
					String windowWhereStatement = null;
					switch (divID) {
					case CREATE_INVENTORY_ROLE_ID:
						windowWhereStatement = "name = 'Role'";
						break;
					case MANAGE_ITEMS_ID:
						windowWhereStatement = "name = 'Product'";
						break;
					case MANAGE_ITEM_ATTRIBUTE_TYPES_ID:
						windowWhereStatement = "name = 'Attribute Set'";
						break;
					case MANAGE_DEPARTMENTS_ID:
						windowWhereStatement = "name = 'Warehouse & Locators'";
						break;
					case MANAGE_INSTITUTIONS_ID:
						windowWhereStatement = "name = 'Business Partner'";
						break;
					case MANAGE_STOCKROOMS_ID:
						windowWhereStatement = "name = 'Warehouse & Locators'";
						break;
					}

					if (windowWhereStatement != null) {
						Query query = new Query(Env.getCtx(), I_AD_Window.Table_Name, windowWhereStatement, null);
						windowID = query.firstId();
						
						SessionManager.getAppDesktop().openWindow(windowID, windowQuery, new Callback<ADWindow>() {
							
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
				}	
				catch (Exception ex) {
					throw new ApplicationException(ex.getMessage(), ex);
				}
			}
		}
	}

}
