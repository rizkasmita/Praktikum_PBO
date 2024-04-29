// import java.util.*;
import java.io.*;
// import java.util.ArrayList;

public abstract class User {
    protected String usn, pw, name;
    // protected ArrayList<Komik> DataKomik;
    protected abstract void displayData() throws IOException;
    protected abstract void menu() throws IOException, InterruptedException;
    protected static int jml = 0;
    protected InputStreamReader p = new InputStreamReader(System.in);
    protected BufferedReader input = new BufferedReader(p);

    public User(String usn, String pw, String name) {
        this.usn = usn;
        this.pw = pw;
        this.name = name;
        p = new InputStreamReader(System.in);
        input = new BufferedReader(p);
        jml++;
    }

    public String getUsn() {
        return usn;
    }

    public String getPw() {
        return pw;
    }

    protected void greeting() {
        System.out.println("Hello, " + this.name + "!");
    }

    protected boolean isNum(String str) {
        if (str == null) {
            return false;
        }
        try {
            int i = Integer.parseInt(str);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    protected void clear() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
