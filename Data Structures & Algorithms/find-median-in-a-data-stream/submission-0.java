class MedianFinder {
    
    PriorityQueue<Integer>maxheap;
    PriorityQueue<Integer>minheap;
    int size;
    public MedianFinder() {
        maxheap=new PriorityQueue<>(Collections.reverseOrder());
        minheap=new PriorityQueue<>();
        size=0;
    }
    
    public void addNum(int num) {
        if(size%2==0){
            if(maxheap.isEmpty() || num<minheap.peek() ){
                maxheap.add(num);
            }else{
                maxheap.add(minheap.poll());
                minheap.add(num);
            }
        }else{
            if(num>maxheap.peek()){
                minheap.add(num);
            }else{
                minheap.add(maxheap.poll());
                maxheap.add(num);
            }
        }
        size++;
    }
    
    public double findMedian() {
        if(size%2==0){
            return (double)(maxheap.peek()+minheap.peek())/2.0;
        }else{
            return (double)maxheap.peek();
        }
    }
}
