class Solution {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character,Integer>map=new HashMap<>();
        for(char c:tasks) map.put(c,map.getOrDefault(c,0)+1);
        PriorityQueue<Integer>pq=new PriorityQueue<>(Collections.reverseOrder());
        for(int c:map.values()){
            pq.add(c);
        }
        int time=0;
        while(!pq.isEmpty()){
            List<Integer>add_back=new ArrayList<>();
            for(int i=0;i<=n;i++){
                if(pq.size()>0){
                    int cnt=pq.poll();
                    cnt--;
                    if(cnt>0){
                    add_back.add(cnt);
                     }
                }
                time+=1;
                if(pq.size()==0 && add_back.size()==0) break;
            }
            pq.addAll(add_back);
        }
        return time;
    }
}
