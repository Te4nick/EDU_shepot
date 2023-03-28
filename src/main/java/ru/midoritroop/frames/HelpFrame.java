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
        crd.show(slideShow, "1");

    }

    private void createFirstSlide() {
        JPanel firstSlide = createSlide("", "Справка", true);

        firstSlide.add(createDesc(RMan.getString("helpFrame", "desc1"),
                31, false, 100, 80, 1180, 100));

        firstSlide.add(createDesc(RMan.getString("helpFrame", "desc2"),
        38, false, 100, 150, 1180, 250));


        firstSlide.add(createPDFButton(RMan.getString("helpFrame", "btn1"), 37,
                RMan.getPath("f.pdf"),20, 350, 400, 130));

        firstSlide.add(createPDFButton(RMan.getString("helpFrame", "btn2"), 32,
                RMan.getPath("y.pdf"),440, 350, 400, 130));

        firstSlide.add(createPDFButton(RMan.getString("helpFrame", "btn3"), 25,
                RMan.getPath("l.pdf"),860, 350, 400, 130));

        slideShow.add("1", firstSlide);
    }

    private JButton createPDFButton(String text, int fontSize, String path, int x, int y, int width, int height) {
        JButton btn = new JButton(text);
        btn.setFocusable(false);
        btn.setFont(new Font("Calibri", Font.BOLD, fontSize));
        btn.setHorizontalAlignment(JButton.CENTER);
        btn.setForeground(RMan.color.textLilac);
        btn.setBounds(x, y, width, height);
        btn.setBackground(RMan.color.btmTopBars);
        btn.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                File file = new File(path);
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
        return btn;
    }
}