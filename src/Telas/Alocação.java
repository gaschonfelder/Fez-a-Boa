/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Telas;

import Conexões.MySQL;
import Objetos.Prestador;
import Objetos.Serviço;
import java.awt.Toolkit;
import javax.swing.JOptionPane;

public class Alocação extends javax.swing.JFrame {

    MySQL conectar = new MySQL();
    Prestador novoPrestador = new Prestador();
    Serviço novoServiço = new Serviço();
    public Alocação() {
        initComponents();
            this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagens//logo.png"))); // Define Icone

        this.conectar.conectaBanco();
        
    try{
        this.conectar.executarSQL(
            "SELECT "
                +"nome"
            +" FROM "
                +"PrestadorDeServico"
        );
        while(this.conectar.getResultSet().next()){
            CmbPrestador.addItem(this.conectar.getResultSet().getString(1));
        }
        
            
            }catch (Exception e){
                System.out.println("Erro ao consultar clinte "+ e.getMessage());
                JOptionPane.showMessageDialog(null, "Erro ao buscar cliente!");
            }finally{
            
            this.conectar.fechaBanco();
            
    }
    this.conectar.conectaBanco();
    try{
        this.conectar.executarSQL(
            "SELECT "
                +"RazaoSocial"
            +" FROM "
                +"Empresa"
        );
        while(this.conectar.getResultSet().next()){
            CmbEmpresa.addItem(this.conectar.getResultSet().getString(1));
        }
        
        
            
            }catch (Exception e){
                System.out.println("Erro ao consultar clinte "+ e.getMessage());
                JOptionPane.showMessageDialog(null, "Erro ao buscar cliente!");
            }finally{
            
            this.conectar.fechaBanco();
            
    }
    this.conectar.conectaBanco();
    
    try{
        this.conectar.executarSQL(
            "SELECT "
                +"RazaoSocial"
            +" FROM "
                +"Empresa"
        );
        while(this.conectar.getResultSet().next()){
            cbmConsServEmp.addItem(this.conectar.getResultSet().getString(1));
        }
        
        
            
            }catch (Exception e){
                System.out.println("Erro ao consultar clinte "+ e.getMessage());
                JOptionPane.showMessageDialog(null, "Erro ao buscar cliente!");
            }finally{
            
            this.conectar.fechaBanco();
            
    }
    
    
    }
    private void CadastrarServiço(Serviço novo){
        this.conectar.conectaBanco();
        
        novo.setEmpresa(CmbEmpresa.getSelectedItem().toString());
        novo.setPrestador(CmbPrestador.getSelectedItem().toString());
        novo.setCNPJEmpresa(txtCNPJEm.getText());
        novo.setCPFPrestador(txtCPFPrest.getText());
        novo.setHorasTrab(Integer.parseInt(txtHrsCont.getText()));
        novo.setObservação(txtObs.getText());
        novo.setServiço(txtServico.getText());
        
        try{
            this.conectar.insertSQL("INSERT INTO Servico("
                    +"Prestador,"
                    +"CPF,"
                    +"Empresa,"
                    +"CNPJ,"
                    +"servico,"
                    +"observacao,"
                    +"horas"
                +") VALUES ("
                    +"'"+novo.getPrestador()+"',"
                    +"'"+novo.getCPFPrestador()+"',"
                    +"'"+novo.getEmpresa()+"',"
                    +"'"+novo.getCNPJEmpresa()+"',"
                    +"'"+novo.getServiço()+"',"
                    +"'"+novo.getObservação()+"',"
                    +"'"+novo.getHorasTrab()+"'"
                    +")"        
            );
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar serviço!");
        }
        finally{
            this.conectar.fechaBanco();
            JOptionPane.showMessageDialog(null, "Serviço cadastrado com sucesso!");

        }
        
    }
    
