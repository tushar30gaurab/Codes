import java.util.*;
public class CountPairs {


    static int solveCountPairs(int arr[], int sum, int n)
    {
        int count=0;
        HashMap<Integer,Integer> hm = new HashMap<Integer,Integer>();
        for(int i=0;i<n;i++)
        {
            if(!hm.containsKey(arr[i]))
                hm.put(arr[i], 0);
            
            hm.put(arr[i],hm.get(arr[i])+1);
        }
        for(int i=0;i<n;i++)
        {
            if(hm.get(sum-arr[i])!=null)
                count += hm.get(sum-arr[i]);

            if(sum-arr[i]==arr[i])
                count--;
        }

        return count/2;
        
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of array: ");
        int n = sc.nextInt();
        int arr[] = new int[n];
        System.out.println("Enter elements:");
        for(int i=0;i<n;i++)
        {
            arr[i] = sc.nextInt();
        }

        System.out.println("Enter sum:");
        int sum = sc.nextInt();

        System.out.println("Count of pairs with a given sum is: "+solveCountPairs(arr,sum,n));
    }
}
