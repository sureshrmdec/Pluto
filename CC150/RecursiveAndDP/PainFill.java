package CC150.RecursiveAndDP;

// paint 把 一个point的color 全改成ncolor. 
public class PainFill {
	enum Color {
		Black, White, Red;
	}
	
	boolean painFill(Color[][] screen, int x, int y, Color ocolor, Color ncolor) {
		if (x < 0 || x >= screen[0].length || y < 0 || y >= screen.length) {
			return false;
		}
		
		if (screen[y][x] == ocolor) {
			screen[y][x] = ncolor;
			painFill(screen, x - 1, y, ocolor, ncolor);
			painFill(screen, x + 1, y, ocolor, ncolor);
			painFill(screen, x, y - 1, ocolor, ncolor);
			painFill(screen, x, y + 1, ocolor, ncolor);
		}
		
		return true;
	}
	
	
	boolean painFill(Color[][] screen, int x, int y, Color ncolor) {
		return painFill(screen, x, y, screen[y][x], ncolor);
	}
}
