import java.time.LocalDate;
import java.util.Scanner;

/**
 * Diese Klasse hilft bei der Eingabe in der Konsole
 *
 * @author Daniel (Francesco wurde die Nutzung gewährt)
 * @date 2099-06-08
 */
public class Einleser {
    static Scanner scanner;

    public Einleser() {
        scanner = new Scanner(System.in);
    }

    public int readInt(String msg, String err, int von, int bis) {
        if (msg != null) {
            System.out.print(msg);
        }
        if (err == null) {
            if (von == bis) {
                err = "Bitte Ganzzahl eingeben   > ";
            } else {
                err = "Bitte Ganzzahl zwischen %d und %d eingeben   > ";
            }
        }
        int zahl = 0;
        while (true) {
            if (scanner.hasNextInt()) {
                zahl = scanner.nextInt();
                scanner.nextLine();
                if ((zahl > bis || zahl < von) && (von != bis)) {
                    System.err.printf(err, von, bis);
                } else {
                    break;
                }
            } else {
                System.err.printf(err, von, bis);
                scanner.next();
            }
        }
        return zahl;
    }

    public int readInt(String msg, int von, int bis) {
        return readInt(msg, null, von, bis);
    }

    public int readInt(int von, int bis) {
        return readInt(null, null, von, bis);
    }

    public int readInt(String msg, String err) {
        return readInt(msg, err, 0, 0);
    }

    public int readInt(String msg) {
        return readInt(msg, null, 0, 0);
    }

    public int readInt() {
        return readInt(0, 0);
    }

    public double readDouble(String msg, String err, double von, double bis) {
        if (msg != null) {
            System.out.print(msg);
        }
        if (err == null) {
            if (von == bis) {
                err = "Bitte Zahl eingeben   > ";
            } else {
                err = "Bitte Zahl zwischen %.1f und %.1f eingeben   > ";
            }
        }
        double zahl = 0;
        while (true) {
            if (scanner.hasNextDouble()) {
                zahl = scanner.nextDouble();
                scanner.nextLine();
                if ((zahl > bis || zahl < von) && (von != bis)) {
                    System.err.printf(err, von, bis);
                } else {
                    break;
                }
            } else {
                System.err.printf(err, von, bis);
                scanner.next();
            }
        }
        return zahl;
    }

    public double readDouble(String msg, double von, double bis) {
        return readDouble(msg, null, von, bis);
    }

    public double readDouble(double von, double bis) {
        return readDouble(null, null, von, bis);
    }

    public double readDouble(String msg, String err) {
        return readDouble(msg, err, 0, 0);
    }

    public double readDouble(String msg) {
        return readDouble(msg, null, 0, 0);
    }

    public double readDouble() {
        return readDouble(0, 0);
    }

    public boolean readBoolean(String msg) {
        if (msg != null) {
            System.out.println(msg);
        }
        while (!scanner.nextBoolean()) {
            System.err.println("Bitte \"true\" oder \"false\" eingeben");
            scanner.next();
        }
        boolean bool = scanner.nextBoolean();
        scanner.nextLine();

        return bool;
    }

    public boolean readBoolean() {
        return readBoolean(null);
    }

    public String readString(String msg) {
        if (msg != null) {
            System.out.print(msg);
        }
        //scanner.next();
        return scanner.nextLine();
    }

    public String readString() {
        return readString(null);
    }

    public char readChar(String msg, String err, char[] options) {
        if (msg != null) {
            System.out.print(msg);
        }
        if (err == null) {
            if (options == null) {
                err = "Bitte geben sie einen Buchstaben ein";
            } else {
                err = "Diese Möglichkeit gibt es nicht > ";
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

    public LocalDate readDate(String msg) {
        if (msg != null) {
            System.out.println(msg);
        }
        LocalDate date = null;
        int jahr = readInt("Jahr  > ");
        int monat = readInt("Monat > ", 1, 12);
        int tag = readInt("Tag   > ", 1, 31);
        date = LocalDate.of(jahr, monat, tag);

        return date;
    }

    public LocalDate readDate() {
        return readDate(null);
    }
}
