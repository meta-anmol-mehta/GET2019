
public class QueensProblem {

	private int matrixDimension;

	public QueensProblem(int matrixDimension) {

		this.matrixDimension = matrixDimension;

	}

	/**
	 * to print solution
	 * 
	 * @param board A 2D array that represent ChessBoard of N*N
	 */
	void printSolution(int queenMatrix[][]) {
		for (int i = 0; i < matrixDimension; i++) {
			for (int j = 0; j < matrixDimension; j++)
				System.out.print(" " + queenMatrix[i][j] + " ");
			System.out.println();
		}
	}

	/**
	 * to check if a queen can be placed on board[row][col]
	 * 
	 * @param board a 2D array where we have to check at position [row] [col]
	 * @param row   integer value
	 * @param col   integer value
	 * @return true if the Queen can be placed on board at location [row][col]
	 */
	protected boolean checkPosition(int[][] queenMatrix, int row, int column) {

		for (int i = 0; i < column; ++i) {
			if (queenMatrix[row][i] == 1) {
				return false;
			}
		}

		for (int i = row, j = column; i >= 0 && j >= 0; i--, j--)
			if (queenMatrix[i][j] == 1)
				return false;

		for (int i = row, j = column; j >= 0 && i < matrixDimension; i++, j--)
			if (queenMatrix[i][j] == 1)
				return false;

		return true;

	}

	/**
	 * 
	 * @param board integer Array
	 * @param col   integer
	 * @return true if Queen can be placed in the col
	 */

	protected boolean QueensUtilSolution(int[][] queenMatrix, int column) {
		if (column == matrixDimension) {
			return true;
		} else {

			for (int i = 0; i < matrixDimension; ++i) {

				if (checkPosition(queenMatrix, i, column)) {
					queenMatrix[i][column] = 1;
					if (QueensUtilSolution(queenMatrix, column + 1)) {
						return true;
					}
					queenMatrix[i][column] = 0;
				}
			}

		}

		return false;
	}

	/**
	 * @return true if the solution Exist
	 */

	protected boolean solveNQ(int[][] queenMatrix, int column) {

		if (matrixDimension == 3 || matrixDimension == 2) {
			throw new AssertionError("n queen is not possible for this");
		} else if (queenMatrix.length < 1) {
			throw new AssertionError("array is empty");
		} else {
			if (!QueensUtilSolution(queenMatrix, column)) {
				return false;
			} else {
				printSolution(queenMatrix);
				return true;
			}
		}
	}

}
