class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int outerleft = 0;
        int outerright = matrix.length -1;
        boolean found = false;
        int lane = -1;
        if (matrix.length > 1) {
            while (outerleft <= outerright && !found) {
                int outermid = (outerleft + outerright) /2;
                int comp = matrix[outermid][0];
                if (comp == target) {
                    return true;
                } else if (comp < target) {
                    if ((outermid == matrix.length -1) || (outermid+1 < matrix.length && (matrix[outermid+1][0] > target))) {
                        lane = outermid;
                        found = true;
                    } else {
                        outerleft = outermid+1;
                    }
                } else if (comp > target) {
                    if (outermid-1 >= 0 && matrix[outermid-1][0] < target) {
                        lane = outermid-1;
                        found = true;
                    } else {
                        outerright =outermid-1;
                    }
                }
            }
        } else {
            lane = 0;
        }
        if (lane == -1) {
            return false;
        }
        int left = 0;
        int right = matrix[lane].length -1;
        while (left <= right) {
            int mid = (left + right) /2;
            if (matrix[lane][mid] == target) {
                return true;
            } else if (matrix[lane][mid] > target) {
                right = mid-1;
            } else {
                left = mid+1;
            }
        }
        return false;
    }
}
