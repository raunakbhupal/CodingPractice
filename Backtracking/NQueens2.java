class Solution {
    public int result = 0;
    public int totalNQueens(int n) {
        Set<Integer> cols = new HashSet<>();
        Set<Integer> posDiag = new HashSet<>();
        Set<Integer> negDiag = new HashSet<>();
        backtrack(n, cols, posDiag, negDiag, 0);
        return result;
    }

    public void backtrack(int n, Set<Integer> cols, Set<Integer> posDiag, Set<Integer> negDiag, int row) {
        if (row == n) {
            result += 1;
            return;
        }

        for (int col = 0; col < n; col++) {
            if (cols.contains(col) || posDiag.contains(row + col) || negDiag.contains(row - col)) {
                continue;
            }
            cols.add(col);
            posDiag.add(row + col);
            negDiag.add(row - col);

            backtrack(n, cols, posDiag, negDiag, row + 1);

            cols.remove(col);
            posDiag.remove(row + col);
            negDiag.remove(row - col);
        }
    }   
}
