class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int arrLen = matrix[0].length; 
        int left = 0; 
        int right = arrLen * matrix.length - 1; 
        while (left <= right) {
            int middle = left + (right - left) / 2; 
            int x = middle / arrLen; 
            int y = middle % arrLen; 

            if (matrix[x][y] == target) return true;
            if (matrix[x][y] < target) {
                left = middle + 1; 
            } else {
                right = middle - 1;
            }
        }
        return false;
    }
}
