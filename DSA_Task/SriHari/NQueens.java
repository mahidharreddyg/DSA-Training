import java.util.Scanner;

public class NQueens {
    // Function to print the solution
    private static void printSolution(int board[][], int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Function to check if a queen can be placed on board[row][col]
    private static boolean isSafe(int board[][], int row, int col, int n) {
        int i, j;

        // Check this row on the left side
        for (i = 0; i < col; i++) {
            if (board[row][i] == 1) {
                return false;
            }
        }

        // Check the upper diagonal on the left side
        for (i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        // Check the lower diagonal on the left side
        for (i = row, j = col; j >= 0 && i < n; i++, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        return true;
    }

    // Function to solve N-Queens problem using backtracking
    private static boolean solveNQUtil(int board[][], int col, int n) {
        // If all queens are placed, return true
        if (col >= n) {
            return true;
        }

        // Consider this column and try placing this queen in all rows one by one
        for (int i = 0; i < n; i++) {
            if (isSafe(board, i, col, n)) {
                // Place this queen in board[i][col]
                board[i][col] = 1;

                // Recur to place the rest of the queens
                if (solveNQUtil(board, col + 1, n)) {
                    return true;
                }

                // If placing queen in board[i][col] doesn't lead to a solution
                // then remove the queen from board[i][col]
                board[i][col] = 0; // BACKTRACK
            }
        }

        // If the queen cannot be placed in any row in this column, return false
        return false;
    }

    // Function to solve the N-Queens problem
    public static boolean solveNQ(int n) {
        int board[][] = new int[n][n];

        if (!solveNQUtil(board, 0, n)) {
            System.out.print("Solution does not exist");
            return false;
        }

        printSolution(board, n);
        return true;
    }

    // Main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the value of n:");
        int n = sc.nextInt();

        solveNQ(n);
    }
}
