package ru.midoritroop.frames;

import ru.midoritroop.RMan;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ReviewFrame extends SlideShowFrame {
    ReviewFrame(ActionListener onReturn) {
        super(onReturn);
        createFirstSlide();

        crd.first(slideShow);
    }
    private void createFirstSlide() {
        JPanel firstSlide = createSlide("slide1Name");

        addImage(firstSlide, "sprut-6ma.png", 75, 75, 500, 500);

        addDesc(firstSlide, "slide1Desc",23,
                false, 585, 75, 600, 550);

        addHitbox(firstSlide, 58, 77, 130, 300,
                "slide1H1",200, 100, 250, 270, "1");
        addHitbox(firstSlide, 410, 250, 127, 210,
                "slide1H2",150, 115, 250, 450, "1");
        addHitbox(firstSlide, 200, 285, 200, 540 - 288,
                "slide1H3",200, 80, 250, 200, "1");
        addHitbox(firstSlide, 100, 380, 100, 100,
                "slide1H4",200, 200, 250, 340, "1");
        addHitbox(firstSlide, 402, 460, 58, 67,
                "slide1H5",150, 200, 250, 350, "1");
        addHitbox(firstSlide, 477, 471, 100, 100,
                "slide1H6",180, 160, 250, 430, "1");
        addHitbox(firstSlide, 120, 485, 55, 50,
                "slide1H7",200, 300, 250, 280, "1");
        slideShow.add("1", firstSlide);
    }
}