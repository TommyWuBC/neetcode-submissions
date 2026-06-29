class LRUCache {
    int size;
    int capacity;
    Map<Integer, Integer> map;
    Map<Integer, ListNode> nodeMap;
    ListNode head;
    ListNode tail;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        size = 0;
        map = new HashMap<>();
        nodeMap = new HashMap<>();
        head = new ListNode();
        tail = new ListNode();
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        int val = map.getOrDefault(key, -1);
        if (val != -1) {
            ListNode accessed = nodeMap.get(key);
            accessed.next.prev = accessed.prev;
            accessed.prev.next = accessed.next;
            accessed.next = head.next;
            accessed.prev = head;
            head.next = accessed;
            accessed.next.prev = accessed;
        }
        return val;
    }
    
    public void put(int key, int value) {
        if (map.getOrDefault(key, -1) == -1) {
            size++;
        }  else {
            ListNode removed = nodeMap.get(key);
            removed.next.prev = removed.prev;
            removed.prev.next = removed.next;
        }
        map.put(key, value);
        ListNode added = new ListNode(key);
        added.next = head.next;
        head.next.prev = added;
        head.next = added;
        added.prev = head;
        nodeMap.put(key, added);
        if (size > capacity) {
            nodeMap.remove(tail.prev.val);
            map.remove(tail.prev.val);
            tail.prev.prev.next = tail;
            tail.prev = tail.prev.prev;
            size--;
        }
    }

    private static class ListNode {
        int val;
        ListNode next;
        ListNode prev;
        public ListNode(int val) {
            this.val = val;
        }
        public ListNode() {
        }
    }
}
