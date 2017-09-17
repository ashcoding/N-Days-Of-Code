import java.util.Arrays;
public class Heap {

    public static void main(String[] args) {
        int notUsed = -1337;
        int[] unsorted = {notUsed, 1, 9, 3, 6, 2, 8, 19, 10};
        System.out.println(Arrays.toString(unsorted));
        Heap.sort(unsorted);
        System.out.println(Arrays.toString(unsorted));
    }

    public static void sort(int[] arr) {
        int length = arr.length;
        // Get into heap order. Start from last leaf
        for (int i = length/2; i >= 1; i--) {
            sink(arr, i, length);
        }
        for (int i = 1; i < length; i++) {
            swap(arr, 1, length-i);
            sink(arr, 1, length-i-1);
        }
    }

    public static void sink(int[] arr, int pos, int n) {
        int lc = pos*2;
        if (lc > n) {
            // No more children
            return;
        }
        int rc = lc + 1;
        // Max between children
        int max = rc >= n ? lc : (arr[rc] > arr[lc]) ? rc : lc;

        if (arr[pos] > arr[max]) {
            // Already a max heap
            return;
        }
        // Max is in the child. Swap the values.
        swap(arr, pos, max);

        // Recursive sink from the child position aka max.
        sink(arr, max, n);
    }

    public static void swap(int[] arr, int thing, int other) {
        int temp = arr[thing];
        arr[thing] = arr[other];
        arr[other] = temp;
    }
}
