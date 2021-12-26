/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import com.teamdev.jxmaps.Circle;
import com.teamdev.jxmaps.CircleOptions;
import com.teamdev.jxmaps.LatLng;
import com.teamdev.jxmaps.Map;
import com.teamdev.jxmaps.MapOptions;
import com.teamdev.jxmaps.MapReadyHandler;
import com.teamdev.jxmaps.MapStatus;
import com.teamdev.jxmaps.MapTypeControlOptions;
import com.teamdev.jxmaps.Marker;
import connexion.Connexion;
import entities.Position;
import entities.Tracker;
import entities.User;
import entities.Vehicule;
import entities.VehiculeGPSTracker;
import java.awt.Color;
import java.sql.PreparedStatement;
import java.text.DateFormat;
import java.text.MessageFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import static java.util.Collections.list;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.jdbc.JDBCCategoryDataset;
import service.PositionService;
import service.TrackerService;
import service.UserService;
import service.VehiculeGPSTrackerService;
import service.VehiculeService;

/**
 *
 * @author TAHIRI
 */
public class MenuThrFrame extends javax.swing.JFrame  {

    
    private TrackerService ts;
    private PositionService ps;
    private VehiculeService vs;
    private UserService us;
    private VehiculeGPSTrackerService vts ;
    private DefaultTableModel modelTracker, modelPosition, modelVehicule, modelUser, modelTrackerVeh, modelTrackerPosition , modelVehiculePosition;
    private static int idTracker , idPosition , idVehicule , idUser , idTrackerVeh , idpositionTrakcerfind , idpositionVehiculefind ;
    
    
    
    public MenuThrFrame() {
        initComponents();
        this.setExtendedState(MAXIMIZED_BOTH);
        ts = new TrackerService();
        ps = new PositionService();
        vs = new VehiculeService();
        us = new UserService();
        vts = new VehiculeGPSTrackerService();
        VehiculePanel.setVisible(false);
        TrackerPanel.setVisible(false);
        PositionPanel.setVisible(false);
        UserPanel.setVisible(false);
        VehTrackerPanel.setVisible(false);
        positiontrackerPanel.setVisible(false);
        positionvehiculePanel.setVisible(false);
        Dash.setVisible(true);
        modelTracker          = (DefaultTableModel) ListeTrackerTable.getModel();
        modelPosition         = (DefaultTableModel) ListePositionTable.getModel();
        modelVehicule         = (DefaultTableModel) ListeVehiculeTable.getModel();
        modelUser             = (DefaultTableModel) ListeUserTable.getModel();
        modelTrackerVeh       = (DefaultTableModel) ListeVehTrackerTable.getModel();
        modelTrackerPosition  = (DefaultTableModel) listepositionTrakcerfind.getModel();
        modelVehiculePosition = (DefaultTableModel) listepositionVehiculefind.getModel();
        loadTracker();
        loadPositins();
        loadVehicule();
        loadListeTrackers();
        loadUser();
        loadTrackerVeh();
        loadListeVehicules();
        
    }
    
    // Tracker
    private void loadTracker() {
        modelTracker.setRowCount(0);
        for (Tracker t : ts.findAll()) {
            modelTracker.addRow(new Object[]{
                t.getId(),
                t.getSimNumber()
            });
        }
    }
    
    // Position
    private void loadPositins() {
        modelPosition.setRowCount(0);
        for (Position p : ps.findAll()) {
            modelPosition.addRow(new Object[]{
                p.getId(),
                p.getLatitude(),
                p.getLongitude(),
                p.getDate(),
                p.getTracker()
            });
        }
    }
    
    private void loadListeTrackers() {
        for (Tracker t : ts.findAll()) {
            listeTrackers.addItem(t);
            listeTrackers1.addItem(t);
            listeTrackers2.addItem(t);
        }
    }
    
    // Vehicule 
    private void loadVehicule() {
        modelVehicule.setRowCount(0);
        for (Vehicule v : vs.findAll()) {
            modelVehicule.addRow(new Object[]{
                v.getId(),
                v.getMatricule(),
                v.getMarque(),
                v.getType()
            });
        }
    }
    
    // User
    private void loadUser() {
        modelUser.setRowCount(0);
        for (User u : us.findAll()) {
            modelUser.addRow(new Object[]{
                u.getId(),
                u.getFullname(),
                u.getEmail()
            });
        }
    }
    
    // Tracker , Vehicule
    private void loadTrackerVeh() {
        modelTrackerVeh.setRowCount(0);
        for (VehiculeGPSTracker vg : vts.findAll()) {
            modelTrackerVeh.addRow(new Object[]{
                vg.getId(),
                vg.getDateDebut(),
                vg.getDateFin(),
                vg.getTracker(),
                vg.getVehicule()
            });
        }
    }
    
    private void loadListeVehicules() {
        for (Vehicule v : vs.findAll()) {
            ListeVehicule.addItem(v);
            ListeVehicule1.addItem(v);
            ListeVehicule2.addItem(v);
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Menu = new javax.swing.JPanel();
        MenuDashboard = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        MenuTracker = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        MenuPosition = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        MenuVehucile = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        MenuUtilisateur = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        TrackerVehicule = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        positionTracker = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        positionVehicule = new javax.swing.JPanel();
        jLabel30 = new javax.swing.JLabel();
        deconnecter = new javax.swing.JPanel();
        jLabel46 = new javax.swing.JLabel();
        TrackerPanel = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ListeTrackerTable = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        simNumberTxt = new javax.swing.JTextField();
        createbtnTracker = new javax.swing.JButton();
        deletebtnTracker = new javax.swing.JButton();
        updatebtnTracker = new javax.swing.JButton();
        PositionPanel = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        latitudeTxt = new javax.swing.JTextField();
        longitudeTxt = new javax.swing.JTextField();
        listeTrackers = new javax.swing.JComboBox();
        DateTxt = new com.toedter.calendar.JDateChooser();
        jPanel7 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        ListePositionTable = new javax.swing.JTable();
        CreatePositionBtn = new javax.swing.JButton();
        DeletePositionBtn = new javax.swing.JButton();
        UpdatePositionButton = new javax.swing.JButton();
        VehiculePanel = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        marqueTxt = new javax.swing.JTextField();
        matriculeTxt = new javax.swing.JTextField();
        typeTxt = new javax.swing.JTextField();
        jPanel9 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        ListeVehiculeTable = new javax.swing.JTable();
        CreateVehiculeBtn = new javax.swing.JButton();
        deleteVehiculeBtn = new javax.swing.JButton();
        updateVehiculeBtn = new javax.swing.JButton();
        UserPanel = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        fullnameTxt = new javax.swing.JTextField();
        emailTxt = new javax.swing.JTextField();
        secretTxt = new javax.swing.JTextField();
        passwordTxt = new javax.swing.JPasswordField();
        addUserBtn = new javax.swing.JButton();
        deleteUserBtn = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        ListeUserTable = new javax.swing.JTable();
        VehTrackerPanel = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        datedeDebutTxt = new com.toedter.calendar.JDateChooser();
        listeTrackers1 = new javax.swing.JComboBox();
        datedeFinTxt = new com.toedter.calendar.JDateChooser();
        ListeVehicule = new javax.swing.JComboBox();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        addtrackervehBtn = new javax.swing.JButton();
        deletetrackervehBtn = new javax.swing.JButton();
        updatetrackervehBtn = new javax.swing.JButton();
        jPanel13 = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        ListeVehTrackerTable = new javax.swing.JTable();
        positiontrackerPanel = new javax.swing.JPanel();
        listeTrackers2 = new javax.swing.JComboBox();
        datedeDebutTxt1 = new com.toedter.calendar.JDateChooser();
        datedeFinTxt1 = new com.toedter.calendar.JDateChooser();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel38 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel39 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        listepositionTrakcerfind = new javax.swing.JTable();
        searchBtn = new javax.swing.JButton();
        MapBtn = new javax.swing.JButton();
        imprimerBtn = new javax.swing.JButton();
        positionvehiculePanel = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jLabel40 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        listepositionVehiculefind = new javax.swing.JTable();
        jLabel42 = new javax.swing.JLabel();
        datedeDebutTxt2 = new com.toedter.calendar.JDateChooser();
        datedeFinTxt2 = new com.toedter.calendar.JDateChooser();
        jLabel43 = new javax.swing.JLabel();
        searchBtn1 = new javax.swing.JButton();
        jPanel15 = new javax.swing.JPanel();
        jLabel44 = new javax.swing.JLabel();
        ListeVehicule1 = new javax.swing.JComboBox();
        jLabel45 = new javax.swing.JLabel();
        MapBtn1 = new javax.swing.JButton();
        Dash = new javax.swing.JPanel();
        anneeBtn = new javax.swing.JButton();
        chartPositionTracker = new javax.swing.JButton();
        moisBtn = new javax.swing.JButton();
        jLabel41 = new javax.swing.JLabel();
        ListeVehicule2 = new javax.swing.JComboBox();
        dateTxt = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(1000, 550));
        getContentPane().setLayout(null);

        Menu.setBackground(new java.awt.Color(51, 51, 51));

        MenuDashboard.setBackground(new java.awt.Color(0, 102, 255));
        MenuDashboard.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MenuDashboardMouseClicked(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Bodoni MT", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Géolocalisation");

        javax.swing.GroupLayout MenuDashboardLayout = new javax.swing.GroupLayout(MenuDashboard);
        MenuDashboard.setLayout(MenuDashboardLayout);
        MenuDashboardLayout.setHorizontalGroup(
            MenuDashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenuDashboardLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        MenuDashboardLayout.setVerticalGroup(
            MenuDashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenuDashboardLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(0, 102, 255));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 58, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 29, Short.MAX_VALUE)
        );

