import java.awt.*;
import java.awt.event.*;   //importa bibliotecas relevantes para o codigo
import javax.swing.*;

public class TelaDeAtualizacao extends JFrame { // cria classe TelaDeAtualizacao e a faz herdar a JFrame
    public static JLabel lblId;
    public static JComboBox<String> cbxId;  
    public static String[] ids;

    public static JLabel lblNome;
    public static JTextField txtNome;
    public static String nomeAtual;

    public static JLabel lblEmail;
    public static JTextField txtEmail;     // cria as variaveis de label e inputs assim como uma JComboBox e uma matriz de String 
    public static String emailAtual;

    public static JLabel lblSenha;
    public static JPasswordField txtSenha;
    public static String senhaAtual;

    public static JLabel lblNotificacoes;

    public static JButton btnAtualizar;
    public static JButton btnCancelar;

    public static int tamanhoInputs = 20;  // cria uma variavel tipo int e atribui o valor 20

    public TelaDeAtualizacao()  // cria o construtor da classe
    {
        super("Tela de Atualização");   // define o titulo da aplicação a ser exibido
        setLayout(new GridLayout(6,1,5,5));  // Define o Layout da aplicação como grid e define a quantidade de linhas colunas e espaçamento 

        JPanel linha_id = new JPanel(new GridLayout(1, 2)); 

        lblId = new JLabel("Id:", SwingConstants.RIGHT); // cria uma nova JLabel 
        linha_id.add(lblId); // adciona a label na aplicação

        NavegadorDeRegistro.popularIds();
        cbxId = new JComboBox(ids); // cria um novo JComboBox e atribui a variavel de matriz criada anteriormente
        linha_id.add(cbxId); // adciona na aplicação

        add(linha_id);

        JPanel linha_nome = new JPanel(new GridLayout(1, 2)); // Cria um JPanel com GridLayout definindo linhas e colunas

        lblNome = new JLabel("Nome:", SwingConstants.RIGHT); // cria uma nova Label 
        linha_nome.add(lblNome); // adciona na aplicação

        txtNome = new JTextField(tamanhoInputs); // cria um JTextField para ser o input do nome 
        linha_nome.add(txtNome); // adciona na aplicação

        add(linha_nome);

        JPanel linha_email = new JPanel(new GridLayout(1, 2)); // cria um nvo JPanel e define sua linhas e colunas com grid layout

        lblEmail = new JLabel("Email:", SwingConstants.RIGHT); // cria nova JLabel 
        linha_email.add(lblEmail); // adciona na aplicação

        txtEmail = new JTextField(tamanhoInputs); // cria novo JTextField para ser input do email
        linha_email.add(txtEmail); // adciona na aplicação

        add(linha_email);

        JPanel linha_senha = new JPanel(new GridLayout(1, 2)); // cria novo JPanel e define suas linhas e colunas com grid layout

        lblSenha = new JLabel("Senha:", SwingConstants.RIGHT); // cria nova label 
        linha_senha.add(lblSenha); // adciona na aplicação

        txtSenha = new JPasswordField(tamanhoInputs); // cria novo JPasswordField para ser o input da senha
        linha_senha.add(txtSenha); // adciona na aplicação

        add(linha_senha);

        JPanel linha_botoes = new JPanel(new GridLayout(1, 2)); // cria novo JPanel para ser a linha dos botoes e define suas linhas e colunas com grid layout

        btnAtualizar = new JButton("Atualizar"); // cria novo JButton com texto atualizar a ser exibido
        linha_botoes.add(btnAtualizar); // adciona na linha dos botoes

        btnCancelar = new JButton("Cancelar"); // cria um novo JButton com o texto cancelar dentro
        linha_botoes.add(btnCancelar);

        add(linha_botoes);

        JPanel linha_notificacoes = new JPanel(new GridLayout(1, 1)); // cria um novo JPanel para exibir notificações

        lblNotificacoes = new JLabel("Notificações", SwingConstants.CENTER); // cria novo JLabel para as notificações 
        linha_notificacoes.add(lblNotificacoes); // adciona na respectiva linha

        add(linha_notificacoes); // adciona na aplicação

        btnAtualizar.addActionListener( // define um escutador para o botao atualizar
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) {
                    NavegadorDeRegistro.atualizarId(); // executa o metodo atualizarId ao clicar no botao
                }
            }
        );

        btnCancelar.addActionListener( // define um escutador para o botao cancelar
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) {
                    NavegadorDeRegistro.limparCampos(); // executa o metodo limparCampos quando o botao é acionado
                }
            }
        );

        cbxId.addItemListener( // define um escutador para o ComboBox 
            new ItemListener() {
            @Override
                public void itemStateChanged(ItemEvent event) { 
                    if (event.getStateChange() == ItemEvent.SELECTED) { // executa o metodo atualizar campos toda vez em que se seleciona um dos intens do ComboBox
                        NavegadorDeRegistro.atualizarCampos(cbxId.getSelectedItem().toString());
                    }
                } 
            }
        );

        setSize(250, 300); // define tamanho e largura da aplicação em pixels
        ImageIcon img = new ImageIcon("./senac-logo.png"); // define o icone da aplicação (eu que dei a ideia kkk)
        setIconImage(img.getImage()); // adciona o icone escolhido
        setVisible(true); // define como visivel
        cbxId.requestFocus();
    }

    public static String setHtmlFormat(String strTexto) { // cria o metodo setHTMLformat
        return "<html><body>" + strTexto + "</body></html>";
    }

    public static void main(String[] args) { // cria a main
        TelaDeAtualizacao appTelaDeAtualizacao = new TelaDeAtualizacao(); // executa a aplicação programada anteriormente
        appTelaDeAtualizacao.setDefaultCloseOperation(EXIT_ON_CLOSE); // define modo de fechamento da aplicação
    }
}
