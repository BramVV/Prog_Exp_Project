package Solver;

import javax.swing.*;

import static javax.swing.JOptionPane.*;

/**
 * @author raido
 */
public class Solution {

    private Cells cells;

    public Solution(Cells cells) {
        this.cells = cells;
        int size = cells.getSize();
        long start = System.currentTimeMillis();
        if (IsValid()) {
            if (solve(size, 0)) {
                System.out.println("Solution found in " + (System.currentTimeMillis() - start) + " ms!");
                output();
            }
        } else {
            showMessageDialog(null, "The input is not valid", "Unvalid input", ERROR_MESSAGE);
        }
    }


    public void output() {
        cells.output();
    }

    public Cells getCells() {
        return cells;
    }

    private boolean solve(int size, int count) {
        int row = count / size;
        int col = count % size;
        if (count++ == (size * size)) return true;
        if (cells.getCell(row, col) == 0) { // is cell preset or not?
            for (int val = 1; val <= size; val++) { // loop through valid values
                if (isLegal(row, col, val)) { // can this value be put in current cell
                    cells.setCell(row, col, val); // sets cell's value
                    if (solve(size, count)) return true;
                }
            } // end of loop through valid values
            cells.setCell(row, col, 0); // didn't find suitable value, reset cell
        } else { // next cell if this one is not empty
            if (solve(size, count)) return true;
        }
        return false;
    }

    private Boolean IsValid() {
        //horizontal check
        for (int[] rowOfCells : cells.getCells()) {
            int[] count = new int[9];
            for (int CellValue : rowOfCells) {
                if (CellValue != 0) {
                    count[CellValue] += 1;
                    if (count[CellValue] != 1) {
                        return false;
                    }
                }
            }
        }
        //Vertical Check
        for (int i = 0; i < 9; i++) {
            int[] count = new int[9];
            for (int j = 0; j < 9; j++) {
                if (cells.getCell(j, i) != 0) {
                    count[cells.getCell(j, i)] += 1;
                    if (count[cells.getCell(j, i)] != 1) {
                        return false;
                    }
                }
            }
        }
        //3x3 check
        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                int[] count = new int[9];
                for (int k = 0; k < 3; k++) {
                    for (int l = 0; l < 3; l++) {
                        if (cells.getCell(k + i, l + j) != 0) {
                            count[cells.getCell(k + i, l + j)] += 1;
                            if (count[cells.getCell(k + i, l + j)] != 1) {
                                return false;
                            }
                        }
                    }
                }
            }
        }
        return true;
    }

    private boolean isLegal(int row, int col, int value) {
        int i = 0, j = 0;
        int top = row / 3;
        int left = col / 3;
        for (int[] rowOfCells : cells.getCells()) {
            for (int cellValue : rowOfCells) {
                if ((j == row || i == col || (left == i / 3 && top == j / 3)) && cellValue == value) {
                    return false;
                }
                i++;
            }
            j++;
            i = 0;
        }
        return true;
    }

}
