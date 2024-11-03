package ui.core;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import static ui.core.ListPanel.getRandomJPanel;

/**
 *
 * @author brian
 */
public class MyListPanel extends JPanel {
    public ListPanel list;
    public JScrollPane scrollPane;
    
    public MyListPanel() {
        list = new ListPanel();
//        list.addPanelHead(list.getParticipantPanel(
//                "/ui/teacher/assets/user_male_0.png",
//                "snowdence",
//                "Tran Minh Duc"
//            ), 40);
        scrollPane = new JScrollPane();
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setViewportView(list);
    }
    
}
