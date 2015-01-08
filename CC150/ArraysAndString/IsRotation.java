package CC150.ArraysAndString;

/**
 * 
 * 1.8 Given two string, s1 and s2, write code to check if s2 is a ratation of s1 using only one call to isSubstring() 
 * eg: "waterbottle" is a rotation of "erbottlewat" 
 *
 */
public class IsRotation {

	public boolean isRotation2(String s1, String s2) {
		if (s1.length() == 0 || s2.length() == 0 ||(s1.length() != s2.length())) {
			return false;
		}
		
		String newStr =  s1.concat(s1);  
		return isSubstring(newStr, s2);
	}

	//helper
	private boolean isSubstring(String newStr, String s2) {
		return false;
	}
}
