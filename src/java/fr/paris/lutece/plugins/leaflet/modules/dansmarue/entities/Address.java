package fr.paris.lutece.plugins.leaflet.modules.dansmarue.entities;

public class Address {
	private String libelleTypo;
	private Double x;
	private Double y;
	private String type;
	private Integer id;
	
	/**
	 * @return the libelleTypo
	 */
	public String getLibelleTypo() {
		return libelleTypo;
	}
	/**
	 * @param libelleTypo the libelleTypo to set
	 */
	public void setLibelleTypo(String libelleTypo) {
		this.libelleTypo = libelleTypo;
	}
	/**
	 * @return the x
	 */
	public Double getX() {
		return x;
	}
	/**
	 * @param x the x to set
	 */
	public void setX(Double x) {
		this.x = x;
	}
	/**
	 * @return the y
	 */
	public Double getY() {
		return y;
	}
	/**
	 * @param y the y to set
	 */
	public void setY(Double y) {
		this.y = y;
	}
	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
}
