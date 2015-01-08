package com.jiaxin.company.yelp;
/**
 *  1. given an array of intervals, return max number of non-overlapping intervals   View Answer
 *  2.FizzBuzz
 *  
 *  3. How to find the only different number in two unsorted arrays?
 *  4. How to design a request dispatcher for load balancing?
 *  5. Write code to generate all possible case combinations of a given lower-cased string. (e.g. "0ab" -> ["0ab", "0aB", "0Ab", "0AB"])   
 * @author jeffwan
 * @date May 15, 2014
 */
public class Part7 {

	// 4. 
	
	public static void permute(int level, String permuted, boolean used[],
			String original) {
		int length = original.length();
		if (level == length) {
			System.out.println(permuted);
		} else {
			for (int i = 0; i < length; i++) {
				if (!used[i]) {
					used[i] = true;
					permute(level + 1, permuted + original.charAt(i), used,
							original);
					used[i] = false;
				}
			}
		}
	}

	public static void main(String[] args) {
		String s = "hello";
		boolean used[] = { false, false, false, false, false };
		permute(0, "", used, s);
	}
	
	/*
	Response.Status = "302 Found";
	Response.StatusCode = 302;
	Response.AddHeader("Location", servers[DateTime.Now.Millisecond % 2]);
	
	static string[] servers =
        {
            "http://192.168.0.77/luminji2/aspx/test3.aspx",
            "http://192.168.0.77/luminji2/aspx/test4.aspx"
        };
protected void Page_Load(object sender, EventArgs e)
{
    Response.Redirect(servers[DateTime.Now.Millisecond % 2]);
}

 	*/
	
}
