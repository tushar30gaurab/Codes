import java.util.*;
public class HCF {

    static int hcf(int a, int b)
    {
        if(b==0)
            return a;
        else{
            //b=a;
            return hcf(b,a%b);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a and b:");
        int a = sc.nextInt();
        int b = sc.nextInt();
        System.out.println(hcf(a, b));
        hcf(a,b);
    }
}
