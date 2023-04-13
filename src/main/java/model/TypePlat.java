package model;

public class TypePlat {
	
	private int id_type;
	private String type;
	private String image;
	
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public int getId_type() {
		return id_type;
	}
	public void setId_type(int id_type) {
		this.id_type = id_type;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	

	@Override
	public String toString() {
		return "TypePlat [id_type=" + id_type + ", type=" + type + ", image=" + image + "]";
	}
	public TypePlat() {
		super();
	}
	
	
	public TypePlat(int id_type, String type, String image) {
		super();
		this.id_type = id_type;
		this.type = type;
		this.image = image;
	}
	
	
	public TypePlat( String type, String image) {
		super();
		
		this.type = type;
		this.image = image;
	}
	
	
	
}
