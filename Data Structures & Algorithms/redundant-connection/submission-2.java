class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n=edges.length+1;
        DisjointSet ds=new DisjointSet(n);
        for(int [] edge:edges){
            int u=edge[0];
            int v=edge[1];
            if(ds.find(u)==ds.find(v)){
                return edge;
            }else{
                ds.union(u,v);
            }
        }
        return new int[0];
    }
}
class DisjointSet{
    int[] parent;
    int[] size;
    public DisjointSet(int n){
        parent=new int[n];
        size=new int[n];
        for(int i=0;i<n;i++){
            parent[i]=i;
            size[i]=1;
        }
    }
    public int find(int node){
        if(node!=parent[node]){
            parent[node]=find(parent[node]);
        }
        return parent[node];
    }
    public void union(int u,int v){
        int pu=find(u);
        int pv=find(v);
        if(pu!=pv){
            if(size[pv]>size[pu]){
                parent[pu]=pv;
                size[pv]+=size[pu];
            }else{
                parent[pv]=pu;
                size[pu]+=size[pv];
            }
        }
    }
}