import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
public class App {
    // Global variables
    private static int[][] seats = null;

    public static void main(String[] args) {
        System.out.println("Welcome to the Theatre App!");
        initialiseRows();
        runMenu();
    }
    public static void initialiseRows() {
        seats = new int[2][]; // total rows - multidimensional array
        seats[0] = new int[12]; // row 1 - initialised at 0 all available
        seats[1] = new int[16]; // row 2 - initialised at 0 all available
    }
    public static void runMenu() {
        int option;
        boolean cont = true;

        while (cont) {
            option = getOption();
            switch (option) {
                case 0:
                    cont = false;
                    break;
                case 1:
                    buyTicket();
                    break;
                case 2:
                    showSeatingArea();
                    break;
                case 3:
                    addShow();
                    break;
                case 4:
                    addUser();
                    break;
                case 5:
                    saveToFile();
                    break;
                default:
                    System.out.println("Option not available. Please select a valid option: ");
            }
        }
    }
    private static int getOption() {
        Scanner input = new Scanner(System.in);
        boolean valid = false;
        int option = -1;
        do {
            System.out.println();
            System.out.println("+---------------------------------------------+");
            System.out.println("|                MAIN MENU                    |");
            System.out.println("+---------------------------------------------+");
            System.out.println("|  1) Buy a ticket                            |");
            System.out.println("|  2) Show seating area and available seats   |");
            System.out.println("|  3) Add Show                                |");
            System.out.println("|  4) Add User                                |");
            System.out.println("|  5) Save information to file                |");
            System.out.println("|  0) Quit                                    |");
            System.out.println("+---------------------------------------------+");
            System.out.print("Please select an option: ");
            try {
                option = input.nextInt();
                valid = true;
                input.close();
            } catch (Exception e) {
                System.out.println("This option not valid.");
            }
        } while (!valid);
        return option;
        

    }
    private static void buyTicket() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter row number: ");
        int row = input.nextInt() - 1;
        System.out.print("Enter seat number: ");
        int seat = input.nextInt() - 1;
        input.close();
        // Check if the seat is available or not
        if (seats[row][seat] == 0) {
            seats[row][seat] = 1;
            System.out.println("Purchase successful.");
            showSeatingArea();
        } else {
            System.out.println("This seat is already taken.");
        }
        
    }
    private static void showSeatingArea() {
        int rows = seats.length;
        System.out.println("=".repeat(76));
        System.out.println("                              STAGE ");
        System.out.println("=".repeat(76));

        for (int row = 0; row < rows; row++) {
            System.out.print("Row " + (row + 1) + "  ");
            int seatsPerRow = seats[row].length;
            if (row == 0) {
                System.out.print("      ");
            }
            for (int seat = 0; seat < seatsPerRow; seat++) {
                if (seats[row][seat] == 0) { //available
                    System.out.print("[O]");
                } else { // not available
                    System.out.print("[X]");
                }
            }
            System.out.println();
        }
        System.out.println("=".repeat(76));
        System.out.println("LEGEND: [O] = Seat available, [X] = Seat not available");
        System.out.println("=".repeat(76));
        System.out.println();
    }
    private static void addShow() {
        // method not implemented
    }
    private static void addUser() {
        // method not implemented
    }
    private static void saveToFile() {
        try {
            FileWriter file = new FileWriter("TheatreData.txt");
            file.write("Data:\n");
            // Implement save data here based on test task
            file.close();
            System.out.println("Data saved to file.");
        } catch (IOException exception) {
            System.out.println("Error while writing in a file.");
        }
    }
}