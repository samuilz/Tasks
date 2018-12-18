package clock;

import java.util.Scanner;

public class Main {
    private static final String ADD = "ADD";
    private static final String SUBTRACT = "SUBTRACT";
    private static final String END = "END";
    private static String action = "";
    private static Integer minutes = 0;

    public static void main(String[] args) {
        Clock clock = new Clock();

        while (true) {
            boolean isActive = readInput();

            if(!isActive) {
                break;
            }

            act(clock);

            getTime(clock);
        }
    }

    private static void getTime(Clock clock) {
        clock.getTime();
    }

    private static void act(Clock clock) {
        switch (action) {
            case ADD:
                clock.addMinutes(minutes);
                break;
            case SUBTRACT:
                clock.subtractMinutes(minutes);
                break;
        }
    }

    private static boolean readInput() {
        Scanner in = new Scanner(System.in);

        System.out.println("Please enter your minutes or enter End(case insensitive) to stop the program");
        System.out.println("The minutes should be of type Integer: ");
        String line = in.nextLine();

        if(line.toUpperCase().equals(END)) {
            return false;
        }

        try {
            minutes = Integer.parseInt(line);
        } catch (NumberFormatException e) {
            System.out.println("Please enter correct data!\n");
            readInput();
        }

        System.out.println("Choose your action");
        System.out.println("It should be Add or Subtract (case insensitive): ");
        action = in.nextLine().toUpperCase();

        return true;
    }
}
