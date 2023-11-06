// look at the video for reason behind posDiag, negDiag etc. for posDiag r+c will be same and for negDiag r-c will be same

class Solution {
    public List<List<String>> solveNQueens(int n) {
        Set<Integer> cols = new HashSet<>();
        Set<Integer> posDiag = new HashSet<>();
        Set<Integer> negDiag = new HashSet<>();
        List<List<String>> result = new ArrayList<>();
        char[][] board = new char[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }

        backtrack(board, cols, posDiag, negDiag, result, 0);
        return result;
    }

    public void backtrack(char[][] board, Set<Integer> cols, Set<Integer> posDiag, Set<Integer> negDiag, List<List<String>> result, int row) {
        if (row == board.length) {
            // each row is an array as of now, it needs to be a string in the output thus for each row we will join each substring together
            // example in python : copy = ["".join(row) for row in board] res.append(copy)
            List<String> copy = new ArrayList<>();
            for (int i = 0; i < board.length; i++) {
                copy.add(new String(board[i]));
            }
            result.add(copy);
            return;
        }

        for (int col = 0; col < board.length; col++) {
            if (cols.contains(col) || posDiag.contains(row + col) || negDiag.contains(row - col)) {
                continue;
            }
            cols.add(col);
            posDiag.add(row + col);
            negDiag.add(row - col);
            board[row][col] = 'Q';

            backtrack(board, cols, posDiag, negDiag, result, row + 1);

            cols.remove(col);
            posDiag.remove(row + col);
            negDiag.remove(row - col);
            board[row][col] = '.';
        }
    }
}
