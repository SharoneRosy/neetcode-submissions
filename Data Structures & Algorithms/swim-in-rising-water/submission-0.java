class Solution {
    public int swimInWater(int[][] grid) {
        int n=grid.length;
        boolean[][]visit=new boolean[n][n];
        PriorityQueue<int[]>pq=new PriorityQueue<>((a,b)->a[0]-b[0]);
        int drow[]={-1,0,1,0};
        int dcol[]={0,1,0,-1};
        pq.add(new int[]{grid[0][0],0,0});
        visit[0][0]=true;
        while(!pq.isEmpty()){
            int []curr=pq.poll();
            int t=curr[0],r=curr[1],c=curr[2];
            if(r==n-1 && c==n-1) return t;
            for(int i=0;i<4;i++){
                int nrow=r+drow[i],ncol=c+dcol[i];
                if(nrow>=0 && ncol>=0 && nrow<n && ncol<n && visit[nrow][ncol]==false){
                    visit[nrow][ncol]=true;
                    pq.add(new int[]{Math.max(t,grid[nrow][ncol]),nrow,ncol});
                }
            }
        }
        return n*n;
    }
}
