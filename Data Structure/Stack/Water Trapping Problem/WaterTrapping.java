import java.util.*;
public class WaterTrapping {

    static void solveWaterTrapping(int arr[], int n)
    {
        int left[] = new int[n];
        int right[] = new int[n];
        int water[] = new int[n];

        left[0] = arr[0];
        for(int i=1;i<n;i++)
            left[i] = Math.max(left[i-1], arr[i]);

        right[n-1] = arr[n-1];
        for(int i=n-2;i>=0;i--)
            right[i] = Math.max(right[i+1], arr[i]);

        for(int i=0;i<n;i++)
            water[i] = Math.min(left[i], right[i])-arr[i];

        int max = 0;
        for(int i=0;i<n;i++)
        {
            max = max+water[i];
        }

        System.out.println("Rain Trapping Solution: "+ max);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size: ");
        int n= sc.nextInt();
        int arr[] = new int[n];
        System.out.println("Enter Elements: ");
        for(int i=0;i<n;i++)
        {
            arr[i] = sc.nextInt();
        }
        solveWaterTrapping(arr, n);
        sc.close();
    }
}
