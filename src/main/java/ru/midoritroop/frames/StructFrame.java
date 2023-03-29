package ru.midoritroop.frames;

import javax.swing.*;
import java.awt.event.ActionListener;

public class StructFrame extends SlideShowFrame {
    StructFrame(ActionListener onReturn){
        super(onReturn);
        createFirstSlide();
        createSecondSlide();
        createThirdSlide();
        createFourthSlide();
        createFifthSlide();

        crd.first(slideShow);
    }

    private void createFirstSlide() {
        JPanel firstSlide = createSlide("slide1Name");

        addDesc(firstSlide, "slide1Desc", 28,
                false, 830, 80, 430, 500);

        addImage(firstSlide, "MainStruct.png", 50, 85, 750, 500);

        addHitbox(firstSlide, 107,154,244-107,253-154,
                "slide1H1", 256,194,150,60, "2");
        addHitbox(firstSlide, 412,155,549-412,254-155,
                 "slide1H1", 256,194,150,60, "2");
        addHitbox(firstSlide, 597,152,740-597,257-152,
                "slide1H2", 483,91,150,60, "3");
        addHitbox(firstSlide, 603,292,746-603,400-292,
                "slide1H3", 584,412, 150,60, "4");
        addHitbox(firstSlide, 247,405,491-247,531-405,
                        "slide1H4", 512,431, 170,60, "5");
        addHitbox(firstSlide, 287,121,362-287,346-121,
                                 "slide1H5", 391,269, 150,130, "1");
        slideShow.add("1", firstSlide);
    }
    private void createSecondSlide() {
        JPanel secondSlide = createSlide("slide2Name");

        addDesc(secondSlide,"slide2Desc", 28,
                false, 830, 180, 430, 250);

        addImage(secondSlide, "MicroStruct.png", 0, 200, 750, 250);

        addHitbox(secondSlide, 336,248,454-336,325-248,
                "slide2H1", 391,187,150,60, "2");
        addHitbox(secondSlide, 484,248,579-484,275-248,
                "slide2H2", 445,178,100,60, "2");
        addHitbox(secondSlide, 477,275,578-477,299-275,
                "slide2H3", 409,342,150,60, "2");
        addHitbox(secondSlide, 454,297,577-454,316-297,
                "slide2H4", 513,346,150,60, "2");
        addHitbox(secondSlide, 46,275,93-46,322-278,
                "slide2H5", 63,180,150,60, "2");
        addHitbox(secondSlide, 190,244,315-190,353-244,
                "slide2H6", 239,432,150,60, "2");
        addHitbox(secondSlide, 581,248,703-581,317-248,
                "slide2H7", 629,166,150,60, "2");
        addHitbox(secondSlide, 516,200,560-516,246-200,
                "slide2H8", 260,80,300,200, "2");
        addHitbox(secondSlide, 221,205,263-221,242-205,
                "slide2H9", 30,108,200,160, "2");
        addHitbox(secondSlide, 516,318,557-516,357-318,
                "slide2H10", 445,399,200,100, "2");
        addHitbox(secondSlide, 661,355,701-661,392-355,
                "slide2H11", 699,467,180,120, "2");
        addHitbox(secondSlide, 580,357,616-580,393-357,
                "slide2H12", 555,463,200,120, "2");
        slideShow.add("2", secondSlide);
    }
    private void createThirdSlide() {
        JPanel thirdSlide = createSlide("slide3Name");

        addDesc(thirdSlide, "slide3Desc", 28,
                false,830, 80, 430, 450);

        addDesc(thirdSlide,"slide3Desc1", 28,
                false,100,240, 630, 100);
        addDesc(thirdSlide, "slide3Desc2", 28,
                false,226,428, 430, 100);

        addImage(thirdSlide, "AcousticStruct.png", 0, 80, 750, 200);
        addImage(thirdSlide, "AcousticStruct2.png", 0, 350, 750, 200);

        addHitbox(thirdSlide, 136,143,170-136,172-143,
                "slide3H1", 125,82,250,60, "3");
        addHitbox(thirdSlide, 169,126,232-169,189-126,
                "slide3H2", 169,201,150,60, "3");
        addHitbox(thirdSlide, 230,143,274-230,170-143,
                "slide3H3", 223,82,250,60, "3");
        addHitbox(thirdSlide, 272,124,336-272,187-124,
                "slide3H4", 274,190,150,60, "3");
        addHitbox(thirdSlide, 336,140,379-336,172-140,
                "slide3H5", 323,82,250,60, "3");
        addHitbox(thirdSlide, 379,124,443-379,186-124,
                "slide3H6", 372,189,150,60, "3");
        addHitbox(thirdSlide, 442,140,515-442,169-140,
                "slide3H7", 434,82,150,60, "3");
        addHitbox(thirdSlide, 515,123,574-515,189-123,
                "slide3H8", 514,191,150,60, "3");
        addHitbox(thirdSlide, 255,214,455-255,258-214,
                "slide3H9", 243,259,300,160, "3");
        addHitbox(thirdSlide, 462,214,659-462,259-214,
                "slide3H10",465,265,300,200, "3");
        addHitbox(thirdSlide, 59,380,172-59,449-380,
                "slide3H11", 21,317,250,60, "3");
        addHitbox(thirdSlide, 201,378,298-201,449-378,
                "slide3H12", 206,462,250,120, "3");
        addHitbox(thirdSlide, 201,378,298-201,449-378,
                "slide3H12", 206,462,250,120, "3");
        addHitbox(thirdSlide, 326,376,410-326,447-376,
                "slide3H13", 328,456,330,150, "3");
        addHitbox(thirdSlide, 444,374,506-444,447-374,
                "slide3H14", 448,456,250,120, "3");
        addHitbox(thirdSlide, 538,374,589-538,445-374,
                "slide3H15", 543,455,270,120, "3");
        addHitbox(thirdSlide, 57,470,173-57,523-470,
                "slide3H16", 42,531,150,60, "3");
        slideShow.add("3", thirdSlide);
    }
    private void createFourthSlide() {
        JPanel fourthSlide = createSlide("slide4Name");

        addDesc(fourthSlide, "slide4Desc", 28,
                false, 830, 180, 430, 250);

        addImage(fourthSlide, "GeneratorStruct.png", 50, 200, 750, 300);

        addHitbox(fourthSlide, 71,198,218-71,333-198,
                "slide4H1", 37,138,250,60, "4");
        addHitbox(fourthSlide, 258,198,407-258,330-198,
                "slide4H2", 222,132,270,80, "4");
        addHitbox(fourthSlide, 447,199,595-447,330-199,
                "slide4H3", 395,78,300,120, "4");
        addHitbox(fourthSlide, 259,371,406-259,502-371,
                "slide4H4", 5,360,250,200, "4");
        addHitbox(fourthSlide, 447,369,593-447,502-369,
                "slide4H5", 390,514,250,80, "4");
        addHitbox(fourthSlide, 630,370,781-630,503-370,
                "slide4H6", 589,511,250,80, "4");
        slideShow.add("4", fourthSlide);
    }
    private void createFifthSlide() {
        JPanel fifthSlide = createSlide("slide5Name");

        addDesc(fifthSlide, "slide5Desc", 28,
                false, 830, 80, 430, 450);

        addImage(fifthSlide, "MeasuringToolStruct.png", 50, 85, 750, 500);

        addHitbox(fifthSlide, 96,94,216-94,142-94,
                "slide5H1", 37,138,150,60, "5");
        addHitbox(fifthSlide, 264,85,327-264,193-85,
                "slide5H2", 229,186,200,60, "5");
        addHitbox(fifthSlide, 330,89,484-330,192-89,
                "slide5H3", 344,203,300,190, "5");
        addHitbox(fifthSlide, 527,88,603-527,191-88,
                "slide5H4", 376,197,300,120, "5");
        addHitbox(fifthSlide, 267,206,343-267,307-206,
                "slide5H4", 376,197,300,120, "5");
        addHitbox(fifthSlide, 633,89,708-633,191-89,
                "slide5H5", 635,195,300,200, "5");
        addHitbox(fifthSlide, 109,183,167-109,220-183,
                "slide5H6", 2,196,150,60, "5");
        addHitbox(fifthSlide, 546,207,626-546,286-207,
                "slide5H7", 639,207,170,60, "5");
        addHitbox(fifthSlide, 541,286,627-541,325-286,
                "slide5H8", 639,291,170,60, "5");
        addHitbox(fifthSlide, 636,207,701-636,321-207,
                "slide5H9", 701,321,300,170, "5");
        addHitbox(fifthSlide, 739,241,779-739,288-241,
                "slide5H10", 779,288,180,60, "5");
        addHitbox(fifthSlide, 119,376,166-119,419-376,
                "slide5H11", 166,419,150,60, "5");
        addHitbox(fifthSlide, 276,476,344-276,521-476,
                "slide5H12", 221,530,300,60, "5");
        addHitbox(fifthSlide, 343,477,412-343,521-477,
                "slide5H13", 297,359,300,100, "5");
        addHitbox(fifthSlide, 412,477,512-412,521-477,
                "slide5H14", 374,530,300,60, "5");
        addHitbox(fifthSlide, 512,478,580-512,521-478,
                "slide5H15", 455,320,300,150, "5");
        addHitbox(fifthSlide, 656,394,777-656,494-394,
                "slide5H16", 777,474,150,120, "5");
        addHitbox(fifthSlide, 607,518,685-607,561-518,
                "slide5H17", 685,541,150,60, "5");
        addHitbox(fifthSlide, 736,514,776-736,562-514,
                "slide5H18", 776,424,300,150, "5");
        slideShow.add("5", fifthSlide);
    }
}