// Fig. 12.25: MultipleSelectionFrame.java
// JList that allows multiple selections.
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MultipleSelectionFrame extends JFrame {
   private final JList<String> colorJList; // list to hold color names
   private final JList<String> copyJList; // list to hold copied names
   private final JList<String> copyJList2;
   private JButton copyJButton; // button to copy selected names
   private JButton copyJButton2; // second button to copy names

   private static final String[] colorNames = { "Black", "Blue", "Cyan",
         "Dark Gray", "Gray", "Green", "Light Gray", "Magenta", "Orange",
         "Pink", "Red", "White", "Yellow" };

   // MultipleSelectionFrame constructor
   public MultipleSelectionFrame() {
      super("Multiple Selection Lists");
      setLayout(new FlowLayout());

      colorJList = new JList<>(colorNames); // list of color names
      colorJList.setVisibleRowCount(5); // show five rows
      colorJList.setSelectionMode(
            ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
      add(new JScrollPane(colorJList)); // add list with scrollpane

      copyJButton = new JButton("Copy >>>");
      copyJButton.addActionListener(
            new ActionListener() // anonymous inner class
            {
               // handle button event
               @Override
               public void actionPerformed(ActionEvent event) {
                  // place selected values in copyJList
                  copyJList.setListData(
                        colorJList.getSelectedValuesList().toArray(
                              new String[0]));
               }
            });

      add(copyJButton); // add copy button to JFrame

      copyJButton2 = new JButton("Copy to Second List >>>");
      copyJButton2.addActionListener(
            new ActionListener() // anonymous inner class
            {
               // handle button event
               @Override
               public void actionPerformed(ActionEvent event) {
                  // place selected values in copyJList2
                  copyJList2.setListData(
                        copyJList.getSelectedValuesList().toArray(
                              new String[0]));
               }
            });

      add(copyJButton2); // add second copy button to JFrame

      copyJList = new JList<>(); // list to hold copied color names
      copyJList.setVisibleRowCount(5); // show 5 rows
      copyJList.setFixedCellWidth(100); // set width
      copyJList.setFixedCellHeight(15); // set height
      copyJList.setSelectionMode(
            ListSelectionModel.SINGLE_INTERVAL_SELECTION);
      add(new JScrollPane(copyJList)); // add list with scrollpane

      copyJList2 = new JList<>(); // list to hold copied color names
      copyJList2.setVisibleRowCount(5); // show 5 rows
      copyJList2.setFixedCellWidth(100); // set width
      copyJList2.setFixedCellHeight(15); // set height
      copyJList2.setSelectionMode(
            ListSelectionModel.SINGLE_INTERVAL_SELECTION);
      add(new JScrollPane(copyJList2)); // add list with scrollpane
   }

   public static void main(String[] args) {
      MultipleSelectionFrame frame = new MultipleSelectionFrame();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setSize(400, 300);
      frame.setVisible(true);
   }
}
