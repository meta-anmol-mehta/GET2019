public class KnightProblem {
	int[][] chessboard;
	int pathCovered = 0;

	public KnightProblem(int N) {
		chessboard = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				chessboard[i][j] = 0;
			}
		}
	}

	public boolean solve() {
		
		if (findPath(0, 0, 0, chessboard.length)) {
			print();
			return true;
		} else {
			System.out.println("NO PATH FOUND");
			return false;
		}
	}

	public boolean findPath(int row, int column, int index, int N) {
		// check if current is not used already
		if (chessboard[row][column] != 0) {
			return false;
		}
		// mark the current cell is as used
		chessboard[row][column] = pathCovered++;
		// if (index == 50) {
		if (index == N * N - 1) {
			// if we are here means we have solved the problem
			return true;
		}
		// try to solve the rest of the problem recursively

		// go down and right
		if (canMove(row + 2, column + 1, N) && findPath(row + 2, column + 1, index + 1, N)) {
			return true;
		}
		// go right and down
		if (canMove(row + 1, column + 2, N) && findPath(row + 1, column + 2, index + 1, N)) {
			return true;
		}
		// go right and up
		if (canMove(row - 1, column + 2, N) && findPath(row - 1, column + 2, index + 1, N)) {
			return true;
		}
		// go up and right
		if (canMove(row - 2, column + 1, N) && findPath(row - 2, column + 1, index + 1, N)) {
			return true;
		}
		// go up and left
		if (canMove(row - 2, column - 1, N) && findPath(row - 2, column - 1, index + 1, N)) {
			return true;
		}
		// go left and up
		if (canMove(row - 1, column - 2, N) && findPath(row - 1, column - 2, index + 1, N)) {
			return true;
		}
		// go left and down
		if (canMove(row + 1, column - 2, N) && findPath(row + 1, column - 2, index + 1, N)) {
			return true;
		}
		// go down and left
		if (canMove(row + 2, column - 1, N) && findPath(row + 2, column - 1, index + 1, N)) {
			return true;
		}
		// if we are here means nothing has worked , backtrack
		chessboard[row][column] = 0;
		pathCovered--;
		return false;

	}

	public boolean canMove(int row, int col, int N) {
		if (row >= 0 && col >= 0 && row < N && col < N) {
			return true;
		}
		return false;
	}

	public void print() {
		for (int i = 0; i < chessboard.length; i++) {
			for (int j = 0; j < chessboard.length; j++) {
				System.out.print("   " + chessboard[i][j]);
			}
			System.out.println();
		}
	}

}