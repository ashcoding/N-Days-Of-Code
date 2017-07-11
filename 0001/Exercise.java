public class Exercise {
    public static void main(String[] args) {
        System.out.println("Expected 3: " + SortedRotated.numOfRotated(new int[] {6, 7, 8, 1, 2, 3})); // 3
        System.out.println("Expected 0: " + SortedRotated.numOfRotated(new int[] {1, 2, 3})); // 0
        System.out.println("Expected 1: " + SortedRotated.numOfRotated(new int[] {4, 2, 3})); // 1
    }
}
