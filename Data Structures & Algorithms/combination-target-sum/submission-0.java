class Solution {
    
    public void solve(int [] arr, int target,int i,List<Integer>list,List<List<Integer>>ans){
        if(i==arr.length){
            if(target==0){
                ans.add(new ArrayList<>(list));
                return;
            }
            return;
        }
        if(arr[i]<=target){
            list.add(arr[i]);
            solve(arr,target-arr[i],i,list,ans);
            list.remove(list.size()-1);
        }
        solve(arr,target,i+1,list,ans);
    }
    public List<List<Integer>> combinationSum(int[] arr, int target) {
        
        List<List<Integer>>ans=new ArrayList<>();
        List<Integer>list=new ArrayList<>();
        solve(arr,target,0,list,ans);
        return ans;
    }
}