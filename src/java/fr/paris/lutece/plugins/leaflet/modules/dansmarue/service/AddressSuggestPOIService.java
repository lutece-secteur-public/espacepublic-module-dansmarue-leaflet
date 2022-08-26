/*
 * Copyright (c) 2002-2022, City of Paris
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *  1. Redistributions of source code must retain the above copyright notice
 *     and the following disclaimer.
 *
 *  2. Redistributions in binary form must reproduce the above copyright notice
 *     and the following disclaimer in the documentation and/or other materials
 *     provided with the distribution.
 *
 *  3. Neither the name of 'Mairie de Paris' nor 'Lutece' nor the names of its
 *     contributors may be used to endorse or promote products derived from
 *     this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDERS OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 *
 * License 1.0
 */
package fr.paris.lutece.plugins.leaflet.modules.dansmarue.service;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.util.UriUtils;

import com.fasterxml.jackson.databind.ObjectMapper;

import fr.paris.lutece.plugins.leaflet.modules.dansmarue.entities.Address;
import fr.paris.lutece.portal.service.util.AppLogService;
import fr.paris.lutece.portal.service.util.AppPropertiesService;
import fr.paris.lutece.util.httpaccess.HttpAccess;
import fr.paris.lutece.util.httpaccess.HttpAccessException;

/**
 * AddressSuggestPOIService.
 */
public class AddressSuggestPOIService implements IAddressSuggestPOIService
{
    // PROPERTIES
    private static final String PROPERTY_SUGGEST_POI_URL = "address.autocomplete.url";
    private static final String PROPERTY_CLIENT_ID = "address.autocomplete.clientId";

    private static final String ERROR_MESSAGE = "Error retrieving the return of suggest POI";

    /**
     * Gets the address item.
     *
     * @param address
     *            the address
     * @return the address item
     */
    @Override
    public List<Address> getAddressItem( String address )
    {
        String storePOIUrl = AppPropertiesService.getProperty( PROPERTY_SUGGEST_POI_URL );
        String clientId = AppPropertiesService.getProperty( PROPERTY_CLIENT_ID );
        String response = StringUtils.EMPTY;

        try
        {
            HttpAccess httpAccess = new HttpAccess( );
            AppLogService.info( "Appel storePOI pour la récupération des adresses" );
            String url = storePOIUrl + "/" + clientId + "/poiauto/" + address.replace( " ", "%20" ) + "?";
            String param = "Parms={\"Entites\":\"ADR,JRDN,VOIE\"}";

            response = httpAccess.doGet( url + UriUtils.encode( param, StandardCharsets.UTF_8.toString( ) ) );
        }
        catch( HttpAccessException | UnsupportedEncodingException ex )
        {
            AppLogService.error( ERROR_MESSAGE, ex );
        }

        ObjectMapper mapper = new ObjectMapper( );
        List<Address> addressList = new ArrayList<>( );
        try
        {
            addressList = Arrays.asList( mapper.readValue( response, Address [ ].class ) );
        }
        catch( IOException e )
        {
            AppLogService.error( ERROR_MESSAGE, e );
        }

        return addressList;
    }

}
