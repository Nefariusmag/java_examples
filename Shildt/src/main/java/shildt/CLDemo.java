package shildt;

public class CLDemo {
    public static void main (String args[]) {
        System.out.println("I have " + args.length + " args, list this args:");
        for (int i=0; i < args.length; i++) {
            System.out.println(args[i]);
        }
    }
}
