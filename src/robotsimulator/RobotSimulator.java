package robotsimulator;

import java.util.Scanner;


public class RobotSimulator {
    private static final String NORTH = "NORTH";
    private static final String EAST = "EAST";
    private static final String WEST = "WEST";
    private static final String SOUTH = "SOUTH";
    private static final String RIGHT = "R";
    private static final String LEFT = "L";
    private static final String ADVANCE = "A";
    private static final String EMPTY_STRING = "";
    private static int directionX = 0;
    private static int directionY = 0;
    private static int x = 0;
    private static int y = 0;
    private static String instructions;

    public static void main(String[] args) {
        readInput();

        boolean isValid = processInstructions();

        if (!isValid) {
            return;
        }

        printResult();
    }

    private static void readInput() {
        Scanner in = new Scanner(System.in);

        try {
            System.out.println("Please enter starting X coordinate: ");
            x = Integer.parseInt(in.nextLine());
            System.out.println("Please enter starting Y coordinate: ");
            y = Integer.parseInt(in.nextLine());

        } catch (NumberFormatException e) {
            System.out.println("You entered incorrect data!\n");
            readInput();
        }

        System.out.println("Please enter facing direction");
        System.out.println("It should be EAST, WEST, NORTH or SOUTH: ");
        String direction = in.nextLine();

        boolean isDirectionValid = initDirections(direction);

        if (!isDirectionValid) {
            readInput();
        }

        System.out.println("Please enter your instructions");
        System.out.println("They should be in format RAL (e.g. RAALAL) where R stands for right, " +
                "L stands for Left and A stands for Advance: ");
        instructions = in.nextLine();
    }

    private static boolean initDirections(String direction) {
        switch (direction) {
            case NORTH:
                directionX = 0;
                directionY = 1;
                break;
            case EAST:
                directionX = 1;
                directionY = 0;
                break;
            case SOUTH:
                directionX = 0;
                directionY = -1;
                break;
            case WEST:
                directionX = -1;
                directionY = 0;
                break;
            default:
                System.out.println("You entered incorrect direction!\n");
                return false;
        }

        return true;
    }

    private static boolean processInstructions() {
        for (int index = 0; index < instructions.length(); index++) {
            String currentCommand = instructions.substring(index, index + 1);

            switch (currentCommand) {
                case RIGHT:
                    turnRight();
                    break;
                case LEFT:
                    turnLeft();
                    break;
                case ADVANCE:
                    changeCoordinates();
                    break;
                default:
                    System.out.println("You entered incorrect instruction!\n");
                    return false;
            }
        }

        return true;
    }

    private static void turnRight() {
        if (directionX == 1) {
            directionX = 0;
            directionY = -1;
        } else if (directionX == -1) {
            directionX = 0;
            directionY = 1;
        } else if (directionY == 1) {
            directionY = 0;
            directionX = 1;
        } else if (directionY == -1) {
            directionY = 0;
            directionX = -1;
        }
    }

    private static void turnLeft() {
        if (directionX == 1) {
            directionX = 0;
            directionY = 1;
        } else if (directionX == -1) {
            directionX = 0;
            directionY = -1;
        } else if (directionY == 1) {
            directionY = 0;
            directionX = -1;
        } else if (directionY == -1) {
            directionY = 0;
            directionX = 1;
        }
    }

    private static void changeCoordinates() {
        x = x + directionX;
        y = y + directionY;
    }

    private static void printResult() {
        System.out.printf("Final coordinates are: (%d, %d)\n", x, y);
        String finalDirection = calculateFinalDirection();
        System.out.printf("The robot now facing %s", finalDirection);
    }

    private static String calculateFinalDirection() {
        String finalDirection = EMPTY_STRING;

        if (directionX == 1) {
            finalDirection = EAST;
        } else if (directionX == -1) {
            finalDirection = WEST;
        } else if (directionY == 1) {
            finalDirection = NORTH;
        } else if (directionY == -1) {
            finalDirection = SOUTH;
        }

        return finalDirection;
    }
}
