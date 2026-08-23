class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        Queue<int []>q=new LinkedList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==0){
                    q.add(new int[]{i,j});
                }
            }
        }
        if(q.size()==0) return;
        int dr[]={-1,0,1,0};
        int dc[]={0,1,0,-1};
        while(!q.isEmpty()){
            int curr[]=q.poll();
            int r=curr[0];
            int c=curr[1];
            for(int i=0;i<4;i++){
                int nrow=r+dr[i];
                int ncol=c+dc[i];
                if(nrow>=0 && ncol>=0 && ncol<n && nrow<m && grid[nrow][ncol]==Integer.MAX_VALUE){
                    grid[nrow][ncol]=grid[r][c]+1;
                    q.add(new int[]{nrow,ncol});
                }
            }
        }
    }
}
