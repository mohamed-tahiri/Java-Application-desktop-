package entities;

public class Tracker {

    private int id;
    private int simNumber;

    public Tracker(int simNumber) {
        super();
        this.simNumber = simNumber;
    }

    public Tracker(int id, int simNumber) {
        super();
        this.id = id;
        this.simNumber = simNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSimNumber() {
        return simNumber;
    }

    public void setSimNumber(int simNumber) {
        this.simNumber = simNumber;
    }

    @Override
    public String toString() {
        return " "+simNumber;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Tracker other = (Tracker) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

}
