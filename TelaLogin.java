import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.FlowLayout;


public class TelaLogin extends JFrame{
    

    private final JLabel lblLogin;
    private final JTextField txtLogin;

    private final JLabel lblSenha;
    private final JPasswordField txtSenha;

    private final JButton btnEntrar;

    private final JLabel lblNotificacoes;

    public TelaLogin()
    {

        super("Tela de Login");
        setLayout(new FlowLayout());

        lblLogin = new JLabel("Login: ");
        txtLogin = new JTextField(10);

        lblSenha = new JLabel("Senha: ");
        txtSenha = new JPasswordField(10);

        btnEntrar = new JButton("Logar");

        lblNotificacoes = new JLabel("Notificações");

        add(lblLogin);
        add(txtLogin);
        add(lblSenha);
        add(txtSenha);
        add(btnEntrar);
        add(lblNotificacoes);

        setSize(200,200);
        setVisible(true);


        MySQLConnector.conectar();

       



    }

   
       
    
    }


