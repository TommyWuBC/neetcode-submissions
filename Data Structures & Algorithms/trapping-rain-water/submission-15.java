class Solution {
    public int trap(int[] height) {
        if (height.length <=1 ){
            return 0;
        }
        int i = 0;
        int j = height.length -1;
        int total = 0;
        while (i<j && height[i+1] >= height[i]) {
            i++;
        }
        while (i<j && height[j-1] >= height[j]) {
            j--;
        }
        while (i < j) {
            int max = 0;
            List<Integer> list = new ArrayList<>();
            int left = i;
            int maxindex = 0;
            int index = 0;
            while (i<j && height[i +1] < height[left]) {
                i++;
                list.add(height[i]);
                if (height[i] > max) {
                    max = height[i];
                    maxindex = i;
                    index = list.size();
                }
            }
            if (i < j && height[i+1] >= height[left]) {
                for (int m : list) {
                    total += height[left] -m;
                }
                i = i+1;
            } else if (max > height[j] && max < height[left]) {
                for (int n = 0; n < index; n++) {
                    total += max - list.get(n);
                }
                i = maxindex;
            } else {
                for (int p : list) {
                    total += Math.min(height[left], height[j]) -p;
                }
                break;
            }
        }

        return total;
    }
}
