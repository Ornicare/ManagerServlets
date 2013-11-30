package com.ornilabs.common;

import java.util.ArrayList;
import java.util.List;

public class Data {

	private static List<Action> actionList = new ArrayList<Action>();
	
	public static List<Action> getActionList() {
		return actionList;
	}
	
	public static void addAction(Action a) {
		actionList.add(a);
	}

}
