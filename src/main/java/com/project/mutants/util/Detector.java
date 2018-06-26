package com.project.mutants.util;

import java.util.ArrayList;
import java.util.List;

public class Detector {

	private char[][] matrix;
	
	public char[][] getMatrix() {
		return matrix;
	}

	public void setMatrix(char[][] matrix) {
		this.matrix = matrix;
	}

	/**
	 * Show Matrix (NxN)
	 */
	public void showMatrix() {

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.print(" " + matrix[i][j] + " ");
			}
			System.out.print("\r\n");
		}
	}
	
	public boolean isMutant(String word) {

		for (int[] pos : possibleSolutionsOf(word)) {

			// Search horizontally to the right.
			String foundWord = wordInMatrix(pos, word.length(), 0, 1);
			if (foundWord.equals(word))
				return true;

			// Search horizontally to the left.
			foundWord = wordInMatrix(pos, word.length(), 0, -1);
			if (foundWord.equals(word))
				return true;

			// Search vertically down.
			foundWord = wordInMatrix(pos, word.length(), 1, 0);
			if (foundWord.equals(word))
				return true;

			// Search vertically up.
			foundWord = wordInMatrix(pos, word.length(), -1, 0);
			if (foundWord.equals(word))
				return true;

			// Search diagonal upper right.
			foundWord = wordInMatrix(pos, word.length(), -1, 1);
			if (foundWord.equals(word))
				return true;

			// Search diagonal upper left.
			foundWord = wordInMatrix(pos, word.length(), -1, -1);
			if (foundWord.equals(word))
				return true;

			// Search lower right diagonal.
			foundWord = wordInMatrix(pos, word.length(), 1, 1);
			if (foundWord.equals(word))
				return true;

			// Search lower left diagonal.
			foundWord = wordInMatrix(pos, word.length(), 1, -1);
			if (foundWord.equals(word))
				return true;
		}
		return false;
	}
	
	public String wordInMatrix(int[] posInicial, int numeroCaracteres, int moveInRow, int moveInColum) {
		String word = "";
		int way = 0, row = posInicial[0], column = posInicial[1];

		while ((way < numeroCaracteres) && (row < matrix.length && column < matrix.length) && (row > -1 && column > -1)) {
			word += matrix[row][column];
			row = row + moveInRow;
			column = column + moveInColum;
			way++;
		}

		return word;
	}
	
	public int[][] possibleSolutionsOf(String word) {
		char firstLetter = word.charAt(0);
		List<int[]> invertedIndex = new ArrayList<int[]>();

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (matrix[i][j] == firstLetter) {
					invertedIndex.add(new int[] { i, j });
				}
			}
		}
		return toArrayInt(invertedIndex);
	}
	
	private int[][] toArrayInt(List<int[]> list) {
		return (int[][]) list.toArray(new int[list.size()][list.get(0).length]);
	}
}
