package view;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class LevelsWindow extends JDialog implements ActionListener {
    
    private JFrame modalWindow;
    /**
     * 
     */
    public LevelsWindow(JFrame modalWindow) {
        super(modalWindow, "Pacman - Choix du niveau");

        this.modalWindow = modalWindow;

        this.setSize(700, 500);
        this.setResizable(false);
        this.setLocationRelativeTo(null);

        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

        this.setContentPane(this.createPanel());
    }

    private JPanel panel;
    private JButton buttonStart;
    private JButton buttonCancel;
    
    /**
     * @return JPanel
     */
    private JPanel createPanel() {
        panel = (JPanel) getContentPane();
        panel.setLayout(new FlowLayout());

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
    public void actionPerformed(ActionEvent e) {
        JButton source = (JButton) e.getSource();
        if (source == buttonStart) {
            modalWindow.dispose();
            Labyrinthe labyrinthe = new Labyrinthe();
            labyrinthe.setVisible(true);
        } else {
            this.dispose();
        }
    }
}
