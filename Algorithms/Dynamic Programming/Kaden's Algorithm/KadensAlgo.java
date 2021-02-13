import java.util.Scanner;
public class KadensAlgo {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter size of array:");
        int n = sc.nextInt();

        int arr[] = new int[n];

        System.out.println("Enter elements:");
        for(int i=0;i<n;i++)
            arr[i] = sc.nextInt();

        //Kadens Algo below

        int max=0,sum=0;
        for(int i=0;i<n;i++)
        {
            if(sum<0)
                sum=0;

                sum+=arr[i];

            if(max<sum)
                max = sum;
            
        }
        System.out.println("Maximum sum of subset is: "+sum);
    }
}
