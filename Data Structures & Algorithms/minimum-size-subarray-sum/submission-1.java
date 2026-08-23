class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int l=0,r=0;
        int total=0;
        int res=Integer.MAX_VALUE;
        while(r<nums.length){
            total+=nums[r];
            while(total>=target){
                res=Math.min(r-l+1,res);
                total-=nums[l];
                l++;
            }
            r++;
        }
        return res==Integer.MAX_VALUE?0:res;
    }
}