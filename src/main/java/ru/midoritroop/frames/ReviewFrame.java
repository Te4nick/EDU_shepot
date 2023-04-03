package ru.midoritroop.frames;

import javax.swing.*;
import java.awt.event.ActionListener;

public class ReviewFrame extends SlideShowFrame {
    ReviewFrame(ActionListener onReturn) {
        super(onReturn);
        createFirstSlide();
        createSecondSlide();
        createThirdSlide();
        createFourthSlide();

        crd.first(slideShow);
    }
    private void createFirstSlide() {
        JPanel firstSlide = createSlide("slide1Name");

        addImage(firstSlide, "Sprut-6ma.png", 75, 75, 500, 500);

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

    private void createSecondSlide() {
        JPanel secondSlide = createSlide("slide2Name");

        addImage(secondSlide, "Sprut-7A.png", 75, 75, 700, 500);

        addDesc(secondSlide, "slide2Desc",20,
                false, 775, 75, 420, 500);

        addHitbox(secondSlide, 85,122,152-85,443-122,
                "slide2H1",170, 80, 350, 420, "2");
        addHitbox(secondSlide, 152,135,325-152,365-135,
                "slide2H2",350, 100, 250,400, "2");
        addHitbox(secondSlide, 332,168,543-332,433-168,
                "slide2H3",50, 100, 250, 300, "2");
        addHitbox(secondSlide, 597,147,754-597,313-147,
                "slide2H4",300, 100, 250, 500, "2");
        addHitbox(secondSlide, 594,309,727-594,410-309,
                "slide2H5",300, 200, 250, 300, "2");
        addHitbox(secondSlide, 639,410,725-639,483-410,
                "slide2H6",270, 150, 350, 450, "2");
        addHitbox(secondSlide, 543,426,611-543,482-426,
                "slide2H7",250, 200,250, 360, "2");
        addHitbox(secondSlide, 581,487,657-581,539-487,
                "slide2H8",250,200, 250, 330, "2");
        slideShow.add("2", secondSlide);
    }

    private void createThirdSlide() {
        JPanel thirdSlide = createSlide("slide3Name");

        addImage(thirdSlide, "Calibri.png", -40, 80, 820, 500);

        addDesc(thirdSlide, "slide3Desc",25,
                false, 775, 75, 400, 500);

        addHitbox(thirdSlide, 5, 203, 159-5, 376-203,
                "slide3H1",180, 100, 300, 350, "3");
        addHitbox(thirdSlide, 60, 383, 212-60, 533-383,
                "slide3H2",20, 100, 250, 250, "3");
        addHitbox(thirdSlide, 161, 121, 413-161, 493-121,
                "slide3H3",420, 80, 350, 490, "3");
        addHitbox(thirdSlide, 374, 337, 533-374, 408-337,
                "slide3H4",30, 100, 350, 490, "3");
        addHitbox(thirdSlide, 356, 406, 678-356, 469-406,
                "slide3H5",100, 100, 250, 480, "3");
        addHitbox(thirdSlide, 436, 121, 618-436, 403-121,
                "slide3H6",180, 100, 250, 400, "3");
        addHitbox(thirdSlide, 620, 228, 698-620, 431-228,
                "slide3H7",200, 100, 400, 500, "3");
        addHitbox(thirdSlide, 684, 395, 730-684, 497-395,
                "slide3H8",400, 90, 250, 510, "3");
        slideShow.add("3", thirdSlide);
    }

    private void createFourthSlide() {
        JPanel fourthSlide = createSlide("slide4Name");

        addImage(fourthSlide, "Shepot-T.png", 75, 75, 500, 500);

        addDesc(fourthSlide, "slide4Desc",25,
                false, 650, 75, 550, 500);

        addHitbox(fourthSlide, 145, 74, 290-145, 191-74,
                "slide4H1",300,80,350,400, "4");
        addHitbox(fourthSlide, 481, 230, 569-481, 320-230,
                "slide4H2", 160,100,300,350, "4");
        addHitbox(fourthSlide, 81, 306, 190-81, 515-306,
                "slide4H3", 200,250,230,280, "4");
        addHitbox(fourthSlide, 276, 326, 459-276, 511-326,
                "slide4H4", 30,280,230,300, "4");
        addHitbox(fourthSlide, 205, 514, 247-205, 554-514,
                "slide4H5", 300,250,330,280, "4");
        addHitbox(fourthSlide, 296, 513, 348-296, 566-513,
                "slide4H6",50,250,250,350, "4");
        addHitbox(fourthSlide, 377, 516, 466-377, 579-516,
                "slide4H7",100,250,300,350, "4");
        addHitbox(fourthSlide, 235,458,271-235,509-458,
                "slide4H8",230,270,400,250, "4");
        slideShow.add("4", fourthSlide);
    }
}