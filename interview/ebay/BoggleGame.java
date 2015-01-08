package interview.ebay;

/**
 * 几个编程细节注意，其实一开始我的思路是完全正确的，但是代码部分没有处理好 1. 接入aba这种往会走的问题，需要一个visited[][]数组 来
 * flag每一个节点， !visited[x][j] 注意是x,y 当前的，不是i,j, 而且放在范围判断后面，否则越界了！ 2.
 * 如何往八个方向走，以current node为中心，一共九个点，弄2层循环就可以，跳过 x=i&&y=j
 * 和visited的点就可以了。如果简易版，上下左右，单独写四个也行。 3.
 * 除了sb来比较最终字符串，不用sb也是可以用，用count来标记多少位即可，当target.charAt(sb.length()) -=
 * boggle[i][j] && count = target.length() - 1. return true; 4.
 * 想减少参数传递的话，boggle, word, visited都可以拿到外面去
 * 
 * @author jeffwan
 * @date May 4, 2014
 */
public class BoggleGame {
	public static void main(String[] args) {
		char[][] boggle = { { 'a', 'b', 'c', 'd' }, { 'e', 'f', 'g', 'h' },
				{ 'i', 'j', 'k', 'l' }, { 'm', 'n', 'o', 'p' } };
		// char[][] tBoard = { { 's', 'm', 'e', 'f' }, { 'r', 'a', 't', 'd' }, {
		// 'l', 'o', 'n', 'i' }, { 's', 'm', 'e', 'f' } };
		String target = "afkh";
		System.out.println(searchResult(boggle, target));
	}

	// Mark visited node --> can't go back
	static boolean[][] visited = new boolean[4][4];

	public static boolean searchResult(char[][] boggle, String target) {
		if (boggle == null || boggle.length == 0 || boggle[0].length == 0) {
			return false;
		}

		for (int i = 0; i < boggle.length; i++) {
			for (int j = 0; j < boggle[i].length; j++) {
				StringBuilder sb = new StringBuilder();
				if (hasResult(boggle, target, i, j, sb)) {
					return true;
				}
			}
		}
		return false;
	}

	private static boolean hasResult(char[][] boggle, String target, int i,
			int j, StringBuilder sb) {
		if (target.charAt(sb.length()) != boggle[i][j]) {
			return false;
		}

		// append
		sb.append(boggle[i][j]);
		visited[i][j] = true;

		if (target.equals(sb.toString())) {
			return true;
		}

		for (int x = i - 1; x <= i + 1; x++) {
			for (int y = j - 1; y <= j + 1; y++) {
				if ((x != i || y != j) && x >= 0 && x < 4 && y >= 0 && y < 4
						&& !visited[x][y]) {
					if (hasResult(boggle, target, x, y, sb)) {
						return true;
					}
				}
			}
		}

		// delete and backtrack
		sb.deleteCharAt(sb.length() - 1);
		visited[i][j] = false;
		return false;
	}
}
