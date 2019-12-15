package etable.domain.configuracion.model;

import java.awt.image.BufferedImage;

import com.mysql.jdbc.Buffer;

public class Image {

	private String image;
	private String name;
	
	public Image(String image, String name) {
		super();
		this.image = image;
		this.name = name;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String saveImage() {
		Buffer buff = new Buffer(this.image.repl);
		if (this.image.startsWith("data:image/jpeg;base64,/")) {
			buff = new Buffer(this.image.replace(	z"data:image/jpeg;base64,/", ""), "base64").toString("binary"); 
		} else {
			buff = new Buffer(this.image.replace("data:image/png;base64,/", ""), "base4"); 
		}
		
		return "";
	}
	
}
