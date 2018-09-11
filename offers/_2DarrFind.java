

public class _2DarrFind {

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 8, 9},
                {2, 4, 9, 12},
                {4, 7, 10, 13},
                {6, 8, 11, 13}
        };
        int target = 2;

        boolean b = new Solution().hasN(matrix, target);
        System.out.println(b);
    }

    static class Solution {
        public boolean hasN(int[][] matrix, int target) {
            int rows = matrix.length;
            int cols = matrix[0].length;

            int r = 0;
            int c = cols-1;

            while(r<rows && c>=0) {
                int num = matrix[r][c];
                if (num == target) {
                    return true;
                } else if (num > target) {
                    r++;
                } else {
                    // num < target
                    c--;
                }
            }
            return false;
        }
    }
}