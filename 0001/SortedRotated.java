public class SortedRotated {

    public static void main(String[] args) {
        System.out.println("Expected 3: " + SortedRotated.numOfRotated(new int[] {6, 7, 8, 1, 2, 3})); // 3
        System.out.println("Expected 0: " + SortedRotated.numOfRotated(new int[] {1, 2, 3})); // 0
        System.out.println("Expected 1: " + SortedRotated.numOfRotated(new int[] {4, 2, 3})); // 1
    }

    public static int numOfRotated(int[] arr) {
        int found = search(arr, 0, arr.length - 1);
        return found;
    }

    public static int search(int[] arr, int low, int high) {
        if (arr[low] > arr[high]) {
            int mid = low + ((high - low) / 2);
            if (arr[mid] > arr[high]) {
                return search(arr, mid+1, high);
            } else {
                return search(arr, low, mid);
            }
        } else {
            return low;
        }
    }
    /*
        References:
        http://comproguide.blogspot.com/2014/03/how-many-times-sorted-array-is-rotated.html
    */
}
