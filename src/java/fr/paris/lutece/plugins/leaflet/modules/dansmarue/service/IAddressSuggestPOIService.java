package fr.paris.lutece.plugins.leaflet.modules.dansmarue.service;

import java.util.List;

import fr.paris.lutece.plugins.leaflet.modules.dansmarue.entities.Address;

public interface IAddressSuggestPOIService {
	 
	/**
	 * Finds a address from the suggest POI WS
	 * @param address
	 * 		  The address to search in the suggest POI
	 * @return
	 * 		  List of adress matching the requested one
	 */
	List<Address> getAddressItem(String address);
}
