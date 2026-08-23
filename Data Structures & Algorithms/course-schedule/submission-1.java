class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
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
        int finish=0;
        while(!q.isEmpty()){
            int curr=q.poll();
            finish++;
            for(int nei:adj.get(curr)){
                indegree[nei]--;
                if(indegree[nei]==0){
                    q.add(nei);
                }
            }
        }
        return finish==numCourses;
    }
}
