package ru.midoritroop.frames;
import ru.midoritroop.RMan;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class StructFrame extends SlideShowFrame {
    private JPanel firstSlide, secondSlide, thirdSlide, fourthSlide, fifthSlide;
    StructFrame(ActionListener onReturn){
        super(onReturn);
        createFirstSlide();
        createSecondSlide();
        createThirdSlide();
        createFourthSlide();
        createFifthSlide();

        slideShow.add("1", firstSlide);
        slideShow.add("2", secondSlide);
        slideShow.add("3", thirdSlide);
        slideShow.add("4", fourthSlide);
        slideShow.add("5", fifthSlide);
        crd.show(slideShow, "1");
    }

    private void createFirstSlide() {
        firstSlide = createSlide(RMan.getPath("MainStruct.png"), "Структура", true);

        firstSlide.add(createDesc(RMan.getString("structFrame", "slide1Desc"), 28, false,
                830, 80, 430, 500));

        addHitbox(firstSlide, 107,154,244-107,253-154,
                RMan.getString("structFrame", "slide1H1"), 256,194,150,60, "2");

        addHitbox(firstSlide, 412,155,549-412,254-155,
                RMan.getString("structFrame", "slide1H1"), 256,194,150,60, "2");

        addHitbox(firstSlide, 597,152,740-597,257-152,
                RMan.getString("structFrame", "slide1H2"), 483,91,150,60, "3");

        addHitbox(firstSlide, 603,292,746-603,400-292,
                RMan.getString("structFrame", "slide1H3"), 584,412, 150,60, "4");

        addHitbox(firstSlide, 247,405,491-247,531-405,
                        RMan.getString("structFrame", "slide1H4"), 512,431, 170,60, "5");

        addHitbox(firstSlide, 287,121,362-287,346-121,
                                RMan.getString("structFrame", "slide1H5"), 391,269, 150,130, "1");
    }
    private void createSecondSlide() { // TODO: Replace plain strings
        secondSlide = createSlide("", "Измерительный микрофон", false);

        secondSlide.add(createDesc(RMan.getString("structFrame", "slide2Desc"), 28, false,
                830, 180, 430, 250));

        addHitbox(secondSlide, 336,248,454-336,325-248,
                "<html>Кабель</html>", 391,187,150,60, "2");

        addHitbox(secondSlide, 484,248,579-484,275-248,
                "<html>Питание</html>", 445,178,100,60, "2");

        addHitbox(secondSlide, 477,275,578-477,299-275,
                "<html>Заземление</html>", 409,342,150,60, "2");

        addHitbox(secondSlide, 454,297,577-454,316-297,
                "<html>Защитная оболочка кабеля</html>", 513,346,150,60, "2");

        addHitbox(secondSlide, 46,275,93-46,322-278,
                 "<html>Источник питания</html>", 63,180,150,60, "2");

        addHitbox(secondSlide, 190,244,315-190,353-244,
                "<html>Одиночный аудио-канал</html>", 239,432,150,60, "2");

        addHitbox(secondSlide, 581,248,703-581,317-248,
                 "<html>Микрофонная система</html>", 629,166,150,60, "2");

        addHitbox(secondSlide, 516,200,560-516,246-200,
                "<html>Параметры барьера:<br>" +
                        "Voc/Uo ≤ VMAX / UI<br>" +
                        " Isc/Io ≤ IMAX/ II <br>" +
                        "Ca/Co > CI + CCABLE<br>" +
                        " La/Lo > LI + LCABL<br>" +
                        "Ui = 30V, Ii = 100mA, Pi = 0.75W, Ci = 0, Li = 0.36uH – барьер серии EX378XYYY</html>", 260,80,300,200, "2");

        addHitbox(secondSlide, 221,205,263-221,242-205,
                "<html>Барьер устанавливается в корпусе, соответствующим стандартам властей данной страны</html>", 30,108,200,160, "2");

        addHitbox(secondSlide, 516,318,557-516,357-318,
                "<html>Защитные экраны заземляются на концах барьера</html>", 445,399,200,100, "2");

        addHitbox(secondSlide, 661,355,701-661,392-355,
                "<html>Утвержденный картридж для микрофона – картридж серии EX377XYYY</html>", 699,467,180,120, "2");

        addHitbox(secondSlide, 580,357,616-580,393-357,
                "<html>Утвержденный усилитель для микрофона – усилитель серии EX426XYYY</html>", 555,463,200,120, "2");

        JLabel img = new JLabel();
        ImageIcon unit = new ImageIcon(RMan.getPath("MicroStruct.png"));
        Image image = unit.getImage();
        Image newimg;
        img.setBounds(0, 200, 750, 250);
        newimg = image.getScaledInstance(750, 250, java.awt.Image.SCALE_SMOOTH);
        unit = new ImageIcon(newimg);
        img.setVerticalAlignment(JLabel.TOP);
        img.setIcon(unit);
        secondSlide.add(img);
    }
    private void createThirdSlide() {
        thirdSlide = createSlide("", "Акустический излучатель", false);

        thirdSlide.add(createDesc(RMan.getString("structFrame", "slide3Desc"), 28, false,
                830, 80, 430, 450));

        thirdSlide.add(createDesc(RMan.getString("structFrame", "slide3Desc1"), 28, false,
                100,240, 630, 100));

        thirdSlide.add(createDesc(RMan.getString("structFrame", "slide3Desc2"), 28, false,
                226,428, 430, 100));

        addHitbox(thirdSlide, 136,143,170-136,172-143,
                "<html>Дискретный по времени и значению сигнал с ошибками</html>", 125,82,250,60, "3");

        addHitbox(thirdSlide, 169,126,232-169,189-126,
                "<html>Канальный декодер</html>", 169,201,150,60, "3");

        addHitbox(thirdSlide, 230,143,274-230,170-143,
                "<html>Дискретный по времени и значению сигнал без ошибок</html>", 223,82,250,60, "3");

        addHitbox(thirdSlide, 272,124,336-272,187-124,
                "<html>Декодер</html>", 274,190,150,60, "3");

        addHitbox(thirdSlide, 336,140,379-336,172-140,
                        "<html>Дискретный по значению сигнал</html>", 323,82,250,60, "3");

        addHitbox(thirdSlide, 379,124,443-379,186-124,
                "<html>Сглаживание</html>", 372,189,150,60, "3");

        addHitbox(thirdSlide, 442,140,515-442,169-140,
                "<html>Непрерывный сигнал</html>", 434,82,150,60, "3");

        addHitbox(thirdSlide, 515,123,574-515,189-123,
                "<html>Фильтрация</html>", 514,191,150,60, "3");

        addHitbox(thirdSlide, 255,214,455-255,258-214,
                "<html>На данном этапе из потока цифровых данных с помощью цифроаналогового преобразователя (ЦАП) выделяют отсчеты сигнала, следующие с частотой дискретизации</html>", 243,259,300,160, "3");

        addHitbox(thirdSlide, 462,214,659-462,259-214,
                "<html>На данном этапе из дискретных отсчетов путем сглаживания (интерполяции)" +
                        " формируется непрерывный аналоговый сигнал с помощью фильтра низкой частоты, который" +
                        " подавляет периодические составляющие спектра дискретного сигнала</html>",
                465,265,300,200, "3");

        addHitbox(thirdSlide, 59,380,172-59,449-380,
                "<html>В случае комплекса «Шепот» - генератор шума</html>", 21,317,250,60, "3");

        addHitbox(thirdSlide, 201,378,298-201,449-378,
                "<html>Сигнал возбуждения подается на фильтр, имитирующий необходимую амплитудно-частотную характеристику</html>", 206,462,250,120, "3");

        addHitbox(thirdSlide, 201,378,298-201,449-378,
                        "<html>Сигнал возбуждения подается на фильтр, имитирующий необходимую амплитудно-частотную характеристику</html>", 206,462,250,120, "3");

        addHitbox(thirdSlide, 326,376,410-326,447-376,
                "<html>На другой вход фильтра подается сигнал амплитудной огибающей, а совокупность сигналов" +
                        " обрабатывается с целью получения специальных звуковых эффектов, например, эха</html>", 328,456,330,150, "3");

        addHitbox(thirdSlide, 444,374,506-444,447-374,
                "<html>Фильтрация сигнала с помощью фильтра низких частот</html>", 448,456,250,120, "3");

        addHitbox(thirdSlide, 538,374,589-538,445-374,
                "<html>Генерирует ADSR огибающую - функцию, описывающую изменения какого-либо параметра во времени</html>", 543,455,270,120, "3");

        addHitbox(thirdSlide, 57,470,173-57,523-470,
                "<html>Канальный декодер</html>", 42,531,150,60, "3");


        JLabel img = new JLabel();
        ImageIcon unit = new ImageIcon(RMan.getPath("AcousticStruct.png"));
        Image image = unit.getImage();
        Image newimg;
        img.setBounds(0, 80, 750, 200);
        newimg = image.getScaledInstance(750, 200, java.awt.Image.SCALE_SMOOTH);
        unit = new ImageIcon(newimg);
        img.setVerticalAlignment(JLabel.TOP);
        img.setIcon(unit);
        thirdSlide.add(img);

        JLabel img2 = new JLabel();
        ImageIcon unit2 = new ImageIcon(RMan.getPath("AcousticStruct2.png"));
        Image image2 = unit2.getImage();
        Image newimg2;
        img2.setBounds(0, 350, 750, 200);
        newimg2 = image2.getScaledInstance(750, 200, java.awt.Image.SCALE_SMOOTH);
        unit2 = new ImageIcon(newimg2);
        img2.setVerticalAlignment(JLabel.TOP);
        img2.setIcon(unit2);
        thirdSlide.add(img2);
    }
    private void createFourthSlide() {
        fourthSlide = createSlide("", "Генератор шума", false);

        fourthSlide.add(createDesc(RMan.getString("structFrame", "slide4Desc"), 28, false,
                830, 180, 430, 250));

        addHitbox(fourthSlide, 71,198,218-71,333-198,
                "<html>Источник шумового сигнала, выполненный на резисторе</html>", 37,138,250,60, "4");


        addHitbox(fourthSlide, 258,198,407-258,330-198,
                "<html>Повышает сигнал до уровня напряжения линейного входа</html>", 222,132,270,80, "4");


        addHitbox(fourthSlide, 447,199,595-447,330-199,
                "<html>Пассивное сверхвысокочастотное устройство, которое изменяет и исправляет спектральные плотности сигнала</html>", 395,78,300,120, "4");

        addHitbox(fourthSlide, 259,371,406-259,502-371,
                "<html>Маломощный генератор электрических колебаний, применяемый для преобразования частот сигнала, а данном случае источник опорного сигнала для перемножения</html>", 5,360,250,200, "4");

        addHitbox(fourthSlide, 447,369,593-447,502-369,
                "<html>Переводит сигнал из области звуковых частот в радиочастоты</html>", 390,514,250,80, "4");

        addHitbox(fourthSlide, 630,370,781-630,503-370,
                "<html>Усиливает мощность сигнала для его перенаправления на акустический излучатель</html>", 589,511,250,80, "4");

        JLabel img = new JLabel();
        ImageIcon unit = new ImageIcon(RMan.getPath("GeneratorStruct.png"));
        Image image = unit.getImage();
        Image newimg;
        img.setBounds(50, 200, 750, 300);
        newimg = image.getScaledInstance(750, 300, java.awt.Image.SCALE_SMOOTH);
        unit = new ImageIcon(newimg);
        img.setVerticalAlignment(JLabel.TOP);
        img.setIcon(unit);
        fourthSlide.add(img);
    }
    private void createFifthSlide() {
        fifthSlide = createSlide(RMan.getPath("MeasuringToolStruct.png"), "Средство измерения помех", true);

        fifthSlide.add(createDesc(RMan.getString("structFrame", "slide5Desc"), 28, false,
                830, 80, 430, 450));

        addHitbox(fifthSlide, 96,94,216-94,142-94,
                "<html>Микрофон и предусилитель</html>", 37,138,150,60, "5");

        addHitbox(fifthSlide, 264,85,327-264,193-85,
                "<html>Коэффициент передачи от 0 до 50 дБ</html>", 229,186,200,60, "5");

        addHitbox(fifthSlide, 330,89,484-330,192-89,
                "<html>Электронный или любой другой фильтр, пропускающий высокие частоты входного сигнала, при этом подавляя" +
                        " частоты сигнала ниже частоты среза. Степень подавления зависит от конкретного типа фильтра</html>", 344,203,300,190, "5");

        addHitbox(fifthSlide, 527,88,603-527,191-88,
                "<html>Аналого-цифровой преобразователь - устройство, преобразующее входной аналоговый сигнал в дискретный код/цифровой сигнал</html>", 376,197,300,120, "5");

        addHitbox(fifthSlide, 267,206,343-267,307-206,
                        "<html>Аналого-цифровой преобразователь - устройство, преобразующее входной аналоговый сигнал в дискретный код/цифровой сигнал</html>", 376,197,300,120, "5");

        addHitbox(fifthSlide, 633,89,708-633,191-89,
                "<html>Цифровой процессор обработки сигналов - специализированный программируемый микропроцессор," +
                        " предназначенный для манипулирования в реальном масштабе времени потоком цифровых данных</html>", 635,195,300,200, "5");

        addHitbox(fifthSlide, 109,183,167-109,220-183,
                "<html>Внешнее питание</html>", 2,196,150,60, "5");

        addHitbox(fifthSlide, 546,207,626-546,286-207,
                "<html>Подача переменного тока</html>", 639,207,170,60, "5");

        addHitbox(fifthSlide, 541,286,627-541,325-286,
                "<html>Подача постоянного тока</html>", 639,291,170,60, "5");

        addHitbox(fifthSlide, 636,207,701-636,321-207,
                "<html>Мультиплексор - позволяет передавать сигнал с одного из входов на выход;" +
                        " при этом выбор желаемого входа осуществляется подачей соответствующей комбинации управляющих сигналов</html>", 701,321,300,170, "5");

        addHitbox(fifthSlide, 739,241,779-739,288-241,
                "<html>Выход постоянного и переменного тока</html>", 779,288,180,60, "5");

        addHitbox(fifthSlide, 119,376,166-119,419-376,
                        "<html>Контроллер ввода/вывода</html>", 166,419,150,60, "5");

        addHitbox(fifthSlide, 276,476,344-276,521-476,
                "<html>RAM – оперативная память – от ½ до 2 МБ</html>", 221,530,300,60, "5");

        addHitbox(fifthSlide, 343,477,412-343,521-477,
                "<html>Flash ROM - электрически-стираемая программируемая постоянная память</html>", 297,359,300,100, "5");

        addHitbox(fifthSlide, 412,477,512-412,521-477,
                "<html>Календарь и счетчик реального времени</html>", 374,530,300,60, "5");

        addHitbox(fifthSlide, 512,478,580-512,521-478,
                "<html>Серийный контроллер ввода/вывода - метод последовательной передачи элементов данных между устройствами</html>", 455,320,300,150, "5");

        addHitbox(fifthSlide, 656,394,777-656,494-394,
                "<html>Графический жидкокристаллический экран 128х64 мм с подсветкой</html>", 777,474,150,120, "5");

        addHitbox(fifthSlide, 607,518,685-607,561-518,
                "<html>Передатчик RS-422/232</html>", 685,541,150,60, "5");

        addHitbox(fifthSlide, 736,514,776-736,562-514,
                "<html>Серийный контроллер ввода/вывода – метод последовательной передачи элементов данных между устройствами</html>", 776,424,300,150, "5");
    }
}