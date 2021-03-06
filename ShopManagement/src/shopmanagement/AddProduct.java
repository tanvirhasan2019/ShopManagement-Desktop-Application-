
package shopmanagement;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Locale;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import static shopmanagement.HomePage.CurrentAdmin;

/**
 *
 * @author Atel Dot Net
 */
public class AddProduct extends javax.swing.JFrame {
private BufferedImage chosen_picture;
    private String filename=null;
    private byte[]personimage=null;
    int qnt, quantity;
    String id;
    boolean x=false;
    boolean Id_Exist=false;
    String findid;
    boolean search_old_product=false;
    String Admin;
    private ImageIcon icon;
    /**
     * Creates new form AddProduct
     */
    public AddProduct() {
        initComponents();
        
         HomePage1 obj=new HomePage1(); 
         Admin=obj.CurrentAdmin.toString();
         SetIcon();  
       //  OldProduct.setEnabled(false);
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

        dateChooserDialog1 = new datechooser.beans.DateChooserDialog();
        dateChooserDialog2 = new datechooser.beans.DateChooserDialog();
        dateChooserDialog3 = new datechooser.beans.DateChooserDialog();
        dateChooserDialog4 = new datechooser.beans.DateChooserDialog();
        dateChooserDialog5 = new datechooser.beans.DateChooserDialog();
        dateChooserDialogBeanInfo1 = new datechooser.beans.DateChooserDialogBeanInfo();
        lblimage = new javax.swing.JLabel();
        AddButton = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        EntryDate = new datechooser.beans.DateChooserCombo();
        importAddress = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        ProductQuantity = new javax.swing.JTextField();
        ProductId = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        SellingPrice = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        Price = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        ProductName = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        SellingPriceText = new javax.swing.JLabel();
        QuantityText = new javax.swing.JLabel();
        OwnPriceText = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        InsertImageButton = new javax.swing.JButton();
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

        lblimage.setBackground(new java.awt.Color(0, 102, 255));
        lblimage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/shopmanagement/favourite.png"))); // NOI18N
        lblimage.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        getContentPane().add(lblimage);
        lblimage.setBounds(150, 10, 200, 150);

        AddButton.setBackground(new java.awt.Color(0, 102, 255));
        AddButton.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 24)); // NOI18N
        AddButton.setForeground(new java.awt.Color(255, 255, 255));
        AddButton.setText("ADD ");
        AddButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        AddButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddButtonActionPerformed(evt);
            }
        });
        getContentPane().add(AddButton);
        AddButton.setBounds(740, 570, 200, 60);

        jPanel1.setBackground(new java.awt.Color(0, 102, 255));
        jPanel1.setLayout(null);

        jPanel2.setLayout(null);

        jLabel3.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel3.setText("ENTER PRODUCT NAME        :");
        jPanel2.add(jLabel3);
        jLabel3.setBounds(70, 530, 260, 40);

        jLabel2.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 24)); // NOI18N
        jLabel2.setText("DATE                      ");
        jPanel2.add(jLabel2);
        jLabel2.setBounds(160, 110, 230, 20);

        jLabel6.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 24)); // NOI18N
        jLabel6.setText("ADDRESS                ");
        jPanel2.add(jLabel6);
        jLabel6.setBounds(160, 190, 250, 30);

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
    EntryDate.setBounds(440, 100, 420, 35);

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
    importAddress.setBounds(440, 190, 420, 35);

    jLabel7.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 24)); // NOI18N
    jLabel7.setText("QUANTITY              ");
    jPanel2.add(jLabel7);
    jLabel7.setBounds(160, 150, 250, 30);

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
    ProductQuantity.setBounds(440, 150, 420, 35);

    ProductId.setBackground(new java.awt.Color(0, 102, 255));
    ProductId.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 22)); // NOI18N
    ProductId.setForeground(new java.awt.Color(255, 255, 255));
    ProductId.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
    ProductId.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            ProductIdActionPerformed(evt);
        }
    });
    jPanel2.add(ProductId);
    ProductId.setBounds(440, 10, 420, 35);

    jLabel10.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 24)); // NOI18N
    jLabel10.setText("SELLING PRICE        ");
    jPanel2.add(jLabel10);
    jLabel10.setBounds(160, 270, 270, 30);

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
    SellingPrice.setBounds(440, 270, 420, 35);

    jLabel11.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 24)); // NOI18N
    jLabel11.setText("COST PRICE             ");
    jPanel2.add(jLabel11);
    jLabel11.setBounds(160, 230, 240, 30);

    Price.setBackground(new java.awt.Color(0, 102, 255));
    Price.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 18)); // NOI18N
    Price.setForeground(new java.awt.Color(255, 255, 255));
    Price.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
    Price.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            PriceActionPerformed(evt);
        }
    });
    jPanel2.add(Price);
    Price.setBounds(440, 230, 420, 35);

    jLabel12.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 24)); // NOI18N
    jLabel12.setText("PRODUCT NAME    ");
    jPanel2.add(jLabel12);
    jLabel12.setBounds(160, 60, 240, 30);

    ProductName.setBackground(new java.awt.Color(0, 102, 255));
    ProductName.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 18)); // NOI18N
    ProductName.setForeground(new java.awt.Color(255, 255, 255));
    ProductName.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
    jPanel2.add(ProductName);
    ProductName.setBounds(440, 50, 420, 35);

    jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/shopmanagement/FILLUP.png"))); // NOI18N
    jPanel2.add(jLabel1);
    jLabel1.setBounds(870, 260, 40, 50);

    jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/shopmanagement/FILLUP.png"))); // NOI18N
    jPanel2.add(jLabel13);
    jLabel13.setBounds(870, 40, 40, 50);

    jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/shopmanagement/FILLUP.png"))); // NOI18N
    jPanel2.add(jLabel14);
    jLabel14.setBounds(870, 90, 40, 50);

    jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/shopmanagement/FILLUP.png"))); // NOI18N
    jPanel2.add(jLabel15);
    jLabel15.setBounds(870, 140, 40, 40);

    jLabel16.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 24)); // NOI18N
    jLabel16.setText("NEWPRODUCT ID   ");
    jPanel2.add(jLabel16);
    jLabel16.setBounds(160, 10, 230, 30);

    jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/shopmanagement/FILLUP.png"))); // NOI18N
    jPanel2.add(jLabel17);
    jLabel17.setBounds(870, 220, 40, 50);

    jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/shopmanagement/FILLUP.png"))); // NOI18N
    jPanel2.add(jLabel18);
    jLabel18.setBounds(870, 0, 40, 50);

    SellingPriceText.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
    jPanel2.add(SellingPriceText);
    SellingPriceText.setBounds(910, 300, 130, 30);

    QuantityText.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
    jPanel2.add(QuantityText);
    QuantityText.setBounds(910, 180, 130, 40);

    OwnPriceText.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
    jPanel2.add(OwnPriceText);
    OwnPriceText.setBounds(910, 260, 130, 30);

    jPanel1.add(jPanel2);
    jPanel2.setBounds(60, 20, 960, 340);

    getContentPane().add(jPanel1);
    jPanel1.setBounds(150, 170, 1090, 380);

    jPanel3.setBackground(new java.awt.Color(0, 102, 255));
    jPanel3.setLayout(null);

    jLabel9.setFont(new java.awt.Font("Tempus Sans ITC", 3, 45)); // NOI18N
    jLabel9.setForeground(new java.awt.Color(255, 255, 255));
    jLabel9.setText("ADD NEW PRODUCT ON STOCK");
    jPanel3.add(jLabel9);
    jLabel9.setBounds(100, 20, 720, 70);

    jPanel4.setBackground(new java.awt.Color(0, 102, 255));
    jPanel4.setLayout(null);

    InsertImageButton.setBackground(new java.awt.Color(0, 102, 255));
    InsertImageButton.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 18)); // NOI18N
    InsertImageButton.setForeground(new java.awt.Color(255, 255, 255));
    InsertImageButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/shopmanagement/L_32.png"))); // NOI18N
    InsertImageButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
    InsertImageButton.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            InsertImageButtonActionPerformed(evt);
        }
    });
    jPanel4.add(InsertImageButton);
    InsertImageButton.setBounds(0, 20, 70, 50);

    jPanel3.add(jPanel4);
    jPanel4.setBounds(0, 80, 160, 70);

    getContentPane().add(jPanel3);
    jPanel3.setBounds(360, 10, 880, 150);

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
    AddProductMenu.setText("    OLD PRODUCT");
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

    setSize(new java.awt.Dimension(1377, 779));
    setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void InsertImageButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InsertImageButtonActionPerformed
        // TODO add your handling code here:
        
        
       JFileChooser chooser=new JFileChooser();
       chooser.showOpenDialog(null);
       File f=chooser.getSelectedFile();
        String filename = f.getAbsolutePath();
       ImageIcon imageicon=new ImageIcon(new ImageIcon(filename).getImage().getScaledInstance(lblimage.getWidth(), lblimage.getHeight(), 100));
       lblimage.setIcon(imageicon);
       try
       {
           File image=new File(filename);
           FileInputStream fis=new FileInputStream(image);
           
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            byte[] buf = new byte[1024];
            for (int readNum; (readNum = fis.read(buf)) != -1;) 
            {
              bos.write(buf, 0, readNum);
             // System.out.println("read " + readNum + " bytes,");
            }
            
           personimage = bos.toByteArray();
           
       }catch(Exception e)
       {
           
       }
       

    }//GEN-LAST:event_InsertImageButtonActionPerformed

    private void importAddressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_importAddressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_importAddressActionPerformed

    private void SellingPriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SellingPriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SellingPriceActionPerformed

    private void AddButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddButtonActionPerformed
        // TODO add your handling code here:
        
        
        isCurrentStock_id_exist(ProductId.getText().toString());
        
        if(Id_Exist==false)
        {
        try
         {
            if( ProductId.getText().isEmpty() && ProductName.getText().isEmpty() && ProductQuantity.getText().isEmpty() && Price.getText().isEmpty() && SellingPrice.getText().isEmpty())
            {
                JOptionPane.showMessageDialog(null, "PLEASE FILL UP THE FULL FORM");

            }
            
            else
            {
                
            //admin name find
               
                System.out.println("Login  "+Admin);
                
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url="jdbc:sqlserver://localhost:1433;databaseName=ShopManagement;user=sa;password=123456";
            Connection con1 = DriverManager.getConnection(url);
           // Connection con1 = DriverManager.getConnection(url);

             
            String sql = "Insert into ALLSTOCK"
                    +"(ProductId,ProductQuantity, ImportAddress, Price,  EntryDate, EntryBy, SellPrice)"
                    +"values(?, ?, ?, ?, ?, ?, ?)";
            
            PreparedStatement pst = con1.prepareStatement(sql);
            
            pst.setString(1, ProductId.getText().toString());
            qnt = Integer.parseInt(ProductQuantity.getText().toString());
            pst.setInt(2, qnt);
            pst.setString(3, importAddress.getText().toString());
            float productPrice=Float.parseFloat(Price.getText().toString());
            pst.setFloat(4, productPrice);
           // pst.setString(5, entryBy.getText());
            String dt=EntryDate.getText().toString();
            pst.setString(5, dt);
            pst.setString(6, Admin);
            
            String tmp=SellingPrice.getText().toString();
            float Sell=Float.parseFloat(tmp);
            
            pst.setFloat(7, Sell);
            
            pst.executeUpdate();
            
            
           // isCurrentStock_id_exist();
            
        //    if(!findid.equals(ProductId.getText().toString()))
         //   {  
                System.out.println("New Entry Current stock");
                String sql2="INSERT INTO CURRENT_STOCK"
                    + "(ProductId, ProductQuantity, ProductImage, ProductName, Price, SellingPrice)"+
                    "values(?, ?, ?, ?, ?, ?)";
                  
                 PreparedStatement pst1 = con1.prepareStatement(sql2);
                 pst1.setString(1, ProductId.getText().toString());
                 int Quantity=Integer.parseInt(ProductQuantity.getText());
                 pst1.setInt(2, Quantity);
                 
                       
         Icon icons = lblimage.getIcon();
        BufferedImage bi = new BufferedImage(icons.getIconWidth(), icons.getIconHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics g = bi.createGraphics();
        icons.paintIcon(null, g, 0, 0);
        g.setColor(Color.WHITE);
        g.drawString(lblimage.getText(), 10, 20);
        g.dispose();

        ByteArrayOutputStream os = new ByteArrayOutputStream();
        ImageIO.write(bi, "jpg", os);
        InputStream fis = new ByteArrayInputStream(os.toByteArray());
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        byte[] buf = new byte[1024];
        for (int readNum; (readNum = fis.read(buf)) != -1;) {
            bos.write(buf, 0, readNum);
            System.out.println("read " + readNum + " bytes,");
            }
         byte[] bytes = bos.toByteArray();
         personimage = bytes;
            
            
     //    pst.setBytes(12, personimage);

                 
                 
                 pst1.setBytes(3,  personimage);
                 pst1.setString(4, ProductName.getText().toString());
                 float productPrice1=Float.parseFloat(Price.getText().toString());
                 pst1.setFloat(5, productPrice1);
                 
                 float priceSell=Float.parseFloat(SellingPrice.getText().toString());
                 pst1.setFloat(6, priceSell);
               
                 pst1.executeUpdate();
            //else
           // {
               // UpdateCurrentStock();
           // }
            
    
               JOptionPane.showMessageDialog(null, "Successfully ADDED");
           
                id=ProductId.getText().toString();
                ProductId.setText("");
                ProductName.setText("");
                ProductQuantity.setText("");
                Price.setText("");
                SellingPrice.setText("");
                importAddress.setText("");
               // entryBy.setText("");
                lblimage.setText("");
             //   lblimage.setIcon(null);

            
                con1.close();
                AddProduct obj=new AddProduct();
                obj.setVisible(true);
                this.dispose();
                
              //  Id_Exist=false;
              //  search_old_product=false;
            }
         }
        
        //CurrentStock();
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            System.out.println(e);
        } 
        }else
        {
            JOptionPane.showMessageDialog(null, "PRODUCT ID ALREADY EXIST");
        }
    }//GEN-LAST:event_AddButtonActionPerformed

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
            findid=" ";
            while (resultSet.next()) 
            { 
               Id_Exist=true;
               findid=resultSet.getString("ProductId");
             //  System.out.println(findid+"ID Print");
              // x=true;
              
            }
            
            connection.close();
        }catch(Exception e)
        {
            
        }
         
    }
    private void PriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PriceActionPerformed

    private void ProductIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProductIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ProductIdActionPerformed

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
        AddOldProduct obj=new AddOldProduct();
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
            
            pst.setString(1, ProductId.getText().toString());
            qnt = Integer.parseInt(ProductQuantity.getText().toString());
            pst.setInt(2, qnt);
            
            
             System.out.println("AllStock BEFORE IMPORT ADRRESS ");
             
             
            pst.setString(3, importAddress.getText().toString());
            float productPrice=Float.parseFloat(Price.getText().toString());
            pst.setFloat(4, productPrice);
           // pst.setString(5, entryBy.getText());
            String dt=EntryDate.getText().toString();
            pst.setString(5, dt);
            pst.setString(6, Admin);
            
            
             System.out.println("AllStock AFTER IMPORT ADRRESS ");
             
             
            pst.executeUpdate();
            
         
             //  JOptionPane.showMessageDialog(null, "ADDED ON ALL STOCK");
           
              
                con1.close();
                
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
                
    }
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
            java.util.logging.Logger.getLogger(AddProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddProduct().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddButton;
    private javax.swing.JMenu AddProductMenu;
    private javax.swing.JMenuItem DueBillItem;
    private datechooser.beans.DateChooserCombo EntryDate;
    private javax.swing.JMenu ExitMenu;
    private javax.swing.JButton InsertImageButton;
    private javax.swing.JMenuItem MemberInfoItem;
    private javax.swing.JLabel OwnPriceText;
    private javax.swing.JTextField Price;
    private javax.swing.JTextField ProductId;
    private javax.swing.JTextField ProductName;
    private javax.swing.JTextField ProductQuantity;
    private javax.swing.JLabel QuantityText;
    private javax.swing.JMenu SellProductMenu;
    private javax.swing.JTextField SellingPrice;
    private javax.swing.JLabel SellingPriceText;
    private javax.swing.JMenu StockMenu;
    private datechooser.beans.DateChooserDialog dateChooserDialog1;
    private datechooser.beans.DateChooserDialog dateChooserDialog2;
    private datechooser.beans.DateChooserDialog dateChooserDialog3;
    private datechooser.beans.DateChooserDialog dateChooserDialog4;
    private datechooser.beans.DateChooserDialog dateChooserDialog5;
    private datechooser.beans.DateChooserDialogBeanInfo dateChooserDialogBeanInfo1;
    private javax.swing.JTextField importAddress;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel lblimage;
    // End of variables declaration//GEN-END:variables
}
