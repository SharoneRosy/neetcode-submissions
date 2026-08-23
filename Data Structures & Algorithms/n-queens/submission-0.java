class Solution {
    public void solve(int r,int n,List<List<String>>res,char board[][],List<int []>queens){
        if(queens.size()==n){
            List<String>rows=new ArrayList<>();
            for(char []row:board){
                rows.add(new String(row));
            }
            res.add(rows);
            return;
        }
        for(int c=0;c<n;c++){
            if(isValid(r,c,queens)){
                queens.add(new int[]{r,c});
                board[r][c]='Q';
                solve(r+1,n,res,board,queens);
                queens.remove(queens.size()-1);
                board[r][c]='.';
            }
        }
    }
    public boolean isValid(int r,int c,List<int[]>queens){
        for(int []q:queens){
            int dr=r-q[0];
            int dc=c-q[1];
            if (q[1] == c || dr == dc || dr == -dc) {
                return false;
            }
        }
        return true;
    }
    public List<List<String>> solveNQueens(int n) {
        List<List<String>>res=new ArrayList<>();
        char board[][]=new char[n][n];
        if (n == 0) return res; 
        for(char [] row:board) Arrays.fill(row,'.');
        List<int[]>queens=new ArrayList<>();
        solve(0,n,res,board,queens);
        return res;
    }
}