        MenuTracker.setBackground(new java.awt.Color(0, 102, 255));
        MenuTracker.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MenuTrackerMouseClicked(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Tracker");

        javax.swing.GroupLayout MenuTrackerLayout = new javax.swing.GroupLayout(MenuTracker);
        MenuTracker.setLayout(MenuTrackerLayout);
        MenuTrackerLayout.setHorizontalGroup(
            MenuTrackerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenuTrackerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        MenuTrackerLayout.setVerticalGroup(
            MenuTrackerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
        );

        MenuPosition.setBackground(new java.awt.Color(0, 102, 255));
        MenuPosition.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MenuPositionMouseClicked(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Position");

        javax.swing.GroupLayout MenuPositionLayout = new javax.swing.GroupLayout(MenuPosition);
        MenuPosition.setLayout(MenuPositionLayout);
        MenuPositionLayout.setHorizontalGroup(
            MenuPositionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenuPositionLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        MenuPositionLayout.setVerticalGroup(
            MenuPositionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
        );

        MenuVehucile.setBackground(new java.awt.Color(0, 102, 255));
        MenuVehucile.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MenuVehucileMouseClicked(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Vehicule");

        javax.swing.GroupLayout MenuVehucileLayout = new javax.swing.GroupLayout(MenuVehucile);
        MenuVehucile.setLayout(MenuVehucileLayout);
        MenuVehucileLayout.setHorizontalGroup(
            MenuVehucileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenuVehucileLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        MenuVehucileLayout.setVerticalGroup(
            MenuVehucileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
        );

        MenuUtilisateur.setBackground(new java.awt.Color(0, 102, 255));
        MenuUtilisateur.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MenuUtilisateurMouseClicked(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Utilisateur");

        javax.swing.GroupLayout MenuUtilisateurLayout = new javax.swing.GroupLayout(MenuUtilisateur);
        MenuUtilisateur.setLayout(MenuUtilisateurLayout);
        MenuUtilisateurLayout.setHorizontalGroup(
            MenuUtilisateurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenuUtilisateurLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        MenuUtilisateurLayout.setVerticalGroup(
            MenuUtilisateurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
        );

        TrackerVehicule.setBackground(new java.awt.Color(0, 102, 255));
        TrackerVehicule.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TrackerVehiculeMouseClicked(evt);
            }
        });

        jLabel25.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("Tracker , Véhicule");

        javax.swing.GroupLayout TrackerVehiculeLayout = new javax.swing.GroupLayout(TrackerVehicule);
        TrackerVehicule.setLayout(TrackerVehiculeLayout);
        TrackerVehiculeLayout.setHorizontalGroup(
            TrackerVehiculeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TrackerVehiculeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel25)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        TrackerVehiculeLayout.setVerticalGroup(
            TrackerVehiculeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel25, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
        );

        positionTracker.setBackground(new java.awt.Color(0, 102, 255));
        positionTracker.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                positionTrackerMouseClicked(evt);
            }
        });

        jLabel29.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setText("Les positions enregistrées par un tracker");

        javax.swing.GroupLayout positionTrackerLayout = new javax.swing.GroupLayout(positionTracker);
        positionTracker.setLayout(positionTrackerLayout);
        positionTrackerLayout.setHorizontalGroup(
            positionTrackerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(positionTrackerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(76, Short.MAX_VALUE))
        );
        positionTrackerLayout.setVerticalGroup(
            positionTrackerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel29, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        positionVehicule.setBackground(new java.awt.Color(0, 102, 204));
        positionVehicule.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                positionVehiculeMouseClicked(evt);
            }
        });

        jLabel30.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setText(" Les positions d’un véhicule");

