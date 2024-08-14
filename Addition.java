import javax.swing.JOptionPane; //importa a biblioteca javax e seus componentes;
public class Addition //cria a classe Addition
{
   public static void main(String[] args) // cria a classe inicializadora
   {
      
      String firstNumber = //cria uam variavel do tipo string e atribui o metodo showInputDialog com o parametro Enter first integer para ser exibido no input
         JOptionPane.showInputDialog("Enter first integer");
      String secondNumber = // mesma coisa mas criando uma segunda janela
         JOptionPane.showInputDialog("Enter second integer");

      
      int number1 = Integer.parseInt(firstNumber); //cria uma variavel chamada number1 e atribui a ela o valor firstNumber convertido para int por meio do parseInt
      int number2 = Integer.parseInt(secondNumber);//mesma coisa porem convertendo a variavel secondNumber

      int sum = number1 + number2; //cria uma variavel de tipo int e atribui a ela a soma das variaveis number1 e number2

      
      JOptionPane.showMessageDialog(null, "The sum is " + sum, // mostra uma janela que exibe os resultados da soma por meio do metodo showeMessageDialoge (querido professor a pronuncia correta da palavra Dialoge é "Dáialog" e nao "Diálogue" bjss ass:Lucas)
         "Sum of Two Integers", JOptionPane.PLAIN_MESSAGE);
   } 
} 