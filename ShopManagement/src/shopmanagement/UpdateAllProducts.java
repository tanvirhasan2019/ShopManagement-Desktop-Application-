/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shopmanagement;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JTable;
import javax.swing.KeyStroke;

/**
 *
 * @author Atel Dot Net
 */
public class UpdateAllProducts extends javax.swing.JFrame {

    private ImageIcon icon;
    int ID, QUANTITY;
    boolean Select=false;
    String PID, ADDRESS, ADMIN, IMPORT_DATE;
    float PRICE, SELL_PRICE;
   // int rowIndex=0;
    
    /**
     * Creates new form UpdateAllProducts
     */
    public UpdateAllProducts() {
        initComponents();
        Table_Data();
        jButton3.setEnabled(false);
        jButton4.setEnabled(false);
        SetIcon();

    }
      public void SetIcon()
    {
        icon=new ImageIcon(getClass().getResource("shop32.png"));
        this.setIconImage(icon.getImage());
    }

    public void Table_Data()
    {
        
  
         try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
             Connection connection = DriverManager.getConnection(
                     "jdbc:sqlserver://localhost:1433;databaseName=ShopManagement;selectMethod=cursor", "sa", "123456");

      
            Statement statement = connection.createStatement();
           
            ResultSet resultSet = statement
                    .executeQuery("SELECT  * FROM ALLSTOCK");
            
           
         
           String[] columnNames = {"SERIAL", "PRODUCT ID","QUANTITY","PRICE","SELLING PRICE","IMPORTED ADDRESS","ENTRY BY", "IMPORT DATE"};
           
           DefaultTableModel model = new DefaultTableModel() {
            boolean[] canEdit = new boolean[]{
                    false, true, true, true, true,true,true, true, true
            };
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
};
           
           model.setColumnIdentifiers(columnNames);
           model.isCellEditable(1,1);
           jTable1.setModel(model);
            
              int id, quantity;
              String Product_Id, Address, Admin, Import_Date;
              float Price, Sell_Price;
              
            while (resultSet.next()) {
               
                id=resultSet.getInt("Id");
                Product_Id=resultSet.getString("ProductID");
                quantity=resultSet.getInt("ProductQuantity");
                Price=resultSet.getFloat("Price");
                Address=resultSet.getString("ImportAddress");
                Admin=resultSet.getString("EntryBy");
                Import_Date=resultSet.getString("EntryDate");
                Sell_Price=resultSet.getFloat("SellPrice");
           
                model.addRow(new Object[]{id, Product_Id, quantity, Price, Sell_Price, Address,Admin,Import_Date});
              
            }
       
            connection.close();
                
        } catch (Exception e) {
            e.printStackTrace();
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jPanel3 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        ProductIdText = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        ExitMenu = new javax.swing.JMenu();
        AddProductMenu = new javax.swing.JMenu();
        SellProductMenu = new javax.swing.JMenu();
        StockMenu = new javax.swing.JMenu();
        jMenu6 = new javax.swing.JMenu();
        MemberInfoItem = new javax.swing.JMenuItem();
        DueBillItem = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Sylfaen", 3, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 204));
        jLabel1.setText("ALL ITEMS");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(540, 10, 220, 40);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(20, 10, 1300, 50);
        getContentPane().add(jSeparator1);
        jSeparator1.setBounds(0, 10, 1340, 10);

        jTable1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTable1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTable1.setForeground(new java.awt.Color(51, 51, 51));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setRowHeight(25);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jTable1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTable1KeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(20, 70, 1300, 470);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.setLayout(null);

        jButton2.setBackground(new java.awt.Color(0, 102, 204));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("CLEAR");
        jButton2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2);
        jButton2.setBounds(470, 30, 110, 50);

