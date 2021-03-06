/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.Data;

import Calendar.CalendarEvent;
import Calendar.CourseToEvents;
import Calendar.CreatePanels;
import Calendar.WeekCalendar;
import Main.ApplicationFrame;
import Main.SQLPreparedStatements;
import View.Item.ItemFacultyPanel;
import View.Item.ItemFinalCourseAssignmentPanel;
import java.awt.BorderLayout;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JInternalFrame;

/**
 *
 * @author Derek
 */
public class DataFacultyPanel extends javax.swing.JPanel {

    int visual;
    
    /**
     * Creates new form DataFacultyPanel
     */
    public DataFacultyPanel(int visual) {
        this.visual = visual;
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
        jComboBox2 = new javax.swing.JComboBox<>();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

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

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "PSU ID", "First Name", "Last Name", "Employment Type", "Major" }));

        jButton1.setText("Search");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 449, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(9, 9, 9)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 430, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jList1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList1MouseClicked
        if (evt.getClickCount() == 2) {
            if (visual == 0) {
                singleItem();
            } else if (visual == 1) {
                calendarStuff();
            }
        }
    }//GEN-LAST:event_jList1MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void calendarStuff(){
        ArrayList<ArrayList> fca = SQLPreparedStatements.getFCA();
        ArrayList<CalendarEvent> fcas = new ArrayList<>();
        ArrayList<ArrayList> faculty = SQLPreparedStatements.getFaculty();
        String psu_id = (String) faculty.get(0).get(jList1.getSelectedIndex());
        
        ArrayList<Integer> courses = new ArrayList<>();
        
        for(int i = 0; i < jList1.getModel().getSize(); i++) {
            String f = (String) fca.get(4).get(i);
            if(f.equals(psu_id)){
                courses.add(i);
            }
        }
        
        courses.forEach((index) -> {
            String course_id = (String) fca.get(3).get(index);
            String section_num = (String) fca.get(2).get(index);
            Date start_date = (Date) fca.get(6).get(index);
            Date end_date = (Date) fca.get(7).get(index);
            String days = (String) SQLPreparedStatements.getSingleTime((int) fca.get(5).get(index)).get(1);
            Time start_time = (Time) SQLPreparedStatements.getSingleTime((int) fca.get(5).get(index)).get(2);
            Time end_time = (Time) SQLPreparedStatements.getSingleTime((int) fca.get(5).get(index)).get(3);
            
            fcas.addAll(CourseToEvents.fcaToCalendarEvent(course_id, section_num, "COURSE SUB - NUM - SECTION", start_date.toLocalDate(), end_date.toLocalDate(), start_time.toLocalTime(), end_time.toLocalTime(), days));
        });
        
        JInternalFrame jif = new JInternalFrame("Calendar: Room's", true, true, true, true);
        jif.setBounds(0, 0, 1000, 900);
        jif.setLocation(ApplicationFrame.XOFFSET * ApplicationFrame.openFrameCount, ApplicationFrame.YOFFSET * ApplicationFrame.openFrameCount);
        ApplicationFrame.openFrameCount++;

        WeekCalendar cal = CreatePanels.createWeekCalendarPanel(fcas);

        jif.add(CreatePanels.createWeekControlPanel(cal), BorderLayout.NORTH);
        jif.add(cal, BorderLayout.CENTER);
        jif.setVisible(true);
        ApplicationFrame.jDesktop.add(jif);
        jif.toFront();
    }
    
    private void singleItem(){
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JList<String> jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
