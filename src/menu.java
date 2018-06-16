
public class menu{
	String name;
	int price;
	int origin;
	jaeryo[] jae = new jaeryo[100];
	int jaecount;
	
	public menu() {
		name = null;
		price = 0;
		origin = 0;
		jae = null;
		jaecount = 0;
	}
	public menu(String n, int p) {
		name = n;
		price = p;
		jae = null;
		jaecount = 0;
		origin = 0;
	}
}
