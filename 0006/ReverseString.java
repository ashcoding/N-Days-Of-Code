public class ReverseString {
    public static void main(String[] args) {
        String word = "Supercalifragilisticexpialidocious";
        System.out.println(word);
        System.out.println(reverse(word));
    }

    public static String reverse(String word) {
        char[] in = word.toCharArray();

        for (int i = 0; i < (in.length / 2); i++) {
            char temp = in[i];
            in[i] = in[in.length - i - 1];
            in[in.length - i - 1] = temp;
        }

        return new String(in);
    }
}
