class Solution {
    int count = 0;

    public int totalNQueens(int n) {
        char [][] board = new char[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j] = '.';
            }
        }
        List<int[]> queens = new ArrayList<>();
        solve(board, 0, queens);
        return count;
    }

    public void solve(char [][] board, int r, List<int []> queens){
        if(queens.size() == board.length){
            count++;
            return;
        }
        for(int c=0;c<board.length;c++){
            if(canAddQueen(r, c, queens)){
                board[r][c] = 'Q';
                queens.add(new int[]{r,c});
                solve(board, r+1, queens);
                board[r][c] = '.';
                queens.remove(queens.size()-1);
            }
        }
    }

    public boolean canAddQueen(int r, int c, List<int[]> queens){
        for(int[] q : queens){
            int dr = Math.abs(r - q[0]);
            int dc = Math.abs(c - q[1]);
            if(dr == 0 || dc == 0 || dr == dc){
                return false;
            }
        }
        return true;
    }
}
