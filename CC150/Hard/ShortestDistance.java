package CC150.Hard;
/**
 * 18.5 You have a large text file containing words. 
 * Given any two words, find the shortest distance.
 * Search in O(1) time. What about the space complexity? 
 * 
 * Solution: 
 * 
 * 
 * @author jeffwan
 * @date May 19, 2014
 */
public class ShortestDistance {
	public int shortest(String[] words, String word1, String word2) {
		int min = Integer.MIN_VALUE;
		int[] lastPassword = {-1, -1};
		for (int i = 0; i < words.length; i++) {
			
			String current = words[i];
			if (current.equals(word1)) {
				lastPassword[0] = i;
				int distance = lastPassword[0] - lastPassword[1];
				if (lastPassword[1] >= 0 && min > distance) {
					min = distance;
				}
			} else if (current.equals(word2)) {
				lastPassword[1] = i;
				int distance = lastPassword[1] - lastPassword[0];
				if (lastPassword[0] >= 0 && min > distance) {
					min = distance;
				}
			}
		}
		return min;
	}
}
