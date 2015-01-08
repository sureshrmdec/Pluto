package interview.ebay;

public class Board {
	public static boolean inBoard(char[][] board, String word) {

		for (int i = 0; i < 4; i++)
			for (int j = 0; j < 4; j++)
				if (hasResult(board, word, i, j, 0))
					return true;
		return false;
	}

	public static boolean hasResult(char[][] board, String word, int i, int j, int start) {
		if (board[i][j] != word.charAt(start))
			return false;
		else if (start == word.length() - 1)
			return true;

		for (int k = i - 1; k <= i + 1; k++)
			for (int l = j - 1; l <= j + 1; l++)
				if ((k != i || l != j) && 0 <= k && k < 4 && 0 <= l && l < 4) {
					if (hasResult(board, word, k, l, start + 1))
						return true;
				}
		return false;
	}

	public static void main(String[] args) {
		char[][] tBoard = { { 's', 'm', 'e', 'f' }, { 'r', 'a', 't', 'd' },
				{ 'l', 'o', 'n', 'i' }, { 's', 'm', 'e', 'f' } };
		char[][] boggle = {{'a', 'b', 'c', 'd'}, {'e', 'f', 'g', 'h'},{'i', 'j', 'k', 'l'},{'m', 'n', 'o', 'p'}};
		System.out.println(inBoard(boggle, "ab"));
	}
}
