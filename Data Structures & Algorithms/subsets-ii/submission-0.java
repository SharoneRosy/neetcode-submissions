class Solution {
    public void solve(int []nums,int ind,List<Integer>list,List<List<Integer>>ans){
        ans.add(new ArrayList<>(list));
        for(int i=ind;i<nums.length;i++){
            if(i!=ind && nums[i]==nums[i-1]) continue;
            list.add(nums[i]);
            solve(nums,i+1,list,ans);
            list.remove(list.size()-1);
        }
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>>ans=new ArrayList<>();
        Arrays.sort(nums);
        List<Integer>list=new ArrayList<>();
        solve(nums,0,list,ans);
        return ans;
    }
}