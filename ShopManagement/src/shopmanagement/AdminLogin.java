
package shopmanagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Atel Dot Net
 */
public class AdminLogin extends javax.swing.JFrame {

    private  ImageIcon icon;
    /**
     * Creates new form AdminLogin
     */
    public AdminLogin() {
        initComponents();
        SetIcon();
    }
    
    public void SetIcon()
    {
        icon=new ImageIcon(getClass().getResource("shop32.png"));
        this.setIconImage(icon.getImage());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFrame1 = new javax.swing.JFrame();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        UserText = new javax.swing.JTextField();
        PasswordText = new javax.swing.JPasswordField();
        SigninButton = new javax.swing.JButton();
        ChangeButton = new javax.swing.JButton();
        NewAdminButton = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("    SHOP MANAGEMENT");
        setBackground(new java.awt.Color(153, 153, 153));
        setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        setForeground(new java.awt.Color(0, 51, 204));
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(52, 73, 94));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("LOGIN HERE ");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(690, 80, 480, 70);

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("ENTER PASSWORD :");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(630, 370, 230, 50);

        jLabel3.setBackground(new java.awt.Color(0, 153, 255));
        jLabel3.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("ENTER USER NAME :");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(630, 280, 240, 50);

        UserText.setBackground(new java.awt.Color(52, 73, 94));
        UserText.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        UserText.setForeground(new java.awt.Color(255, 255, 255));
        UserText.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        UserText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UserTextActionPerformed(evt);
            }
        });
        jPanel1.add(UserText);
        UserText.setBounds(910, 290, 340, 50);

        PasswordText.setBackground(new java.awt.Color(52, 73, 94));
        PasswordText.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        PasswordText.setForeground(new java.awt.Color(255, 255, 255));
        PasswordText.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        PasswordText.setEchoChar('*');
        PasswordText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PasswordTextActionPerformed(evt);
            }
        });
        jPanel1.add(PasswordText);
        PasswordText.setBounds(910, 380, 340, 50);

        SigninButton.setBackground(new java.awt.Color(153, 153, 153));
        SigninButton.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 24)); // NOI18N
        SigninButton.setForeground(new java.awt.Color(74, 84, 94));
        SigninButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/shopmanagement/L_sign.png"))); // NOI18N
        SigninButton.setText("   Sign in");
        SigninButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SigninButtonActionPerformed(evt);
            }
        });
        jPanel1.add(SigninButton);
        SigninButton.setBounds(760, 540, 270, 60);

        ChangeButton.setBackground(new java.awt.Color(153, 153, 153));
        ChangeButton.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 24)); // NOI18N
        ChangeButton.setForeground(new java.awt.Color(74, 84, 94));
        ChangeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/shopmanagement/pass_change.png"))); // NOI18N
        ChangeButton.setText("Change Password ?");
        ChangeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ChangeButtonActionPerformed(evt);
            }
        });
        jPanel1.add(ChangeButton);
        ChangeButton.setBounds(1050, 540, 280, 60);

        NewAdminButton.setBackground(new java.awt.Color(153, 153, 153));
        NewAdminButton.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 24)); // NOI18N
        NewAdminButton.setForeground(new java.awt.Color(74, 84, 94));
        NewAdminButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/shopmanagement/L_32.png"))); // NOI18N
        NewAdminButton.setText("  ADD ADMIN");
        NewAdminButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NewAdminButtonActionPerformed(evt);
            }
        });
        jPanel1.add(NewAdminButton);
        NewAdminButton.setBounds(490, 540, 250, 60);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/shopmanagement/LOGINICON.png"))); // NOI18N
        jPanel1.add(jLabel5);
        jLabel5.setBounds(10, 100, 520, 590);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.add(jPanel2);
        jPanel2.setBounds(630, 170, 420, 10);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.add(jPanel3);
        jPanel3.setBounds(630, 150, 420, 10);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 1360, 730);

        setSize(new java.awt.Dimension(1389, 765));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void UserTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UserTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UserTextActionPerformed

    private void PasswordTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PasswordTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PasswordTextActionPerformed

    private void SigninButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SigninButtonActionPerformed
        // TODO add your handling code here:

        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url="jdbc:sqlserver://localhost:1433;databaseName=ShopManagement;user=sa;password=123456";
            Connection con = DriverManager.getConnection(url);
            String sql = "Select * from AdminLogin where UserName=? and Password = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, UserText.getText().toString());
            pst.setString(2, PasswordText.getText().toString());
            ResultSet rs = pst.executeQuery();
            if(rs.next()){

                String  CurrentLogin=UserText.getText();
                //  System.out.print(CurrentLogin);
                // Deposit obj1=new Deposit();
                // obj1.setEntry(CurrentLogin);
                //JOptionPane.showMessageDialog(null, "Username and Password Matched");
                HomePage1 obj1=new HomePage1();
                obj1.setAdminName(UserText.getText());
                
                HomePage obj= new HomePage();
               // obj.setAdminName(UserText.getText());
                obj.setVisible(true);
                //setVisible(false);
                UserText.setText("");
                PasswordText.setText("");
                dispose();

            }
            else{
                JOptionPane.showMessageDialog(null, "Username and password not Correct");
                UserText.setText("");
                PasswordText.setText("");
            }
            con.close();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_SigninButtonActionPerformed

    private void ChangeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ChangeButtonActionPerformed
        // TODO add your handling code here:
        AdminPasswordChanged obj1=new AdminPasswordChanged();
        obj1.setVisible(true);
    }//GEN-LAST:event_ChangeButtonActionPerformed

    private void NewAdminButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NewAdminButtonActionPerformed
        // TODO add your handling code here:
        NewAdminAdd obj2=new NewAdminAdd();
        obj2.setVisible(true);
    }//GEN-LAST:event_NewAdminButtonActionPerformed

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
            java.util.logging.Logger.getLogger(AdminLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ChangeButton;
    private javax.swing.JButton NewAdminButton;
    private javax.swing.JPasswordField PasswordText;
    private javax.swing.JButton SigninButton;
    private javax.swing.JTextField UserText;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    // End of variables declaration//GEN-END:variables
}