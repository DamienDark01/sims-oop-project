/*
 * Class Name : EntityWindow
 * Interface
 *
 * Version info : ~
 *
 * Copyright notice
 * Author Name : 
 * Author Reg No :
 */

// package
package project;

import java.util.ArrayList;

// class implementation
public interface EntityWindow {
	
	void initialize(User user);
	<E> void getTable(ArrayList<E> itemList);

}
