package ui.core;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.BoxLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.BevelBorder;

public class ListPanel extends JPanel {

    private static final long serialVersionUID = 1L;
    private JPanel fillerPanel;
    private ArrayList<JPanel> panels;

    public ListPanel(List<JPanel> panels, int height) {
        this(panels, height, new Insets(2, 0, 2, 0));
    }

    public ListPanel(List<JPanel> panels, int height, Insets insets) {
        this();
        for (JPanel panel : panels) {
            addPanel(panel, height, insets);
        }
    }

    public ListPanel() {
        super();
        this.fillerPanel = new JPanel();
        this.fillerPanel.setMinimumSize(new Dimension(0, 0));
        this.panels = new ArrayList<JPanel>();
        setLayout(new GridBagLayout());
    }

    public void addPanel(JPanel p, int height) {
        addPanel(p, height, new Insets(5, 0, 5, 0));
    }

    public void addPanel() {
        addPanel(getRandomJPanel(), new Random().nextInt(50) + 50);
    }

    public void addPanel(JPanel p, int height, Insets insets) {
        super.remove(fillerPanel);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = getComponentCount();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.PAGE_START;
        gbc.ipady = height;
        gbc.insets = insets;
        gbc.weightx = 1.0;
        panels.add(p);
        add(p, gbc);
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = getComponentCount();
        gbc.fill = GridBagConstraints.VERTICAL;
        gbc.weighty = 1.0;
        add(fillerPanel, gbc);
        revalidate();
        invalidate();
        repaint();
    }

    public void addPanelHead(JPanel p, int height) {
        addPanelHead(p, height, new Insets(5, 0, 5, 0));
    }

    public void addPanelHead() {
        addPanelHead(getRandomJPanel(), new Random().nextInt(50) + 50);
    }

    public void addPanelHead(JPanel p, int height, Insets insets) {
        super.remove(fillerPanel);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = getComponentCount();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.PAGE_START;
        gbc.ipady = height;
        gbc.insets = insets;
        gbc.weightx = 1.0;
        panels.add(0, p);
        add(p, gbc);
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = getComponentCount();
        gbc.fill = GridBagConstraints.VERTICAL;
        gbc.weighty = 1.0;
        add(fillerPanel, gbc);
        revalidate();
        invalidate();
        repaint();
    }

    public void removeAll() {

        for (int i = 0; i < panels.size(); i++) {
            removePanel(i);
        }

    }

    public void removePanel(JPanel p) {
        removePanel(panels.indexOf(p));
    }

    public void removePanel(int i) {
        super.remove(i);
        panels.remove(i);
        revalidate();
        invalidate();
        repaint();
    }

    public ArrayList<JPanel> getPanels() {
        return this.panels;
    }

