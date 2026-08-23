class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> ans = new ArrayList<>();

        int rowStart = 0;
        int rowEnd = matrix.length - 1;

        int colStart = 0;
        int colEnd = matrix[0].length - 1;

        while (rowStart <= rowEnd && colStart <= colEnd) {

            // 1. Left → Right
            for (int col = colStart; col <= colEnd; col++) {
                ans.add(matrix[rowStart][col]);
            }
            rowStart++;

            // 2. Top → Bottom
            for (int row = rowStart; row <= rowEnd; row++) {
                ans.add(matrix[row][colEnd]);
            }
            colEnd--;

            // 3. Right → Left
            if (rowStart <= rowEnd) {
                for (int col = colEnd; col >= colStart; col--) {
                    ans.add(matrix[rowEnd][col]);
                }
                rowEnd--;
            }

            // 4. Bottom → Top
            if (colStart <= colEnd) {
                for (int row = rowEnd; row >= rowStart; row--) {
                    ans.add(matrix[row][colStart]);
                }
                colStart++;
            }
        }

        return ans;
    }
}