package utng.model;
import java.io.Serializable;

public class Media implements Serializable {
	private String  id;
	private String x_uuid;
	private String url;
	private String media_type;
	
	public Media(String id, String x_uuid, String url, String media_type) {
		super();
		this.id = id;
		this.x_uuid = x_uuid;
		this.url = url;
		this.media_type = media_type;
	}
	public Media() {
		this("","","","");
		
	}
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return the x_uuid
	 */
	public String getX_uuid() {
		return x_uuid;
	}
	/**
	 * @param x_uuid the x_uuid to set
	 */
	public void setX_uuid(String x_uuid) {
		this.x_uuid = x_uuid;
	}
	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}
	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	/**
	 * @return the media_type
	 */
	public String getMedia_type() {
		return media_type;
	}
	/**
	 * @param media_type the media_type to set
	 */
	public void setMedia_type(String media_type) {
		this.media_type = media_type;
	}
	
	
	
	

}
