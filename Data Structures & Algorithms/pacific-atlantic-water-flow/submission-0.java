class Solution {
    private int []dr={-1,0,1,0};
    private int []dc={0,1,0,-1};
    int n,m;
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        n=heights.length;
        m=heights[0].length;
        boolean [][] p=new boolean[n][m];
        boolean [][] a=new boolean[n][m];

        for(int c=0;c<m;c++){
            dfs(0,c,p,heights);
            dfs(n-1,c,a,heights);
        }
        for(int r=0;r<n;r++){
            dfs(r,0,p,heights);
            dfs(r,m-1,a,heights);
        }
        List<List<Integer>>res=new ArrayList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(p[i][j] && a[i][j]){
                    res.add(Arrays.asList(i,j));
                }
            }
        }
        return res;
    }

    private void dfs(int r,int c,boolean [][]o,int [][]heights){
        o[r][c]=true;
        for(int i=0;i<4;i++){
            int nr=r+dr[i];
            int nc=c+dc[i];
            if(nr>=0 && nc>=0 && nr<n && nc<m && !o[nr][nc] && heights[nr][nc]>=heights[r][c]){
                dfs(nr,nc,o,heights);
            }
        }
    }
}
