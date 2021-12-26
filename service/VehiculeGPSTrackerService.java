package service;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import connexion.Connexion;
import dao.IDao;
import entities.Tracker;
import entities.Position;
import entities.Vehicule;
import entities.VehiculeGPSTracker;
import java.util.Arrays;

public class VehiculeGPSTrackerService implements IDao<VehiculeGPSTracker> {

        private TrackerService ts = new TrackerService();
        private VehiculeService vs = new VehiculeService();
	@Override
	public boolean create(VehiculeGPSTracker vgt) {
		try {
			String req = "insert into VehiculeGPSTracker values (null, ?, ?, ?, ?)";
			PreparedStatement pr = Connexion.getConnection().prepareStatement(req);
			pr.setDate(1, new Date( vgt.getDateDebut().getTime()));
			pr.setDate(2, new Date( vgt.getDateFin().getTime()));
			pr.setInt(3, vgt.getTracker().getId());
			pr.setInt(4, vgt.getVehicule().getId());
			if (pr.executeUpdate() == 1)
				return true;
		} catch (SQLException e) {
			System.out.println("Create : Erreur");
		}
		return false;
	}

	@Override
	public boolean delete(VehiculeGPSTracker vgt) {
		try {
			String req = "delete from  VehiculeGPSTracker where id  = ?";
			PreparedStatement pr = Connexion.getConnection().prepareStatement(req);
			pr.setInt(1, vgt.getId());
			if (pr.executeUpdate() == 1)
				return true;
		} catch (SQLException e) {
			System.out.println("Delete : Erreur");
		}
		return false;
	}

	@Override
	public boolean update(VehiculeGPSTracker vgt) {
		try {
			String req = "update VehiculeGPSTracker set dateDebut = ? , dateFin = ? , idVehicule = ? , idGpsTracker = ? where id = ?";
			PreparedStatement pr = Connexion.getConnection().prepareStatement(req);
			pr.setDate(1, new Date( vgt.getDateDebut().getTime() ));
			pr.setDate(2, new Date( vgt.getDateFin().getTime() ));
			pr.setInt(3, vgt.getVehicule().getId());
			pr.setInt(4, vgt.getTracker().getId());
			pr.setInt(5, vgt.getId());
			
			if (pr.executeUpdate() == 1)
				return true;
		} catch (SQLException e) {
			System.out.println("Update : Erreur");
		}
		return false;
	}

	@Override
	public VehiculeGPSTracker findById(int id) {
		try {
			String req = "select * from VehiculeGPSTracker where id  = ?";
			PreparedStatement pr = Connexion.getConnection().prepareStatement(req);
			pr.setInt(1, id);
			ResultSet rs = pr.executeQuery();
			if (rs.next()) {
				return new VehiculeGPSTracker(rs.getInt("id") ,rs.getDate("dateDebut"), 
                                        rs.getDate("dateFin"), vs.findById(rs.getInt("idVehicule")) , ts.findById(rs.getInt("idGpsTracker")) );
			}

		} catch (SQLException e) {
			System.out.println("Erreur :: VehiculeGPSTracker : FindById");
		}

		return null;
	}

	@Override
	public List<VehiculeGPSTracker> findAll() {
            List<VehiculeGPSTracker> vehiculeGPSTrackers = new ArrayList<VehiculeGPSTracker>();
            try {
                    String req = "select * from VehiculeGPSTracker";
                    PreparedStatement pr = Connexion.getConnection().prepareStatement(req);

                    ResultSet rs = pr.executeQuery();
                    while (rs.next()) {
                            vehiculeGPSTrackers.add(new VehiculeGPSTracker(rs.getInt("id") ,rs.getDate("dateDebut"), rs.getDate("dateFin"), 
                                    vs.findById(rs.getInt("idVehicule")) , ts.findById(rs.getInt("idGpsTracker")) ));
                    }

            } catch (SQLException e) {
                    System.out.println("Erreur :: VehiculeGPSTracker : findAll");
            }

            return vehiculeGPSTrackers;	
	}
	
	
    public List <Position> findPositionsBetweenDates (Tracker tracker, Date dateDebut, Date dateFin){

        List<Position> Positions = new ArrayList<Position>();

        PositionService ps = new PositionService();
        
        for(Position p : ps.findAll())
            if(p.getTracker().getId() == tracker.getId() && p.getDate().after(dateDebut) && p.getDate().before(dateFin))
                Positions.add(p);
        
        
        return Positions;	
    }
        
        
    public List <Position> findPositionsVehBetweenDates (Vehicule vehicule, Date dateDebut, Date dateFin){

        List<Tracker> trackers = new ArrayList<Tracker>();
        List<Position> positions = new ArrayList<Position>();

        
        PositionService ps = new PositionService();
        
        VehiculeGPSTrackerService vgs = new VehiculeGPSTrackerService();
        for(VehiculeGPSTracker vs : vgs.findAll())
            if(vs.getVehicule().getId() == vehicule.getId() && vs.getDateDebut().after(dateDebut) && vs.getDateFin().before(dateFin))
                    trackers.add(vs.getTracker());
        
        
        for(Position p: ps.findAll())
            for(Tracker t : trackers)
                if(p.getTracker().getId() == t.getId())
                    positions.add(p);
        
  
        List<Position> ListPositions = new ArrayList<Position>();
  
        for (Position p : positions) {
  
            if (!ListPositions.contains(p)) {
  
                ListPositions.add(p);
            }
        }
  
        return ListPositions;
    }
}
