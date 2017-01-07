package com.jiaxin.company.fb.onsite;

import org.junit.Test;

/**
 * Given a string that which is in JSON format, print it in a human readable way. 
 * For example" {'a':'1', 'b':['c':'2','d':'3']}" should output:
 *  a:1
    b:[
      c:2
      d:3
      ]
 * @author jiashan
 *
 */
public class JSONBeautify {
	// http://www.meetqun.com/forum.php?mod=viewthread&tid=5589&extra=page%3D1%26filter%3Dtypeid%26typeid%3D1
	public String prettyJSON(String input){
		StringBuilder sb = new StringBuilder();
		
		int i = 0;
		int space = 0;
		
		while (i < input.length()) {
			int j = 0;
			// pre tab
			while (j < space) {
				sb.append(" ");
				j++;
			}
			
			while (i < input.length()) {
				char c = input.charAt(i);
				if (isLeftBracket(c)) {
					sb.append(c);
					sb.append('\n');
					space += 2;
					i++;
					break;
				} else if (c == ','){
					sb.append('\n');
					i++;
					break;
				} else if (isRightBracket(c)) {
					sb.append('\n');
					space -= 2;
					int k = 0;
					while (k < space) {
						sb.append(' ');
						k++;
					}
					sb.append(c);
					i++;
					break;
				} else if (c == '\'') {
					i++;
				} else {
					sb.append(c);
					i++;
				}
			}
		}
		
		return sb.toString();
	}

	private boolean isLeftBracket(char c) {
		return c == '{' || c == '[';
	}
	
	private boolean isRightBracket(char c) {
		return c == '}' || c == ']';	
	}
	
	@Test
	public void test() {
		String input = "{'meau':{'id':'file','value':'File'," +
				"'popup':{'menuitem':[{'value':'new','onclick':'CreateNewDoc()'}," +
				"{'value':'Open','onclick':'OpenDoc()'}]}}}";
		
		System.out.println(prettyJSON(input));
	}
	
	
}
