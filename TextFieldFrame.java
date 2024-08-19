
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;// importa um monte de coisa necessaria pra aplicação
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JOptionPane;

public class TextFieldFrame extends JFrame // cria a classe TextFieldFrame e faz ela herdar JFrame por meio do extends
{
   private final JTextField textField1; // cria uma variavel privada e final chamada textField1 do tipo JTextField1
   private final JTextField textField2; // mesma coisa só que textField2
   private final JTextField textField3; // mesma coisa só que textField3
   private final JPasswordField passwordField; //cria uma variavel private e final do tipo JPasswordField com o nome de passwordField 

   // declara o construtor de TextFieldFrame
   public TextFieldFrame()
   {
      super("Testing JTextField and JPasswordField");// chama o super passando uma String como argumento
      setLayout(new FlowLayout()); // chama um metodo para definir layout e passa um novo objeto FlowLayout como argumento

      // cria uma variavel e atribui o objeto criado JTextField com o paramentro de colunas 10
      textField1 = new JTextField(10); 
      add(textField1); //adiciona textField ao frame  

      // atribui o objeto JytextField a variavel textField2. O objeto tem uma string como parametro
      textField2 = new JTextField("Enter your text here now");
      add(textField2); // adciona textField2 ao frame

      // atribui um novo objeto JTextField com uma string e um numero de colunas como parameto a variavel textField3
      textField3 = new JTextField("Uneditable text field", 21); 
      textField3.setEditable(false); // chama um metodo para textfield e passa um booleane false como parametro
      add(textField3); // add textField3 to JFrame

      //define a variavel passwordField com um novo objeto JPassordField com o parametro String
      passwordField = new JPasswordField("Hidden text");
      add(passwordField); // adciona passwordField ao frame

      // cria a variavel handler do tipo TextFieldHandler e atribui um novo objeto TextFieldhandler();
      TextFieldHandler handler = new TextFieldHandler();
      textField1.addActionListener(handler);
      textField2.addActionListener(handler);     //Chama o metodo addActionListener com o parametro handler para
      textField3.addActionListener(handler);    // textField 1,2,3 e passwordField
      passwordField.addActionListener(handler);
   } // end TextFieldFrame constructor

   // cria uma classe private chamada TextFieldHandler e implementa a interface ActionListener
   private class TextFieldHandler implements ActionListener 
   {
      
      @Override
      public void actionPerformed(ActionEvent event) // usa o metodo da interface com um parametro do tipo Action event
      {
         String string = ""; // cria uma variavel do tipo String e atribui uma String vazia a ela
         // user pressed Enter in JTextField textField1
         if (event.getSource() == textField1)// cria um if else e passa uma condição
            string = String.format("textField1: %s", // se a condição for atendidida atribui a string uma String formatada
               event.getActionCommand());

         // user pressed Enter in JTextField textField2
         else if (event.getSource() == textField2) //caso a condição ininical nao for atendida repete o if e cria uma nova condição
            string = String.format("textField2: %s", //se a condição fo atendida a string ganha outra String formatada 
               event.getActionCommand());

         // user pressed Enter in JTextField textField3
         else if (event.getSource() == textField3)
            string = String.format("textField3: %s", 
               event.getActionCommand());

         // user pressed Enter in JTextField passwordField
         else if (event.getSource() == passwordField)
            string = String.format("passwordField: %s", 
               event.getActionCommand());

         // display JTextField content
         JOptionPane.showMessageDialog(null, string); 
      } 
   } // end private inner class TextFieldHandler
} // end class TextFieldFrame

/**************************************************************************
 * (C) Copyright 1992-2014 by Deitel & Associates, Inc. and               *
 * Pearson Education, Inc. All Rights Reserved.                           *
 *                                                                        *
 * DISCLAIMER: The authors and publisher of this book have used their     *
 * best efforts in preparing the book. These efforts include the          *
 * development, research, and testing of the theories and programs        *
 * to determine their effectiveness. The authors and publisher make       *
 * no warranty of any kind, expressed or implied, with regard to these    *
 * programs or to the documentation contained in these books. The authors *
 * and publisher shall not be liable in any event for incidental or       *
 * consequential damages in connection with, or arising out of, the       *
 * furnishing, performance, or use of these programs.                     *
 *************************************************************************/
