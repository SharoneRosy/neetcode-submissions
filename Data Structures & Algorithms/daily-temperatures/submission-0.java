class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer>st=new Stack<>();
        int n=temperatures.length;
        int []res=new int[n];
        for(int i=0;i<n;i++){
            int curr=temperatures[i];
            while(!st.isEmpty() && temperatures[st.peek()]<curr ){
                int prev=st.pop();
                res[prev]=i-prev;
            }
            st.push(i);
        }
        return res;
    }
}
