/*
 * Copyright (c) 2002-2020, City of Paris
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
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.web.util.UriUtils;

import fr.paris.lutece.plugins.leaflet.modules.dansmarue.entities.Address;
import fr.paris.lutece.plugins.leaflet.modules.dansmarue.entities.ResultPOI;
import fr.paris.lutece.portal.service.util.AppLogService;
import fr.paris.lutece.portal.service.util.AppPropertiesService;
import fr.paris.lutece.util.httpaccess.HttpAccess;
import fr.paris.lutece.util.httpaccess.HttpAccessException;

/**
 * AddressSuggestPOIService.
 */
public class AddressSuggestPOIService implements IAddressSuggestPOIService
{

    /** The Constant PROPERTY_SUGGEST_POI_URL. */
    // PROPERTIES
    private static final String PROPERTY_SUGGEST_POI_URL     = "address.autocomplete.srv.url";

    /** The Constant PROPERTY_TYPES. */
    private static final String PROPERTY_TYPES               = "address.autocomplete.types";

    /** The Constant PROPERTY_CLIENT_ID. */
    private static final String PROPERTY_CLIENT_ID           = "address.autocomplete.clientId";

    /** The Constant PARAMETER_TYPES. */
    // PARAMETERS
    private static final String PARAMETER_TYPES              = "types";

    /** The Constant PARAMETER_CLIENT_ID. */
    private static final String PARAMETER_CLIENT_ID          = "clientId";

    /** The Constant PARAMETER_QUERY. */
    private static final String PARAMETER_QUERY              = "query";

    /** The Constant CONST_INTERROGATION_MARK. */
    // MARK
    private static final String CONST_INTERROGATION_MARK     = "?";

    /** The Constant CONST_ADDITIONNAL_PARAM_MARK. */
    private static final String CONST_ADDITIONNAL_PARAM_MARK = "&";

    /** The Constant CONST_EQUAL_MARK. */
    private static final String CONST_EQUAL_MARK             = "=";

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
        String suggestPOIUrl = AppPropertiesService.getProperty( PROPERTY_SUGGEST_POI_URL );

        StringBuilder uri = new StringBuilder( suggestPOIUrl );
        uri.append( CONST_INTERROGATION_MARK );

        StringBuilder params = new StringBuilder( );
        // Address query
        params.append( PARAMETER_QUERY ).append( CONST_EQUAL_MARK ).append( address );

        // Types
        String types = AppPropertiesService.getProperty( PROPERTY_TYPES );
        params.append( CONST_ADDITIONNAL_PARAM_MARK );
        params.append( PARAMETER_TYPES ).append( CONST_EQUAL_MARK ).append( types );

        // Client id
        String clientId = AppPropertiesService.getProperty( PROPERTY_CLIENT_ID );
        params.append( CONST_ADDITIONNAL_PARAM_MARK );
        params.append( PARAMETER_CLIENT_ID ).append( CONST_EQUAL_MARK ).append( clientId );

        String response = StringUtils.EMPTY;

        try
        {
            HttpAccess httpAccess = new HttpAccess( );
            uri.append( UriUtils.encodeQuery( params.toString( ), StandardCharsets.UTF_8.toString( ) ) );
            response = httpAccess.doGet( uri.toString( ) );
        }
        catch ( HttpAccessException | UnsupportedEncodingException ex )
        {
            AppLogService.error( "Error retrieving the return of suggest POI", ex );
        }

        ObjectMapper mapper = new ObjectMapper( );
        List<Address> addressList = new ArrayList<>( );
        try
        {
            ResultPOI result = mapper.readValue( response, ResultPOI.class );
            addressList = result.getResult( );
        }
        catch ( IOException e )
        {
            AppLogService.error( "Error retrieving the return of suggest POI", e );
        }

        return addressList;
    }
}
