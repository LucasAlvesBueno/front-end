// Fig. 12.6: LabelFrame.java
// JLabels with text and icons.
import java.awt.FlowLayout; // specifies how components are arranged
import javax.swing.JFrame; // provides basic window features
import javax.swing.JLabel; // displays text and images
import javax.swing.SwingConstants; // common constants used with Swing
import javax.swing.Icon; // interface used to manipulate images
import javax.swing.ImageIcon; // loads images

public class LabelFrame extends JFrame //Cria a classe LabelFrame e faz ela herdar a classe JFrame
{
   private final JLabel label1; // cria uma variavel private e final do tipo JLabel e da o nome de label1
   private final JLabel label2; // mesma coisa mas com nome de label2
   private final JLabel label3; // mesma coisa label3 agora;

   
   public LabelFrame() // declara o construtor da classe LabelFrame
   {
      super("Testing JLabel"); // chama o super e passa a String "Testing JLabel"
      setLayout(new FlowLayout()); // chama o metodo setLayout e passa um novo objeto FlowLayout de parametro

      
      label1 = new JLabel("Label with text"); // atribui um novo objeto JLabel com uma string de parametro
      label1.setToolTipText("This is label1"); // chama o metodo setToolTip do label1 e passa uma String de parametro
      add(label1); // adciona o label 1 ao frame q será mostrado

      // Cria a variavel bug e atribui a ela um novo objeto ImageIcon com a imagem bug1.png de paramentro
      Icon bug = new ImageIcon(getClass().getResource("bug1.png"));
      label2 = new JLabel("Label with text and icon", bug, // atribui a variavel label2 um novo objetoJLabel com string,uma variavel e um posicionamento
         SwingConstants.LEFT);
      label2.setToolTipText("This is label2"); // chama o metodo responsavel por exibir uma dica ao passar o mouse e passa uma String de parametro para ser exibida quando isso acontecer
      add(label2); // adciona o label2 ao frame que será exibido

      label3 = new JLabel(); // atribui um novo objeto a label3
      label3.setText("Label with icon and text at bottom");// usa um metodo para definir o texto
      label3.setIcon(bug); // passa bug como parametro do metodo setIcon
      label3.setHorizontalTextPosition(SwingConstants.CENTER);// usa um metodo para ajustar posição do texto usando parametros de posicionamento
      label3.setVerticalTextPosition(SwingConstants.BOTTOM);//mesma coisa passando um metodo de posicionamento diferente
      label3.setToolTipText("This is label3");// usa um metodo para definir uma dica quando o mouse passar por cima
      add(label3); // adiciona label3 ao frame
   } 
} 


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
