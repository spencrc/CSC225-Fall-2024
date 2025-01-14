import java.io.File;
import java.util.Scanner;

public class Lab7 {
    public static boolean PairSum225_BF(int[] A) {
        int n = A.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (A[i] + A[j] == 225) {
                    return true;
                }
            }
        }
        return false;
    }
    public static boolean PairSum225_LR(int[] A) {
        int n = A.length;
        int i = 0;
        int j = n - 1;

        mergeSort(A);

        while (i < n && j >= 0 && i < j) {
            if      (A[i] + A[j] == 225) return true;
            else if (A[i] + A[j] >  225) j--;
            else     i++;
        }
        return false;
    }
    public static boolean PairSum225_CS(int[] A) {
        int     n = A.length;
        int[]   countedA = new int[226];

        for (int i = 0; i < n; i++) {
            if (A[i] >= 0 && A[i] <= 225) countedA[A[i]]++;
        } 

        for (int i = 0; i < 226; i++) {
            int j = n - 1 - i;
            if (i == j) {
                if (countedA[i] >= 2) return true;
            } else if (A[i] > 0 && A[j] > 0) {
                return true;
            }
        }
        return false;
    }
    public static void mergeSort(int[] S) {
        if (S.length < 2) {
            return;
        }
        int[] S1 = new int[S.length/2];
        int[] S2 = new int[S.length - S1.length];

        divide(S, S1, S2);

        mergeSort(S1);
        mergeSort(S2);

        merge(S1, S2, S);
    }
    public static void divide(int[] S, int[] S1, int[] S2) {
        int c1 = 0; int c2 = 0;
        for (int i = 0; i < S1.length; i++) {
            S1[c1++] = S[i];
        }
        for (int i = S.length/2; i < S.length; i++) {
            S2[c2++] = S[i];
        }
    }
    public static void merge(int[] S1, int[] S2, int[] S) {
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < S1.length && j < S2.length) {
            if (S1[i] <= S2[j]) {
                S[k] = S1[i];
                i++;
            } else {
                S[k] = S2[j];
                j++;
            } k++;
        }

        while (i < S1.length) {
            S[k++] = S1[i++];
        }
        while (j < S2.length) {
            S[k++] = S2[j++];
        }
    }
    public static void main(String[] args) throws Exception {
         //System.out.println(args.length);
        File input = new File(args[0]);
        Scanner reader = new Scanner(input);
        String[] line1 = reader.nextLine().split(" ", 0);
        int[] arr = new int[line1.length];

        reader.close();

        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(line1[i]);
        }

        if (PairSum225_CS(arr)) System.out.println("225");
        else                    System.out.println("NO 225");
    }
}