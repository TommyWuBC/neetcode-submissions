class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<Map<Character, Integer>, List<String>> anaMap = new HashMap<>();
        for (String s : strs) {
            Map<Character, Integer> map = new HashMap<>();
            for (char c : s.toCharArray()) {
                map.put(c, map.getOrDefault(c, 0) +1);
            }
            List<String> list = anaMap.getOrDefault(map, new ArrayList<>());
            list.add(s);
            anaMap.put(map, list);
        }
        List<List<String>> output = new ArrayList<>();
        for (Map<Character, Integer> m : anaMap.keySet()) {
            output.add(anaMap.get(m));
        }
        return output;
    }
}
