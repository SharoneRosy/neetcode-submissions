class Solution {
    public void dfs(int r,int c,char[][] board,int m,int n){
        board[r][c]='T';
        int dr[]={-1,0,1,0};
        int dc[]={0,1,0,-1};
        for(int i=0;i<4;i++){
            int nr=r+dr[i];
            int nc=c+dc[i];
            if(nr>=0 && nc>=0 && nr<m && nc<n && board[nr][nc]=='O'){
                dfs(nr,nc,board,m,n);
            }
        }
    }
    public void solve(char[][] board) {
        int m=board.length;
        int n=board[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0 || j==0 || i==m-1 || j==n-1 ){
                    if(board[i][j]=='O'){
                        dfs(i,j,board,m,n);
                    }
                }
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]=='O'){
                    board[i][j]='X';
                }else if(board[i][j]=='T'){
                    board[i][j]='O';
                }
            }
        }
    }
}
