class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int indegree[]=new int[numCourses];
        List<List<Integer>>adj=new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        for(int []pre:prerequisites){
            int course=pre[0];
            int prerequisite=pre[1];
            adj.get(prerequisite).add(course);
            indegree[course]++;
        }
        Queue<Integer>q=new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }
        int res[]=new int[numCourses];
        int finish=0;
        while(!q.isEmpty()){
            int curr=q.poll();
            res[finish++]=curr;
            for(int nei:adj.get(curr)){
                indegree[nei]--;
                if(indegree[nei]==0){
                    q.add(nei);
                }
            }
        }
        if(finish!=numCourses){
            return new int[0];
        }
        return res;
    }
}
