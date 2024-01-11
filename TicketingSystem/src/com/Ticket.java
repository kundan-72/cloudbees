package com;

import com.util.TrainSection;

public class Ticket {
	
    private static int seatCounter = 1;
    private User user;
    private int seat;
    private TrainSection section;
    private double price;
    
    private Location from;
    private Location to;
    
    enum Location {
    		France, London;
    }
    
    public Ticket(User user, TrainSection section) {
        this.user = user;
        this.section = section;
        this.price = 20;
        this.seat = seatCounter++;

        this.setTo(Location.France);
        this.setFrom(Location.London);
        
        
    }
    
    public User getUser() {
        return user;
    }

    public int getSeat() {
        return seat;
    }

    public TrainSection getSection() {
        return section;
    }

    public double getPrice() {
        return price;
    }

    public void setSeat(int newSeat) {
        this.seat = newSeat;
    }

	public Location getFrom() {
		return from;
	}

	public void setFrom(Location london) {
		this.from = london;
	}

	public Location getTo() {
		return to;
	}

	public void setTo(Location france) {
		this.to = france;
	}

}
