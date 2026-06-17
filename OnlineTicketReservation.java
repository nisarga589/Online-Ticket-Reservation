package arrays;

import java.util.Scanner;

public class OnlineTicketReservation {

    static int[] ticketIds = {101, 102, 103, 104, 105};
    static String[] destinations = {
            "Delhi",
            "Mumbai",
            "Bangalore",
            "Chennai",
            "Kolkata"
    };

    static boolean[] booked = new boolean[5];

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        while (true) {

            System.out.println("\n===== ONLINE TICKET RESERVATION SYSTEM =====");
            System.out.println("1. View Available Tickets");
            System.out.println("2. Book Ticket");
            System.out.println("3. Cancel Ticket");
            System.out.println("4. View Booked Tickets");
            System.out.println("5. Exit");

            System.out.print("Enter Choice: ");
            int choice = in.nextInt();

            switch (choice) {

                case 1:
                    viewTickets();
                    break;

                case 2:
                    System.out.print("Enter Ticket ID to Book: ");
                    int bookId = in.nextInt();
                    bookTicket(bookId);
                    break;

                case 3:
                    System.out.print("Enter Ticket ID to Cancel: ");
                    int cancelId = in.nextInt();
                    cancelTicket(cancelId);
                    break;

                case 4:
                    viewBookedTickets();
                    break;

                case 5:
                    System.out.println("Thank You!");
                    System.exit(0);

                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }

    static void viewTickets() {

        System.out.println("\nAvailable Tickets:");

        for (int i = 0; i < ticketIds.length; i++) {

            if (!booked[i]) {

                System.out.println(
                        "Ticket ID: " + ticketIds[i] +
                                " | Destination: " + destinations[i]
                );
            }
        }
    }

    static void bookTicket(int id) {

        for (int i = 0; i < ticketIds.length; i++) {

            if (ticketIds[i] == id) {

                if (!booked[i]) {

                    booked[i] = true;

                    System.out.println(
                            "Ticket Booked Successfully!"
                    );

                } else {

                    System.out.println(
                            "Ticket Already Booked!"
                    );
                }

                return;
            }
        }

        System.out.println("Invalid Ticket ID!");
    }

    static void cancelTicket(int id) {

        for (int i = 0; i < ticketIds.length; i++) {

            if (ticketIds[i] == id) {

                if (booked[i]) {

                    booked[i] = false;

                    System.out.println(
                            "Ticket Cancelled Successfully!"
                    );

                } else {

                    System.out.println(
                            "Ticket Was Not Booked!"
                    );
                }

                return;
            }
        }

        System.out.println("Invalid Ticket ID!");
    }

    static void viewBookedTickets() {

        System.out.println("\nBooked Tickets:");

        boolean found = false;

        for (int i = 0; i < ticketIds.length; i++) {

            if (booked[i]) {

                found = true;

                System.out.println(
                        "Ticket ID: " + ticketIds[i] +
                                " | Destination: " + destinations[i]
                );
            }
        }

        if (!found) {

            System.out.println("No Tickets Booked Yet!");
        }
    }
}
