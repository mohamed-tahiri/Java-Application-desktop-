package service;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connexion.Connexion;
import dao.IDao;
import entities.Vehicule;
import entities.VehiculeGPSTracker;

public class VehiculeService implements IDao<Vehicule> {

	public boolean create(Vehicule v) {
		try {
			String req = "insert into Vehicule values (null, ?, ?, ?)";
			PreparedStatement pr = Connexion.getConnection().prepareStatement(req);
			pr.setString(1, v.getMatricule());
			pr.setString(2, v.getMarque());
			pr.setString(3, v.getType());
			if (pr.executeUpdate() == 1)
				return true;
		} catch (SQLException e) {
			System.out.println("Create : Erreur");
		}
		return false;
	}

	@Override
	public boolean delete(Vehicule v) {
            try {
                    String req = "delete from  Vehicule where id  = ?";
                    PreparedStatement pr = Connexion.getConnection().prepareStatement(req);
                    pr.setInt(1, v.getId());
                    if (pr.executeUpdate() == 1)
                            return true;
            } catch (SQLException e) {
                    System.out.println("Delete : Erreur");
            }
            return false;
	}

	@Override
	public boolean update(Vehicule v) {
		try {
			String req = "update Vehicule set matricule = ? , marque = ? , type = ?  where id = ?";
			PreparedStatement pr = Connexion.getConnection().prepareStatement(req);
			pr.setString(1, v.getMatricule());
			pr.setString(2, v.getMarque());
			pr.setString(3, v.getType());
			pr.setInt(4, v.getId());
			
			if (pr.executeUpdate() == 1)
				return true;
		} catch (SQLException e) {
			System.out.println("Update : Erreur");
		}
		return false;
	}

	@Override
	public Vehicule findById(int id) {
            try {
                String req = "select * from Vehicule where id  = ?";
                PreparedStatement pr = Connexion.getConnection().prepareStatement(req);
                pr.setInt(1, id);
                ResultSet rs = pr.executeQuery();
                if (rs.next()) {
                        return new Vehicule(rs.getInt("id"), rs.getString("matricule"), rs.getString("marque"), rs.getString("type"));
                }

            } catch (SQLException e) {
                    System.out.println("Erreur :: Vehicule : FindById");
            }

            return null;
	}

	@Override
	public List<Vehicule> findAll() {
            List<Vehicule> vehicules = new ArrayList<Vehicule>();
            try {
                String req = "select * from Vehicule";
                PreparedStatement pr = Connexion.getConnection().prepareStatement(req);

                ResultSet rs = pr.executeQuery();
                while (rs.next()) {
                        vehicules.add(new Vehicule(rs.getInt("id"), rs.getString("matricule"), rs.getString("marque"), rs.getString("type")));
                }

            } catch (SQLException e) {
                    System.out.println("Erreur :: Vehicule : findAll");
            }

            return vehicules;
	}
		
}
