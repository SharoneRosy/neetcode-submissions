class Solution {
    public void dfs(char [][] grid,int i,int j,int n,int m){
        grid[i][j]='0';
        int dr[]={-1,0,1,0};
        int dc[]={0,1,0,-1};
        for(int k=0;k<4;k++){
            int nrow=i+dr[k];
            int ncol=j+dc[k];
            if(nrow>=0 && ncol>=0 && nrow<n && ncol<m && grid[nrow][ncol]=='1'){
                dfs(grid,nrow,ncol,n,m);
            }
        }
    }
    public int numIslands(char[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int cnt=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]=='1'){
                    cnt++;
                    dfs(grid,i,j,n,m);
                }
            }
        }
        return cnt;
    }
}
