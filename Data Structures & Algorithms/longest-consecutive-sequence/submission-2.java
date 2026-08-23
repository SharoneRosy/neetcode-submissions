class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer>set=new HashSet<>();
        for(int i:nums) set.add(i);
        int max=0;
        for(int i :set){
            if(!set.contains(i-1)){
                int cnt=1;
                while(set.contains(i+cnt)){
                    cnt++;
                }
                max=Math.max(max,cnt);
            }
        }
        return max;
    }
}
