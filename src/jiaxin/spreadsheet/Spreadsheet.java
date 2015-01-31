package jiaxin.spreadsheet;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;


public class Spreadsheet {
	int mRows;
	int nCols;
	
	private Cell[][] cellMatrix;
	private SpreadsheetHelper helper;
	
	/**
	 * 
	 * Constructor for spreadsheet.
	 * 
	 * @param mRows
	 * @param nCols
	 * @param stringParams
	 */
	public Spreadsheet(int mRows, int nCols, List<String> stringParams) {
		this.mRows = mRows;
		this.nCols = nCols;

		this.cellMatrix = new Cell[mRows][nCols];
		
		for (int i = 0; i < mRows; i++) {
			cellMatrix[i] = new Cell[nCols];
			
			for (int j = 0; j < nCols; j++) {
				cellMatrix[i][j] = new Cell(stringParams.get(i * nCols + j));
			}
		}
	}
	
	public Double[] calSpreadsheet() throws CyclicDependencyException {
		this.helper = generateTopGraph();
		this.helper.solve();
		
		Double[] result = new Double[mRows * nCols];
		for (int i = 0; i < mRows; i++) {
			for (int j = 0; j < nCols; j++) {
				result[i * nCols + j] = cellMatrix[i][j].getValue();
			}
		}
		return result;
		
	}
	
	private SpreadsheetHelper generateTopGraph() {
		SpreadsheetHelper helper = new SpreadsheetHelper(mRows * nCols);
		for (int i = 0; i < mRows; i++) {
			for (int j = 0; j < nCols; j++) {
				Cell cell = cellMatrix[i][j];
				List<String> references = cell.getReferences();
				
				if (references.size() != 0) {
					 for (String reference : references) {
						Cell refCell = getCellFromRef(reference);
						refCell.addDependent(cell);
					}
				} else {
					helper.enqueue(cell);
				}
			}
		}
		return helper;
	}
	
	/**
	 * Helper function to get real value if there's a reference in cell.
	 * @param ref
	 * @return
	 */
	private Cell getCellFromRef(String ref) {
		int row = ref.charAt(0) - 'A';
		int col = Integer.parseInt(ref.substring(1)) - 1;
		return cellMatrix[row][col];
	}

	

	/**
	 * Main function and program entry
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		List<String> stringParams = new ArrayList<String>();
		
		// Read parameters from command pipe
		System.setIn(new FileInputStream("D:/testFile.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String s;
		
		
		while ((s = in.readLine()) != null && s.length() != 0) {
			stringParams.add(s);
		}	
		
		// Get matrix size
		String[] matrixSize = stringParams.get(0).split(" ");
		int nCols = Integer.parseInt(matrixSize[0]);
		int mRows = Integer.parseInt(matrixSize[1]);
		
		// Construct spreadsheet
		Spreadsheet spreadsheet = new Spreadsheet(mRows, nCols, stringParams.subList(1, stringParams.size()));
		Double[] result = spreadsheet.calSpreadsheet();
		
		// output first line(matrix size)
		System.out.println(nCols + " " + mRows);
		
		for (Double line : result) {
			System.out.println(String.format("%.5f", line));
		}
	}
	
	
	

	/**
	 ***********************************************************************************************
	 *                                   Spreadsheet cell class
	 ***********************************************************************************************
	 * @author jiaxin
	 */
	class Cell {
		private String expression;
		private Double value = null;

		private int inDegree = 0;
		private List<Cell> dependents = null;

		Cell(String expression) {
			this.expression = expression;
			this.value = null;
			dependents = new ArrayList<Cell>();
		}

		String getExpression() {
			return expression;
		}

		void setExpression(String expression) {
			this.expression = expression;
		}

		Double getValue() {
			return value;
		}

		List<Cell> getDependents() {
			return dependents;
		}

		void addDependent(Cell cell) {
			dependents.add(cell);
		}

		void setInDegree(int size) {
			inDegree = size;
		}

		boolean decrementInDegreeAndCheckZero() {
			return --inDegree == 0;
		}

		List<String> getReferences() {
			List<String> refs = new ArrayList<String>();
			String[] strs = expression.split(" ");
			for (String str : strs) {
				if (isReference(str)) {
					refs.add(str);
				}
			}
			
			setInDegree(refs.size());
			return refs;
		}

		void computeCell() {
			Stack<Double> stack = new Stack<Double>();
			String[] operands = expression.split(" ");
			
			for (String operand : operands) {
				if (isNumber(operand)) {
					stack.push(Double.parseDouble(operand));
				} else if (isReference(operand)) {
					stack.push(getCellFromRef(operand).getValue());
				} else {
					
					Double a = stack.pop();
					Double b = stack.pop();
					stack.push(calculater(a, b, operand));
				}
			}
			value = stack.pop();
		}

		private Double calculater(Double a, Double b, String operand) {
			Double result = null;
			
			switch (operand.charAt(0)) {
			case '+':
				result = new Double(b + a);
				break;
			case '-':
				result = new Double(b - a);
				break;
			case '*':
				result = new Double(b * a);
				break;
			case '/':
				result = new Double(b / a);
			}
			
			return result;
		}

		private boolean isNumber(String s) {
			String operators = "+-*/";
			return s != null && s.length() > 0 && !operators.contains(s) 
					&& (Character.isDigit(s.charAt(0)) || s.charAt(0) == '.');
		}

		private boolean isReference(String s) {
			return s != null && s.length() >= 2
					&& Character.isUpperCase(s.charAt(0));
		}
	}
	
	/**
	 ***********************************************************************************************
	 *                           Spreadsheet Helper class to solve dependency 
	 ***********************************************************************************************
	 * @author jiaxin
	 */
	class SpreadsheetHelper {
		private int count = 0;
		private int size = 0;
		private Queue<Cell> queue;

		SpreadsheetHelper(int size) {
			this.count = 0;
			this.size = size;
			this.queue = new LinkedList<Cell>();
		}

		void enqueue(Cell cell) {
			queue.offer(cell);
		}

		Cell dequeue() {
			return queue.poll();
		}

		public void solve() throws CyclicDependencyException {
			while (!queue.isEmpty()) {
				Cell cell = queue.poll();
				count++;
				cell.computeCell();
				for (Cell dependency : cell.getDependents()) {
					if (dependency.decrementInDegreeAndCheckZero()) {
						enqueue(dependency);
					}
				}
			}

			if (count < size) {
				throw new CyclicDependencyException("Infinite Cyclic found");
			}
		}
	}
	
	
	/**
	 ***********************************************************************************************
	 *                            Definition Infinite circle Exception
	 ***********************************************************************************************
	 * @author jiaxin
	 */
	class CyclicDependencyException extends RuntimeException {
		public CyclicDependencyException(String message) {
			super(message);
		}
	}
}
