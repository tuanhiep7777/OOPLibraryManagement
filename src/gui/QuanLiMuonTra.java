/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import dal.ChiTietMuonDAO;
import dal.DocGiaDAO;
import dal.MuonTraDAO;
import dal.NhanVienDAO;
import dal.SachDAO;
import dto.ChiTietMuonDTO;
import dto.MuonTraDTO;
import java.awt.Color;
import java.awt.event.ItemEvent;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author hiep.tt166077
 */
public class QuanLiMuonTra extends javax.swing.JFrame {

    /**
     * Creates new form QuanLiMuonTra
     */
    String TieuChiTK = "ALL";
    String TenBaoCao = null;
    Boolean hienThiNhapTenBC = false;

    public QuanLiMuonTra() {

        setUndecorated(true);
        setVisible(true);
        initComponents();
        setModelToCombobox();
        Disable_Buttons_Lables();
        Load_RefreshTable();
        TenBC.setVisible(false);
        buttXuatFile1.setVisible(false);
        TenBMLab.setVisible(false);
        
        try {
            MuonTraDAO.updateTienPhat();
            Load_RefreshTable();
        } catch (ClassNotFoundException | SQLException | ParseException ex) {
            Logger.getLogger(QuanLiMuonTra.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void Load_RefreshTable() {
        try {
            MuonTraDAO.LoadDuLieu(tableMT);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(QuanLiSach.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void Load_RefreshTable1(String MaMT) {
        try {
            ChiTietMuonDAO.LoadDuLieu(tableCTM, MaMT);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(QuanLiSach.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void Disable_Buttons_Lables() {

        themMT.setEnabled(false);
        themCTM.setEnabled(false);
        suaMT.setEnabled(false);
        suaCTM.setEnabled(false);
        xoaMT.setEnabled(false);
        xoaCTM.setEnabled(false);
        resetMaSCombo.setEnabled(false);

        txtMaMT.setEnabled(false);
        txtMaDG.setEnabled(false);
        txtMaNV.setEnabled(false);
        txtNgayMuon.setEnabled(false);
        txtHanTra.setEnabled(false);
        txtMaS.setEnabled(false);
        txtTienCoc.setEnabled(false);
        txtNgayTra.setEnabled(false);
        txtGhiChu.setEnabled(false);

        jComboBoxMaMT.setEnabled(false);
        jComboBoxDG.setEnabled(false);
        jComboBoxNV.setEnabled(false);
        jComboBoxMaS.setEnabled(false);
    }

    private void setClickedPanelColor(JPanel panel) {
        panel.setBackground(new Color(254,74,87));//102, 207, 224
    }

    private void resetUnClickedPanColor(JPanel[] pane, JPanel[] indicators) {
        for (int i = 0; i < pane.length; i++) {
            pane[i].setBackground(new Color(216,168,166));

        }
        for (int i = 0; i < indicators.length; i++) {
            indicators[i].setOpaque(false);
        }

    }

    public void setModelToCombobox() {

        DefaultComboBoxModel MaMTModel = new DefaultComboBoxModel();
        DefaultComboBoxModel MaDGModel = new DefaultComboBoxModel();
        DefaultComboBoxModel MaNVModel = new DefaultComboBoxModel();
        DefaultComboBoxModel MaSModel = new DefaultComboBoxModel();

        ArrayList<String> list = new ArrayList<>();
        try {
            list = MuonTraDAO.takeMaMT();
            for (String i : list) {
                MaMTModel.addElement(i);
            }
            jComboBoxMaMT.setModel(MaMTModel);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(QuanLiMuonTra.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            list = DocGiaDAO.takeMaDG();
            for (String i : list) {
                MaDGModel.addElement(i);
            }
            jComboBoxDG.setModel(MaDGModel);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(QuanLiMuonTra.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(QuanLiMuonTra.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            list = NhanVienDAO.takeMaNV();
            for (String i : list) {
                MaNVModel.addElement(i);
            }
            jComboBoxNV.setModel(MaNVModel);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(QuanLiMuonTra.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(QuanLiMuonTra.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void LoaaMaSachToCombobox() {

        DefaultComboBoxModel MaSModel = new DefaultComboBoxModel();
        ArrayList<String> list = new ArrayList<>();
        try {
            list = ChiTietMuonDAO.takeModel("MA_SACH", txtMaMT.getText());
            for (String i : list) {
                MaSModel.addElement(i);
            }
            jComboBoxMaS.setModel(MaSModel);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(QuanLiMuonTra.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(QuanLiMuonTra.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private Boolean isNull(JTextField tf, String content, String tfName) {

        if (content.equals("")) {
            JOptionPane.showMessageDialog(null, tfName + " không được rỗng");
            tf.requestFocus();
            return true;
        }
        return false;
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
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtMaMT = new javax.swing.JTextField();
        txtMaDG = new javax.swing.JTextField();
        txtMaNV = new javax.swing.JTextField();
        txtNgayMuon = new javax.swing.JTextField();
        txtHanTra = new javax.swing.JTextField();
        themMT = new javax.swing.JButton();
        suaMT = new javax.swing.JButton();
        xoaMT = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        txtMaS = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtTienCoc = new javax.swing.JTextField();
        txtGhiChu = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        themCTM = new javax.swing.JButton();
        suaCTM = new javax.swing.JButton();
        xoaCTM = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jComboBoxMaMT = new javax.swing.JComboBox<>();
        jComboBoxDG = new javax.swing.JComboBox<>();
        jComboBoxNV = new javax.swing.JComboBox<>();
        jComboBoxMaS = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        txtNgayTra = new javax.swing.JTextField();
        resetMaSCombo = new javax.swing.JButton();
        resetMaSCombo1 = new javax.swing.JButton();
        txtTC = new javax.swing.JTextField();
        txtTenSach = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        txtTienPhat = new javax.swing.JTextField();
        jSeparator4 = new javax.swing.JSeparator();
        txtTenNV = new javax.swing.JTextField();
        txtTenDG = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        buttPanThem = new javax.swing.JPanel();
        focusThem = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        buttPanSua = new javax.swing.JPanel();
        focusSua = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        buttPanXoa = new javax.swing.JPanel();
        focusXoa = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        buttPanThemFile = new javax.swing.JPanel();
        focusThemFile = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel7 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableMT = new javax.swing.JTable();
        ctmLable = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableCTM = new javax.swing.JTable();
        TieuChi = new javax.swing.JComboBox<>();
        txtContent = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel12 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        buttXuatFile1 = new javax.swing.JButton();
        TenBC = new javax.swing.JTextField();
        TenBMLab = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        jPanel5 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(254, 74, 87));

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Filled_Circle_14px.png"))); // NOI18N
        jLabel1.setText("Mã mượn trả");

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Filled_Circle_14px.png"))); // NOI18N
        jLabel2.setText("Mã độc giả");

        jLabel3.setFont(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Filled_Circle_14px.png"))); // NOI18N
        jLabel3.setText("Mã nhân viên");

        jLabel4.setFont(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Filled_Circle_14px.png"))); // NOI18N
        jLabel4.setText("Ngày mượn");

        jLabel5.setFont(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Filled_Circle_14px.png"))); // NOI18N
        jLabel5.setText("Hạn trả");

        txtMaDG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaDGActionPerformed(evt);
            }
        });

        themMT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Plus_20px_1.png"))); // NOI18N
        themMT.setText("Thêm");
        themMT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                themMTActionPerformed(evt);
            }
        });

        suaMT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Edit_20px.png"))); // NOI18N
        suaMT.setText("Sửa");
        suaMT.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        suaMT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                suaMTActionPerformed(evt);
            }
        });

        xoaMT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Trash_20px.png"))); // NOI18N
        xoaMT.setText("Xóa");
        xoaMT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                xoaMTActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Filled_Circle_14px.png"))); // NOI18N
        jLabel6.setText("Mã sách");

        jLabel7.setFont(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Filled_Circle_14px.png"))); // NOI18N
        jLabel7.setText("Số lượng");

        jLabel8.setFont(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Filled_Circle_14px.png"))); // NOI18N
        jLabel8.setText("Ghi chú");

        themCTM.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Plus_20px_1.png"))); // NOI18N
        themCTM.setText("Thêm");
        themCTM.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        themCTM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                themCTMActionPerformed(evt);
            }
        });

        suaCTM.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Edit_20px.png"))); // NOI18N
        suaCTM.setText("Sửa");
        suaCTM.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        suaCTM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                suaCTMActionPerformed(evt);
            }
        });

        xoaCTM.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Trash_20px.png"))); // NOI18N
        xoaCTM.setText("Xóa");
        xoaCTM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                xoaCTMActionPerformed(evt);
            }
        });

        jSeparator2.setForeground(new java.awt.Color(102, 102, 102));

        jComboBoxMaMT.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxMaMT.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxMaMTItemStateChanged(evt);
            }
        });

        jComboBoxDG.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxDG.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxDGItemStateChanged(evt);
            }
        });

        jComboBoxNV.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxNV.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxNVItemStateChanged(evt);
            }
        });

        jComboBoxMaS.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxMaSItemStateChanged(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Filled_Circle_14px.png"))); // NOI18N
        jLabel10.setText("NgayTra");

        resetMaSCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetMaSComboActionPerformed(evt);
            }
        });

        resetMaSCombo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetMaSCombo1ActionPerformed(evt);
            }
        });

        txtTC.setEditable(false);
        txtTC.setBackground(new java.awt.Color(254, 74, 87));
        txtTC.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        txtTC.setForeground(new java.awt.Color(204, 255, 255));
        txtTC.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 3, 0));
        txtTC.setFocusable(false);
        txtTC.setName(""); // NOI18N

        txtTenSach.setEditable(false);
        txtTenSach.setBackground(new java.awt.Color(254, 74, 87));
        txtTenSach.setFont(new java.awt.Font("Segoe UI Light", 1, 14)); // NOI18N
        txtTenSach.setForeground(new java.awt.Color(204, 255, 255));
        txtTenSach.setBorder(null);

        jLabel11.setFont(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Filled_Circle_14px.png"))); // NOI18N
        jLabel11.setText("Tiền cọc");

        jLabel20.setFont(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Filled_Circle_14px.png"))); // NOI18N
        jLabel20.setText("Tiền phạt");

        txtTienPhat.setEditable(false);
        txtTienPhat.setBackground(new java.awt.Color(254, 74, 87));
        txtTienPhat.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        txtTienPhat.setForeground(new java.awt.Color(204, 255, 255));
        txtTienPhat.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 3, 0));

        txtTenNV.setEditable(false);
        txtTenNV.setBackground(new java.awt.Color(254, 74, 87));
        txtTenNV.setForeground(new java.awt.Color(204, 255, 255));
        txtTenNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTenNVActionPerformed(evt);
            }
        });

        txtTenDG.setEditable(false);
        txtTenDG.setBackground(new java.awt.Color(254, 74, 87));
        txtTenDG.setForeground(new java.awt.Color(204, 255, 255));
        txtTenDG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTenDGActionPerformed(evt);
            }
        });

        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Reset_20px_1.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Reset_20px_1.png"))); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(45, 45, 45)
                                .addComponent(jLabel1)
                                .addGap(3, 3, 3)
                                .addComponent(jComboBoxMaMT, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(3, 3, 3)
                                .addComponent(txtMaMT, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(45, 45, 45)
                                .addComponent(jLabel2)
                                .addGap(16, 16, 16)
                                .addComponent(jComboBoxDG, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(3, 3, 3)
                                .addComponent(txtMaDG, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(139, 139, 139)
                                .addComponent(txtTenDG, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(45, 45, 45)
                                .addComponent(jLabel3)
                                .addGap(2, 2, 2)
                                .addComponent(jComboBoxNV, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(3, 3, 3)
                                .addComponent(txtMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(137, 137, 137)
                                .addComponent(txtTenNV, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(45, 45, 45)
                                .addComponent(jLabel4)
                                .addGap(11, 11, 11)
                                .addComponent(resetMaSCombo1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(txtNgayMuon, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(45, 45, 45)
                                .addComponent(jLabel5)
                                .addGap(36, 36, 36)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtHanTra, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(45, 45, 45)
                                .addComponent(jLabel11)
                                .addGap(28, 28, 28)
                                .addComponent(txtTC, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(45, 45, 45)
                                .addComponent(jLabel20)
                                .addGap(23, 23, 23)
                                .addComponent(txtTienPhat, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(130, 130, 130)
                                .addComponent(txtTenSach, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(140, 140, 140)
                                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(47, 47, 47)
                                .addComponent(jLabel6)
                                .addGap(27, 27, 27)
                                .addComponent(resetMaSCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(jComboBoxMaS, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(3, 3, 3)
                                .addComponent(txtMaS, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(47, 47, 47)
                                .addComponent(jLabel7)
                                .addGap(22, 22, 22)
                                .addComponent(txtTienCoc, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(47, 47, 47)
                                .addComponent(jLabel10)
                                .addGap(28, 28, 28)
                                .addComponent(txtNgayTra, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(47, 47, 47)
                                .addComponent(jLabel8)
                                .addGap(31, 31, 31)
                                .addComponent(txtGhiChu, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(themMT)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(suaMT)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(xoaMT))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(themCTM)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(suaCTM)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(xoaCTM)))))
                .addGap(10, 10, 10))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel1))
                    .addComponent(jComboBoxMaMT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMaMT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jLabel2))
                    .addComponent(jComboBoxDG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMaDG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addComponent(txtTenDG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel3))
                    .addComponent(jComboBoxNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addComponent(txtTenNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(jLabel4))
                            .addComponent(resetMaSCombo1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNgayMuon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(4, 4, 4)
                                        .addComponent(jLabel5))
                                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(txtHanTra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(jLabel11))
                            .addComponent(txtTC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(23, 23, 23)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel20)
                            .addComponent(txtTienPhat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(11, 11, 11)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(suaMT)
                            .addComponent(xoaMT)
                            .addComponent(themMT))
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(txtTenSach, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel6))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(resetMaSCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jComboBoxMaS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMaS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel7))
                    .addComponent(txtTienCoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel10))
                    .addComponent(txtNgayTra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel8))
                    .addComponent(txtGhiChu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(suaCTM)
                    .addComponent(xoaCTM)
                    .addComponent(themCTM)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 30, 330, 670));

        jPanel6.setBackground(new java.awt.Color(216, 168, 166));
        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3));

        buttPanThem.setBackground(new java.awt.Color(216, 168, 166));
        buttPanThem.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buttPanThem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttPanThemMouseClicked(evt);
            }
        });

        focusThem.setOpaque(false);
        focusThem.setPreferredSize(new java.awt.Dimension(5, 51));

        javax.swing.GroupLayout focusThemLayout = new javax.swing.GroupLayout(focusThem);
        focusThem.setLayout(focusThemLayout);
        focusThemLayout.setHorizontalGroup(
            focusThemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );
        focusThemLayout.setVerticalGroup(
            focusThemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(51, 51, 51));
        jLabel16.setText("Thêm");

        javax.swing.GroupLayout buttPanThemLayout = new javax.swing.GroupLayout(buttPanThem);
        buttPanThem.setLayout(buttPanThemLayout);
        buttPanThemLayout.setHorizontalGroup(
            buttPanThemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buttPanThemLayout.createSequentialGroup()
                .addComponent(focusThem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(jLabel16)
                .addGap(0, 39, Short.MAX_VALUE))
        );
        buttPanThemLayout.setVerticalGroup(
            buttPanThemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, buttPanThemLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(buttPanThemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
                    .addComponent(focusThem, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        buttPanSua.setBackground(new java.awt.Color(216, 168, 166));
        buttPanSua.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buttPanSua.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttPanSuaMouseClicked(evt);
            }
        });

        focusSua.setOpaque(false);
        focusSua.setPreferredSize(new java.awt.Dimension(5, 51));

        javax.swing.GroupLayout focusSuaLayout = new javax.swing.GroupLayout(focusSua);
        focusSua.setLayout(focusSuaLayout);
        focusSuaLayout.setHorizontalGroup(
            focusSuaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );
        focusSuaLayout.setVerticalGroup(
            focusSuaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLabel17.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(51, 51, 51));
        jLabel17.setText("Sửa");

        javax.swing.GroupLayout buttPanSuaLayout = new javax.swing.GroupLayout(buttPanSua);
        buttPanSua.setLayout(buttPanSuaLayout);
        buttPanSuaLayout.setHorizontalGroup(
            buttPanSuaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buttPanSuaLayout.createSequentialGroup()
                .addComponent(focusSua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(jLabel17)
                .addGap(0, 51, Short.MAX_VALUE))
        );
        buttPanSuaLayout.setVerticalGroup(
            buttPanSuaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, buttPanSuaLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(buttPanSuaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
                    .addComponent(focusSua, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        buttPanXoa.setBackground(new java.awt.Color(216, 168, 166));
        buttPanXoa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buttPanXoa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttPanXoaMouseClicked(evt);
            }
        });

        focusXoa.setOpaque(false);
        focusXoa.setPreferredSize(new java.awt.Dimension(5, 51));

        javax.swing.GroupLayout focusXoaLayout = new javax.swing.GroupLayout(focusXoa);
        focusXoa.setLayout(focusXoaLayout);
        focusXoaLayout.setHorizontalGroup(
            focusXoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );
        focusXoaLayout.setVerticalGroup(
            focusXoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLabel18.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(51, 51, 51));
        jLabel18.setText("Xóa");

        javax.swing.GroupLayout buttPanXoaLayout = new javax.swing.GroupLayout(buttPanXoa);
        buttPanXoa.setLayout(buttPanXoaLayout);
        buttPanXoaLayout.setHorizontalGroup(
            buttPanXoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buttPanXoaLayout.createSequentialGroup()
                .addComponent(focusXoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(jLabel18)
                .addGap(0, 50, Short.MAX_VALUE))
        );
        buttPanXoaLayout.setVerticalGroup(
            buttPanXoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, buttPanXoaLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(buttPanXoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
                    .addComponent(focusXoa, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        buttPanThemFile.setBackground(new java.awt.Color(216, 168, 166));
        buttPanThemFile.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buttPanThemFile.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttPanThemFileMouseClicked(evt);
            }
        });

        focusThemFile.setOpaque(false);
        focusThemFile.setPreferredSize(new java.awt.Dimension(5, 51));

        javax.swing.GroupLayout focusThemFileLayout = new javax.swing.GroupLayout(focusThemFile);
        focusThemFile.setLayout(focusThemFileLayout);
        focusThemFileLayout.setHorizontalGroup(
            focusThemFileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );
        focusThemFileLayout.setVerticalGroup(
            focusThemFileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLabel19.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(51, 51, 51));
        jLabel19.setText("Thống kê");

        javax.swing.GroupLayout buttPanThemFileLayout = new javax.swing.GroupLayout(buttPanThemFile);
        buttPanThemFile.setLayout(buttPanThemFileLayout);
        buttPanThemFileLayout.setHorizontalGroup(
            buttPanThemFileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buttPanThemFileLayout.createSequentialGroup()
                .addComponent(focusThemFile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(jLabel19)
                .addGap(0, 16, Short.MAX_VALUE))
        );
        buttPanThemFileLayout.setVerticalGroup(
            buttPanThemFileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, buttPanThemFileLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(buttPanThemFileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel19, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
                    .addComponent(focusThemFile, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(buttPanXoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(buttPanSua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(buttPanThem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(buttPanThemFile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(150, 150, 150)
                        .addComponent(buttPanXoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(buttPanSua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(buttPanThem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(buttPanThemFile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jPanel1.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 120, 230));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 410, 690, 10));

        jPanel7.setBackground(new java.awt.Color(220, 214, 216));
        jPanel7.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 3, true));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(51, 51, 51));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("QUẢN LÍ MƯỢN TRẢ");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addGap(470, 470, 470)
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(428, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel14)
        );

        jPanel1.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 1160, 30));

        tableMT.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tableMT.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tableMT.setGridColor(new java.awt.Color(255, 255, 255));
        tableMT.setRowHeight(20);
        tableMT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMTMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableMT);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 60, 690, 190));

        ctmLable.setText("Chi tiết mượn của phiếu ...");
        jPanel1.add(ctmLable, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 440, -1, -1));

        tableCTM.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tableCTM.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tableCTM.setGridColor(new java.awt.Color(255, 255, 255));
        tableCTM.setRowHeight(20);
        tableCTM.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableCTMMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tableCTM);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 480, 650, 130));

        TieuChi.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả tiêu chí", "Mã mượn trả", "Mã độc giả", "Mã nhân viên", "Ngày mượn", "Hạn trả", "Mã sách", "Ngày trả" }));
        TieuChi.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        TieuChi.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                TieuChiItemStateChanged(evt);
            }
        });
        jPanel1.add(TieuChi, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 280, 140, -1));

        txtContent.setBorder(null);
        jPanel1.add(txtContent, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 320, 140, -1));

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/icons8_Google_Web_Search_64px.png"))); // NOI18N
        jLabel15.setToolTipText("tìm kiếm");
        jLabel15.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel15MousePressed(evt);
            }
        });
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 270, -1, -1));
        jPanel1.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 340, 140, -1));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/icons8_Refresh_50px_1.png"))); // NOI18N
        jLabel12.setToolTipText("reset bảng");
        jLabel12.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel12MousePressed(evt);
            }
        });
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 270, -1, 60));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Print_50px_2.png"))); // NOI18N
        jLabel9.setToolTipText("in phiếu mượn");
        jLabel9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel9MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(1100, 270, -1, 60));

        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Save_50px_2.png"))); // NOI18N
        jLabel21.setToolTipText("lưu/ in biểu mẫu");
        jLabel21.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel21.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel21MousePressed(evt);
            }
        });
        jPanel1.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 270, -1, 60));

        buttXuatFile1.setBackground(new java.awt.Color(247, 247, 247));
        buttXuatFile1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Fast_Forward_30px_2.png"))); // NOI18N
        buttXuatFile1.setToolTipText("Xuất biểu mẫu");
        buttXuatFile1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buttXuatFile1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttXuatFile1ActionPerformed(evt);
            }
        });
        jPanel1.add(buttXuatFile1, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 360, 40, 30));
        jPanel1.add(TenBC, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 360, 270, 30));

        TenBMLab.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        TenBMLab.setText("Tên biểu mẫu :");
        jPanel1.add(TenBMLab, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 360, -1, 30));

        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Calendar_10_50px.png"))); // NOI18N
        jLabel22.setToolTipText("hết hạn trong 10 ngày tới!");
        jLabel22.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel22.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel22MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 280, -1, -1));

        jPanel3.setBackground(new java.awt.Color(254, 74, 87));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 120, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 170, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 120, 170));

        jPanel4.setBackground(new java.awt.Color(254, 74, 87));

        jLabel13.setBackground(new java.awt.Color(255, 255, 102));
        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 28)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("<<");
        jLabel13.setToolTipText("quay lại menu");
        jLabel13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel13MousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(jLabel13)
                .addContainerGap(33, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(223, Short.MAX_VALUE)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 430, 120, 270));

        jLabel24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Filled_Circle_25px_3.png"))); // NOI18N
        jPanel1.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 670, -1, -1));

        jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Filled_Circle_25px_3.png"))); // NOI18N
        jPanel1.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(1120, 670, -1, -1));

        jLabel26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Filled_Circle_25px_3.png"))); // NOI18N
        jPanel1.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 670, -1, -1));

        jLabel27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Filled_Circle_25px_3.png"))); // NOI18N
        jPanel1.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 670, -1, -1));

        jLabel28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Filled_Circle_25px_3.png"))); // NOI18N
        jPanel1.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 670, -1, -1));

        jLabel29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Filled_Circle_25px_3.png"))); // NOI18N
        jPanel1.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 670, -1, -1));

        jSeparator5.setBackground(new java.awt.Color(220, 214, 196));
        jSeparator5.setForeground(new java.awt.Color(220, 214, 196));
        jPanel1.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 48, 710, -1));

        jPanel5.setBackground(new java.awt.Color(230, 230, 230));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 670, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 30, 10, 670));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tableMTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMTMouseClicked
        // TODO add your handling code here:
        int row = tableMT.getSelectedRow();
        String MaMT = (tableMT.getModel().getValueAt(row, 0)).toString();
        MuonTraDTO newDTO = null;
        try {
            newDTO = MuonTraDAO.LoadRowContent(MaMT);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(QuanLiSach.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (newDTO == null) {
        } else {
            txtMaMT.setText(newDTO.getMaMT());
            txtMaDG.setText(newDTO.getMaDG());
            txtMaNV.setText(newDTO.getMaNV());
            txtNgayMuon.setText(newDTO.getNgayMuon().toString());
            txtHanTra.setText(newDTO.getHanTra().toString());
            txtTC.setText((tableMT.getModel().getValueAt(row, 7)).toString() + " VNĐ");
            txtTienPhat.setText((tableMT.getModel().getValueAt(row, 8)).toString() + " VNĐ");
            
            txtTenDG.setText(DocGiaDAO.getTenDG(newDTO.getMaDG()));
            txtTenNV.setText(NhanVienDAO.getTenNV(newDTO.getMaNV()));

            LoaaMaSachToCombobox();
        }

        ctmLable.setText("Chi tiết mượn của phiếu " + MaMT);
        try {
            ChiTietMuonDAO.LoadDuLieu(tableCTM, MaMT);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(QuanLiMuonTra.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(QuanLiMuonTra.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_tableMTMouseClicked

    private void tableCTMMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableCTMMouseClicked
        // TODO add your handling code here:

        String MaMT = txtMaMT.getText();
        int row = tableCTM.getSelectedRow();
        String MaS = (tableCTM.getModel().getValueAt(row, 0)).toString();
        ChiTietMuonDTO newDTO = null;
        try {
            newDTO = ChiTietMuonDAO.LoadRowContent(MaMT, MaS);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(QuanLiSach.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (newDTO == null) {
        } else {
            txtMaS.setText(newDTO.getMaS());
            txtTienCoc.setText(Integer.toString(newDTO.getTienCoc()));
            
            if (newDTO.getNgayTra() != null) //if (!newDTO.getNgayTra().equals(null))
                txtNgayTra.setText(newDTO.getNgayTra().toString());
            else
                txtNgayTra.setText("");
            
            if (newDTO.getGhiChu() != null)
                txtGhiChu.setText(newDTO.getGhiChu());
            else
                txtGhiChu.setText("");
            
            txtTenSach.setText(SachDAO.getTenSach(MaS));
        }
    }//GEN-LAST:event_tableCTMMouseClicked

    private void themMTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_themMTActionPerformed
        // TODO add your handling code here:
        String strMaMT = txtMaMT.getText();
        if (isNull(txtMaMT, strMaMT, "Mã mượn trả")) {
            return;
        }

        String strMaDG = txtMaDG.getText();
        if (isNull(txtMaDG, strMaDG, "Mã độc giả")) {
            return;
        }
        
        String strMaNV = txtMaNV.getText();
        if (isNull(txtMaNV, strMaNV, "Mã nhân viên")) {
            return;
        }
        
        Date ngayMuon = Date.valueOf(txtNgayMuon.getText());
        
        String strHanTra = txtHanTra.getText().trim();
        if (isNull(txtHanTra, strHanTra, "Hạn trả")) {
            return;
        }
        Date hanTra;
        try {
            hanTra = Date.valueOf(strHanTra);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Giá trị '" + strHanTra + "' không hợp lệ!");
            txtHanTra.requestFocus();
            return;
        }
        if (!hanTra.after(ngayMuon)){
            JOptionPane.showMessageDialog(null, "Hạn trả phải sau ngày " + ngayMuon.toString());
            txtHanTra.requestFocus();
            return;
        }
        
        
        if (MuonTraDAO.isIDExistence(strMaMT.trim())) {
                JOptionPane.showMessageDialog(null, "Mã mượn trả " + strMaMT.trim() + " đã có trong hệ thống");
                txtMaDG.requestFocus();
                return;
        }
        
        if (!DocGiaDAO.isIDExistence(strMaDG.trim())) {
                JOptionPane.showMessageDialog(null, "Mã độc giả " + strMaDG.trim() + " chưa có trong hệ thống");
                txtMaDG.requestFocus();
                return;
        }
        
        if (!NhanVienDAO.isIDExistence(strMaNV.trim())) {
                JOptionPane.showMessageDialog(null, "Mã nhân viên " + strMaNV.trim() + " chưa có trong hệ thống");
                txtMaNV.requestFocus();
                return;
        }
        

        MuonTraDTO newDTO = new MuonTraDTO(strMaMT, strMaDG, strMaNV, ngayMuon, hanTra);

        try {
            MuonTraDAO.Them(newDTO);
            JOptionPane.showMessageDialog(null, "Thêm thành công!");
            Load_RefreshTable();
            txtMaS.requestFocus();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(QuanLiMuonTra.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_themMTActionPerformed

    private void suaMTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_suaMTActionPerformed
        // TODO add your handling code here:
        String strMaMT = txtMaMT.getText();
        if (isNull(txtMaMT, strMaMT, "Mã mượn trả")) {
            return;
        }

        String strMaDG = txtMaDG.getText();
        if (isNull(txtMaDG, strMaDG, "Mã độc giả")) {
            return;
        }
        
        String strMaNV = txtMaNV.getText();
        if (isNull(txtMaNV, strMaNV, "Mã nhân viên")) {
            return;
        }
        
        String strNgayMuon = txtNgayMuon.getText();
        if (isNull(txtNgayMuon, strNgayMuon, "Ngày mượn")) {
            return;
        }
        Date ngayMuon;
        try {
            ngayMuon = Date.valueOf(strNgayMuon);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Giá trị '" + strNgayMuon + "' không hợp lệ!");
            txtNgayMuon.requestFocus();
            return;
        }
        
        String strHanTra = txtHanTra.getText();
        if (isNull(txtHanTra, strHanTra, "Hạn trả")) {
            return;
        }
        Date hanTra;
        try {
            hanTra = Date.valueOf(strHanTra);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Giá trị '" + strHanTra + "' không hợp lệ!");
            txtHanTra.requestFocus();
            return;
        }
        if (!hanTra.after(ngayMuon)){
            JOptionPane.showMessageDialog(null, "Hạn trả phải sau ngày " + ngayMuon.toString());
            txtHanTra.requestFocus();
            return;
        }
        
        
        if (!MuonTraDAO.isIDExistence(strMaMT.trim())) {
                JOptionPane.showMessageDialog(null, "Mã mượn trả " + strMaMT.trim() + " chưa có trong hệ thống");
                txtMaMT.requestFocus();
                return;
        }
        
        if (!DocGiaDAO.isIDExistence(strMaDG.trim())) {
                JOptionPane.showMessageDialog(null, "Mã độc giả " + strMaDG.trim() + " chưa có trong hệ thống");
                txtMaDG.requestFocus();
                return;
        }
        
        if (!NhanVienDAO.isIDExistence(strMaNV.trim())) {
                JOptionPane.showMessageDialog(null, "Mã nhân viên " + strMaNV.trim() + " chưa có trong hệ thống");
                txtMaNV.requestFocus();
                return;
        }
        

        MuonTraDTO newDTO = new MuonTraDTO(strMaMT, strMaDG, strMaNV, ngayMuon, hanTra);

        try {
            MuonTraDAO.ModifyRecord(newDTO);
            JOptionPane.showMessageDialog(null, "Sửa thành công!");
            
            try {
                MuonTraDAO.updateTienPhat();
                Load_RefreshTable();
            } catch (ClassNotFoundException | SQLException | ParseException ex) {
                Logger.getLogger(QuanLiMuonTra.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            Load_RefreshTable();
        } catch (SQLException ex) {
            Logger.getLogger(QuanLiMuonTra.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_suaMTActionPerformed

    private void xoaMTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_xoaMTActionPerformed
        // TODO add your handling code here:
        int choice = JOptionPane.showConfirmDialog(null, "Bạn có muốn xóa sách có mã " + txtMaMT.getText() + "?", "Confirm", JOptionPane.YES_NO_OPTION);
        if (choice == JOptionPane.YES_OPTION) {
            
            String strMaMT = txtMaMT.getText().trim();
            if (isNull(txtMaMT, strMaMT, "Mã mượn trả")) {
                return;
            }
            if (!MuonTraDAO.isIDExistence(strMaMT.trim())) {
                JOptionPane.showMessageDialog(null, "Mã mượn trả " + strMaMT.trim() + " chưa có trong hệ thống");
                txtMaDG.requestFocus();
                return;
            }
            
            MuonTraDAO.DeleteReCord(txtMaMT.getText());
            
            JOptionPane.showMessageDialog(null, "Xoá thành công!");
            Load_RefreshTable();
        }
    }//GEN-LAST:event_xoaMTActionPerformed

    private void themCTMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_themCTMActionPerformed
        // TODO add your handling code here:
        String strMaMT = txtMaMT.getText().trim();
        
        String strMaS = txtMaS.getText().trim();
        if (isNull(txtMaS, strMaS, "Mã sách")) {
            return;
        }
        
        String strTienCoc = txtTienCoc.getText();
        if (isNull(txtTienCoc, strTienCoc, "Số lượng")) {
            return;
        }
        int SL;
        try {
            SL = Short.parseShort(strTienCoc);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Giá trị '" + strTienCoc + "' không hợp lệ!");
            txtTienCoc.requestFocus();
            return;
        }
        short SLScu = 0;
        try {
            SLScu = SachDAO.getSL(strMaS);
            if (SLScu < SL){
                JOptionPane.showMessageDialog(null, "Số sách trong thư viện (" + Short.toString(SLScu) +") không đủ để mượn!");
                txtTienCoc.requestFocus();
                return;
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(QuanLiMuonTra.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        /////////////////////////////////////
        if (!SachDAO.isIDExistence(strMaS)){
            JOptionPane.showMessageDialog(null, "Mã sách '" + strMaS + "' không tồn tại!");
            txtMaS.requestFocus();
            return;
        }///////////////////////////////////
        
        String strNgayTra = txtNgayTra.getText();
        Date ngayTra;
        strNgayTra = strNgayTra.trim();
        if (strNgayTra.equals(""))
            ngayTra = null;
        else{
            try {
                ngayTra = Date.valueOf(strNgayTra);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Giá trị '" + strNgayTra + "' không hợp lệ!");
                txtNgayTra.requestFocus();
                return;
            }
        }
        
        String strGhiChu = txtGhiChu.getText();
        strGhiChu = strGhiChu.trim();
        if (strGhiChu.equals(""))
            strGhiChu = null;

        ChiTietMuonDTO newDTO = new ChiTietMuonDTO(strMaMT, strMaS, SL, ngayTra, strGhiChu);

        try {
            ChiTietMuonDAO.Them(newDTO);
            ChiTietMuonDAO.UpdateTienCoc(strMaMT);
            SachDAO.updateSLSach(strMaS, (short) (SLScu - SL));
            JOptionPane.showMessageDialog(null, "Thêm thành công!");
            
            try {
                MuonTraDAO.updateTienPhat();
                Load_RefreshTable();
            } catch (ClassNotFoundException | SQLException | ParseException ex) {
                Logger.getLogger(QuanLiMuonTra.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            Load_RefreshTable1(strMaMT);
            Load_RefreshTable();
        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(null, "Thêm thất bại!");
            Logger.getLogger(QuanLiMuonTra.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_themCTMActionPerformed

    private void suaCTMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_suaCTMActionPerformed
        // TODO add your handling code here:
        String strMaMT = txtMaMT.getText().trim();
        
        String strMaS = txtMaS.getText().trim();
        if (isNull(txtMaS, strMaS, "Mã sách")) {
            return;
        }
        
        String strTienCoc = txtTienCoc.getText();
        if (isNull(txtTienCoc, strTienCoc, "Số lượng")) {
            return;
        }
        int intTienCoc;
        try {
            intTienCoc = Integer.parseInt(strTienCoc);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Giá trị '" + strTienCoc + "' không hợp lệ!");
            txtTienCoc.requestFocus();
            return;
        }
        int SLcu = 0;
        int tongSach = 0;
        try {
            SLcu = ChiTietMuonDAO.getSL(strMaMT, strMaS);
            tongSach = SachDAO.getSL(strMaS);
            if (intTienCoc - SLcu >  tongSach) {
                JOptionPane.showMessageDialog(null, "Số sách trong thư viện (" + Short.toString(SachDAO.getSL(strMaS)) +") không đủ để mượn thêm!");
                txtTienCoc.requestFocus();
                return;
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(QuanLiMuonTra.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String strNgayTra = txtNgayTra.getText();
        Date ngayTra;
        strNgayTra = strNgayTra.trim();
        if (strNgayTra.equals(""))
            ngayTra = null;
        else{
            try {
                ngayTra = Date.valueOf(strNgayTra);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Giá trị '" + strNgayTra + "' không hợp lệ!");
                txtNgayTra.requestFocus();
                return;
            }
        }
        
        String strGhiChu = txtGhiChu.getText();
        strGhiChu = strGhiChu.trim();
        if (strGhiChu.equals(""))
            strGhiChu = null;
        
                    Date NgayTraCu = null;
                    try {
                        NgayTraCu = ChiTietMuonDAO.getNgayTra(strMaMT, strMaS);
                    } catch (ClassNotFoundException | SQLException ex) {
                        Logger.getLogger(QuanLiMuonTra.class.getName()).log(Level.SEVERE, null, ex);
                    }

        ChiTietMuonDTO newDTO = new ChiTietMuonDTO(strMaMT, strMaS, intTienCoc, ngayTra, strGhiChu);
        
//        try {
//            ChiTietMuonDAO.ModifyRecord(newDTO);
//            ChiTietMuonDAO.UpdateTienCoc(strMaMT);
//            
//            if (NgayTraCu == null) {
//                        if (ngayTra != null)
//                            SachDAO.updateSLSach(strMaS, (short) (tongSach + intTienCoc));
//                        else
//                            SachDAO.updateSLSach(strMaS, (short) (tongSach - intTienCoc + SLcu));
//                        }
//            JOptionPane.showMessageDialog(null, "Sửa thành công!");
//            
//            try {
//                MuonTraDAO.updateTienPhat();
//                Load_RefreshTable();
//            } catch (ClassNotFoundException | SQLException | ParseException ex) {
//                Logger.getLogger(QuanLiMuonTra.class.getName()).log(Level.SEVERE, null, ex);
//            }
//            
//            Load_RefreshTable1(strMaMT);
//            Load_RefreshTable();
//        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null, "Sửa thất bại!");
//            Logger.getLogger(QuanLiMuonTra.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(QuanLiMuonTra.class.getName()).log(Level.SEVERE, null, ex);
//        }

        if (NgayTraCu == null) {

            try {
                ChiTietMuonDAO.ModifyRecord(newDTO);
                ChiTietMuonDAO.UpdateTienCoc(strMaMT);

                
                    if (ngayTra != null) {
                        SachDAO.updateSLSach(strMaS, (short) (tongSach + intTienCoc));
                    } else {
                        SachDAO.updateSLSach(strMaS, (short) (tongSach - intTienCoc + SLcu));
                    }
                    
                JOptionPane.showMessageDialog(null, "Sửa thành công!");

                try {
                    MuonTraDAO.updateTienPhat();
                    Load_RefreshTable();
                } catch (ClassNotFoundException | SQLException | ParseException ex) {
                    Logger.getLogger(QuanLiMuonTra.class.getName()).log(Level.SEVERE, null, ex);
                }

                Load_RefreshTable1(strMaMT);
                Load_RefreshTable();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Sửa thất bại!");
                Logger.getLogger(QuanLiMuonTra.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(QuanLiMuonTra.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            
            JOptionPane.showMessageDialog(null, "Không sửa được sách dã trả!");
        }
            
    }//GEN-LAST:event_suaCTMActionPerformed

    private void xoaCTMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_xoaCTMActionPerformed
        // TODO add your handling code here:
        int choice = JOptionPane.showConfirmDialog(null, "Bạn có muốn xóa sách có mã '" + txtMaS.getText().trim() + "' trong phiên mượn?", "Confirm", JOptionPane.YES_NO_OPTION);
        if (choice == JOptionPane.YES_OPTION) {
            
            try {
                short tongSach = SachDAO.getSL(txtMaS.getText().trim());
                short sachTra = ChiTietMuonDAO.getSL(txtMaMT.getText().trim(), txtMaS.getText().trim());
                SachDAO.updateSLSach(txtMaS.getText().trim(), (short) (tongSach + sachTra));
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(QuanLiMuonTra.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            ChiTietMuonDAO.DeleteReCord(txtMaMT.getText(), txtMaS.getText());
            ChiTietMuonDAO.UpdateTienCoc(txtMaMT.getText().trim());
            
            JOptionPane.showMessageDialog(null, "Xoá thành công!");
            
            try {
                MuonTraDAO.updateTienPhat();
                Load_RefreshTable();
            } catch (ClassNotFoundException | SQLException | ParseException ex) {
                Logger.getLogger(QuanLiMuonTra.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            Load_RefreshTable1(txtMaMT.getText());
            Load_RefreshTable();
        }
    }//GEN-LAST:event_xoaCTMActionPerformed

    private void TieuChiItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_TieuChiItemStateChanged
        // TODO add your handling code here:
        if (evt.getStateChange() == ItemEvent.SELECTED) {

            if (TieuChi.getSelectedItem().equals("Mã mượn trả")) {
                TieuChiTK = "MA_MUON_TRA";

            } else if (TieuChi.getSelectedItem().equals("Mã độc giả")) {
                TieuChiTK = "MA_DOC_GIA";

            } else if (TieuChi.getSelectedItem().equals("Mã nhân viên")) {
                TieuChiTK = "MA_NHAN_VIEN";

            } else if (TieuChi.getSelectedItem().equals("Ngày mượn")) {
                TieuChiTK = "NGAY_MUON";

            } else if (TieuChi.getSelectedItem().equals("Hạn trả")) {
                TieuChiTK = "HAN_TRA";

            } else if (TieuChi.getSelectedItem().equals("Mã sách")) {
                TieuChiTK = "MA_SACH";
                
            } else if (TieuChi.getSelectedItem().equals("Ngày trả")) {
                TieuChiTK = "NGAY_TRA";
                
            } else {
                TieuChiTK = "ALL";

            }
        }
    }//GEN-LAST:event_TieuChiItemStateChanged

    private void jLabel15MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel15MousePressed
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            if(TieuChiTK.equals("ALL"))
                MuonTraDAO.Search_Load_Table(txtContent.getText(), tableMT);
            
            else if (TieuChiTK.equals("MA_SACH"))
                 ChiTietMuonDAO.Search_Load_Table(TieuChiTK, txtContent.getText(), tableMT);
            
            else if (TieuChiTK.equals("NGAY_TRA"))
                ChiTietMuonDAO.Search_Load_Table(TieuChiTK, txtContent.getText(), tableMT);
            
            else MuonTraDAO.Search_Load_Table(TieuChiTK, txtContent.getText(), tableMT);
            
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(MuonTraDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jLabel15MousePressed

    private void jLabel12MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MousePressed
        // TODO add your handling code here:
        Load_RefreshTable();
    }//GEN-LAST:event_jLabel12MousePressed

    private void SetModelToBooksListCombo(){
        
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        ArrayList<String> list = new ArrayList<>();
        
        try {
            list = SachDAO.takeMaS();
            for(String i : list) model.addElement(i);
            jComboBoxMaS.setModel(model);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(QuanLiMuonTra.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(QuanLiMuonTra.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked
        // TODO add your handling code here:

        String strMaMT = txtMaMT.getText().trim();
        if (isNull(txtMaMT, strMaMT, "Mã mượn trả")) {
            return;
        }

        String strMaDG = txtMaDG.getText().trim();
        if (isNull(txtMaDG, strMaDG, "Mã độc giả")) {
            return;
        }
        
        String strMaNV = txtMaNV.getText().trim();
        if (isNull(txtMaNV, strMaNV, "Mã nhân viên")) {
            return;
        }
        
        String strNgayMuon = txtNgayMuon.getText();
        if (isNull(txtNgayMuon, strNgayMuon, "Ngày mượn")) {
            return;
        }
        Date ngayMuon;
        try {
            ngayMuon = Date.valueOf(strNgayMuon);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Giá trị '" + strNgayMuon + "' không hợp lệ!");
            txtNgayMuon.requestFocus();
            return;
        }
        
        String strHanTra = txtHanTra.getText();
        if (isNull(txtHanTra, strHanTra, "Hạn trả")) {
            return;
        }
        Date hanTra;
        try {
            hanTra = Date.valueOf(strHanTra);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Giá trị '" + strHanTra + "' không hợp lệ!");
            txtHanTra.requestFocus();
            return;
        }
        if (!hanTra.after(ngayMuon)){
            JOptionPane.showMessageDialog(null, "Hạn trả phải sau ngày " + ngayMuon.toString());
            txtHanTra.requestFocus();
            return;
        }
        
        
        if (!MuonTraDAO.isIDExistence(strMaMT.trim())) {
                JOptionPane.showMessageDialog(null, "Mã mượn trả " + strMaMT.trim() + " chưa có trong hệ thống");
                txtMaMT.requestFocus();
                return;
        }
        
        if (!DocGiaDAO.isIDExistence(strMaDG.trim())) {
                JOptionPane.showMessageDialog(null, "Mã độc giả " + strMaDG.trim() + " chưa có trong hệ thống");
                txtMaDG.requestFocus();
                return;
        }
        
        if (!NhanVienDAO.isIDExistence(strMaNV.trim())) {
                JOptionPane.showMessageDialog(null, "Mã nhân viên " + strMaNV.trim() + " chưa có trong hệ thống");
                txtMaNV.requestFocus();
                return;
        }
        

        MuonTraDTO newDTO = new MuonTraDTO(strMaMT, strMaDG, strMaNV, ngayMuon, hanTra);
        
        //MuonTraDTO newDTO = new MuonTraDTO(txtMaMT.getText().trim(), txtMaDG.getText().trim(), txtMaNV.getName().trim(), Date.valueOf(txtNgayMuon.getText()), Date.valueOf(txtHanTra.getText()));
        
        MuonTraDAO.InPhieuMuonTra(tableCTM, newDTO, txtTC.getText(), txtTienPhat.getText());
    }//GEN-LAST:event_jLabel9MouseClicked

    private void txtMaDGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaDGActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaDGActionPerformed

    private void jComboBoxMaMTItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxMaMTItemStateChanged
        // TODO add your handling code here:
        txtMaMT.setText(jComboBoxMaMT.getSelectedItem().toString());
    }//GEN-LAST:event_jComboBoxMaMTItemStateChanged

    private void jComboBoxDGItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxDGItemStateChanged
        // TODO add your handling code here:
        txtMaDG.setText(jComboBoxDG.getSelectedItem().toString());
        txtTenDG.setText(DocGiaDAO.getTenDG(jComboBoxDG.getSelectedItem().toString()));
    }//GEN-LAST:event_jComboBoxDGItemStateChanged

    private void jComboBoxNVItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxNVItemStateChanged
        // TODO add your handling code here:
        txtMaNV.setText(jComboBoxNV.getSelectedItem().toString());
        txtTenNV.setText(NhanVienDAO.getTenNV(jComboBoxNV.getSelectedItem().toString()));
    }//GEN-LAST:event_jComboBoxNVItemStateChanged

    private void jComboBoxMaSItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxMaSItemStateChanged
        // TODO add your handling code here:
        txtMaS.setText(jComboBoxMaS.getSelectedItem().toString());
        txtTenSach.setText(SachDAO.getTenSach(jComboBoxMaS.getSelectedItem().toString()));
    }//GEN-LAST:event_jComboBoxMaSItemStateChanged

    private void resetMaSComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetMaSComboActionPerformed
        // TODO add your handling code here:
        SetModelToBooksListCombo();
    }//GEN-LAST:event_resetMaSComboActionPerformed

    private void resetMaSCombo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetMaSCombo1ActionPerformed
        // TODO add your handling code here:
        txtNgayMuon.setText(new Date(System.currentTimeMillis()).toString());
    }//GEN-LAST:event_resetMaSCombo1ActionPerformed

    private void jLabel21MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel21MousePressed
        // TODO add your handling code here:
        if (hienThiNhapTenBC){
            TenBC.setVisible(false);
            buttXuatFile1.setVisible(false);
            hienThiNhapTenBC = false;
            TenBMLab.setVisible(false);
        } else{
            TenBC.setVisible(true);
            buttXuatFile1.setVisible(true);
            hienThiNhapTenBC = true;
            TenBMLab.setVisible(true);
            TenBC.requestFocus();
        }
    }//GEN-LAST:event_jLabel21MousePressed

    private void buttXuatFile1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttXuatFile1ActionPerformed
        // TODO add your handling code here:
        TenBaoCao = TenBC.getText();
        TenBC.setVisible(false);
        buttXuatFile1.setVisible(false);
        hienThiNhapTenBC = false;
        MuonTraDAO.XuatBieuMauTimKiem(tableMT, TenBaoCao);
    }//GEN-LAST:event_buttXuatFile1ActionPerformed

    private void jLabel22MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel22MouseClicked
        
        try {
            // TODO add your handling code here:
            MuonTraDAO.Search_Load_Table(new Date(System.currentTimeMillis()), new Date(System.currentTimeMillis() + 864000000), tableMT);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(QuanLiMuonTra.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jLabel22MouseClicked

    private void txtTenNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTenNVActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTenNVActionPerformed

    private void txtTenDGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTenDGActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTenDGActionPerformed

    private void jLabel13MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MousePressed
        // TODO add your handling code here:
        Menu CNFrame = new Menu();
        CNFrame.setLocationRelativeTo(null);
        dispose();
    }//GEN-LAST:event_jLabel13MousePressed

    private void buttPanThemFileMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttPanThemFileMouseClicked
        // TODO add your handling code here:
        setClickedPanelColor(buttPanThemFile);
        focusThemFile.setOpaque(true);
        resetUnClickedPanColor(new JPanel[]{buttPanSua, buttPanThem, buttPanXoa}, new JPanel[]{focusSua, focusThem, focusXoa});

        Disable_Buttons_Lables();
        
        GUIThongKeMT.main(null);
    }//GEN-LAST:event_buttPanThemFileMouseClicked

    private void buttPanXoaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttPanXoaMouseClicked
        // TODO add your handling code here:
        setClickedPanelColor(buttPanXoa);
        focusXoa.setOpaque(true);
        resetUnClickedPanColor(new JPanel[]{buttPanSua, buttPanThem, buttPanThemFile}, new JPanel[]{focusSua, focusThem, focusThemFile});

        themMT.setEnabled(false);
        themCTM.setEnabled(false);
        suaMT.setEnabled(false);
        suaCTM.setEnabled(false);
        xoaMT.setEnabled(true);
        xoaCTM.setEnabled(true);
        resetMaSCombo.setEnabled(false);

        txtMaMT.setEnabled(true);
        txtMaDG.setEnabled(false);
        txtMaNV.setEnabled(false);
        txtNgayMuon.setEnabled(false);
        txtHanTra.setEnabled(false);
        txtMaS.setEnabled(false);
        txtTienCoc.setEnabled(false);
        txtNgayTra.setEnabled(false);
        txtGhiChu.setEnabled(false);
        jComboBoxMaMT.setEnabled(true);
        jComboBoxDG.setEnabled(false);
        jComboBoxNV.setEnabled(false);
        jComboBoxMaS.setEnabled(true);
    }//GEN-LAST:event_buttPanXoaMouseClicked

    private void buttPanSuaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttPanSuaMouseClicked
        // TODO add your handling code here:
        setClickedPanelColor(buttPanSua);
        focusSua.setOpaque(true);
        resetUnClickedPanColor(new JPanel[]{buttPanThem, buttPanXoa, buttPanThemFile}, new JPanel[]{focusThem, focusXoa, focusThemFile});

        themMT.setEnabled(false);
        themCTM.setEnabled(false);
        suaMT.setEnabled(true);
        suaCTM.setEnabled(true);
        xoaMT.setEnabled(false);
        xoaCTM.setEnabled(false);
        resetMaSCombo.setEnabled(false);

        txtMaMT.setEnabled(false);
        txtMaDG.setEnabled(true);
        txtMaNV.setEnabled(true);
        txtNgayMuon.setEnabled(true);
        txtHanTra.setEnabled(true);
        txtMaS.setEnabled(false);
        txtTienCoc.setEnabled(true);
        txtNgayTra.setEnabled(true);
        txtGhiChu.setEnabled(true);

        jComboBoxMaMT.setEnabled(true);
        jComboBoxDG.setEnabled(true);
        jComboBoxNV.setEnabled(true);
        jComboBoxMaS.setEnabled(true);
    }//GEN-LAST:event_buttPanSuaMouseClicked

    private void buttPanThemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttPanThemMouseClicked
        // TODO add your handling code here:
        setClickedPanelColor(buttPanThem);
        focusThem.setOpaque(true);
        resetUnClickedPanColor(new JPanel[]{buttPanSua, buttPanXoa, buttPanThemFile}, new JPanel[]{focusSua, focusXoa, focusThemFile});

        SetModelToBooksListCombo();

        themMT.setEnabled(true);
        themCTM.setEnabled(true);
        suaMT.setEnabled(false);
        suaCTM.setEnabled(false);
        xoaMT.setEnabled(false);
        xoaCTM.setEnabled(false);
        resetMaSCombo.setEnabled(true);

        txtMaMT.setEnabled(true);
        txtMaDG.setEnabled(true);
        txtMaNV.setEnabled(true);

        txtNgayMuon.setEnabled(false);
        txtNgayMuon.setText(new Date(System.currentTimeMillis()).toString());

        txtHanTra.setEnabled(true);
        txtMaS.setEnabled(true);
        txtTienCoc.setEnabled(true);
        txtNgayTra.setEnabled(true);
        txtGhiChu.setEnabled(true);

        jComboBoxMaMT.setEnabled(false);
        jComboBoxDG.setEnabled(true);
        jComboBoxNV.setEnabled(true);
        jComboBoxMaS.setEnabled(true);
    }//GEN-LAST:event_buttPanThemMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        txtHanTra.setText(gethanTra(5));
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        txtMaMT.setText("");
        txtMaDG.setText("");
        txtMaNV.setText("");
        txtNgayMuon.setText("");
        txtHanTra.setText("");
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        txtMaS.setText("");
        txtTienCoc.setText("");
        txtNgayTra.setText("");
        txtGhiChu.setText("");
    }//GEN-LAST:event_jButton2ActionPerformed

    private String gethanTra(int thang){
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        Calendar c = Calendar.getInstance();
        c.setTime(Date.valueOf(txtNgayMuon.getText().trim()));
        c.roll(Calendar.MONTH, thang);
        return dateFormat.format(c.getTime());
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
                if ("Windows".equals(info.getName())) { //Nimbus
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(QuanLiMuonTra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QuanLiMuonTra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QuanLiMuonTra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QuanLiMuonTra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QuanLiMuonTra().setLocationRelativeTo(null);;
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField TenBC;
    private javax.swing.JLabel TenBMLab;
    private javax.swing.JComboBox<String> TieuChi;
    private javax.swing.JPanel buttPanSua;
    private javax.swing.JPanel buttPanThem;
    private javax.swing.JPanel buttPanThemFile;
    private javax.swing.JPanel buttPanXoa;
    private javax.swing.JButton buttXuatFile1;
    private javax.swing.JLabel ctmLable;
    private javax.swing.JPanel focusSua;
    private javax.swing.JPanel focusThem;
    private javax.swing.JPanel focusThemFile;
    private javax.swing.JPanel focusXoa;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox<String> jComboBoxDG;
    private javax.swing.JComboBox<String> jComboBoxMaMT;
    private javax.swing.JComboBox<String> jComboBoxMaS;
    private javax.swing.JComboBox<String> jComboBoxNV;
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
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JButton resetMaSCombo;
    private javax.swing.JButton resetMaSCombo1;
    private javax.swing.JButton suaCTM;
    private javax.swing.JButton suaMT;
    private javax.swing.JTable tableCTM;
    private javax.swing.JTable tableMT;
    private javax.swing.JButton themCTM;
    private javax.swing.JButton themMT;
    private javax.swing.JTextField txtContent;
    private javax.swing.JTextField txtGhiChu;
    private javax.swing.JTextField txtHanTra;
    private javax.swing.JTextField txtMaDG;
    private javax.swing.JTextField txtMaMT;
    private javax.swing.JTextField txtMaNV;
    private javax.swing.JTextField txtMaS;
    private javax.swing.JTextField txtNgayMuon;
    private javax.swing.JTextField txtNgayTra;
    private javax.swing.JTextField txtTC;
    private javax.swing.JTextField txtTenDG;
    private javax.swing.JTextField txtTenNV;
    private javax.swing.JTextField txtTenSach;
    private javax.swing.JTextField txtTienCoc;
    private javax.swing.JTextField txtTienPhat;
    private javax.swing.JButton xoaCTM;
    private javax.swing.JButton xoaMT;
    // End of variables declaration//GEN-END:variables
}
