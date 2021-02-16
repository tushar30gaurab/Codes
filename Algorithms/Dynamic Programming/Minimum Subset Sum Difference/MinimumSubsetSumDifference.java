import java.util.*;
public class MinimumSubsetSumDifference
{
    static ArrayList<Integer> solveSubsetSumDifference(int arr[], int n, ArrayList<Integer> list, int sum)
    {
        boolean t[][] = new boolean[n+1][sum+1];
        for(int i=0;i<n+1;i++)
        {
            for(int j=0;j<sum+1;j++)
            {
                if(i==0)
                t[i][j] = true;
                if(j==0)
                t[i][j] = false;
            }
        }
        for(int i=1;i<n+1;i++)
        {
            for(int j=1;j<sum+1;j++)
            {
                if(arr[i-1]<=j)
                t[i][j] = t[i-1][j-arr[i-1]] || t[i-1][j];

                if(arr[i-1]>j)
                t[i][j] = t[i-1][j];
            }
        }

        for(int i=0;i<sum+1;i++)
        {
            if(t[n][i]==true)
            list.add(i);
        }

        return list;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of array:");
        int n = sc.nextInt();
        int arr[] = new int[n];
        int sum=0;
        System.out.println("Enter elements:");
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
            sum+=arr[i];
        }

        ArrayList <Integer> list = new ArrayList<Integer>();
        solveSubsetSumDifference(arr, n, list, sum);
        int minm = Integer.MAX_VALUE;
        for(int i=0;i<list.size()/2;i++){
            minm = Math.min(minm,(sum-2*list.get(i)));
        }
        System.out.println("Minimum Subset Sum Difference: "+ minm);
        
    }
}