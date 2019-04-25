package Main;

import View.Create.*;
import View.Data.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Derek
 */
public class ApplicationFrame extends javax.swing.JFrame {

    public static int openFrameCount = 0;
    public static int XOFFSET = 30, YOFFSET = 30;

    /**
     * Creates new form TestFrame
     */
    public ApplicationFrame() {
        initComponents();
        try {
            this.setIconImage(ImageIO.read(new File("img/icon.png")));
        } catch (IOException ex) {
            Logger.getLogger(ApplicationFrame.class.getName()).log(Level.SEVERE, null, ex);
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

        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jmiNewTime = new javax.swing.JMenuItem();
        jDesktop = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jmFile = new javax.swing.JMenu();
        jmiImport = new javax.swing.JMenuItem();
        jmiExport = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        jmiAbout = new javax.swing.JMenuItem();
        jmNew = new javax.swing.JMenu();
        jmiNewFaculty = new javax.swing.JMenuItem();
        jmiNewRoom = new javax.swing.JMenuItem();
        jmiNewCourse = new javax.swing.JMenuItem();
        jmiNewFCA = new javax.swing.JMenuItem();
        jmData = new javax.swing.JMenu();
        jmiDataFaculty = new javax.swing.JMenuItem();
        jmiDataTime = new javax.swing.JMenuItem();
        jmiDataRoom = new javax.swing.JMenuItem();
        jmiDataCourse = new javax.swing.JMenuItem();
        jmiDataFCA = new javax.swing.JMenuItem();
        jmCalView = new javax.swing.JMenu();
        jmiCVFaculty = new javax.swing.JMenuItem();
        jmiCVRoom = new javax.swing.JMenuItem();
        jmCVCL = new javax.swing.JMenu();
        jmiCVCLFCA = new javax.swing.JMenuItem();
        jmiCVCLCourse = new javax.swing.JMenuItem();
        jmiCVCLSections = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jmiSQLConnection = new javax.swing.JMenuItem();
        jmiDisconnect = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jmiReset = new javax.swing.JMenuItem();

        jMenuItem1.setText("jMenuItem1");

        jMenuItem2.setText("jMenuItem2");

        jmiNewTime.setText("Time");
        jmiNewTime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiNewTimeActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout jDesktopLayout = new javax.swing.GroupLayout(jDesktop);
        jDesktop.setLayout(jDesktopLayout);
        jDesktopLayout.setHorizontalGroup(
            jDesktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1300, Short.MAX_VALUE)
        );
        jDesktopLayout.setVerticalGroup(
            jDesktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 857, Short.MAX_VALUE)
        );

        jmFile.setText("File");

        jmiImport.setText("Import");
        jmiImport.setEnabled(false);
        jmFile.add(jmiImport);

        jmiExport.setText("Export");
        jmiExport.setEnabled(false);
        jmFile.add(jmiExport);
        jmFile.add(jSeparator2);

