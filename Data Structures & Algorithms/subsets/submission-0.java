class Solution {
    public void solve(int i,int [] nums,List<Integer>ls,List<List<Integer>>res){
        if(i==nums.length){
            res.add(new ArrayList<>(ls));
            return;
        }
        ls.add(nums[i]);
        solve(i+1,nums,ls,res);
        ls.remove(ls.size()-1);
        solve(i+1,nums,ls,res);
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>>res=new ArrayList<>();
        List<Integer>ls=new ArrayList<>();
        solve(0,nums,ls,res);
        return res;
    }
}
