/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Telas;

import Conexões.MySQL;
import Objetos.Prestador;
import javax.swing.JOptionPane;


public class CadastroPrestador extends javax.swing.JFrame {

    MySQL conectar = new MySQL();
    Prestador novoPrestador = new Prestador();    
    
    
    public CadastroPrestador() {
        initComponents();
    }
    private void CadastrarPrestador(Prestador novo){
        
        this.conectar.conectaBanco();
        
        novo.setNome(txtNomeCad.getText());
        novo.setCpf(txtCPfCad.getText());
        novo.setEmail(txtEmailCad.getText());
        novo.setEndereco(txtEndCad.getText());
        novo.setIdade(Integer.parseInt(txtIdadeCad.getText()));
        novo.setServicos(txtServicosCad.getText());
        novo.setSexo(String.valueOf(CmbSexo.getSelectedItem()));        
       
        try{
            this.conectar.insertSQL("INSERT INTO PrestadorDeServico("
            +"nome,"
            +"cpf,"
            +"idade,"        
            +"sexo,"
            +"email,"
            +"endereco,"
            +"servicos"
        +") VALUES ("
            +"'"+ novo.getNome()+"',"
            +"'"+ novo.getCpf()+"',"
            +"'"+ novo.getIdade()+"',"
            +"'"+ novo.getSexo()+"',"
            +"'"+ novo.getEmail()+"',"
            +"'"+ novo.getEndereco()+"',"
            +"'"+ novo.getServicos()+"'"
            +")"); 
                    
            
            
            
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar prestador!");
        }
        finally{
            this.conectar.fechaBanco();
            JOptionPane.showMessageDialog(null, "Prestador cadastrado com sucesso!");

        }
        
    }
    public void buscarPrestador(Prestador novo){
        
        
        this.conectar.conectaBanco();
        
        String consultaCPF = this.txtCPFBuscar.getText();
        
        
        try{
            this.conectar.executarSQL(
             "SELECT  "
            + "nome," 
            + "idade,"
            + "sexo,"        
            + "email,"        
            + "endereco,"        
            +"servicos"
         + " FROM "
             + "PrestadorDeServico"
         + " WHERE "
             + "cpf = '" + consultaCPF + "'" + ";"  
            );
            while(this.conectar.getResultSet().next()){
                novo.setNome(this.conectar.getResultSet().getString(1));
                novo.setIdade(Integer.parseInt(this.conectar.getResultSet().getString(2)));
                novo.setSexo(this.conectar.getResultSet().getString(3));
                novo.setEmail(this.conectar.getResultSet().getString(4));
                novo.setEndereco(this.conectar.getResultSet().getString(5));
                novo.setServicos(this.conectar.getResultSet().getString(6));
            }
            if(novo.getNome()==""){
                JOptionPane.showMessageDialog(null, "Cliente não encontrado!");
                System.out.println("Cliente não encontrado! ");
            }
            }catch (Exception e){
                System.out.println("Erro ao consultar clinte "+ e.getMessage());
                JOptionPane.showMessageDialog(null, "Erro ao buscar cliente!");
            }finally{
            txtNomeBuscar.setText(novo.getNome());
            txtIdadeBuscar.setText(Integer.toString(novo.getIdade()));
            txtSexoBuscar.setText(novo.getSexo());
            txtEmailBuscar.setText(novo.getEmail());
            txtEndBuscaaar.setText(novo.getEndereco());
            txtServicoBuscar.setText(novo.getServicos());
            this.conectar.fechaBanco();
            JOptionPane.showMessageDialog(null, "Prestador Localizado!");
            
            
        }
    }
    public void atualizarPrestador(Prestador novo){
        this.conectar.conectaBanco();
         String consultaCPF = this.txtCPFBuscar.getText();
         
         try{
             this.conectar.updateSQL(
              "UPDATE PrestadorDeServico SET " 
            + "nome='"+txtNomeBuscar.getText()+"',"
            + "cpf='"+txtCPFBuscar.getText()+"',"
            + "idade='"+txtIdadeBuscar.getText()+"',"
            + "sexo='"+txtServicoBuscar.getText()+"',"
            + "email='"+txtEmailBuscar.getText()+"',"
            + "endereco='"+txtEndBuscaaar.getText()+"',"
            +"servicos='"+txtServicoBuscar.getText()+"'"
            + " WHERE"
             + " cpf = '" + consultaCPF + "'" + ";"
             );
         }catch(Exception e){
              System.out.println("Erro ao consultar Prestador "+ e.getMessage());
               JOptionPane.showMessageDialog(null, "Erro ao buscar prestador!");
         }finally{
            txtNomeBuscar.setText(novo.getNome());
            txtIdadeBuscar.setText(Integer.toString(novo.getIdade()));
            txtServicoBuscar.setText(novo.getSexo());
            txtEmailBuscar.setText(novo.getEmail());
            txtEndBuscaaar.setText(novo.getEndereco());
            txtServicoBuscar.setText(novo.getServicos());
            this.conectar.fechaBanco();
            JOptionPane.showMessageDialog(null, "Prestador Atualizado!");
         }
    }
    public void excluirPrestador(Prestador novo){
        this.conectar.conectaBanco();
        String consultaCPF = this.txtCPFBuscar.getText();
        
        try{
                this.conectar.updateSQL(
                "DELETE FROM PrestadorDeServico WHERE "
                +"cpf = '" + consultaCPF + "'" + ";"        
                );
            }catch (Exception e){
                System.out.println("Erro ao consultar clinte "+ e.getMessage());
                JOptionPane.showMessageDialog(null, "Erro ao excluir cliente!");
            }finally{
                
                this.conectar.fechaBanco();
                System.out.println("Cliente deletado!");
                JOptionPane.showMessageDialog(null, "Cliente excluido com sucesso!");
            }
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtNomeCad = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtCPfCad = new javax.swing.JFormattedTextField();
        jLabel3 = new javax.swing.JLabel();
        txtIdadeCad = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtEmailCad = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        CmbSexo = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtEndCad = new javax.swing.JTextArea();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtServicosCad = new javax.swing.JTextArea();
        btnCad = new javax.swing.JButton();
        btnLimparCad = new javax.swing.JButton();
        btnVoltarCad = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        txtCPFBuscar = new javax.swing.JFormattedTextField();
        btnBuscar = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        txtNomeBuscar = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtEmailBuscar = new javax.swing.JTextField();
        txtIdadeBuscar = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtSexoBuscar = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtEndBuscaaar = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtServicoBuscar = new javax.swing.JTextField();
        btnAtualziar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnVoltar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(248, 244, 235));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Nome: ");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("CPF: ");

