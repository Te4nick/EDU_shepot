package ru.midoritroop.frames;

import ru.midoritroop.RMan;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.AbstractAction;

import java.awt.Font;
import java.awt.Desktop;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.io.File;
import java.io.IOException;

public class HelpFrame extends SlideShowFrame {

    HelpFrame(ActionListener onReturn) {
        super(onReturn);
        createFirstSlide(); // set up for screens panels containers
        crd.first(slideShow);
        System.out.println(name);
    }

    private void createFirstSlide() {
        JPanel firstSlide = createSlide("slide1Name");
        addDesc(firstSlide, "desc1", 31,
                false, 100, 80, 1180, 100);
        addDesc(firstSlide, "desc2", 38,
                false, 100, 150, 1180, 250);
        addPDFButton(firstSlide,"btn1", 37,
                "f.pdf",20);
        addPDFButton( firstSlide,"btn2", 32,
                "y.pdf",440);
        addPDFButton(firstSlide,"btn3", 25,
                "l.pdf",860);
        slideShow.add("1", firstSlide);
    }

    private void addPDFButton(JPanel parent, String stringId, int fontSize, String filename, int x) {
        JButton btn = new JButton(RMan.getString(name, stringId));
        btn.setFocusable(false);
        btn.setFont(new Font("Calibri", Font.BOLD, fontSize));
        btn.setHorizontalAlignment(JButton.CENTER);
        btn.setForeground(RMan.color.textLilac);
        btn.setBounds(x, 350, 400, 130);
        btn.setBackground(RMan.color.btmTopBars);
        btn.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    File file = new File(RMan.getPath(filename));
                    if (file.exists() && Desktop.isDesktopSupported()) {
                        Desktop.getDesktop().open(file);
                    }
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        parent.add(btn);
    }
}