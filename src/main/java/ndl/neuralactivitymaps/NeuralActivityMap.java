/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/Application.java to edit this template
 */
package ndl.neuralactivitymaps;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import ndl.ndllib.*;
/**
 *
 * @author balaji
 */
public class NeuralActivityMap extends javax.swing.JFrame {

    /**
     * @param nRepeat the nRepeat to set
     */
    public void setnRepeat(int nRepeat) {
        this.nRepeat = nRepeat;
    }

    /**
     * @param repeatSpace the repeatSpace to set
     */
    public void setRepeatSpace(boolean repeatSpace) {
        this.repeatSpace = repeatSpace;
    }

    private float ScaleX = 1;       // use this to scale the resolution and hence the size of images
    private float ScaleY = 1;       //
    private String fileSep;
    private int nRepeat;
    private boolean repeatSpace = true;
            
    /**
     * @return the xRes
     */
    public int getxRes() {
        var txt = this.jFormattedTextFieldxRes.getText();
        xRes =  (txt == null ) ? 0 : Integer.parseInt(txt);
        return xRes ;
    }

    /**
     * @param xRes the xRes to set
     */
    public void setxRes(int xRes) {
        this.xRes = xRes;
        this.jFormattedTextFieldxRes.setText(xRes+"");
    }

    /**
     * @return the yRes
     */
    public int getyRes() {
        var txt = this.jFormattedTextFieldyRes.getText();
        yRes =  (txt == null ) ? 0 : Integer.parseInt(txt);
        return yRes ;
    }

    /**
     * @param yRes the yRes to set
     */
    public void setyRes(int yRes) {
        this.yRes = yRes;
        this.jFormattedTextFieldyRes.setText(yRes+"");
    }

