package recursion;

import java.io.File;


public class RecursiveDirectoryTreePrinter {

    public static final String SPACES = "   ";
    static int count = 0;

    public static void main(String[] args) {
        assert args != null : "args cant be null";

        if(args.length != 1){
            System.err.println("Usage: REcursiveDirectoryTreePrinter <dir>");
            System.exit(4);
        }

        print(new File(args[0]), "");
        System.out.println(count);
    }

    static void print(File file, String spaces){
        count++;
        System.out.print(spaces);
        System.out.println(file.getName());

        if(file.isDirectory()){
            print(file.listFiles(), spaces + SPACES);
        }
    }

    static void print(File[] files, String spaces){
        for (File file :
                files) {
            print(file, spaces);
        }
    }
}
