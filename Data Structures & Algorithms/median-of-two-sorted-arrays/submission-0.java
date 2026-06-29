class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int i = 0;
        int j = 0;
        int prev = 0;
        int total = nums1.length +nums2.length;
        int mid = (total)/2;
        for (int count = 0; count < mid; count++) {
            if (i < nums1.length && j < nums2.length) {
                if (nums1[i] <= nums2[j]) {
                    prev = nums1[i];
                    i++;
                } else {
                    prev = nums2[j];
                    j++;
                }
            } else if (i < nums1.length) {
                prev = nums1[i];
                i++;
            } else {
                prev = nums2[j];
                j++;
            }
        }   
        if (i < nums1.length && j < nums2.length) {
            if (total % 2 == 1) {
                return (int)(Math.min(nums1[i], nums2[j]));
            } else {
                return ((double)(Math.min(nums1[i], nums2[j]) + prev))/2.0;
            }
        } else if (i < nums1.length) {
            if (total % 2 == 1) {
                return nums1[i];
            } else {
                return ((double)(nums1[i] + prev))/2.0;
            }
        } else {
            if (total % 2 == 1) {
                return nums2[j];
            } else {
                return ((double)(nums2[j] + prev))/2.0;
            }
        }
    }
}
