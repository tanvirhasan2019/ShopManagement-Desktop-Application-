/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shopmanagement;

import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Atel Dot Net
 */
public class AddOldProduct extends javax.swing.JFrame {

    private int ProductId;
    boolean Id_Exist=true;
    boolean search_old_product=false;
    String Admin;
    private  ImageIcon icon;
    /**
     * Creates new form AddOldProduct
     */
    public AddOldProduct() {
        initComponents();
        AddButton.setEnabled(false);
         HomePage1 obj=new HomePage1(); 
         Admin=obj.CurrentAdmin.toString();
         SetIcon();
    }
    
      public void SetIcon()
    {
        icon=new ImageIcon(getClass().getResource("shop32.png"));
        this.setIconImage(icon.getImage());
    }
    
 /*   public void setId(int ProductId)
    {
        this.ProductId=ProductId;
    } */

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        AddButton = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        EntryDate = new datechooser.beans.DateChooserCombo();
        importAddress = new javax.swing.JTextField();
        SellingPrice = new javax.swing.JTextField();
        ProductQuantity = new javax.swing.JTextField();
        ProductName = new javax.swing.JTextField();
        price = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        OldProductId = new javax.swing.JTextField();
        SearchButton = new javax.swing.JButton();
        Qnt_Text = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
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

