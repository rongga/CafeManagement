public class menu{
	String name;
	int price;
	int origin;
	String jae;
	
	public menu() {
		name = null;
		price = 0;
		origin = 0;
		jae = null;
	}
	public menu(String n, int p) {
		name = n;
		price = p;
		jae = null;
		origin = 0;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
	
	public void setjae(String jae) {
		this.jae = jae;
	}
	
	public void setOrigin(int origin) {
		this.origin = origin;
	}
	
	public String getjae(int count) {
		return jae;
	}
}
