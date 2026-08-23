class Solution {
    public void solve(int [] arr, int target,int ind,List<Integer>list, List<List<Integer>>ans){
        if(target==0){
            ans.add(new ArrayList<>(list));
        }
        for(int i=ind;i<arr.length;i++){
            if(i!=ind && arr[i]==arr[i-1]) continue;
            if(arr[i]<=target){
                list.add(arr[i]);
                solve(arr,target-arr[i],i+1,list,ans);
                 list.remove(list.size()-1);
            }
           
        }
    }
    public List<List<Integer>> combinationSum2(int[] arr, int target) {
        List<List<Integer>>ans=new ArrayList<>();
        List<Integer>list=new ArrayList<>();
        Arrays.sort(arr);
        solve(arr,target,0,list,ans);
        return ans;
    }
}