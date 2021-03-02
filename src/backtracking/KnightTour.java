package backtracking;
public class KnightTour
{
	static int size=0;
	static int[][] board;
	public static void main(String[] args) {
		size=8;
		board = new int[size][size];
		initalizeBoard(board,size);
		//int xMove[] = { 2, 1, -1, -2, -2, -1, 1, 2 };
		//int yMove[] = { 1, 2, 2, 1, -1, -2, -2, -1 };
		int x[]={ 2, 1, -1, -2, -2, -1, 1, 2 };
		int y[]={ 1, 2, 2, 1, -1, -2, -2, -1 };
		board[0][0]=0;
		if(mainFunction(0,0,1,x,y))
		{
		printBoard(board,size);
	}
	}
public static boolean mainFunction(int xl,int yl,int move,int[] x,int[] y){
	if(move==size*size)
	{
		return true;
	}
	int currX=0;
	int currY=0;
	for(int i=0;i<x.length;i++)
	{
		currX=xl+x[i];
		currY=yl+y[i];
	
	
	if(isValidMove(currX,currY))
	{
		board[currX][currY]=move;
	if(mainFunction(currX,currY,move+1,x,y))
	{
		return true;
	}
	else
{
		board[currX][currY]=-1;

}
	}
	}
	return false;

}
public static boolean isValidMove(int x,int y)
{
	if(x>=0&&y>=0&&x<size&&y<size)
	{
return board[x][y]==-1;
	}
	else
	{
		return false;
	}
}
	//TODO initalizeBoard()
	//TODO mainFunction()


	public static void initalizeBoard(int[][] board,int size)
	{
		for(int i=0;i<size;i++)
		{
			for (int j=0;j<size;j++)
			{
				board[i][j]=-1;
			}
		}
	}
	public static void printBoard(int[][] board, int size)
	{
		for(int i=0;i<size;i++)
		{
			for (int j=0;j<size;j++)
			{
				System.out.print(board[i][j]+ " ");
			}
			System.out.print("\n");
		}
	}
}