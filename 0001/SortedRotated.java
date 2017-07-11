public class SortedRotated {
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
