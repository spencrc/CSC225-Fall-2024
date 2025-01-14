import java.io.File;
import java.util.Scanner;

public class ArrayMatch {
    /* PROVING RUNTIME:
    * For our recurrence relation, our equation will be of the form T(n) = aT(n/b) + cn via the Master's Theorem.
    * The match function contains 4 recursive calls at worst-case, so we define a as equal to 4.
    * The match function divides arrays A and B in two, so we define b as equal to 2.
    * Thus, we have:   T(n) = 4T(n/2) + cn
    *                  T(1) = 1 (base case)
    * 
    * Now, solving:    T(n) =  4(4T(n/4)  + c(n/2)) + cn  =   16T(n/4) + 3cn
    *                  T(n) = 16(4T(n/8)  + c(n/4)) + 3cn =   64T(n/8) + 7cn
    *                  T(n) = 64(4T(n/16) + c(n/8)) + 7cn = 256T(n/16) + 15cn
    * After k substiutions, we reach the following recurrence relation: 
    *                  T(n) = k^2 * T(n/k) + (k-1)cn
    * When base case is reached, we have: n/k = 1 -> k = n
    * Substituting k back into T(n):
    *                  T(n) = n^2 * T(1) + cn^2 - cn
    *                  T(n) = O(n^2)                 
    */ 
    public static boolean match(int[] A, int[] B) {
        int n = A.length;

        if (areArraysEqual(A, B)) return true;
        else if (n % 2 != 0) return false;

        int mid = n/2;
        int[] A1 = new int[mid];        int[] B1 = new int[mid]; 
        int[] A2 = new int[n - mid];    int[] B2 = new int[n - mid];  

        divide(A, A1, A2);
        divide(B, B1, B2);

        boolean matchA1B1 = match(A1, B1);
        boolean matchA2B2 = match(A2, B2);

        if      (matchA1B1 && matchA2B2) return true;
        else if (matchA1B1 && match(A1, B2)) return true;
        else if (match(A2, B1) && matchA2B2) return true;
        else return false;
    }

    public static boolean areArraysEqual(int[] A, int[] B) {
        boolean exact_match = true;
        for (int i = 0; i < A.length; i++) {
            if (A[i] != B[i]) exact_match = false;
        }
        return exact_match;
    }

    public static void divide(int[] arr, int[] arr1, int[] arr2) {
        int c1 = 0; int c2 = 0;
        for (int i = 0; i < arr.length/2; i++) {
            arr1[c1++] = arr[i];
        }
        for (int i = arr.length/2; i < arr.length; i++) {
            arr2[c2++] = arr[i];
        }
    }
    public static void main(String[] args) throws Exception {
        //System.out.println(args.length);
        if (args.length != 1) {
            throw new Exception("Invalid number of arguments given!");
        } 
        File input = new File(args[0]);
        Scanner reader = new Scanner(input);
        int n = Integer.parseInt(reader.nextLine());
        int[] arr1 = new int[n]; int[] arr2 = new int[n];
        String[] line2 = reader.nextLine().split(" ", 0); 
        String[] line3 = reader.nextLine().split(" ", 0);

        reader.close();

        if (line2.length != n || line3.length != n) throw new Exception("Input strings are not of " + n + " length!");

        for (int i = 0; i < n; i++) {
            arr1[i] = Integer.parseInt(line2[i]);
            arr2[i] = Integer.parseInt(line3[i]);
        }

        if (match(arr1, arr2)) System.out.println("YES");
        else System.out.println("NO");
    }
}