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
package com.sliit.gui.general;

// imports
import java.util.ArrayList;

import com.sliit.entities.User;

// class implementation
interface EntityWindow {
	
	void initialize(User user);
	<E> void getTable(ArrayList<E> itemList);

}
