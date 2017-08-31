package leetcode;

/*
 * You are given a map in form of a two-dimensional integer grid where 1 represents land and 0 represents water.
 * Grid cells are connected horizontally/vertically (not diagonally). 
 * The grid is completely surrounded by water, and there is exactly one island (i.e., one or more connected land cells).
 * The island doesn't have "lakes" (water inside that isn't connected to the water around the island).
 * One cell is a square with side length 1. The grid is rectangular, width and height don't exceed 100.
 * Determine the perimeter of the island.
 *
 * Example:
 * 
 * [[0,1,0,0],
 *  [1,1,1,0],
 *  [0,1,0,0],
 *  [1,1,0,0]]
 * 
 * Answer: 16
 */

public class IslandPerimeter {
	
    public static int islandPerimeter(int[][] grid) {
    	
    	int h = grid.length;
    	int w = grid[0].length;
    	int perimeter = 0;
    	int tmp = 0;
        for (int i = 0; i < h; ++i) {
        	for (int j = 0; j < w; ++j) {
        		if (grid[i][j] == 1) {
        			tmp = 4;
        			if (i - 1 >= 0 && grid[i - 1][j] == 1)
        				tmp--;
        			if (i + 1 < h && grid[i + 1][j] == 1)
        				tmp--;
        			if (j - 1 >= 0 && grid[i][j - 1] == 1)
        				tmp--;
        			if (j + 1 < w && grid[i][j + 1] == 1)
        				tmp--;
        			
        			perimeter += tmp;
        		}
        	}
        }
    	return perimeter;
    }

	public static void main(String[] args) {
		int[][] grid = {{0,1,0,0},{1,1,1,0},{0,1,0,0},{1,1,0,0}};
		
		System.out.println(islandPerimeter(grid));
	}

}