        javax.swing.GroupLayout positionVehiculeLayout = new javax.swing.GroupLayout(positionVehicule);
        positionVehicule.setLayout(positionVehiculeLayout);
        positionVehiculeLayout.setHorizontalGroup(
            positionVehiculeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 325, Short.MAX_VALUE)
            .addGroup(positionVehiculeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(positionVehiculeLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(122, Short.MAX_VALUE)))
        );
        positionVehiculeLayout.setVerticalGroup(
            positionVehiculeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 35, Short.MAX_VALUE)
            .addGroup(positionVehiculeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel30, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE))
        );

        deconnecter.setBackground(new java.awt.Color(0, 102, 204));
        deconnecter.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deconnecterMouseClicked(evt);
            }
        });

        jLabel46.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(255, 255, 255));
        jLabel46.setText("Deconnecter");

        javax.swing.GroupLayout deconnecterLayout = new javax.swing.GroupLayout(deconnecter);
        deconnecter.setLayout(deconnecterLayout);
        deconnecterLayout.setHorizontalGroup(
            deconnecterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(deconnecterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(deconnecterLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel46, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(142, Short.MAX_VALUE)))
        );
        deconnecterLayout.setVerticalGroup(
            deconnecterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 34, Short.MAX_VALUE)
            .addGroup(deconnecterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel46, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout MenuLayout = new javax.swing.GroupLayout(Menu);
        Menu.setLayout(MenuLayout);
        MenuLayout.setHorizontalGroup(
            MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MenuLayout.createSequentialGroup()
                .addContainerGap(342, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                .addComponent(deconnecter, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(MenuDashboard, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(MenuTracker, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(MenuPosition, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(MenuVehucile, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(MenuUtilisateur, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(TrackerVehicule, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(positionTracker, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(positionVehicule, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        MenuLayout.setVerticalGroup(
            MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenuLayout.createSequentialGroup()
                .addComponent(MenuDashboard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addComponent(MenuTracker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(MenuPosition, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(MenuVehucile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(MenuUtilisateur, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(TrackerVehicule, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(positionTracker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(positionVehicule, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(deconnecter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 347, Short.MAX_VALUE))
        );

        getContentPane().add(Menu);
        Menu.setBounds(0, 0, 400, 900);

        TrackerPanel.setBackground(new java.awt.Color(102, 102, 102));
        TrackerPanel.setName(""); // NOI18N

        jPanel3.setBackground(new java.awt.Color(0, 102, 255));

        jLabel6.setFont(new java.awt.Font("Bodoni MT", 0, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Gestion Tracker");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addContainerGap(229, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(40, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addContainerGap())
        );

        jPanel5.setBackground(new java.awt.Color(51, 51, 51));
        jPanel5.setPreferredSize(new java.awt.Dimension(647, 205));

        jLabel7.setFont(new java.awt.Font("Bodoni MT", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Listes Trackers");

        ListeTrackerTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Sim number"
            }
        ));
        ListeTrackerTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ListeTrackerTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(ListeTrackerTable);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 337, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel8.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Sim Number :");

        simNumberTxt.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N

        createbtnTracker.setBackground(new java.awt.Color(0, 102, 255));
        createbtnTracker.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        createbtnTracker.setForeground(new java.awt.Color(255, 255, 255));
        createbtnTracker.setText("Ajouter");
        createbtnTracker.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createbtnTrackerActionPerformed(evt);
            }
        });

        deletebtnTracker.setBackground(new java.awt.Color(0, 102, 255));
        deletebtnTracker.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        deletebtnTracker.setForeground(new java.awt.Color(255, 255, 255));
        deletebtnTracker.setText("Supprimer");
        deletebtnTracker.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletebtnTrackerActionPerformed(evt);
            }
        });

        updatebtnTracker.setBackground(new java.awt.Color(0, 102, 255));
        updatebtnTracker.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        updatebtnTracker.setForeground(new java.awt.Color(255, 255, 255));
        updatebtnTracker.setText("Modifier");
        updatebtnTracker.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updatebtnTrackerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout TrackerPanelLayout = new javax.swing.GroupLayout(TrackerPanel);
        TrackerPanel.setLayout(TrackerPanelLayout);
        TrackerPanelLayout.setHorizontalGroup(
            TrackerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TrackerPanelLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(TrackerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TrackerPanelLayout.createSequentialGroup()
                        .addGroup(TrackerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 914, Short.MAX_VALUE)
                            .addGroup(TrackerPanelLayout.createSequentialGroup()
                                .addComponent(createbtnTracker, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(186, 186, 186)
                                .addComponent(deletebtnTracker, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 191, Short.MAX_VALUE)
                                .addComponent(updatebtnTracker, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(32, 32, 32))))
            .addGroup(TrackerPanelLayout.createSequentialGroup()
                .addGap(220, 220, 220)
                .addComponent(jLabel8)
                .addGap(47, 47, 47)
                .addComponent(simNumberTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        TrackerPanelLayout.setVerticalGroup(
            TrackerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TrackerPanelLayout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(TrackerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(simNumberTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(TrackerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(createbtnTracker)
                    .addComponent(deletebtnTracker)
                    .addComponent(updatebtnTracker))
                .addGap(18, 18, 18)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(291, Short.MAX_VALUE))
        );

        getContentPane().add(TrackerPanel);
        TrackerPanel.setBounds(400, 0, 968, 900);

        PositionPanel.setBackground(new java.awt.Color(102, 102, 102));
        PositionPanel.setPreferredSize(new java.awt.Dimension(968, 900));

        jPanel6.setBackground(new java.awt.Color(0, 102, 255));

        jLabel9.setFont(new java.awt.Font("Bodoni MT", 0, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Gestion Position");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addContainerGap(222, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(40, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addContainerGap())
        );

        jLabel10.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Latitude :");

        jLabel11.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Longitude :");

        jLabel12.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Date :");

        jLabel13.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Tracker:");

        latitudeTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                latitudeTxtActionPerformed(evt);
            }
        });

        jPanel7.setBackground(new java.awt.Color(51, 51, 51));

        jLabel14.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Listes Position");

        ListePositionTable.setBackground(new java.awt.Color(102, 102, 102));
        ListePositionTable.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        ListePositionTable.setForeground(new java.awt.Color(255, 255, 255));
        ListePositionTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Latitude", "Longitude", "Date", "Tracker"
            }
        ));
        ListePositionTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ListePositionTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(ListePositionTable);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 885, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
                .addContainerGap())
        );

        CreatePositionBtn.setBackground(new java.awt.Color(0, 102, 255));
        CreatePositionBtn.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        CreatePositionBtn.setForeground(new java.awt.Color(255, 255, 255));
        CreatePositionBtn.setText("Ajouter");
        CreatePositionBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CreatePositionBtnActionPerformed(evt);
            }
        });

        DeletePositionBtn.setBackground(new java.awt.Color(0, 102, 255));
        DeletePositionBtn.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        DeletePositionBtn.setForeground(new java.awt.Color(255, 255, 255));
        DeletePositionBtn.setText("Supprimer");
        DeletePositionBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeletePositionBtnActionPerformed(evt);
            }
        });

        UpdatePositionButton.setBackground(new java.awt.Color(0, 51, 255));
        UpdatePositionButton.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        UpdatePositionButton.setForeground(new java.awt.Color(255, 255, 255));
        UpdatePositionButton.setText("Modifier");
        UpdatePositionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdatePositionButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PositionPanelLayout = new javax.swing.GroupLayout(PositionPanel);
        PositionPanel.setLayout(PositionPanelLayout);
        PositionPanelLayout.setHorizontalGroup(
            PositionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PositionPanelLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(PositionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PositionPanelLayout.createSequentialGroup()
                        .addGroup(PositionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11))
                        .addGap(18, 18, 18)
                        .addGroup(PositionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(latitudeTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(longitudeTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(PositionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(PositionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(listeTrackers, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(DateTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26))
                    .addGroup(PositionPanelLayout.createSequentialGroup()
                        .addComponent(CreatePositionBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 164, Short.MAX_VALUE)
                        .addComponent(DeletePositionBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(197, 197, 197)
                        .addComponent(UpdatePositionButton, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(21, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PositionPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(PositionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PositionPanelLayout.createSequentialGroup()
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32))))
        );
        PositionPanelLayout.setVerticalGroup(
            PositionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PositionPanelLayout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(PositionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(DateTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(PositionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(latitudeTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel12)
                        .addComponent(jLabel10)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PositionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(longitudeTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(listeTrackers, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addGap(26, 26, 26)
                .addGroup(PositionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CreatePositionBtn)
                    .addComponent(DeletePositionBtn)
                    .addComponent(UpdatePositionButton))
                .addGap(38, 38, 38)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(242, Short.MAX_VALUE))
        );

        getContentPane().add(PositionPanel);
        PositionPanel.setBounds(400, 0, 968, 900);

        VehiculePanel.setBackground(new java.awt.Color(102, 102, 102));
        VehiculePanel.setPreferredSize(new java.awt.Dimension(968, 900));

        jPanel8.setBackground(new java.awt.Color(0, 51, 255));
        jPanel8.setPreferredSize(new java.awt.Dimension(400, 80));

        jLabel15.setFont(new java.awt.Font("Bodoni MT", 0, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Gestion de Vehicules");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel15)
                .addContainerGap(231, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(46, Short.MAX_VALUE)
                .addComponent(jLabel15)
                .addContainerGap())
        );

        jLabel16.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Marque :");

        jLabel17.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Matricule :");

        jLabel18.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Type :");

        marqueTxt.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        marqueTxt.setForeground(new java.awt.Color(51, 51, 51));
        marqueTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                marqueTxtActionPerformed(evt);
            }
        });

        matriculeTxt.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        matriculeTxt.setForeground(new java.awt.Color(51, 51, 51));
        matriculeTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                matriculeTxtActionPerformed(evt);
            }
        });

        typeTxt.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        typeTxt.setForeground(new java.awt.Color(51, 51, 51));
        typeTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                typeTxtActionPerformed(evt);
            }
        });

        jPanel9.setBackground(new java.awt.Color(51, 51, 51));

        jLabel19.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Listes de Vehicules :");

        ListeVehiculeTable.setBackground(new java.awt.Color(102, 102, 102));
        ListeVehiculeTable.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        ListeVehiculeTable.setForeground(new java.awt.Color(255, 255, 255));
        ListeVehiculeTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Matricule", "Marque", "Type"
            }
        ));
        ListeVehiculeTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ListeVehiculeTableMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(ListeVehiculeTable);

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel19)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3)
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel19)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 343, Short.MAX_VALUE)
                .addContainerGap())
        );

        CreateVehiculeBtn.setBackground(new java.awt.Color(0, 51, 255));
        CreateVehiculeBtn.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        CreateVehiculeBtn.setForeground(new java.awt.Color(255, 255, 255));
        CreateVehiculeBtn.setText("Ajouter");
        CreateVehiculeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CreateVehiculeBtnActionPerformed(evt);
            }
        });

        deleteVehiculeBtn.setBackground(new java.awt.Color(0, 51, 255));
        deleteVehiculeBtn.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        deleteVehiculeBtn.setForeground(new java.awt.Color(255, 255, 255));
        deleteVehiculeBtn.setText("Supprimer");
        deleteVehiculeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteVehiculeBtnActionPerformed(evt);
            }
        });

        updateVehiculeBtn.setBackground(new java.awt.Color(0, 51, 255));
        updateVehiculeBtn.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        updateVehiculeBtn.setForeground(new java.awt.Color(255, 255, 255));
        updateVehiculeBtn.setText("Modifier");
        updateVehiculeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateVehiculeBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout VehiculePanelLayout = new javax.swing.GroupLayout(VehiculePanel);
        VehiculePanel.setLayout(VehiculePanelLayout);
        VehiculePanelLayout.setHorizontalGroup(
            VehiculePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, VehiculePanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, VehiculePanelLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(VehiculePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(VehiculePanelLayout.createSequentialGroup()
                        .addGroup(VehiculePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel17)
                            .addComponent(jLabel16))
                        .addGap(18, 18, 18)
                        .addGroup(VehiculePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(VehiculePanelLayout.createSequentialGroup()
                                .addComponent(marqueTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel18)
                                .addGap(18, 18, 18)
                                .addComponent(typeTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(VehiculePanelLayout.createSequentialGroup()
                                .addComponent(matriculeTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(VehiculePanelLayout.createSequentialGroup()
                        .addComponent(CreateVehiculeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 145, Short.MAX_VALUE)
                        .addComponent(deleteVehiculeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(128, 128, 128)
                        .addComponent(updateVehiculeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(30, 30, 30))
        );
        VehiculePanelLayout.setVerticalGroup(
            VehiculePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(VehiculePanelLayout.createSequentialGroup()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(VehiculePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(typeTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18)
                    .addComponent(marqueTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16))
                .addGap(35, 35, 35)
                .addGroup(VehiculePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(matriculeTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17))
                .addGap(22, 22, 22)
                .addGroup(VehiculePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CreateVehiculeBtn)
                    .addComponent(deleteVehiculeBtn)
                    .addComponent(updateVehiculeBtn))
                .addGap(46, 46, 46)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(228, Short.MAX_VALUE))
        );

        getContentPane().add(VehiculePanel);
        VehiculePanel.setBounds(400, 0, 968, 900);

        UserPanel.setBackground(new java.awt.Color(102, 102, 102));

        jPanel1.setBackground(new java.awt.Color(0, 102, 204));
        jPanel1.setPreferredSize(new java.awt.Dimension(400, 80));

        jLabel20.setFont(new java.awt.Font("Bodoni MT", 0, 18)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Gestion des utilisateurs");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel20)
                .addContainerGap(211, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(46, Short.MAX_VALUE)
                .addComponent(jLabel20)
                .addContainerGap())
        );

        jLabel21.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Nom complete :");

        jLabel22.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Email :");

        jLabel23.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("Password :");

        jLabel24.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("Secret :");

        fullnameTxt.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        fullnameTxt.setForeground(new java.awt.Color(51, 51, 51));
        fullnameTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fullnameTxtActionPerformed(evt);
            }
        });

        emailTxt.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        emailTxt.setForeground(new java.awt.Color(51, 51, 51));

        secretTxt.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        secretTxt.setForeground(new java.awt.Color(51, 51, 51));

        addUserBtn.setBackground(new java.awt.Color(0, 51, 255));
        addUserBtn.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        addUserBtn.setForeground(new java.awt.Color(255, 255, 255));
        addUserBtn.setText("Ajouter");
        addUserBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addUserBtnActionPerformed(evt);
            }
        });

        deleteUserBtn.setBackground(new java.awt.Color(0, 51, 255));
        deleteUserBtn.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        deleteUserBtn.setForeground(new java.awt.Color(255, 255, 255));
        deleteUserBtn.setText("Supprimer");
        deleteUserBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteUserBtnActionPerformed(evt);
            }
        });

        jPanel10.setBackground(new java.awt.Color(51, 51, 51));

        jLabel26.setFont(new java.awt.Font("Bodoni MT", 0, 18)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setText("Liste des utilisateurs");

        ListeUserTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nom Complete", "Email"
            }
        ));
        ListeUserTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ListeUserTableMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(ListeUserTable);

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jLabel26)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane4))
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel26)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 337, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout UserPanelLayout = new javax.swing.GroupLayout(UserPanel);
        UserPanel.setLayout(UserPanelLayout);
        UserPanelLayout.setHorizontalGroup(
            UserPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(UserPanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(UserPanelLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(UserPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, UserPanelLayout.createSequentialGroup()
                        .addGroup(UserPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel21)
                            .addComponent(jLabel22, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(18, 18, 18)
                        .addGroup(UserPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(UserPanelLayout.createSequentialGroup()
                                .addComponent(emailTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel23))
                            .addGroup(UserPanelLayout.createSequentialGroup()
                                .addComponent(fullnameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel24)))
                        .addGap(18, 18, 18)
                        .addGroup(UserPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(passwordTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 283, Short.MAX_VALUE)
                            .addComponent(secretTxt)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, UserPanelLayout.createSequentialGroup()
                        .addComponent(addUserBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 299, Short.MAX_VALUE)
                        .addComponent(deleteUserBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(38, 38, 38))
        );
        UserPanelLayout.setVerticalGroup(
            UserPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(UserPanelLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(UserPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fullnameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21)
                    .addComponent(secretTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24))
                .addGap(34, 34, 34)
                .addGroup(UserPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(UserPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(emailTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel22))
                    .addGroup(UserPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(passwordTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel23)))
                .addGap(33, 33, 33)
                .addGroup(UserPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addUserBtn)
                    .addComponent(deleteUserBtn))
                .addGap(18, 18, 18)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(233, Short.MAX_VALUE))
        );

        getContentPane().add(UserPanel);
        UserPanel.setBounds(400, 0, 968, 900);

        VehTrackerPanel.setBackground(new java.awt.Color(102, 102, 102));
        VehTrackerPanel.setForeground(new java.awt.Color(255, 255, 255));
        VehTrackerPanel.setPreferredSize(new java.awt.Dimension(968, 900));

        jPanel12.setBackground(new java.awt.Color(0, 102, 204));
        jPanel12.setPreferredSize(new java.awt.Dimension(400, 80));

        jLabel27.setFont(new java.awt.Font("Bodoni MT", 0, 24)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setText("Gestion(tracker,véhicule) ");

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel27)
                .addContainerGap(129, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addContainerGap(40, Short.MAX_VALUE)
                .addComponent(jLabel27)
                .addContainerGap())
        );

        jLabel31.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(255, 255, 255));
        jLabel31.setText("Date de debut :");

        jLabel32.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(255, 255, 255));
        jLabel32.setText("Vehicule :");

        jLabel33.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(255, 255, 255));
        jLabel33.setText("Date de fin :");

        jLabel34.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(255, 255, 255));
        jLabel34.setText("Tracker :");

        addtrackervehBtn.setBackground(new java.awt.Color(0, 51, 255));
        addtrackervehBtn.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        addtrackervehBtn.setForeground(new java.awt.Color(255, 255, 255));
        addtrackervehBtn.setText("Ajouter");
        addtrackervehBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addtrackervehBtnActionPerformed(evt);
            }
        });

        deletetrackervehBtn.setBackground(new java.awt.Color(0, 51, 255));
        deletetrackervehBtn.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        deletetrackervehBtn.setForeground(new java.awt.Color(255, 255, 255));
        deletetrackervehBtn.setText("Supprimer");
        deletetrackervehBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletetrackervehBtnActionPerformed(evt);
            }
        });

        updatetrackervehBtn.setBackground(new java.awt.Color(0, 51, 255));
        updatetrackervehBtn.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        updatetrackervehBtn.setForeground(new java.awt.Color(255, 255, 255));
        updatetrackervehBtn.setText("Modifier");
        updatetrackervehBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updatetrackervehBtnActionPerformed(evt);
            }
        });

        jPanel13.setBackground(new java.awt.Color(51, 51, 51));

        jLabel28.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setText("Liste (Vehicule, Tracker) ");

        ListeVehTrackerTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Date de debut", "Date fe fin", "Tracker", "Vehicule"
            }
        ));
        ListeVehTrackerTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ListeVehTrackerTableMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(ListeVehTrackerTable);

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 889, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel28))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel28)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout VehTrackerPanelLayout = new javax.swing.GroupLayout(VehTrackerPanel);
        VehTrackerPanel.setLayout(VehTrackerPanelLayout);
        VehTrackerPanelLayout.setHorizontalGroup(
            VehTrackerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, VehTrackerPanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, VehTrackerPanelLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(VehTrackerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, 905, Short.MAX_VALUE)
                    .addGroup(VehTrackerPanelLayout.createSequentialGroup()
                        .addGroup(VehTrackerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(VehTrackerPanelLayout.createSequentialGroup()
                                .addGroup(VehTrackerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel31)
                                    .addComponent(jLabel32))
                                .addGap(18, 18, 18)
                                .addGroup(VehTrackerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(datedeDebutTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(ListeVehicule, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(addtrackervehBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
                        .addGroup(VehTrackerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(datedeFinTxt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(VehTrackerPanelLayout.createSequentialGroup()
                                .addGroup(VehTrackerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(VehTrackerPanelLayout.createSequentialGroup()
                                        .addComponent(deletetrackervehBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(133, 133, 133))
                                    .addComponent(jLabel33)
                                    .addComponent(jLabel34))
                                .addGap(10, 10, 10)
                                .addGroup(VehTrackerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(updatetrackervehBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(listeTrackers1, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGap(35, 35, 35))
        );
        VehTrackerPanelLayout.setVerticalGroup(
            VehTrackerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(VehTrackerPanelLayout.createSequentialGroup()
                .addGroup(VehTrackerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(VehTrackerPanelLayout.createSequentialGroup()
                        .addGap(96, 96, 96)
                        .addGroup(VehTrackerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel31)
                            .addComponent(datedeDebutTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, VehTrackerPanelLayout.createSequentialGroup()
                        .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(VehTrackerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(datedeFinTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel33))))
                .addGap(18, 18, 18)
                .addGroup(VehTrackerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(VehTrackerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(listeTrackers1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel34))
                    .addGroup(VehTrackerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(ListeVehicule, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel32)))
                .addGap(40, 40, 40)
                .addGroup(VehTrackerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addtrackervehBtn)
                    .addComponent(deletetrackervehBtn)
                    .addComponent(updatetrackervehBtn))
                .addGap(18, 18, 18)
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 239, Short.MAX_VALUE))
        );

        getContentPane().add(VehTrackerPanel);
        VehTrackerPanel.setBounds(400, 0, 968, 900);

        positiontrackerPanel.setBackground(new java.awt.Color(102, 102, 102));

        jLabel35.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(255, 255, 255));
        jLabel35.setText("Date de fin :");

        jLabel36.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(255, 255, 255));
        jLabel36.setText("Date de debut :");

        jLabel37.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(255, 255, 255));
        jLabel37.setText("Tracker :");

        jPanel4.setBackground(new java.awt.Color(0, 102, 204));
        jPanel4.setPreferredSize(new java.awt.Dimension(400, 80));

        jLabel38.setFont(new java.awt.Font("Bodoni MT", 0, 18)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(255, 255, 255));
        jLabel38.setText("les positions d'un tracker entre deux dates ");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel38)
                .addContainerGap(65, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(46, Short.MAX_VALUE)
                .addComponent(jLabel38)
                .addContainerGap())
        );

        jPanel11.setBackground(new java.awt.Color(51, 51, 51));

        jLabel39.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(255, 255, 255));
        jLabel39.setText("Listes :");

        listepositionTrakcerfind.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Latitude", "Longitude", "Date", "Tracker"
            }
        ));
        listepositionTrakcerfind.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listepositionTrakcerfindMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(listepositionTrakcerfind);

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jLabel39)
                        .addContainerGap(882, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 854, Short.MAX_VALUE)
                        .addGap(69, 69, 69))))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel39)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 339, Short.MAX_VALUE)
                .addGap(33, 33, 33))
        );

        searchBtn.setBackground(new java.awt.Color(0, 102, 204));
        searchBtn.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        searchBtn.setForeground(new java.awt.Color(255, 255, 255));
        searchBtn.setText("Search");
        searchBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBtnActionPerformed(evt);
            }
        });

        MapBtn.setBackground(new java.awt.Color(0, 51, 255));
        MapBtn.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        MapBtn.setForeground(new java.awt.Color(255, 255, 255));
        MapBtn.setText("Select Une Position Pour Afficher Dans Une Map");
        MapBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MapBtnActionPerformed(evt);
            }
        });

        imprimerBtn.setText("Imprimer");
        imprimerBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imprimerBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout positiontrackerPanelLayout = new javax.swing.GroupLayout(positiontrackerPanel);
        positiontrackerPanel.setLayout(positiontrackerPanelLayout);
        positiontrackerPanelLayout.setHorizontalGroup(
            positiontrackerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, positiontrackerPanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, positiontrackerPanelLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(positiontrackerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(positiontrackerPanelLayout.createSequentialGroup()
                        .addGroup(positiontrackerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(positiontrackerPanelLayout.createSequentialGroup()
                                .addComponent(jLabel37)
                                .addGap(46, 46, 46)
                                .addComponent(listeTrackers2, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(86, 86, 86)
                                .addComponent(imprimerBtn)
                                .addGap(92, 92, 92)
                                .addComponent(searchBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 368, Short.MAX_VALUE))
                            .addGroup(positiontrackerPanelLayout.createSequentialGroup()
                                .addComponent(jLabel36)
                                .addGap(18, 18, 18)
                                .addComponent(datedeDebutTxt1, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel35)
                                .addGap(16, 16, 16)
                                .addComponent(datedeFinTxt1, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(30, 30, 30))
                    .addGroup(positiontrackerPanelLayout.createSequentialGroup()
                        .addComponent(MapBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(607, 607, 607))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, positiontrackerPanelLayout.createSequentialGroup()
                        .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        positiontrackerPanelLayout.setVerticalGroup(
            positiontrackerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(positiontrackerPanelLayout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addGroup(positiontrackerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(datedeFinTxt1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(datedeDebutTxt1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel35, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel36, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(positiontrackerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(listeTrackers2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel37)
                    .addComponent(imprimerBtn))
                .addGap(18, 18, 18)
                .addComponent(MapBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(679, Short.MAX_VALUE))
        );

        getContentPane().add(positiontrackerPanel);
        positiontrackerPanel.setBounds(400, 0, 968, 1317);

        positionvehiculePanel.setBackground(new java.awt.Color(102, 102, 102));

        jPanel14.setBackground(new java.awt.Color(51, 51, 51));

        jLabel40.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(255, 255, 255));
        jLabel40.setText("Listes :");

        listepositionVehiculefind.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Latitude", "Longitude", "Date", "Tracker"
            }
        ));
        listepositionVehiculefind.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listepositionVehiculefindMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(listepositionVehiculefind);

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 893, Short.MAX_VALUE)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addComponent(jLabel40)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel40)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel42.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(255, 255, 255));
        jLabel42.setText("Date de debut :");

        jLabel43.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(255, 255, 255));
        jLabel43.setText("Date de fin :");

        searchBtn1.setBackground(new java.awt.Color(0, 102, 204));
        searchBtn1.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        searchBtn1.setForeground(new java.awt.Color(255, 255, 255));
        searchBtn1.setText("Search");
        searchBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBtn1ActionPerformed(evt);
            }
        });

        jPanel15.setBackground(new java.awt.Color(0, 102, 204));
        jPanel15.setPreferredSize(new java.awt.Dimension(400, 80));

        jLabel44.setFont(new java.awt.Font("Bodoni MT", 0, 18)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(255, 255, 255));
        jLabel44.setText(" Les positions d’un véhicule entre deux dates");

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel44)
                .addContainerGap(38, Short.MAX_VALUE))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                .addContainerGap(46, Short.MAX_VALUE)
                .addComponent(jLabel44)
                .addContainerGap())
        );

        jLabel45.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(255, 255, 255));
        jLabel45.setText("Vehicule :");

        MapBtn1.setBackground(new java.awt.Color(0, 51, 255));
        MapBtn1.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        MapBtn1.setForeground(new java.awt.Color(255, 255, 255));
        MapBtn1.setText("Select Une Position Pour Afficher Dans Une Map");
        MapBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MapBtn1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout positionvehiculePanelLayout = new javax.swing.GroupLayout(positionvehiculePanel);
        positionvehiculePanel.setLayout(positionvehiculePanelLayout);
        positionvehiculePanelLayout.setHorizontalGroup(
            positionvehiculePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, positionvehiculePanelLayout.createSequentialGroup()
                .addGap(0, 568, Short.MAX_VALUE)
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, positionvehiculePanelLayout.createSequentialGroup()
                .addGroup(positionvehiculePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, positionvehiculePanelLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(positionvehiculePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel42)
                            .addComponent(jLabel45))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(positionvehiculePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ListeVehicule1, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(datedeDebutTxt2, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(positionvehiculePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(positionvehiculePanelLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel43)
                                .addGap(18, 18, 18)
                                .addComponent(datedeFinTxt2, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(positionvehiculePanelLayout.createSequentialGroup()
                                .addGap(251, 251, 251)
                                .addComponent(searchBtn1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(positionvehiculePanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(positionvehiculePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(MapBtn1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel14, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(30, 30, 30))
        );
        positionvehiculePanelLayout.setVerticalGroup(
            positionvehiculePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(positionvehiculePanelLayout.createSequentialGroup()
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(positionvehiculePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(positionvehiculePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(datedeFinTxt2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(positionvehiculePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(datedeDebutTxt2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel42)))
                    .addComponent(jLabel43))
                .addGap(18, 18, 18)
                .addGroup(positionvehiculePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(searchBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(positionvehiculePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(ListeVehicule1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel45)))
                .addGap(18, 18, 18)
                .addComponent(MapBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(257, Short.MAX_VALUE))
        );

        getContentPane().add(positionvehiculePanel);
        positionvehiculePanel.setBounds(400, 0, 968, 900);

        Dash.setBackground(new java.awt.Color(102, 102, 102));

        anneeBtn.setBackground(new java.awt.Color(0, 102, 255));
        anneeBtn.setFont(new java.awt.Font("Bodoni MT", 0, 18)); // NOI18N
        anneeBtn.setForeground(new java.awt.Color(255, 255, 255));
        anneeBtn.setText("Nombre positions,véhicule  par yyyy ");
        anneeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                anneeBtnActionPerformed(evt);
            }
        });

        chartPositionTracker.setBackground(new java.awt.Color(0, 102, 255));
        chartPositionTracker.setFont(new java.awt.Font("Bodoni MT", 0, 18)); // NOI18N
        chartPositionTracker.setForeground(new java.awt.Color(255, 255, 255));
        chartPositionTracker.setText("Nombre positions /tracker");
        chartPositionTracker.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chartPositionTrackerActionPerformed(evt);
            }
        });

        moisBtn.setBackground(new java.awt.Color(0, 102, 255));
        moisBtn.setFont(new java.awt.Font("Bodoni MT", 0, 18)); // NOI18N
        moisBtn.setForeground(new java.awt.Color(255, 255, 255));
        moisBtn.setText("Nombre positions,véhicule  par mois");
        moisBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                moisBtnActionPerformed(evt);
            }
        });

        jLabel41.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(255, 255, 255));
        jLabel41.setText("Vehicule :");

        javax.swing.GroupLayout DashLayout = new javax.swing.GroupLayout(Dash);
        Dash.setLayout(DashLayout);
        DashLayout.setHorizontalGroup(
            DashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DashLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(DashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(DashLayout.createSequentialGroup()
                        .addComponent(dateTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel41)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ListeVehicule2, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(DashLayout.createSequentialGroup()
                        .addComponent(anneeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(moisBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DashLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(chartPositionTracker, javax.swing.GroupLayout.PREFERRED_SIZE, 900, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        DashLayout.setVerticalGroup(
            DashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DashLayout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addComponent(chartPositionTracker, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(115, 115, 115)
                .addGroup(DashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(DashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(ListeVehicule2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel41))
                    .addComponent(dateTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(DashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(anneeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(moisBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(323, Short.MAX_VALUE))
        );

        getContentPane().add(Dash);
        Dash.setBounds(400, 0, 968, 900);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void MenuTrackerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuTrackerMouseClicked
        // TODO add your handling code here:
        TrackerPanel.setVisible(true);
        PositionPanel.setVisible(false);
        VehiculePanel.setVisible(false);
        UserPanel.setVisible(false);
        VehTrackerPanel.setVisible(false);
        positiontrackerPanel.setVisible(false);
        positionvehiculePanel.setVisible(false);
        Dash.setVisible(false);
    }//GEN-LAST:event_MenuTrackerMouseClicked

    private void MenuPositionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuPositionMouseClicked
        // TODO add your handling code here:
        TrackerPanel.setVisible(false);
        PositionPanel.setVisible(true);
        VehiculePanel.setVisible(false);
        UserPanel.setVisible(false);
        VehTrackerPanel.setVisible(false);
        positiontrackerPanel.setVisible(false);
        positionvehiculePanel.setVisible(false);
        Dash.setVisible(false);
    }//GEN-LAST:event_MenuPositionMouseClicked

    private void MenuVehucileMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuVehucileMouseClicked
        // TODO add your handling code here:
        TrackerPanel.setVisible(false);
        PositionPanel.setVisible(false);
        VehiculePanel.setVisible(true);
        UserPanel.setVisible(false);
        VehTrackerPanel.setVisible(false);
        positiontrackerPanel.setVisible(false);
        positionvehiculePanel.setVisible(false);
        Dash.setVisible(false);
    }//GEN-LAST:event_MenuVehucileMouseClicked

    private void MenuUtilisateurMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuUtilisateurMouseClicked
        // TODO add your handling code here:
        TrackerPanel.setVisible(false);
        PositionPanel.setVisible(false);
        VehiculePanel.setVisible(false);
        UserPanel.setVisible(true);
        VehTrackerPanel.setVisible(false);
        positiontrackerPanel.setVisible(false);
        positionvehiculePanel.setVisible(false);
        Dash.setVisible(false);
    }//GEN-LAST:event_MenuUtilisateurMouseClicked

    private void createbtnTrackerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createbtnTrackerActionPerformed
        // TODO add your handling code here:
        int simNumber = Integer.parseInt(simNumberTxt.getText()); 
        if (ts.create(new Tracker(simNumber))) {
            JOptionPane.showMessageDialog(this, "Tracker " + simNumber + " bien enregistré");
            loadTracker();
        } else {
            JOptionPane.showMessageDialog(this, "Error :: Enregister tracker");
        }
    }//GEN-LAST:event_createbtnTrackerActionPerformed
    
      
    
    private void deletebtnTrackerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletebtnTrackerActionPerformed
        int reponse = JOptionPane.showConfirmDialog(this, "Voulez vous vraiment supprimer ce tracker");

        if (reponse == 0 && idTracker != 0) {
            if (ts.delete(ts.findById(idTracker))) {
                JOptionPane.showMessageDialog(this, "Tracker supprimé");
                loadTracker();
            } else {
                JOptionPane.showMessageDialog(this, "Error :: Supprimer Tracker");

            }
        }    
    }//GEN-LAST:event_deletebtnTrackerActionPerformed

    private void ListeTrackerTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ListeTrackerTableMouseClicked
        idTracker = Integer.parseInt(modelTracker.getValueAt(ListeTrackerTable.getSelectedRow(), 0).toString());
        simNumberTxt.setText(modelTracker.getValueAt(ListeTrackerTable.getSelectedRow(), 1).toString());   
    }//GEN-LAST:event_ListeTrackerTableMouseClicked

    private void updatebtnTrackerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updatebtnTrackerActionPerformed
        int simNumber = Integer.parseInt(simNumberTxt.getText()); 
        Tracker t = ts.findById(idTracker);
        t.setSimNumber(simNumber);

        int reponse = JOptionPane.showConfirmDialog(this, "Voulez vous vraiment modifier ce tracker");

        if (reponse == 0 && idTracker != 0) {
            if(simNumberTxt.getText().length() != 0){
                if (ts.update(t)) {
                    JOptionPane.showMessageDialog(this, "Tracker modifié");
                    loadTracker();
                }else{
                    JOptionPane.showMessageDialog(this, "erreur");
                }
            }else{
                JOptionPane.showMessageDialog(this, "Sim Number is empty");
            }
            
        }
    }//GEN-LAST:event_updatebtnTrackerActionPerformed

    private void latitudeTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_latitudeTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_latitudeTxtActionPerformed

    private void CreatePositionBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CreatePositionBtnActionPerformed
        double latitude = Double.parseDouble(latitudeTxt.getText());
        double longitude = Double.parseDouble(longitudeTxt.getText());
        Date date = DateTxt.getDate();
        Tracker tracker = (Tracker) listeTrackers.getSelectedItem();
        if (ps.create(new Position(latitude, longitude, date, tracker))) {
            JOptionPane.showMessageDialog(this, "Position bien enregistrée");
            loadPositins();
        }else{
            JOptionPane.showMessageDialog(this, "erreur d'enregistrée de position");
        }
    }//GEN-LAST:event_CreatePositionBtnActionPerformed

    private void DeletePositionBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeletePositionBtnActionPerformed
        int reponse = JOptionPane.showConfirmDialog(this, "Voulez vous vraiment supprimer cette position");

        if (reponse == 0 && idPosition != 0) {
            if (ps.delete(ps.findById(idPosition))) {
                JOptionPane.showMessageDialog(this, "Position supprimée");
                loadPositins();
            } 
        }
    }//GEN-LAST:event_DeletePositionBtnActionPerformed

    private void ListePositionTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ListePositionTableMouseClicked
        idPosition = Integer.parseInt(modelPosition.getValueAt(ListePositionTable.getSelectedRow(), 0).toString());
        latitudeTxt.setText(modelPosition.getValueAt(ListePositionTable.getSelectedRow(), 1).toString());
        longitudeTxt.setText(modelPosition.getValueAt(ListePositionTable.getSelectedRow(), 2).toString());
        DateTxt.setDate((Date) modelPosition.getValueAt(ListePositionTable.getSelectedRow(), 3));
        listeTrackers.setSelectedItem((Tracker)modelPosition.getValueAt(ListePositionTable.getSelectedRow(), 4));
    }//GEN-LAST:event_ListePositionTableMouseClicked

    private void UpdatePositionButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdatePositionButtonActionPerformed
        Position p = ps.findById(idPosition);
        p.setLatitude(Double.parseDouble(latitudeTxt.getText()));
        p.setLongitude(Double.parseDouble(longitudeTxt.getText()));
        p.setDate(DateTxt.getDate());
        p.setTracker((Tracker) listeTrackers.getSelectedItem());

        int reponse = JOptionPane.showConfirmDialog(this, "Voulez vous vraiment modifier cette position");

        if (reponse == 0 && idPosition != 0) {
            if(latitudeTxt.getText().length() == 0){
                JOptionPane.showMessageDialog(this, "latitude is empty");
                
            }else if(longitudeTxt.getText().length() == 0){
                JOptionPane.showMessageDialog(this, "longitude is empty");
            }else {
                if (ps.update(p)) {
                    JOptionPane.showMessageDialog(this, "Postion modifié");
                    loadPositins();
                }else{
                    JOptionPane.showMessageDialog(this, "erreur de modification de position");
                }
            }
            
        }
    }//GEN-LAST:event_UpdatePositionButtonActionPerformed

    private void marqueTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_marqueTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_marqueTxtActionPerformed

    private void matriculeTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_matriculeTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_matriculeTxtActionPerformed

    private void typeTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_typeTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_typeTxtActionPerformed

    private void MenuDashboardMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuDashboardMouseClicked
        // TODO add your handling code here:
        VehiculePanel.setVisible(false);
        TrackerPanel.setVisible(false);
        PositionPanel.setVisible(false);
        UserPanel.setVisible(false);
        VehTrackerPanel.setVisible(false);
        positiontrackerPanel.setVisible(false);
        positionvehiculePanel.setVisible(false);
        Dash.setVisible(true);
    }//GEN-LAST:event_MenuDashboardMouseClicked

    private void CreateVehiculeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CreateVehiculeBtnActionPerformed
        // TODO add your handling code here:
        String matricule = matriculeTxt.getText();
        String marque    = marqueTxt.getText()   ;
        String type      = typeTxt.getText()     ;
        
        if (vs.create(new Vehicule(matricule, marque, type))) {
            JOptionPane.showMessageDialog(this, "Vehicule bien enregistrée");
            loadVehicule();
        }else{
            JOptionPane.showMessageDialog(this, "erreur d'enregistrée de vehicule");
        }
    }//GEN-LAST:event_CreateVehiculeBtnActionPerformed

    private void deleteVehiculeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteVehiculeBtnActionPerformed
        int reponse = JOptionPane.showConfirmDialog(this, "Voulez vous vraiment supprimer cette position");

        if (reponse == 0 && idVehicule != 0) {
            if (vs.delete(vs.findById(idVehicule))) {
                JOptionPane.showMessageDialog(this, "Vehicule supprimée");
                loadVehicule();
            } else {
                JOptionPane.showMessageDialog(this, "erreur vehicule non supprimée");
            }   
        }
    }//GEN-LAST:event_deleteVehiculeBtnActionPerformed

    private void ListeVehiculeTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ListeVehiculeTableMouseClicked
        idVehicule = Integer.parseInt(modelVehicule.getValueAt(ListeVehiculeTable.getSelectedRow(), 0).toString());
        marqueTxt.setText(modelVehicule.getValueAt(ListeVehiculeTable.getSelectedRow(), 2).toString());
        matriculeTxt.setText(modelVehicule.getValueAt(ListeVehiculeTable.getSelectedRow(), 1).toString());
        typeTxt.setText(modelVehicule.getValueAt(ListeVehiculeTable.getSelectedRow(), 3).toString());
    }//GEN-LAST:event_ListeVehiculeTableMouseClicked

    private void updateVehiculeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateVehiculeBtnActionPerformed
        Vehicule v = vs.findById(idVehicule);
        
        v.setMatricule(matriculeTxt.getText());
        v.setMarque(marqueTxt.getText());
        v.setType(typeTxt.getText());
        
        int reponse = JOptionPane.showConfirmDialog(this, "Voulez vous vraiment modifier cette vehicule");

        if (reponse == 0 && idVehicule != 0) {
            if(matriculeTxt.getText().length() == 0){
                JOptionPane.showMessageDialog(this, "Matricule is empty");
            }else if(marqueTxt.getText().length() == 0){
                JOptionPane.showMessageDialog(this, "Marque is empty");
            }else if(typeTxt.getText().length() == 0){
                JOptionPane.showMessageDialog(this, "Type is empty");
            }else {
                if (vs.update(v)) {
                    JOptionPane.showMessageDialog(this, "vehicule modifié");
                    loadVehicule();
                }else{
                    JOptionPane.showMessageDialog(this, "erreur de modification de vehicule");
                }
            }
            
        }
    }//GEN-LAST:event_updateVehiculeBtnActionPerformed

    private void fullnameTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fullnameTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fullnameTxtActionPerformed

    private void addUserBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addUserBtnActionPerformed
        String fullname  = fullnameTxt.getText() ;
        String email     = emailTxt.getText()   ;
        String secret    = secretTxt.getText()   ;
        char[] password  = passwordTxt.getPassword(); 
        
        
        
        String EMAIL_PATTERN = 
        "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

        if (!email.matches(EMAIL_PATTERN)) {
            JOptionPane.showMessageDialog(this, "Verifier l'email");
        }else if (password.length < 8 ){
            JOptionPane.showMessageDialog(this, "password variables doit etre plus que 7");
        }else if (us.create(new User(fullname, email, secret, String.valueOf(password)))) {
            JOptionPane.showMessageDialog(this, "User bien enregistrée");
            loadUser();
        }else{
            JOptionPane.showMessageDialog(this, "erreur d'enregistrée de User");
        }
    }//GEN-LAST:event_addUserBtnActionPerformed

    private void ListeUserTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ListeUserTableMouseClicked
        idUser = Integer.parseInt(modelUser.getValueAt(ListeUserTable.getSelectedRow(), 0).toString());
        fullnameTxt.setText(modelUser.getValueAt(ListeUserTable.getSelectedRow(), 1).toString());
        emailTxt.setText(modelUser.getValueAt(ListeUserTable.getSelectedRow(), 2).toString());        
    }//GEN-LAST:event_ListeUserTableMouseClicked

    private void deleteUserBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteUserBtnActionPerformed
        int reponse = JOptionPane.showConfirmDialog(this, "Voulez vous vraiment supprimer l'utilisateur.");

        if (reponse == 0 && idUser != 0) {
            if (us.delete(us.findById(idUser))) {
                JOptionPane.showMessageDialog(this, "Utilisateur supprimée");
                loadUser();
            } else {
                JOptionPane.showMessageDialog(this, "erreur : Utilisateur non supprimée");
            }   
        }
    }//GEN-LAST:event_deleteUserBtnActionPerformed

    private void TrackerVehiculeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TrackerVehiculeMouseClicked
        // TODO add your handling code here:
        VehiculePanel.setVisible(false);
        TrackerPanel.setVisible(false);
        PositionPanel.setVisible(false);
        UserPanel.setVisible(false);
        VehTrackerPanel.setVisible(true);
        positiontrackerPanel.setVisible(false);
        Dash.setVisible(false);
    }//GEN-LAST:event_TrackerVehiculeMouseClicked

    private void addtrackervehBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addtrackervehBtnActionPerformed
        Date dateDebut   = datedeDebutTxt.getDate();
        Date dateFin     = datedeFinTxt.getDate()  ;
        Vehicule veh     = (Vehicule) ListeVehicule.getSelectedItem();
        Tracker tracker  = (Tracker) listeTrackers1.getSelectedItem();
        if(dateDebut.after(dateFin)){
            JOptionPane.showMessageDialog(this, "Problem, Date de debut apres date de fin");
        }else{
            if (vts.create(new VehiculeGPSTracker(dateDebut, dateFin, veh , tracker ))) {
                JOptionPane.showMessageDialog(this, "Vehicule , Tracker bien enregistrée");
                loadTrackerVeh();
            }else{
                JOptionPane.showMessageDialog(this, "erreur d'enregistrée !!!!");
            }
        }
        
    }//GEN-LAST:event_addtrackervehBtnActionPerformed

    private void deletetrackervehBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletetrackervehBtnActionPerformed
        int reponse = JOptionPane.showConfirmDialog(this, "Voulez vous vraiment supprimer cette (Tracker , Vehicule)");

        if (reponse == 0 && idTrackerVeh != 0) {
            if (vts.delete(vts.findById(idTrackerVeh))) {
                JOptionPane.showMessageDialog(this, "(Tracker , Vehicule) supprimée");
                loadTrackerVeh();
            }else{
                JOptionPane.showMessageDialog(this, "erreur supprition !!!!");
            } 
        }
    }//GEN-LAST:event_deletetrackervehBtnActionPerformed

    private void ListeVehTrackerTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ListeVehTrackerTableMouseClicked
        idTrackerVeh = Integer.parseInt(modelTrackerVeh.getValueAt(          ListeVehTrackerTable.getSelectedRow(), 0).toString());
        datedeDebutTxt.setDate((Date) modelTrackerVeh.getValueAt(            ListeVehTrackerTable.getSelectedRow(), 1));
        datedeFinTxt.setDate((Date) modelTrackerVeh.getValueAt(              ListeVehTrackerTable.getSelectedRow(), 2));
        listeTrackers1.setSelectedItem((Tracker) modelTrackerVeh.getValueAt( ListeVehTrackerTable.getSelectedRow(), 3));
        ListeVehicule.setSelectedItem((Vehicule) modelTrackerVeh.getValueAt( ListeVehTrackerTable.getSelectedRow(), 4));
    }//GEN-LAST:event_ListeVehTrackerTableMouseClicked

    private void updatetrackervehBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updatetrackervehBtnActionPerformed
        VehiculeGPSTracker vt = vts.findById(idTrackerVeh);
        vt.setDateDebut(datedeDebutTxt.getDate());
        vt.setDateFin(datedeFinTxt.getDate());
        vt.setTracker((Tracker) listeTrackers1.getSelectedItem());
        vt.setVehicule((Vehicule) ListeVehicule.getSelectedItem());

        int reponse = JOptionPane.showConfirmDialog(this, "Voulez vous vraiment modifier cette (Tracker , Vehicule)");

        if (reponse == 0 && idTrackerVeh != 0) {
            if(datedeDebutTxt.getDate().after(datedeFinTxt.getDate())){
                JOptionPane.showMessageDialog(this, "Problem, Date de debut apres date de fin");
            }else{
                if (vts.update(vt)) {
                    JOptionPane.showMessageDialog(this, "(Tracker , Vehicule) modifié");
                    loadTrackerVeh();
                }else{
                    JOptionPane.showMessageDialog(this, "erreur de modification de (Tracker , Vehicule)");
                }
            }
        }
    }//GEN-LAST:event_updatetrackervehBtnActionPerformed

    private void positionTrackerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_positionTrackerMouseClicked
        VehiculePanel.setVisible(false);
        TrackerPanel.setVisible(false);
        PositionPanel.setVisible(false);
        UserPanel.setVisible(false);
        VehTrackerPanel.setVisible(false);
        positiontrackerPanel.setVisible(true);
        positionvehiculePanel.setVisible(false);
        Dash.setVisible(false);
    }//GEN-LAST:event_positionTrackerMouseClicked

    private void searchBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBtnActionPerformed
        // TODO add your handling code here:
        Date dateDebut = datedeDebutTxt1.getDate();
        Date dateFin   = datedeFinTxt1.getDate();
        Tracker tracker = (Tracker) listeTrackers2.getSelectedItem();
        
        java.sql.Date sqldateDebut = new java.sql.Date(dateDebut.getTime());
        java.sql.Date sqldateFin = new java.sql.Date(dateFin.getTime());
        
        System.out.println(sqldateDebut);
        System.out.println(sqldateFin);
 
        modelTrackerPosition.setRowCount(0);
        for (Position p : vts.findPositionsBetweenDates(tracker, sqldateDebut , sqldateFin)) {
            modelTrackerPosition.addRow(new Object[]{
                p.getId(),
                p.getLatitude(),
                p.getLongitude(),
                p.getDate(),
                p.getTracker()
            });
        }
        
        
    }//GEN-LAST:event_searchBtnActionPerformed

    private void positionVehiculeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_positionVehiculeMouseClicked
        // TODO add your handling code here:
        VehiculePanel.setVisible(false);
        TrackerPanel.setVisible(false);
        PositionPanel.setVisible(false);
        UserPanel.setVisible(false);
        VehTrackerPanel.setVisible(false);
        positiontrackerPanel.setVisible(false);
        positionvehiculePanel.setVisible(true);
        Dash.setVisible(false);
    }//GEN-LAST:event_positionVehiculeMouseClicked

    private void searchBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBtn1ActionPerformed
        // TODO add your handling code here:
        Date dateDebut    = datedeDebutTxt2.getDate();
        Date dateFin      = datedeFinTxt2.getDate();
        Vehicule vehicule = (Vehicule) ListeVehicule1.getSelectedItem();
        
        
        java.sql.Date sqldateDebut = new java.sql.Date(dateDebut.getTime());
        java.sql.Date sqldateFin = new java.sql.Date(dateFin.getTime());
        
 
        modelVehiculePosition.setRowCount(0);
        
        for (Position p : vts.findPositionsVehBetweenDates(vehicule, sqldateDebut, sqldateFin)) {
            modelVehiculePosition.addRow(new Object[]{
                p.getId(),
                p.getLatitude(),
                p.getLongitude(),
                p.getDate(),
                p.getTracker()
            });
        }
        
    }//GEN-LAST:event_searchBtn1ActionPerformed

    private void chartPositionTrackerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chartPositionTrackerActionPerformed
        DefaultCategoryDataset dataset = new DefaultCategoryDataset(); 
        List<Tracker> list = ts.ChartTrackerByposition();
        
        for(Tracker t: list)
            dataset.setValue(t.getSimNumber(), "Position By tracker",  "" +ts.findById(t.getId()));

        
        JFreeChart chart = ChartFactory.createBarChart("Nombre des positions renvoyées par chaque tracker", "Tracker", "Nombre des positions", dataset, PlotOrientation.VERTICAL, false, true, false);
        CategoryPlot p= chart.getCategoryPlot();
        p.setRangeGridlinePaint(Color.BLACK);
        ChartFrame frame = new ChartFrame("Bar Chart for student", chart);
        frame.setVisible(true);
        frame.setSize(650,450);
        frame.setExtendedState(MAXIMIZED_BOTH);
    }//GEN-LAST:event_chartPositionTrackerActionPerformed

    private void moisBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_moisBtnActionPerformed
        Date dateAnn = dateTxt.getDate();
        System.out.println(dateAnn);
        
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
        String Dateformat = formatter.format(dateAnn);
        Integer DateInt = Integer.valueOf(Dateformat);
        
        System.out.println(DateInt);
        
        Vehicule veh     = (Vehicule) ListeVehicule2.getSelectedItem();
        
        List<Tracker> list;
        
        try {
            DefaultCategoryDataset dataset = new DefaultCategoryDataset(); 
        
            list = ts.ChartNombrePositionsVehiculeMois(veh,DateInt);
            for(Tracker t: list)
            dataset.setValue( t.getId(), "Nombre des positions d’un véhicule par mois",  "" + t.getSimNumber());
            JFreeChart chart = ChartFactory.createBarChart("Nombre des positions d’un véhicule par mois", "mois", "Nombre des positions d’un véhicule", dataset, PlotOrientation.VERTICAL, false, true, false);
            CategoryPlot p= chart.getCategoryPlot();
            p.setRangeGridlinePaint(Color.BLACK);
            ChartFrame frame = new ChartFrame("Bar Chart for student", chart);
            frame.setVisible(true);
            frame.setSize(650,450);
            frame.setExtendedState(MAXIMIZED_BOTH);
        } catch (ParseException ex) {
            Logger.getLogger(MenuThrFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_moisBtnActionPerformed

    private void anneeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_anneeBtnActionPerformed
        
        Vehicule veh     = (Vehicule) ListeVehicule2.getSelectedItem();
        
        List<Tracker> list;
        
        try {
            DefaultCategoryDataset dataset = new DefaultCategoryDataset(); 
        
            list = ts.ChartNombrePositionsVehiculeAnnee(veh);
            
            for(Tracker t: list)
                dataset.setValue( t.getId(), "Nombre des positions d’un véhicule par année",  "" + t.getSimNumber());
            JFreeChart chart = ChartFactory.createBarChart("Nombre des positions d’un véhicule ", "Année", "Nombre des positions d’un véhicule", dataset, PlotOrientation.VERTICAL, false, true, false);
            CategoryPlot p= chart.getCategoryPlot();
            p.setRangeGridlinePaint(Color.BLACK);
            ChartFrame frame = new ChartFrame("Bar Chart for student", chart);
            frame.setVisible(true);
            frame.setSize(650,450);
            frame.setExtendedState(MAXIMIZED_BOTH);
        } catch (ParseException ex) {
            Logger.getLogger(MenuThrFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }//GEN-LAST:event_anneeBtnActionPerformed

    private void listepositionTrakcerfindMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listepositionTrakcerfindMouseClicked
        idpositionTrakcerfind = Integer.parseInt(modelTrackerPosition.getValueAt(listepositionTrakcerfind.getSelectedRow(), 0).toString());        
    }//GEN-LAST:event_listepositionTrakcerfindMouseClicked

    private void MapBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MapBtnActionPerformed
        Position p = ps.findById(idpositionTrakcerfind);
        
        MapPosition Mp = new MapPosition("TAHIRI", p.getLatitude(), p.getLongitude());
        
    }//GEN-LAST:event_MapBtnActionPerformed

    private void MapBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MapBtn1ActionPerformed
        Position p = ps.findById(idpositionVehiculefind);
        
        MapPosition Mp = new MapPosition("TAHIRI", p.getLatitude(), p.getLongitude());
    }//GEN-LAST:event_MapBtn1ActionPerformed

    private void listepositionVehiculefindMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listepositionVehiculefindMouseClicked
        idpositionVehiculefind = Integer.parseInt(modelVehiculePosition.getValueAt(listepositionVehiculefind.getSelectedRow(), 0).toString());       
    }//GEN-LAST:event_listepositionVehiculefindMouseClicked

    private void deconnecterMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deconnecterMouseClicked
        Login login = new Login();
        this.hide();
        login.show();
    }//GEN-LAST:event_deconnecterMouseClicked

    private void imprimerBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imprimerBtnActionPerformed
        MessageFormat Header = new MessageFormat("Liste des Positions :");
        MessageFormat footer = new MessageFormat("Page {0,number,integer}");
        try{
            listepositionTrakcerfind.print(JTable.PrintMode.NORMAL, Header, footer);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_imprimerBtnActionPerformed

    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MenuThrFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuThrFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuThrFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuThrFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuThrFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CreatePositionBtn;
    private javax.swing.JButton CreateVehiculeBtn;
    private javax.swing.JPanel Dash;
    private com.toedter.calendar.JDateChooser DateTxt;
    private javax.swing.JButton DeletePositionBtn;
    private javax.swing.JTable ListePositionTable;
    private javax.swing.JTable ListeTrackerTable;
    private javax.swing.JTable ListeUserTable;
    private javax.swing.JTable ListeVehTrackerTable;
    private javax.swing.JComboBox ListeVehicule;
    private javax.swing.JComboBox ListeVehicule1;
    private javax.swing.JComboBox ListeVehicule2;
    private javax.swing.JTable ListeVehiculeTable;
    private javax.swing.JButton MapBtn;
    private javax.swing.JButton MapBtn1;
    private javax.swing.JPanel Menu;
    private javax.swing.JPanel MenuDashboard;
    private javax.swing.JPanel MenuPosition;
    private javax.swing.JPanel MenuTracker;
    private javax.swing.JPanel MenuUtilisateur;
    private javax.swing.JPanel MenuVehucile;
    private javax.swing.JPanel PositionPanel;
    private javax.swing.JPanel TrackerPanel;
    private javax.swing.JPanel TrackerVehicule;
    private javax.swing.JButton UpdatePositionButton;
    private javax.swing.JPanel UserPanel;
    private javax.swing.JPanel VehTrackerPanel;
    private javax.swing.JPanel VehiculePanel;
    private javax.swing.JButton addUserBtn;
    private javax.swing.JButton addtrackervehBtn;
    private javax.swing.JButton anneeBtn;
    private javax.swing.JButton chartPositionTracker;
    private javax.swing.JButton createbtnTracker;
    private com.toedter.calendar.JDateChooser dateTxt;
    private com.toedter.calendar.JDateChooser datedeDebutTxt;
    private com.toedter.calendar.JDateChooser datedeDebutTxt1;
    private com.toedter.calendar.JDateChooser datedeDebutTxt2;
    private com.toedter.calendar.JDateChooser datedeFinTxt;
    private com.toedter.calendar.JDateChooser datedeFinTxt1;
    private com.toedter.calendar.JDateChooser datedeFinTxt2;
    private javax.swing.JPanel deconnecter;
    private javax.swing.JButton deleteUserBtn;
    private javax.swing.JButton deleteVehiculeBtn;
    private javax.swing.JButton deletebtnTracker;
    private javax.swing.JButton deletetrackervehBtn;
    private javax.swing.JTextField emailTxt;
    private javax.swing.JTextField fullnameTxt;
    private javax.swing.JButton imprimerBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTextField latitudeTxt;
    private javax.swing.JComboBox listeTrackers;
    private javax.swing.JComboBox listeTrackers1;
    private javax.swing.JComboBox listeTrackers2;
    private javax.swing.JTable listepositionTrakcerfind;
    private javax.swing.JTable listepositionVehiculefind;
    private javax.swing.JTextField longitudeTxt;
    private javax.swing.JTextField marqueTxt;
    private javax.swing.JTextField matriculeTxt;
    private javax.swing.JButton moisBtn;
    private javax.swing.JPasswordField passwordTxt;
    private javax.swing.JPanel positionTracker;
    private javax.swing.JPanel positionVehicule;
    private javax.swing.JPanel positiontrackerPanel;
    private javax.swing.JPanel positionvehiculePanel;
    private javax.swing.JButton searchBtn;
    private javax.swing.JButton searchBtn1;
    private javax.swing.JTextField secretTxt;
    private javax.swing.JTextField simNumberTxt;
    private javax.swing.JTextField typeTxt;
    private javax.swing.JButton updateVehiculeBtn;
    private javax.swing.JButton updatebtnTracker;
    private javax.swing.JButton updatetrackervehBtn;
    // End of variables declaration//GEN-END:variables
}
