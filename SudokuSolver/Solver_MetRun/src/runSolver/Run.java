package runSolver;

import com.majestic.solver.SudokuGenerator;
import com.majestic.solver.SudokuSolver;

public class Run {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] unsolvedPuzzle = SudokuGenerator.generate(18);
		SudokuSolver solver = new SudokuSolver(unsolvedPuzzle);
		solver.solve();
		int[][] solvedPuzzle = solver.getBoard();
		//sudoku late zien
		for (int[] is : solvedPuzzle) {
			for (int i : is) {
				System.out.print(i);
		}
			System.out.println();
		}
	}
}