    static protected  File workingDirectory;
    JVectorSpace[] activitySpace ;
    int fileCount;
    String[] fileList;
    private int xRes;
    private int yRes;
    DefaultTableModel model;
    /**
     * Creates new form NeuralActivityMap
     */
    public NeuralActivityMap() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jScrollPane1 = new javax.swing.JScrollPane();
        jTableDataFiles = new javax.swing.JTable();
        jButtonAddFiles = new javax.swing.JButton();
        jButtonDeleteFiles = new javax.swing.JButton();
        jButtonProcess = new javax.swing.JButton();
        jFormattedTextFieldxRes = new javax.swing.JFormattedTextField();
        jFormattedTextFieldyRes = new javax.swing.JFormattedTextField();
        jLabelxRes = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jCheckBoxEqSamples = new javax.swing.JCheckBox();
        jFormattedTextFieldRepeat = new javax.swing.JFormattedTextField();
        jLabel3 = new javax.swing.JLabel();
        jCheckBox2 = new javax.swing.JCheckBox();
        jProgressBar1 = new javax.swing.JProgressBar();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jComboBoxFSeparator = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        menuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        openMenuItem = new javax.swing.JMenuItem();
        saveMenuItem = new javax.swing.JMenuItem();
        saveAsMenuItem = new javax.swing.JMenuItem();
        exitMenuItem = new javax.swing.JMenuItem();
        editMenu = new javax.swing.JMenu();
        cutMenuItem = new javax.swing.JMenuItem();
        copyMenuItem = new javax.swing.JMenuItem();
        pasteMenuItem = new javax.swing.JMenuItem();
        deleteMenuItem = new javax.swing.JMenuItem();
        helpMenu = new javax.swing.JMenu();
        contentsMenuItem = new javax.swing.JMenuItem();
        aboutMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(900, 750));
        setPreferredSize(new java.awt.Dimension(900, 750));
        java.awt.GridBagLayout layout = new java.awt.GridBagLayout();
        layout.columnWidths = new int[] {0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0};
        layout.rowHeights = new int[] {0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0};
        getContentPane().setLayout(layout);

        jScrollPane1.setMinimumSize(new java.awt.Dimension(576, 576));

        jTableDataFiles.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "SNo", "File name", "Status", "xRes", "yRes", "Number of Components"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Boolean.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                true, true, true, true, true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableDataFiles.setColumnSelectionAllowed(true);
        jTableDataFiles.setPreferredSize(new java.awt.Dimension(450, 400));
        jTableDataFiles.setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        jTableDataFiles.setShowGrid(true);
        jScrollPane1.setViewportView(jTableDataFiles);
        jTableDataFiles.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 16;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.gridheight = 39;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        getContentPane().add(jScrollPane1, gridBagConstraints);

        jButtonAddFiles.setText("Click to add files");
        jButtonAddFiles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddFilesActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        getContentPane().add(jButtonAddFiles, gridBagConstraints);

        jButtonDeleteFiles.setText("Delete selected files");
        jButtonDeleteFiles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteFilesActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        getContentPane().add(jButtonDeleteFiles, gridBagConstraints);

        jButtonProcess.setText("Process");
        jButtonProcess.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonProcessActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        getContentPane().add(jButtonProcess, gridBagConstraints);

        jFormattedTextFieldxRes.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        jFormattedTextFieldxRes.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jFormattedTextFieldxRes.setText("5120");
        jFormattedTextFieldxRes.setMinimumSize(new java.awt.Dimension(42, 22));
        jFormattedTextFieldxRes.setPreferredSize(new java.awt.Dimension(42, 22));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 14;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        getContentPane().add(jFormattedTextFieldxRes, gridBagConstraints);

        jFormattedTextFieldyRes.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        jFormattedTextFieldyRes.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jFormattedTextFieldyRes.setText("5120");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 18;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        getContentPane().add(jFormattedTextFieldyRes, gridBagConstraints);

        jLabelxRes.setText("x Res");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 14;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        getContentPane().add(jLabelxRes, gridBagConstraints);

        jLabel2.setText("y Res");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 18;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        getContentPane().add(jLabel2, gridBagConstraints);

        jCheckBoxEqSamples.setSelected(true);
        jCheckBoxEqSamples.setText(" Equate Samples");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 30;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        getContentPane().add(jCheckBoxEqSamples, gridBagConstraints);

        jFormattedTextFieldRepeat.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        jFormattedTextFieldRepeat.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jFormattedTextFieldRepeat.setText("0");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 32;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        getContentPane().add(jFormattedTextFieldRepeat, gridBagConstraints);

        jLabel3.setText("Repeat activity for");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 32;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        getContentPane().add(jLabel3, gridBagConstraints);

        jCheckBox2.setText("Uniform resolution");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 10;
        getContentPane().add(jCheckBox2, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 36;
        gridBagConstraints.gridwidth = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        getContentPane().add(jProgressBar1, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 34;
        getContentPane().add(jLabel4, gridBagConstraints);

        jLabel5.setText("File Separator");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 26;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        getContentPane().add(jLabel5, gridBagConstraints);

        jComboBoxFSeparator.setEditable(true);
        jComboBoxFSeparator.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Space (\" \")", "Tab (\\t)", "Newline(\\n)", "Newline(\\r)", "Comma(\",\")", "Semicolon(\";\")", "Colon(\":\")", "Others(Overwrite this text)" }));
        jComboBoxFSeparator.setSelectedIndex(4);
        jComboBoxFSeparator.setToolTipText("Choose the datasepartor string/char. \nIn case your separator is not listed choose other and overwrite it with your string/char. \nYou can represent standard escape sequence (that printf for eg) will understand to represent\nthe special charecter. ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 26;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        getContentPane().add(jComboBoxFSeparator, gridBagConstraints);

        jLabel6.setText("Progress");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 34;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        getContentPane().add(jLabel6, gridBagConstraints);

        fileMenu.setMnemonic('f');
        fileMenu.setText("File");

        openMenuItem.setMnemonic('o');
        openMenuItem.setText("Open");
        fileMenu.add(openMenuItem);

        saveMenuItem.setMnemonic('s');
        saveMenuItem.setText("Save");
        fileMenu.add(saveMenuItem);

        saveAsMenuItem.setMnemonic('a');
        saveAsMenuItem.setText("Save As ...");
        saveAsMenuItem.setDisplayedMnemonicIndex(5);
        fileMenu.add(saveAsMenuItem);

        exitMenuItem.setMnemonic('x');
        exitMenuItem.setText("Exit");
        exitMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(exitMenuItem);

        menuBar.add(fileMenu);

        editMenu.setMnemonic('e');
        editMenu.setText("Edit");

        cutMenuItem.setMnemonic('t');
        cutMenuItem.setText("Cut");
        editMenu.add(cutMenuItem);

        copyMenuItem.setMnemonic('y');
        copyMenuItem.setText("Copy");
        editMenu.add(copyMenuItem);

        pasteMenuItem.setMnemonic('p');
        pasteMenuItem.setText("Paste");
        editMenu.add(pasteMenuItem);

        deleteMenuItem.setMnemonic('d');
        deleteMenuItem.setText("Delete");
        editMenu.add(deleteMenuItem);

        menuBar.add(editMenu);

        helpMenu.setMnemonic('h');
        helpMenu.setText("Help");

        contentsMenuItem.setMnemonic('c');
        contentsMenuItem.setText("Contents");
        helpMenu.add(contentsMenuItem);

        aboutMenuItem.setMnemonic('a');
        aboutMenuItem.setText("About");
        helpMenu.add(aboutMenuItem);

        menuBar.add(helpMenu);

        setJMenuBar(menuBar);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuItemActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitMenuItemActionPerformed

    private void jButtonProcessActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonProcessActionPerformed
        // TODO add your handling code here:
       // File workingDirectory;
        if(fileList == null || fileList.length == 0)
            return;
        
        int sepChoice = this.jComboBoxFSeparator.getSelectedIndex();
        this.setRepeatSpace(this.jCheckBoxEqSamples.isSelected());
        this.setnRepeat(Integer.parseInt(this.jFormattedTextFieldRepeat.getText()));
        
        
       /**The choices of file separators
        *Space (" ")
         Tab (\t)
         Newline(\n)
         Newline(\r)
         Comma(",")
         Semicolon(";")
         Colon(":")
         Others(Overwrite this text)
        *  
        */
         
        switch (sepChoice){
            case 0:
                this.fileSep = " ";
                break;
            case 1:
                this.fileSep = "\t";
                break;
            case 2:
                this.fileSep = "\n";
                break;
            case 3:
                this.fileSep = "\r";
                break;
            case 4:
                this.fileSep = ",";
                break;
            case 5: 
                this.fileSep = ";";
                break;
            case 6:
                this.fileSep = ":";
                break;
            default :
                String sepTxt = (String) this.jComboBoxFSeparator.getSelectedItem();
                int idx = sepTxt.indexOf("\\");
                if(idx >= 0)
                    this.fileSep = "\\" + sepTxt.charAt(idx+1);
                else
                    this.fileSep = sepTxt;
                break;      
        }
        
        if(model == null)   
            model = (DefaultTableModel)this.jTableDataFiles.getModel();
        boolean readStatus = false;
        int count = 0;
        activitySpace = new JVectorSpace[fileList.length];
        //read the data from files
        for(String fName : fileList){
            String prefix = fName.split("\\.")[0];
            try {
                activitySpace[count]= new JVectorSpace(this.getxRes(),this.getyRes());
                readStatus = readNeuralActivitySpace(fName,activitySpace[count]);
                model.setValueAt(activitySpace[count].getnComp(), count,5);
            } catch (IOException ex) {
                Logger.getLogger(NeuralActivityMap.class.getName()).log(Level.SEVERE, null, ex);
            }catch(Exception ex){
                Logger.getLogger(NeuralActivityMap.class.getName()).log(Level.WARNING, null, ex);
            }
            if(readStatus){
                JVectorCmpImg cmpImg = new JVectorCmpImg(activitySpace[count]);
                cmpImg.saveStack(prefix + "_cmpts");
            }
            this.jTableDataFiles.setValueAt(readStatus, count, 2);
            count++;
            
        }
        
        
        
        
    }//GEN-LAST:event_jButtonProcessActionPerformed

    private void jButtonAddFilesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddFilesActionPerformed
        
        //JTable dataTable =  new JTable();
        model = (DefaultTableModel)jTableDataFiles.getModel();
        
        if (NeuralActivityMap.workingDirectory == null )
           workingDirectory = new File(System.getProperty("user.dir"));
       
        MultiFileDialog FD = new MultiFileDialog(null,true,workingDirectory);
        FD.setVisible(true);
        int result = FD.getResult();
        if(result != 2){                    //2 => atleast 1 file has been selected
            ///To Do; Display a message saying that no files are selected. 
        }
        
        fileList = FD.getSelectionArray();
        
        if (fileList.length > 0 ) {
            File selDirectory = new File(fileList[0]).getParentFile();
            workingDirectory = selDirectory.exists() ? selDirectory : workingDirectory;
            //if (currRows == 0 )
             //       model.setColumnCount(3);
            //model.setRowCount(0);
            model.setRowCount(fileList.length );
            //model.
            int count = 0;
            for(String fname : fileList){

                model.setValueAt(count+1, count, 0);
                model.setValueAt(fname, count, 1);
                model.setValueAt(false,count,2);
                model.setValueAt(this.getxRes(),count,3);
                model.setValueAt(this.getyRes(), count, 4);
                model.setValueAt(0,count,5);
                count++;
            }
            //model.fireTableDataChanged();
            fileCount = count;
        }
        activitySpace = new JVectorSpace[fileCount];
    }//GEN-LAST:event_jButtonAddFilesActionPerformed

    private void jButtonDeleteFilesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteFilesActionPerformed
        // TODO add your handling code here:
        int[] selRows = this.jTableDataFiles.getSelectedRows();
        int nSelections = selRows.length;
        if(nSelections <= 0)
            return;
        ArrayList<Integer> selList = new ArrayList();
        for(int idx : selRows)
                selList.add(idx);
        selList.sort(null);
        for(int count = nSelections - 1 ; count >= 0 ; count --){
            model.removeRow((int) selList.get(count));
        }
        this.jTableDataFiles.setModel(model);
    }//GEN-LAST:event_jButtonDeleteFilesActionPerformed
        
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
                if ("System".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(NeuralActivityMap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NeuralActivityMap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NeuralActivityMap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NeuralActivityMap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NeuralActivityMap().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem aboutMenuItem;
    private javax.swing.JMenuItem contentsMenuItem;
    private javax.swing.JMenuItem copyMenuItem;
    private javax.swing.JMenuItem cutMenuItem;
    private javax.swing.JMenuItem deleteMenuItem;
    private javax.swing.JMenu editMenu;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JMenu helpMenu;
    private javax.swing.JButton jButtonAddFiles;
    private javax.swing.JButton jButtonDeleteFiles;
    private javax.swing.JButton jButtonProcess;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBoxEqSamples;
    private javax.swing.JComboBox<String> jComboBoxFSeparator;
    private javax.swing.JFormattedTextField jFormattedTextFieldRepeat;
    private javax.swing.JFormattedTextField jFormattedTextFieldxRes;
    private javax.swing.JFormattedTextField jFormattedTextFieldyRes;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabelxRes;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableDataFiles;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem openMenuItem;
    private javax.swing.JMenuItem pasteMenuItem;
    private javax.swing.JMenuItem saveAsMenuItem;
    private javax.swing.JMenuItem saveMenuItem;
    // End of variables declaration//GEN-END:variables

    private boolean readNeuralActivitySpace(String fName, JVectorSpace jVectorSpace) throws FileNotFoundException, IOException {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
       boolean status = false;
       if (getxRes() != 0 && getyRes() != 0){
        
          // jVectorSpace = new JVectorSpace(getxRes(),getyRes());
           
           File dataFile = new File(fName);
           status = dataFile.canRead();
           
           if(status){
               
               FileReader reader = new FileReader(dataFile);
               BufferedReader dataReader = new BufferedReader(reader);
               ArrayList<OrdXYData> xyVector = new ArrayList();
               ArrayList<JVector> activityVector = new ArrayList();
               
               String dataLine, dataFrag [];
               Double [] cmpts ; //= new Double[0];
               int xData, yData, sNo = 0;
               OrdXYData xyCord;
               JVector activity; //= new JVector(cmpts);
               
                   while ((dataLine = dataReader.readLine()) != null){
                       dataFrag = dataLine.split(this.fileSep); 
                       var tFrag = dataFrag.length;
                       cmpts = new Double[tFrag-2];
                       
                       Float xfloatData = Float.parseFloat(dataFrag[0])/ScaleX;
                       Float yfloatData = Float.parseFloat(dataFrag[1])/ScaleY;
                       xData = xfloatData.intValue();
                       yData = yfloatData.intValue();
                       xyCord = new OrdXYData(sNo++,xData,yData);

                       for(int nFrag = 2 ; nFrag < tFrag; nFrag++){
                            cmpts[nFrag - 2] = Double.valueOf(dataFrag[nFrag]);
                       }   
                       if (cmpts.length > 0 ){
                            activity = new JVector(cmpts);
                            activityVector.add(activity);
                       }
                       
                       xyVector.add(xyCord);
                       
                   }
                   double spaceRatio = xyVector.size()/activityVector.size();
                   if(this.isRepeatSpace() && spaceRatio != 1){
                       
                       
                       if(spaceRatio < 1){
                           int nRepeats = (activityVector.size()/xyVector.size());
                           ArrayList <OrdXYData> expXYArray = new ArrayList();
                           for(var xyTmp : xyVector){
                               for(var Count = 0; Count < nRepeats ; Count++)
                                   expXYArray.add(xyTmp);
                           }
                           for(int reminder = activityVector.size() % xyVector.size();reminder > 0 ; reminder--)
                               expXYArray.add(xyVector.getLast());
                           jVectorSpace.fillSpace(expXYArray, activityVector, status);
                       }else{
                           int nRepeats = (xyVector.size()/activityVector.size());
                           ArrayList <JVector> expActivity = new ArrayList();
                           for(var currActivity : activityVector){
                               for(var Count = 0 ; Count < nRepeats ; Count++)
                                        expActivity.add(currActivity);
                           }
                           for(int reminder =  xyVector.size() % activityVector.size();reminder > 0 ; reminder--)
                               expActivity.add(activityVector.getLast());
                           jVectorSpace.fillSpace(xyVector, expActivity, status);
                       }
                       
                   }else
                        
                       jVectorSpace.fillSpace(xyVector, activityVector, false);
                   
                  // this.jFormattedTextFieldnCmpts.setText(activity.getNComponents()+"");
           }
           
           
       }
       
        
        return status;
    }

    /**
     * @return the nRepeat
     */
    public int getnRepeat() {
        return nRepeat;
    }

    /**
     * @return the repeatSpace
     */
    public boolean isRepeatSpace() {
        return repeatSpace;
    }

}