    private void buscarServicoPrestador (Serviço novo){
        this.conectar.conectaBanco();
        String consultaCPF = this.txtCPFbuscarServ.getText();
        
        try{
            this.conectar.executarSQL(
            "SELECT "
                    +"Prestador, "
                    +"Empresa,"
                    +"CNPJ,"
                    +"servico,"
                    +"observacao,"
                    +"horas"
            +" FROM "
                    +"Servico"
            +" WHERE "
                    +"CPF = '"+ consultaCPF +"';"
            );
            while(this.conectar.getResultSet().next()){
                novo.setPrestador(this.conectar.getResultSet().getString(1));
                novo.setEmpresa(this.conectar.getResultSet().getString(2));
                novo.setCNPJEmpresa(this.conectar.getResultSet().getString(3));
                novo.setServiço(this.conectar.getResultSet().getString(4));
                novo.setObservação(this.conectar.getResultSet().getString(5));
                novo.setHorasTrab(Integer.parseInt(this.conectar.getResultSet().getString(6)));
            }
            if(novo.getPrestador()==""){
                JOptionPane.showMessageDialog(null, "Serviço não encontrado!");
                System.out.println("Prestador não encontrado! ");
            }
        }catch (Exception e){
                System.out.println("Erro ao consultar cliente "+ e.getMessage());
                JOptionPane.showMessageDialog(null, "Erro ao buscar serviço!");
        }finally{
            txtNomePrestConsult.setText(novo.getPrestador());
            txtEmpresaBuscar.setText(novo.getEmpresa());
            txtCNPJBuscar.setText(novo.getCNPJEmpresa());
            txtServicoBuscar.setText(novo.getServiço());
            txtObsBuscar.setText(novo.getObservação());
            txtHorasBuscar.setText(String.valueOf(novo.getHorasTrab()));
            this.conectar.fechaBanco();
        }
    }
    public void atualizarServicoPrest(Serviço novo){
        this.conectar.conectaBanco();
        String consultaCPF = this.txtCPFbuscarServ.getText();
        
        try{
            this.conectar.updateSQL(
            "UPDATE Servico SET "
            +"Prestador='"+txtNomePrestConsult.getText()+"',"
            +"Empresa='"+txtEmpresaBuscar.getText()+"',"
            +"CNPJ='"+txtCNPJBuscar.getText()+"',"
            +"servico='"+txtServicoBuscar.getText()+"',"
            +"observacao='"+txtObsBuscar.getText()+"',"
            +"horas='"+txtHorasBuscar.getText()+"'"
            + " WHERE"
            +" CPF='"+consultaCPF+"';"
            );
        }catch(Exception e){
            System.out.println("Erro ao consultar Prestador "+ e.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao buscar prestador!");
        }finally{
            txtNomePrestConsult.setText(novo.getPrestador());
            txtEmpresaBuscar.setText(novo.getEmpresa());
            txtCNPJBuscar.setText(novo.getCNPJEmpresa());
            txtServicoBuscar.setText(novo.getServiço());
            txtObsBuscar.setText(novo.getObservação());
            txtHorasBuscar.setText(String.valueOf(novo.getHorasTrab()));
        }
    }
    public void atualizarServicoEmpresa(Serviço novo){
        this.conectar.conectaBanco();
        String consulta = this.cbmPrestaContra.getSelectedItem().toString();
        try{
            this.conectar.updateSQL(
             "UPDATE Servico SET "
                    +"CPF='"+txtCPFEmpConsult.getText()+"',"
                    +"servico='"+txtServEmpConsult.getText()+"',"
                    +"observacao='"+txtObsEmpCOnsult.getText()+"',"
                    +"horas='"+txtHrsEmpConsult.getText()+"'"
                    +" WHERE "
                    +"Prestador='"+consulta+"';"
            );
        }catch(Exception e){
           JOptionPane.showMessageDialog(null, "Erro ao buscar prestador!"); 
        }finally{
         JOptionPane.showMessageDialog(null, "Atualização realizada com sucesso!"); 
         this.conectar.fechaBanco();   
        }
    }
    
    
    
    public void excluirServicoPrest(Serviço novo){
        this.conectar.conectaBanco();
        String consultaCPF = this.txtCPFbuscarServ.getText();
        
        try{
            this.conectar.updateSQL(
                    "DELETE FROM Servico WHERE "
                    +"CPF = '"+consultaCPF+"';"
            );            
        }catch (Exception e){
          System.out.println("Erro ao consultar clinte "+ e.getMessage());
          JOptionPane.showMessageDialog(null, "Erro ao excluir Serviço!");  
        }finally{
         this.conectar.fechaBanco();
         System.out.println("Serviço deletado!");
         JOptionPane.showMessageDialog(null, "Serviço excluido com sucesso!");
   
        }
    }
    public void excluirServicoEmpresa(Serviço novo){
        this.conectar.conectaBanco();
        String consulta = this.cbmPrestaContra.getSelectedItem().toString();
        
        try{
            this.conectar.updateSQL(
                    "DELETE FROM Servico WHERE "
                    +"Prestador = '"+consulta+"';"
            );
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro ao excluir serviço!"); 
           
        }finally{
            this.conectar.fechaBanco();
            txtCPFEmpConsult.setText("");
            txtCNPJConsultporEmpr.setText("");
            txtHrsEmpConsult.setText("");
            txtObsEmpCOnsult.setText("");
            txtServEmpConsult.setText("");
            cbmConsServEmp.setSelectedIndex(0);
            cbmPrestaContra.setSelectedIndex(0);
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

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        CmbPrestador = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        CmbEmpresa = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        txtServico = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtObs = new javax.swing.JTextPane();
        jLabel5 = new javax.swing.JLabel();
        txtHrsCont = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        txtCPFPrest = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtCNPJEm = new javax.swing.JTextField();
        BtnVoltar = new javax.swing.JButton();
        jLabel24 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        txtCPFbuscarServ = new javax.swing.JFormattedTextField();
        btnBuscarServ = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        txtNomePrestConsult = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtEmpresaBuscar = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtCNPJBuscar = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtServicoBuscar = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtHorasBuscar = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtObsBuscar = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        BtnAtualizarServ = new javax.swing.JButton();
        btnExcluirServ = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jLabel23 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        txtCNPJConsultporEmpr = new javax.swing.JFormattedTextField();
        cbmConsServEmp = new javax.swing.JComboBox<>();
        jLabel16 = new javax.swing.JLabel();
        cbmPrestaContra = new javax.swing.JComboBox<>();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        txtCPFEmpConsult = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        txtServEmpConsult = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        txtObsEmpCOnsult = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        txtHrsEmpConsult = new javax.swing.JTextField();
        BtnBuscarEmp = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        BtnLimparConsutEmo = new javax.swing.JButton();
        jLabel22 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(248, 244, 235));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Prestador: ");

        CmbPrestador.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Prestadores cadastrados" }));
        CmbPrestador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CmbPrestadorActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Empresa: ");

        CmbEmpresa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Empresas cadastradas" }));
        CmbEmpresa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CmbEmpresaActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("Serviço solicitado:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Observação: ");

        jScrollPane1.setViewportView(txtObs);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setText(" Horas contratadas: ");

        jButton1.setBackground(new java.awt.Color(204, 204, 255));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 0, 0));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/icons8-salvar-16 (1).png"))); // NOI18N
        jButton1.setText("Cadastrar serviço");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(204, 204, 255));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(0, 0, 0));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/icons8-apagar-16.png"))); // NOI18N
        jButton2.setText("Limpar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("CPF do prestador: ");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("CNPJ Empresa: ");

        BtnVoltar.setBackground(new java.awt.Color(204, 204, 255));
        BtnVoltar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        BtnVoltar.setForeground(new java.awt.Color(0, 0, 0));
        BtnVoltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/icons8-à-esquerda-dentro-de-um-círculo-16.png"))); // NOI18N
        BtnVoltar.setText("Voltar");
        BtnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnVoltarActionPerformed(evt);
            }
        });

        jLabel24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/logo.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(BtnVoltar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(txtHrsCont, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(txtCNPJEm)
                            .addComponent(txtServico)
                            .addComponent(jScrollPane1)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtCPFPrest, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(CmbPrestador, javax.swing.GroupLayout.Alignment.LEADING, 0, 299, Short.MAX_VALUE)
                            .addComponent(CmbEmpresa, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(39, 39, 39)
                .addComponent(jLabel24)
                .addGap(30, 30, 30))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(CmbPrestador, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtCPFPrest, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(CmbEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(txtCNPJEm))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtServico, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(txtHrsCont)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BtnVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(38, Short.MAX_VALUE))
            .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Contratar serviço", jPanel2);

        jPanel1.setBackground(new java.awt.Color(248, 244, 235));
        jPanel1.setLayout(null);

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("CPF :");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(6, 6, 37, 30);

        try {
            txtCPFbuscarServ.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jPanel1.add(txtCPFbuscarServ);
        txtCPFbuscarServ.setBounds(49, 6, 126, 30);

        btnBuscarServ.setBackground(new java.awt.Color(204, 204, 255));
        btnBuscarServ.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnBuscarServ.setForeground(new java.awt.Color(0, 0, 0));
        btnBuscarServ.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/icons8-binóculos-16 (1).png"))); // NOI18N
        btnBuscarServ.setText("BUSCAR");
        btnBuscarServ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarServActionPerformed(evt);
            }
        });
        jPanel1.add(btnBuscarServ);
        btnBuscarServ.setBounds(187, 6, 112, 30);

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setText("Nome prestador :");
        jPanel1.add(jLabel9);
        jLabel9.setBounds(6, 48, 112, 30);
        jPanel1.add(txtNomePrestConsult);
        txtNomePrestConsult.setBounds(124, 48, 311, 30);

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setText("Nome empresa :");
        jPanel1.add(jLabel10);
        jLabel10.setBounds(6, 96, 112, 30);
        jPanel1.add(txtEmpresaBuscar);
        txtEmpresaBuscar.setBounds(124, 96, 311, 30);

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel11.setText("CNPJ empresa :");
        jPanel1.add(jLabel11);
        jLabel11.setBounds(6, 144, 112, 30);
        jPanel1.add(txtCNPJBuscar);
        txtCNPJBuscar.setBounds(124, 144, 311, 30);

        jLabel12.setText("Serviço contratado :");
        jPanel1.add(jLabel12);
        jLabel12.setBounds(6, 192, 112, 30);
        jPanel1.add(txtServicoBuscar);
        txtServicoBuscar.setBounds(124, 192, 311, 30);

        jLabel13.setText("Horas contratadas :");
        jPanel1.add(jLabel13);
        jLabel13.setBounds(6, 240, 112, 30);
        jPanel1.add(txtHorasBuscar);
        txtHorasBuscar.setBounds(124, 240, 311, 30);

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel14.setText("Observação :");
        jPanel1.add(jLabel14);
        jLabel14.setBounds(6, 288, 112, 30);
        jPanel1.add(txtObsBuscar);
        txtObsBuscar.setBounds(124, 288, 311, 30);

        jButton4.setBackground(new java.awt.Color(204, 204, 255));
        jButton4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton4.setForeground(new java.awt.Color(0, 0, 0));
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/icons8-apagar-16.png"))); // NOI18N
        jButton4.setText("LIMPAR");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4);
        jButton4.setBounds(311, 6, 124, 30);

        BtnAtualizarServ.setBackground(new java.awt.Color(204, 204, 255));
        BtnAtualizarServ.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        BtnAtualizarServ.setForeground(new java.awt.Color(0, 0, 0));
        BtnAtualizarServ.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/icons8-actualizar-16 (1).png"))); // NOI18N
        BtnAtualizarServ.setText("ATUALIZAR");
        BtnAtualizarServ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAtualizarServActionPerformed(evt);
            }
        });
        jPanel1.add(BtnAtualizarServ);
        BtnAtualizarServ.setBounds(6, 357, 200, 40);

        btnExcluirServ.setBackground(new java.awt.Color(204, 204, 255));
        btnExcluirServ.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnExcluirServ.setForeground(new java.awt.Color(0, 0, 0));
        btnExcluirServ.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/icons8-lixo-16.png"))); // NOI18N
        btnExcluirServ.setText("EXCLUIR");
        btnExcluirServ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirServActionPerformed(evt);
            }
        });
        jPanel1.add(btnExcluirServ);
        btnExcluirServ.setBounds(238, 357, 197, 40);

        jButton7.setBackground(new java.awt.Color(204, 204, 255));
        jButton7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton7.setForeground(new java.awt.Color(0, 0, 0));
        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/icons8-à-esquerda-dentro-de-um-círculo-16.png"))); // NOI18N
        jButton7.setText("VOLTAR");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton7);
        jButton7.setBounds(6, 409, 430, 30);

        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/logo.png"))); // NOI18N
        jPanel1.add(jLabel23);
        jLabel23.setBounds(470, 0, 270, 450);

        jTabbedPane1.addTab("Consultar por prestador", jPanel1);

        jPanel3.setBackground(new java.awt.Color(248, 244, 235));
        jPanel3.setLayout(null);

        jLabel15.setText("CNPJ :");
        jPanel3.add(jLabel15);
        jLabel15.setBounds(6, 48, 43, 26);

        try {
            txtCNPJConsultporEmpr.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##.###.###/####-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jPanel3.add(txtCNPJConsultporEmpr);
        txtCNPJConsultporEmpr.setBounds(116, 48, 186, 26);

        cbmConsServEmp.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbmConsServEmp.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Empresas cadastradas" }));
        cbmConsServEmp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbmConsServEmpActionPerformed(evt);
            }
        });
        jPanel3.add(cbmConsServEmp);
        cbmConsServEmp.setBounds(116, 8, 315, 26);

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel16.setText("Empresas :");
        jPanel3.add(jLabel16);
        jLabel16.setBounds(6, 6, 68, 30);

        cbmPrestaContra.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbmPrestaContra.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Prestadores contratados" }));
        cbmPrestaContra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbmPrestaContraActionPerformed(evt);
            }
        });
        jPanel3.add(cbmPrestaContra);
        cbmPrestaContra.setBounds(116, 86, 315, 26);

        jLabel17.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel17.setText("Prestadores : ");
        jPanel3.add(jLabel17);
        jLabel17.setBounds(6, 86, 86, 30);

        jLabel18.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel18.setText("CPF :");
        jPanel3.add(jLabel18);
        jLabel18.setBounds(6, 172, 43, 30);
        jPanel3.add(txtCPFEmpConsult);
        txtCPFEmpConsult.setBounds(73, 172, 358, 30);

        jLabel19.setText("Serviço solicitado :");
        jPanel3.add(jLabel19);
        jLabel19.setBounds(6, 214, 104, 30);
        jPanel3.add(txtServEmpConsult);
        txtServEmpConsult.setBounds(116, 214, 315, 30);

        jLabel20.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel20.setText("Observação :");
        jPanel3.add(jLabel20);
        jLabel20.setBounds(6, 256, 104, 30);
        jPanel3.add(txtObsEmpCOnsult);
        txtObsEmpCOnsult.setBounds(116, 256, 315, 30);

        jLabel21.setText("Horas contratadas: ");
        jPanel3.add(jLabel21);
        jLabel21.setBounds(6, 298, 104, 30);
        jPanel3.add(txtHrsEmpConsult);
        txtHrsEmpConsult.setBounds(116, 298, 315, 30);

        BtnBuscarEmp.setBackground(new java.awt.Color(204, 204, 255));
        BtnBuscarEmp.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        BtnBuscarEmp.setForeground(new java.awt.Color(0, 0, 0));
        BtnBuscarEmp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/icons8-binóculos-16 (1).png"))); // NOI18N
        BtnBuscarEmp.setText("BUSCAR");
        BtnBuscarEmp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnBuscarEmpActionPerformed(evt);
            }
        });
        jPanel3.add(BtnBuscarEmp);
        BtnBuscarEmp.setBounds(6, 128, 200, 30);

        jButton5.setBackground(new java.awt.Color(204, 204, 255));
        jButton5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton5.setForeground(new java.awt.Color(0, 0, 0));
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/icons8-actualizar-16 (1).png"))); // NOI18N
        jButton5.setText("ATUALIZAR");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton5);
        jButton5.setBounds(6, 346, 200, 40);

        jButton6.setBackground(new java.awt.Color(204, 204, 255));
        jButton6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton6.setForeground(new java.awt.Color(0, 0, 0));
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/icons8-lixo-16.png"))); // NOI18N
        jButton6.setText("EXCLUIR");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton6);
        jButton6.setBounds(231, 346, 200, 42);

        jButton8.setBackground(new java.awt.Color(204, 204, 255));
        jButton8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton8.setForeground(new java.awt.Color(0, 0, 0));
        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/icons8-à-esquerda-dentro-de-um-círculo-16.png"))); // NOI18N
        jButton8.setText("VOLTAR");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton8);
        jButton8.setBounds(6, 400, 430, 39);

        BtnLimparConsutEmo.setBackground(new java.awt.Color(204, 204, 255));
        BtnLimparConsutEmo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        BtnLimparConsutEmo.setForeground(new java.awt.Color(0, 0, 0));
        BtnLimparConsutEmo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/icons8-apagar-16.png"))); // NOI18N
        BtnLimparConsutEmo.setText("LIMPAR");
        BtnLimparConsutEmo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnLimparConsutEmoActionPerformed(evt);
            }
        });
        jPanel3.add(BtnLimparConsutEmo);
        BtnLimparConsutEmo.setBounds(231, 128, 200, 32);

        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/logo.png"))); // NOI18N
        jPanel3.add(jLabel22);
        jLabel22.setBounds(470, -2, 270, 450);

        jTabbedPane1.addTab("Consultar por empresa", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       txtCNPJEm.setText("");
       txtCPFPrest.setText("");
       txtHrsCont.setText("");
       txtObs.setText("");
       txtServico.setText("");
       CmbEmpresa.setSelectedIndex(0);
       CmbPrestador.setSelectedIndex(0);
       
    
    }//GEN-LAST:event_jButton2ActionPerformed

    private void CmbPrestadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CmbPrestadorActionPerformed
        this.conectar.conectaBanco();
    String consultaCPF = this.CmbPrestador.getSelectedItem().toString();
    try{
        this.conectar.executarSQL(
            "SELECT "
                +"cpf"
            +" FROM "
                +"PrestadorDeServico"
            +" WHERE "
                +"nome = '"+consultaCPF+"';"
        );
        while(this.conectar.getResultSet().next()){
            txtCPFPrest.setText(this.conectar.getResultSet().getString(1));
        }
    }catch (Exception e){
                System.out.println("Erro ao consultar clinte "+ e.getMessage());
                JOptionPane.showMessageDialog(null, "Erro ao buscar cliente!");
            }finally{
            
            this.conectar.fechaBanco();
            //JOptionPane.showMessageDialog(null, "Prestador Localizado!");
    
    
    }
    }//GEN-LAST:event_CmbPrestadorActionPerformed

    private void CmbEmpresaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CmbEmpresaActionPerformed
    this.conectar.conectaBanco();
    String consultaCPF = this.CmbEmpresa.getSelectedItem().toString();
    try{
        this.conectar.executarSQL(
            "SELECT "
                +"CNPJ"
            +" FROM "
                +"Empresa"
            +" WHERE "
                +"RazaoSocial = '"+consultaCPF+"';"
        );
        while(this.conectar.getResultSet().next()){
            txtCNPJEm.setText(this.conectar.getResultSet().getString(1));
        }
    }catch (Exception e){
                System.out.println("Erro ao consultar clinte "+ e.getMessage());
                JOptionPane.showMessageDialog(null, "Erro ao buscar cliente!");
            }finally{
            
            this.conectar.fechaBanco();
            //JOptionPane.showMessageDialog(null, "Prestador Localizado!");
    
    }
    }//GEN-LAST:event_CmbEmpresaActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        CadastrarServiço(novoServiço);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void BtnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnVoltarActionPerformed
        TelaInicial tela2 = new TelaInicial();
        tela2.setVisible(true);
        dispose();
    }//GEN-LAST:event_BtnVoltarActionPerformed

    private void btnBuscarServActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarServActionPerformed
        buscarServicoPrestador(novoServiço);
    }//GEN-LAST:event_btnBuscarServActionPerformed

    private void BtnAtualizarServActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAtualizarServActionPerformed
        atualizarServicoPrest(novoServiço);
    }//GEN-LAST:event_BtnAtualizarServActionPerformed

    private void btnExcluirServActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirServActionPerformed
        excluirServicoPrest(novoServiço);
        txtCNPJBuscar.setText("");
        txtCPFbuscarServ.setText("");
        txtEmpresaBuscar.setText("");
        txtObsBuscar.setText("");
        txtServicoBuscar.setText("");
        txtHorasBuscar.setText("");
        txtNomePrestConsult.setText("");
        
    }//GEN-LAST:event_btnExcluirServActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        txtCNPJBuscar.setText("");
        txtCPFbuscarServ.setText("");
        txtEmpresaBuscar.setText("");
        txtObsBuscar.setText("");
        txtServicoBuscar.setText("");
        txtHorasBuscar.setText("");
        txtNomePrestConsult.setText("");
    }//GEN-LAST:event_jButton4ActionPerformed

    private void cbmConsServEmpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbmConsServEmpActionPerformed
    this.conectar.conectaBanco();
    String consultarEmpresa = this.cbmConsServEmp.getSelectedItem().toString();
    cbmPrestaContra.removeAllItems();
    cbmPrestaContra.addItem("Prestadores Contratados");
    try{
        this.conectar.executarSQL(
            "SELECT "
                +"CNPJ"
            +" FROM "
                +"Empresa"
            +" WHERE "
                +"RazaoSocial = '"+consultarEmpresa+"';"
        );
        while(this.conectar.getResultSet().next()){
            txtCNPJConsultporEmpr.setText(this.conectar.getResultSet().getString(1));
        }
    }catch (Exception e){
                System.out.println("Erro ao consultar clinte "+ e.getMessage());
                JOptionPane.showMessageDialog(null, "Erro ao buscar cliente!");
            }finally{
            
            this.conectar.fechaBanco();
            //JOptionPane.showMessageDialog(null, "Prestador Localizado!");
    
    }
    this.conectar.conectaBanco();
    try{
        this.conectar.executarSQL(
        "SELECT "
                +"Prestador"
        +" FROM "
                +"Servico"
        +" WHERE "
                +"Empresa ='"+consultarEmpresa+"';"
        );while(this.conectar.getResultSet().next()){
        cbmPrestaContra.addItem(this.conectar.getResultSet().getString(1));
    }
    }catch(Exception e){
        System.out.println("Erro ao consultar clinte "+ e.getMessage());
    }finally{
        this.conectar.fechaBanco();
    }
    
    }//GEN-LAST:event_cbmConsServEmpActionPerformed

    private void cbmPrestaContraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbmPrestaContraActionPerformed
    this.conectar.conectaBanco();
    /*
    String consulta = this.cbmPrestaContra.getSelectedItem().toString();
    try{
        this.conectar.executarSQL(
            "SELECT "
                +"CPF,"
                +"servico,"
                +"observacao,"
                +"horas"
            +" FROM "
                +"Servico"
            +" WHERE "
                +"Prestador = '"+consulta+"';"
        );
        while(this.conectar.getResultSet().next()){
            txtCPFEmpConsult.setText(this.conectar.getResultSet().getString(1));
            txtServEmpConsult.setText(this.conectar.getResultSet().getString(2));
            txtObsEmpCOnsult.setText(this.conectar.getResultSet().getString(3));
            txtHrsEmpConsult.setText(this.conectar.getResultSet().getString(4));
        } 
    }catch(Exception e){
     JOptionPane.showMessageDialog(null, "Erro ao buscar Prestador!"); 
    }finally{
    this.conectar.fechaBanco();
    }
    */
    }//GEN-LAST:event_cbmPrestaContraActionPerformed

    private void BtnBuscarEmpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnBuscarEmpActionPerformed
    this.conectar.conectaBanco();
    String consulta = this.cbmPrestaContra.getSelectedItem().toString();
    try{
        this.conectar.executarSQL(
            "SELECT "
                +"CPF,"
                +"servico,"
                +"observacao,"
                +"horas"
            +" FROM "
                +"Servico"
            +" WHERE "
                +"Prestador = '"+consulta+"';"
        );
        while(this.conectar.getResultSet().next()){
            txtCPFEmpConsult.setText(this.conectar.getResultSet().getString(1));
            txtServEmpConsult.setText(this.conectar.getResultSet().getString(2));
            txtObsEmpCOnsult.setText(this.conectar.getResultSet().getString(3));
            txtHrsEmpConsult.setText(this.conectar.getResultSet().getString(4));
        } 
    }catch(Exception e){
     JOptionPane.showMessageDialog(null, "Erro ao buscar Prestador!"); 
    }finally{
    this.conectar.fechaBanco();
    }
    }//GEN-LAST:event_BtnBuscarEmpActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        atualizarServicoEmpresa(novoServiço); 
    }//GEN-LAST:event_jButton5ActionPerformed

    private void BtnLimparConsutEmoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnLimparConsutEmoActionPerformed
        txtCPFEmpConsult.setText("");
        txtHrsEmpConsult.setText("");
        txtObsEmpCOnsult.setText("");
        txtServEmpConsult.setText("");
        cbmPrestaContra.setSelectedIndex(0);
        cbmConsServEmp.setSelectedIndex(0);
        txtCNPJConsultporEmpr.setText("");
    }//GEN-LAST:event_BtnLimparConsutEmoActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        excluirServicoEmpresa(novoServiço);
        
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
     TelaInicial tela2 = new TelaInicial();
        tela2.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
    TelaInicial tela2 = new TelaInicial();
        tela2.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton8ActionPerformed

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
            java.util.logging.Logger.getLogger(Alocação.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Alocação.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Alocação.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Alocação.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Alocação().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnAtualizarServ;
    private javax.swing.JButton BtnBuscarEmp;
    private javax.swing.JButton BtnLimparConsutEmo;
    private javax.swing.JButton BtnVoltar;
    private javax.swing.JComboBox<String> CmbEmpresa;
    private javax.swing.JComboBox<String> CmbPrestador;
    private javax.swing.JButton btnBuscarServ;
    private javax.swing.JButton btnExcluirServ;
    private javax.swing.JComboBox<String> cbmConsServEmp;
    private javax.swing.JComboBox<String> cbmPrestaContra;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
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
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField txtCNPJBuscar;
    private javax.swing.JFormattedTextField txtCNPJConsultporEmpr;
    private javax.swing.JTextField txtCNPJEm;
    private javax.swing.JTextField txtCPFEmpConsult;
    private javax.swing.JTextField txtCPFPrest;
    private javax.swing.JFormattedTextField txtCPFbuscarServ;
    private javax.swing.JTextField txtEmpresaBuscar;
    private javax.swing.JTextField txtHorasBuscar;
    private javax.swing.JTextField txtHrsCont;
    private javax.swing.JTextField txtHrsEmpConsult;
    private javax.swing.JTextField txtNomePrestConsult;
    private javax.swing.JTextPane txtObs;
    private javax.swing.JTextField txtObsBuscar;
    private javax.swing.JTextField txtObsEmpCOnsult;
    private javax.swing.JTextField txtServEmpConsult;
    private javax.swing.JTextField txtServico;
    private javax.swing.JTextField txtServicoBuscar;
    // End of variables declaration//GEN-END:variables
}
