package ru.midoritroop.frames;

import ru.midoritroop.RMan;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class SlideShowFrame extends JPanel {
    protected CardLayout crd;
    protected Container slideShow;

    protected String name;

    SlideShowFrame(ActionListener onReturn) {
        this.crd = new CardLayout();
        this.name = this.getClass().getName();
        createComposition(onReturn);
    }

    protected JLabel addDesc(JPanel parent, String stringId, int fontSize, boolean border, int x, int y, int width, int height) {
        JLabel desc = new JLabel();
        desc.setBounds(x, y, width, height);
        desc.setFont(new Font("Calibri", Font.BOLD, fontSize));
        desc.setHorizontalTextPosition(JLabel.CENTER);
        desc.setForeground(RMan.color.textLilac);
        desc.setHorizontalAlignment(border ? JLabel.LEFT : JLabel.CENTER);
        desc.setText(RMan.getString(name, stringId));
        if (border) {
            desc.setOpaque(true);
            desc.setBorder(BorderFactory.createLineBorder(RMan.color.lightPurple, 5));
            desc.setVisible(false);
        }
        parent.add(stringId, desc);
        return desc;
    }

    private JPanel createBlankSlide() {
        JPanel slide = new JPanel();
        slide.setLayout(null);
        slide.setBackground(Color.BLACK);
        slide.setBounds(0, 0, 1280, 605);
        return slide;
    }

    protected JPanel createSlide(String name) {
        JPanel slide = new JPanel();
        slide.setLayout(null);
        slide.setBackground(RMan.color.background);
        slide.setBounds(0, 0, 1280, 605);

        JPanel topBar = new JPanel();
        topBar.setBounds(0, 0, 1280, 75);
        topBar.setBackground(RMan.color.btmTopBars);

        slide.setLayout(null);
        slide.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int x = e.getX();
                int y = e.getY();
                System.out.println(x + "," + y);
            }
            @Override
            public void mousePressed(MouseEvent e) {}
            @Override
            public void mouseReleased(MouseEvent e) {}
            @Override
            public void mouseEntered(MouseEvent e) {}
            @Override
            public void mouseExited(MouseEvent e) {}
        });
        JLabel txt = new JLabel();
        txt.setText(RMan.getString(this.name, name));
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
        slideShow = createBlankSlide();
        slideShow.setLayout(crd);
        this.add(slideShow);
        JPanel bottomNavBar = new JPanel();
        bottomNavBar.setLayout(null);
        bottomNavBar.setBounds(0, 605, 1280, 75);
        bottomNavBar.setBackground(RMan.color.btmTopBars);
        this.add(bottomNavBar);
        // Return Button
        bottomNavBar.add("arrowReturn", createButton(RMan.getPath("ArrowReturnPRPL.png"),
                50, 15, 100, 45, listener));
        // Next Button
        bottomNavBar.add("arrowNext", createButton(RMan.getPath("ArrowNextPRPL.png"),
                680, 5, 65, 65, e -> crd.next(slideShow)));
        // Back Button
        bottomNavBar.add("arrowBack", createButton(RMan.getPath("ArrowBackPRPL.png"),
                550, 5, 65, 65, e -> crd.previous(slideShow)));
    }

    protected void addImage(JPanel parent, String filename, int x, int y, int width, int height) {
        JLabel img = new JLabel();
        ImageIcon unit = new ImageIcon(RMan.getPath(filename));
        Image image = unit.getImage();
        Image newImg;
        img.setBounds(x, y, width, height);
        newImg = image.getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH);
        unit = new ImageIcon(newImg);
        img.setVerticalAlignment(JLabel.TOP);
        img.setIcon(unit);
        parent.add(img);
    }
    protected void addHitbox(JPanel parent, int boxX, int boxY, int boxWidth, int boxHeight,
                           String stringId, int textX, int textY, int textWidth, int textHeight, String slide) {
        JLabel label = addDesc(parent, stringId, 18, true, textX, textY, textWidth, textHeight);
        JLabel hitbox = new JLabel();
        hitbox.setBounds(boxX, boxY, boxWidth, boxHeight);
        hitbox.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {}
            @Override
            public void mousePressed(MouseEvent e) { crd.show(slideShow, slide); }
            @Override
            public void mouseReleased(MouseEvent e) {}
            @Override
            public void mouseEntered(MouseEvent e) {
                label.setVisible(true);
                label.updateUI();
            }
            @Override
            public void mouseExited(MouseEvent e) { label.setVisible(false); }
        });
        parent.add(hitbox);
    }
}