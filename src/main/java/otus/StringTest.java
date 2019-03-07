package otus;

public class StringTest {

    public static void main(String[] arg) {
        String str1 = "abc";
        String str2 = new String(new char[]{'a', 'b', 'c'});
        System.out.println(str1);
        System.out.println(str2);

        System.out.println(str1 == str2);
        System.out.println(str1.equals(str2));

        System.out.println(str1.contains("bc"));
        System.out.println("a" + "b" + "C");

        StringBuilder tmp = new StringBuilder();
        for (int i = 0; i < 100; i++) {
            tmp.append(i + "_");
        }
        System.out.println(tmp.toString());


    }

}
