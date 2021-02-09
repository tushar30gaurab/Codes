import java.util.*;
public class mergeSort {

    static void merge(int arr[], int l ,int mid, int r) {
        int n1 = mid-l+1;
        int n2 = r-mid;
        int L[] = new int[n1];
        int R[] = new int[n2];
        for(int i=0;i<n1;i++)
        {
            L[i] = arr[l+i];
        }

        for(int i=0;i<n2;i++)
        {
            R[i] = arr[mid+i+1];
        }
        int i=0,j=0,k=l;
        while(i<n1 && j<n2)
        {
            if(L[i]<R[j])
            {
                arr[k] = L[i];
                i++;
            }
            else{
                arr[k] = R[j];
                j++;
            }
            k++;
        }
        while(i<n1)
        {
            arr[k] = L[i];
            i++;
            k++;
        }
        while(j<n2)
        {
            arr[k] = R[j];
            j++;
            k++;
        }

    }

    static void mergesort(int arr[], int l, int r)
    {
        if(l<r)
        {
            int mid = (l+r)/2;
            mergesort(arr, l, mid);
            mergesort(arr, mid+1, r);
            merge(arr, l, mid, r);
        }
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of array:");
        int n = sc.nextInt();
        int arr[]= new int[n];
        for(int i=0;i<n;i++)
        {
            arr[i] = sc.nextInt();
        }
         mergesort(arr,0,n-1);
         System.out.println("Sorted Array:");
         for(int i=0;i<n;i++)
         {
             System.out.print(arr[i]+" ");
         }
         sc.close();
    }
    
}
