class Solution {
    public int leastInterval(char[] tasks, int n) {
        PriorityQueue<Entry> heap = new PriorityQueue<>((a,b) -> Integer.compare(b.freq, a.freq));
        Map<Character, Integer> map = new HashMap<>();
        Queue<Entry> cooldown = new LinkedList<>(); 
        for (char c: tasks) {
            map.put(c, map.getOrDefault(c, 0)+1);
        }
        for (char key : map.keySet()) {
            heap.add(new Entry(key, map.get(key), 0));
        }
        int count = 0;
        while (!heap.isEmpty() || !cooldown.isEmpty()) {
            while (!cooldown.isEmpty() && cooldown.peek().availableTime <= count) {
                heap.add(cooldown.poll());
            }
            if (!heap.isEmpty()) {
                Entry curr = heap.poll();
                curr.freq--;
                if (curr.freq >0) {
                    curr.availableTime = count + n +1;
                    cooldown.add(curr);
                }
            }
            count++;
        }
        return count;
    }

    private class Entry {
        char c;
        int freq;
        int availableTime;
        public Entry(char c, int freq, int availableTime) {
            this.c = c;
            this.freq = freq;
            this.availableTime = availableTime;
        }
    }
}
