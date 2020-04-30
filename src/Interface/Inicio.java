/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author felipe-c4
 */
public class Inicio extends javax.swing.JPanel {

    
    Fauna fauna;
    Flora flora;
    Ecoparques ecoparques;
    public Inicio(JFrame ventana){
        initComponents();
        this.setBounds(0, 0, 1000, 800);
        
        fauna=new Fauna(ventana,this);
        flora=new Flora(ventana,this);
        ecoparques= new Ecoparques(ventana,this);

        
        ventana.add(this);
        this.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        JBRegistrarse = new javax.swing.JButton();
        JBLogin = new javax.swing.JButton();
        LJEnterFlora = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        JLEnterEcoparques = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        JLEnterFauna = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(120, 120, 120));
        setMaximumSize(new java.awt.Dimension(250, 250));

        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 72)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(1, 1, 1));
        jLabel1.setText("-");

        jLabel2.setFont(new java.awt.Font("Ubuntu", 1, 72)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(3, 222, 1));
        jLabel2.setText("ECO");

        jLabel3.setFont(new java.awt.Font("Ubuntu", 1, 72)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(253, 237, 67));
        jLabel3.setText("LOM");

        jLabel4.setFont(new java.awt.Font("Ubuntu", 1, 72)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(67, 155, 253));
        jLabel4.setText("BI");

        jLabel5.setFont(new java.awt.Font("Ubuntu", 1, 72)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 44, 29));
        jLabel5.setText("A");

        jPanel1.setBackground(new java.awt.Color(1, 1, 1));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interface/inicio.png"))); // NOI18N

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interface/next.png"))); // NOI18N

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interface/prev.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(188, 188, 188)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(132, 132, 132)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(131, 131, 131))
        );

        jLabel6.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(254, 254, 254));
        jLabel6.setText("RED COLABORATIVA PARA LA BIODIVERSIDAD Y ECOPARQUES COLOMBIANOS");

        jLabel8.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(254, 254, 254));
        jLabel8.setText("CONSULTAR");

        JBRegistrarse.setBackground(new java.awt.Color(231, 231, 231));
        JBRegistrarse.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        JBRegistrarse.setText("Registrarse");
        JBRegistrarse.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.lightGray, null, null));

        JBLogin.setBackground(new java.awt.Color(231, 231, 231));
        JBLogin.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        JBLogin.setText("Login");
        JBLogin.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.lightGray, null, null));
        JBLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBLoginActionPerformed(evt);
            }
        });

        LJEnterFlora.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interface/flora.png"))); // NOI18N
        LJEnterFlora.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));
        LJEnterFlora.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LJEnterFloraMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                LJEnterFloraMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                LJEnterFloraMouseEntered(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Ubuntu", 3, 30)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(254, 254, 254));
        jLabel10.setText("Flora");

        JLEnterEcoparques.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interface/Ecoparques.png"))); // NOI18N
        JLEnterEcoparques.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));
        JLEnterEcoparques.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JLEnterEcoparquesMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                JLEnterEcoparquesMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                JLEnterEcoparquesMouseEntered(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Ubuntu", 3, 30)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(254, 254, 254));
        jLabel14.setText("Ecoparques");

        JLEnterFauna.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interface/Fauna.png"))); // NOI18N
        JLEnterFauna.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));
        JLEnterFauna.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JLEnterFaunaMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                JLEnterFaunaMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                JLEnterFaunaMouseEntered(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Ubuntu", 3, 30)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(254, 254, 254));
        jLabel16.setText("Fauna");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(JBRegistrarse, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
                    .addComponent(JBLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(20, 20, 20))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(JLEnterFauna)
                        .addGap(38, 38, 38)
                        .addComponent(LJEnterFlora)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(107, 107, 107)
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel10)
                        .addGap(139, 139, 139)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(JLEnterEcoparques, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addGap(68, 68, 68))))
            .addGroup(layout.createSequentialGroup()
                .addGap(422, 422, 422)
                .addComponent(jLabel8)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(JBLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JBRegistrarse, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(JLEnterFauna)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel16))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(LJEnterFlora)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel10))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(JLEnterEcoparques)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel14)))
                .addContainerGap(40, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void JBLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBLoginActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JBLoginActionPerformed

    private void JLEnterFaunaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JLEnterFaunaMouseClicked
     fauna.setVisible(true);
     this.setVisible(false);

    }//GEN-LAST:event_JLEnterFaunaMouseClicked

    private void JLEnterFaunaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JLEnterFaunaMouseEntered
        JLEnterFauna.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0,255, 0), 3, true));
    }//GEN-LAST:event_JLEnterFaunaMouseEntered

    private void JLEnterFaunaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JLEnterFaunaMouseExited
        JLEnterFauna.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));
    }//GEN-LAST:event_JLEnterFaunaMouseExited

    private void LJEnterFloraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LJEnterFloraMouseClicked
       flora.setVisible(true);
       this.setVisible(false);
    }//GEN-LAST:event_LJEnterFloraMouseClicked

    private void LJEnterFloraMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LJEnterFloraMouseEntered
        LJEnterFlora.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0,255, 0), 3, true));
    }//GEN-LAST:event_LJEnterFloraMouseEntered

    private void LJEnterFloraMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LJEnterFloraMouseExited
        LJEnterFlora.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));
    }//GEN-LAST:event_LJEnterFloraMouseExited

    private void JLEnterEcoparquesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JLEnterEcoparquesMouseClicked
        ecoparques.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_JLEnterEcoparquesMouseClicked

    private void JLEnterEcoparquesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JLEnterEcoparquesMouseEntered
        JLEnterEcoparques.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0,255, 0), 3, true));
    }//GEN-LAST:event_JLEnterEcoparquesMouseEntered

    private void JLEnterEcoparquesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JLEnterEcoparquesMouseExited
        JLEnterEcoparques.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));

    }//GEN-LAST:event_JLEnterEcoparquesMouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JBLogin;
    private javax.swing.JButton JBRegistrarse;
    private javax.swing.JLabel JLEnterEcoparques;
    private javax.swing.JLabel JLEnterFauna;
    private javax.swing.JLabel LJEnterFlora;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}