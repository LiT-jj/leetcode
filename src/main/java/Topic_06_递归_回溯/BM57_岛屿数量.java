package Topic_06_递归_回溯;

public class BM57_岛屿数量 {
    public int solve (char[][] grid) {
        // write code here
        int res = 0;
        for (int i = 0; i < grid.length; ++i){
            for (int j = 0; j < grid[0].length; ++j){
                if (grid[i][j] == '1'){
                    res++;
                    DFS(grid, i, j);
                }
            }
        }
        return res;
    }

    private void DFS(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i == grid.length || j == grid[0].length || grid[i][j] == '0'){
            return;
        }
        grid[i][j] = '0';
        DFS(grid, i+1, j);
        DFS(grid, i, j+1);
        DFS(grid, i-1, j);
        DFS(grid, i, j-1);

    }
}
