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
package fr.paris.lutece.plugins.leaflet.modules.dansmarue.entities;

/**
 *
 * Address
 *
 */
public class Address
{
    private String  _strLibelleTypo;
    private Double  _x;
    private Double  _y;
    private String  _strType;
    private Integer _id;

    /**
     * @return the libelleTypo
     */
    public String getLibelleTypo( )
    {
        return _strLibelleTypo;
    }

    /**
     * @param libelleTypo
     *            the libelleTypo to set
     */
    public void setLibelleTypo( String libelleTypo )
    {
        _strLibelleTypo = libelleTypo;
    }

    /**
     * @return the x
     */
    public Double getX( )
    {
        return _x;
    }

    /**
     * @param x
     *            the x to set
     */
    public void setX( Double x )
    {
        _x = x;
    }

    /**
     * @return the y
     */
    public Double getY( )
    {
        return _y;
    }

    /**
     * @param y
     *            the y to set
     */
    public void setY( Double y )
    {
        _y = y;
    }

    /**
     * @return the type
     */
    public String getType( )
    {
        return _strType;
    }

    /**
     * @param type
     *            the type to set
     */
    public void setType( String type )
    {
        _strType = type;
    }

    /**
     * @return the id
     */
    public Integer getId( )
    {
        return _id;
    }

    /**
     * @param id
     *            the id to set
     */
    public void setId( Integer id )
    {
        _id = id;
    }
}
