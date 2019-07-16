package com.bruce.demo.enumerated;

import java.util.Collections;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;

public class Text {
//	public static final int STYLE_BOLD =  1<<0;
//	public static final int STYLE_ITALIC =  1<<1;
//	public static final int STYLE_UNDERLINE =  1<<2;
//	public static final int STYLE_STRIKETHROUGH =  1<<3;
//	
//	public void applyStyles(int styles){
//		System.out.println(styles);
//	}
//	public static void main(String[] args) {
//		Text text = new Text();
//		text.applyStyles(STYLE_UNDERLINE | STYLE_STRIKETHROUGH);
//	}
	public enum Style
	{
		BOLD,ITALIC,UNDERLINE,STRIKETHROUGH	
	}
	
	public void applyStyles(Set<Style> styles)
	{
		for (Style style: styles) {
			System.out.println(style);
		}
	}
	
	public static void main(String[] args) {
		Text text = new Text();
		text.applyStyles(EnumSet.of(Style.BOLD));
		
		Set<Style> set = new HashSet<Style>();
		set.add(Style.STRIKETHROUGH);
		set.add(Style.UNDERLINE);
		System.out.println(set.add(Style.UNDERLINE));;
		text.applyStyles(set);
		
//		set = Collections.unmodifiableSet(set);
//		set.remove(Style.UNDERLINE);
		
	}
}
