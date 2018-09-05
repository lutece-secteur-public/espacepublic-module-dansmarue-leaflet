/*
 * Copyright (c) 2002-2018, Mairie de Paris
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
package fr.paris.lutece.plugins.leaflet.modules.dansmarue.web;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import fr.paris.lutece.portal.service.template.AppTemplateService;
import fr.paris.lutece.portal.service.util.AppPropertiesService;
import fr.paris.lutece.util.html.HtmlTemplate;

/**
 *
 * AddressAutocompleteJspBean
 *
 */
public class AddressAutocompleteJspBean
{

    // Properties
    private static final String PROPERTY_DELAY               = "address.autocomplete.delay";
    private static final String PROPERTY_MIN_LENGTH          = "address.autocomplete.minLength";
    private static final String PROPERTY_TYPES               = "address.autocomplete.types";
    private static final String PROPERTY_NB_RESULTS          = "address.autocomplete.nbResults";
    private static final String PROPERTY_CLIENT_ID           = "address.autocomplete.clientId";
    private static final String PROPERTY_URL                 = "address.autocomplete.url";

    // Markers
    private static final String MARK_DELAY                   = "delay";
    private static final String MARK_MIN_LENGTH              = "min_length";
    private static final String MARK_TYPES                   = "types";
    private static final String MARK_NB_RESULTS              = "nb_results";
    private static final String MARK_CLIENT_ID               = "client_id";
    private static final String MARK_URL                     = "url";

    // TEMPLATES
    private static final String TEMPLATE_ADRESS_AUTOCOMPLETE = "admin/plugins/leaflet/modules/dansmarue/address_autocomplete.html";

    /**
     * Get the template address autocomplete .
     *
     * @param request
     *            the request
     * @return the template address autocomplete
     */
    public String getAddressAutocomplete( HttpServletRequest request )
    {
        Map<String, Object> model = new HashMap<String, Object>( );
        model.put( MARK_DELAY, AppPropertiesService.getProperty( PROPERTY_DELAY ) );
        model.put( MARK_MIN_LENGTH, AppPropertiesService.getProperty( PROPERTY_MIN_LENGTH ) );
        model.put( MARK_TYPES, AppPropertiesService.getProperty( PROPERTY_TYPES ) );
        model.put( MARK_NB_RESULTS, AppPropertiesService.getProperty( PROPERTY_NB_RESULTS ) );
        model.put( MARK_CLIENT_ID, AppPropertiesService.getProperty( PROPERTY_CLIENT_ID ) );
        model.put( MARK_URL, AppPropertiesService.getProperty( PROPERTY_URL ) );

        HtmlTemplate template = AppTemplateService.getTemplate( TEMPLATE_ADRESS_AUTOCOMPLETE, request.getLocale( ), model );
        return template.getHtml( );

    }

}
