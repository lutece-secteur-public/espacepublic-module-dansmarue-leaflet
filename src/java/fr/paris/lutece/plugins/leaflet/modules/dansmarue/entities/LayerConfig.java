package fr.paris.lutece.plugins.leaflet.modules.dansmarue.entities;

/**
 * Map config for leaflet use
 *
 */
public class LayerConfig {
	private String layerType;
	private String layerUrl;
	private Integer maxNativeZoom;
	private Integer maxZoom;
	private Integer minZoom;
	private String layerName;
	private String layerBaseMap;
	private Double layerOpacity;
	
	/**
	 * @return the layerType
	 */
	public String getLayerType() {
		return layerType;
	}
	/**
	 * @param layerType the layerType to set
	 */
	public void setLayerType(String layerType) {
		this.layerType = layerType;
	}
	/**
	 * @return the layerUrl
	 */
	public String getLayerUrl() {
		return layerUrl;
	}
	/**
	 * @param layerUrl the layerUrl to set
	 */
	public void setLayerUrl(String layerUrl) {
		this.layerUrl = layerUrl;
	}
	/**
	 * @return the maxNativeZoom
	 */
	public Integer getMaxNativeZoom() {
		return maxNativeZoom;
	}
	/**
	 * @param maxNativeZoom the maxNativeZoom to set
	 */
	public void setMaxNativeZoom(Integer maxNativeZoom) {
		this.maxNativeZoom = maxNativeZoom;
	}
	/**
	 * @return the maxZoom
	 */
	public Integer getMaxZoom() {
		return maxZoom;
	}
	/**
	 * @param maxZoom the maxZoom to set
	 */
	public void setMaxZoom(Integer maxZoom) {
		this.maxZoom = maxZoom;
	}
	/**
	 * @return the minZoom
	 */
	public Integer getMinZoom() {
		return minZoom;
	}
	/**
	 * @param minZoom the minZoom to set
	 */
	public void setMinZoom(Integer minZoom) {
		this.minZoom = minZoom;
	}
	/**
	 * @return the layerName
	 */
	public String getLayerName() {
		return layerName;
	}
	/**
	 * @param layerName the layerName to set
	 */
	public void setLayerName(String layerName) {
		this.layerName = layerName;
	}
	/**
	 * @return the layerBaseMap
	 */
	public String getLayerBaseMap() {
		return layerBaseMap;
	}
	/**
	 * @param layerBaseMap the layerBaseMap to set
	 */
	public void setLayerBaseMap(String layerBaseMap) {
		this.layerBaseMap = layerBaseMap;
	}
	public Double getLayerOpacity() {
		return layerOpacity;
	}
	public void setLayerOpacity(Double layerOpacity) {
		this.layerOpacity = layerOpacity;
	}
}
