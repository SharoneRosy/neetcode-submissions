class Solution {
    public void solve(int o,int c,int n,String s,List<String>ans){
        if(o==n && c==n){
            ans.add(s);
            return ;
        }
        if(o<n){
            solve(o+1,c,n,s+"(",ans);
        }
        if(c<o){
            solve(o,c+1,n,s+")",ans);
        }
    }
    public List<String> generateParenthesis(int n) {
        List<String>ans=new ArrayList<>();
        String s="";
        solve(0,0,n,s,ans);
        return ans;
    }
}
