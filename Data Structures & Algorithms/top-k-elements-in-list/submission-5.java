class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer>map=new HashMap<>();
        for(int i:nums) map.put(i,map.getOrDefault(i,0) +1);

        PriorityQueue<int []>pq=new PriorityQueue<>((a,b)->a[1]-b[1]);

        for(int i:map.keySet()){
            pq.add(new int[]{i,map.get(i)});
            if(pq.size()>k){
                pq.poll();
            }
        }

        int res[]=new int[k];
        int j=0;
        while(!pq.isEmpty()){
            res[j++]=pq.poll()[0];
        }
        return res;
    }
}
