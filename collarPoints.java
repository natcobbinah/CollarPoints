package CollarPointsGUI;

public class collarPoints {
	
	static int countColJValue = 0;

	public static int[] collarPoints(int matrix[][]){
		
		int maxvalueinMatrix = 0;
		
		int numRows = matrix.length;
		int numCols = matrix[0].length;
		
		int[] rowmaxValue = new int[numRows];
		int[] collarpoints = new int[numCols];
		
		for(int i = 0; i < matrix.length; i++) {
			maxvalueinMatrix = matrix[i][0];
			for(int j = 0 ; j < matrix[i].length; j++) {
				if(matrix[i][j] > maxvalueinMatrix) {
					maxvalueinMatrix = matrix[i][j];
					rowmaxValue[i] = maxvalueinMatrix;
				}
			}
		}
		
		OuterLoop:
			for (int i = 0; i < matrix.length; i++) {
				for (int j = 0; j < matrix[i].length; j++) {
					if (rowmaxValue[i] < matrix[0][j]) {
						collarpoints[i] = rowmaxValue[i];
						countColJValue  = j;
						break OuterLoop;
					}
				}
			}
		return collarpoints;
	}
}
