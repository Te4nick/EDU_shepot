package ru.midoritroop.layouts;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class MainMenuFrame extends JFrame {
    // --------------COLORS-----------
    Color darkCyan = new Color(66, 122, 171, 134);
    Color lightBlueBtn = new Color(162, 226, 245);
    Color greyCyan = new Color(42, 55, 63);
    Color greyExitButton = new Color(81, 90, 101);
    Color background = new Color(234, 255, 255);
    Color textColor = new Color(0x3d74a6);
    Color btmTopBars = new Color(197, 230, 236);
    //---- GLOBAL ELEMENTS ------
    CardLayout crd;
    JPanel menu, about, review, composition, struct, study, help;
    Container box;

    MainMenuFrame() {
        box = getContentPane();// set up for screens panels containers
        crd = new CardLayout();
        box.setLayout(crd);

        createMenu();//calling constructors of screen panels
        createAbout();
        review = new ReviewFrame(e -> crd.show(box, "menu"));
        composition = new CompositionFrame(e -> crd.show(box, "menu"));
        struct = new StructFrame(e -> crd.show(box, "menu"));
        study = new StudyFrame(e -> crd.show(box, "menu"));
        help = new HelpFrame(e -> crd.show(box, "menu"));

        box.add("menu", menu);//adding elements in container
        box.add("about", about);
        box.add("review", review);
        box.add("composition", composition);
        box.add("struct", struct);
        box.add("study", study);
        box.add("help", help);

        //---------------------------------------------------------------------------

        this.setVisible(true); //set up frame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(1280,720);
        this.setTitle("Edu SHEPOT");

        ImageIcon image = new ImageIcon(".\\assets\\Logo.png");
        this.setIconImage(image.getImage());
    }
    private void createMenu() {
        menu = new JPanel();
        menu.setLayout(null);
        menu.setBackground(background);

        JLabel img = new JLabel();
        img.setBounds(0, 50 ,500, 500);
        menu.add(img);
        ImageIcon unit = new ImageIcon(".\\assets\\shepot.png");
        img.setIcon(unit);
        img.setVerticalAlignment(JLabel.TOP);
        menu.setLayout(null);

        JLabel txt = new JLabel();
        txt.setText("<html>Автоматизированный комплекс<br>для проведения акустических<br>и виброакустических измерений<br>''ШЕПОТ''</html>");
        txt.setForeground(textColor);
        txt.setFont(new Font("Calibri", Font.BOLD, 40 ));
        txt.setBounds(500, 0, 700, 200);
        menu.add(txt);

        JPanel buttons = new JPanel();
        buttons.setBackground(background);
        buttons.setBounds(550, 250, 650, 350);
        menu.add(buttons);
        buttons.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        buttons.setLayout(new GridLayout(3, 3, 10, 10));

        // Creating Review button
        JButton reviewBtn = createMainMenuButton("Обзор", textColor, lightBlueBtn, 25, 10, 280, 90);
        reviewBtn.addActionListener(e -> crd.show(box, "review"));
        buttons.add(reviewBtn);

        // Creating Contents button
        JButton contBtn = createMainMenuButton("Состав", textColor, lightBlueBtn, 345, 10, 280, 90);
        contBtn.addActionListener(e ->  crd.show(box, "composition"));
        buttons.add(contBtn);

        // Creating Learn button
        JButton structBtn = createMainMenuButton("Структура", textColor, lightBlueBtn, 345, 220, 280, 90);
        //exitBtn.addActionListener(e -> super.dispose());
        structBtn.addActionListener(e -> crd.show(box, "struct"));
        buttons.add(structBtn);

        // Creating Help button
        JButton learnBtn = createMainMenuButton("Обучение", textColor, lightBlueBtn, 25, 110, 280, 90);
        learnBtn.addActionListener(e -> crd.show(box, "study")); // TODO: fill w/ proper action
        buttons.add(learnBtn);

        // Creating About button
        JButton aboutBtn = createMainMenuButton("О программе", textColor, lightBlueBtn, 25, 220, 280, 90);
        aboutBtn.addActionListener(e -> crd.show(box, "about"));
        buttons.add(aboutBtn);

        // Creating Exit Button
        JButton helpBtn = createMainMenuButton("Справка", textColor, lightBlueBtn, 345, 110, 280, 90);
        helpBtn.addActionListener(e -> crd.show(box, "help")); // TODO: fill w/ proper action
        buttons.add(helpBtn);

        JButton exitBtn = createMainMenuButton("Выход", greyCyan, greyExitButton, 100, 550, 280, 90);
        exitBtn.addActionListener(e -> super.dispose());
        menu.add(exitBtn);
    }

    private void createAbout() {
        Color LtPurple = new Color(103, 82, 128);
        Color background = new Color(237, 239, 246);
        Color textColor = new Color(0x6e67a0);
        Color btmTopBars = new Color(193, 197, 220);
        about = new JPanel();
        about.setLayout(null);
        about.setBackground(background);

        JPanel topBar = new JPanel();
        topBar.setBounds(0, 0 , 1280, 75);
        topBar.setBackground(btmTopBars);
        about.add(topBar);

        JLabel txt = new JLabel();
        txt.setText("О программе");
        txt.setFont(new Font("Calibri", Font.BOLD, 70 ));
        txt.setHorizontalTextPosition(JLabel.CENTER);
        txt.setForeground(textColor);
        topBar.add(txt);

        JLabel txt2 = new JLabel();
        txt2.setBounds(150, 50,  980,  240);
        txt2.setText("<html>Автоматизированный комплекс для проведения акустических и виброакустических измерений \"ШЕПОТ\"</html>");
        txt2.setFont(new Font("Calibri", Font.BOLD, 40 ));
        txt2.setHorizontalTextPosition(JLabel.CENTER);
        txt2.setForeground(textColor);
        about.add(txt2);

        JLabel txt3 = new JLabel();
        txt3.setBounds(150, 250,  980,  240);
        txt3.setText("<html>Авторские права: Зарубко Мария Владимировна<br>" +
                "Ветров Игорь Анатольевич<br>" +
                "<br>" +
                "Все права защищены.</html>");
        txt3.setFont(new Font("Calibri", Font.BOLD, 35 ));
        txt3.setHorizontalTextPosition(JLabel.CENTER);
        txt3.setForeground(textColor);
        about.add(txt3);

        JPanel btmBar = new JPanel();
        btmBar.setLayout(null);
        btmBar.setBounds(0, 605 , 1280, 75);
        btmBar.setBackground(btmTopBars);
        about.add(btmBar);

        JButton returnToMenu = new JButton();
        returnToMenu.setFocusable(false);
        ImageIcon img = new ImageIcon(".\\assets\\ReturnArrowPRPL.png");
        returnToMenu.setContentAreaFilled(false);
        returnToMenu.setFocusPainted(false);
        returnToMenu.setBorderPainted(false);
        returnToMenu.setBounds(50, 15, 100, 45);
        returnToMenu.setIcon(img);
        returnToMenu.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) { crd.show(box, "menu");

            }
        });
        btmBar.add(returnToMenu);
    }

    private JButton createMainMenuButton(String text, Color foreground, Color background, int x, int y, int width, int height) {
        JButton btn = new JButton(text);
        btn.setFocusable(false);
        btn.setFont(new Font("Calibri", Font.BOLD, 45));
        btn.setForeground(foreground);
        btn.setBounds(x, y, width, height);
        btn.setBackground(background);
        return btn;
    }
}
