public class NQueenProblem{
	public static int queens=0;

		static int[] x={0,0,0,0,0,0,0,0};
		static int[] y={0,0,0,0,0,0,0,0};
	public static void main(String[] args) {
		int[][] chessBoard= {{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0}};
		int N=4;
		//TODO placeQueen
		//TODO printChessBoard
		int curr[]={0,0};
		System.out.println(placeQueen(chessBoard,N,curr));
		printChessBoard(chessBoard,N);
	}
	public static boolean placeQueen(int[][] chessBoard,int N,int[] curr)
	{
		if(queens==N)
			return true;
		else
		{
			for(int i=0;i<N;i++)
			{
				if(isQueenSafe(i,curr[1],N))
				{
					queens++;
					chessBoard[i][curr[1]]=1;
					x[i]=1;
					y[curr[1]]=1;
					if(placeQueen(chessBoard,N,new int[]{0,curr[1]+1}))
					{
						return true;
					}
					else
					{
						queens--;
						chessBoard[i][curr[1]]=0;
					}
				}
			}
			return false;
		}
	}
	public static boolean isQueenSafe(int xMoves,int yMoves,int N)
	{
		return xMoves<N &&yMoves<N &&x[xMoves]!=1 && y[yMoves]!=1;
	}
	public static void printChessBoard(int[][] chessBoard,int N)
	{
		for (int i=0;i<N ;i++ ) {
			for (int j=0;j<N ;j++ ) {
				System.out.print(chessBoard[i][j]+"\t");
			}
			System.out.println("");
		}
	}
}