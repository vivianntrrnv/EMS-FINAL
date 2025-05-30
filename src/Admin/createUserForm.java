/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Admin;

import Config.dbConnector;
import Config.passwordHasher;
import eventm.loginForm;
import eventm.regForm;
import static eventm.regForm.uemail;
import static eventm.regForm.usname;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author Jake
 */
public class createUserForm extends javax.swing.JFrame {

  
    public createUserForm() {
        initComponents();
    }
    
     public String destination= "";
     File selectedFile;
     public String oldpath;
      public String path;
      
      public int FileExistenceChecker(String path){
        File file = new File(path);
        String fileName = file.getName();
        
        Path filePath = Paths.get("src/userimages", fileName);
        boolean fileExists = Files.exists(filePath);
        
        if (fileExists) {
            return 1;
        } else {
            return 0;
        }
    
    }
      public static int getHeightFromWidth(String imagePath, int desiredWidth) {
        try {
            // Read the image file
            File imageFile = new File(imagePath);
            BufferedImage image = ImageIO.read(imageFile);
            
            // Get the original width and height of the image
            int originalWidth = image.getWidth();
            int originalHeight = image.getHeight();
            
            // Calculate the new height based on the desired width and the aspect ratio
            int newHeight = (int) ((double) desiredWidth / originalWidth * originalHeight);
            
            return newHeight;
        } catch (IOException ex) {
            System.out.println("No image found!");
        }
        
        return -1;
    }
      
