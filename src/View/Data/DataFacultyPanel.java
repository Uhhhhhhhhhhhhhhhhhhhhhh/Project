/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.Data;

import Main.ApplicationFrame;
import Main.SQLPreparedStatements;
import View.Item.ItemFacultyPanel;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JInternalFrame;

/**
 *
 * @author Derek
 */
public class DataFacultyPanel extends javax.swing.JPanel {

    /**
     * Creates new form DataFacultyPanel
     */
    public DataFacultyPanel() {
        initComponents();
    }
    
    
    public DefaultListModel createFacultyList(){
        ArrayList<ArrayList> faculty = SQLPreparedStatements.getFaculty();
        
        DefaultListModel lmfaculty = new DefaultListModel();
        
        for(int i = 0; i < faculty.get(1).size(); i++) {
            lmfaculty.addElement(faculty.get(2).get(i) + ", " + faculty.get(1).get(i));
        }
        
        return lmfaculty;
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setText("Faculty Information");

        jList1.setModel(createFacultyList());
        jList1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jList1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jList1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jList1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 482, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 458, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jList1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList1MouseClicked
        if(evt.getClickCount() == 2) {
            ArrayList<ArrayList> faculty = SQLPreparedStatements.getFaculty();
            String psu_id = (String) faculty.get(0).get(jList1.getSelectedIndex());
            String first = (String) faculty.get(2).get(jList1.getSelectedIndex());
            String last = (String) faculty.get(1).get(jList1.getSelectedIndex());
            JInternalFrame jif = new JInternalFrame("Item: Faculty " + last + ", " + first + " - " + psu_id, true, true, true, true);
            jif.setBounds(0, 0, 529, 410);
            jif.setLocation(ApplicationFrame.XOFFSET * ApplicationFrame.openFrameCount, ApplicationFrame.YOFFSET * ApplicationFrame.openFrameCount);
            ApplicationFrame.openFrameCount++;
            jif.add((new ItemFacultyPanel(SQLPreparedStatements.getSingleFaculty(psu_id))));
            jif.setVisible(true);
            ApplicationFrame.jDesktop.add(jif);
            jif.toFront();
        }
    }//GEN-LAST:event_jList1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JList<String> jList1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
