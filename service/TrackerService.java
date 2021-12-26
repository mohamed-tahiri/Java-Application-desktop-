package service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connexion.Connexion;
import dao.IDao;
import entities.Position;
import entities.Tracker;
import entities.Vehicule;
import entities.VehiculeGPSTracker;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TrackerService implements IDao<Tracker> {

    @Override
    public boolean create(Tracker o) {
        try {
            String req = "insert into tracker values (null, ?)";
            PreparedStatement pr = Connexion.getConnection().prepareStatement(req);
            pr.setInt(1, o.getSimNumber());
            if (pr.executeUpdate() != 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean update(Tracker o) {
        try {
            String req = "update tracker set simNumber = ? where id = ?";
            PreparedStatement pr = Connexion.getConnection().prepareStatement(req);
            pr.setInt(1, o.getSimNumber());
            pr.setInt(2, o.getId());
            if (pr.executeUpdate() != 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(Tracker o) {
        try {
            String req = "delete from tracker where id = ?";
            PreparedStatement pr = Connexion.getConnection().prepareStatement(req);
            pr.setInt(1, o.getId());
            if (pr.executeUpdate() != 0) {
                return true;
            }
        } catch (SQLException e) {
            
        }
        return false;
    }

    @Override
    public Tracker findById(int id) {
        try {
            String req = "select * from tracker where id = ?";
            PreparedStatement pr = Connexion.getConnection().prepareStatement(req);
            pr.setInt(1, id);
            ResultSet rs = pr.executeQuery();
            if (rs.next()) {
                return new Tracker(rs.getInt("id"), rs.getInt("simNumber"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Tracker> findAll() {
        List<Tracker> trackers = new ArrayList<Tracker>();
        try {
            String req = "select * from tracker";
            PreparedStatement pr = Connexion.getConnection().prepareStatement(req);
            ResultSet rs = pr.executeQuery();
            while (rs.next()) {
                trackers.add(new Tracker(rs.getInt("id"), rs.getInt("simNumber")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return trackers;
    }
    
    public List<Tracker> ChartTrackerByposition() {
        List<Tracker> trackers = new ArrayList<Tracker>();
        try {
            String req = "select idtracker as id, count(*) as simNumber from position group by idtracker ;" ;
            PreparedStatement pr = Connexion.getConnection().prepareStatement(req);
            ResultSet rs = pr.executeQuery();
            while (rs.next()) {
                trackers.add(new Tracker(rs.getInt("id"), rs.getInt("simNumber")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return trackers;
    }
    
    public List<Tracker> ChartNombrePositionsVehiculeAnnee(Vehicule vehicule) throws ParseException {
        List<Tracker> trackers = new ArrayList<Tracker>();
        try {
            
            String req = "SELECT COUNT(*) as nbr , YEAR(p.date) as date "
                    + "from position p , vehiculegpstracker v "
                    + "WHERE p.idTracker = v.idGpsTracker "
                    + "AND v.idVehicule = ? "
                    + "GROUP BY YEAR(date)" ;
            PreparedStatement pr = Connexion.getConnection().prepareStatement(req);
            
            
            pr.setInt(1, vehicule.getId());
            
            ResultSet rs = pr.executeQuery();
            while (rs.next()) {
                trackers.add(new Tracker(rs.getInt("nbr"), rs.getInt("date")));
            }
            
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        for(Tracker t: trackers )
            System.out.println(t);
        return trackers;
    }
    
    public List<Tracker> ChartNombrePositionsVehiculeMois(Vehicule vehicule, int annee) throws ParseException {
        List<Tracker> trackers = new ArrayList<Tracker>();
        try {
            String req = "select COUNT(*) as nbrPsVAnnee , MONTH ( p.date ) as date "
                    + "from position p , vehiculegpstracker vgt "
                    + "where p.id = vgt.id "
                    + "and MONTH(p.date) = MONTH(?)"
                    + "and vgt.idVehicule = ? "
                    + "GROUP BY DATE(YEAR(p.date));" ;
            PreparedStatement pr = Connexion.getConnection().prepareStatement(req);
            
            
            SimpleDateFormat originalFormat = new SimpleDateFormat("yyyyMMdd");
            
            Date date = originalFormat.parse(Integer.toString(annee));
            SimpleDateFormat newFormat = new SimpleDateFormat("yyyy-MM-dd");
            String formatedDate = newFormat.format(date);
            
            java.util.Date ANNEE = newFormat.parse(formatedDate);
            java.sql.Date dateAnnee = new java.sql.Date(ANNEE.getTime());
            
            pr.setDate(1, dateAnnee);
            pr.setInt(2, vehicule.getId());
            
            String mois = originalFormat.format(date);
            StringBuilder MyString = new StringBuilder(mois);
            
            MyString = MyString.deleteCharAt(0);
            MyString = MyString.deleteCharAt(0);
            MyString = MyString.deleteCharAt(0);
            MyString = MyString.deleteCharAt(0);
            MyString = MyString.deleteCharAt(2);
            MyString = MyString.deleteCharAt(2);
            
            String singleString = MyString.toString();
            int MoisInt = Integer.parseInt(singleString);
            ResultSet rs = pr.executeQuery();
            while (rs.next()) {
                trackers.add(new Tracker(rs.getInt("nbrPsVAnnee"), MoisInt));
            }
            
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        for(Tracker t: trackers )
            System.out.println(t);
        return trackers;
    }   
     
}
