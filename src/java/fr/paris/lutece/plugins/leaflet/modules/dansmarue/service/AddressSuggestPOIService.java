package fr.paris.lutece.plugins.leaflet.modules.dansmarue.service;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.springframework.web.util.UriUtils;

import fr.paris.lutece.plugins.leaflet.modules.dansmarue.entities.Address;
import fr.paris.lutece.plugins.leaflet.modules.dansmarue.entities.ResultPOI;
import fr.paris.lutece.portal.service.util.AppPropertiesService;
import fr.paris.lutece.util.httpaccess.HttpAccess;
import fr.paris.lutece.util.httpaccess.HttpAccessException;
import net.sf.json.JSONObject;

public class AddressSuggestPOIService implements IAddressSuggestPOIService{
	
	private static final Logger LOGGER = Logger.getLogger( AddressSuggestPOIService.class );
	
	//PROPERTIES
	private static final String PROPERTY_SUGGEST_POI_URL = "address.autocomplete.srv.url";
	private static final String PROPERTY_TYPES = "address.autocomplete.types";
	private static final String PROPERTY_CLIENT_ID = "address.autocomplete.clientId";
	
	//PARAMETERS
	private static final String PARAMETER_TYPES = "types";
	private static final String PARAMETER_CLIENT_ID = "clientId";
	private static final String PARAMETER_QUERY = "query";
	
	//MARK
	private static final String CONST_INTERROGATION_MARK = "?";
	private static final String CONST_ADDITIONNAL_PARAM_MARK = "&";
	private static final String CONST_EQUAL_MARK = "=";
	
	public List<Address> getAddressItem(String address){
		String suggestPOIUrl = AppPropertiesService.getProperty(PROPERTY_SUGGEST_POI_URL);
		
		StringBuilder uri = new StringBuilder(suggestPOIUrl);
		uri.append(CONST_INTERROGATION_MARK);
		
		StringBuilder params = new StringBuilder();
		//Address query
		params.append(PARAMETER_QUERY).append(CONST_EQUAL_MARK).append(address);
		
		//Types
		String types = AppPropertiesService.getProperty(PROPERTY_TYPES);
		params.append(CONST_ADDITIONNAL_PARAM_MARK);
		params.append(PARAMETER_TYPES).append(CONST_EQUAL_MARK).append(types);
		
		//Client id
		String clientId = AppPropertiesService.getProperty(PROPERTY_CLIENT_ID);
		params.append(CONST_ADDITIONNAL_PARAM_MARK);
		params.append(PARAMETER_CLIENT_ID).append(CONST_EQUAL_MARK).append(clientId);
		
		String response = StringUtils.EMPTY;
		
		try{
			HttpAccess httpAccess = new HttpAccess();
			uri.append(UriUtils.encodeQuery(params.toString(), StandardCharsets.UTF_8.toString()));
			response = httpAccess.doGet(uri.toString());
		} catch(HttpAccessException | UnsupportedEncodingException ex){
			LOGGER.error("Erreur lors de l'appel au suggest POI",ex);
		}
		
		ObjectMapper mapper = new ObjectMapper();
		List<Address> addressList = new ArrayList<>();
		try {
			ResultPOI result = mapper.readValue(response, ResultPOI.class);
			addressList = result.getResult();
		} catch (IOException e) {
			LOGGER.error("Erreur lors de la récupération du retour suggest POI",e);
		}
		
		return addressList;
	}
}
