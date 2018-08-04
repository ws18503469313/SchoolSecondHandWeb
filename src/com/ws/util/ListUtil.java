package com.ws.util;

import java.util.ArrayList;
import java.util.List;

public class ListUtil<T> {
	
	public static void main(String[] args) {
		List<Integer> numberlist = new ArrayList<Integer>();
		for (int i = 0; i < 5; i++) {
			numberlist.add(i);
		}
		System.out.println(numberlist.toString());
		numberlist = reviseList(numberlist);
		System.out.println(numberlist.toString());
	}
	
	public static<T> List<T> reviseList(List<T> list){
		T t;
		int time = list.size()/2;
		int length = list.size()-1;
		for(int i = 0; i<time; i++){
			t = list.get(i);
			list.set(i, list.get(length-i));
			list.set(length-i, t);
		}
		return list;
	}
	
}
