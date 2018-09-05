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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;

import fr.paris.lutece.plugins.leaflet.modules.dansmarue.entities.LayerConfig;
import fr.paris.lutece.portal.service.template.AppTemplateService;
import fr.paris.lutece.portal.service.util.AppPropertiesService;
import fr.paris.lutece.portal.web.admin.PluginAdminPageJspBean;
import fr.paris.lutece.util.html.HtmlTemplate;

public abstract class LeafletDansMaRueJspBean extends PluginAdminPageJspBean{

    /**
     *
     */
    private static final long serialVersionUID = 7030522625985545691L;

    //PROPERTIES
    protected String APP_NAME;

    protected static final String PROPERTY_RADIUS = "leaflet.position.radius";

    protected static final String PROPERTY_INITAL_BOTTOM_BOUND = "leaflet.initial.bottom.bound";
    protected static final String PROPERTY_INITAL_LEFT_BOUND = "leaflet.initial.left.bound";
    protected static final String PROPERTY_INITAL_TOP_BOUND = "leaflet.initial.top.bound";
    protected static final String PROPERTY_INITAL_RIGHT_BOUND = "leaflet.initial.right.bound";

    protected static final String PROPERTY_MAX_BOTTOM_BOUND = "leaflet.max.bottom.bound";
    protected static final String PROPERTY_MAX_LEFT_BOUND = "leaflet.max.left.bound";
    protected static final String PROPERTY_MAX_TOP_BOUND = "leaflet.max.top.bound";
    protected static final String PROPERTY_MAX_RIGHT_BOUND = "leaflet.max.right.bound";

    protected static final String PROPERTY_MAX_NATIVE_ZOOM = "leaflet.max.native.zoom";
    protected static final String PROPERTY_MAX_ZOOM = "leaflet.max.zoom";
    protected static final String PROPERTY_MIN_ZOOM = "leaflet.min.zoom";

    protected static final String PROPERTY_SHOW_METRIC = "leaflet.show.metric";
    protected static final String PROPERTY_SHOW_IMPERIAL = "leaflet.show.imperial";

    protected static final String PROPERTY_LAYER_TYPE = "layers.layer.type";
    protected static final String PROPERTY_LAYER_NAME = "layers.layer.name";
    protected static final String PROPERTY_LAYER_URL = "layers.layer.url";
    protected static final String PROPERTY_LAYER_BASE_MAP = "layers.layer.basemap";
    protected static final String PROPERTY_LAYER_OPACITY = "layers.layer.opacity";

    protected static final String PROPERTY_LAYERS_COUNT = "layers.count";

    //MARKERS
    protected static final String MARK_RADIUS = "position_radius";

    protected static final String MARK_INITIAL_BOTTOM_BOUND = "initial_bottom_bound";
    protected static final String MARK_INITIAL_LEFT_BOUND = "initial_left_bound";
    protected static final String MARK_INITIAL_TOP_BOUND = "initial_top_bound";
    protected static final String MARK_INITIAL_RIGHT_BOUND = "initial_right_bound";

    protected static final String MARK_MAX_BOTTOM_BOUND = "max_bottom_bound";
    protected static final String MARK_MAX_LEFT_BOUND = "max_left_bound";
    protected static final String MARK_MAX_TOP_BOUND = "max_top_bound";
    protected static final String MARK_MAX_RIGHT_BOUND = "max_right_bound";

    protected static final String MARK_MAX_NATIVE_ZOOM = "max_native_zoom";
    protected static final String MARK_MAX_ZOOM = "max_zoom";
    protected static final String MARK_MIN_ZOOM = "min_zoom";

    protected static final String MARK_SHOW_METRIC = "show_metric";
    protected static final String MARK_SHOW_IMPERIAL= "show_imperial";

    protected static final String MARK_LAYER_TYPE = "layer_type";
    protected static final String MARK_LAYER_NAME = "layer_name";
    protected static final String MARK_LAYER_URL = "layer_url";
    protected static final String MARK_LAYER_BASE_MAP = "layer_base_map";

    protected static final String MARK_LAYERS_COUNT = "layers_count";
    protected static final String MARK_LAYERS_CONFIG = "layers_config";

    protected static final Double DEFAULT_OPACITY = 1.0;

    //TEMPLATES
    protected static final String TEMPLATE_LEAFTLET_MAP = "admin/plugins/leaflet/modules/dansmarue/leaflet_map.html";

