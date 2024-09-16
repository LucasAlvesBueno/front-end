import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;


public class TelaLogin extends JFrame{
    

    private final JLabel lblNome;
    private final JTextField txtNome;

    private final JLabel lblEmail;
    private final JTextField txtEmail;

    private final JLabel lblSenha;
    private final JPasswordField txtSenha;

    private final JButton btnEntrar;

    private final JLabel lblNotificacoes;

    public TelaLogin()
    {

        super("Tela de Login");
        setLayout(new GridLayout(4,2,5,5));

        lblNome = new JLabel("Nome: ");
        txtNome = new JTextField(5);

        lblEmail = new JLabel("Email: ");
        txtEmail = new JTextField(5);

        lblSenha = new JLabel("Senha: ");
        txtSenha = new JPasswordField(5);

        btnEntrar = new JButton("Cadastrar");

        lblNotificacoes = new JLabel("Notificações");

        add(lblNome);
        add(txtNome);
        add(lblEmail);
        add(txtEmail);
        add(lblSenha);
        add(txtSenha);
        add(btnEntrar);
        add(lblNotificacoes);

        setSize(200,200);
        setVisible(true);


        MySQLConnector.conectar();

       



    }

   
       
    
    }

