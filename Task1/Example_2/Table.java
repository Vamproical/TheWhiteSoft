public class Table {
    private final char[][] table = new char[3][3];

    public Table() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                table[i][j] = ' ';
            }
        }
    }

    private void printTable() {
        System.out.println("---------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(table[i][j] + " ");
            }
            System.out.println("|");
        }
        System.out.println("---------");
    }

    private boolean isEmpty() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (table[i][j] == ' ') {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isImpossible() {
        int countX = 0, countO = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (table[i][j] == 'X') {
                    ++countX;
                } else if (table[i][j] == 'O') {
                    ++countO;
                }
            }
        }
        return countX - countO >= 2 || countO - countX >= 2;
    }

    private boolean isWin(char value) {
        boolean horizontal = (value == table[0][0] && value == table[0][1] && value == table[0][2]) ||
                (value == table[1][0] && value == table[1][1] && value == table[1][2]) ||
                (value == table[2][0] && value == table[2][1] && value == table[2][2]);
        boolean vertical = (value == table[0][0] && value == table[1][0] && value == table[2][0]) ||
                (value == table[0][1] && value == table[1][1] && value == table[2][1]) ||
                (value == table[0][2] && value == table[1][2] && value == table[2][2]);
        boolean diagonal = (value == table[0][0] && value == table[1][1] && value == table[2][2]) ||
                (value == table[0][2] && value == table[1][1] && value == table[2][0]);
        return horizontal || vertical || diagonal;
    }
}