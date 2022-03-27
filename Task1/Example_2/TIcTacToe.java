package tictactoe;

import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
    private final Random random = new Random();
    private final Scanner scanner = new Scanner(System.in);

    public void game() {
        Table table = new Table();
        table.printTable();
        char player = 'X';
        while (!gameStatus().equals("Game not finished")) {
            movePerson(player, table);
            table.printTable();
            moveComputer(table);
            table.printTable();
        }
        System.out.println(checkRes());
    }

    private void movePerson(char player, Table table) {
        boolean flag = true;
        while (flag) {
            System.out.println("Enter the coordinates: ");
            int x;
            try {
                x = Integer.parseInt(scanner.nextLine) - 1;
            } catch (NumberFormatException e) {
                System.out.println("You should enter numbers!");
                return;
            }
            int y;
            try {
                y = Integer.parseInt(scanner.nextLine) - 1;
            } catch (NumberFormatException e) {
                System.out.println("You should enter numbers!");
                return;
            }
            if (x > 2 || x < 0 || y < 0 || y > 2) {
                System.out.println("Coordinates should be from 1 to 3!");
            } else {
                if (table[2 - y][x] == ' ') {
                    table[2 - y][x] = player;
                    flag = false;
                } else {
                    System.out.println("This cell is occupied! Choose another one!");
                }
            }
        }
    }

    private void moveComputer(Table table) {
        boolean flag = true;
        while (flag) {
            int x = random.nextInt(3), y = random.nextInt(3);
            if (table[2 - y][x] == ' ') {
                table[2 - y][x] = 'O';
                flag = false;
            }
        }
    }

    private String gameStatus(Table table) {
        if (table.isWin('X') && table.isWin('O') || table.isImpossible()) {
            return "Impossible";
        } else if (!table.isWin('X') && !table.isWin('O') && table.isEmpty()) {
            return "Game not finished";
        } else if (!table.isEmpty() && !table.isWin('X') && !table.isWin('O')) {
            return "Draw";
        }
        if (table.isWin('O')) {
            return "O wins";
        } else if (table.isWin('X')) {
            return "X wins";
        }
        return null;
    }
}