        try {
            txtCPfCad.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Idade:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("E-mail: ");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Sexo:");

        CmbSexo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        CmbSexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-", "Masculino", "Feminino" }));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Endereço:");

        txtEndCad.setColumns(20);
        txtEndCad.setRows(5);
        jScrollPane1.setViewportView(txtEndCad);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Serviços: ");

        txtServicosCad.setColumns(20);
        txtServicosCad.setRows(5);
        jScrollPane2.setViewportView(txtServicosCad);

        btnCad.setBackground(new java.awt.Color(248, 244, 235));
        btnCad.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnCad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/icons8-salvar-16 (1).png"))); // NOI18N
        btnCad.setText("CADASTRAR");
        btnCad.setBorderPainted(false);
        btnCad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadActionPerformed(evt);
            }
        });

        btnLimparCad.setBackground(new java.awt.Color(248, 244, 235));
        btnLimparCad.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnLimparCad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/icons8-apagar-16.png"))); // NOI18N
        btnLimparCad.setText("LIMPAR");
        btnLimparCad.setBorderPainted(false);
        btnLimparCad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparCadActionPerformed(evt);
            }
        });

        btnVoltarCad.setBackground(new java.awt.Color(248, 244, 235));
        btnVoltarCad.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnVoltarCad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/icons8-à-esquerda-dentro-de-um-círculo-16.png"))); // NOI18N
        btnVoltarCad.setText("VOLTAR");
        btnVoltarCad.setBorderPainted(false);
        btnVoltarCad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarCadActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNomeCad)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtCPfCad, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
                                    .addComponent(txtEmailCad))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtIdadeCad)
                                    .addComponent(CmbSexo, 0, 107, Short.MAX_VALUE)))
                            .addComponent(jScrollPane1)
                            .addComponent(jScrollPane2)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnCad, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnLimparCad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(btnVoltarCad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtNomeCad, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtCPfCad, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtIdadeCad))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txtEmailCad, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(CmbSexo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnCad, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                    .addComponent(btnLimparCad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnVoltarCad, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("CADASTRO", jPanel1);

        jPanel2.setBackground(new java.awt.Color(248, 244, 235));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("CPF: ");

        try {
            txtCPFBuscar.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/icons8-binóculos-16 (1).png"))); // NOI18N
        btnBuscar.setText("BUSCAR");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnLimpar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/icons8-apagar-16.png"))); // NOI18N
        btnLimpar.setText("LIMPAR");
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("NOME: ");

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("E-MAIL: ");

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel11.setText("IDADE: ");

        jLabel12.setText("SEXO: ");

        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel13.setText("ENDEREÇO: ");

        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel14.setText("SERVIÇOS: ");

        btnAtualziar.setBackground(new java.awt.Color(248, 244, 235));
        btnAtualziar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnAtualziar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/icons8-actualizar-16 (1).png"))); // NOI18N
        btnAtualziar.setText("ATUALIZAR");
        btnAtualziar.setBorderPainted(false);
        btnAtualziar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtualziarActionPerformed(evt);
            }
        });

        btnExcluir.setBackground(new java.awt.Color(248, 244, 235));
        btnExcluir.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/icons8-lixo-16.png"))); // NOI18N
        btnExcluir.setText("EXCLUIR");
        btnExcluir.setBorderPainted(false);
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        btnVoltar.setBackground(new java.awt.Color(248, 244, 235));
        btnVoltar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnVoltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/icons8-à-esquerda-dentro-de-um-círculo-16.png"))); // NOI18N
        btnVoltar.setText("VOLTAR");
        btnVoltar.setBorderPainted(false);
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtCPFBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 7, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNomeBuscar)
                            .addComponent(txtEmailBuscar)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(txtIdadeBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtSexoBuscar)))
                        .addContainerGap())))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtEndBuscaaar)
                            .addComponent(txtServicoBuscar)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(btnAtualziar, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnExcluir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(btnVoltar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtCPFBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(btnLimpar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtNomeBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtEmailBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtIdadeBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtSexoBuscar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtEndBuscaaar, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtServicoBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnAtualziar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addComponent(btnVoltar, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("CONSULTAR", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadActionPerformed
        Prestador prestador = new Prestador();
        CadastrarPrestador(prestador);
    }//GEN-LAST:event_btnCadActionPerformed

    private void btnLimparCadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparCadActionPerformed
        txtNomeCad.setText("");
        txtEmailCad.setText("");
        txtEndCad.setText("");
        txtIdadeCad.setText("");
        txtServicosCad.setText("");
        txtCPfCad.setText("");
        CmbSexo.setSelectedIndex(0);

    }//GEN-LAST:event_btnLimparCadActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        buscarPrestador(novoPrestador);

    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnAtualziarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualziarActionPerformed
        atualizarPrestador(novoPrestador);
        txtNomeBuscar.setText("");
        txtEndBuscaaar.setText("");
        txtServicoBuscar.setText("");
        txtSexoBuscar.setText("");
        txtIdadeBuscar.setText("");
        txtEmailBuscar.setText("");
        txtCPFBuscar.setText("");
    }//GEN-LAST:event_btnAtualziarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        excluirPrestador(novoPrestador);
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        txtNomeBuscar.setText("");
        txtEndBuscaaar.setText("");
        txtServicoBuscar.setText("");
        txtSexoBuscar.setText("");
        txtIdadeBuscar.setText("");
        txtEmailBuscar.setText("");
        txtCPFBuscar.setText("");
    }//GEN-LAST:event_btnLimparActionPerformed

    private void btnVoltarCadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarCadActionPerformed
        TelaInicial tela2 = new TelaInicial();
        tela2.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnVoltarCadActionPerformed

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        TelaInicial tela2 = new TelaInicial();
        tela2.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnVoltarActionPerformed

    
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
            java.util.logging.Logger.getLogger(CadastroPrestador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroPrestador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroPrestador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroPrestador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastroPrestador().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> CmbSexo;
    private javax.swing.JButton btnAtualziar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCad;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnLimparCad;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JButton btnVoltarCad;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JFormattedTextField txtCPFBuscar;
    private javax.swing.JFormattedTextField txtCPfCad;
    private javax.swing.JTextField txtEmailBuscar;
    private javax.swing.JTextField txtEmailCad;
    private javax.swing.JTextField txtEndBuscaaar;
    private javax.swing.JTextArea txtEndCad;
    private javax.swing.JTextField txtIdadeBuscar;
    private javax.swing.JTextField txtIdadeCad;
    private javax.swing.JTextField txtNomeBuscar;
    private javax.swing.JTextField txtNomeCad;
    private javax.swing.JTextField txtServicoBuscar;
    private javax.swing.JTextArea txtServicosCad;
    private javax.swing.JTextField txtSexoBuscar;
    // End of variables declaration//GEN-END:variables
}
