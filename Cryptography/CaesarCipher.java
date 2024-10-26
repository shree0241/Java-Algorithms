public class CaesarCipher {
    public String encrypt(String text, int shift) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (Character.isUpperCase(ch)) {
                char c = (char) (((int) ch + shift - 65) % 26 + 65);
                result.append(c);
            } else if (Character.isLowerCase(ch)) {
                char c = (char) (((int) ch + shift - 97) % 26 + 97);
                result.append(c);
            } else {
                result.append(ch);
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        CaesarCipher cc = new CaesarCipher();
        String text = "HelloWorld";
        int shift = 4;
        System.out.println("Encrypted Text : " + cc.encrypt(text, shift));
    }
}
