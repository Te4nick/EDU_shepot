package ru.midoritroop.frames;

import ru.midoritroop.RMan;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;

public class HelpFrame extends JPanel {
    private CardLayout crd;
    private Container slideShow;
    private JButton returnToMenu;
    private JPanel firstSlide;
    HelpFrame(ActionListener onReturn){
        crd = new CardLayout();
        createComposition();
        createFirstSlide(); // set up for screens panels containers

        slideShow.add("1", firstSlide);
        crd.show(slideShow, "1");

        returnToMenu.addActionListener(onReturn);
    }
    private JLabel createPanel(int x, int y, int widh, int height){
        JLabel pnl = new JLabel();
        pnl.setBounds(x, y, widh, height);
        pnl.setFont(new Font("Calibri", Font.BOLD, 18));
        pnl.setBackground(RMan.color.background);
        pnl.setForeground(RMan.color.textLilac);
        pnl.setHorizontalAlignment(JLabel.LEFT);
        pnl.setOpaque(true);
        pnl.setBorder(BorderFactory.createLineBorder(RMan.color.lightPurple, 5));
        pnl.setVisible(false);
        return pnl;
    }
    private JPanel createCompSlide() {
        JPanel slide = new JPanel();
        slide.setLayout(null);
        slide.setBackground(Color.BLACK);
        slide.setBounds(0, 0, 1280, 605);
        return slide;
    }
    private JPanel createSlide(String path, String name, boolean SideLayout, int fontsize) {
        JPanel slide = new JPanel();
        slide.setLayout(null);
        slide.setBackground(RMan.color.background);
        slide.setBounds(0, 0, 1280, 605);

        JPanel topBar = new JPanel();
        topBar.setBounds(0, 0, 1280, 75);
        topBar.setBackground(RMan.color.btmTopBars);

        JLabel img = new JLabel();
        ImageIcon unit = new ImageIcon(path);
        Image image = unit.getImage();
        Image newimg;
        if (!SideLayout) {
            img.setBounds(50, 150, 750, 400);
            newimg = image.getScaledInstance(750, 400, java.awt.Image.SCALE_SMOOTH);
        } else {
            img.setBounds(50, 85, 750, 500);
            newimg = image.getScaledInstance(750, 500, java.awt.Image.SCALE_SMOOTH);
        }
        unit = new ImageIcon(newimg);
        img.setVerticalAlignment(JLabel.TOP);
        img.setIcon(unit);
        slide.setLayout(null);
        slide.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int x = e.getX();
                int y = e.getY();
                System.out.println(x + "," + y);
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        slide.add(img);

        JLabel txt = new JLabel();
        txt.setText(name);
        txt.setFont(new Font("Calibri", Font.BOLD, fontsize));
        txt.setHorizontalTextPosition(JLabel.CENTER);
        txt.setForeground(RMan.color.textLilac);
        topBar.add(txt);
        slide.add(topBar);
        slide.repaint();
        return slide;
    }
    private void createComposition() {
        this.setLayout(null);
        slideShow = createCompSlide();
        slideShow.setLayout(crd);
        this.add(slideShow);
        JPanel bottomNavBar = new JPanel();
        bottomNavBar.setLayout(null);
        bottomNavBar.setBounds(0, 605, 1280, 75);
        bottomNavBar.setBackground(RMan.color.btmTopBars);
        this.add(bottomNavBar);

        returnToMenu = new JButton();
        returnToMenu.setFocusable(false);
        ImageIcon img = new ImageIcon(".\\assets\\ReturnArrowPRPL.png");
        returnToMenu.setBounds(50, 15, 100, 45);
        returnToMenu.setIcon(img);
        returnToMenu.setContentAreaFilled(false);
        returnToMenu.setFocusPainted(false);
        returnToMenu.setBorderPainted(false);
        bottomNavBar.add(returnToMenu);
    }
    private void createFirstSlide() {
        firstSlide = createSlide("", "Справка", true, 70);

        JLabel instructions = new JLabel();
        instructions.setBounds(100, 80, 1180, 100);
        instructions.setFont(new Font("Calibri", Font.BOLD, 31));
        instructions.setHorizontalTextPosition(JLabel.CENTER);
        instructions.setForeground(RMan.color.textLilac);
        instructions.setHorizontalAlignment(JLabel.CENTER);
        instructions.setText("<html>Для создания этой программы использовались данные из открытых" +
                " источников, научной литературы, официальных сайтов производителей оборудования.</html>");
        firstSlide.add(instructions);

        JLabel generalInfo = new JLabel();
        generalInfo.setBounds(100, 150, 1180, 250);
        generalInfo.setFont(new Font("Calibri", Font.BOLD, 38));
        generalInfo.setHorizontalTextPosition(JLabel.CENTER);
        generalInfo.setForeground(RMan.color.textLilac);
        generalInfo.setHorizontalAlignment(JLabel.LEFT);
        generalInfo.setText("<html>Литература по автоматизированному" +
                " комплексу для проведения акустических и виброакустических измерений «ШЕПОТ»:</html>");
        firstSlide.add(generalInfo);

        JButton btn = new JButton("<html>Формуляр (PDF rus)</html>");
        btn.setFocusable(false);
        btn.setFont(new Font("Calibri", Font.BOLD, 37));
        btn.setHorizontalAlignment(JButton.CENTER);
        btn.setForeground(RMan.color.textLilac);
        btn.setBounds(20, 350, 400, 130);
        btn.setBackground(RMan.color.btmTopBars);
        btn.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                File file = new File(".\\assets\\f.pdf");
                if (file.toString().endsWith(".pdf")) {
                    try {
                        Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + file);
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                }
                else {
                    Desktop desktop = Desktop.getDesktop();
                    try {
                        desktop.open(file);
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            }
        });
        firstSlide.add(btn);

        JButton btn2 = new JButton("<html>Учебно-методическое пособие (PDF rus)</html>");
        btn2.setFocusable(false);
        btn2.setFont(new Font("Calibri", Font.BOLD, 32));
        btn2.setHorizontalAlignment(JButton.CENTER);
        btn2.setForeground(RMan.color.textLilac);
        btn2.setBounds(440, 350, 400, 130);
        btn2.setBackground(RMan.color.btmTopBars);
        btn2.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                File file = new File(".\\assets\\y.pdf");
                if (file.toString().endsWith(".pdf")) {
                    try {
                        Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + file);
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                }
                else {
                    Desktop desktop = Desktop.getDesktop();
                    try {
                        desktop.open(file);
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            }
        });
        firstSlide.add(btn2);

        JButton btn3 = new JButton("<html>Руководство по эксплуатации измерителя шумовых помех «Larson&Davis 824» (PDF eng)</html>");
        btn3.setFocusable(false);
        btn3.setFont(new Font("Calibri", Font.BOLD, 25));
        btn3.setHorizontalAlignment(JButton.CENTER);
        btn3.setForeground(RMan.color.textLilac);
        btn3.setBounds(860, 350, 400, 130);
        btn3.setBackground(RMan.color.btmTopBars);
        btn3.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                File file = new File(".\\assets\\l.pdf");
                if (file.toString().endsWith(".pdf")) {
                    try {
                        Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + file);
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                }
                else {
                    Desktop desktop = Desktop.getDesktop();
                    try {
                        desktop.open(file);
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            }
        });
        firstSlide.add(btn3);
    }
}

