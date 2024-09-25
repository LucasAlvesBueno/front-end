import java.awt.*;
import java.awt.event.*;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.ResultSet;

import javax.swing.*;

public class TelaDeAtualizacao extends JFrame {
    public static JLabel lblId;
    public static JComboBox<String> cbxId;
    public static String[] ids;

    public static JLabel lblNome;
    public static JTextField txtNome;

    public static JLabel lblEmail;
    public static JTextField txtEmail;

    public static JLabel lblSenha;
    public static JPasswordField txtSenha;

    public static JLabel lblNotificacoes;

    public static JButton btnAtualizar;
    public static JButton btnCancelar;

    public static int tamanhoInputs = 20;

    public TelaDeAtualizacao()
    {
        super("Tela de Atualização");
        setLayout(new GridLayout(6,1,5,5));

        JPanel linha_id = new JPanel(new GridLayout(1, 2));

        lblId = new JLabel("Id:", SwingConstants.RIGHT);
        linha_id.add(lblId);

        NavegadorDeRegistro.popularIds();
        cbxId = new JComboBox(ids);
        linha_id.add(cbxId);

        add(linha_id);

        JPanel linha_nome = new JPanel(new GridLayout(1, 2));

        lblNome = new JLabel("Nome:", SwingConstants.RIGHT);
        linha_nome.add(lblNome);

        txtNome = new JTextField(tamanhoInputs);
        linha_nome.add(txtNome);

        add(linha_nome);

        JPanel linha_email = new JPanel(new GridLayout(1, 2));

        lblEmail = new JLabel("Email:", SwingConstants.RIGHT);
        linha_email.add(lblEmail);

        txtEmail = new JTextField(tamanhoInputs);
        linha_email.add(txtEmail);

        add(linha_email);

        JPanel linha_senha = new JPanel(new GridLayout(1, 2));

        lblSenha = new JLabel("Senha:", SwingConstants.RIGHT);
        linha_senha.add(lblSenha);

        txtSenha = new JPasswordField(tamanhoInputs);
        linha_senha.add(txtSenha);

        add(linha_senha);

        JPanel linha_botoes = new JPanel(new GridLayout(1, 2));

        btnAtualizar = new JButton("Atualizar");
        linha_botoes.add(btnAtualizar);

        btnCancelar = new JButton("Cancelar");
        linha_botoes.add(btnCancelar);

        add(linha_botoes);

        JPanel linha_notificacoes = new JPanel(new GridLayout(1, 1));

        lblNotificacoes = new JLabel("Notificações", SwingConstants.CENTER);
        linha_notificacoes.add(lblNotificacoes);

        add(linha_notificacoes);

        btnAtualizar.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) {
                    
                }
            }
        );

        btnCancelar.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) {
                    //...
                }
            }
        );

        cbxId.addItemListener(
            new ItemListener() {
            @Override
                public void itemStateChanged(ItemEvent event) {
                    if (event.getStateChange() == ItemEvent.SELECTED) {
                        System.out.println("Teste");

                        try{
                            Connection conexao = MySQLConnector.conectar();
                            String strSqlPesquisa = "SELECT * FROM `db_senac`.`tbl_senac` WHERE `id` = " + cbxId.getSelectedItem() + ";";
                            java.sql.Statement stmSqlPesquisa = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                            ResultSet rstSqlPesquisa = stmSqlPesquisa.executeQuery(strSqlPesquisa);
                            if (rstSqlPesquisa.next()) {

                                txtNome.setText((rstSqlPesquisa.getString("nome")));

                            }else{

                                lblNotificacoes.setText((setHtmlFormat("Poxa vida nao encontrou nada e bla bla bla tenta denovo ai")));

                            }
                        }catch(Exception e) {

                            lblNotificacoes.setText((setHtmlFormat("Erro: " + e.getMessage())));
                        }
                            
                        
                    }
                } 
            }
        );

        



        setSize(250, 300);
        ImageIcon img = new ImageIcon("./senac-logo.png");
        setIconImage(img.getImage());
        setVisible(true);
        cbxId.requestFocus();
    }

    public static String setHtmlFormat(String strTexto) {
        return "<html><body>" + strTexto + "</body></html>";
    }

    public static void main(String[] args) {
        TelaDeAtualizacao appTelaDePesquisa = new TelaDeAtualizacao();
        appTelaDePesquisa.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
