public class Main {
    public static void main(String[] args) {
        String grid[] = {"/\\","\\/"};
        System.out.println(regionsBySlashes(grid));
    }

    public static int regionsBySlashes(String[] grid) {
        if(grid.length == 1) return grid[0].charAt(0) == ' ' ? 1 : 2;

        int height = grid.length;
        int width = grid[0].length();
        boolean visited[][][] = new boolean[height][width][4];

        int regions = 0;
        for(int row = 0; row < height; row++){
            for(int col = 0; col < width; col++){
                for(int type = 0; type < 4; type++){
                    if(!visited[row][col][type]){
                        dfs(row, col, type, grid, visited);
                        regions++;
                    }
                }
            }
        }

        return regions;
    }

    public static void dfs(int row, int col, int type, String grid[], boolean visited[][][]){
        if(!inside(row, col, grid) || visited[row][col][type]){
            return;
        }

        visited[row][col][type] = true;

        // to connect the graph in other cell
        if(type == 1){
            dfs(row, col + 1, 3, grid, visited);
        } else if(type == 0){
            dfs(row - 1, col, 2, grid, visited);
        } else if(type == 2){
            dfs(row + 1, col, 0, grid, visited);
        } else if(type == 3){
            dfs(row, col - 1, 1, grid, visited);
        }

        // within the cell
        if(grid[row].charAt(col) != '/'){
            dfs(row, col, type ^ 1, grid, visited);
        }

        if(grid[row].charAt(col) != '\\'){
            dfs(row, col, type ^ 3, grid, visited);
        }
    }

    public static boolean inside(int row, int col, String grid[]){
        return 0 <= row && row < grid.length && 0 <= col && col < grid[0].length();
    }
}