package ls.java.menu;

import java.util.Scanner;

public class LSMenu {
	public static final int MAX_ITEMS = 10;
	public static final int MENU_ITEM_ERROR = -1;
	
	String menuTitle = "Choose: ";
	LSMenuItem[] menu = new LSMenuItem[MAX_ITEMS];
	int nItems = 0;
	Scanner scan = new Scanner(System.in);
	
	public LSMenu(String title) {
		menuTitle = title;
	}
	
	public void addItem(String s) {
		int conflict = 0;
		if (nItems == MAX_ITEMS) {
			System.out.println("Menu overflow");
			return;
		}
		
		// Checking if there's already an item with the same ID character, and if so saying what character is the first
		// unused character, then stores it in menu[] and creates it along with its ID
		// ID is only used for LSLetterMenu, but LSMenu items have IDs as well
		for (int i = 0; i < nItems; i++) {
			if (s.charAt(0) == menu[i].getItemID()) {
				// if there's a conflict with the first letter
				conflict = 1;
				//if there's a conflict with the second letter of ANY string
				for (int z = 0; z < nItems; z++) {
					if (s.charAt(1) == menu[z].getItemID()) {
						conflict = 2;
					}
				}
			}
		}
		menu[nItems] = new LSMenuItem(s, conflict);
		nItems++;
	}
	
	String displayMenuItem(int i) {
		return (i + 1) + ") " + menu[i].getItemString() + " ";
	}
	
	int lookUpMenuItem(String s) {
		int choice;
		try {
			choice = Integer.valueOf(s);
		} catch (Exception e) {
			return MENU_ITEM_ERROR;
		}
		if (choice > 0 && choice <= nItems) {
			return choice;
		} else {
			return MENU_ITEM_ERROR;
		}
	}
	
	public int displayAndChoose() {
		boolean valid = false;
		int choice;
		do {
			System.out.println(menuTitle);
			for (int i = 0; i < nItems; i++) {
				System.out.println(displayMenuItem(i));
			}
			String input = scan.next();
			choice = lookUpMenuItem(input);
			valid = choice != MENU_ITEM_ERROR;
		} while (!valid);
		return choice;
	}
	
	// Prints out the options on a single line instead of a new line per option
	public int displayAndChooseSingleLine() {
		boolean valid = false;
		String finalStr;
		int choice;
		
		// Basically combine all the ItemStrings and the menu title into one big string and then print it
		do {
			finalStr = menuTitle;
			for (int i = 0; i < nItems; i++) {
				finalStr += displayMenuItem(i);
			}
			System.out.println(finalStr);
			String input = scan.next();
			choice = lookUpMenuItem(input);
			valid = choice != MENU_ITEM_ERROR;
		} while (!valid);
		return choice;
	}
}
