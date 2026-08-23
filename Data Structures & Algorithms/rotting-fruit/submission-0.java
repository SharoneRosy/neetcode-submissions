class Solution {
    public int orangesRotting(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        Queue<int []>q=new LinkedList<>();
        int fresh=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==2){
                    q.add(new int[]{i,j});
                }
                else if(grid[i][j]==1){
                    fresh++;
                }
            }
        }
        int time=0;
        int dr[]={-1,0,1,0};
        int dc[]={0,1,0,-1};
        while(!q.isEmpty() && fresh>0){
            int size=q.size();
            for(int j=0;j<size;j++){
                int curr[]=q.poll();
                int r=curr[0];
                int c=curr[1];
            
                for(int i=0;i<4;i++){
                 int nrow=r+dr[i];
                 int ncol=c+dc[i];
                 if(nrow>=0 && ncol>=0 && ncol<n && nrow<m && grid[nrow][ncol]==1){
                    grid[nrow][ncol]=2;
                    q.add(new int[]{nrow,ncol});
                    fresh--;
                }
            }
            }
            time++;
        }
        return fresh==0?time:-1;
    }
}
