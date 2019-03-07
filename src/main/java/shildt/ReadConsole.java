package shildt;

public class ReadConsole {
    public static void main (String args[])
        throws java.io.IOException {

            int i;
            System.out.println("FOr stop print q");
            for (i = 0; (char) System.in.read() != 'Q'; i++)
                System.out.println("Step " + i);
        }
}
