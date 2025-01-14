public class lab5 {
    public static int mergeSortAndCount(int[] S) {
        int count = 0;
        if (S.length < 2) {
            return count;
        }
        int[] S1 = new int[S.length/2];
        int[] S2 = new int[S.length - S1.length];

        divide(S, S1, S2);
        count += mergeSortAndCount(S1);
        count += mergeSortAndCount(S2);
        count += merge(S1, S2, S);

        return count;
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
    public static int merge(int[] S1, int[] S2, int[] S) {
        int i = 0;
        int j = 0;
        int k = 0;
        int count = 0;
        while (i < S1.length && j < S2.length) {
            if (S1[i] <= S2[j]) {
                S[k] = S1[i];
                i++;
            } else {
                S[k] = S2[j];
                j++;
                count += (S1.length - i);
            } k++;
        }

        while (i < S1.length) {
            S[k++] = S1[i++];
        }
        while (j < S2.length) {
            S[k++] = S2[j++];
        }
        return count;
    }
    public static void main(String args[]) {
        int[] S = {2, 1, 5, 3, 4}; //array, modifiable
        System.out.println(mergeSortAndCount(S));
    } 
}