package test;

import java.util.Date;

import entities.Position;
import service.PositionService;
import service.TrackerService;

public class TestPosition {

	public static void main(String[] args) {
		TrackerService ts = new TrackerService();
		PositionService ps = new PositionService();
		
		ps.create(new Position(41, -9, new Date(), ts.findById(1)));
		ps.create(new Position(71, -8, new Date(), ts.findById(2)));
		ps.create(new Position(91, -2, new Date("1999/02/01"), ts.findById(1)));
		
		ps.delete(ps.findById(1));

		for(Position p : ps.findAll()) {
			System.out.println(p);
		}
	}

}
