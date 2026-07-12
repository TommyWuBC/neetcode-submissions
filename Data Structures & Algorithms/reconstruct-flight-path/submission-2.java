class Solution {
    Map<String, PriorityQueue<String>> graph;
    List<String> output;
    public List<String> findItinerary(List<List<String>> tickets) {
        graph = new HashMap<>();
        output = new ArrayList<>();
        for (List<String> ticket : tickets) {
            PriorityQueue<String> pq = graph.getOrDefault(ticket.get(0), new PriorityQueue<>());
            pq.add(ticket.get(1));
            graph.put(ticket.get(0), pq);
        }
        dfs("JFK");
        Collections.reverse(output);
        return output;
    }
    private void dfs(String airport) {
        PriorityQueue<String> pq = graph.getOrDefault(airport, new PriorityQueue<>());
        if (pq.isEmpty()) {
            output.add(airport);
            return;
        }
        while (!pq.isEmpty()) {
            String next = pq.poll();
            dfs(next);
        }
        output.add(airport);
        return;
    }
}
