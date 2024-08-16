import java.util.Scanner;

// A class to represent the Lecture Room
class LectureRoom {
    private int numberOfStudents;
    private final boolean[] lights;

    public LectureRoom() {
        numberOfStudents = 0;
        lights = new boolean[3]; // Represents 3 lights (light 1, light 2, light 3)
    }

    // Method to add students
    public void addStudents(int count) {
        if (count > 0) {
            numberOfStudents += count;
            System.out.println(count + " students added. Total students: " + numberOfStudents);
        } else {
            System.out.println("Invalid number of students.");
        }
    }

    // Method to remove students
    public void removeStudents(int count) {
        if (count > 0 && count <= numberOfStudents) {
            numberOfStudents -= count;
            System.out.println(count + " students removed. Total students: " + numberOfStudents);
        } else if (count > numberOfStudents) {
            numberOfStudents = 0;
            System.out.println("Too many students to remove. Room is now empty.");
        } else {
            System.out.println("Invalid number of students.");
        }
    }

    // Method to turn on a specific light
    public void turnOnLight(int lightNumber) {
        if (lightNumber >= 1 && lightNumber <= 3) {
            lights[lightNumber - 1] = true;
            System.out.println("Light " + lightNumber + " is turned on.");
        } else {
            System.out.println("Invalid light number. Please enter 1, 2, or 3.");
        }
    }

    // Method to turn off a specific light
    public void turnOffLight(int lightNumber) {
        if (lightNumber >= 1 && lightNumber <= 3) {
            lights[lightNumber - 1] = false;
            System.out.println("Light " + lightNumber + " is turned off.");
        } else {
            System.out.println("Invalid light number. Please enter 1, 2, or 3.");
        }
    }

    // Method to display the current status of the room
    public void displayStatus() {
        System.out.println("Lecture Room Status:");
        System.out.println("Number of Students: " + numberOfStudents);
        System.out.print("Lights: ");
        for (int i = 0; i < lights.length; i++) {
            System.out.print("Light " + (i + 1) + " is " + (lights[i] ? "ON" : "OFF") + " | ");
        }
        System.out.println();
    }
}

// Main program that interacts with the user
public class LectureRoomManager {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            LectureRoom room = new LectureRoom();
            char choice;
            
            do {
                // Display the main menu
                System.out.println("\n=== Lecture Room Control Menu ===");
                System.out.println("W: Add Students");
                System.out.println("X: Remove Students");
                System.out.println("Y: Turn On Light");
                System.out.println("Z: Turn Off Light");
                System.out.println("S: Show Room Status");
                System.out.println("Q: Quit");
                
                // Prompt the manager for a choice
                System.out.print("Enter your choice: ");
                choice = scanner.next().toUpperCase().charAt(0);
                
                switch (choice) {
                    case 'W' -> {
                        System.out.print("Enter number of students to add: ");
                        int studentsToAdd = scanner.nextInt();
                        room.addStudents(studentsToAdd);
                    }
                        
                    case 'X' -> {
                        System.out.print("Enter number of students to remove: ");
                        int studentsToRemove = scanner.nextInt();
                        room.removeStudents(studentsToRemove);
                    }
                        
                    case 'Y' -> {
                        System.out.print("Enter the light number to turn on (1, 2, or 3): ");
                        int lightToTurnOn = scanner.nextInt();
                        room.turnOnLight(lightToTurnOn);
                    }
                        
                    case 'Z' -> {
                        System.out.print("Enter the light number to turn off (1, 2, or 3): ");
                        int lightToTurnOff = scanner.nextInt();
                        room.turnOffLight(lightToTurnOff);
                    }
                        
                    case 'S' -> room.displayStatus();
                        
                    case 'Q' -> System.out.println("Exiting the program...");
                        
                    default -> System.out.println("Invalid option! Please choose a valid menu option.");
                }
            } while (choice != 'Q');
        }
    }
}
