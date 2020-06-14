/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Codigo.Eco_lombia;
import Codigo.UsuarioRegistrado;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author felipe-c4
 */
public class Perfil extends javax.swing.JPanel {
    Ventana ventana;
    Integer id=0;
    String contrasena="";
    JPanel Inicio;
    boolean Afauna=false;
    boolean Aflora=false;
    boolean Aecoparques=false;
            
            
    public Perfil(Ventana ventana,JPanel Inicio){
        initComponents();
        this.setBounds(0, 0, 1000, 800);
        this.Inicio=Inicio;
        this.ventana=ventana;
        ventana.add(this);
        this.setVisible(false);
        Restaurar();
        JRBCaminatas.setActionCommand("Caminatas");
        JRBCamping.setActionCommand("Camping");
        JRBDeportes.setActionCommand("Deportes");
        JRBPlanes.setActionCommand("Planes");
    }
    
    public void Restaurar(){
        Afauna=false;
        Aflora=false;
        Aecoparques=false;
        JBCargarAporte.setVisible(false);
        JRFauna.setVisible(false);
        JRFlora.setVisible(false);
        JREcoparques.setVisible(false);
        JTFNombre.setVisible(false);
        JTFNombreCientifico.setVisible(false);
        JTFNombreComun.setVisible(false);
        JTFTaxonomia.setVisible(false);
        JCBEcosistemaEco.setVisible(false);
        JCBEcosistemaEco.setSelectedIndex(0);
        JCBEcosistemaF.setVisible(false);
        JCBEcosistemaF.setSelectedIndex(0);
        JCBUbicacionF.setVisible(false);
        JCBUbicacionF.setSelectedIndex(0);
        JCBUbicaciónEco.setVisible(false);
        JCBUbicaciónEco.setSelectedIndex(0);
        JRBCaminatas.setVisible(false);
        JRBCamping.setVisible(false);
        JRBDeportes.setVisible(false);
        JRBPlanes.setVisible(false);
        JLE.setVisible(false);
        JLE1.setVisible(false);
        JLE2.setVisible(false);
        JLE3.setVisible(false);
        JLF.setVisible(false);
        JLF1.setVisible(false);
        JLF2.setVisible(false);
        JLF3.setVisible(false);
        JLF4.setVisible(false);
        
    }
    public void clear(){
        JTFNombre.setText("");
        JTFNombreCientifico.setText("");
        JTFNombreComun.setText("");
        JTFTaxonomia.setText("filo/Clase/orden/familia/genero/especie");  
    }
    public void MostrarF(){
        clear();
        JBCargarAporte.setVisible(true);
        JRFauna.setVisible(true);
        JRFlora.setVisible(true);
        JREcoparques.setVisible(true);
        JLF.setVisible(true);
        JLF1.setVisible(true);
        JLF2.setVisible(true);
        JLF3.setVisible(true);
        JLF4.setVisible(true);   
        JCBEcosistemaF.setVisible(true);
        JCBUbicacionF.setVisible(true);
        JTFNombreCientifico.setVisible(true);
        JTFNombreComun.setVisible(true);
        JTFTaxonomia.setVisible(true);
    }
    public void MostrarE(){
        clear();
        JBCargarAporte.setVisible(true);
        JRFauna.setVisible(true);
        JRFlora.setVisible(true);
        JREcoparques.setVisible(true);
        JLE.setVisible(true);
        JLE1.setVisible(true);
        JLE2.setVisible(true);
        JLE3.setVisible(true);
        JTFNombre.setVisible(true);
        JRBCaminatas.setVisible(true);
        JRBCamping.setVisible(true);
        JRBDeportes.setVisible(true);
        JRBPlanes.setVisible(true);
        JCBEcosistemaEco.setVisible(true);
        JCBUbicaciónEco.setVisible(true);
    }        
    public void InicioSesion(UsuarioRegistrado U){
        id=U.getId();
        contrasena=U.getPassword();
        NombreEid.setText(U.getNombres()+" "+U.getApellidos()+" - "+U.getId());
        Institucion.setText(U.getInstitucion());
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Aporte = new javax.swing.ButtonGroup();
        JBGInteres = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        NombreEid = new javax.swing.JLabel();
        JBCambioContraseña = new javax.swing.JLabel();
        Institucion = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        JBLogOut = new javax.swing.JButton();
        JBNuevoAporte = new javax.swing.JButton();
        JBMisAportes = new javax.swing.JButton();
        JBBuscar = new javax.swing.JButton();
        JRFlora = new javax.swing.JRadioButton();
        JRFauna = new javax.swing.JRadioButton();
        JREcoparques = new javax.swing.JRadioButton();
        JLF = new javax.swing.JLabel();
        JLF3 = new javax.swing.JLabel();
        JLF1 = new javax.swing.JLabel();
        JLF2 = new javax.swing.JLabel();
        JLF4 = new javax.swing.JLabel();
        JCBEcosistemaF = new javax.swing.JComboBox<>();
        JCBUbicacionF = new javax.swing.JComboBox<>();
        JTFNombreCientifico = new javax.swing.JTextField();
        JTFNombreComun = new javax.swing.JTextField();
        JTFTaxonomia = new javax.swing.JTextField();
        JLE2 = new javax.swing.JLabel();
        JCBEcosistemaEco = new javax.swing.JComboBox<>();
        JLE3 = new javax.swing.JLabel();
        JCBUbicaciónEco = new javax.swing.JComboBox<>();
        JLE = new javax.swing.JLabel();
        JTFNombre = new javax.swing.JTextField();
        JLE1 = new javax.swing.JLabel();
        JRBCaminatas = new javax.swing.JRadioButton();
        JRBPlanes = new javax.swing.JRadioButton();
        JRBCamping = new javax.swing.JRadioButton();
        JRBDeportes = new javax.swing.JRadioButton();
        JBCargarAporte = new javax.swing.JButton();

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

        NombreEid.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        NombreEid.setForeground(new java.awt.Color(254, 254, 254));
        NombreEid.setText("Nombre y Apellido - ID");

        JBCambioContraseña.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        JBCambioContraseña.setForeground(new java.awt.Color(254, 254, 254));
        JBCambioContraseña.setText("Cambiar Contraseña");
        JBCambioContraseña.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JBCambioContraseñaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                JBCambioContraseñaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                JBCambioContraseñaMouseExited(evt);
            }
        });

        Institucion.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        Institucion.setForeground(new java.awt.Color(254, 254, 254));
        Institucion.setText("Institución");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(NombreEid)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(JBCambioContraseña)
                        .addGap(43, 43, 43))))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(51, 51, 51)
                    .addComponent(Institucion)
                    .addContainerGap(850, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(NombreEid)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 97, Short.MAX_VALUE)
                .addComponent(JBCambioContraseña)
                .addContainerGap())
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(61, 61, 61)
                    .addComponent(Institucion)
                    .addContainerGap(82, Short.MAX_VALUE)))
        );

        jLabel6.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(254, 254, 254));
        jLabel6.setText("RED COLABORATIVA PARA LA BIODIVERSIDAD Y ECOPARQUES COLOMBIANOS");

        JBLogOut.setBackground(new java.awt.Color(231, 231, 231));
        JBLogOut.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        JBLogOut.setText("LogOut");
        JBLogOut.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.lightGray, null, null));
        JBLogOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBLogOutActionPerformed(evt);
            }
        });

        JBNuevoAporte.setBackground(new java.awt.Color(76, 234, 86));
        JBNuevoAporte.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        JBNuevoAporte.setForeground(new java.awt.Color(254, 254, 254));
        JBNuevoAporte.setText("Nuevo Aporte");
        JBNuevoAporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBNuevoAporteActionPerformed(evt);
            }
        });

        JBMisAportes.setBackground(new java.awt.Color(76, 234, 86));
        JBMisAportes.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        JBMisAportes.setForeground(new java.awt.Color(254, 254, 254));
        JBMisAportes.setText("Mis Aportes");
        JBMisAportes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBMisAportesActionPerformed(evt);
            }
        });

        JBBuscar.setBackground(new java.awt.Color(76, 234, 86));
        JBBuscar.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        JBBuscar.setForeground(new java.awt.Color(254, 254, 254));
        JBBuscar.setText("Buscar");
        JBBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBBuscarActionPerformed(evt);
            }
        });

        JRFlora.setBackground(new java.awt.Color(120, 120, 120));
        Aporte.add(JRFlora);
        JRFlora.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        JRFlora.setForeground(new java.awt.Color(254, 254, 254));
        JRFlora.setText("Flora");
        JRFlora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JRFloraActionPerformed(evt);
            }
        });

        JRFauna.setBackground(new java.awt.Color(120, 120, 120));
        Aporte.add(JRFauna);
        JRFauna.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        JRFauna.setForeground(new java.awt.Color(254, 254, 254));
        JRFauna.setText("Fauna");
        JRFauna.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JRFaunaActionPerformed(evt);
            }
        });

        JREcoparques.setBackground(new java.awt.Color(120, 120, 120));
        Aporte.add(JREcoparques);
        JREcoparques.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        JREcoparques.setForeground(new java.awt.Color(254, 254, 254));
        JREcoparques.setText("Ecoparques");
        JREcoparques.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JREcoparquesActionPerformed(evt);
            }
        });

        JLF.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        JLF.setForeground(new java.awt.Color(254, 254, 254));
        JLF.setText("Nombre cientifico");

        JLF3.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        JLF3.setForeground(new java.awt.Color(254, 254, 254));
        JLF3.setText("Ecosistema");

        JLF1.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        JLF1.setForeground(new java.awt.Color(254, 254, 254));
        JLF1.setText("Nombre comun");

        JLF2.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        JLF2.setForeground(new java.awt.Color(254, 254, 254));
        JLF2.setText("Taxonomia");

        JLF4.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        JLF4.setForeground(new java.awt.Color(254, 254, 254));
        JLF4.setText("Ubicación");

        JCBEcosistemaF.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione ", "Bosque Tropical", "Bosque andino", "Complejo Rocoso de los Andes", "Selva Amazonica", "Matorrales", "Paramo", "Humedal", "Lotico", "Manglar", "Desierto", "Formaciones Xericas", "Embalse", "Coral", "Rio", "Lago", "Cienaga", "Estuario" }));
        JCBEcosistemaF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JCBEcosistemaFActionPerformed(evt);
            }
        });

        JCBUbicacionF.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione ", "    Amazonas", "    Antioquia", "    Arauca", "    Atlántico", "    Bolívar", "    Boyacá", "    Caldas", "    Caquetá", "    Casanare", "    Cauca", "    Cesar", "    Chocó", "    Córdoba", "    Cundinamarca", "    Guainía", "    Guaviare", "    Huila", "    La Guajira", "    Magdalena", "    Meta", "    Nariño", "    Norte de Santander", "    Putumayo", "    Quindío", "    Risaralda", "    San Andrés y Providencia", "    Santander", "    Sucre", "    Tolima", "    Valle del Cauca", "    Vaupés", "    Vichada" }));
        JCBUbicacionF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JCBUbicacionFActionPerformed(evt);
            }
        });

        JTFTaxonomia.setText("Filo/Clase/Orden/Familia/Genero/Especie");
        JTFTaxonomia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTFTaxonomiaActionPerformed(evt);
            }
        });

        JLE2.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        JLE2.setForeground(new java.awt.Color(254, 254, 254));
        JLE2.setText("Ecosistema");

        JCBEcosistemaEco.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione ", "Bosque Tropical", "Bosque andino", "Complejo Rocoso de los Andes", "Selva Amazonica", "Matorrales", "Paramo", "Humedal", "Lotico", "Manglar", "Desierto", "Formaciones Xericas", "Embalse", "Coral", "Rio", "Lago", "Cienaga", "Estuario" }));
        JCBEcosistemaEco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JCBEcosistemaEcoActionPerformed(evt);
            }
        });

        JLE3.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        JLE3.setForeground(new java.awt.Color(254, 254, 254));
        JLE3.setText("Ubicación");

        JCBUbicaciónEco.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione ", "    Amazonas", "    Antioquia", "    Arauca", "    Atlántico", "    Bolívar", "    Boyacá", "    Caldas", "    Caquetá", "    Casanare", "    Cauca", "    Cesar", "    Chocó", "    Córdoba", "    Cundinamarca", "    Guainía", "    Guaviare", "    Huila", "    La Guajira", "    Magdalena", "    Meta", "    Nariño", "    Norte de Santander", "    Putumayo", "    Quindío", "    Risaralda", "    San Andrés y Providencia", "    Santander", "    Sucre", "    Tolima", "    Valle del Cauca", "    Vaupés", "    Vichada" }));
        JCBUbicaciónEco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JCBUbicaciónEcoActionPerformed(evt);
            }
        });

        JLE.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        JLE.setForeground(new java.awt.Color(254, 254, 254));
        JLE.setText("Nombre");

        JLE1.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        JLE1.setForeground(new java.awt.Color(254, 254, 254));
        JLE1.setText("Interes");

        JRBCaminatas.setBackground(new java.awt.Color(120, 120, 120));
        JBGInteres.add(JRBCaminatas);
        JRBCaminatas.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        JRBCaminatas.setForeground(new java.awt.Color(254, 254, 254));
        JRBCaminatas.setText("Caminatas");
        JRBCaminatas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JRBCaminatasActionPerformed(evt);
            }
        });

        JRBPlanes.setBackground(new java.awt.Color(120, 120, 120));
        JBGInteres.add(JRBPlanes);
        JRBPlanes.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        JRBPlanes.setForeground(new java.awt.Color(254, 254, 254));
        JRBPlanes.setText("Planes");
        JRBPlanes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JRBPlanesActionPerformed(evt);
            }
        });

        JRBCamping.setBackground(new java.awt.Color(120, 120, 120));
        JBGInteres.add(JRBCamping);
        JRBCamping.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        JRBCamping.setForeground(new java.awt.Color(254, 254, 254));
        JRBCamping.setText("Camping");
        JRBCamping.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JRBCampingActionPerformed(evt);
            }
        });

        JRBDeportes.setBackground(new java.awt.Color(120, 120, 120));
        JBGInteres.add(JRBDeportes);
        JRBDeportes.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        JRBDeportes.setForeground(new java.awt.Color(254, 254, 254));
        JRBDeportes.setText("Deportes");
        JRBDeportes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JRBDeportesActionPerformed(evt);
            }
        });

        JBCargarAporte.setBackground(new java.awt.Color(76, 234, 86));
        JBCargarAporte.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        JBCargarAporte.setForeground(new java.awt.Color(254, 254, 254));
        JBCargarAporte.setText("Cargar Aporte");
        JBCargarAporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBCargarAporteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(JBLogOut, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24))))
            .addGroup(layout.createSequentialGroup()
                .addGap(208, 208, 208)
                .addComponent(JRFlora)
                .addGap(182, 182, 182)
                .addComponent(JRFauna)
                .addGap(101, 101, 101)
                .addComponent(JREcoparques)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(JLF4)
                                    .addComponent(JLF3))
                                .addGap(68, 68, 68)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(JCBEcosistemaF, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(JCBUbicacionF, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(JLF)
                                    .addComponent(JLF1)
                                    .addComponent(JLF2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(JTFTaxonomia, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(JTFNombreComun)
                                    .addComponent(JTFNombreCientifico))))
                        .addGap(0, 68, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JLE)
                            .addComponent(JLE1))
                        .addGap(47, 47, 47))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(JBNuevoAporte, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(JBMisAportes, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JRBCaminatas)
                            .addComponent(JRBCamping)
                            .addComponent(JRBPlanes)
                            .addComponent(JRBDeportes)
                            .addComponent(JTFNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 165, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(JBBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(195, 195, 195)
                .addComponent(JBCargarAporte, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JLE2)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(JLE3)))
                .addGap(67, 67, 67)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JCBUbicaciónEco, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JCBEcosistemaEco, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(168, 168, 168))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(JBLogOut, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addGap(28, 28, 28)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JBNuevoAporte, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JBMisAportes, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JBBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JRFlora)
                    .addComponent(JRFauna)
                    .addComponent(JREcoparques))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JLE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(JLF)
                        .addComponent(JTFNombreCientifico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(JTFNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(JLF1)
                            .addComponent(JTFNombreComun, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(JTFTaxonomia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JLF2))
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(JCBEcosistemaF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JLF3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(JCBUbicacionF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JLF4))
                        .addGap(41, 41, 41)
                        .addComponent(JBCargarAporte, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(JRBCaminatas)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JRBCamping)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JLE1)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(JRBDeportes)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(JRBPlanes)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(JCBEcosistemaEco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JLE2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JCBUbicaciónEco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JLE3))))
                .addGap(0, 57, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void JBLogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBLogOutActionPerformed
        this.setVisible(false);
        Inicio.setVisible(true);
    }//GEN-LAST:event_JBLogOutActionPerformed

    private void JBNuevoAporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBNuevoAporteActionPerformed
        JRFauna.setVisible(true);
        JRFlora.setVisible(true);
        JREcoparques.setVisible(true);
    }//GEN-LAST:event_JBNuevoAporteActionPerformed

    private void JBMisAportesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBMisAportesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JBMisAportesActionPerformed

    private void JBBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBBuscarActionPerformed
    this.setVisible(false);
        Inicio.setVisible(true);
    }//GEN-LAST:event_JBBuscarActionPerformed

    private void JRFloraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JRFloraActionPerformed
        Restaurar();
        MostrarF();
        Aflora=true;
    }//GEN-LAST:event_JRFloraActionPerformed

    private void JRFaunaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JRFaunaActionPerformed
        Restaurar();
        MostrarF();
        JTFTaxonomia.setText("Filo/Clase/Orden/Familia/Genero/Alimentacion/Depredador/Especie");
        Afauna=true;
    }//GEN-LAST:event_JRFaunaActionPerformed

    private void JREcoparquesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JREcoparquesActionPerformed
        Restaurar();
        MostrarE();
        Aecoparques=true;
        
        
    }//GEN-LAST:event_JREcoparquesActionPerformed

    private void JCBEcosistemaFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JCBEcosistemaFActionPerformed
    }//GEN-LAST:event_JCBEcosistemaFActionPerformed

    private void JCBUbicacionFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JCBUbicacionFActionPerformed
    }//GEN-LAST:event_JCBUbicacionFActionPerformed

    private void JCBEcosistemaEcoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JCBEcosistemaEcoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JCBEcosistemaEcoActionPerformed

    private void JCBUbicaciónEcoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JCBUbicaciónEcoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JCBUbicaciónEcoActionPerformed

    private void JRBCaminatasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JRBCaminatasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JRBCaminatasActionPerformed

    private void JRBPlanesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JRBPlanesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JRBPlanesActionPerformed

    private void JRBCampingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JRBCampingActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JRBCampingActionPerformed

    private void JRBDeportesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JRBDeportesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JRBDeportesActionPerformed

    private void JTFTaxonomiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTFTaxonomiaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JTFTaxonomiaActionPerformed

    private void JBCargarAporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBCargarAporteActionPerformed
        if(Aflora){
            Integer id=ventana.flora.size()+101;
            String info=id.toString();
            info=info+"/"+JTFNombreCientifico.getText()+"/"+JTFNombreComun.getText()+"/"+JCBUbicacionF.getSelectedItem().toString()
                    +"/"+JCBEcosistemaF.getSelectedItem().toString()+"/"+JTFTaxonomia.getText();
            Eco_lombia.insertarFlora(ventana.flora, info);
            Restaurar(); 
            
        }else if(Afauna){
           
            Integer id=ventana.fauna.size()+101;
            System.out.println("");
            String info=id.toString();
            info=info+"/"+JTFNombreCientifico.getText()+"/"+JTFNombreComun.getText()+"/"+JCBUbicacionF.getSelectedItem().toString()
                    +"/"+JCBEcosistemaF.getSelectedItem().toString()+"/"+JTFTaxonomia.getText();
            Eco_lombia.insertarFauna(ventana.fauna, info);
            Restaurar(); 
 
        }else if(Aecoparques){
            Integer id=ventana.ecoparque.size()+101;
            String info=id.toString();
  
            
            info=info+"/"+JTFNombre.getText()+"/"+JCBUbicaciónEco.getSelectedItem().toString()+"/"+JCBEcosistemaEco.getSelectedItem().toString()
                    +"/"+JBGInteres.getSelection().getActionCommand();
            System.out.println(info);
            Eco_lombia.insertarEcoparque(ventana.ecoparque, info);
            Restaurar(); 
            
        }






    }//GEN-LAST:event_JBCargarAporteActionPerformed

    private void JBCambioContraseñaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JBCambioContraseñaMouseClicked
        String CActual=JOptionPane.showInputDialog(null, "Introduzca su contraseña actual");
        if(CActual.equals(contrasena)){
            String C1=JOptionPane.showInputDialog(null, "Introduzca su nueva contraseña");
            String C2=JOptionPane.showInputDialog(null, "Introduzca su nueva contraseña de nuevo");
            if(C1.equals(C2)){
                Eco_lombia.contraseñaCambio(ventana.Usuarios,C1,id.toString());
                JOptionPane.showMessageDialog(null,"Cambio realizado exitosamente");
            }else
                JOptionPane.showMessageDialog(null,"Las contraseñas ingresadas no coinciden, intente nuevamente"); 
        }else{
            JOptionPane.showMessageDialog(null,"Contraseña incorrecta");

        }
    }//GEN-LAST:event_JBCambioContraseñaMouseClicked

    private void JBCambioContraseñaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JBCambioContraseñaMouseEntered
        JBCambioContraseña.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0,255, 0), 3, true));
    }//GEN-LAST:event_JBCambioContraseñaMouseEntered

    private void JBCambioContraseñaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JBCambioContraseñaMouseExited
        JBCambioContraseña.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));
    }//GEN-LAST:event_JBCambioContraseñaMouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup Aporte;
    private javax.swing.JLabel Institucion;
    private javax.swing.JButton JBBuscar;
    private javax.swing.JLabel JBCambioContraseña;
    private javax.swing.JButton JBCargarAporte;
    private javax.swing.ButtonGroup JBGInteres;
    private javax.swing.JButton JBLogOut;
    private javax.swing.JButton JBMisAportes;
    private javax.swing.JButton JBNuevoAporte;
    private javax.swing.JComboBox<String> JCBEcosistemaEco;
    private javax.swing.JComboBox<String> JCBEcosistemaF;
    private javax.swing.JComboBox<String> JCBUbicacionF;
    private javax.swing.JComboBox<String> JCBUbicaciónEco;
    private javax.swing.JLabel JLE;
    private javax.swing.JLabel JLE1;
    private javax.swing.JLabel JLE2;
    private javax.swing.JLabel JLE3;
    private javax.swing.JLabel JLF;
    private javax.swing.JLabel JLF1;
    private javax.swing.JLabel JLF2;
    private javax.swing.JLabel JLF3;
    private javax.swing.JLabel JLF4;
    private javax.swing.JRadioButton JRBCaminatas;
    private javax.swing.JRadioButton JRBCamping;
    private javax.swing.JRadioButton JRBDeportes;
    private javax.swing.JRadioButton JRBPlanes;
    private javax.swing.JRadioButton JREcoparques;
    private javax.swing.JRadioButton JRFauna;
    private javax.swing.JRadioButton JRFlora;
    private javax.swing.JTextField JTFNombre;
    private javax.swing.JTextField JTFNombreCientifico;
    private javax.swing.JTextField JTFNombreComun;
    private javax.swing.JTextField JTFTaxonomia;
    private javax.swing.JLabel NombreEid;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
