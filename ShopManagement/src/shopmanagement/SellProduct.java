/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shopmanagement;

import java.awt.ComponentOrientation;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Atel Dot Net
 */
public class SellProduct extends javax.swing.JFrame {

    public Connection connection;
    boolean PhoneNum = false;
    boolean isPriceNeg=false;
    DefaultListModel defaultListModel = new DefaultListModel();
    int ID;
    String ID1;
    String productname;
    int serial = 1;
    //  float sum=0;
    String SellingDate;
    int InvoiceNumber;
    int INVOICE_NUMBER;
    String Shop_Name = "", Shop_Phone = "", Shop_Email = "", Shop_Address = "";
    float Vat = 0;
    String VatNumber = "";
    String SELDATE = "";
    //  String textArea="";
    StringBuffer strBuffer = new StringBuffer();
    //FOR PROFIT PURPOSE
    Map<String, Float> map_p = new HashMap<>();
    Map<String, Float> map_s = new HashMap<>();
    
     Vector<String>Prd_Id  = new Vector<String>(); 
     Vector<Integer>Prd_qnt  = new Vector<Integer>();
     Vector<Float>Prd_price  = new Vector<Float>();
//--
     
    String[] columnNames = {"ProductID", "ProductName", "Quantity", "Price", "Total Price"};

   // DefaultTableModel model = new DefaultTableModel();
       DefaultTableModel model = new DefaultTableModel() {
                    boolean[] canEdit = new boolean[]{
                        false, true, true, true, true, true
                    };

                    public boolean isCellEditable(int rowIndex, int columnIndex) {
                        return canEdit[columnIndex];
                    }
                };

    String Bname, Bphonenumber, Bdate, Baddress, Bemail, Bcompanyname;
    String Admin;
    String Pay_Type = "CASH";
    private ImageIcon icon;

    /**
     * Creates new form SellProduct
     */
    public SellProduct() {
        initComponents();
        SetIcon();
        HomePage1 obj = new HomePage1();
        Admin = obj.CurrentAdmin.toString();

        //  finalTotal.setText("TOTAL PRICE : ");
        ShopInfo();
        jTextPane1.setContentType("text/html");
        model.setColumnIdentifiers(columnNames);
        jTable2.setModel(model);
        this.bindData();

        ButtonGroup radio = new ButtonGroup();
        radio.add(CashButton);
        radio.add(CreditButton);

        CashButton.setSelected(true);
      
    }

    public void SetIcon() {
        icon = new ImageIcon(getClass().getResource("shop32.png"));
        this.setIconImage(icon.getImage());
    }

    private ArrayList getStars() {
        ArrayList stars = new ArrayList();

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection(
                    "jdbc:sqlserver://localhost:1433;databaseName=ShopManagement;selectMethod=cursor", "sa", "123456");

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement
                    .executeQuery("SELECT ProductName, ProductId, Price, SellingPrice FROM CURRENT_STOCK WHERE ProductQuantity>0");

            float p, s;
            while (resultSet.next()) {

                productname = resultSet.getString("ProductName");
                //ID=resultSet.getInt("ProductId");
                ID1 = resultSet.getString("ProductId");
                p=resultSet.getFloat("Price");
             //   s=resultSet.getFloat("SellingPrice");
                
                map_p.put(ID1, p);
               // map_p.put(ID1, s);
                
                stars.add(ID1 + "   " + productname);

            }

            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return stars;
    }

    private void bindData() {

        getStars().stream().forEach((star) -> {
            defaultListModel.addElement(star);
        });

        jList1.setModel(defaultListModel);
        jList1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }

    private void searchFilter(String searchTerm) {
        DefaultListModel filteredItems = new DefaultListModel();
        ArrayList stars = getStars();
        stars.stream().forEach((star) -> {
            String starName = star.toString().toLowerCase();
            if (starName.contains(searchTerm.toLowerCase())) {
                filteredItems.addElement(star);
            }
        });
        defaultListModel = filteredItems;
        jList1.setModel(defaultListModel);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        companyName = new javax.swing.JTextField();
        buyerName = new javax.swing.JTextField();
        phoneNumber = new javax.swing.JTextField();
        address = new javax.swing.JTextField();
        email = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        searchItem = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jLabel10 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        finalTotal = new javax.swing.JLabel();
        print = new javax.swing.JButton();
        saveButton = new javax.swing.JButton();
        clear = new javax.swing.JButton();
        selDate = new datechooser.beans.DateChooserCombo();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        DeleteItem = new javax.swing.JButton();
        Calculate = new javax.swing.JButton();
        CreditButton = new javax.swing.JRadioButton();
        CashButton = new javax.swing.JRadioButton();
        DueBillText = new javax.swing.JTextField();
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

        jPanel1.setBackground(new java.awt.Color(0, 102, 255));

        jLabel1.setFont(new java.awt.Font("Segoe Print", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("SELL PRODUCT");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(569, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 401, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(410, 410, 410))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 1380, 40);

        jLabel2.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 18)); // NOI18N
        jLabel2.setText("ENTER COMPANY NAME :");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(50, 330, 240, 30);

