/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.Create;

import Main.SQLPreparedStatements;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.DefaultListModel;
import javax.swing.JSpinner;

/**
 *
 * @author Derek
 */
public class CreateFinalCourseAssignmentPanel extends javax.swing.JPanel {

    /**
     * Creates new form CreateFinalCourseAssignmentPanel
     */
    public CreateFinalCourseAssignmentPanel() {
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
    
    public DefaultListModel createRoomList(){
        ArrayList<ArrayList> rooms = SQLPreparedStatements.getRooms();
        
        DefaultListModel lmroom = new DefaultListModel();
        
        for(int i = 0; i < rooms.get(0).size(); i++) {
            lmroom.addElement(rooms.get(0).get(i) + " " + rooms.get(1).get(i) + " -   Lab: " + rooms.get(2).get(i) + "   Capacity: " + rooms.get(3).get(i));
        }
        
        return lmroom;
    }
    
    public DefaultListModel createTimeList(){
        ArrayList<ArrayList> times = SQLPreparedStatements.getTimePeriods();
        
        DefaultListModel time = new DefaultListModel();
        
        for(int i = 0; i < times.get(1).size(); i++) {
            time.addElement(times.get(1).get(i) + " - " + times.get(2).get(i));
        }
        return time;
    }
    
    public DefaultListModel createCourseList(){
        ArrayList<ArrayList> courses = SQLPreparedStatements.getCourses();
        
        DefaultListModel course = new DefaultListModel();
        
        for(int i = 0; i < courses.get(0).size(); i++) {
            course.addElement(courses.get(0).get(i) + " " + courses.get(1).get(i));
        }
        return course;
    }
    
    //public ComboBoxModel createList

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jlTime = new javax.swing.JList<>();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jlFaculty = new javax.swing.JList<>();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jlRoom = new javax.swing.JList<>();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jlCourse = new javax.swing.JList<>();
        jButton1 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jsStartDate = new javax.swing.JSpinner();
        jLabel10 = new javax.swing.JLabel();
        jsEndDate = new javax.swing.JSpinner();
        jScrollPane5 = new javax.swing.JScrollPane();
        jlDays = new javax.swing.JList<>();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jsEnrollment = new javax.swing.JSpinner();
        jLabel11 = new javax.swing.JLabel();
        jsCapacity = new javax.swing.JSpinner();
        jLabel12 = new javax.swing.JLabel();
        jcbType = new javax.swing.JComboBox<>();

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setText("Final Course Assignment Information");

        jLabel3.setText("Faculty Teaching Course");

        jlTime.setModel(createTimeList());
        jlTime.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(jlTime);

        jLabel4.setText("Time Period");

        jlFaculty.setModel(createFacultyList());
        jlFaculty.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane2.setViewportView(jlFaculty);

        jLabel5.setText("Building and Room");

        jlRoom.setModel(createRoomList());
        jlRoom.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane3.setViewportView(jlRoom);

        jLabel6.setText("Course");

        jlCourse.setModel(createCourseList());
        jlCourse.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane4.setViewportView(jlCourse);

        jButton1.setText("Create Final Course Assignment");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel7.setText("Start Date (MM/DD/YYYY)");

        jsStartDate.setModel(new javax.swing.SpinnerDateModel());

        jLabel10.setText("End Date (MM/DD/YYYY)");

        jsEndDate.setModel(new javax.swing.SpinnerDateModel());

        jlDays.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane5.setViewportView(jlDays);

        jLabel8.setText("Preferred Days");

        jLabel9.setText("Number of Enrollment");

        jsEnrollment.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        jLabel11.setText("Capacity");

        jsCapacity.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));

        jLabel12.setText("Type of Course");

        jcbType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "In-Person", "Online", "Hybrid" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jsStartDate, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jsEndDate, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING))
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel8)))
                            .addComponent(jLabel5)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel4)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel6)
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel11)
                                .addComponent(jsCapacity)
                                .addComponent(jsEnrollment, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel12)
                                .addComponent(jcbType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(34, 34, 34))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jsStartDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jsEndDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jsEnrollment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel11)
                        .addGap(18, 18, 18)
                        .addComponent(jsCapacity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(jLabel12)
                        .addGap(18, 18, 18)
                        .addComponent(jcbType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20))
        );

        jsStartDate.setEditor(new JSpinner.DateEditor(jsStartDate,"MM/dd/yyyy"));
        jsEndDate.setEditor(new JSpinner.DateEditor(jsEndDate,"MM/dd/yyyy"));
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        boolean[] days = {false, false, false, false, false, false, false};
        
        for(int day:jlDays.getSelectedIndices()){
            days[day] = true;
        }
        
        Date start = (Date) jsStartDate.getValue();
        Date end = (Date) jsEndDate.getValue();
        
        LocalDate startDate = start.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate endDate = end.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        
        ArrayList<ArrayList> rooms = SQLPreparedStatements.getRooms();
        String room_num = (String) rooms.get(1).get(jlRoom.getSelectedIndex());
        String room_bldg = (String) rooms.get(0).get(jlRoom.getSelectedIndex());
        
        ArrayList<ArrayList> courses = SQLPreparedStatements.getCourses();
        String course_id = (String) courses.get(2).get(jlCourse.getSelectedIndex());

        ArrayList<ArrayList> faculty = SQLPreparedStatements.getFaculty();
        String fac_id = (String) faculty.get(0).get(jlFaculty.getSelectedIndex());
        
        ArrayList<ArrayList> times = SQLPreparedStatements.getTimePeriods();
        int time_period = (int) times.get(0).get(jlTime.getSelectedIndex());
        
        String type = ""; 
        switch(jcbType.getItemAt(jcbType.getSelectedIndex())) {
            case "In-Person": type = "P"; break;
            case "Hybrid": type = "H"; break;
            case "Online": type = "W"; break;  
        }
        
        if((int) jsCapacity.getValue() > (int) jsEnrollment.getValue())
            // TODO - Need to Update to use StorageController
            SQLPreparedStatements.addNewFCA(room_num, room_bldg, "001", course_id, fac_id, time_period, startDate, endDate, (int) jsCapacity.getValue(), (int) jsEnrollment.getValue(), type);
        else {
            int section = 1;
            int capacity = (int) jsCapacity.getValue();
            int enrollment = (int) jsEnrollment.getValue();
            while(capacity < enrollment) {
                int class_enrollment = enrollment / 2;
                enrollment /= 2;
                String sect = null;
                if(section < 10)
                    sect = "00" + section++;
                SQLPreparedStatements.addNewFCA(room_num, room_bldg, sect, course_id, fac_id, time_period, startDate, endDate, (int) jsCapacity.getValue(), class_enrollment, type);
                
            }
        }
        clearItems();
        
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JComboBox<String> jcbType;
    private javax.swing.JList<String> jlCourse;
    private javax.swing.JList<String> jlDays;
    private javax.swing.JList<String> jlFaculty;
    private javax.swing.JList<String> jlRoom;
    private javax.swing.JList<String> jlTime;
    private javax.swing.JSpinner jsCapacity;
    private javax.swing.JSpinner jsEndDate;
    private javax.swing.JSpinner jsEnrollment;
    private javax.swing.JSpinner jsStartDate;
    // End of variables declaration//GEN-END:variables

    private void clearItems() {
        jlFaculty.clearSelection();
        jlRoom.clearSelection();
        jlCourse.clearSelection();
        jlTime.clearSelection();
        jlDays.clearSelection();
        jsStartDate.setModel(new javax.swing.SpinnerDateModel());
        jsEndDate.setModel(new javax.swing.SpinnerDateModel());
        jsCapacity.setValue(1);
        jsEnrollment.setValue(0);
        //jtfSectionNumber.setText("");
    }
}
