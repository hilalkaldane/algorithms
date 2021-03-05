package backtracking;
public class RatInMaze
{
    public static void main(String[] args)
    {
        int size = 4;
        int maze[][] = { { 1, 0, 0, 0 },
            { 1, 1, 0, 1 },
            { 0, 1, 0, 0 },
            { 1, 1, 1, 1 }
        };
        //define moves
        int[][] moves = {{0, 1},
            {1, 0}
        };

        int[] curr={0,0};
        System.out.print(traverse(maze,size,moves,curr));
        //define baseCondition
        //
        //printSolution(maze);


    }

    public static boolean traverse(int[][] maze, int size, int[][] moves, int[] curr )
    {
    		if(curr[0]==size-1&&curr[1]==size-1)
    			return true;

    		else
    		{
    			for(int i=0;i<moves.length;i++)
    			{
    				int[] currentMove={0,0};
    				currentMove[0]=curr[0]+moves[i][0];
    				currentMove[1]=curr[1]+moves[i][1];

    				if(checkValidMove(maze,currentMove,size))
    				{
    					return traverse(maze,size,moves,currentMove);
    				}
    			}
    		}
    		return false;
    }
    public static boolean checkValidMove(int[][]maze,int[] currentMove,int size)
    {
    	return currentMove[0]<size&&currentMove[1]<size&&currentMove[0]>=0&&currentMove[1]>=0&&maze[currentMove[0]][currentMove[1]]!=0;
    }
}