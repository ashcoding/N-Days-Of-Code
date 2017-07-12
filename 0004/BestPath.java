import java.lang.Integer;

public class BestPath {
    public static void main(String[] args) {
        int[][] matrix =
            {	{2,3,4,1},
                {1,1,3,9},
                {2,2,3,1},
                {2,2,3,1},
                {6,5,5,6}
            };
        findBestPath(matrix);
    }

    public static void findBestPath(int[][] matrix) {
        int[][] value = new int[matrix.length][matrix[0].length];
        int[][][] parent = new int[matrix.length][matrix[0].length][2];

        // By default, not defining int in Java means it's a 0
        // Refer to https://docs.oracle.com/javase/tutorial/java/nutsandbolts/datatypes.html

        for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[0].length; j++) {
				value[i][j] = Integer.MIN_VALUE;
			}
		}

        // Init the starting point
        value[0][0] = matrix[0][0];
        System.out.println("Matrix size: " + matrix.length + " x " + matrix[0].length);

        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                // Check the next matrix on the right exists
                // and if the next value is more (what we want), take it
                if(i+1 < matrix.length && value[i][j] + matrix[i+1][j] > value[i+1][j]) {
                    value[i+1][j] = value[i][j] + matrix[i+1][j];
                    // Store the i and j, parent
                    parent[i+1][j][0] = i; // x position
                    parent[i+1][j][1] = j; // y position
                }

                // Check the next matrix on the bottom exists
                // and if the next value is more (what we want), take it
                if(j+1 < matrix[0].length && value[i][j] + matrix[i][j+1] > value[i][j+1]) {
                    value[i][j+1] = value[i][j] + matrix[i][j+1];
                    // Store the i and j, parent
                    parent[i][j+1][0] = i; // x position
                    parent[i][j+1][1] = j; // y position
                }
            }
        }

        System.out.println("Max is " + value[matrix.length-1][matrix[0].length-1]);
		int[] at = parent[matrix.length-1][matrix[0].length-1];
		System.out.print((matrix.length-1) + ":" + (matrix[0].length-1) + " (" + matrix[matrix.length-1][matrix[0].length-1] + ") <- ");
		while(!(at[0] == 0 && at[1] == 0)) {
			System.out.print(at[0] + ":" + at[1] + " (" + matrix[at[0]][at[1]] + ") <- ");
			at = parent[at[0]][at[1]];
		}
		System.out.print(at[0] + ":" + at[1] + " (" + matrix[at[0]][at[1]] + ")");
        System.out.println();
    }

}
