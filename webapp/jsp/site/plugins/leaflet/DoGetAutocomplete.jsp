<jsp:useBean id="adress_autocomplete" scope="session"
	class="fr.paris.lutece.plugins.leaflet.modules.dansmarue.web.AddressAutocompleteJspBean" />

<%= adress_autocomplete.getAddressAutocomplete( request ) %>