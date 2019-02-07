package ls.java.menu;

public class LSMenuItem {
	String itemString;
	char id;
	
	public LSMenuItem(String s, int conflict) {
		itemString= s;
		id = itemString.charAt(conflict);
	}
	
	public String getItemString() {
		return itemString;
	}
	
	public char getItemID() {
		return id;
	}
}
