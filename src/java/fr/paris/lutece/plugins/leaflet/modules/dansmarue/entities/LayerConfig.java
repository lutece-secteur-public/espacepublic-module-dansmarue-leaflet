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
package fr.paris.lutece.plugins.leaflet.modules.dansmarue.entities;


/**
 * Map config for leaflet use.
 */
public class LayerConfig
{
    
    /** The str layer type. */
    private String  _strLayerType;
    
    /** The str layer url. */
    private String  _strLayerUrl;
    
    /** The max native zoom. */
    private Integer _maxNativeZoom;
    
    /** The max zoom. */
    private Integer _maxZoom;
    
    /** The min zoom. */
    private Integer _minZoom;
    
    /** The str layer name. */
    private String  _strLayerName;
    
    /** The str layer base map. */
    private String  _strLayerBaseMap;
    
    /** The layer opacity. */
    private Double  _layerOpacity;

    /**
     * Gets the layer type.
     *
     * @return the layerType
     */
    public String getLayerType( )
    {
        return _strLayerType;
    }

    /**
     * Sets the layer type.
     *
     * @param layerType            the layerType to set
     */
    public void setLayerType( String layerType )
    {
        _strLayerType = layerType;
    }

    /**
     * Gets the layer url.
     *
     * @return the layerUrl
     */
    public String getLayerUrl( )
    {
        return _strLayerUrl;
    }

    /**
     * Sets the layer url.
     *
     * @param layerUrl            the layerUrl to set
     */
    public void setLayerUrl( String layerUrl )
    {
        _strLayerUrl = layerUrl;
    }

    /**
     * Gets the max native zoom.
     *
     * @return the maxNativeZoom
     */
    public Integer getMaxNativeZoom( )
    {
        return _maxNativeZoom;
    }

    /**
     * Sets the max native zoom.
     *
     * @param maxNativeZoom            the maxNativeZoom to set
     */
    public void setMaxNativeZoom( Integer maxNativeZoom )
    {
        _maxNativeZoom = maxNativeZoom;
    }

    /**
     * Gets the max zoom.
     *
     * @return the maxZoom
     */
    public Integer getMaxZoom( )
    {
        return _maxZoom;
    }

    /**
     * Sets the max zoom.
     *
     * @param maxZoom            the maxZoom to set
     */
    public void setMaxZoom( Integer maxZoom )
    {
        _maxZoom = maxZoom;
    }

    /**
     * Gets the min zoom.
     *
     * @return the minZoom
     */
    public Integer getMinZoom( )
    {
        return _minZoom;
    }

    /**
     * Sets the min zoom.
     *
     * @param minZoom            the minZoom to set
     */
    public void setMinZoom( Integer minZoom )
    {
        _minZoom = minZoom;
    }

    /**
     * Gets the layer name.
     *
     * @return the layerName
     */
    public String getLayerName( )
    {
        return _strLayerName;
    }

    /**
     * Sets the layer name.
     *
     * @param layerName            the layerName to set
     */
    public void setLayerName( String layerName )
    {
        _strLayerName = layerName;
    }

    /**
     * Gets the layer base map.
     *
     * @return the layerBaseMap
     */
    public String getLayerBaseMap( )
    {
        return _strLayerBaseMap;
    }

    /**
     * Sets the layer base map.
     *
     * @param layerBaseMap            the layerBaseMap to set
     */
    public void setLayerBaseMap( String layerBaseMap )
    {
        _strLayerBaseMap = layerBaseMap;
    }

    /**
     * Gets the layer opacity.
     *
     * @return the layerOpacity
     */
    public Double getLayerOpacity( )
    {
        return _layerOpacity;
    }

    /**
     * Sets the layer opacity.
     *
     * @param layerOpacity            the layerOpacity to set
     */
    public void setLayerOpacity( Double layerOpacity )
    {
        _layerOpacity = layerOpacity;
    }
}
