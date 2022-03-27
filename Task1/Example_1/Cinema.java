public class Cinema {
    private final String[][] theater;
    private int numberOfPurchasedTickets = 0;
    private double currentIncome = 0;

    public Cinema(int row, int seatsInRow) {
        theater = new String[row][seatsInRow];
        fillCinema();
    }

    private void fillCinema() {
        for (int i = 0; i < theater.length; i++) {
            for (int j = 0; j < theater[i].length; j++) {
                theater[i][j] = "S";
            }
        }
    }

    private void printCinema() {
        System.out.print("  ");
        for (int i = 1; i <= theater[0].length; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < theater.length; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < theater[i].length; j++) {
                System.out.print(strings[j] + " ");
            }
            System.out.println();
        }
    }

    private boolean setSeat(int row, int seatRow) {
        if (row > seatsRow || row < 0 || seatRow > rows || seatRow < 0) {
            System.out.println("Wrong input!");
            return false;
        }
        if (theater[row - 1][seatRow - 1].equals("B")) {
            System.out.println("That ticket has already been purchased");
            return false;
        }
        theater[row - 1][seatRow - 1] = "B";
        return true;
    }

    public void saleTicket() {
        int row, int seatRow;
        boolean complete;

        do {
            System.out.println("Enter a row number:");
            row = scanner.nextInt();
            System.out.println("Enter a seat number in that row:");
            seatRow = scanner.nextInt();
            complete = setSeat(row, seatRow);
        } while (!complete);

        numberOfPurchasedTickets++;

        double income = Price.priceSeat(theater.length, theater[0].length, row);
        currentIncome += income;

        System.out.println();
        System.out.println("Ticket price: $" + income);
    }
}