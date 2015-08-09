package com.kasonyang.kava.model

class VarObject {
	String name
	String type
	Object value
	Boolean isConst
	
	String toString(){
		return type + ":" + value
	}
}
