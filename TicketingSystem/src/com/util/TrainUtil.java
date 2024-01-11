package com.util;

import java.util.HashMap;
import java.util.Map;

import com.Ticket;
import com.User;


public class TrainUtil {

	private static Map<String, Ticket> ticketsByUser = new HashMap<>();

	public Ticket purchaseTicket(User user, TrainSection section) {
		Ticket ticket = new Ticket(user, section);
		ticketsByUser.put(user.getEmail(), ticket);
		return ticket;
	}

	public Ticket viewTicket(String userEmail) {
		return ticketsByUser.get(userEmail);
	}

	public void viewUsersBySection(TrainSection section) {
		for (Ticket ticket : ticketsByUser.values()) {
			if (ticket.getSection() == section) {
				System.out
						.println(ticket.getUser().getFullName() + " - Seat: " + ticket.getSeat() + " - Price: $" + ticket.getPrice());
			}
		}
	}

	public void removeUser(String userEmail) {
		if (ticketsByUser.containsKey(userEmail)) {
            ticketsByUser.remove(userEmail);
            System.out.println("User " + userEmail + " removed successfully.");
        } else {
            System.out.println("User not found.");
        }
	}

	public void modifyUserSeat(String userEmail, int newSeat) {
		Ticket ticket = ticketsByUser.get(userEmail);
		if (ticket != null) {
			ticket.setSeat(newSeat);
		}
	}
	
	public void viewReceipt(String userEmail) {
        Ticket ticket = ticketsByUser.get(userEmail);
        if (ticket != null) {
            System.out.println("From: " + ticket.getFrom());
            System.out.println("To: " + ticket.getTo());
            System.out.println("User: " + ticket.getUser().getFullName());
            System.out.println("Price Paid: $" + ticket.getPrice());
        } else {
            System.out.println("Ticket not found for the user.");
        }
    }

}
