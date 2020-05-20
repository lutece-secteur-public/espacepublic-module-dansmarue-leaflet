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
 * Address.
 */
public class Address
{
    
    /** The str libelle typo. */
    private String  _strLibelleTypo;
    
    /** The x. */
    private Double  _x;
    
    /** The y. */
    private Double  _y;
    
    /** The str type. */
    private String  _strType;
    
    /** The n id. */
    private Integer _nId;

    /**
     * Gets the libelle typo.
     *
     * @return the libelleTypo
     */
    public String getLibelleTypo( )
    {
        return _strLibelleTypo;
    }

    /**
     * Sets the libelle typo.
     *
     * @param strLibelleTypo            the libelleTypo to set
     */
    public void setLibelleTypo( String strLibelleTypo )
    {
        _strLibelleTypo = strLibelleTypo;
    }

    /**
     * Gets the x.
     *
     * @return the x
     */
    public Double getX( )
    {
        return _x;
    }

    /**
     * Sets the x.
     *
     * @param x            the x to set
     */
    public void setX( Double x )
    {
        _x = x;
    }

    /**
     * Gets the y.
     *
     * @return the y
     */
    public Double getY( )
    {
        return _y;
    }

    /**
     * Sets the y.
     *
     * @param y            the y to set
     */
    public void setY( Double y )
    {
        _y = y;
    }

    /**
     * Gets the type.
     *
     * @return the type
     */
    public String getType( )
    {
        return _strType;
    }

    /**
     * Sets the type.
     *
     * @param strType            the type to set
     */
    public void setType( String strType )
    {
        _strType = strType;
    }

    /**
     * Gets the id.
     *
     * @return the id
     */
    public Integer getId( )
    {
        return _nId;
    }

    /**
     * Sets the id.
     *
     * @param nId            the id to set
     */
    public void setId( Integer nId )
    {
        _nId = nId;
    }
}
