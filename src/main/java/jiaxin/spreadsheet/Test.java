package jiaxin.spreadsheet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Test {
	public static void main(String[] args) throws IOException {
		
		List<String> list = new ArrayList<String>();
		list.add("1");
		list.add("2");
		list.add("3");
		list.add("4");
		
		System.out.println(list.subList(1, list.size()));
	}
	
}
