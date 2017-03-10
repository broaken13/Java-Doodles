/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fileio;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author bjo
 */
public class ContactProgram {

    private final Path filePath;
    private List<Contact> contacts = new ArrayList<>();
    private final Scanner stdIn = new Scanner(System.in);

    public ContactProgram(Path p) throws IOException {
        filePath = p;
        readFile();
    }

    public void run() throws IOException {
        System.out.println("---------------------------------");
        System.out.println("           Contact App           ");
        System.out.println("---------------------------------");
        printHelp();

        String input = "";
        while (!input.equals("quit")) {
            System.out.print("Enter a command: ");
            input = stdIn.next();
            input = input.toLowerCase();
            switch (input) {
                case "add":
                    addContact();
                    break;
                case "print":
                    printContacts();
                    break;
                case "delete":
                    deleteContact();
                    break;
                case "quit":
                    System.out.println("Closing...");
                    break;
                case "help":
                    printHelp();
                    break;
                default:
                    System.out.println("Unknown Command");
                    break;
            }

            saveFile();

        }

    }

    private void printHelp() {
        System.out.println("\nCommands: ");
        System.out.println("Print - print all contacts");
        System.out.println("Add - add a contact");
        System.out.println("Delete - remove a contact");
        System.out.println("Quit - save and exit the program");
        System.out.println("Help - print this command list");
        System.out.println();
    }

    private void printContacts() {
        if (contacts.isEmpty()) {
            System.out.println("No contacts");
        } else {
            String header = String.format("%5s | %-20s | %-20s | %s %n","#", "First Name", "Last Name", "Phone Number");
            String line = String.format("%" + header.length() + "s", "").replace(' ', '-');
            System.out.print(header);
            System.out.println(line);
            for (int i = 0; i < contacts.size(); i++) {
                Contact contact = contacts.get(i);
                System.out.printf("%5d | %-20s | %-20s | %s %n", i + 1, contact.getFirstName(), contact.getLastName(), contact.getPhoneNumber());
            }
        }
        System.out.println();
    }

    private void addContact() {
        System.out.print("What is the contacts first name: ");
        String firstName = stdIn.next();
        System.out.print("What is the contacts last name: ");
        String lastName = stdIn.next();
        System.out.print("What is their phone number: ");
        String phoneNumber = stdIn.next();

        Contact contact = new Contact(firstName, lastName, phoneNumber);
        contacts.add(contact);
    }
    
    private void deleteContact() {
        System.out.print("Enter the contacts #: ");
        try {
            int index = Integer.parseInt(stdIn.next()) - 1;
            if(index > contacts.size() || index < 0) {
                throw new RuntimeException();
            }
            Contact toBeDeleted = contacts.get(index);
            System.out.print("Delete " + toBeDeleted.getFirstName() + " " + toBeDeleted.getLastName() + "? (Y/N): ");
            String confirmation = stdIn.next();
            if(confirmation.toLowerCase().charAt(0) == 'y') {
                contacts.remove(index);
            }
        } catch (RuntimeException e) {
            System.out.println("Not valid");
        }
    }

    private void saveFile() throws IOException {
        BufferedWriter w = Files.newBufferedWriter(filePath, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
        for(Contact c : contacts) {
            w.write(c.getFirstName() + "\t" + c.getLastName() + "\t" + c.getPhoneNumber());
            w.newLine();
        }
        
        w.flush();
        w.close();
    }

    private void readFile() throws IOException {
        if (Files.exists(filePath)) {
            BufferedReader r = Files.newBufferedReader(filePath);
            r.lines().forEach(line -> {
                String[] parts = line.split("\\t");
                Contact c = new Contact(parts[0], parts[1], parts[2]);
                contacts.add(c);
            });
            r.close();
        }
    }
}
