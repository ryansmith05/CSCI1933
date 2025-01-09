import java.util.LinkedList;
import java.util.Queue;

public class PathExists {
    public static boolean doesPathExist(char[][] grid, int sourceRow, int sourceCol) {
        //return bfs(grid, sourceRow, sourceCol) || dfs(grid, sourceRow, sourceCol);
        return dfs(grid, sourceRow, sourceCol) || dfs(grid, sourceRow, sourceCol);
    }
    public static boolean bfs(char[][] grid, int sourceRow, int sourceCol) {
        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];
        visited[sourceRow][sourceCol] = true;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{sourceRow, sourceCol});

        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int row = curr[0];
            int col = curr[1];

            if (grid[row][col] == 'v'&& (row != sourceRow || col != sourceCol)) {
                return true;
            }
            for (int[] dir : directions) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];

                if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols &&
                        !visited[newRow][newCol] && grid[newRow][newCol] != 'x') {
                    visited[newRow][newCol] = true;
                    queue.offer(new int[]{newRow, newCol});
                }
            }
        }
        return false;
    }
    public static boolean dfs(char[][] grid, int sourceRow, int sourceCol) {
        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];
       // System.out.println(visited[0][0]);
        return dfsHelper(grid, sourceRow, sourceCol, visited, sourceRow, sourceCol);
    }
    private static boolean dfsHelper(char[][] grid, int row, int col, boolean[][] visited, int sourceRow, int sourceCol) {
        int rows = grid.length;
        int cols = grid[0].length;

        if (row < 0 || row >= rows || col < 0 || col >= cols || visited[row][col] || grid[row][col] == 'x') {
            return false;
        }
        visited[row][col] = true;

        if (grid[row][col] == 'v' && (row != sourceRow || col != sourceCol)) {
            return true;
        }
        boolean up = dfsHelper(grid, row - 1, col, visited, sourceRow, sourceCol);
        boolean down = dfsHelper(grid, row + 1, col, visited, sourceRow, sourceCol);
        boolean left = dfsHelper(grid, row, col - 1, visited, sourceRow, sourceCol);
        boolean right = dfsHelper(grid, row, col + 1, visited, sourceRow, sourceCol);

        return up || down || left || right;
    }
}