        AddButton.setBackground(new java.awt.Color(0, 102, 255));
        AddButton.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 24)); // NOI18N
        AddButton.setForeground(new java.awt.Color(255, 255, 255));
        AddButton.setText("ADD");
        AddButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddButtonActionPerformed(evt);
            }
        });
        getContentPane().add(AddButton);
        AddButton.setBounds(700, 620, 200, 60);

        jPanel1.setBackground(new java.awt.Color(0, 102, 255));
        jPanel1.setLayout(null);

        jPanel2.setLayout(null);

        jLabel3.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel3.setText("ENTER PRODUCT NAME        :");
        jPanel2.add(jLabel3);
        jLabel3.setBounds(70, 530, 260, 40);

        EntryDate.setCurrentView(new datechooser.view.appearance.AppearancesList("custom",
            new datechooser.view.appearance.ViewAppearance("custom",
                new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 11),
                    new java.awt.Color(0, 0, 0),
                    new java.awt.Color(0, 0, 255),
                    false,
                    true,
                    new datechooser.view.appearance.swing.ButtonPainter()),
                new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 11),
                    new java.awt.Color(0, 0, 0),
                    new java.awt.Color(0, 0, 255),
                    true,
                    true,
                    new datechooser.view.appearance.swing.ButtonPainter()),
                new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 11),
                    new java.awt.Color(0, 0, 255),
                    new java.awt.Color(0, 0, 255),
                    false,
                    true,
                    new datechooser.view.appearance.swing.ButtonPainter()),
                new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 11),
                    new java.awt.Color(128, 128, 128),
                    new java.awt.Color(0, 0, 255),
                    false,
                    true,
                    new datechooser.view.appearance.swing.LabelPainter()),
                new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 11),
                    new java.awt.Color(0, 0, 0),
                    new java.awt.Color(0, 0, 255),
                    false,
                    true,
                    new datechooser.view.appearance.swing.LabelPainter()),
                new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 11),
                    new java.awt.Color(0, 0, 0),
                    new java.awt.Color(255, 0, 0),
                    false,
                    false,
                    new datechooser.view.appearance.swing.ButtonPainter()),
                (datechooser.view.BackRenderer)null,
                false,
                true)));
    EntryDate.setCalendarPreferredSize(new java.awt.Dimension(400, 350));
    EntryDate.setFieldFont(new java.awt.Font("Tahoma", java.awt.Font.BOLD, 18));
    jPanel2.add(EntryDate);
    EntryDate.setBounds(370, 120, 490, 40);

    importAddress.setBackground(new java.awt.Color(0, 102, 255));
    importAddress.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 18)); // NOI18N
    importAddress.setForeground(new java.awt.Color(255, 255, 255));
    importAddress.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
    importAddress.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            importAddressActionPerformed(evt);
        }
    });
    jPanel2.add(importAddress);
    importAddress.setBounds(370, 240, 490, 40);

    SellingPrice.setBackground(new java.awt.Color(0, 102, 255));
    SellingPrice.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 18)); // NOI18N
    SellingPrice.setForeground(new java.awt.Color(255, 255, 255));
    SellingPrice.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
    SellingPrice.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            SellingPriceActionPerformed(evt);
        }
    });
    jPanel2.add(SellingPrice);
    SellingPrice.setBounds(370, 340, 490, 40);

    ProductQuantity.setBackground(new java.awt.Color(0, 102, 255));
    ProductQuantity.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 18)); // NOI18N
    ProductQuantity.setForeground(new java.awt.Color(255, 255, 255));
    ProductQuantity.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
    ProductQuantity.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            ProductQuantityActionPerformed(evt);
        }
    });
    jPanel2.add(ProductQuantity);
    ProductQuantity.setBounds(370, 180, 490, 40);

    ProductName.setBackground(new java.awt.Color(0, 102, 255));
    ProductName.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 18)); // NOI18N
    ProductName.setForeground(new java.awt.Color(255, 255, 255));
    ProductName.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
    jPanel2.add(ProductName);
    ProductName.setBounds(370, 60, 490, 40);

    price.setBackground(new java.awt.Color(0, 102, 255));
    price.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 18)); // NOI18N
    price.setForeground(new java.awt.Color(255, 255, 255));
    price.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
    price.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            priceActionPerformed(evt);
        }
    });
    jPanel2.add(price);
    price.setBounds(370, 290, 490, 40);

    jLabel8.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 24)); // NOI18N
    jLabel8.setText("PRODUCT ID :");
    jPanel2.add(jLabel8);
    jLabel8.setBounds(100, 10, 190, 40);

    jLabel12.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 24)); // NOI18N
    jLabel12.setText("PRODUCT NAME  :");
    jPanel2.add(jLabel12);
    jLabel12.setBounds(100, 60, 210, 30);

    jLabel2.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 24)); // NOI18N
    jLabel2.setText(" DATE   :");
    jPanel2.add(jLabel2);
    jLabel2.setBounds(90, 120, 130, 30);

    jLabel7.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 24)); // NOI18N
    jLabel7.setText("PRODUCT QUANTITY    :");
    jPanel2.add(jLabel7);
    jLabel7.setBounds(100, 180, 270, 30);

    jLabel6.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 24)); // NOI18N
    jLabel6.setText("ADDRESS  :");
    jPanel2.add(jLabel6);
    jLabel6.setBounds(100, 240, 130, 30);

    jLabel11.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 24)); // NOI18N
    jLabel11.setText("COST PRICE :");
    jPanel2.add(jLabel11);
    jLabel11.setBounds(100, 290, 150, 30);

    jLabel10.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 24)); // NOI18N
    jLabel10.setText("SELLING PRICE   :");
    jPanel2.add(jLabel10);
    jLabel10.setBounds(100, 340, 190, 30);

    OldProductId.setBackground(new java.awt.Color(102, 102, 255));
    OldProductId.setFont(new java.awt.Font("Yu Gothic Light", 1, 22)); // NOI18N
    OldProductId.setForeground(new java.awt.Color(255, 255, 255));
    OldProductId.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
    OldProductId.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
    OldProductId.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            OldProductIdActionPerformed(evt);
        }
    });
    OldProductId.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyPressed(java.awt.event.KeyEvent evt) {
            OldProductIdKeyPressed(evt);
        }
    });
    jPanel2.add(OldProductId);
    OldProductId.setBounds(370, 10, 490, 40);

    SearchButton.setBackground(new java.awt.Color(0, 102, 255));
    SearchButton.setForeground(new java.awt.Color(255, 255, 255));
    SearchButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/shopmanagement/search.png"))); // NOI18N
    SearchButton.setText("   SEARCH");
    SearchButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
    SearchButton.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            SearchButtonActionPerformed(evt);
        }
    });
    jPanel2.add(SearchButton);
    SearchButton.setBounds(880, 10, 120, 40);

    Qnt_Text.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    jPanel2.add(Qnt_Text);
    Qnt_Text.setBounds(870, 184, 150, 30);

    jPanel1.add(jPanel2);
    jPanel2.setBounds(30, 20, 1030, 420);

    getContentPane().add(jPanel1);
    jPanel1.setBounds(150, 140, 1090, 460);

    jPanel3.setBackground(new java.awt.Color(0, 102, 255));
    jPanel3.setLayout(null);

    jLabel9.setFont(new java.awt.Font("Tempus Sans ITC", 3, 48)); // NOI18N
    jLabel9.setForeground(new java.awt.Color(255, 255, 255));
    jLabel9.setText("ADD OLD PRODUCT ON STOCK");
    jPanel3.add(jLabel9);
    jLabel9.setBounds(180, 30, 760, 40);

    getContentPane().add(jPanel3);
    jPanel3.setBounds(150, 30, 1090, 100);

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
    AddProductMenu.setText("    NEW PRODUCT");
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

    MemberInfoItem.setText("MEMBER INFO");
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

    DueBillItem.setText("DUE BILL");
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

    setSize(new java.awt.Dimension(1384, 771));
    setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void AddButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddButtonActionPerformed
        // TODO add your handling code here:
  isCurrentStock_id_exist(OldProductId.getText().toString());
         if(search_old_product==true)
         {
         if(Id_Exist==true)
         {
            
            
            try{
                
              Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
              String url="jdbc:sqlserver://localhost:1433;databaseName=ShopManagement;user=sa;password=123456";
              Connection con = DriverManager.getConnection(url);
           
              String sql = "Update CURRENT_STOCK set ProductQuantity=ProductQuantity+?, ProductName=?, Price=?, SellingPrice=? where ProductId=?";
              PreparedStatement pst2 = con.prepareStatement(sql);
                 //  pst2.setString(1, ProductQuantity.getText().toString());
             // int total=qnt+quantity;
              
              String quantity_st=ProductQuantity.getText().toString();
              int quantity=Integer.parseInt(quantity_st);
              
              pst2.setInt(1, quantity);
              
              //image add
                 
              pst2.setString(2, ProductName.getText().toString());
              float prc=Float.parseFloat(price.getText().toString());
              pst2.setFloat(3, prc);
              float sell=Float.parseFloat(SellingPrice.getText().toString());
              pst2.setFloat(4, sell);
              pst2.setString(5, OldProductId.getText().toString());
                   
              pst2.executeUpdate();
             
         
             con.close();
             
              AllStock();
              
             JOptionPane.showMessageDialog(null, "SUCCESSFULLY ADDED");
             
             OldProductId.setText("");
             ProductName.setText("");
             ProductQuantity.setText("");
             importAddress.setText("");
             price.setText("");
             SellingPrice.setText("");
             
             Qnt_Text.setText("");
          
             
            }
          catch(Exception e)
          {
              
             System.out.println(e);
          }
         
         }else
         {
             JOptionPane.showMessageDialog(null, "PRODUCT ID NOT FOUND");
         }
         }else
         {
            JOptionPane.showMessageDialog(null, "SELECT SERACH BUTTON FIRST");
         } 
    }//GEN-LAST:event_AddButtonActionPerformed

     public void AllStock()
    {
        try
        {
            
        System.out.println("AllStock start ");
          Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url="jdbc:sqlserver://localhost:1433;databaseName=ShopManagement;user=sa;password=123456";
            Connection con1 = DriverManager.getConnection(url);
           // Connection con1 = DriverManager.getConnection(url);

             
            String sql = "Insert into ALLSTOCK"
                    +"(ProductId,ProductQuantity, ImportAddress, Price,  EntryDate, EntryBy)"
                    +"values(?, ?, ?, ?, ?, ?)";
            
            PreparedStatement pst = con1.prepareStatement(sql);
            
            pst.setString(1, OldProductId.getText().toString());
            int qnt = Integer.parseInt(ProductQuantity.getText().toString());
            pst.setInt(2, qnt);
            
            
             System.out.println("AllStock BEFORE IMPORT ADRRESS ");
             
             
            pst.setString(3, importAddress.getText().toString());
            float productPrice=Float.parseFloat(price.getText().toString());
            pst.setFloat(4, productPrice);
           // pst.setString(5, entryBy.getText());
            String dt=EntryDate.getText().toString();
            pst.setString(5, dt);
         //   pst.setString(6, Admin);
            pst.setString(6, Admin);

            
            
             System.out.println("AllStock AFTER IMPORT ADRRESS ");
             
             
            pst.executeUpdate();
            
         
             //  JOptionPane.showMessageDialog(null, "SUCCESSFULLY ADDED");
           
              
                con1.close();
                
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
                
    }
    private void importAddressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_importAddressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_importAddressActionPerformed

    private void SellingPriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SellingPriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SellingPriceActionPerformed

    private void priceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_priceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_priceActionPerformed

    private void OldProductIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OldProductIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_OldProductIdActionPerformed

    private void OldProductIdKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_OldProductIdKeyPressed
        // TODO add your handling code here:
  
        if(evt.getKeyCode()==KeyEvent.VK_ENTER)
        {
            isCurrentStock_id_exist(OldProductId.getText().toString());

            if(Id_Exist==true)
            {
                try {

                    AddButton.setEnabled(true);
                    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                    Connection connection = DriverManager.getConnection(
                        "jdbc:sqlserver://localhost:1433;databaseName=ShopManagement;selectMethod=cursor", "sa", "123456");

                    Statement statement = connection.createStatement();
                    String sql="SELECT * FROM CURRENT_STOCK WHERE ProductId='"+OldProductId.getText().toString()+"'";
                    //System.out.println(sql);
                    ResultSet resultSet = statement
                    .executeQuery(sql);

                    //  String sql="SELECT * FROM AdmissionForm WHERE MemberId=?";

                    // System.out.println("To");
                    String Product_Name="";
                    float Own_Price=0, Sell_Price=0;
                    int quantity=0;
                    while (resultSet.next())
                    {
                        search_old_product=true;
                        quantity=resultSet.getInt("ProductQuantity");
                        Product_Name=resultSet.getString("ProductName");
                        Own_Price=resultSet.getFloat("Price");
                        Sell_Price=resultSet.getFloat("SellingPrice");
                     
                    }

                    // System.out.println("from");
                    ProductName.setText(Product_Name);
                    // ProductQuantity.setText(""+quantity);
                    // importAddress.setText("");
                    price.setText("" + Own_Price);
                    SellingPrice.setText("" + Sell_Price);

                    Qnt_Text.setText("" + quantity);

                    connection.close();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e);
                }
            }else
            {
                JOptionPane.showMessageDialog(null, "PRODUCT ID NOT EXIST ");
            }
        } 
    }//GEN-LAST:event_OldProductIdKeyPressed

    private void SearchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchButtonActionPerformed
        // TODO add your handling code here:

            // AddButton.setEnabled(false);
       // OldProduct.setEnabled(true);

        isCurrentStock_id_exist(OldProductId.getText().toString());

        if(Id_Exist==true)
        {
            try {
                AddButton.setEnabled(true);
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                Connection connection = DriverManager.getConnection(
                    "jdbc:sqlserver://localhost:1433;databaseName=ShopManagement;selectMethod=cursor", "sa", "123456");

                Statement statement = connection.createStatement();
                String sql="SELECT * FROM CURRENT_STOCK WHERE ProductId='"+OldProductId.getText().toString()+"'";
                //System.out.println(sql);
                ResultSet resultSet = statement
                .executeQuery(sql);

                //  String sql="SELECT * FROM AdmissionForm WHERE MemberId=?";

                // System.out.println("To");
                String Product_Name="";
                int quantity=0;
                float Own_Price=0, Sell_Price=0;
                while (resultSet.next())
                {
                    search_old_product=true;
                    quantity=resultSet.getInt("ProductQuantity");
                    Product_Name=resultSet.getString("ProductName");
                    Own_Price=resultSet.getFloat("Price");
                    Sell_Price=resultSet.getFloat("SellingPrice");
                    //  InputStream in = resultSet.getBinaryStream("MemberImage");
                  //  InputStream in = resultSet.getBinaryStream("ProductImage");
                  //  Image image = ImageIO.read(in);
                 //   Image newimg = image.getScaledInstance(200, 150,  java.awt.Image.SCALE_SMOOTH);
                  //  ImageIcon icon=new ImageIcon(newimg);

                  //  lblimage.setIcon(icon);
                 //   lblimage.revalidate();
                    // lblimage.revalidate();
                }

               // search_old_product =true;
                // System.out.println("from");
                ProductName.setText(Product_Name);
                // ProductQuantity.setText(""+quantity);
                // importAddress.setText("");
                price.setText(""+Own_Price);
                SellingPrice.setText(""+Sell_Price);

                Qnt_Text.setText(""+quantity);
             //   OwnPriceText.setText(""+Own_Price+"   BDT");
              //  SellingPriceText.setText(""+Sell_Price+"   BDT");

                connection.close();
                Id_Exist=false;
            }catch(Exception e)
            {
                JOptionPane.showMessageDialog(null, e);
            }
        }else
        {
            JOptionPane.showMessageDialog(null, "PRODUCT ID NOT EXIST ");
        }
        
    }//GEN-LAST:event_SearchButtonActionPerformed
  public void isCurrentStock_id_exist(String ID)
    {
         try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
             Connection connection = DriverManager.getConnection(
                     "jdbc:sqlserver://localhost:1433;databaseName=ShopManagement;selectMethod=cursor", "sa", "123456");


            Statement statement = connection.createStatement();
         //   String sql="SELECT ProductId FROM CURRENT_STOCK WHERE ProductId="+ProductId.getText().toString();
            String sql="SELECT ProductId FROM CURRENT_STOCK WHERE ProductId='"+ID+"'";
            //System.out.println(sql);
            ResultSet resultSet = statement
                    .executeQuery(sql);
            
          //  String sql="SELECT * FROM AdmissionForm WHERE MemberId=?";
            
           // boolean x=false;
         //   findid=" ";
            while(resultSet.next()) 
            { 
               Id_Exist=true;
            //   findid=resultSet.getString("ProductId");
             //  System.out.println(findid+"ID Print");
              // x=true;
              
            }
            
            connection.close();
        }catch(Exception e)
        {
            
        }
         
    }
    private void ProductQuantityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProductQuantityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ProductQuantityActionPerformed

    private void ExitMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ExitMenuMouseClicked
        // TODO add your handling code here:
        HomePage obj=new HomePage();
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
        DueBill obj=new DueBill();
        obj.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_DueBillItemMouseClicked

    private void DueBillItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DueBillItemActionPerformed
        // TODO add your handling code here:
        DueBill obj=new DueBill();
        obj.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_DueBillItemActionPerformed

    private void jMenu1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu1MouseClicked
        // TODO add your handling code here:
        AddProduct obj=new AddProduct();
        obj.setVisible(true);
        this.dispose();

    }//GEN-LAST:event_jMenu1MouseClicked

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
            java.util.logging.Logger.getLogger(AddOldProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddOldProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddOldProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddOldProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddOldProduct().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddButton;
    private javax.swing.JMenu AddProductMenu;
    private javax.swing.JMenuItem DueBillItem;
    private datechooser.beans.DateChooserCombo EntryDate;
    private javax.swing.JMenu ExitMenu;
    private javax.swing.JMenuItem MemberInfoItem;
    private javax.swing.JTextField OldProductId;
    private javax.swing.JTextField ProductName;
    private javax.swing.JTextField ProductQuantity;
    private javax.swing.JLabel Qnt_Text;
    private javax.swing.JButton SearchButton;
    private javax.swing.JMenu SellProductMenu;
    private javax.swing.JTextField SellingPrice;
    private javax.swing.JMenu StockMenu;
    private javax.swing.JTextField importAddress;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField price;
    // End of variables declaration//GEN-END:variables
}
