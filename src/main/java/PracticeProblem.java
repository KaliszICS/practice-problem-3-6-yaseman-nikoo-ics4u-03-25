public class PracticeProblem {

	public static void main(String args[]) {

	}
	public static int searchMazeMoves(String[][] arr){
		int col=0;
		int row=arr.length-1;
		int noOfMoves=0;
		return searchMazeHelper(row, col, arr, noOfMoves);

	}
	public static int searchMazeHelper(int row, int col, String[][] arr, int moves){
		if(row<0||col>arr[row].length-1 || arr[row][col].equals("*")){
			return -1;
		}
		if(arr[row][col].equals("F")){
			return moves;
		}
		int up=searchMazeHelper(row-1, col, arr, moves+1);
		int right=searchMazeHelper(row, col+1, arr, moves+1);
		if(up<0){
			return right;
		}
		else if(right<0){
			return up;
		}
		else{
			return Math.min(right, up);
		}
		
	}

	public static int noOfPaths(String[][] arr){
		int row=arr.length-1;
		int col=0;
		int paths=0;
		if (noOfPathsHelper(row, col, paths, arr)==-1){
			return 0;
		}
		return noOfPathsHelper(row, col, paths, arr);
	}
	public static int noOfPathsHelper(int row, int col, int paths, String[][] arr){
		if(row<0 || col>arr[row].length-1|| arr[row][col].equals("*")){
			return -1;
		}
		if(arr[row][col].equals("F")){
			paths++;
			return paths;
		}
		int up=noOfPathsHelper(row-1, col, paths, arr);
		int right=noOfPathsHelper(row, col+1, paths, arr);
		if(right<0){
			return up;
		}
		else if(up<0){
			return right;
		}
		else{
			return up+right;
		}

	}
}
