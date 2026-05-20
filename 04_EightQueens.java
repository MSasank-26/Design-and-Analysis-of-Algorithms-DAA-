
// Program 4: Eight Queens Problem using Backtracking

public class EightQueens {

    final int N = 8;

    boolean isSafe(int board[][], int row, int col) {

        for (int i = 0; i < col; i++) {

            if (board[row][i] == 1)
                return false;
        }

        for (int i = row, j = col;
             i >= 0 && j >= 0;
             i--, j--) {

            if (board[i][j] == 1)
                return false;
        }

        for (int i = row, j = col;
             i < N && j >= 0;
             i++, j--) {

            if (board[i][j] == 1)
                return false;
        }

        return true;
    }

    boolean solveQueen(int board[][], int col) {

        if (col >= N)
            return true;

        for (int i = 0; i < N; i++) {

            if (isSafe(board, i, col)) {

                board[i][col] = 1;

                if (solveQueen(board, col + 1))
                    return true;

                board[i][col] = 0;
            }
        }

        return false;
    }

    void printBoard(int board[][]) {

        for (int i = 0; i < N; i++) {

            for (int j = 0; j < N; j++) {

                System.out.print(board[i][j] + " ");
            }

            System.out.println();
        }
    }

    public static void main(String[] args) {

        EightQueens queen = new EightQueens();

        int board[][] = new int[8][8];

        if (queen.solveQueen(board, 0)) {

            queen.printBoard(board);

        } else {

            System.out.println("No Solution Exists");
        }
    }
}
