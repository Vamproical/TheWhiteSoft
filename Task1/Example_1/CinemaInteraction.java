public class CinemaInteraction {
    public void run() {
        System.out.println("Enter the number of rows:");
        rows = scanner.nextInt();
        System.out.println("Enter the number of seats in each row:");
        seatsRow = scanner.nextInt();
        menu(new Cinema(rows, seatsRow))
    }
    public void menu(Cinema cinema) {
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
                    cinema.printCinema();
                    break;
                case 2:
                    cinema.saleTicket();
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
