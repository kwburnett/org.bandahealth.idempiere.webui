<%@ page contentType="text/css;charset=UTF-8" %>
<%@ taglib uri="http://www.zkoss.org/dsp/web/core" prefix="c" %>
<%@ taglib uri="http://www.idempiere.org/dsp/web/util" prefix="u" %>

html,body {
	margin: 0;
	padding: 0;
	height: 100%;
	width: 100%;
	background-color: #D4E3F4;
	color: #333;
	font-family: Helvetica,Arial,sans-serif;
	overflow: hidden;
}

.z-html p{
	margin:0px;
}

<%-- Tablet --%>
.tablet-scrolling {
	-webkit-overflow-scrolling: touch;
}

<%-- vbox fix for firefox and ie --%>
table.z-vbox > tbody > tr > td > table {
	width: 100%;	
}

<%-- workflow activity --%>
.workflow-activity-form {
}
.workflow-panel-table {
	border: 0px;
}

<%-- payment form --%>
.payment-form-content {
}

<%-- line 1232 OpenMRS Reference App CSS --%>
.openmrs .button, .openmrs button, .openmrs input[type="submit"], .openmrs input[type="button"], .openmrs input[type="submit"], .openmrs a.button {
  -moz-border-radius: 3px;
  -webkit-border-radius: 3px;
  -o-border-radius: 3px;
  -ms-border-radius: 3px;
  -khtml-border-radius: 3px;
  border-radius: 3px;
  background: -webkit-gradient(linear, 50% 0%, 50% 100%, color-stop(0%, #ffffff), color-stop(100%, #dddddd));
  background: -webkit-linear-gradient(top, #ffffff, #dddddd);
  background: -moz-linear-gradient(top, #ffffff, #dddddd);
  background: -o-linear-gradient(top, #ffffff, #dddddd);
  background: -ms-linear-gradient(top, #ffffff, #dddddd);
  background: linear-gradient(top, #ffffff, #dddddd);
  background-color: #dddddd;
  border: #dddddd 1px solid;
  padding: 8px 20px;
  display: inline-block;
  line-height: 1.2em;
  color: #363463;
  cursor: pointer;
  min-width: 0;
  max-width: 300px;
  text-decoration: none;
}

.openmrs .button:hover, .openmrs button:hover, .openmrs input[type="submit"]:hover, .openmrs input[type="button"]:hover, .openmrs input[type="submit"]:hover, .openmrs a.button:hover {
  background: #e2e2e2;
  border-color: #d0d0d0;
}

.openmrs .button.active, .openmrs button.active, .openmrs input[type="submit"].active, .openmrs input[type="button"].active, .openmrs input[type="submit"].active, .openmrs a.button.active {
  background: #d8d8d8;
  border-color: #d0d0d0;
}

.openmrs .button .i, .openmrs button .i, .openmrs input[type="submit"] .i, .openmrs input[type="button"] .i, .openmrs input[type="submit"] .i, .openmrs a.button .i {
  font-size: 1.2em;
  margin: 0;
  padding: 0;
  line-height: .5em;
}

.openmrs .button.big .i, .openmrs .button.medium .i, .openmrs button.big .i, .openmrs button.medium .i, .openmrs input[type="submit"].big .i, .openmrs input[type="submit"].medium .i, .openmrs input[type="button"].big .i, .openmrs input[type="button"].medium .i, .openmrs input[type="submit"].big .i, .openmrs input[type="submit"].medium .i, .openmrs a.button.big .i, .openmrs a.button.medium .i {
  display: block;
  font-size: 50px;
  margin: 0 auto;
  padding: 10px;
}

<%-- line 1291 OpenMRS Reference App CSS --%>
.openmrs .button.app, .openmrs button.app, .openmrs input[type="submit"].app, .openmrs input[type="button"].app, .openmrs input[type="submit"].app, .openmrs a.button.app {
  padding: 20px 10px;
  width: 150px;
  min-height: 90px;
  vertical-align: top;
  line-height: 1.3em;
  margin: 10px;
  text-align: center;
}

<c:include page="fragment/login.css.dsp" />

<c:include page="fragment/desktop.css.dsp" />

<c:include page="fragment/application-menu.css.dsp" />

<c:include page="fragment/gadget.css.dsp" />

<c:include page="fragment/toolbar.css.dsp" />

<c:include page="fragment/button.css.dsp" />

<c:include page="fragment/adwindow.css.dsp" />
			
<c:include page="fragment/grid.css.dsp" />

<c:include page="fragment/input-element.css.dsp" />

<c:include page="fragment/tree.css.dsp" /> 

<c:include page="fragment/field-editor.css.dsp" />

<c:include page="fragment/group.css.dsp" />

<c:include page="fragment/tab.css.dsp" />

<c:include page="fragment/menu-tree.css.dsp" />

<c:include page="fragment/info-window.css.dsp" />

<c:include page="fragment/window.css.dsp" />

<c:include page="fragment/form.css.dsp" />

<c:include page="fragment/toolbar-popup.css.dsp" />	

<c:include page="fragment/setup-wizard.css.dsp" />

<c:include page="fragment/about.css.dsp" />

<c:include page="fragment/tab-editor.css.dsp" />

<c:include page="fragment/find-window.css.dsp" />

<c:include page="fragment/help-window.css.dsp" />

<c:include page="fragment/borderlayout.css.dsp" />

<c:include page="fragment/parameter-process.css.dsp" />

<c:include page="fragment/window-size.css.dsp" />

<c:include page="fontawesome.css.dsp" />

<c:include page="openmrs/inventory.css.dsp" />
