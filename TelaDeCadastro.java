import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class TelaDeCadastro extends JFrame //cria classe TelaDeCadastro e a faz herdar JFrame
{
    private final JLabel lblNome;
    private final JTextField txtNome;  

    private final JLabel lblEmail;
    private final JTextField txtEmail;

    private final JLabel lblSenha;         //cria variaveis para armazenar as labels e text field
    private final JPasswordField txtSenha;

    private final JButton btnCadastrar;

    private final JLabel lblNotificacoes;

    public TelaDeCadastro() //cria o construtor da classe TelaDeCadastro
    {
        super("Tela de Cadastro");
        setLayout(new GridLayout(4,2,5,5));

        lblNome = new JLabel("Nome:");
        add(lblNome);

        txtNome = new JTextField(10);
        add(txtNome);

        lblEmail = new JLabel("Email:");     //atribui as variaveis objetos novos JLabel,JTextField e JButton e os adciona a aplicação
        add(lblEmail);

        txtEmail = new JTextField(10);
        add(txtEmail);

        lblSenha = new JLabel("Senha:");
        add(lblSenha);

        txtSenha = new JPasswordField(10);
        add(txtSenha);

        btnCadastrar = new JButton("Cadastrar");
        add(btnCadastrar);

        lblNotificacoes = new JLabel("Notificações", SwingConstants.CENTER); // define o posicionamento
        add(lblNotificacoes);

        btnCadastrar.addActionListener( // cria um escutador para o botao de cadastro
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) {
                    if (txtNome.getText().trim().length() <= 0) {
                        lblNotificacoes.setText(setHtmlFormat("É necessário digitar um Nome para o cadastro. Por favor, digite um nome e tente novamente.")); // define condicional para caso o input do nome for menor ou igual a zero quando o botao de cadastro for ativado
                        txtNome.requestFocus(); 
                        return;
                    }

                    if (txtEmail.getText().trim().length() <= 0) {
                        lblNotificacoes.setText(setHtmlFormat("É necessário digitar um Email para o cadastro. Por favor, digite um Email e tente novamente.")); // define condicional para caso o input do email for menor ou igual a zero quando o botao de cadastro for ativado
                        txtEmail.requestFocus();
                        return;
                    }

                    if (String.valueOf(txtSenha.getPassword()).trim().length() <= 0) {
                        lblNotificacoes.setText(setHtmlFormat("É necessário digitar uma Senha para o cadastro. Por favor, digite uma Senha e tente novamente.")); //define condicional para caso o input da senha for menor ou igual a zero quando o botao de cadastro for ativado
                        txtSenha.requestFocus();
                        return;
                    }

                    try {
                        Connection conexao = MySQLConnector.conectar();
                        String strSqlEmail = "select * from `db_senac`.`tbl_senac` where `email` = '" + txtEmail.getText() + "';"; //executa um comando sql que verifica se o email contido no input existe no banco de dados quando o botao de cadastro for pressionado
                        Statement stmSqlEmail = conexao.createStatement();
                        ResultSet rstSqlEmail = stmSqlEmail.executeQuery(strSqlEmail);
                        if (rstSqlEmail.next()) {
                            lblNotificacoes.setText(setHtmlFormat("Ops! Já existe um usuário utilizando este email. Por favor, digite outro email e tente novamente.")); //se esse comando ja existir exibe mensagem de aviso para usuario
                        } else {
                            lblNotificacoes.setText(setHtmlFormat("Login liberado para cadastro.")); // caso nao exista uma mensagem é exibida para o usuario
                            String strSqlCadastrar = "insert into `db_senac`.`tbl_senac` (`nome`, `email`, `senha`) values ('" + txtNome.getText() + "', '" + txtEmail.getText() + "', '" + String.valueOf(txtSenha.getPassword()) + "');"; //cria um comando sql que insere o conteudo dos inputs no banco de dados
                            // System.out.println(strSqlCadastrar);
                            Statement stmSqlCadastrar = conexao.createStatement(); //cria uma statment e atribui a uma variavel tipo statment
                            stmSqlCadastrar.addBatch(strSqlCadastrar); //adciona a lista de execução
                            stmSqlCadastrar.executeBatch(); //executa
                            lblNotificacoes.setText(setHtmlFormat("Cadastro realizado com sucesso")); // exibe notificação de sucesso de cadastro
                        }
                        stmSqlEmail.close();
                    } catch (Exception e) {
                        lblNotificacoes.setText(setHtmlFormat("Não foi possível prosseguir com o cadastro! Por favor, verifique e tente novamente.")); //configura comando para capturar exceção e configura mensagem de erro sa ser exibida e imprime erro 
                        System.err.println("Erro: " + e);
                    }
                }
            }
        );

        setSize(250, 600); //configura o tamanho da aplicação e a torna visivel
        setVisible(true);
    }

    private String setHtmlFormat(String strTexto) {
        return "<html><body>" + strTexto + "</body></html>"; // cria o metodo que retorna um comando estilo Html contengo tag body
    }

    public static void main(String[] args) { //cria metodo excecutor
        TelaDeCadastro appTelaDeCadastro = new TelaDeCadastro();   //cria variavel appTelaDeCadastro do tipo TelaDeCadastro e atribui um novo objeto TelaDeCadastro
        appTelaDeCadastro.setDefaultCloseOperation(EXIT_ON_CLOSE);  // configura o encerramento da aplicação ao clicar no x;
    }
}
