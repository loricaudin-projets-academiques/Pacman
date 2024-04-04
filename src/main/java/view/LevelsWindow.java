package view;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
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

        this.setSize(200, 200);
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
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS)); //Aligner verticalement les widgets
        panel.setAlignmentX(JPanel.CENTER_ALIGNMENT); //Centrer horizontalement

        panel.add(Box.createRigidArea(new Dimension(0, 10))); //Ajouter un espacement

        JLabel labelSelectLevel = new JLabel("Choix du niveau");
        labelSelectLevel.setAlignmentX(CENTER_ALIGNMENT);
        panel.add(labelSelectLevel);

        panel.add(Box.createRigidArea(new Dimension(0, 10))); // Ajouter un espacement

        JPanel panelComboBox = new JPanel();
        panelComboBox.setLayout(new FlowLayout());

        comboxBoxLevels = new JComboBox<String>();
        comboxBoxLevels.addItem("Niveau 1");
        //comboxBoxLevels.addItem("Niveau 2");

        panelComboBox.add(comboxBoxLevels);
        
        panelComboBox.setAlignmentX(CENTER_ALIGNMENT);
        panel.add(panelComboBox);

        panel.add(Box.createRigidArea(new Dimension(0, 10))); // Ajouter un espacement

        buttonStart = new JButton("Commencer");
        buttonStart.addActionListener(this);
        buttonStart.setAlignmentX(CENTER_ALIGNMENT);
        panel.add(buttonStart);

        panel.add(Box.createRigidArea(new Dimension(0, 10))); // Ajouter un espacement

        buttonCancel = new JButton("Retour");
        buttonCancel.addActionListener(this);
        buttonCancel.setAlignmentX(CENTER_ALIGNMENT);
        panel.add(buttonCancel);

        panel.add(Box.createRigidArea(new Dimension(0, 10))); // Ajouter un espacement


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
