public class lab6 {
    public static void MaxHeapify(int[] A, int i, int heap_size) {
        int left = Left(i);
        int right = Right(i);
        int largest = i;

        if (left < heap_size && A[left] > A[largest]) {
            largest = left;
        }

        if (right < heap_size && A[right] > A[largest]) {
            largest = right;
        }

        if (largest != i) {
            int temp = A[i];
            A[i] = A[largest];
            A[largest] = temp;
            MaxHeapify(A, largest, heap_size);
        }
    }

    public static int Left(int i) {
        return 2*i + 1;
    }

    public static int Right(int i) {
        return 2*i + 2;
    }

    public static void HeapSort(int[] A) {
        for (int heap_size = A.length - 1; heap_size > 0; heap_size--) {
            int temp = A[heap_size];
            A[heap_size] = A[0];
            A[0] = temp;
            MaxHeapify(A, 0, heap_size);
        }
    }
    public static void main(String[] args) {
        int[] A1 = {6, 5, 4, 1, 2, 3};
        int[] A2 = {99, 19, 9, 7, 11, 3, 3, 2, 2, 1};

        HeapSort(A1);
        HeapSort(A2);

        System.out.print("A1: ");
        for (int i : A1) {
            System.out.print(i + " ");
        } System.out.print("\nA2: ");
        for (int i : A2) {
            System.out.print(i + " ");
        } System.out.print("\n");
    }
}