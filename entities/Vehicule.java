package entities;

public class Vehicule {
	// attributs 
	private int id;
	private String matricule;
	private String marque;
	private String type;
	private static int comp;
	
	// Constructeur
	public Vehicule(String matricule, String marque, String type) {
		this.id = ++comp;
		this.matricule = matricule;
		this.marque = marque;
		this.type = type;
	}
	
	public Vehicule(int id ,String matricule, String marque, String type) {
		super();
		this.id = id;
		this.matricule = matricule;
		this.marque = marque;
		this.type = type;
	}

	// Getter et Setter
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMatricule() {
		return matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	public String getMarque() {
		return marque;
	}

	public void setMarque(String marque) {
		this.marque = marque;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	// Method toString
	@Override
	public String toString() {
		return marque;
	}
        
        public boolean equals(Object obj) {
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            final Vehicule other = (Vehicule) obj;
            if (this.id != other.id) {
                return false;
            }
            return true;
        }
	
}
