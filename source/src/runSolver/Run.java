package runSolver;

import java.util.Scanner;

import com.majestic.solver.SudokuGenerator;
import com.majestic.solver.SudokuSolver;

public class Run {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		System.out.println("Hoeveel Onbekende?");
		int onb = s.nextInt();
		int[][] unsolvedPuzzle = SudokuGenerator.generate(onb);
		DisplaySudoku(unsolvedPuzzle);
		System.out.println("Druk enter om op te lossen.");
		s.nextLine();
		s.nextLine();
		SudokuSolver solver = new SudokuSolver(unsolvedPuzzle);
		solver.solve();
		int[][] solvedPuzzle = solver.getBoard();
		DisplaySudoku(solvedPuzzle);
	}

	private static void DisplaySudoku(int[][] Puzzle) {
		int count2 = 0;
		for (int[] is : Puzzle) {
			if (count2 % 3 == 0) {
				System.out.println("---------------------------");
			}
			int count = 1;
			System.out.print(" | ");
			for (int i : is) {
				System.out.print(i + " ");
				if (count % 3 == 0) {
					System.out.print("| ");
				}
				count++;
			}
			count2++;
			System.out.println();
		}
		System.out.println("---------------------------");
	}

}
