class Solution {
    public void  solve(String s, int ind,List<String>list,List<List<String>>ans){
        if(ind==s.length()){
            ans.add(new ArrayList<>(list));
        }
        for(int i=ind;i<s.length();i++){
            if(isPalli(s,ind,i)){
                list.add(s.substring(ind,i+1));
                solve(s,i+1,list,ans);
                list.remove(list.size()-1);
            }
        }
    }
    public boolean isPalli(String s, int start,int end){
        while(start<=end){
            if(s.charAt(start)!=s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
    public List<List<String>> partition(String s) {
        List<List<String>>ans=new ArrayList<>();
        List<String>list=new ArrayList<>();
        solve(s,0,list,ans);
        return ans;
    }
}