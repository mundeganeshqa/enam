package com.bikkadit.enam;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	String array[] = {"One", "Two", "Three", "Four"};
    	List<String> list = Arrays.asList(array);
    	list.remove("0");
    	for(String abc:list) {
    		System.out.println(abc);
    	}
    }
}