      public  ImageIcon ResizeImage(String ImagePath, byte[] pic, JLabel label) {
    ImageIcon MyImage = null;
        if(ImagePath !=null){
            MyImage = new ImageIcon(ImagePath);
        }else{
            MyImage = new ImageIcon(pic);
        }
        
    int newHeight = getHeightFromWidth(ImagePath, label.getWidth());

    Image img = MyImage.getImage();
    Image newImg = img.getScaledInstance(label.getWidth(), newHeight, Image.SCALE_SMOOTH);
    ImageIcon image = new ImageIcon(newImg);
    return image;
}
    public void imageUpdater(String existingFilePath, String newFilePath){
        File existingFile = new File(existingFilePath);
        if (existingFile.exists()) {
            String parentDirectory = existingFile.getParent();
            File newFile = new File(newFilePath);
            String newFileName = newFile.getName();
            File updatedFile = new File(parentDirectory, newFileName);
            existingFile.delete();
            try {
                Files.copy(newFile.toPath(), updatedFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
                System.out.println("Image updated successfully.");
            } catch (IOException e) {
                System.out.println("Error occurred while updating the image: "+e);
            }
        } else {
            try{
                Files.copy(selectedFile.toPath(), new File(destination).toPath(), StandardCopyOption.REPLACE_EXISTING);
            }catch(IOException e){
                System.out.println("Error on update!");
            }
        }
   }
    
         public boolean updateCheck(){
        dbConnector dbc= new dbConnector();
        try{
             String query= "SELECT*FROM tbl_user WHERE( u_username='"+un.getText()+"'OR u_email= '"
                     +email.getText()+"')AND u_id != '"+uiid.getText()+"'";
            ResultSet resultSet= dbc.getData(query);
            
            if(resultSet.next()){
                uemail= resultSet.getString("u_email");
                if(uemail.equals(email.getText())){
                    JOptionPane.showMessageDialog(null,"Email is Already Used!");
                    email.setText("");
                }
                usname= resultSet.getString("u_username");
                        if(usname.equals(un.getText())){
                    JOptionPane.showMessageDialog(null,"Username is Already Used!");
                    un.setText("");
                }
                
                  return true;
            }else{
                return false;
            }
                    
        }catch(SQLException ex){
            System.out.println(""+ex);
            return false;
            
            
        }
        
    }
     
     public boolean duplicateCheck(){
        dbConnector dbc= new dbConnector();
        
        try{
             String query= "SELECT*FROM tbl_user WHERE u_username='"+un.getText()+"'OR u_email= '"
                     +email.getText()+"'";
            ResultSet resultSet= dbc.getData(query);
            
            if(resultSet.next()){
                uemail= resultSet.getString("u_email");
                if(uemail.equals(email.getText())){
                    JOptionPane.showMessageDialog(null,"Email is Already Used!");
                    email.setText("");
                }
                usname= resultSet.getString("u_username");
                        if(usname.equals(un.getText())){
                    JOptionPane.showMessageDialog(null,"Username is Already Used!");
                    un.setText("");
                }
                
                  return true;
            }else{
                return false;
            }
                    
        }catch(SQLException ex){
            System.out.println(""+ex);
            return false;
            
            
        }
        
    }
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        ln = new javax.swing.JTextField();
        fn = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        email = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        un = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        ut = new javax.swing.JComboBox<>();
        us = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        add = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        uiid = new javax.swing.JTextField();
        update = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        clear = new javax.swing.JButton();
        cancel = new javax.swing.JButton();
        refresh = new javax.swing.JButton();
        ps = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        image = new javax.swing.JLabel();
        select = new javax.swing.JButton();
        remove = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 227));
        jPanel1.setForeground(new java.awt.Color(240, 240, 240));

        jPanel4.setBackground(new java.awt.Color(255, 255, 227));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37, 61, 44)));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel4.add(ln, new org.netbeans.lib.awtextra.AbsoluteConstraints(232, 209, 151, 40));
        jPanel4.add(fn, new org.netbeans.lib.awtextra.AbsoluteConstraints(51, 209, 151, 40));

        jLabel2.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(37, 61, 44));
        jLabel2.setText("Last Name:");
        jPanel4.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(232, 187, -1, -1));

        jLabel1.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(37, 61, 44));
        jLabel1.setText("First Name:");
        jPanel4.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(51, 187, -1, -1));

        jLabel3.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(37, 61, 44));
        jLabel3.setText("Email:");
        jPanel4.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(51, 267, -1, -1));
        jPanel4.add(email, new org.netbeans.lib.awtextra.AbsoluteConstraints(51, 289, 332, 40));

        jLabel4.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(37, 61, 44));
        jLabel4.setText("Username:");
        jPanel4.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(51, 335, -1, -1));
        jPanel4.add(un, new org.netbeans.lib.awtextra.AbsoluteConstraints(51, 357, 332, 40));

        jLabel5.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(37, 61, 44));
        jLabel5.setText("Password:");
        jPanel4.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(51, 403, -1, -1));

        jLabel6.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(37, 61, 44));
        jLabel6.setText("Account Type:");
        jPanel4.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 403, -1, -1));

        ut.setFont(new java.awt.Font("Century Gothic", 1, 11)); // NOI18N
        ut.setForeground(new java.awt.Color(37, 61, 44));
        ut.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Admin", "User" }));
        ut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                utActionPerformed(evt);
            }
        });
        jPanel4.add(ut, new org.netbeans.lib.awtextra.AbsoluteConstraints(431, 429, 247, 40));

        us.setFont(new java.awt.Font("Century Gothic", 1, 11)); // NOI18N
        us.setForeground(new java.awt.Color(37, 61, 44));
        us.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Active", "Pending" }));
        us.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usActionPerformed(evt);
            }
        });
        jPanel4.add(us, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 356, 247, 40));

        jLabel7.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(37, 61, 44));
        jLabel7.setText("User Status:");
        jPanel4.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 335, -1, -1));

        add.setBackground(new java.awt.Color(204, 204, 204));
        add.setFont(new java.awt.Font("Century Gothic", 1, 11)); // NOI18N
        add.setForeground(new java.awt.Color(37, 61, 44));
        add.setText("Add");
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });
        jPanel4.add(add, new org.netbeans.lib.awtextra.AbsoluteConstraints(51, 25, 81, 35));

        jLabel8.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(37, 61, 44));
        jLabel8.setText("User ID:");
        jPanel4.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(51, 119, -1, -1));

        uiid.setEnabled(false);
        jPanel4.add(uiid, new org.netbeans.lib.awtextra.AbsoluteConstraints(51, 141, 332, 40));

        update.setBackground(new java.awt.Color(204, 204, 204));
        update.setFont(new java.awt.Font("Century Gothic", 1, 11)); // NOI18N
        update.setForeground(new java.awt.Color(37, 61, 44));
        update.setText("Update");
        update.setEnabled(false);
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });
        jPanel4.add(update, new org.netbeans.lib.awtextra.AbsoluteConstraints(176, 25, 81, 35));

        delete.setBackground(new java.awt.Color(204, 204, 204));
        delete.setFont(new java.awt.Font("Century Gothic", 1, 11)); // NOI18N
        delete.setForeground(new java.awt.Color(37, 61, 44));
        delete.setText("Delete");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });
        jPanel4.add(delete, new org.netbeans.lib.awtextra.AbsoluteConstraints(302, 25, 81, 35));

        clear.setBackground(new java.awt.Color(204, 204, 204));
        clear.setFont(new java.awt.Font("Century Gothic", 1, 11)); // NOI18N
        clear.setForeground(new java.awt.Color(37, 61, 44));
        clear.setText("Clear");
        clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearActionPerformed(evt);
            }
        });
        jPanel4.add(clear, new org.netbeans.lib.awtextra.AbsoluteConstraints(51, 66, 81, 35));

        cancel.setBackground(new java.awt.Color(204, 204, 204));
        cancel.setFont(new java.awt.Font("Century Gothic", 1, 11)); // NOI18N
        cancel.setForeground(new java.awt.Color(37, 61, 44));
        cancel.setText("Cancel");
        cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelActionPerformed(evt);
            }
        });
        jPanel4.add(cancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(176, 66, 81, 35));

        refresh.setBackground(new java.awt.Color(204, 204, 204));
        refresh.setFont(new java.awt.Font("Century Gothic", 1, 11)); // NOI18N
        refresh.setForeground(new java.awt.Color(37, 61, 44));
        refresh.setText("Refresh");
        refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshActionPerformed(evt);
            }
        });
        jPanel4.add(refresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(302, 66, 81, 35));

        ps.setEnabled(false);
        jPanel4.add(ps, new org.netbeans.lib.awtextra.AbsoluteConstraints(51, 429, 332, 40));

        jPanel3.setLayout(null);

        image.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel3.add(image);
        image.setBounds(10, 10, 190, 180);

        jPanel4.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 30, 210, 200));

        select.setBackground(new java.awt.Color(204, 204, 204));
        select.setFont(new java.awt.Font("Century Gothic", 1, 11)); // NOI18N
        select.setForeground(new java.awt.Color(37, 61, 44));
        select.setText("Select");
        select.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectActionPerformed(evt);
            }
        });
        jPanel4.add(select, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 240, 81, 35));

        remove.setBackground(new java.awt.Color(204, 204, 204));
        remove.setFont(new java.awt.Font("Century Gothic", 1, 11)); // NOI18N
        remove.setForeground(new java.awt.Color(37, 61, 44));
        remove.setText("Remove");
        remove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeActionPerformed(evt);
            }
        });
        jPanel4.add(remove, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 240, 81, 35));

        jLabel11.setFont(new java.awt.Font("Century Gothic", 2, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(37, 61, 44));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Please enter the required information below. ");

        jPanel2.setBackground(new java.awt.Color(37, 61, 44));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel14.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 227));
        jLabel14.setText("Event Management System");
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 192, -1));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 860, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 633, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 705, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 487, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 798, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void utActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_utActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_utActionPerformed

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
        
        if(fn.getText().isEmpty()|| ln.getText().isEmpty()|| email.getText().isEmpty()|| un.getText().isEmpty()|| ps.getText().isEmpty()){
            JOptionPane.showMessageDialog(null,"All fields are required!");
        }else if(ps.getText().length()<8){
            JOptionPane.showMessageDialog(null,"Max password character should be 8 above");
            ps.setText("");
        }else if(duplicateCheck()){
            System.out.println("Duplicate Exist");
        } else{
            
                  dbConnector dbc= new dbConnector();
                  {
                if( dbc.insertData("INSERT INTO tbl_user(u_fname, u_lname, u_email, u_username, u_password, u_type, u_status, u_image)"
                    + "VALUES('"+fn.getText()+"','"+ln.getText()+"','"+email.getText()+"','"+un.getText()+"','"+ps.getText()+"','"+ut.getSelectedItem()+"','"+us.getSelectedItem()+"','"+destination+"')"))
                {
                    try{
                        if (selectedFile == null || destination == null || destination.isEmpty()) {
                         JOptionPane.showMessageDialog(null, "Please select an image before submitting.");
                        return;
                        }
                        
                Files.copy(selectedFile.toPath(), new File(destination).toPath(),StandardCopyOption.REPLACE_EXISTING);
                JOptionPane.showMessageDialog(null,"Inserted Successfully!");
                usersForm uf= new usersForm();
                uf.setVisible(true);
                this.dispose();
                }catch( IOException ex){
                        System.out.println("Insert Image Error: "+ex);
                        }
            }else{
                JOptionPane.showMessageDialog(null, "Connection error!");
            }

         }
        }
    }//GEN-LAST:event_addActionPerformed

    private void usActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usActionPerformed

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
      
    if (fn.getText().isEmpty() || ln.getText().isEmpty() || email.getText().isEmpty() || un.getText().isEmpty()) {
    JOptionPane.showMessageDialog(null, "All fields are required (except password if not changing it).");
} else if (!email.getText().matches("^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$")) {
    JOptionPane.showMessageDialog(null, "Please enter a valid email address.");
    email.setText("");
} else if (updateCheck()) {
    JOptionPane.showMessageDialog(null, "Duplicate exists.");
} else {
    dbConnector dbc = new dbConnector();
    String finalPassword = "";
    String newPassword = ps.getText().trim();

    // If a new password is provided, hash it
    if (!newPassword.isEmpty()) {
        try {
            finalPassword = passwordHasher.hashPassword(newPassword);
        } catch (NoSuchAlgorithmException ex) {
            JOptionPane.showMessageDialog(null, "Error hashing password.");
            return;
        }
    } else {
        // Keep existing hashed password from DB if password field is empty
        try {
            ResultSet rs = dbc.getData("SELECT u_password FROM tbl_user WHERE u_id = '" + uiid.getText() + "'");
            if (rs.next()) {
                finalPassword = rs.getString("u_password");
            } else {
                JOptionPane.showMessageDialog(null, "User  not found.");
                return;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Database error retrieving password.");
            return;
        }
    }

    // Update user record with the final password (hashed or existing)
    dbc.updateData("UPDATE tbl_user SET u_fname = '" + fn.getText() +
                   "', u_lname = '" + ln.getText() +
                   "', u_email = '" + email.getText() +
                   "', u_username = '" + un.getText() +
                   "', u_password = '" + finalPassword +
                   "', u_type = '" + ut.getSelectedItem() +
                   "', u_status = '" + us.getSelectedItem() +
                   "', u_image = '" + destination +
                   "' WHERE u_id = '" + uiid.getText() + "'");

    // Handle image file changes
    if (destination.isEmpty()) {
        File existingFile = new File(oldpath);
        if (existingFile.exists()) {
            existingFile.delete();
        }
    } else {
        if (!oldpath.equals(path)) {
            imageUpdater(oldpath, path);
        }
    }

    // Open users form and close current
    usersForm uf = new usersForm();
    uf.setVisible(true);
    this.dispose();
}



    }//GEN-LAST:event_updateActionPerformed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_deleteActionPerformed

    private void clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_clearActionPerformed

    private void cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelActionPerformed
        usersForm usf= new usersForm();
        usf.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_cancelActionPerformed

    private void refreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshActionPerformed
        createUserForm crf= new createUserForm();
        crf.setVisible(true);
         crf.remove.setEnabled(false);
          crf.select.setEnabled(true);
        this.dispose();
    }//GEN-LAST:event_refreshActionPerformed

    private void selectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectActionPerformed
      JFileChooser fileChooser = new JFileChooser();
                int returnValue = fileChooser.showOpenDialog(null);
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    try {
                        selectedFile = fileChooser.getSelectedFile();
                        destination = "src/userimages/" + selectedFile.getName();
                        path  = selectedFile.getAbsolutePath();
                        
                        
                        if(FileExistenceChecker(path) == 1){
                          JOptionPane.showMessageDialog(null, "File Already Exist, Rename or Choose another!");
                            destination = "";
                            path="";
                        }else{
                            image.setIcon(ResizeImage(path, null, image));
                            select.setEnabled(false);
                            remove.setEnabled(true);
                        }
                    } catch (Exception ex) {
                        System.out.println("File Error!");
                    }
                }
    }//GEN-LAST:event_selectActionPerformed

    private void removeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeActionPerformed
        remove.setEnabled(false);
       select.setEnabled(true);
       image.setIcon(null);
       destination="";
       path= "";

    }//GEN-LAST:event_removeActionPerformed

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
            java.util.logging.Logger.getLogger(createUserForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(createUserForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(createUserForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(createUserForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new createUserForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton add;
    private javax.swing.JButton cancel;
    private javax.swing.JButton clear;
    private javax.swing.JButton delete;
    public javax.swing.JTextField email;
    public javax.swing.JTextField fn;
    public javax.swing.JLabel image;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    public javax.swing.JTextField ln;
    public javax.swing.JTextField ps;
    private javax.swing.JButton refresh;
    public javax.swing.JButton remove;
    public javax.swing.JButton select;
    public javax.swing.JTextField uiid;
    public javax.swing.JTextField un;
    public javax.swing.JButton update;
    public javax.swing.JComboBox<String> us;
    public javax.swing.JComboBox<String> ut;
    // End of variables declaration//GEN-END:variables
}
