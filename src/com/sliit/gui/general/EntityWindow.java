/*
 * Class Name : EntityWindow
 * Interface
 *
 * Version info : ~
 *
 * Copyright notice
 * Author Name : Bandara K. M. D. I.
 */

// package
package com.sliit.gui.general;

// imports
import java.util.ArrayList;

import com.sliit.entity.User;

// interface implementation
interface EntityWindow {
	
	// ensures that this method is implemented
	void initialize(User user);
	<E> void getTable(ArrayList<E> itemList);

}
