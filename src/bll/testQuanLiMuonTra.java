/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bll;

import gui.*;
import dal.ChiTietMuonDAO;
import dal.DocGiaDAO;
import dal.MuonTraDAO;
import dal.NhanVienDAO;
import dal.SachDAO;
import dto.ChiTietMuonDTO;
import dto.MuonTraDTO;
import dto.SachDTO;
import java.awt.Color;
import java.awt.event.ItemEvent;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author hiep.tt166077
 */
public class testQuanLiMuonTra extends javax.swing.JFrame {

    /**
     * Creates new form QuanLiMuonTra
     */
    String TieuChiTK = "ALl";

    public testQuanLiMuonTra() {

        setUndecorated(true);
        setVisible(true);
        initComponents();
        setModelToCombobox();
        Disable_Buttons_Lables();
        Load_RefreshTable();
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
        panel.setBackground(new Color(153, 153, 255));//102, 207, 224
    }

    private void resetUnClickedPanColor(JPanel[] pane, JPanel[] indicators) {
        for (int i = 0; i < pane.length; i++) {
            pane[i].setBackground(new Color(71, 120, 197));

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
            Logger.getLogger(testQuanLiMuonTra.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            list = DocGiaDAO.takeMaDG();
            for (String i : list) {
                MaDGModel.addElement(i);
            }
            jComboBoxDG.setModel(MaDGModel);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(testQuanLiMuonTra.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(testQuanLiMuonTra.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            list = NhanVienDAO.takeMaNV();
            for (String i : list) {
                MaNVModel.addElement(i);
            }
            jComboBoxNV.setModel(MaNVModel);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(testQuanLiMuonTra.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(testQuanLiMuonTra.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(testQuanLiMuonTra.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(testQuanLiMuonTra.class.getName()).log(Level.SEVERE, null, ex);
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
        jLabel13 = new javax.swing.JLabel();
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
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(153, 255, 255));

        jLabel1.setText("Mã mượn trả");

        jLabel2.setText("Mã độc giả");

        jLabel3.setText("Mã nhân viên");

        jLabel4.setText("Ngày mượn");

        jLabel5.setText("Hạn trả");

        txtMaDG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaDGActionPerformed(evt);
            }
        });

        themMT.setText("Thêm");
        themMT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                themMTActionPerformed(evt);
            }
        });

        suaMT.setText("Sửa");
        suaMT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                suaMTActionPerformed(evt);
            }
        });

        xoaMT.setText("Xóa");
        xoaMT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                xoaMTActionPerformed(evt);
            }
        });

        jLabel6.setText("Mã sách");

        jLabel7.setText("Số lượng");

        jLabel8.setText("Ghi chú");

        themCTM.setText("Thêm");
        themCTM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                themCTMActionPerformed(evt);
            }
        });

        suaCTM.setText("Sửa");
        suaCTM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                suaCTMActionPerformed(evt);
            }
        });

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

        jLabel10.setText("NgayTra");

        resetMaSCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetMaSComboActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jLabel1)
                .addGap(31, 31, 31)
                .addComponent(jComboBoxMaMT, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(txtMaMT, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jLabel2)
                .addGap(41, 41, 41)
                .addComponent(jComboBoxDG, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(txtMaDG, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jLabel3)
                .addGap(28, 28, 28)
                .addComponent(jComboBoxNV, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(txtMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jLabel4)
                .addGap(37, 37, 37)
                .addComponent(txtNgayMuon, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jLabel5)
                .addGap(56, 56, 56)
                .addComponent(txtHanTra, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(jLabel10)
                .addGap(49, 49, 49)
                .addComponent(txtNgayTra, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(jLabel8)
                .addGap(55, 55, 55)
                .addComponent(txtGhiChu, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(themCTM)
                .addGap(31, 31, 31)
                .addComponent(suaCTM)
                .addGap(44, 44, 44)
                .addComponent(xoaCTM))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel6))
                .addGap(48, 48, 48)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(resetMaSCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComboBoxMaS, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(3, 3, 3)
                        .addComponent(txtMaS, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtTienCoc, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(themMT)
                .addGap(33, 33, 33)
                .addComponent(suaMT)
                .addGap(38, 38, 38)
                .addComponent(xoaMT))
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
                .addGap(16, 16, 16)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel3))
                    .addComponent(jComboBoxNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel4))
                    .addComponent(txtNgayMuon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel5))
                    .addComponent(txtHanTra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(themMT)
                    .addComponent(suaMT)
                    .addComponent(xoaMT))
                .addGap(80, 80, 80)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(68, 68, 68)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jComboBoxMaS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtMaS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(resetMaSCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(15, 15, 15)
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
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(themCTM)
                    .addComponent(suaCTM)
                    .addComponent(xoaCTM)))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 30, 330, 630));

        jPanel6.setBackground(new java.awt.Color(71, 120, 197));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        buttPanThem.setBackground(new java.awt.Color(71, 120, 197));
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
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
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

        jPanel6.add(buttPanThem, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 230, 120, -1));

        buttPanSua.setBackground(new java.awt.Color(71, 120, 197));
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
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Sửa");

        javax.swing.GroupLayout buttPanSuaLayout = new javax.swing.GroupLayout(buttPanSua);
        buttPanSua.setLayout(buttPanSuaLayout);
        buttPanSuaLayout.setHorizontalGroup(
            buttPanSuaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buttPanSuaLayout.createSequentialGroup()
                .addComponent(focusSua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(jLabel17)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        buttPanSuaLayout.setVerticalGroup(
            buttPanSuaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, buttPanSuaLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(buttPanSuaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
                    .addComponent(focusSua, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jPanel6.add(buttPanSua, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 280, 120, -1));

        buttPanXoa.setBackground(new java.awt.Color(71, 120, 197));
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
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Xóa");

        javax.swing.GroupLayout buttPanXoaLayout = new javax.swing.GroupLayout(buttPanXoa);
        buttPanXoa.setLayout(buttPanXoaLayout);
        buttPanXoaLayout.setHorizontalGroup(
            buttPanXoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buttPanXoaLayout.createSequentialGroup()
                .addComponent(focusXoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(jLabel18)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        buttPanXoaLayout.setVerticalGroup(
            buttPanXoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, buttPanXoaLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(buttPanXoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
                    .addComponent(focusXoa, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jPanel6.add(buttPanXoa, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 330, 120, -1));

        buttPanThemFile.setBackground(new java.awt.Color(71, 120, 197));
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
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Thêm file");

        javax.swing.GroupLayout buttPanThemFileLayout = new javax.swing.GroupLayout(buttPanThemFile);
        buttPanThemFile.setLayout(buttPanThemFileLayout);
        buttPanThemFileLayout.setHorizontalGroup(
            buttPanThemFileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buttPanThemFileLayout.createSequentialGroup()
                .addComponent(focusThemFile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(jLabel19)
                .addGap(0, 18, Short.MAX_VALUE))
        );
        buttPanThemFileLayout.setVerticalGroup(
            buttPanThemFileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, buttPanThemFileLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(buttPanThemFileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel19, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
                    .addComponent(focusThemFile, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jPanel6.add(buttPanThemFile, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 180, 120, -1));

        jPanel1.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 120, 630));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 380, 520, 20));

        jPanel7.setBackground(new java.awt.Color(23, 35, 51));

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(102, 255, 255));
        jLabel13.setText("<");
        jLabel13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel13MousePressed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(102, 255, 255));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("QUẢN LÍ MƯỢN TRẢ");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(329, 329, 329)
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(377, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 30));

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

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 60, 514, 190));

        ctmLable.setText("Chi tiết mượn của phiếu ...");
        jPanel1.add(ctmLable, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 410, -1, -1));

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

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 440, 516, 130));

        TieuChi.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả tiêu chí", "Mã mượn trả", "Mã độc giả", "Mã nhân viên", "Ngày mượn", "Hạn trả" }));
        TieuChi.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                TieuChiItemStateChanged(evt);
            }
        });
        jPanel1.add(TieuChi, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 280, 140, -1));

        txtContent.setBorder(null);
        jPanel1.add(txtContent, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 320, 140, -1));

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/icons8_Google_Web_Search_64px.png"))); // NOI18N
        jLabel15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel15MousePressed(evt);
            }
        });
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 270, -1, -1));
        jPanel1.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 340, 140, -1));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/icons8_Refresh_50px_1.png"))); // NOI18N
        jLabel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel12MousePressed(evt);
            }
        });
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 270, -1, 60));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/icons8_Edit_File_50px_1.png"))); // NOI18N
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel9MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 270, -1, 60));

        jButton1.setText("Update tiền phạt");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 590, 150, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

            LoaaMaSachToCombobox();
        }

        ctmLable.setText("Chi tiết mượn của phiếu " + MaMT);
        try {
            ChiTietMuonDAO.LoadDuLieu(tableCTM, MaMT);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(testQuanLiMuonTra.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(testQuanLiMuonTra.class.getName()).log(Level.SEVERE, null, ex);
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
            txtNgayTra.setText(newDTO.getNgayTra().toString());
            txtGhiChu.setText(newDTO.getGhiChu());
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
        
        
        if (DocGiaDAO.isIDExistence(strMaMT.trim())) {
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
            Logger.getLogger(testQuanLiMuonTra.class.getName()).log(Level.SEVERE, null, ex);
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
            Load_RefreshTable();
        } catch (SQLException ex) {
            Logger.getLogger(testQuanLiMuonTra.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_suaMTActionPerformed

    private void xoaMTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_xoaMTActionPerformed
        // TODO add your handling code here:
        int choice = JOptionPane.showConfirmDialog(null, "Bạn có muốn xóa sách có mã " + txtMaMT.getText() + "?", "Confirm", JOptionPane.YES_NO_OPTION);
        if (choice == JOptionPane.YES_OPTION) {
            
            MuonTraDAO.DeleteReCord(txtMaMT.getText());
            String strMaMT = txtMaMT.getText();
            if (isNull(txtMaMT, strMaMT, "Mã mượn trả")) {
                return;
            }
            if (!MuonTraDAO.isIDExistence(strMaMT.trim())) {
                JOptionPane.showMessageDialog(null, "Mã mượn trả " + strMaMT.trim() + " chưa có trong hệ thống");
                txtMaDG.requestFocus();
                return;
            }
            
            JOptionPane.showMessageDialog(null, "Xoá thành công!");
            Load_RefreshTable();
        }
    }//GEN-LAST:event_xoaMTActionPerformed

    private void themCTMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_themCTMActionPerformed
        // TODO add your handling code here:
        String strMaMT = txtMaMT.getText();
        
        String strMaS = txtMaS.getText();
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

        ChiTietMuonDTO newDTO = new ChiTietMuonDTO(strMaMT, strMaS, intTienCoc, ngayTra, strGhiChu);

        try {
            ChiTietMuonDAO.Them(newDTO);
            Load_RefreshTable1(strMaMT);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(testQuanLiMuonTra.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_themCTMActionPerformed

    private void suaCTMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_suaCTMActionPerformed
        // TODO add your handling code here:
        String strMaMT = txtMaMT.getText();
        
        String strMaS = txtMaS.getText();
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

        ChiTietMuonDTO newDTO = new ChiTietMuonDTO(strMaMT, strMaS, intTienCoc, ngayTra, strGhiChu);
        
        try {
            ChiTietMuonDAO.ModifyRecord(newDTO);
            Load_RefreshTable1(strMaMT);
        } catch (SQLException ex) {
            Logger.getLogger(testQuanLiMuonTra.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_suaCTMActionPerformed

    private void xoaCTMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_xoaCTMActionPerformed
        // TODO add your handling code here:
        int choice = JOptionPane.showConfirmDialog(null, "Bạn có muốn xóa " + txtMaS.getText() + "?", "Confirm", JOptionPane.YES_NO_OPTION);
        if (choice == JOptionPane.YES_OPTION) {
            ChiTietMuonDAO.DeleteReCord(txtMaMT.getText(), txtMaS.getText());
            JOptionPane.showMessageDialog(null, "Xoá thành công!");
            Load_RefreshTable1(txtMaMT.getText());
        }
    }//GEN-LAST:event_xoaCTMActionPerformed

    private void jLabel13MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MousePressed
        // TODO add your handling code here:
        Menu CNFrame = new Menu();
        CNFrame.setLocationRelativeTo(null);
        dispose();
    }//GEN-LAST:event_jLabel13MousePressed

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

            } else {
                TieuChiTK = "ALL";

            }
        }
    }//GEN-LAST:event_TieuChiItemStateChanged

    private void jLabel15MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel15MousePressed
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            MuonTraDAO.Search_Load_Table(TieuChiTK, txtContent.getText(), tableMT);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MuonTraDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
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
            Logger.getLogger(testQuanLiMuonTra.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(testQuanLiMuonTra.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
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

    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked
        // TODO add your handling code here:
        JFileChooser input = new JFileChooser();
        input.setDialogTitle("Tìm file nguồn");
        if (input.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {

        }
    }//GEN-LAST:event_jLabel9MouseClicked

    private void txtMaDGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaDGActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaDGActionPerformed

    private void buttPanThemFileMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttPanThemFileMouseClicked
        // TODO add your handling code here:
        setClickedPanelColor(buttPanThemFile);
        focusThemFile.setOpaque(true);
        resetUnClickedPanColor(new JPanel[]{buttPanSua, buttPanThem, buttPanXoa}, new JPanel[]{focusSua, focusThem, focusXoa});

        Disable_Buttons_Lables();
    }//GEN-LAST:event_buttPanThemFileMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            // TODO add your handling code here:
            MuonTraDAO.updateTienPhat();
            Load_RefreshTable();
        } catch (ClassNotFoundException | SQLException | ParseException ex) {
            Logger.getLogger(testQuanLiMuonTra.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jComboBoxMaMTItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxMaMTItemStateChanged
        // TODO add your handling code here:
        txtMaMT.setText(jComboBoxMaMT.getSelectedItem().toString());
    }//GEN-LAST:event_jComboBoxMaMTItemStateChanged

    private void jComboBoxDGItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxDGItemStateChanged
        // TODO add your handling code here:
        txtMaDG.setText(jComboBoxDG.getSelectedItem().toString());
    }//GEN-LAST:event_jComboBoxDGItemStateChanged

    private void jComboBoxNVItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxNVItemStateChanged
        // TODO add your handling code here:
        txtMaNV.setText(jComboBoxNV.getSelectedItem().toString());
    }//GEN-LAST:event_jComboBoxNVItemStateChanged

    private void jComboBoxMaSItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxMaSItemStateChanged
        // TODO add your handling code here:
        txtMaS.setText(jComboBoxMaS.getSelectedItem().toString());
    }//GEN-LAST:event_jComboBoxMaSItemStateChanged

    private void resetMaSComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetMaSComboActionPerformed
        // TODO add your handling code here:
        SetModelToBooksListCombo();
    }//GEN-LAST:event_resetMaSComboActionPerformed

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
            java.util.logging.Logger.getLogger(testQuanLiMuonTra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(testQuanLiMuonTra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(testQuanLiMuonTra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(testQuanLiMuonTra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new testQuanLiMuonTra().setLocationRelativeTo(null);;
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> TieuChi;
    private javax.swing.JPanel buttPanSua;
    private javax.swing.JPanel buttPanThem;
    private javax.swing.JPanel buttPanThemFile;
    private javax.swing.JPanel buttPanXoa;
    private javax.swing.JLabel ctmLable;
    private javax.swing.JPanel focusSua;
    private javax.swing.JPanel focusThem;
    private javax.swing.JPanel focusThemFile;
    private javax.swing.JPanel focusXoa;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBoxDG;
    private javax.swing.JComboBox<String> jComboBoxMaMT;
    private javax.swing.JComboBox<String> jComboBoxMaS;
    private javax.swing.JComboBox<String> jComboBoxNV;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JButton resetMaSCombo;
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
    private javax.swing.JTextField txtTienCoc;
    private javax.swing.JButton xoaCTM;
    private javax.swing.JButton xoaMT;
    // End of variables declaration//GEN-END:variables
}
