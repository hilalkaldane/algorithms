package backtracking;
public class NQueenProblem
{
    public static int queens = 0;

    static int[] x = {0, 0, 0, 0, 0, 0, 0, 0};
    static int[] y = {0, 0, 0, 0, 0, 0, 0, 0};
    public static void main(String[] args)
    {
        int[][] chessBoard = {{0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}};
        int N = 4;
        //TODO placeQueen
        //TODO printChessBoard
        int curr[] = {0, 0};
        System.out.println(placeQueen(chessBoard, N, curr));
        printChessBoard(chessBoard, N);
    }
    public static boolean placeQueen(int[][] chessBoard, int N, int[] curr)
    {
        if(queens == N)
            return true;
        else
        {
            for(int i = curr[0]; i < N; i++)
            {
                if(isQueenSafe(chessBoard, i, curr[1], N))
                {
                    queens++;
                    chessBoard[i][curr[1]] = 1;
                    if(placeQueen(chessBoard, N, new int[] {0, curr[1] + 1}))
                    {
                        return true;
                    }
                    else
                    {
                        queens--;
                        chessBoard[i][curr[1]] = 0;
                    }
                }
            }
            return false;
        }
    }
    public static boolean isQueenSafe(int[][] chessBoard, int xMoves, int yMoves, int N)
    {
        if(xMoves <= N && yMoves <= N)
        {
            //check for rows
            for(int i = 0; i < N; i++)
            {
                if(chessBoard[xMoves][i] == 1)
                    return false;
            }
            for(int i = 0; i < N; i++)
            {
                if(chessBoard[i][yMoves] == 1)
                    return false;
            }
            for(int i = 0; xMoves + i < N && yMoves + i < N; i++)
            {            	
                if(chessBoard[xMoves + i][yMoves + i] == 1)
                    return false;
            }
            for(int i = 0; xMoves-i >= 0 && yMoves - i >= 0; i++)
            {            	
                if(chessBoard[xMoves - i][yMoves - i] == 1)
                    return false;
            }
        }
        return true;
    }
    public static void printChessBoard(int[][] chessBoard, int N)
    {
        for (int i = 0; i < N ; i++ )
        {
            for (int j = 0; j < N ; j++ )
            {
                System.out.print(chessBoard[i][j] + "\t");
            }
            System.out.println("");
        }
    }
}