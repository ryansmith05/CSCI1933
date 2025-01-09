import java.util.Queue;
import java.util.LinkedList;

public class ColorPath {
    public static int[][] colorPath(int[][] image, int sourceRow, int sourceCol, int newColor) {
        bfs(image, sourceRow, sourceCol, newColor);
        //dfs(image, sourceRow, sourceCol, image[sourceRow][sourceCol], newColor);
        return image;
    }
    public static void bfs(int[][] image, int sourceRow, int sourceCol, int newColor) {
        int[][] directions = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        int sourceColor = image[sourceRow][sourceCol];
        if (sourceColor == newColor) {
            return;
        }
        int numRows = image.length;
        int numCols = image[0].length;

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{sourceRow, sourceCol});
        image[sourceRow][sourceCol] = newColor;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int row = curr[0];
            int col = curr[1];

            for (int[] direction : directions) {
                int newRow = row + direction[0];
                int newCol = col + direction[1];

                if (newRow >= 0 && newRow < numRows && newCol >= 0 && newCol < numCols
                        && image[newRow][newCol] == sourceColor) {
                    queue.add(new int[]{newRow, newCol});
                    image[newRow][newCol] = newColor;
                }
            }
        }
    }
    public static void dfs(int[][] image, int row, int col, int sourceColor, int newColor) {
        if (row < 0 || row >= image.length || col < 0 || col >= image[0].length
                || image[row][col] != sourceColor) {
            return;
        }
        image[row][col] = newColor;

        dfs(image, row - 1, col, sourceColor, newColor);
        dfs(image, row + 1, col, sourceColor, newColor);
        dfs(image, row, col - 1, sourceColor, newColor);
        dfs(image, row, col + 1, sourceColor, newColor);
    }
}
