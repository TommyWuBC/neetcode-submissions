class Solution {
    Map<Integer, List<Node>> map;
    Set<Integer> visited;
    Map<Integer, Integer> distanceMap;
    public int networkDelayTime(int[][] times, int n, int k) {
        visited = new HashSet<>();
        distanceMap = new HashMap<>();
        PriorityQueue<Node> queue = new PriorityQueue<>((a, b) -> Integer.compare(a.dist, b.dist));
        map = new HashMap<>();
        for (int[] entry : times) {
            List<Node> list = map.getOrDefault(entry[0], new ArrayList<>());
            Node node = new Node(entry[1], entry[2]);
            list.add(node);
            map.put(entry[0], list);
        }
        for (int j = 1; j < n+1; j++) {
            distanceMap.put(j, Integer.MAX_VALUE);
        }
        queue.add(new Node(k, 0));
        distanceMap.put(k, 0);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node curr = queue.poll();
                if (visited.contains(curr.next)) {
                    continue;
                }
                visited.add(curr.next);
                List<Node> neighbors = map.getOrDefault(curr.next, new ArrayList<>());
                for (Node neighbor : neighbors) {
                    int distance = neighbor.dist + distanceMap.get(curr.next);
                    if (distance < distanceMap.get(neighbor.next)) {
                        distanceMap.put(neighbor.next, distance);
                        queue.add(new Node(neighbor.next, distance));
                    }
                }
            }
        }
        int max = 0;
        for (int key : distanceMap.keySet()) {
            int distance = distanceMap.get(key);
            if (distance == Integer.MAX_VALUE) {
                return -1;
            }
            if (distance > max) {
                max = distance;
            }
        }
        return max;

    }
    private class Node {
        int next;
        int dist;
        public Node(int next, int dist) {
            this.next = next;
            this.dist = dist;
        }
    }
}
