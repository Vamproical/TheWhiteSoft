public class Cinema {
    private final Scanner scanner = new Scanner(System.in);
    private String[][] theater;
    private int numberOfPurchasedTickets = 0;
    private int currentIncome = 0;
    private int rows;
    private int seatsRow;

    private void fillCinema(int rows, int column) {
        theater = new String[column][rows];
        for (int i = 0; i < column; i++) {
            for (int j = 0; j < rows; j++) {
                theater[i][j] = "S";
            }
        }
    }
    private void printCinema() {
        int k = 1;
        System.out.print("  ");
        for (int i = 1; i <= theater[0].length; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (String[] strings : theater) {
            System.out.print(k + " ");
            for (int j = 0; j < theater[0].length; j++) {
                System.out.print(strings[j] + " ");
            }
            k++;
            System.out.println();
        }
    }

    private boolean setSeat() {
        System.out.println("Enter a row number:");
        int row = scanner.nextInt();
        System.out.println("Enter a seat number in that row:");
        int seatRow = scanner.nextInt();
        if (row > seatsRow || row < 0 || seatRow > rows || seatRow < 0) {
            System.out.println("Wrong input!");
            return false;
        }
        if (theater[row - 1][seatRow - 1].equals("B")) {
            System.out.println("That ticket has already been purchased");
            return false;
        }
        int income = Price.priceSeat(rows,seatsRow,row);
        currentIncome += income;
        System.out.println();
        System.out.println("Ticket price: $" + income);
        theater[row - 1][seatRow - 1] = "B";
        numberOfPurchasedTickets++;
        return  true;
    }

    private void menu() {
        System.out.println("Enter the number of rows:");
        rows = scanner.nextInt();
        System.out.println("Enter the number of seats in each row:");
        seatsRow = scanner.nextInt();
        fillCinema(seatsRow,rows);
        boolean flag = false;
        while (!flag) {
            System.out.println();
            System.out.println("1. Show the seats\n" +
                    "2. Buy a ticket\n" +
                    "3. Statistics\n" +
                    "0. Exit");
            int i = scanner.nextInt();
            switch (i) {
                case 1:
                    System.out.println("Cinema:");
                    printCinema();
                    break;
                case 2:
                    boolean complete;
                    do {
                        complete = setSeat();
                    } while (!complete);
                    break;
                case 3:
                    System.out.println("Number of purchased tickets: " + numberOfPurchasedTickets);
                    System.out.printf("Percentage: %.2f%%\n", (double) ((numberOfPurchasedTickets * 100) / (rows * seatsRow)));
                    System.out.println("Current income: $" + currentIncome);
                    System.out.println("Total income: $" + Price.totalIncome(rows,seatsRow));
                    break;
                case 0:
                    flag = true;
                    break;
            }
        }
    }
}