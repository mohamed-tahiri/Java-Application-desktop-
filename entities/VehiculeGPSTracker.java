package entities;

import java.util.Date;
import java.util.List;

public class VehiculeGPSTracker {
	// attributs 
	private int id;
	private Vehicule vehicule;
	private Tracker tracker;
	private Date dateDebut;
	private Date dateFin;
	private static int comp;
	
	// Constructeur
	public VehiculeGPSTracker( Date dateDebut, Date dateFin ,Vehicule vehicule, Tracker tracker) {
		this.id           = ++comp    ;
		this.vehicule     = vehicule;
		this.tracker      = tracker;
		this.dateDebut    = dateDebut;
		this.dateFin      = dateFin;
	}

        public VehiculeGPSTracker(int id , Date dateDebut, Date dateFin ,Vehicule vehicule, Tracker tracker) {
            this.id           = id;
            this.vehicule     = vehicule;
            this.tracker      = tracker;
            this.dateDebut    = dateDebut;
            this.dateFin      = dateFin;
	}
	

	// Setter et Getter
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public Vehicule getVehicule() {
		return vehicule;
	}

	public void setVehicule(Vehicule vehicule) {
		this.vehicule = vehicule;
	}

	public Tracker getTracker() {
		return tracker;
	}

	public void setTracker(Tracker tracker) {
		this.tracker = tracker;
	}

	public Date getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	public Date getDateFin() {
		return dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	// Method toString
	@Override
	public String toString() {
		return "VehiculeGPSTracker ** id : " + id + "\n" + 
				"\t" + "Vehicule   : " + vehicule + "\n" +
				"\t" + "GPSTracker : " + tracker + "\n" +
				"\t" + "Date Debut : " + dateDebut + "\n" +
				"\t" + "Date Fin   : " + dateFin ;
	}
	
}
