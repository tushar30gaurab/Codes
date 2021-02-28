import java.util.*;
public class CoinCountProblem {
    static  ArrayList<Integer> solveCoinCountProblem(int arr[], int n, int sum)
    {
        ArrayList<Integer> list = new ArrayList<Integer>();
        Arrays.sort(arr);
        
        //int count=0;
        for(int i=n;i>=0;i--)
        {
           while(sum>=arr[i])
            {
                sum = sum-arr[i];
                list.add(arr[i]);
            }
        }
        return list;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of array:");
        int n = sc.nextInt();
        int arr[] = new int[n];
        System.out.println("Enter denominations of coins:");
        for(int i=0;i<n;i++)
            arr[i] = sc.nextInt();

        System.out.println("Enter Sum to be counted:");
        int sum = sc.nextInt();


        System.out.println("Minimum denomiantions that sum up to "+sum+" is: "+solveCoinCountProblem(arr,n-1,sum));
    }
    
}
