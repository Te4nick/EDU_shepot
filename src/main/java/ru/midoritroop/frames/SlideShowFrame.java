package ru.midoritroop.frames;

import ru.midoritroop.RMan;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class SlideShowFrame extends JPanel {
    private final CardLayout crd = new CardLayout();
    private Container slideShow;
    private JPanel firstSlide, secondSlide, thirdSlide, fourthSlide, fifthSlide;

    SlideShowFrame(ActionListener onReturn) {
        createComposition(onReturn);

        slideShow.add("1", firstSlide);
        slideShow.add("2", secondSlide);
        slideShow.add("3", thirdSlide);
        slideShow.add("4", fourthSlide);
        slideShow.add("5", fifthSlide);
        crd.show(slideShow, "1");
    }

    private JLabel createPanel(int x, int y, int width, int height) {
        JLabel pnl = new JLabel();
        pnl.setBounds(x, y, width, height);
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

    private JPanel createSlide(String path, String name, boolean SideLayout) {
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
        txt.setFont(new Font("Calibri", Font.BOLD, 70));
        txt.setHorizontalTextPosition(JLabel.CENTER);
        txt.setForeground(RMan.color.textLilac);
        topBar.add(txt);
        slide.add(topBar);
        slide.repaint();
        return slide;
    }

    private JButton createButton(String path, int x, int y, int width, int height, ActionListener e) {
        JButton button = new JButton(new ImageIcon(path));
        button.setBounds(x, y, width, height);
        button.addActionListener(e);
        button.setFocusable(false);
        button.setContentAreaFilled(false);
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        return button;
    }

    private void createComposition(ActionListener listener) {
        this.setLayout(null);
        slideShow = createCompSlide();
        slideShow.setLayout(crd);
        this.add(slideShow);
        JPanel bottomNavBar = new JPanel();
        bottomNavBar.setLayout(null);
        bottomNavBar.setBounds(0, 605, 1280, 75);
        bottomNavBar.setBackground(RMan.color.btmTopBars);
        this.add(bottomNavBar);
        // Return Button
        bottomNavBar.add(createButton(RMan.getPath("ArrowReturnPRPL.png"),
                50, 15, 100, 45, listener));
        // Next Button
        bottomNavBar.add(createButton(RMan.getPath("ArrowNextPRPL.png"),
                680, 5, 65, 65, e -> crd.next(slideShow)));
        // Back Button
        bottomNavBar.add(createButton(RMan.getPath("ArrowBackPRPL.png"),
                550, 5, 65, 65, e -> crd.previous(slideShow)));

    }

    private JLabel createDesc(String text, int x, int y, int width, int height) {
        JLabel instructions = new JLabel();
        instructions.setBounds(x, y, width, height);
        instructions.setFont(new Font("Calibri", Font.BOLD, 28));
        instructions.setHorizontalTextPosition(JLabel.CENTER);
        instructions.setForeground(RMan.color.textLilac);
        instructions.setHorizontalAlignment(JLabel.CENTER);
        instructions.setText(text);
        return instructions;
    }

    private void addHitbox(JPanel parent, int boxX, int boxY, int boxWidth, int boxHeight,
                           String text, int textX, int textY, int textWidth, int textHeight, String slide) {
        JLabel label = createPanel(textX, textY, textWidth, textHeight);
        label.setText(text);
        JLabel hitbox = new JLabel();
        hitbox.setBounds(boxX, boxY, boxWidth, boxHeight);
        hitbox.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
                crd.show(slideShow, slide);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                label.setVisible(true);
                label.updateUI();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                label.setVisible(false);
            }
        });
        parent.add(label);
        parent.add(hitbox);
    }
}