        jmiAbout.setText("About");
        jmiAbout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiAboutActionPerformed(evt);
            }
        });
        jmFile.add(jmiAbout);

        jMenuBar1.add(jmFile);

        jmNew.setText("New");
        jmNew.setEnabled(false);

        jmiNewFaculty.setText("Faculty");
        jmiNewFaculty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiNewFacultyActionPerformed(evt);
            }
        });
        jmNew.add(jmiNewFaculty);

        jmiNewRoom.setText("Room");
        jmiNewRoom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiNewRoomActionPerformed(evt);
            }
        });
        jmNew.add(jmiNewRoom);

        jmiNewCourse.setText("Course");
        jmiNewCourse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiNewCourseActionPerformed(evt);
            }
        });
        jmNew.add(jmiNewCourse);

        jmiNewFCA.setText("Final Course Assignment");
        jmiNewFCA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiNewFCAActionPerformed(evt);
            }
        });
        jmNew.add(jmiNewFCA);

        jMenuBar1.add(jmNew);

        jmData.setText("Data");
        jmData.setEnabled(false);

        jmiDataFaculty.setText("Faculty");
        jmiDataFaculty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiDataFacultyActionPerformed(evt);
            }
        });
        jmData.add(jmiDataFaculty);

        jmiDataTime.setText("Time");
        jmiDataTime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiDataTimeActionPerformed(evt);
            }
        });
        jmData.add(jmiDataTime);

        jmiDataRoom.setText("Room");
        jmiDataRoom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiDataRoomActionPerformed(evt);
            }
        });
        jmData.add(jmiDataRoom);

        jmiDataCourse.setText("Course");
        jmiDataCourse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiDataCourseActionPerformed(evt);
            }
        });
        jmData.add(jmiDataCourse);

        jmiDataFCA.setText("Final Course Assignment");
        jmiDataFCA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiDataFCAActionPerformed(evt);
            }
        });
        jmData.add(jmiDataFCA);

        jMenuBar1.add(jmData);

        jmCalView.setText("Calendar View");
        jmCalView.setEnabled(false);

        jmiCVFaculty.setText("By Faculty");
        jmiCVFaculty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiCVFacultyActionPerformed(evt);
            }
        });
        jmCalView.add(jmiCVFaculty);

        jmiCVRoom.setText("By Room");
        jmiCVRoom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiCVRoomActionPerformed(evt);
            }
        });
        jmCalView.add(jmiCVRoom);

        jmCVCL.setText("By Custom List");

        jmiCVCLFCA.setText("Final Course Assignments");
        jmiCVCLFCA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiCVCLFCAActionPerformed(evt);
            }
        });
        jmCVCL.add(jmiCVCLFCA);

        jmiCVCLCourse.setText("Courses");
        jmCVCL.add(jmiCVCLCourse);

        jmiCVCLSections.setText("Sections");
        jmCVCL.add(jmiCVCLSections);

        jmCalView.add(jmCVCL);

        jMenuBar1.add(jmCalView);

        jMenu1.setText("SQL");

        jmiSQLConnection.setText("SQL Connection");
        jmiSQLConnection.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiSQLConnectionActionPerformed(evt);
            }
        });
        jMenu1.add(jmiSQLConnection);

        jmiDisconnect.setText("SQL Disconnect");
        jmiDisconnect.setEnabled(false);
        jmiDisconnect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiDisconnectActionPerformed(evt);
            }
        });
        jMenu1.add(jmiDisconnect);
        jMenu1.add(jSeparator1);

        jmiReset.setText("Reset Stored Login");
        jmiReset.setEnabled(true);
        jmiReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiResetActionPerformed(evt);
            }
        });
        jMenu1.add(jmiReset);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jDesktop)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jDesktop)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jmiDataFacultyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiDataFacultyActionPerformed
        createNewPanel(new DataFacultyPanel(), "Data: Faculty", 700, 720);
    }//GEN-LAST:event_jmiDataFacultyActionPerformed

    private void jmiDataTimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiDataTimeActionPerformed
        createNewPanel(new DataTimePeriodPanel(), "Data: Time Period", 700, 720);
    }//GEN-LAST:event_jmiDataTimeActionPerformed

    private void jmiDataRoomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiDataRoomActionPerformed
        createNewPanel(new DataRoomPanel(0), "Data: Room", 700, 720);
    }//GEN-LAST:event_jmiDataRoomActionPerformed

    private void jmiDataCourseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiDataCourseActionPerformed
        createNewPanel(new DataCoursePanel(0), "Data: Course", 700, 720);
    }//GEN-LAST:event_jmiDataCourseActionPerformed

    private void jmiDataFCAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiDataFCAActionPerformed
        createNewPanel(new DataFinalCourseAssignmentPanel(0), "Data: Final Course Assignment", 700, 720);
    }//GEN-LAST:event_jmiDataFCAActionPerformed

    private void jmiCVFacultyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiCVFacultyActionPerformed
        // TODO Find Courses Teacher is in, Make Events, Place in Weekly View and show
    }//GEN-LAST:event_jmiCVFacultyActionPerformed

    private void jmiSQLConnectionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiSQLConnectionActionPerformed
        //if() if Dat file Exists
        File dbInfo = new File("261DBLogin.dat");
        if(dbInfo.exists()){
            String ip = "", db = "", username = "", password = "";
            try {
                Scanner inFile = new Scanner(dbInfo);
                while(inFile.hasNextLine()){
                    String line = inFile.nextLine();
                    if(line.substring(0,2).equals("ip"))
                        ip = line.substring(3);
                    if(line.substring(0,2).equals("db"))
                        db = line.substring(3);
                    if(line.substring(0,2).equals("un"))
                        username = line.substring(3);
                    if(line.substring(0,2).equals("pw"))
                        password = line.substring(3);
                }
                inFile.close();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(ApplicationFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
            SQLPreparedStatements.connectToDB(ip, db, username, password);
            ApplicationFrame.toggleMenu(SQLPreparedStatements.checkConnection());
        } else {
            createNewPanel(new SQLLoginPanel(), "SQL Connection", 330, 320);
        }
    }//GEN-LAST:event_jmiSQLConnectionActionPerformed

    private void jmiAboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiAboutActionPerformed
        createNewPanel(new AboutPanel(), "About LionPlanner", 310, 279);
    }//GEN-LAST:event_jmiAboutActionPerformed

    private void jmiDisconnectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiDisconnectActionPerformed
        SQLPreparedStatements.disconnectFromDB();
        toggleMenu(SQLPreparedStatements.checkConnection());
    }//GEN-LAST:event_jmiDisconnectActionPerformed

    private void jmiCVCLFCAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiCVCLFCAActionPerformed
        createNewPanel(new DataFinalCourseAssignmentPanel(1), "Calendar: Final Course Assignment", 700, 720);
    }//GEN-LAST:event_jmiCVCLFCAActionPerformed

    private void jmiResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiResetActionPerformed
        if (JOptionPane.showConfirmDialog(null, "Are you sure you want to reset the stored login info?", "WARNING",
        JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            try {
                SQLPreparedStatements.resetDB();
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "DB not reset!", "MySQL: Reset", JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "DB not reset!", "MySQL: Reset", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_jmiResetActionPerformed

    private void jmiCVRoomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiCVRoomActionPerformed
        createNewPanel(new DataRoomPanel(1), "Calendar: Room", 700, 720);
    }//GEN-LAST:event_jmiCVRoomActionPerformed

    private void jmiNewFCAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiNewFCAActionPerformed
        createNewPanel(new CreateFinalCourseAssignmentPanel(), "New: Final Course Assignment", 835, 745);
    }//GEN-LAST:event_jmiNewFCAActionPerformed

    private void jmiNewCourseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiNewCourseActionPerformed
        createNewPanel(new CreateCoursePanel(), "New: Course", 475, 485);
    }//GEN-LAST:event_jmiNewCourseActionPerformed

    private void jmiNewRoomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiNewRoomActionPerformed
        createNewPanel(new CreateRoomPanel(), "New: Room", 427, 325);
    }//GEN-LAST:event_jmiNewRoomActionPerformed

    private void jmiNewTimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiNewTimeActionPerformed
        createNewPanel(new CreateTimePeriodPanel(), "New: Time", 300, 260);
    }//GEN-LAST:event_jmiNewTimeActionPerformed

    private void jmiNewFacultyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiNewFacultyActionPerformed
        createNewPanel(new CreateFacultyPanel(), "New: Faculty", 600, 455);
    }//GEN-LAST:event_jmiNewFacultyActionPerformed

    
    public static void createNewPanel(JPanel p, String title, int x, int y) {
        int x_val = (int) (Math.random() * (jDesktop.getWidth() - 100 - x)) + 50;
        int y_val = (int) (Math.random() * (jDesktop.getHeight() - 100 - y)) + 50;
        JInternalFrame jif = new JInternalFrame(title, true, true, true, true);
        jif.setBounds(0, 0, x, y);
        jif.setLocation(x_val, y_val);
        openFrameCount++;
        jif.add(p);
        jif.setVisible(true);
        jDesktop.add(jif);
        jif.toFront();
    }
    
    public static void toggleMenu(boolean toggle){
        try {
            jmiImport.setEnabled(toggle);
            jmiExport.setEnabled(toggle);
            jmNew.setEnabled(toggle);
            jmData.setEnabled(toggle);
            jmCalView.setEnabled(toggle);
            jmiDisconnect.setEnabled(SQLPreparedStatements.checkConnection());
            //jmiReset.setEnabled(SQLPreparedStatements.checkConnection());
        }catch(Exception e){}
    }
    
    
    
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
            java.util.logging.Logger.getLogger(ApplicationFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ApplicationFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ApplicationFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ApplicationFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            
        new ApplicationFrame().setVisible(true);
            
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JDesktopPane jDesktop;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private static javax.swing.JMenu jmCVCL;
    private static javax.swing.JMenu jmCalView;
    private static javax.swing.JMenu jmData;
    private static javax.swing.JMenu jmFile;
    private static javax.swing.JMenu jmNew;
    private static javax.swing.JMenuItem jmiAbout;
    private static javax.swing.JMenuItem jmiCVCLCourse;
    private static javax.swing.JMenuItem jmiCVCLFCA;
    private static javax.swing.JMenuItem jmiCVCLSections;
    private static javax.swing.JMenuItem jmiCVFaculty;
    private static javax.swing.JMenuItem jmiCVRoom;
    private static javax.swing.JMenuItem jmiDataCourse;
    private static javax.swing.JMenuItem jmiDataFCA;
    private static javax.swing.JMenuItem jmiDataFaculty;
    private static javax.swing.JMenuItem jmiDataRoom;
    private static javax.swing.JMenuItem jmiDataTime;
    private static javax.swing.JMenuItem jmiDisconnect;
    private static javax.swing.JMenuItem jmiExport;
    private static javax.swing.JMenuItem jmiImport;
    private javax.swing.JMenuItem jmiNewCourse;
    private javax.swing.JMenuItem jmiNewFCA;
    private javax.swing.JMenuItem jmiNewFaculty;
    private javax.swing.JMenuItem jmiNewRoom;
    private javax.swing.JMenuItem jmiNewTime;
    private static javax.swing.JMenuItem jmiReset;
    private static javax.swing.JMenuItem jmiSQLConnection;
    // End of variables declaration//GEN-END:variables
}
