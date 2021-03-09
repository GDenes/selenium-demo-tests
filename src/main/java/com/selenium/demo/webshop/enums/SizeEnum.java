package com.selenium.demo.webshop.enums;

public enum SizeEnum {
	S("S"),
	M("M"),
	L("L");

	public final String string;
	
	private SizeEnum(String string) {
		this.string = string;
	}
	
	public String getText() {
		return string;
	}
}