        jLabel3.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 18)); // NOI18N
        jLabel3.setText("ENTER BUYER NAME       :");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(50, 60, 230, 40);

        jLabel4.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 18)); // NOI18N
        jLabel4.setText("SELECT DATE                 :");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(50, 180, 240, 30);

        jLabel5.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 18)); // NOI18N
        jLabel5.setText("ENTER ADDRESS             :");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(50, 230, 230, 30);

        jLabel6.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 18)); // NOI18N
        jLabel6.setText("ENTER EMAIL                 :");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(50, 280, 240, 25);

        jLabel7.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 18)); // NOI18N
        jLabel7.setText("ENTER PHONE NUMBER  :");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(50, 120, 240, 40);

        companyName.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        companyName.setForeground(new java.awt.Color(0, 51, 153));
        companyName.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(companyName);
        companyName.setBounds(290, 330, 270, 30);

        buyerName.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        buyerName.setForeground(new java.awt.Color(0, 51, 153));
        buyerName.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(buyerName);
        buyerName.setBounds(290, 70, 270, 30);

        phoneNumber.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        phoneNumber.setForeground(new java.awt.Color(0, 51, 153));
        phoneNumber.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(phoneNumber);
        phoneNumber.setBounds(290, 120, 270, 30);

        address.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        address.setForeground(new java.awt.Color(0, 51, 153));
        address.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(address);
        address.setBounds(290, 220, 270, 30);

        email.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        email.setForeground(new java.awt.Color(0, 51, 153));
        email.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(email);
        email.setBounds(290, 280, 270, 30);

        jTable2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTable2.setFont(new java.awt.Font("Century", 0, 18)); // NOI18N
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "SERIAL", "PRODUCT NAME", "QUANTITY", "PRICE(PER PIECE)", "TOTAL "
            }
        ));
        jTable2.setRowHeight(25);
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jTable2MouseEntered(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(50, 410, 910, 190);

        jPanel2.setBackground(new java.awt.Color(0, 102, 204));

        jLabel8.setFont(new java.awt.Font("Segoe Print", 1, 28)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("SELECTED PRODUCTS");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(311, Short.MAX_VALUE)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(258, 258, 258))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2);
        jPanel2.setBounds(50, 370, 910, 40);

        jLabel9.setFont(new java.awt.Font("Tempus Sans ITC", 3, 20)); // NOI18N
        jLabel9.setText("          RECEIPT");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(1060, 40, 220, 30);

        searchItem.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        searchItem.setForeground(new java.awt.Color(0, 51, 153));
        searchItem.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        searchItem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                searchItemKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchItemKeyReleased(evt);
            }
        });
        getContentPane().add(searchItem);
        searchItem.setBounds(570, 70, 390, 30);

        jList1.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        jList1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jList1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jList1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jList1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(570, 100, 390, 260);

        jLabel10.setFont(new java.awt.Font("Tempus Sans ITC", 3, 18)); // NOI18N
        jLabel10.setText("SEARCH ITEM");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(700, 40, 200, 30);

        jPanel3.setBackground(new java.awt.Color(0, 102, 255));

        finalTotal.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        finalTotal.setForeground(new java.awt.Color(255, 255, 255));
        finalTotal.setText("TOTAL  :");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(finalTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(finalTotal, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(jPanel3);
        jPanel3.setBounds(980, 470, 370, 50);

        print.setBackground(new java.awt.Color(153, 153, 255));
        print.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        print.setForeground(new java.awt.Color(51, 51, 51));
        print.setText("PRINT");
        print.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        print.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printActionPerformed(evt);
            }
        });
        getContentPane().add(print);
        print.setBounds(1240, 530, 110, 70);

        saveButton.setBackground(new java.awt.Color(153, 153, 255));
        saveButton.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        saveButton.setForeground(new java.awt.Color(51, 51, 51));
        saveButton.setText("SAVE");
        saveButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });
        getContentPane().add(saveButton);
        saveButton.setBounds(980, 530, 110, 70);

        clear.setBackground(new java.awt.Color(153, 153, 255));
        clear.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        clear.setForeground(new java.awt.Color(51, 51, 51));
        clear.setText("CLEAR");
        clear.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearActionPerformed(evt);
            }
        });
        getContentPane().add(clear);
        clear.setBounds(1110, 530, 110, 70);

        selDate.setCurrentView(new datechooser.view.appearance.AppearancesList("custom",
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
    selDate.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED,
        (java.awt.Color)null,
        (java.awt.Color)null,
        (java.awt.Color)null,
        (java.awt.Color)null));
selDate.setCalendarPreferredSize(new java.awt.Dimension(400, 350));
getContentPane().add(selDate);
selDate.setBounds(290, 170, 270, 30);

jTextPane1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
jTextPane1.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
jScrollPane4.setViewportView(jTextPane1);

getContentPane().add(jScrollPane4);
jScrollPane4.setBounds(980, 70, 370, 400);

