class Solution {
    public static void solve(char [][] board,int r,List<int []>queens, List<List<String>>res){
        if(queens.size()==board.length){
            List<String>rows=new ArrayList<>();
            for(char [] row:board){
                rows.add(new String(row));
            }
            res.add(rows);
            return;
        }
        for(int c=0;c<board.length;c++){
            if(canAddQueen(r,c,queens)){
                board[r][c]='Q';
                queens.add(new int[]{r,c});
                solve(board,r+1,queens,res);
                board[r][c]='.';
                queens.remove(queens.size()-1);
            }
        }
    }
    public static boolean canAddQueen(int r,int c,List<int[]>queens){
        for(int []q:queens){
            int dr=Math.abs(r-q[0]);
            int dc=Math.abs(c-q[1]);
            if(dr==0 || dc==0 || dr==dc){
                return false;
            }
        }
        return true;
    }
    public List<List<String>> solveNQueens(int n) {
        List<List<String>>res=new ArrayList<>();
        char [][]board=new char[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j]='.';
            }
        }
        List<int []>queens=new ArrayList<>();
        solve(board,0,queens,res);
        return res;
    }
}