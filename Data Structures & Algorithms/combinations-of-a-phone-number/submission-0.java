class Solution {
    public void solve(String digits,List<String>res,String []map,StringBuilder sb,int id){
        if(id>=digits.length()){
            res.add(sb.toString());
            return;
        }
        String val=map[digits.charAt(id)-'0'];
        for(int i=0;i<val.length();i++)
        {
            sb.append(val.charAt(i));
            solve(digits,res,map,sb,id+1);
            sb.deleteCharAt(sb.length()-1);
        }
    }
    public List<String> letterCombinations(String digits) {
        List<String>res=new ArrayList<>();
        if(digits.length()==0) return res;
        StringBuilder sb=new StringBuilder();
        String[] map={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        solve(digits,res,map,sb,0);
        return res;
    }
   
}