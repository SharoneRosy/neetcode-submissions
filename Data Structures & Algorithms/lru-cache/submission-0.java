class LRUCache{

    class ListNode{
        int key,value;
        ListNode prev,next;
        public ListNode(int key,int value){
            this.key=key;
            this.value=value;
        }
    }

    private int capacity;
    private Map<Integer,ListNode>cache;
    private ListNode head,tail;

    public LRUCache(int capacity){
        this.capacity=capacity;
        cache=new HashMap<>();
        head=new ListNode(-1,-1);
        tail=new ListNode(-1,-1);

        head.next=tail;
        tail.prev=head;
    }
    public int get(int key){
        if(!cache.containsKey(key)) return -1;

        ListNode node=cache.get(key);
        remove(node);
        insertAtFront(node);
        return node.value;
    }
    public void put(int key,int value){
        if(cache.containsKey(key)){
            remove(cache.get(key));
        }

        ListNode newNode=new ListNode(key,value);
        insertAtFront(newNode);
        cache.put(key,newNode);

        if(cache.size()>capacity){
            ListNode lruNode=tail.prev;
            remove(lruNode);
            cache.remove(lruNode.key);
        }
    }

    private void remove(ListNode node){
        node.prev.next=node.next;
        node.next.prev=node.prev;
    }

    private void insertAtFront(ListNode node){
        node.next=head.next;
        node.prev=head;
        head.next.prev=node;
        head.next=node;
    }
}