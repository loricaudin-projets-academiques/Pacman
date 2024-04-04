package view;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.StartController;

/**
 * 
 */
public class LevelsWindow extends JDialog implements ActionListener {
    
    private JFrame modalWindow;
    /**
     * 
     */
    public LevelsWindow(final JFrame modalWindow) {
        super(modalWindow, "Pacman - Choix du niveau");

        this.modalWindow = modalWindow;

        this.setModal(true);

        this.setSize(700, 500);
        this.setResizable(false);
        this.setLocationRelativeTo(null);

        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

        this.setContentPane(this.createPanel());
    }

    private JPanel panel;
    private JButton buttonStart;
    private JButton buttonCancel;
    private JComboBox comboxBoxLevels;
    
    /**
     * @return JPanel
     */
    private JPanel createPanel() {
        panel = (JPanel) getContentPane();
        panel.setLayout(new FlowLayout());

        JLabel labelSelectLevel = new JLabel("Choix du niveau");
        panel.add(labelSelectLevel);

        comboxBoxLevels = new JComboBox<String>();
        comboxBoxLevels.addItem("Niveau 1");
        comboxBoxLevels.addItem("Niveau 2");

        panel.add(comboxBoxLevels);

        buttonStart = new JButton("Commencer");
        buttonStart.addActionListener(this);
        panel.add(buttonStart);

        buttonCancel = new JButton("Retour");
        buttonCancel.addActionListener(this);
        panel.add(buttonCancel);


        /* Instructions pour créer des widgets */

        return panel;
    }

    @Override
    public void actionPerformed(final ActionEvent e) {
        JButton source = (JButton) e.getSource();
        if (source == buttonStart) {
            int level = 0;
            String selectedLevel = (String) comboxBoxLevels.getSelectedItem();
            if (selectedLevel.equals("Niveau 1")) {
                level = 1;
            }
            modalWindow.dispose();
            StartController controller = new StartController(level);
            controller.control();
        } else {
            this.dispose();
        }
    }
}
