package etable.domain.configuracion.model;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Base64;


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
		if (this.name != null && this.image != null) {
			String path = "src/../../eTable-web/src/assets/logo-emp/";
			String pathName = "/assets/logo-emp/" + this.name;
			try {
				String imageByte = new String(image.substring(image.indexOf(",") + 1));
				File filePath = new File(path, this.name);
		        FileOutputStream fos=new FileOutputStream(filePath.getPath());
		        fos.write(decodeImage(imageByte));
		        fos.close();
		      }
		      catch (java.io.IOException e) {
		    	  pathName = "";
		      }
			return pathName;
		} else {
			return "";
		}
	}
	
	public  byte[] decodeImage(String imageByte) {
		byte[] decodedString = Base64.getDecoder().decode(new String(imageByte).getBytes());
		return decodedString;
	}
	
	
}
