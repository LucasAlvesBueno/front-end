// Fig. 12.7: LabelTest.java
// Testing LabelFrame.
import javax.swing.JFrame;

public class LabelTest // cria classe LabelTest
{
   public static void main(String[] args)// cria inicializador
   { 
      LabelFrame labelFrame = new LabelFrame(); // cria um novo objeto e atribui ele a variavel labelFrame do tipo labelFrame 
      labelFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// chama um metodo para ajustar o encerramento da operação 
      labelFrame.setSize(760, 780);// ajusta o tamanho da janela passando largura e altura
      labelFrame.setVisible(true); // usa um metodo para deixar o frame visivel usando um paramentro booleano
   } 
} // end class LabelTest


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
