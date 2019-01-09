public class BreakTest {
    public static void main (String args[]) {
        int i;
        for (i=1; i<4; i++){
            one:
            {
                two:
                {
                    three:
                    {
                        System.out.println("\n равно " + i);
                        if (i == 1) break one;
                        if (i == 1) break two;
                        if (i == 1) break three;

                        System.out.println("------");
                    }
                    System.out.println("After three");
                }
                System.out.println("After two");
            }
            System.out.println("After one");
        }
        System.out.println("After for");
    }
}
