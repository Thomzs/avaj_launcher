package edu.tmeyer.avaj_launcher;

public class Main {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("ERROR: One argument (filePath) is expected");
        } else {
            Simulator simulator = new Simulator(args[0]);

            try {
                simulator.run();
            } catch (Exception e) {
                System.out.println("ERROR: " + e.getMessage());
            }
        }
    }
}
