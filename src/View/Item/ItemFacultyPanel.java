/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.Item;

import Main.ApplicationFrame;
import Main.SQLPreparedStatements;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.DefaultListModel;
import javax.swing.JInternalFrame;

/**
 *
 * @author Derek
 */
public class ItemFacultyPanel extends javax.swing.JPanel {

    ArrayList<Object> info;
    
    /**
     * Creates new form ItemFacultyPanel
     * @param f
     */
    public ItemFacultyPanel(ArrayList<Object> info) {
        this.info = info;
        initComponents();
    }
    
    public DefaultListModel createPreferredDayList() {
        DefaultListModel preferredDays = new DefaultListModel();
        boolean[] days = {false, false, false, false, false, false, false}; //SQLPreparedStatements.stringToArray((String) info.get(5));
        if(days[0])
            preferredDays.addElement("Monday");
        if(days[1])
            preferredDays.addElement("Tuesday");
        if(days[2])
            preferredDays.addElement("Wednesday");
        if(days[3])
            preferredDays.addElement("Thursday");
        if(days[4])
            preferredDays.addElement("Friday");
        if(days[5])
            preferredDays.addElement("Saturday");
        if(days[6])
            preferredDays.addElement("Sunday");
        if(preferredDays.isEmpty())
            preferredDays.addElement("No Preference.");
        return preferredDays;
    }
    
    public DefaultListModel createPreferredTimeList() {
        DefaultListModel preferredTimes = new DefaultListModel();
        
        for(Object i : SQLPreparedStatements.getProfPrefTimes((String) info.get(0)))
            preferredTimes.addElement((int) i);
        
        
        return preferredTimes;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setText("Faculty Information");

        jLabel2.setText("First Name:");

        jLabel3.setText("Last Name:");

        jLabel4.setText("PSU ID:");

        jLabel5.setText((String) info.get(0));

        jLabel6.setText((String) info.get(2));

        jLabel7.setText((String) info.get(1));

        jLabel8.setText("Major College:");

        jLabel9.setText((String) info.get(3));

        jLabel10.setText("Preferred Days:");

        jList1.setModel(createPreferredDayList());
        jList1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(jList1);

        jLabel12.setText("Employment Type: ");

        jLabel13.setText((String) info.get(4));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel5))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel6))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel7))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel9))
                    .addComponent(jLabel10)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel13)))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JList<String> jList1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
