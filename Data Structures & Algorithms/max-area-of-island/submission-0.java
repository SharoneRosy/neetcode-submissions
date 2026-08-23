class Solution {
    public int bfs(int[][] grid,int i,int j,int n,int m){
        Queue<int []>q=new LinkedList<>();
        grid[i][j]=0;
        int dr[]={-1,0,1,0};
        int dc[]={0,1,0,-1};
        int res=1;
        q.add(new int[]{i, j});
        while(!q.isEmpty()){
             int []curr=q.poll();
             int r=curr[0],c=curr[1];
             for(int k=0;k<4;k++){
                int nrow=r+dr[k];
                int ncol=c+dc[k];
                if(nrow>=0 && ncol>=0 && nrow<n && ncol<m && grid[nrow][ncol]==1){
                    res++;
                    q.add(new int[]{nrow,ncol});
                    grid[nrow][ncol]=0;
                }
           }
        }
        return res;
    }
    public int maxAreaOfIsland(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int max=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                   max=Math.max(max,bfs(grid,i,j,n,m));
                }
            }
        }
        return max;
    }
}
