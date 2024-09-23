package com.customer;

import java.util.LinkedList;
import java.util.Queue;

public class CustomerSupportTicketSystem {
    private Queue<String> tickets = new LinkedList<>();

    public void addTicket(String ticket) {
        tickets.add(ticket);
    }

    public void processTicket() {
        if (!tickets.isEmpty()) {
            System.out.println("Processing ticket: " + tickets.poll());
        } else {
            System.out.println("No tickets to process.");
        }
    }

    public void displayTickets() {
        if (tickets.isEmpty()) {
            System.out.println("No pending tickets.");
        } else {
            System.out.println("Pending tickets:");
            for (String ticket : tickets) {
                System.out.println(ticket);
            }
        }
    }

    public static void main(String[] args) {
        CustomerSupportTicketSystem system = new CustomerSupportTicketSystem();

        // Example usage
        system.addTicket("Ticket 1");
        system.addTicket("Ticket 2");
        system.processTicket();
        system.displayTickets();
    }
}

