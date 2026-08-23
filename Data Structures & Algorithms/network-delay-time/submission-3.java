class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>>adj=new ArrayList<>();
        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<>());
        }

        for(int [] time:times){
            adj.get(time[0]).add(new int[]{time[1],time[2]});
        }

        PriorityQueue<int []>pq=new PriorityQueue<>((a,b)->a[1]-b[1]);
        int dis[]=new int[n+1];
        Arrays.fill(dis,Integer.MAX_VALUE);
        dis[k]=0;
        pq.add(new int[]{k,0});

        while(!pq.isEmpty()){
            int curr[]=pq.poll();
            int node=curr[0];
            int time=curr[1];
            for(int [] nei:adj.get(node)){
                int nextnode=nei[0];
                int weight=nei[1];
                if(time+weight<dis[nextnode]){
                    dis[nextnode]=time+weight;
                    pq.add(new int[]{nextnode,dis[nextnode]});
                }
            }
        }
        int max=0;
        for(int i=1;i<=n;i++){
            if(dis[i]==Integer.MAX_VALUE) return -1;
            max=Math.max(max,dis[i]);
        }
        return max;
    }
}
