class Solution {
    public int largestRectangleArea(int[] heights) {
        int n=heights.length;
        int maxArea=0;
        Stack<Integer>st=new Stack<>();

        for(int i=0;i<=n;i++){
            while(!st.isEmpty() && (i==n || heights[st.peek()]>=heights[i])){
                int height=heights[st.pop()];
                int width=st.isEmpty()?i:i-st.peek()-1;
                maxArea=Math.max(maxArea,height*width);
            }
            st.push(i);
        }
        return maxArea;
    }
}
