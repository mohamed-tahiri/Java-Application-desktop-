package test;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import connexion.Connexion;

public class Test {
	
	public static void main(String[] args) {
            try {

                //  tableau User
                String TUser = "create table user ("
                                + "id int primary key auto_increment,"
                                + "fullname varchar(50) NOT NULL,"
                                + "email varchar(50) NOT NULL UNIQUE,"
                                + "secret varchar(100) NOT NULL,"
                                + "password varchar(50) NOT NULL);";

                //  tableau Tracker
                String TTracker = "create table tracker ("
                                + "id int primary key auto_increment,"
                                + "simNumber int NOT NULL);";

                // tableau Position
                String TPosition = "create table position ("
                                + "id int primary key auto_increment,"
                                + "latitude double NOT NULL,"
                                + "longitude double NOT NULL,"
                                + "date date NOT NULL, "
                                + "idTracker int NOT NULL);";

                // fk
                String Fk = "alter table position add constraint fk " 
                                + "foreign key (idTracker) references tracker(id)"
                                + "ON DELETE CASCADE;";

                // Contraint tableau Vehicule
                String TVehicule = "create table vehicule (" 
                                + "id int primary key auto_increment,"
                                + "matricule varchar(50) NOT NULL," 
                                + "marque varchar(50) NOT NULL," 
                                + "type varchar(50) NOT NULL);";

                // Contraint tableau VehiculeGPSTracker
                String TVehiculeGPSTracker = "create table vehiculeGPSTracker (" 
                                + "id int primary key auto_increment,"
                                + "dateDebut Date NOT NULL," 
                                + "dateFin Date NOT NULL," 
                                + "idVehicule int NOT NULL," 
                                + "idGpsTracker int NOT NULL);";

                // Contraint tableau VehiculeGPSTracker
                String Fk1 = "alter table vehiculeGPSTracker add constraint fk1 " 
                                + "foreign key (idVehicule) references vehicule(id)"
                                + "ON DELETE CASCADE;";

                String Fk2 = "alter table vehiculeGPSTracker add constraint fk2 " 
                                + "foreign key (idGpsTracker) references tracker(id)"
                                + "ON DELETE CASCADE;";

                Statement st = Connexion.getConnection().createStatement();
                // Verification de l'existance des Tableaux
                st.execute("drop table if exists position");
                st.execute("drop table if exists tracker");
                st.execute("drop table if exists vehicule");
                st.execute("drop table if exists vehiculeGPSTracker");
                st.execute("drop table if exists user");
                
                // Creation des Tableaux
                st.executeUpdate(TUser);
                st.executeUpdate(TTracker);
                st.executeUpdate(TPosition);
                st.executeUpdate(TVehicule);
                st.executeUpdate(TVehiculeGPSTracker);
                
                // Creation des cles etrangeres 
                st.executeUpdate(Fk);
                st.executeUpdate(Fk1);
                st.executeUpdate(Fk2);

            } catch (SQLException e) {
                e.printStackTrace();
            }
		
	}

}
