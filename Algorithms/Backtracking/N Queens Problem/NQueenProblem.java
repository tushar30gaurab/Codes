import java.util.*;
public class NQueenProblem {

    static void printSol(int matrix[][], int n)
    {
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(matrix[i][j]==0)
                    System.out.print("_ ");
                else
                    System.out.print("Q ");
            }
            System.out.println();
        }
    }

static boolean solveNQueen(int matrix[][], int n)
{
    for(int i=0;i<n;i++)
    {
        for(int j=0;j<n;j++)
        {
            matrix[i][j]=0;
        }
    }  
    if(solveNQueenUntil(matrix, 0, n)){
        printSol(matrix, n);  
        return true;
    }
    else
    {
        System.out.println("Solution dosen't exist!");
        return false;
    }
}

static boolean isSafe(int matrix[][], int row, int col, int n)
{
    int i, j;

    for(i=0;i<col;i++)
    {
        if(matrix[row][i]==1)
            return false;
    }

    for(i=row, j=col; i>=0 && j>=0; i--, j--)
    {
        if(matrix[i][j]==1)
            return false;
    }

    for(i=row,j=col; i<n && j>=0; i++,j--)
    {
        if(matrix[i][j]==1)
            return false;
    }

    return true;
}

static boolean solveNQueenUntil(int matrix[][], int col, int n)
{
    if(col>=n)
        return true;
    for(int i=0;i<n;i++)
    {
        if(isSafe(matrix, i, col,n))
        {
            matrix[i][col]=1;
            
            if(solveNQueenUntil(matrix, col+1, n))
                return true;
            matrix[i][col]=0;   //Backtracking Step
        }
    }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of array:");
        int n = sc.nextInt();
        int matrix[][] = new int[n][n];
        solveNQueen(matrix, n);
        sc.close();
    }
}
