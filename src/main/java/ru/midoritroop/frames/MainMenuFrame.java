package ru.midoritroop.frames;

import ru.midoritroop.RMan;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class MainMenuFrame extends JFrame {
    //---- GLOBAL ELEMENTS ------
    CardLayout crd;
    JPanel menu, review, composition, struct, study, help;
    Container box;

    String name = this.getClass().getName();

    public MainMenuFrame() {

        box = getContentPane(); // set up for screens panels containers
        crd = new CardLayout();
        box.setLayout(crd);

        RMan.buildStrings(); // building ResourceManager contents

        createMenu(); // calling constructors of screen panels
        struct = new StructFrame(e -> crd.show(box, "menu"));
        help = new HelpFrame(e -> crd.show(box, "menu"));

        box.add("menu", menu); // adding elements in container
        box.add("struct", struct);
        box.add("help", help);

        //---------------------------------------------------------------------------

        this.setVisible(true); //set up frame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(1280,720);
        this.setTitle(RMan.getString("global", "app"));

        ImageIcon image = new ImageIcon(RMan.getPath("Logo.png"));
        this.setIconImage(image.getImage());
    }
    private void createMenu() {
        menu = new JPanel();
        menu.setLayout(null);
        menu.setBackground(RMan.color.background);

        JLabel img = new JLabel();
        img.setBounds(0, 50 ,500, 500);
        menu.add(img);
        ImageIcon unit = new ImageIcon(RMan.getPath("shepot.png"));
        img.setIcon(unit);
        img.setVerticalAlignment(JLabel.CENTER);
        menu.setLayout(null);

        JLabel txt = new JLabel();
        txt.setText(RMan.getString(name, "mainMenuDesc"));
        txt.setForeground(RMan.color.textDarkBlue);
        txt.setFont(new Font("Calibri", Font.BOLD, 40 ));
        txt.setBounds(500, 0, 700, 200);
        menu.add(txt);

        JPanel buttons = new JPanel();
        buttons.setBackground(RMan.color.background);
        buttons.setBounds(550, 250, 650, 350);
        menu.add(buttons);
        buttons.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        buttons.setLayout(new GridLayout(3, 3, 10, 10));

        // Creating Review button
        buttons.add(createMainMenuButton( "review",
                RMan.color.textDarkBlue, RMan.color.lightBlueBtn,
                25, 10, e -> crd.show(box, "review")));
        // Creating Contents button
        buttons.add(createMainMenuButton( "contents",
                RMan.color.textDarkBlue, RMan.color.lightBlueBtn,
                345, 10, e ->  crd.show(box, "contents")));

        // Creating Struct button
        buttons.add(createMainMenuButton( "struct",
                RMan.color.textDarkBlue, RMan.color.lightBlueBtn,
                345, 220, e -> crd.show(box, "struct")));
        // Creating Learn button
        buttons.add(createMainMenuButton("study",
                RMan.color.textDarkBlue, RMan.color.lightBlueBtn,
                25, 110, e -> crd.show(box, "study")));
        // Creating Help button
        buttons.add(createMainMenuButton("help",
                RMan.color.textDarkBlue, RMan.color.lightBlueBtn,
                25, 220, e -> crd.show(box, "help")));
        // Creating Exit Button
        buttons.add(createMainMenuButton("exit",
                RMan.color.greyCyan, RMan.color.greyExitButton,
                345, 110, e -> super.dispose()));
    }

    private JButton createMainMenuButton(String stringId, Color foreground, Color background, int x, int y, ActionListener l) {
        JButton btn = new JButton(RMan.getString(name, stringId));
        btn.setFocusable(false);
        btn.setFont(new Font("Calibri", Font.BOLD, 45));
        btn.setForeground(foreground);
        btn.setBounds(x, y, 280, 90);
        btn.setBackground(background);
        btn.addActionListener(l);
        return btn;
    }
}
