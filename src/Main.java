import java.util.Arrays;

public class Main {

    static int[][] field;
    static int len = 6;
    static int wid = 6;
    static boolean loop;

    public static void main(String[] args) throws Exception{
        System.out.println("Hello world!");
        setup();
        for (int r=0; r<10; r++) {
            generation();
        }
    }

    public static void setup() {
        field = new int[len][wid];
        loop = true;
        for (int l=0; l<10; l++) place(1);
        for (int k=0; k<5; k++) place(2);
    }

    public static int anzahl(int type) {
        int count=0;
        for (int i=0; i<len; i++) {
            for (int j = 0; j < wid; j++) {
                if (field[i][j] == type) count++;
            }
        }
        return count;
    }

    public static void generation() throws Exception{
        round1();
        round2();
        round3();
        round4();
        round5();
        round6();
    }

    public static void round1() {
        int neuLaus = (int) Math.ceil(anzahl(1)/2);
        for (int i=0; i<neuLaus; i++) {
            place(1);
        }
    }

    public static void place(int type) {
        loop = true;
        while (loop) {
            int x = (int) (Math.random()*len);
            int y = (int) (Math.random()*wid);
            if (field[x][y] == 0) {
                field[x][y] = type;
                loop = false;
            }
        }

    }

    public static void round2() {
        for (int i=0; i<len; i++) {
            for (int j=0; j<wid; j++) {
                if (field[i][j] == 2) field[i][j] = 3;
            }
        }
    }

    public static void round3() {
        for (int i=0; i<len; i++) {
            for (int j=0; j<wid; j++) {
                if (field[i][j] == 3) moveKaefer();
            }
        }
    }

    public static void moveKaefer() {
        int x = (int) (Math.random()*len);
        int y = (int) (Math.random()*wid);
        if (field[x][y] == 1) field[x][y] = 2;
        else if (field[y][x] == 1) field[y][x] = 2;
    }

    public static void round4() {
        //TODO: Larven-Behaviour hinzufügen

    }

    public static void round5() {
        for (int i=0; i<len; i++) {
            for (int j=0; j<wid; j++) {
                if (field[i][j] == 5) field[i][j] = 2;
                else if (field[i][j] == 4) field[i][j] = 5;
                else if (field[i][j] == 3) field[i][j] = 4;
            }
        }
    }

    public static void round6() throws Exception{
        DBAccess.insert(anzahl(2), anzahl(1),
                anzahl(3), anzahl(4) , anzahl(5));
        ausgabe();
    }

    public static void ausgabe() {
        for (int[] row : field) System.out.println(Arrays.toString(row));
        System.out.println("\n");
    }
}