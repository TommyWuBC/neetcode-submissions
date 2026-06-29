class TimeMap {
    Map<String, List<Entry>> map;
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        List<Entry> l = new ArrayList<>();
        List<Entry> list = map.getOrDefault(key, l);
        Entry entry = new Entry(timestamp, value);
        list.add(entry);
        map.put(key, list);
    }
    
    public String get(String key, int timestamp) {
        List<Entry> l = new ArrayList<>();
        List<Entry> list = map.getOrDefault(key, l);
        if (list.size() == 0) {
            return "";
        }
        int left = 0;
        int right = list.size() -1;
        int mid = (left + right) /2;
        while (left <= right) {
            mid = (left + right) /2;
            int comp = list.get(mid).timestamp;
            if (comp == timestamp) {
                return list.get(mid).value;
            } else if (comp < timestamp) {
                left = mid+1;
            } else {
                right = mid-1;
            }
        }
        if (right >= 0) {
            return list.get(right).value;
        }
        return "";
    }

    private static class Entry {
        int timestamp;
        String value;

        public Entry (int timestamp, String value) {
            this.timestamp = timestamp;
            this.value = value;
        }
    }
}
