class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashSet<Integer>set=new HashSet<>();
        int l=0,r=0;
        int n=nums.length;
        while(r<n){
            if(r-l>k){
                set.remove(nums[l]);
                l++;
            }
            if(set.contains(nums[r])){
                return true;
            }
            set.add(nums[r]);
            r++;
        }
        return false;
    }
}