        jButton3.setBackground(new java.awt.Color(0, 102, 204));
        jButton3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("UPDATE");
        jButton3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
        });
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton3);
        jButton3.setBounds(70, 30, 110, 50);

        jButton4.setBackground(new java.awt.Color(0, 102, 204));
        jButton4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("DELETE");
        jButton4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jButton4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButton4KeyPressed(evt);
            }
        });
        jPanel2.add(jButton4);
        jButton4.setBounds(260, 30, 110, 50);
        jPanel2.add(jSeparator2);
        jSeparator2.setBounds(-20, -8, 620, 20);

        getContentPane().add(jPanel2);
        jPanel2.setBounds(680, 550, 640, 100);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel3.setLayout(null);

        jLabel11.setBackground(new java.awt.Color(51, 102, 255));
        jLabel11.setFont(new java.awt.Font("Tempus Sans ITC", 3, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(51, 51, 51));
        jLabel11.setText(" SEARCH ITEM :");
        jPanel3.add(jLabel11);
        jLabel11.setBounds(30, 30, 190, 50);

        ProductIdText.setBackground(new java.awt.Color(204, 204, 204));
        ProductIdText.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ProductIdText.setForeground(new java.awt.Color(0, 51, 102));
        ProductIdText.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        ProductIdText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                ProductIdTextKeyPressed(evt);
            }
        });
        jPanel3.add(ProductIdText);
        ProductIdText.setBounds(230, 30, 270, 50);

        jButton1.setBackground(new java.awt.Color(0, 102, 204));
        jButton1.setForeground(new java.awt.Color(204, 204, 204));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/shopmanagement/search.png"))); // NOI18N
        jButton1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton1);
        jButton1.setBounds(520, 30, 100, 50);

        getContentPane().add(jPanel3);
        jPanel3.setBounds(20, 550, 640, 100);

        jMenuBar1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jMenuBar1.setAlignmentX(1.0F);
        jMenuBar1.setAutoscrolls(true);
        jMenuBar1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jMenuBar1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jMenuBar1.setMargin(new java.awt.Insets(5, 5, 50, 50));

        ExitMenu.setBackground(new java.awt.Color(153, 153, 153));
        ExitMenu.setBorder(null);
        ExitMenu.setIcon(new javax.swing.ImageIcon("C:\\Users\\Atel Dot Net\\Desktop\\IMAGE\\icon\\bb16.png")); // NOI18N
        ExitMenu.setText(" BACK");
        ExitMenu.setDelay(100);
        ExitMenu.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ExitMenu.setMargin(new java.awt.Insets(0, 0, 0, 50));
        ExitMenu.setPreferredSize(new java.awt.Dimension(105, 19));
        ExitMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ExitMenuMouseClicked(evt);
            }
        });
        ExitMenu.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                ExitMenuKeyPressed(evt);
            }
        });
        jMenuBar1.add(ExitMenu);

        AddProductMenu.setBackground(new java.awt.Color(153, 153, 153));
        AddProductMenu.setBorder(null);
        AddProductMenu.setText("     ADD PRODUCT");
        AddProductMenu.setDelay(100);
        AddProductMenu.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        AddProductMenu.setMargin(new java.awt.Insets(0, 0, 0, 50));
        AddProductMenu.setPreferredSize(new java.awt.Dimension(150, 20));
        AddProductMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AddProductMenuMouseClicked(evt);
            }
        });
        jMenuBar1.add(AddProductMenu);

        SellProductMenu.setBackground(new java.awt.Color(153, 153, 153));
        SellProductMenu.setBorder(null);
        SellProductMenu.setText("      SELL PRODUCT");
        SellProductMenu.setDelay(100);
        SellProductMenu.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        SellProductMenu.setMargin(new java.awt.Insets(0, 0, 0, 50));
        SellProductMenu.setPreferredSize(new java.awt.Dimension(150, 20));
        SellProductMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SellProductMenuMouseClicked(evt);
            }
        });
        jMenuBar1.add(SellProductMenu);

        StockMenu.setBackground(new java.awt.Color(153, 153, 153));
        StockMenu.setBorder(null);
        StockMenu.setText("            STOCK");
        StockMenu.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        StockMenu.setDelay(100);
        StockMenu.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        StockMenu.setMargin(new java.awt.Insets(0, 0, 0, 50));
        StockMenu.setPreferredSize(new java.awt.Dimension(150, 20));
        StockMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                StockMenuMouseClicked(evt);
            }
        });
        jMenuBar1.add(StockMenu);

        jMenu6.setBackground(new java.awt.Color(153, 153, 153));
        jMenu6.setBorder(null);
        jMenu6.setText("          ACCOUNT");
        jMenu6.setDelay(100);
        jMenu6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jMenu6.setMargin(new java.awt.Insets(0, 0, 0, 50));
        jMenu6.setPreferredSize(new java.awt.Dimension(150, 20));

        MemberInfoItem.setText(" MEMBER INFO");
        MemberInfoItem.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        MemberInfoItem.setMargin(new java.awt.Insets(0, 0, 0, 50));
        MemberInfoItem.setPreferredSize(new java.awt.Dimension(150, 26));
        MemberInfoItem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MemberInfoItemMouseClicked(evt);
            }
        });
        MemberInfoItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MemberInfoItemActionPerformed(evt);
            }
        });
        jMenu6.add(MemberInfoItem);

        DueBillItem.setText(" DUE BILL");
        DueBillItem.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        DueBillItem.setMargin(new java.awt.Insets(0, 0, 0, 50));
        DueBillItem.setPreferredSize(new java.awt.Dimension(127, 26));
        DueBillItem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DueBillItemMouseClicked(evt);
            }
        });
        DueBillItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DueBillItemActionPerformed(evt);
            }
        });
        jMenu6.add(DueBillItem);

        jMenuItem1.setText(" UPDATE STOCK");
        jMenuItem1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jMenuItem1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuItem1MouseClicked(evt);
            }
        });
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem1);

        jMenuBar1.add(jMenu6);

        jMenu1.setBackground(new java.awt.Color(153, 153, 153));
        jMenu1.setText("        REFRESH");
        jMenu1.setActionCommand("    REFRESH");
        jMenu1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jMenu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu1MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        setSize(new java.awt.Dimension(1351, 750));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void ExitMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ExitMenuMouseClicked
        // TODO add your handling code here:
         UpdateStock obj=new UpdateStock();
        obj.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_ExitMenuMouseClicked

    private void ExitMenuKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ExitMenuKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_ExitMenuKeyPressed

    private void AddProductMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddProductMenuMouseClicked
        // TODO add your handling code here:
        AddProduct obj=new AddProduct();
        obj.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_AddProductMenuMouseClicked

    private void SellProductMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SellProductMenuMouseClicked
        // TODO add your handling code here:
        SellProduct obj=new SellProduct();
        obj.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_SellProductMenuMouseClicked

    private void StockMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_StockMenuMouseClicked
        // TODO add your handling code here:
        StockInfo obj=new StockInfo();
        obj.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_StockMenuMouseClicked

    private void MemberInfoItemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MemberInfoItemMouseClicked
        // TODO add your handling code here:
        MemberAccount obj=new MemberAccount();
        obj.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_MemberInfoItemMouseClicked

    private void MemberInfoItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MemberInfoItemActionPerformed
        // TODO add your handling code here:
        MemberAccount obj=new MemberAccount();
        obj.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_MemberInfoItemActionPerformed

    private void DueBillItemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DueBillItemMouseClicked
        // TODO add your handling code here:
        //  DueBill obj=new DueBill();
        // obj.setVisible(true);
    }//GEN-LAST:event_DueBillItemMouseClicked

    private void DueBillItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DueBillItemActionPerformed
        // TODO add your handling code here:
        DueBill obj=new DueBill();
        obj.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_DueBillItemActionPerformed

    private void jMenuItem1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem1MouseClicked
        // TODO add your handling code here:
        UpdateStock obj=new UpdateStock();
        obj.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuItem1MouseClicked

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        jButton4.setEnabled(true);
        jButton3.setEnabled(true);
        Select=true;
       Modified_Data();
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked
        // TODO add your handling code here:
        Modified_Data();
        UPDATE();

      
    }//GEN-LAST:event_jButton3MouseClicked

    private void jTable1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable1KeyPressed
        // TODO add your handling code here:
        jButton4.setEnabled(true);
        jButton3.setEnabled(true);
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {

            Modified_Data();
            //System.out.println("ENTER PRESSED");
        }
    }//GEN-LAST:event_jTable1KeyPressed

    private void jButton4KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton4KeyPressed
        // TODO add your handling code here:
       
    }//GEN-LAST:event_jButton4KeyPressed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        int row = jTable1.getSelectedRow();
        String id1 = jTable1.getValueAt(row, 0).toString();
        int y = JOptionPane.showConfirmDialog(null, "ARE YOU WANT TO DELETE ?");
        if (y == JOptionPane.YES_OPTION) {
            try {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                String url = "jdbc:sqlserver://localhost:1433;databaseName=ShopManagement;user=sa;password=123456";
                Connection con1 = DriverManager.getConnection(url);

                String sql = "DELETE FROM ALLSTOCK WHERE Id='"+id1+"'";

                PreparedStatement pst = con1.prepareStatement(sql);

                pst.executeUpdate();
                con1.close();

                JOptionPane.showMessageDialog(null, "DELETED  SUCCESSFULLY");
                this.dispose();
                UpdateAllProducts obj = new UpdateAllProducts();
                obj.setVisible(true);

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }

        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        this.dispose();
        UpdateAllProducts obj = new UpdateAllProducts();
        obj.setVisible(true);

        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
        if (ProductIdText.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "FIRST ENTER PRODUCT ID");
        } else {
            //JOptionPane.showMessageDialog(null, "WELCOME");
            try {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                Connection connection = DriverManager.getConnection(
                        "jdbc:sqlserver://localhost:1433;databaseName=ShopManagement;selectMethod=cursor", "sa", "123456");

                Statement statement = connection.createStatement();

                ResultSet resultSet = statement
                        .executeQuery("SELECT  * FROM ALLSTOCK WHERE ProductId='"+ProductIdText.getText()+"'");

                String[] columnNames = {"SERIAL", "PRODUCT ID", "QUANTITY", "PRICE", "SELLING PRICE", "IMPORTED ADDRESS", "ENTRY BY", "IMPORT DATE"};

                DefaultTableModel model = new DefaultTableModel() {
                    boolean[] canEdit = new boolean[]{
                        false, true, true, true, true, true, true, true, true
                    };

                    public boolean isCellEditable(int rowIndex, int columnIndex) {
                        return canEdit[columnIndex];
                    }
                };

                model.setColumnIdentifiers(columnNames);
               // model.isCellEditable(1, 1);
                jTable1.setModel(model);

                int id, quantity;
                String Product_Id, Address, Admin, Import_Date;
                float Price, Sell_Price;

                while (resultSet.next()) {

                    id = resultSet.getInt("Id");
                    Product_Id = resultSet.getString("ProductID");
                    quantity = resultSet.getInt("ProductQuantity");
                    Price = resultSet.getFloat("Price");
                    Address = resultSet.getString("ImportAddress");
                    Admin = resultSet.getString("EntryBy");
                    Import_Date = resultSet.getString("EntryDate");
                    Sell_Price = resultSet.getFloat("SellPrice");

                    model.addRow(new Object[]{id, Product_Id, quantity, Price, Sell_Price, Address, Admin, Import_Date});

                }

                connection.close();
                ProductIdText.setText("");
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void ProductIdTextKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ProductIdTextKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (ProductIdText.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "FIRST ENTER PRODUCT ID");
            } else {
                //JOptionPane.showMessageDialog(null, "WELCOME");
                try {
                    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                    Connection connection = DriverManager.getConnection(
                            "jdbc:sqlserver://localhost:1433;databaseName=ShopManagement;selectMethod=cursor", "sa", "123456");

                    Statement statement = connection.createStatement();

                    ResultSet resultSet = statement
                            .executeQuery("SELECT  * FROM ALLSTOCK WHERE ProductId='" + ProductIdText.getText() + "'");

                    String[] columnNames = {"SERIAL", "PRODUCT ID", "QUANTITY", "PRICE", "SELLING PRICE", "IMPORTED ADDRESS", "ENTRY BY", "IMPORT DATE"};

                    DefaultTableModel model = new DefaultTableModel() {
                        boolean[] canEdit = new boolean[]{
                            false, true, true, true, true, true, true, true, true
                        };

                        public boolean isCellEditable(int rowIndex, int columnIndex) {
                            return canEdit[columnIndex];
                        }
                    };

                    model.setColumnIdentifiers(columnNames);
                    model.isCellEditable(1, 1);
                    jTable1.setModel(model);

                    int id, quantity;
                    String Product_Id, Address, Admin, Import_Date;
                    float Price, Sell_Price;

                    while (resultSet.next()) {

                        id = resultSet.getInt("Id");
                        Product_Id = resultSet.getString("ProductID");
                        quantity = resultSet.getInt("ProductQuantity");
                        Price = resultSet.getFloat("Price");
                        Address = resultSet.getString("ImportAddress");
                        Admin = resultSet.getString("EntryBy");
                        Import_Date = resultSet.getString("EntryDate");
                        Sell_Price = resultSet.getFloat("SellPrice");

                        model.addRow(new Object[]{id, Product_Id, quantity, Price, Sell_Price, Address, Admin, Import_Date});

                    }

                    connection.close();
                    ProductIdText.setText("");

                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }
    }//GEN-LAST:event_ProductIdTextKeyPressed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        UpdateStock obj=new UpdateStock();
        obj.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenu1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu1MouseClicked
        // TODO add your handling code here:
        UpdateAllProducts obj=new UpdateAllProducts();
        obj.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenu1MouseClicked

    public void Modified_Data() {
        int rowIndex = jTable1.getSelectedRow();
        System.out.println("SELECTED ENTERED ROW " + rowIndex);
        String id = jTable1.getValueAt(rowIndex, 0).toString();
            ID = Integer.parseInt(id);
            //  {id, Product_Id, quantity, Price, Sell_Price, Address,Admin,Import_Date});
            PID = jTable1.getValueAt(rowIndex, 1).toString();
            String qnt = jTable1.getValueAt(rowIndex, 2).toString();
            QUANTITY = Integer.parseInt(qnt);
            String p = jTable1.getValueAt(rowIndex, 3).toString();
            PRICE = Float.parseFloat(p);
            String slp = jTable1.getValueAt(rowIndex, 4).toString();
            SELL_PRICE = Float.parseFloat(slp);
            ADDRESS = jTable1.getValueAt(rowIndex, 5).toString();
            ADMIN = jTable1.getValueAt(rowIndex, 6).toString();
            IMPORT_DATE = jTable1.getValueAt(rowIndex, 7).toString();

    }
    private void createKeybindings(JTable table) {
table.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "Enter");
  table.getActionMap().put("Enter", new AbstractAction() {
    @Override
    public void actionPerformed(ActionEvent ae) {
      //do something on JTable enter pressed
    }
  });
}
    public void UPDATE() {

        
        boolean Valid_Date = true;
        Valid_Date = isValidFormat("yyyy-mm-dd", IMPORT_DATE);
        System.out.println(" DATE "+Valid_Date);
        if (Valid_Date == false) {
            JOptionPane.showMessageDialog(null, "PLEASE ENTER VALID DATE FORMAT");
        } else {
            
            if(QUANTITY>0 && PRICE>0 && SELL_PRICE >0)
            try {
                
                //
                
                  Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                String url = "jdbc:sqlserver://localhost:1433;databaseName=ShopManagement;user=sa;password=123456";
                Connection con = DriverManager.getConnection(url);
                String sql = "UPDATE ALLSTOCK set ProductQuantity=?, Price=?, ImportAddress=?, EntryBy=?, EntryDate=?, SellPrice=? WHERE Id=?";

                PreparedStatement pst = con.prepareStatement(sql);
                
                pst.setInt(1, QUANTITY);
                pst.setFloat(2, PRICE);
                pst.setString(3, ADDRESS);
                pst.setString(4, ADMIN);
                pst.setString(5, IMPORT_DATE);
                pst.setFloat(6, SELL_PRICE);
                pst.setInt(7, ID);

                pst.executeUpdate();

                JOptionPane.showMessageDialog(null, "SUCCESSFULLY UPDATED");

                con.close();
                this.dispose();
                UpdateAllProducts obj = new UpdateAllProducts();
                obj.setVisible(true);

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
            else{
                JOptionPane.showMessageDialog(null, "PLEASE ENTER VALID DATA(POSITIVE)");
            }
        }
    }

    public static boolean isValidFormat(String format, String value) {
        Date date = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            date = sdf.parse(value);
            if (!value.equals(sdf.format(date))) {
                date = null;
            }
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        return date != null;
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
            java.util.logging.Logger.getLogger(UpdateAllProducts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UpdateAllProducts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UpdateAllProducts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UpdateAllProducts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UpdateAllProducts().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu AddProductMenu;
    private javax.swing.JMenuItem DueBillItem;
    private javax.swing.JMenu ExitMenu;
    private javax.swing.JMenuItem MemberInfoItem;
    private javax.swing.JTextField ProductIdText;
    private javax.swing.JMenu SellProductMenu;
    private javax.swing.JMenu StockMenu;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