    protected LeafletDansMaRueJspBean(){
    }

    /**
     * Gets the leaflet map template
     * @param request
     *            the HTTP request
     * @return the JSP return
     */
    public String getMap(HttpServletRequest request){
        Map<String,Object> model = new HashMap<String,Object>();

        model.put(MARK_RADIUS, getLeafletDansMaRueProperty(PROPERTY_RADIUS));

        model.put(MARK_INITIAL_BOTTOM_BOUND, getLeafletDansMaRueProperty(PROPERTY_INITAL_BOTTOM_BOUND));
        model.put(MARK_INITIAL_LEFT_BOUND, getLeafletDansMaRueProperty(PROPERTY_INITAL_LEFT_BOUND));
        model.put(MARK_INITIAL_RIGHT_BOUND, getLeafletDansMaRueProperty(PROPERTY_INITAL_RIGHT_BOUND));
        model.put(MARK_INITIAL_TOP_BOUND, getLeafletDansMaRueProperty(PROPERTY_INITAL_TOP_BOUND));

        model.put(MARK_MAX_BOTTOM_BOUND, getLeafletDansMaRueProperty(PROPERTY_INITAL_BOTTOM_BOUND));
        model.put(MARK_MAX_LEFT_BOUND, getLeafletDansMaRueProperty(PROPERTY_INITAL_LEFT_BOUND));
        model.put(MARK_MAX_RIGHT_BOUND, getLeafletDansMaRueProperty(PROPERTY_INITAL_RIGHT_BOUND));
        model.put(MARK_MAX_TOP_BOUND, getLeafletDansMaRueProperty(PROPERTY_INITAL_TOP_BOUND));

        model.put(MARK_MAX_NATIVE_ZOOM, getLeafletDansMaRueProperty(PROPERTY_MAX_NATIVE_ZOOM));
        model.put(MARK_MAX_ZOOM, getLeafletDansMaRueProperty(PROPERTY_MAX_ZOOM));
        model.put(MARK_MIN_ZOOM, getLeafletDansMaRueProperty(PROPERTY_MIN_ZOOM));

        model.put(MARK_SHOW_METRIC, getLeafletDansMaRueProperty(PROPERTY_SHOW_METRIC));
        model.put(MARK_SHOW_IMPERIAL, getLeafletDansMaRueProperty(PROPERTY_SHOW_IMPERIAL));

        int layersCount = getLeafletDansMaRuePropertyInt(PROPERTY_LAYERS_COUNT);

        model.put(MARK_LAYERS_COUNT, layersCount);

        List<LayerConfig> layersConfigs = new ArrayList<>();
        for(int i=0;i<layersCount;i++){
            LayerConfig layerConfig = new LayerConfig();
            layerConfig.setLayerBaseMap(getLeafletDansMaRueProperty(PROPERTY_LAYER_BASE_MAP+ "." +i));
            layerConfig.setLayerType(getLeafletDansMaRueProperty(PROPERTY_LAYER_TYPE+ "." +i));
            layerConfig.setLayerName(getLeafletDansMaRueProperty(PROPERTY_LAYER_NAME+ "." +i));
            layerConfig.setLayerUrl(getLeafletDansMaRueProperty(PROPERTY_LAYER_URL+ "." +i));
            String opacity = getLeafletDansMaRueProperty(PROPERTY_LAYER_OPACITY+ "." +i);
            if(StringUtils.isBlank(opacity)){
                layerConfig.setLayerOpacity(DEFAULT_OPACITY);
            }else{
                layerConfig.setLayerOpacity(Double.parseDouble(opacity));
            }
            layersConfigs.add(layerConfig);
        }

        model.put(MARK_LAYERS_CONFIG, layersConfigs);

        HtmlTemplate template = AppTemplateService.getTemplate(TEMPLATE_LEAFTLET_MAP,request.getLocale(),model);
        return template.getHtml();
    }

    /**
     * Getter for the application property
     * @param property
     * @return
     */
    private String getLeafletDansMaRueProperty(String property){
        return AppPropertiesService.getProperty(APP_NAME+"."+property);
    }


    /**
     * Getter for the application property int
     * @param property
     * @return the int property
     */
    private int getLeafletDansMaRuePropertyInt(String property){
        return AppPropertiesService.getPropertyInt(APP_NAME+"."+property,0);
    }

}