DeleteItem.setBackground(new java.awt.Color(0, 102, 255));
DeleteItem.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
DeleteItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/shopmanagement/delete-photo (1).png"))); // NOI18N
DeleteItem.setText("DELETE");
DeleteItem.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
DeleteItem.addActionListener(new java.awt.event.ActionListener() {
    public void actionPerformed(java.awt.event.ActionEvent evt) {
        DeleteItemActionPerformed(evt);
    }
    });
    getContentPane().add(DeleteItem);
    DeleteItem.setBounds(50, 610, 200, 50);

    Calculate.setBackground(new java.awt.Color(0, 102, 255));
    Calculate.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
    Calculate.setText("CALCULATE");
    Calculate.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
    Calculate.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            CalculateActionPerformed(evt);
        }
    });
    getContentPane().add(Calculate);
    Calculate.setBounds(260, 610, 190, 50);

    CreditButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
    CreditButton.setForeground(new java.awt.Color(0, 51, 153));
    CreditButton.setText("CREDIT");
    getContentPane().add(CreditButton);
    CreditButton.setBounds(850, 620, 90, 23);

    CashButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
    CashButton.setForeground(new java.awt.Color(0, 51, 153));
    CashButton.setText("CASH");
    getContentPane().add(CashButton);
    CashButton.setBounds(760, 620, 80, 25);

    DueBillText.setBackground(new java.awt.Color(0, 102, 255));
    DueBillText.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
    DueBillText.setForeground(new java.awt.Color(255, 255, 255));
    DueBillText.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
    getContentPane().add(DueBillText);
    DueBillText.setBounds(460, 610, 290, 50);

    jMenuBar1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
    jMenuBar1.setAlignmentX(1.0F);
    jMenuBar1.setAutoscrolls(true);
    jMenuBar1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    jMenuBar1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    jMenuBar1.setMargin(new java.awt.Insets(5, 5, 50, 50));

    ExitMenu.setBackground(new java.awt.Color(153, 153, 153));
    ExitMenu.setBorder(null);
    ExitMenu.setIcon(new javax.swing.ImageIcon("C:\\Users\\Atel Dot Net\\Desktop\\IMAGE\\icon\\bb16.png")); // NOI18N
    ExitMenu.setText("BACK");
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

    setSize(new java.awt.Dimension(1386, 768));
    setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void printActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printActionPerformed
        // TODO add your handling code here:
        //  receipt.append(Bdate);
        //
        try {
            jTextPane1.print();
            jTextPane1.setText("");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }//GEN-LAST:event_printActionPerformed

    private void jList1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList1MouseClicked

        String selct = jList1.getSelectedValue().toString();
        //  System.out.println(selct);
        Vector<Character> s1 = new Vector<Character>();
        Vector<Character> s2 = new Vector<Character>();

        int i = 0;
        char wt;

        for (i = 0; i < selct.length(); i++) {
            wt = selct.charAt(i);
            // char c='a';
            if (Character.isWhitespace(wt) == false) {
                s1.add(selct.charAt(i));
            } else if (Character.isWhitespace(wt) == true) {
                // s1[i]=selct.charAt(i);
                i = i + 3;
                break;

            }
            // s1[i]=selct.charAt(i);
        }

        int l = 0;
        for (int k = i + 0; k < selct.length(); k++) {
            s2.add(selct.charAt(k));
            l++;
        }

        int size1 = s1.size();
        int size2 = s2.size();
        char ss1[] = new char[size1];
        char ss2[] = new char[size2];
        for (i = 0; i < size1; i++) {
            ss1[i] = s1.get(i);
        }

        for (i = 0; i < size2; i++) {
            ss2[i] = s2.get(i);
        }

        String st1 = new String(ss1);

        String st2 = new String(ss2);

        //  Integer result1 = Integer.valueOf(st1);
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection connection = DriverManager.getConnection(
                    "jdbc:sqlserver://localhost:1433;databaseName=ShopManagement;selectMethod=cursor", "sa", "123456");

            Statement statement = connection.createStatement();

            String sql = "SELECT ProductName,ProductId, SellingPrice, ProductQuantity FROM CURRENT_STOCK where ProductId='" + st1 + "'";
            //System.out.println(sql);
            ResultSet resultSet = statement
                    .executeQuery(sql);

            //  String sql="SELECT * FROM AdmissionForm WHERE MemberId=?";
            jTable2.getColumnModel().getColumn(0).setPreferredWidth(3);
            //  jTable2.getColumnModel().getColumn(1).setPreferredWidth(5);
            //   jTable2.getColumnModel().getColumn(3).setPreferredWidth(10);
            //  jTable2.getColumnModel().getColumn(6).setPreferredWidth(10);

            //  i=1;
            // float StockIntotal=0;
            int QuantityCheck = 0;

            while (resultSet.next()) {
                //   System.out.println("IS Enter ");
                String ProductName = resultSet.getString("ProductName");
                String PrdID = resultSet.getString("ProductId");
                //   int ProductQuantity= resultSet.getInt("ProductQuantity");
                float Sprice = resultSet.getFloat("SellingPrice");
                QuantityCheck = resultSet.getInt("ProductQuantity");
                String qnt = JOptionPane.showInputDialog("Enter Quantity :");
                int quantity = Integer.parseInt(qnt);

                if (quantity <= QuantityCheck && quantity> 0) {
                    float Totalprice = quantity * Sprice;

                    // TotalPrice.setText("Total Price : "+TotalPrice);
                    model.addRow(new Object[]{PrdID, ProductName, quantity, Sprice, Totalprice});
                    serial++;
                } else {
                    JOptionPane.showMessageDialog(null, "INSUFFICIENT PRODUCT");
                }

            }
            //float sellTotal=jTable2.getColumnModel().getColumn(0);
            //  Intotal.setText("TOTAL STOCK AMOUNT :  "+StockIntotal);
            // searchItem.setText("");
            /*float sum = 0;
            for (int count = 0; count < model.getRowCount(); count++) {
                String tl = model.getValueAt(count, 4).toString();
                Float ft = Float.parseFloat(tl);
                sum += ft;
                System.out.println(sum);
                finalTotal.setText("TOTAL  : " + sum);
            } */

           // sum = 0;
            
             float subtotal = 0;
        for (int count = 0; count < model.getRowCount(); count++) {
            String tl = model.getValueAt(count, 4).toString();
            Float ft = Float.parseFloat(tl);
            subtotal += ft;
        
        }

        float TOTAL_Vat = (Vat * subtotal) / 100;
        float TOTAL = TOTAL_Vat + subtotal;
        finalTotal.setText("TOTAL  : " + TOTAL);


            // numdata.add(model.getValueAt(count, 0).toString());
            // float sellTotal=model.getValueAt(count, 4);
            //  String sellTotal=jTable2.getColumnModel().getColumn(4).toString();
            //  float finalsell=Float.parseFloat(sellTotal);
            //  TotalPrice.setText("Total Price : "+finalsell);
            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }//GEN-LAST:event_jList1MouseClicked

    private void searchItemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchItemKeyReleased
        // TODO add your handling code here:
        searchFilter(searchItem.getText());
    }//GEN-LAST:event_searchItemKeyReleased

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked

    }//GEN-LAST:event_jTable2MouseClicked

    private void clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearActionPerformed
        // TODO add your handling code here:

        //RBG
        jTextPane1.setText("");
        model.setRowCount(0);
        finalTotal.setText("");

        address.setText("");
        email.setText("");
        companyName.setText("");
        phoneNumber.setText("");
        buyerName.setText("");

    }//GEN-LAST:event_clearActionPerformed

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        // TODO add your handling code here:
        
       
        if (!DueBillText.getText().isEmpty()) {

            if (!phoneNumber.getText().isEmpty()) {
                
               
                InvoiceCreate();
                if(isPriceNeg == false)
                {    
                GetInvoice();
                ShopInfo();

                // ButtonGroup radio=new ButtonGroup();
                // radio.add();
                // radio.add();
                Bname = buyerName.getText();
                Bphonenumber = phoneNumber.getText();
                Bdate = selDate.getText();
                Baddress = address.getText();
                Bemail = email.getText();
                Bcompanyname = companyName.getText();

                if (CashButton.isSelected()) {
                    Pay_Type = "CASH";
                    CreditButton.setSelected(false);
                }

                if (CreditButton.isSelected()) {
                    Pay_Type = "CREDIT";
                    CashButton.setSelected(false);
                }

                System.out.println("DATE " + SELDATE);

                strBuffer.append("<table style=\"width:100%\">\n"
                        + "  <tr>\n"
                        + "    <th>" + Shop_Name + "</th>\n"
                        + "  </tr>\n"
                        + "  \n"
                        + "   <tr>\n"
                        + "    <th>" + Shop_Address + "</th>\n"
                        + "  </tr>\n"
                        + "  \n"
                        + "   <tr>\n"
                        + "    <th>" + Shop_Phone + "</th>\n"
                        + "  </tr>\n"
                        + "   <tr>\n"
                        + "    <th>" + Shop_Email + "</th>\n"
                        + "  </tr>\n"
                        + "  <tr><th>DATE: " + selDate.getText() + "</th>\n"
                        + "  </tr>\n"
                        + "  <tr> <th>INVOICE :" + INVOICE_NUMBER + "</th>\n"
                        + "  </tr>\n"
                        + "  <tr> <th>VAT NUMBER :" + VatNumber + "</th>\n"
                        + "  </tr>\n"
                        + "<tr></tr><tr></tr></table>");

                strBuffer.append("\n<table border = \"1\" cellpadding = \"5\" cellspacing = \"5\" style=\"width:100%; border: 1px solid black;\">\n"
                        + "  <tr>\n"
                        + "     <td>NO</td>\n"
                        + "     <td>PRODUCTID</td> \n"
                        + "     <td>PRODUCT NAME</td>\n"
                        + "     <td>QUANTITY</td>\n"
                        + "     <td>PRICE</td>\n"
                        + "     <td>TOTAL</td>\n"
                        + "    \n"
                        + "  </tr>");
                int serial = 0;
                float subTotal = 0;
                float Intotal = 0;

                for (int count = 0; count < model.getRowCount(); count++) {
                    String productID = model.getValueAt(count, 0).toString();
                    String productName = model.getValueAt(count, 1).toString();
                    String quantity1 = model.getValueAt(count, 2).toString();
                    int qnt = Integer.parseInt(quantity1);
                    String sellPrice = model.getValueAt(count, 3).toString();
                    float sellPrice1 = Float.parseFloat(sellPrice);
                    serial++;
                    subTotal = sellPrice1 * qnt;
                    Intotal += subTotal;
                    //  strBuffer.append("<tr><td><td>"+productName+"</td>"+"<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+quantity1+"</td>"+"<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+sellPrice+"</td><tr>");
                    strBuffer.append(" <tr>\n"
                            + "    <td>" + serial + "</td>\n"
                            + "    <td>" + productID + "</td>\n"
                            + "    <td>" + productName + "</td>\n"
                            + "    <td>" + quantity1 + "</td>\n"
                            + "    <td>" + sellPrice + "</td>\n"
                            + "    <td>" + subTotal + "</td>\n"
                            + "  </tr>");

                }

                float temp = (Intotal * Vat) / 100;
                float temp2 = Intotal + temp;
                strBuffer.append("<tr><td></td><td></td><td></td><td></td><td>VAT:" + Vat + "%</td><td>" + temp + "</td></tr>");
                strBuffer.append("</table>");

                strBuffer.append("<table style=\"width:100%\">\n"
                        + "  <tr>\n"
                        + "     <td align=\"right\">TOTAL PRICE : " + temp2 + "</td>\n"
                        + "  </tr>\n"
                        + "\n"
                        + "</table>");

                strBuffer.append("\n\n<table style=\"width:100%\">\n"
                        + "  <tr>\n"
                        + "  <tr>\n"
                        + "    <th>WELCOME FOR COMING</th>\n"
                        + "   </tr>\n"
                        + "</tr>"
                        + " \n"
                        + "</table>");
                strBuffer.append(" <table style=\\\"width:100%\\\">\n"
                        + "   <tr>\n"
                        + "   <th style=\"color:black;font-size:6\">\n"
                        + "   SOFTWARE DEVELOPED BY-MD.TANVIR HASAN TANSHEN,CONTACT:01521407602\n"
                        + "   </th>\n"
                        + "   </tr\n"
                        + "  </table>");

                jTextPane1.setText(strBuffer.toString());

                finalTotal.setText("TOTAL : " + temp2);

                //  InvoiceCreate();
                try {

                    for (int count = 0; count < model.getRowCount(); count++) {

                        String productID = model.getValueAt(count, 0).toString();

                        String productName = model.getValueAt(count, 1).toString();

                        String quantity1 = model.getValueAt(count, 2).toString();

                        int quantity = Integer.parseInt(quantity1);
                        String sellPrice = model.getValueAt(count, 3).toString();

                        Float SellingPrice = Float.parseFloat(sellPrice);
                        float temp4 = (SellingPrice * Vat) / 100;
                        float SOLD = temp4 + SellingPrice;

                        //  receipt.append(" "+productID+"                "+productName+"                   "+quantity+"                 "+(SellingPrice*quantity)+"\n");
                        // receipt.setText(productID+"       "+productName+"       "+quantity+"          "+(SellingPrice*quantity)+"\n");
                        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                        String url = "jdbc:sqlserver://localhost:1433;databaseName=ShopManagement;user=sa;password=123456";
                        Connection con1 = DriverManager.getConnection(url);
                        // Connection con1 = DriverManager.getConnection(url);

                        String sql = "Insert into SOLD_PRODUCT"
                                + "(ProductId, ProductName, ProductQuantity, SellingPrice, SellingDate, PhoneNumber, InvoiceID, SoldBy, PaymentType)"
                                + "values(?, ?, ?, ?, ?, ?, ?, ?, ?)";

                        String sql1 = "UPDATE CURRENT_STOCK SET ProductQuantity=ProductQuantity -" + quantity + "WHERE ProductId='" + productID + "'";
                      
                       Prd_Id.add(productID);
                       Prd_qnt.add(quantity);
                       Prd_price.add(SellingPrice);
                       
                       // PROFIT(productID,quantity, SellingPrice);
                        /*    String sql2="INSERT INTO DUEALL"
                        +"(PhoneNumber, MemberName, DueDate, Bill, EntryBy, Invoice)"
                    + "Values(?, ?, ?, ?, ?, ?)";
                         */
                        //  temp2=0;
                        //  GetInvoice(phoneNumber.getText().toString());
                        PreparedStatement pst = con1.prepareStatement(sql);
                        PreparedStatement pst1 = con1.prepareStatement(sql1);

                        pst.setString(1, productID);

                        //   pst.setString(2, buyerName.getText().toString());
                        pst.setString(2, productName);
                        //  qnt = Integer.parseInt(ProductQuantity.getText().toString());
                        pst.setInt(3, quantity);

                        pst.setFloat(4, SellingPrice);
                        // float productPrice=Float.parseFloat(Price.getText().toString());
                        pst.setString(5, selDate.getText().toString());
                        pst.setString(6, phoneNumber.getText().toString());
                        pst.setInt(7, INVOICE_NUMBER);
                        pst.setString(8, Admin);
                        pst.setString(9, Pay_Type);
                       // pst.setFloat(10, temp);

                        pst.executeUpdate();
                        pst1.executeUpdate();

                        MemberIsExist(phoneNumber.getText().toString());

                        if (PhoneNum == false) {
                            String sql3 = "Insert into MEMBER"
                                    + "(MemberName, PhoneNumber, Email, CompanyName)"
                                    + "values(?, ?, ?, ?)";
                            PreparedStatement pst3 = con1.prepareStatement(sql3);

                            pst3.setString(1, buyerName.getText().toString());
                            pst3.setString(4, companyName.getText().toString());
                            pst3.setString(3, email.getText().toString());
                            pst3.setString(2, phoneNumber.getText().toString());

                            pst3.executeUpdate();

                        }

                        con1.close();

                    }

                    try {
                        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                        String url = "jdbc:sqlserver://localhost:1433;databaseName=ShopManagement;user=sa;password=123456";
                        Connection con5 = DriverManager.getConnection(url);
                        String sql2 = "INSERT INTO DUEALL"
                                + "(PhoneNumber, MemberName, DueDate, Bill, EntryBy, Invoice)"
                                + "Values(?, ?, ?, ?, ?, ?)";
                        PreparedStatement pst2 = con5.prepareStatement(sql2);
                        pst2.setString(1, phoneNumber.getText().toString());
                        pst2.setString(2, buyerName.getText().toString());
                        pst2.setString(3, selDate.getText().toString());
                        pst2.setString(5, Admin);
                        pst2.setInt(6, INVOICE_NUMBER);

                        float amnt = 0;
                        String Temp_amnt = DueBillText.getText().toString();
                        amnt = Float.parseFloat(Temp_amnt);

                        pst2.setFloat(4, amnt);

                        pst2.executeUpdate();

                        con5.close();
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, e);
                    }
                    model.setRowCount(0);
                    //   finalTotal.setText("");

                    address.setText("");
                    email.setText("");
                    companyName.setText("");
                    phoneNumber.setText("");
                    buyerName.setText("");
                    
                    PROFIT();
                    JOptionPane.showMessageDialog(null, "PAYEMENT SUCCESSFUL");
                   
                    Prd_Id.clear();
                    Prd_qnt.clear();
                    Prd_price.clear();
                
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e);
                    System.out.println(e);
            }
           }  
            } else {
                JOptionPane.showMessageDialog(null, "PLEASE SELECT PHONE NUMBER");
            }

        }  else {

           
            InvoiceCreate();
            
            if(isPriceNeg==false)
            {
            GetInvoice();
            ShopInfo();

            // ButtonGroup radio=new ButtonGroup();
            // radio.add();
            // radio.add();
            Bname = buyerName.getText();
            Bphonenumber = phoneNumber.getText();
            Bdate = selDate.getText();
            Baddress = address.getText();
            Bemail = email.getText();
            Bcompanyname = companyName.getText();

            if (CashButton.isSelected()) {
                Pay_Type = "CASH";
                CreditButton.setSelected(false);
            }

            if (CreditButton.isSelected()) {
                Pay_Type = "CREDIT";
                CashButton.setSelected(false);
            }

            strBuffer.append("<table style=\"width:100%\">\n"
                    + "  <tr>\n"
                    + "    <th>" + Shop_Name + "</th>\n"
                    + "  </tr>\n"
                    + "  \n"
                    + "   <tr>\n"
                    + "    <th>" + Shop_Address + "</th>\n"
                    + "  </tr>\n"
                    + "  \n"
                    + "   <tr>\n"
                    + "    <th>" + Shop_Phone + "</th>\n"
                    + "  </tr>\n"
                    + "   <tr>\n"
                    + "    <th>" + Shop_Email + "</th>\n"
                    + "  </tr>\n"
                    + "    <th>DATE: " + selDate.getText() + "</th>\n"
                    + "  </tr>\n"
                    + "  <tr> <th>INVOICE :" + INVOICE_NUMBER + "</th>\n"
                    + "  </tr>\n"
                    + "  <tr> <th>VAT NUMBER :" + VatNumber + "</th>\n"
                    + "  </tr>\n"
                    + "  \n"
                    + "<tr></tr><tr></tr></table>");

            strBuffer.append("\n<table border = \"1\" cellpadding = \"5\" cellspacing = \"5\" style=\"width:100%; border: 1px solid black;\">\n"
                    + "  <tr>\n"
                    + "     <td>SERIAL</td>\n"
                    + "     <td>PRODUCTID</td> \n"
                    + "     <td>PRODUCTNAME</td>\n"
                    + "     <td>QUANTITY</td>\n"
                    + "     <td>SELLING PRICE</td>\n"
                    + "     <td>TOTAL</td>\n"
                    + "    \n"
                    + "  </tr>");
            int serial = 0;
            float subTotal = 0;
            float Intotal = 0;

            for (int count = 0; count < model.getRowCount(); count++) {
                String productID = model.getValueAt(count, 0).toString();
                String productName = model.getValueAt(count, 1).toString();
                String quantity1 = model.getValueAt(count, 2).toString();
                int qnt = Integer.parseInt(quantity1);
                String sellPrice = model.getValueAt(count, 3).toString();
                float sellPrice1 = Float.parseFloat(sellPrice);
                serial++;
                subTotal = sellPrice1 * qnt;
                Intotal += subTotal;
                //  strBuffer.append("<tr><td><td>"+productName+"</td>"+"<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+quantity1+"</td>"+"<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+sellPrice+"</td><tr>");
                strBuffer.append(" <tr>\n"
                        + "    <td>" + serial + "</td>\n"
                        + "    <td>" + productID + "</td>\n"
                        + "    <td>" + productName + "</td>\n"
                        + "    <td>" + quantity1 + "</td>\n"
                        + "    <td>" + sellPrice + "</td>\n"
                        + "    <td>" + subTotal + "</td>\n"
                        + "  </tr>");

            }

            float temp = (Intotal * Vat) / 100;
            float temp2 = Intotal + temp;
            strBuffer.append("<tr><td></td><td></td><td></td><td></td><td>VAT:" + Vat + "%</td><td>" + temp + "</td></tr>");
            strBuffer.append("</table>");

            strBuffer.append("<table style=\"width:100%\">\n"
                    + "  <tr>\n"
                    + "     <td align=\"right\">TOTAL PRICE : " + temp2 + "</td>\n"
                    + "  </tr>\n"
                    + "\n"
                    + "</table>");

            strBuffer.append("\n\n<table style=\"width:100%\">\n"
                    + "  <tr>\n"
                    + "  <tr>\n"
                    + "    <th>WELCOME FOR COMING </th>\n"
                    + "   </tr>\n"
                    + "  </tr>\n"
                    + " \n"
                    + "</table>");
                 strBuffer.append(" <table style=\\\"width:100%\\\">\n"
                        + "   <tr>\n"
                        + "   <th style=\"color:black;font-size:6\">\n"
                        + "   @SOFTWARE DEVELOPED BY-MD.TANVIR HASAN TANSHEN,CONTACT:01521407602\n"
                        + "   </th>\n"
                        + "   </tr\n"
                        + "  </table>");
            jTextPane1.setText(strBuffer.toString());

            finalTotal.setText("TOTAL : " + temp2);

            //  InvoiceCreate();
            try {

                for (int count = 0; count < model.getRowCount(); count++) {

                    String productID = model.getValueAt(count, 0).toString();

                    String productName = model.getValueAt(count, 1).toString();

                    String quantity1 = model.getValueAt(count, 2).toString();

                    int quantity = Integer.parseInt(quantity1);
                    String sellPrice = model.getValueAt(count, 3).toString();

                    Float SellingPrice = Float.parseFloat(sellPrice);
                    float temp4 = (SellingPrice * Vat) / 100;
                    float SOLD = temp4 + SellingPrice;

                    //  receipt.append(" "+productID+"                "+productName+"                   "+quantity+"                 "+(SellingPrice*quantity)+"\n");
                    // receipt.setText(productID+"       "+productName+"       "+quantity+"          "+(SellingPrice*quantity)+"\n");
                    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                    String url = "jdbc:sqlserver://localhost:1433;databaseName=ShopManagement;user=sa;password=123456";
                    Connection con1 = DriverManager.getConnection(url);
                    // Connection con1 = DriverManager.getConnection(url);

                    String sql = "Insert into SOLD_PRODUCT"
                            + "(ProductId, ProductName, ProductQuantity, SellingPrice, SellingDate, PhoneNumber, InvoiceID, SoldBy, PaymentType)"
                            + "values(?, ?, ?, ?, ?, ?, ?, ?, ?)";

                    String sql1 = "UPDATE CURRENT_STOCK SET ProductQuantity=ProductQuantity -" + quantity + "WHERE ProductId='" + productID + "'";

                    //  GetInvoice(phoneNumber.getText().toString());
                      Prd_Id.add(productID);
                       Prd_qnt.add(quantity);
                       Prd_price.add(SellingPrice);
                       
                    PreparedStatement pst = con1.prepareStatement(sql);
                    PreparedStatement pst1 = con1.prepareStatement(sql1);
                    //   pst4.setString(1, phoneNumber.getText().toString());

                    pst.setString(1, productID);

                    //   pst.setString(2, buyerName.getText().toString());
                    pst.setString(2, productName);
                    //  qnt = Integer.parseInt(ProductQuantity.getText().toString());
                    pst.setInt(3, quantity);

                    pst.setFloat(4, SellingPrice);
                    // float productPrice=Float.parseFloat(Price.getText().toString());
                    pst.setString(5, selDate.getText().toString());
                    pst.setString(6, phoneNumber.getText().toString());
                    pst.setInt(7, INVOICE_NUMBER);
                    pst.setString(8, Admin);
                    pst.setString(9, Pay_Type);
                    //pst.setFloat(10, temp);
                    // String dt=EntryDate.getText().toString();

                    //  pst.setString(8, companyName.getText().toString());
                    // pst.setString(9, email.getText().toString());
                    pst.executeUpdate();
                    pst1.executeUpdate();

                    //  textArea += productID+productName+quantity+"\n";
                    // IF NEW MEMBER 
                    MemberIsExist(phoneNumber.getText().toString());

                    if (PhoneNum == false) {
                        String sql3 = "Insert into MEMBER"
                                + "(MemberName, PhoneNumber, Email, CompanyName)"
                                + "values(?, ?, ?, ?)";
                        PreparedStatement pst3 = con1.prepareStatement(sql3);

                        pst3.setString(1, buyerName.getText().toString());
                        pst3.setString(4, companyName.getText().toString());
                        pst3.setString(3, email.getText().toString());
                        pst3.setString(2, phoneNumber.getText().toString());

                        pst3.executeUpdate();

                    }

                    con1.close();

                }

                model.setRowCount(0);
                //   finalTotal.setText("");

                address.setText("");
                email.setText("");
                companyName.setText("");
                phoneNumber.setText("");
                buyerName.setText("");
                PROFIT();
                JOptionPane.showMessageDialog(null, "PAYEMENT SUCCESSFUL");
                
                 Prd_Id.clear();
                Prd_qnt.clear();
                Prd_price.clear();

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
                System.out.println(e);
            }
         } else{
                JOptionPane.showMessageDialog(null, "INVALID PRICE AND QUANTITY");
            }
         
           
}
        

        strBuffer.setLength(0);

    }//GEN-LAST:event_saveButtonActionPerformed

    public void PROFIT()
    {
        
        float sum=0;
        int q;
        float p,s;
        float temp;
       //  Map<String, Float> map_p = new HashMap<>();
        //  Map<String, Float> map_s = new HashMap<>();
    
        for(int i=0; i<Prd_Id.size(); i++)
        {
            q=Prd_qnt.get(i);
            s= Prd_price.get(i);
            p=map_p.get(Prd_Id.get(i));
            temp =(s-p)*q;
             sum +=temp;
        }

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433;databaseName=ShopManagement;user=sa;password=123456";
            Connection con1 = DriverManager.getConnection(url);
            // Connection con1 = DriverManager.getConnection(url);

            String sql = "INSERT INTO Profit"
                    + "(Invoice, Amount, SellDate)"
                    + "values(?, ?, ?)";

            //  GetInvoice(phoneNumber.getText().toString());
               PreparedStatement pst = con1.prepareStatement(sql);

            pst.setInt(1, INVOICE_NUMBER);
            pst.setFloat(2, sum);
            pst.setString(3, selDate.getText());
           // pst3.setString(2, phoneNumber.getText().toString());
          //  Prd_Id.add(productID);
        //    Prd_qnt.add(quantity);
            //Prd_price.add(SellingPrice);

          //  PreparedStatement pst = con1.prepareStatement(sql);
            //PreparedStatement pst1 = con1.prepareStatement(sql1);
            //   pst4.setString(1, phoneNumber.getText().toString());

            pst.executeUpdate();

           
            con1.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

         // con1.close();
    
    }
    private void jTable2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseEntered
        // TODO add your handling code here:

    }//GEN-LAST:event_jTable2MouseEntered

    private void DeleteItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteItemActionPerformed
        // TODO add your handling code here:
        try {
            //int SelectedRowIndex=0;
            float sum = 0;
            int SelectedRowIndex = jTable2.getSelectedRow();
            model.removeRow(SelectedRowIndex);
            int rows = 0;
            for (int count = 0; count < model.getRowCount(); count++) {
                String tl = model.getValueAt(count, 4).toString();

                Float ft = Float.parseFloat(tl);
                //     System.out.println("Last"+ft);
                sum += ft;

                rows = jTable2.getRowCount();
                //    System.out.println("Row : "+rows);

                finalTotal.setText(" TOTAL PRICE : " + sum);

                // finalTotal.setText("TOTAL ROW: "+rows);
                //JOptionPane.showMessageDialog(null, "SUCESSFULLY REMOVED");
            }
            if (rows == 0) {
                finalTotal.setText("");
            }

        } catch (Exception ex) {
            //JOptionPane.showMessageDialog(null, ex);
        }
    }//GEN-LAST:event_DeleteItemActionPerformed

    private void CalculateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CalculateActionPerformed
        ShopInfo();
        float subtotal = 0;
        for (int count = 0; count < model.getRowCount(); count++) {
            String tl = model.getValueAt(count, 4).toString();
            Float ft = Float.parseFloat(tl);
            subtotal += ft;
        
        }

        float TOTAL_Vat = (Vat * subtotal) / 100;
        float TOTAL = TOTAL_Vat + subtotal;
        finalTotal.setText("TOTAL  : " + TOTAL);

    }//GEN-LAST:event_CalculateActionPerformed

    private void searchItemKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchItemKeyPressed
        // TODO add your handling code here:
        searchFilter(searchItem.getText());
    }//GEN-LAST:event_searchItemKeyPressed

    private void ExitMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ExitMenuMouseClicked
        // TODO add your handling code here:
        HomePage obj = new HomePage();
        obj.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_ExitMenuMouseClicked

    private void ExitMenuKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ExitMenuKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_ExitMenuKeyPressed

    private void AddProductMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddProductMenuMouseClicked
        // TODO add your handling code here:
        AddProduct obj = new AddProduct();
        obj.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_AddProductMenuMouseClicked

    private void SellProductMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SellProductMenuMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_SellProductMenuMouseClicked

    private void StockMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_StockMenuMouseClicked
        // TODO add your handling code here:
        StockInfo obj = new StockInfo();
        obj.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_StockMenuMouseClicked

    private void MemberInfoItemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MemberInfoItemMouseClicked
        // TODO add your handling code here:
        //   MemberAccount obj=new MemberAccount();
        //obj.setVisible(true);
    }//GEN-LAST:event_MemberInfoItemMouseClicked

    private void MemberInfoItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MemberInfoItemActionPerformed
        // TODO add your handling code here:
        //  MemberAccount obj=new MemberAccount();
        //  obj.setVisible(true);
    }//GEN-LAST:event_MemberInfoItemActionPerformed

    private void DueBillItemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DueBillItemMouseClicked
        // TODO add your handling code here:
        DueBill obj = new DueBill();
        obj.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_DueBillItemMouseClicked

    private void DueBillItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DueBillItemActionPerformed
        // TODO add your handling code here:
        DueBill obj = new DueBill();
        obj.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_DueBillItemActionPerformed

    private void jMenu1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu1MouseClicked
        // TODO add your handling code here:
        SellProduct obj=new SellProduct();
        obj.setVisible(true);
        this.dispose();

    }//GEN-LAST:event_jMenu1MouseClicked

    public void MemberIsExist(String PhoneNumber) {
        try {

            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection connection = DriverManager.getConnection(
                    "jdbc:sqlserver://localhost:1433;databaseName=ShopManagement;selectMethod=cursor", "sa", "123456");

            Statement statement = connection.createStatement();

            String sql = "SELECT* FROM MEMBER where PhoneNumber= '" + PhoneNumber + "'";
            ResultSet resultSet = statement
                    .executeQuery(sql);

            while (resultSet.next()) {

                PhoneNum = true;
            }

            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //  public void GetInvoice(String phoneNumber1)
    public void GetInvoice() {
        try {

            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection connection = DriverManager.getConnection(
                    "jdbc:sqlserver://localhost:1433;databaseName=ShopManagement;selectMethod=cursor", "sa", "123456");

            Statement statement = connection.createStatement();

            // String sql="SELECT InvoiceID FROM INVOICE where PhoneNumber= '"+phoneNumber1+"'";
            String sql = "SELECT TOP 1 InvoiceID FROM INVOICE order by InvoiceID DESC";

            ResultSet resultSet = statement
                    .executeQuery(sql);

            //    int x=0;
            while (resultSet.next()) {
            
                INVOICE_NUMBER = resultSet.getInt("InvoiceID");
            }

            //  System.out.println("Invoice : "+x);
            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void InvoiceCreate() {
        try {

            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433;databaseName=ShopManagement;user=sa;password=123456";
            Connection con1 = DriverManager.getConnection(url);
           
                int serial = 0;
                float subTotal = 0;
                float Intotal = 0;

                for (int count = 0; count < model.getRowCount(); count++) {
                   
                    String quantity1 = model.getValueAt(count, 2).toString();
                    int qnt = Integer.parseInt(quantity1);
                    String sellPrice = model.getValueAt(count, 3).toString();
                    float sellPrice1 = Float.parseFloat(sellPrice);
                    serial++;
                    subTotal = sellPrice1 * qnt;
                    Intotal += subTotal;
                  
                }

                
                if(Intotal<0)
                {
                    isPriceNeg=true;
                }
                
                 // VAT CALCULATE IN VARIABLE VatCount
                float VatCount = (Intotal * Vat) / 100;
                
            
        
            String sql4 = "Insert into INVOICE"
                    + "(PhoneNumber, VatPrice)"
                    + "values(?, ?)";

            PreparedStatement pst4 = con1.prepareStatement(sql4);
            pst4.setString(1, phoneNumber.getText().toString());
            //VAT PRICE 
            pst4.setFloat(2, VatCount);
            if(isPriceNeg==false)
            {
                 pst4.executeUpdate();
            }else{
                JOptionPane.showMessageDialog(null, "PLEASE ENTER VALID PRICE AND QUANTITY");
            }
           // pst4.executeUpdate();

        } catch (Exception e) {

        }
    }

    public void ShopInfo() {
        try {

            // SELDATE=selDate.getText().toString();
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection connection = DriverManager.getConnection(
                    "jdbc:sqlserver://localhost:1433;databaseName=ShopManagement;selectMethod=cursor", "sa", "123456");

            Statement statement = connection.createStatement();

            // String sql="SELECT InvoiceID FROM INVOICE where PhoneNumber= '"+phoneNumber1+"'";
            String sql = "SELECT * FROM SHOPINFO";

            ResultSet resultSet = statement
                    .executeQuery(sql);

            //    int x=0;
            while (resultSet.next()) {
                Shop_Name = resultSet.getString("ShopName");
                Shop_Address = resultSet.getString("Address");
                Shop_Phone = resultSet.getString("Phone");
                Shop_Email = resultSet.getString("Email");
                Vat = resultSet.getFloat("Vat");
                VatNumber = resultSet.getString("VatNumber");
            }

            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
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
            java.util.logging.Logger.getLogger(SellProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SellProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SellProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SellProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SellProduct().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu AddProductMenu;
    private javax.swing.JButton Calculate;
    private javax.swing.JRadioButton CashButton;
    private javax.swing.JRadioButton CreditButton;
    private javax.swing.JButton DeleteItem;
    private javax.swing.JMenuItem DueBillItem;
    private javax.swing.JTextField DueBillText;
    private javax.swing.JMenu ExitMenu;
    private javax.swing.JMenuItem MemberInfoItem;
    private javax.swing.JMenu SellProductMenu;
    private javax.swing.JMenu StockMenu;
    private javax.swing.JTextField address;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JTextField buyerName;
    private javax.swing.JButton clear;
    private javax.swing.JTextField companyName;
    private javax.swing.JTextField email;
    private javax.swing.JLabel finalTotal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JList<String> jList1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JTextField phoneNumber;
    private javax.swing.JButton print;
    private javax.swing.JButton saveButton;
    private javax.swing.JTextField searchItem;
    private datechooser.beans.DateChooserCombo selDate;
    // End of variables declaration//GEN-END:variables
}