    public static void main(String[] args) {
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setMinimumSize(new Dimension(500, 500));
        f.setLocationRelativeTo(null);
        f.getContentPane().setLayout(new BorderLayout());
        final ListPanel listPanel = new ListPanel();
        for (int i = 1; i <= 10; i++) {
            listPanel.addPanel(getRandomJPanel(), new Random().nextInt(50) + 50);
        }
        JButton btnAdd = new JButton("Add");
        btnAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent paramActionEvent) {
                listPanel.addPanel(getRandomJPanel(), new Random().nextInt(50) + 50);
            }
        });
        JButton btnRemove = new JButton("Remove");
        btnRemove.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent paramActionEvent) {
                listPanel.removePanel(0);
            }
        });
        f.getContentPane().add(btnRemove, BorderLayout.NORTH);
        f.getContentPane().add(btnAdd, BorderLayout.SOUTH);
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setViewportView(listPanel);
        f.getContentPane().add(scrollPane, BorderLayout.CENTER);
        f.setVisible(true);
    }

    public static JPanel getRandomJPanel() {
        JPanel panel = new JPanel();
        panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        panel.add(new JLabel("This is a randomly sized JPanel"));
        panel.setBackground(new Color(new Random().nextFloat(), new Random().nextFloat(), new Random().nextFloat()));
        return panel;
    }

    public JPanel getTeacherCoursePanel(String iconPath, String courseName, String courseDescription) {
        JPanel pane = new JPanel();

        JLabel icon = new JLabel();
        JLabel title = new JLabel();
        JLabel description = new JLabel();

        pane.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pane.setPreferredSize(new java.awt.Dimension(0, 27));
        pane.setBackground(Color.white);

        icon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        icon.setIcon(new javax.swing.ImageIcon(getClass().getResource(iconPath)));

        title.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        title.setText(courseName);

        description.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        description.setText(courseDescription);

        javax.swing.GroupLayout MyRecentCourse0Layout = new javax.swing.GroupLayout(pane);
        pane.setLayout(MyRecentCourse0Layout);
        MyRecentCourse0Layout.setHorizontalGroup(MyRecentCourse0Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(MyRecentCourse0Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(icon)
                        .addGroup(MyRecentCourse0Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(MyRecentCourse0Layout.createSequentialGroup()
                                        .addGap(20, 20, 20)
                                        .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                )
                                .addGroup(MyRecentCourse0Layout.createSequentialGroup()
                                        .addGap(20, 20, 20)
                                        .addComponent(description, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                )))
        );
        MyRecentCourse0Layout.setVerticalGroup(MyRecentCourse0Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(MyRecentCourse0Layout.createSequentialGroup()
                        .addGroup(MyRecentCourse0Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(icon, 70, 70, 70)
                                .addGroup(MyRecentCourse0Layout.createSequentialGroup()
                                        .addComponent(title, 45, 45, 45)
                                        .addComponent(description))))
        );
        return pane;
    }

    public JPanel getStudentCoursePanel(String iconPath, String courseName, String courseAuthor, String courseDescription) {
        JPanel pane = new JPanel();

        JLabel icon = new JLabel();
        JLabel title = new JLabel();
        JLabel author = new JLabel();
        JLabel description = new JLabel();

        pane.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pane.setPreferredSize(new java.awt.Dimension(0, 27));
        pane.setBackground(Color.white);

        icon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        icon.setIcon(new javax.swing.ImageIcon(getClass().getResource(iconPath)));

        title.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        title.setText(courseName);

        author.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        author.setText(courseAuthor);

        description.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        description.setText(courseDescription);

        javax.swing.GroupLayout MyRecentCourse0Layout = new javax.swing.GroupLayout(pane);
        pane.setLayout(MyRecentCourse0Layout);
        MyRecentCourse0Layout.setHorizontalGroup(MyRecentCourse0Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(MyRecentCourse0Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(icon)
                        .addGroup(MyRecentCourse0Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(MyRecentCourse0Layout.createSequentialGroup()
                                        .addGap(20, 20, 20)
                                        .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                )
                                .addGroup(MyRecentCourse0Layout.createSequentialGroup()
                                        .addGap(20, 20, 20)
                                        .addComponent(author, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                )
                                .addGroup(MyRecentCourse0Layout.createSequentialGroup()
                                        .addGap(20, 20, 20)
                                        .addComponent(description, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                )))
        );
        MyRecentCourse0Layout.setVerticalGroup(MyRecentCourse0Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(MyRecentCourse0Layout.createSequentialGroup()
                        .addGroup(MyRecentCourse0Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(icon, 75, 75, 75)
                                .addGroup(MyRecentCourse0Layout.createSequentialGroup()
                                        .addComponent(title, 35, 35, 35)
                                        .addComponent(author, 15, 15, 15)
                                        .addComponent(description))))
        );
        return pane;
    }

    public JPanel getLessionPanel(String lessionName, String lessionDescription) {
        JPanel pane = new JPanel();

        JLabel title = new JLabel();
        JLabel description = new JLabel();

        pane.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pane.setPreferredSize(new java.awt.Dimension(0, 27));
        pane.setBackground(Color.white);

        title.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        title.setText(lessionName);

        description.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        description.setText(lessionDescription);

        javax.swing.GroupLayout MyRecentCourse0Layout = new javax.swing.GroupLayout(pane);
        pane.setLayout(MyRecentCourse0Layout);
        MyRecentCourse0Layout.setHorizontalGroup(MyRecentCourse0Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(MyRecentCourse0Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        //                .addComponent(icon)
                        .addGroup(MyRecentCourse0Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(MyRecentCourse0Layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                )
                                .addGroup(MyRecentCourse0Layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(description, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                )))
        );
        MyRecentCourse0Layout.setVerticalGroup(MyRecentCourse0Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(MyRecentCourse0Layout.createSequentialGroup()
                        .addGroup(MyRecentCourse0Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                //                    .addComponent(icon, 70, 70, 70)
                                .addGroup(MyRecentCourse0Layout.createSequentialGroup()
                                        .addComponent(title, 40, 40, 40)
                                        .addComponent(description))))
        );
        return pane;
    }

    public JPanel getParticipantPanel(String iconPath, String username, String fullname) {
        JPanel pane = new JPanel();

        JLabel icon = new JLabel();
        JLabel title = new JLabel();
        JLabel description = new JLabel();
        JLabel delete = new JLabel();

        pane.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pane.setPreferredSize(new java.awt.Dimension(0, 27));
        pane.setBackground(Color.white);

        icon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        icon.setIcon(new javax.swing.ImageIcon(getClass().getResource(iconPath)));

        delete.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        delete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ui/teacher/assets/remove_user.png")));

        title.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        title.setText(username);

        description.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        description.setText(fullname);

        javax.swing.GroupLayout MyRecentCourse0Layout = new javax.swing.GroupLayout(pane);
        pane.setLayout(MyRecentCourse0Layout);
        MyRecentCourse0Layout.setHorizontalGroup(MyRecentCourse0Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(MyRecentCourse0Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(icon)
                        .addGroup(MyRecentCourse0Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(MyRecentCourse0Layout.createSequentialGroup()
                                        .addGap(20, 20, 20)
                                        .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                )
                                .addGroup(MyRecentCourse0Layout.createSequentialGroup()
                                        .addGap(20, 20, 20)
                                        .addComponent(description, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                )
                                .addGroup(MyRecentCourse0Layout.createSequentialGroup()
                                        .addGap(300, 300, 300)
                                        .addComponent(delete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                )
                        ))
        );
        MyRecentCourse0Layout.setVerticalGroup(MyRecentCourse0Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(MyRecentCourse0Layout.createSequentialGroup()
                        .addGroup(MyRecentCourse0Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(icon, 60, 60, 60)
                                .addGroup(MyRecentCourse0Layout.createSequentialGroup()
                                        .addComponent(title, 35, 35, 35)
                                        .addComponent(description)
                                )
                                .addComponent(delete)
                        ))
        );
        return pane;
    }
    
    public JPanel getParticipantPanel_Student(String iconPath, String username, String fullname) {
        JPanel pane = new JPanel();

        JLabel icon = new JLabel();
        JLabel title = new JLabel();
        JLabel description = new JLabel();

        pane.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pane.setPreferredSize(new java.awt.Dimension(0, 27));
        pane.setBackground(Color.white);

        icon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        icon.setIcon(new javax.swing.ImageIcon(getClass().getResource(iconPath)));

        title.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        title.setText(username);

        description.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        description.setText(fullname);

        javax.swing.GroupLayout MyRecentCourse0Layout = new javax.swing.GroupLayout(pane);
        pane.setLayout(MyRecentCourse0Layout);
        MyRecentCourse0Layout.setHorizontalGroup(MyRecentCourse0Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(MyRecentCourse0Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(icon)
                        .addGroup(MyRecentCourse0Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(MyRecentCourse0Layout.createSequentialGroup()
                                        .addGap(20, 20, 20)
                                        .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                )
                                .addGroup(MyRecentCourse0Layout.createSequentialGroup()
                                        .addGap(20, 20, 20)
                                        .addComponent(description, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                )
                        ))
        );
        MyRecentCourse0Layout.setVerticalGroup(MyRecentCourse0Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(MyRecentCourse0Layout.createSequentialGroup()
                        .addGroup(MyRecentCourse0Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(icon, 60, 60, 60)
                                .addGroup(MyRecentCourse0Layout.createSequentialGroup()
                                        .addComponent(title, 35, 35, 35)
                                        .addComponent(description)
                                )
                        ))
        );
        return pane;
    }
}
