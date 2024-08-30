// Fig. 12.21: ComboBoxFrame.java
// JComboBox that displays a list of image names.
import java.awt.FlowLayout;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;     
import javax.swing.JComboBox;
import javax.swing.Icon;
import javax.swing.ImageIcon;


public class ComboBoxFrame extends JFrame //cria classe que herda a classe JFrame
{
   private final JComboBox<String> imagesJComboBox; // cria uma lista de strings para armazenar o nome dos icones
   private final JLabel label; // cria uma variavel para o label

   private static final String[] names = // cria um vetor de strings e insere o nome dos arquivos
      {"bug1.gif", "bug2.gif",  "travelbug.gif", "buganim.gif"};
   private final Icon[] icons = {     //cria um vetor do tipo Icons e cria novos icones de imagem dentro dele
      new ImageIcon(getClass().getResource(names[0])),
      new ImageIcon(getClass().getResource(names[1])), 
      new ImageIcon(getClass().getResource(names[2])),
      new ImageIcon(getClass().getResource(names[3]))};

   
   public ComboBoxFrame() //cria um construtor para ComboBoxFrame
   {
      super("Testing JComboBox"); //define o titulo com uma String
      setLayout(new FlowLayout()); // cria um layout e seta esse layout com o metodo setLayout  

      imagesJComboBox = new JComboBox<String>(names); //  atribui a variavel imagesComboBox uma nova lista de Strings e passa o vetor names de parametro 
      imagesJComboBox.setMaximumRowCount(3); // define o maximo de rows do ComboBox para 3

      imagesJComboBox.addItemListener( //chama um metodo para adcionar o escutador para o ComboBox
         new ItemListener() // cria o escutador
         {
            // handle JComboBox event
            @Override
            public void itemStateChanged(ItemEvent event)// cria um metodo que verifica se o estado do item foi alterado
            {
               // faz a logica de verificação de mudança de estado
               if (event.getStateChange() == ItemEvent.SELECTED)
                  label.setIcon(icons[
                     imagesJComboBox.getSelectedIndex()]);//define a logica para mostrar a imagem icone correspondente ao nome selecionado 
            } 
         } // end anonymous inner class
      ); // end call to addItemListener

      add(imagesJComboBox); // adciona o combobox ao JFrame
      label = new JLabel(icons[0]); // define o primeiro label
      add(label); // adciona ao JFrame
   }
} // end class ComboBoxFrame


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
