package service;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connexion.Connexion;
import dao.IDao;
import entities.Position;

public class PositionService implements IDao<Position> {

	private TrackerService ts = new TrackerService();

	@Override
	public boolean create(Position o) {
		try {
			String req = "insert into Position values (null, ?, ?, ? , ?)";
			PreparedStatement pr = Connexion.getConnection().prepareStatement(req);
			pr.setDouble(1, o.getLatitude());
			pr.setDouble(2, o.getLongitude());
			pr.setDate(3, new Date(o.getDate().getTime()));
			pr.setInt(4, o.getTracker().getId());
			if (pr.executeUpdate() != 0)
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public boolean update(Position o) {
		try {
			String req = "update position set latitude = ?, longitude = ?, date = ?, idTracker = ? where id = ?";
			PreparedStatement pr = Connexion.getConnection().prepareStatement(req);
			pr.setDouble(1, o.getLatitude());
			pr.setDouble(2, o.getLongitude());
			pr.setDate(3, new Date(o.getDate().getTime()));
			pr.setInt(4, o.getTracker().getId());
			pr.setInt(5, o.getId());
			if (pr.executeUpdate() != 0)
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean delete(Position o) {
		try {
			String req = "delete from position where id = ?";
			PreparedStatement pr = Connexion.getConnection().prepareStatement(req);
			pr.setInt(1, o.getId());
			if (pr.executeUpdate() != 0)
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Position findById(int id) {
		try {
			String req = "select * from position where id = ?";
			PreparedStatement pr = Connexion.getConnection().prepareStatement(req);
			pr.setInt(1, id);
			ResultSet rs = pr.executeQuery();
			if (rs.next())
				return new Position(rs.getInt("id"), rs.getDouble("latitude"), rs.getDouble("longitude"),
						rs.getDate("date"), ts.findById(rs.getInt("idTracker")));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Position> findAll() {
		List<Position> positions = new ArrayList<Position>();
		try {
			String req = "select * from Position";
			PreparedStatement pr = Connexion.getConnection().prepareStatement(req);
			ResultSet rs = pr.executeQuery();
			while (rs.next())
				positions.add(new Position(rs.getInt("id"), rs.getDouble("latitude"), rs.getDouble("longitude"),
						rs.getDate("date"), ts.findById(rs.getInt("idTracker"))));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return positions;
	}

}
