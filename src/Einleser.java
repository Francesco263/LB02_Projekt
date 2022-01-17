import java.util.Scanner;
/**
 * @author XX
 * @since 2021-01-XX
 * @version 1.0
 */
public class Einleser {
    static Scanner scanner;

    public Einleser() {
        scanner = new Scanner(System.in);
    }

    public char readChar(String msg, String err, char[] options) {
        if (msg != null) {
            System.out.print(msg);
        }
        if (err == null) {
            if (options == null) {
                err = "Please enter a valid character, please try again > ";
            } else {
                err = "This option is not available, please try again > ";
            }
        }
        char ch;
        if (options != null) {
            while (true) {
                ch = scanner.next().toLowerCase().charAt(0);
                scanner.nextLine();
                boolean bool = false;
                for (int i = 0; i < options.length; i++) {
                    if (options[i] == ch) {
                        bool = true;
                    }
                }
                if (!bool) {
                    System.err.print(err);
                } else {
                    break;
                }
            }
        } else {
            ch = scanner.next().toLowerCase().charAt(0);
            scanner.nextLine();
        }
        return ch;
    }

    public char readChar(String msg) {
        return readChar(msg, null, null);
    }

    public char readChar(String msg, String err) {
        return readChar(msg, err, null);
    }

    public char readChar(String msg, char[] options) {
        return readChar(msg, null, options);
    }
    
    public char readChar(char[] options) {
        return readChar(null, null, options);
    }
}
