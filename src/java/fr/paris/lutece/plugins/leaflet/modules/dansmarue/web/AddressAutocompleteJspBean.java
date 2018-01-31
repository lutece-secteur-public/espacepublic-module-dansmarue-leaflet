package fr.paris.lutece.plugins.leaflet.modules.dansmarue.web;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import fr.paris.lutece.portal.service.template.AppTemplateService;
import fr.paris.lutece.portal.service.util.AppPropertiesService;
import fr.paris.lutece.util.html.HtmlTemplate;

public class AddressAutocompleteJspBean {
	
	//Properties
	private static final String PROPERTY_DELAY = "address.autocomplete.delay";
	private static final String PROPERTY_MIN_LENGTH = "address.autocomplete.minLength";
	private static final String PROPERTY_TYPES = "address.autocomplete.types";
	private static final String PROPERTY_NB_RESULTS = "address.autocomplete.nbResults";
	private static final String PROPERTY_CLIENT_ID = "address.autocomplete.clientId";
	private static final String PROPERTY_URL = "address.autocomplete.url";
	
	//Markers
	private static final String MARK_DELAY = "delay";
	private static final String MARK_MIN_LENGTH = "min_length";
	private static final String MARK_TYPES = "types";
	private static final String MARK_NB_RESULTS = "nb_results";
	private static final String MARK_CLIENT_ID = "client_id";
	private static final String MARK_URL = "url";
	
	//TEMPLATES
	private static final String TEMPLATE_ADRESS_AUTOCOMPLETE = "admin/plugins/leaflet/modules/dansmarue/address_autocomplete.html";
	
	public String getAddressAutocomplete(HttpServletRequest request){
		Map<String,Object> model = new HashMap<String,Object>();
		model.put(MARK_DELAY, AppPropertiesService.getProperty(PROPERTY_DELAY));
		model.put(MARK_MIN_LENGTH, AppPropertiesService.getProperty(PROPERTY_MIN_LENGTH));
		model.put(MARK_TYPES, AppPropertiesService.getProperty(PROPERTY_TYPES));
		model.put(MARK_NB_RESULTS, AppPropertiesService.getProperty(PROPERTY_NB_RESULTS));
		model.put(MARK_CLIENT_ID, AppPropertiesService.getProperty(PROPERTY_CLIENT_ID));
		model.put(MARK_URL, AppPropertiesService.getProperty(PROPERTY_URL));
		
		HtmlTemplate template = AppTemplateService.getTemplate(TEMPLATE_ADRESS_AUTOCOMPLETE,request.getLocale(),model);
		return template.getHtml();
		
	}
	
}
