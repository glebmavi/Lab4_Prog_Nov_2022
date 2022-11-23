import ru.glebmavi.lab3.Characteristic;
import ru.glebmavi.lab3.Lichnost;
import ru.glebmavi.lab3.Storychar;
import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {

        System.out.println("---Создание персонажей---");
        long startTime = System.nanoTime();

        Secretaria sec = new Secretaria();
        Group.Member sp = new Group.Member("Спрутс");
        Group.Member du = new Group.Member("Дубе");
        du.addComo(Characteristic.DUB);
        Group.Member me = new Group.Member("E");
        Group.Member mf = new Group.Member("F");


        System.out.println(sec);
        System.out.println(sp);
        System.out.println(du);
        System.out.println(me);
        System.out.println(mf);

        long stopTime = System.nanoTime();
        long elapsedTime = stopTime - startTime;
        double elapsedTimeInSecond = (double) elapsedTime / 1000000000;
        System.out.println("---Время обработки: " + elapsedTimeInSecond + " сек---\n");


        System.out.println("---Создание группы---");
        startTime = System.nanoTime();
        Group BB = new Group("Большой Бредлам");
        BB.addIntegrante(sp);
        BB.addIntegrante(du);
        BB.addIntegrante(me);
        BB.addIntegrante(mf);

        System.out.println(BB);
        stopTime = System.nanoTime();
        elapsedTime = stopTime - startTime;
        elapsedTimeInSecond = (double) elapsedTime / 1000000000;
        System.out.println("---Время обработки: " + elapsedTimeInSecond + " сек---\n");


        /*
        Вызов всех членов Большого Бредлама
         */
        for (Group.Member m : BB.integrantes) {
            m.Hear(sec.call(m));
        }


        System.out.println("\n---Создание кабинета---");
        startTime = System.nanoTime();
        Cabinet cabS = new Cabinet(sp);
//        Cabinet.Table t = null;
        Group empty = new Group();
//        try {
//            t = cabS.new Table(1, BB);
//        } catch (Cabinet.TableFewSeatsException | Cabinet.TableNegativeSeatsException e) {
//            System.out.println(e.getMessage());
//            System.out.println("Setting default amount of seats (9999)");
//            t = cabS.new Table(BB);
//
//        }
        Cabinet.Table t = cabS.new Table(1, BB);
        System.out.println(cabS);
        System.out.println(t);
        stopTime = System.nanoTime();
        elapsedTime = stopTime - startTime;
        elapsedTimeInSecond = (double) elapsedTime / 1000000000;
        System.out.println("---Время обработки: " + elapsedTimeInSecond + " сек---\n");

        String said = "Я хочу вам рассказать о причинах столь экстренного заседания. Нам грозит беда в связи с появлением гигантских растений";
        sp.talk(said);
        t.hear(said, BB);
        t.emotion(" волнение", BB);

        said = "Всё дело с гигантскими растениями необходимо убить в зародыше, то есть еще до того, как оно разовьется в полную силу.";
        sp.talk(said);
        t.hear(said, BB);

        System.out.println("----------\n");


        System.out.println("---Создание растения---");
        startTime = System.nanoTime();
        Plant GiganticPlant = null;
        try {
            GiganticPlant = new Plant(Plant.Size.EN, -10);
        } catch (Plant.PlantNegativeDamageException e) {
            System.out.println(e.getMessage());
            System.out.println("Setting default damage (10)");
            GiganticPlant = new Plant(Plant.Size.EN);
        }

        System.out.println(GiganticPlant);
        System.out.println("Гигантское растение имеет " + GiganticPlant.damage + " урона");
        stopTime = System.nanoTime();
        elapsedTime = stopTime - startTime;
        elapsedTimeInSecond = (double) elapsedTime / 1000000000;
        System.out.println("---Время обработки: " + elapsedTimeInSecond + " сек---\n");

        said = "Моё выступление окончено";
        sp.talk(said);
        t.hear(said, BB);


        /*
        Далее часть текста реализованного в ЛР3 (модифицированно чтобы работало с table)
         */

        System.out.println("\n---Создание остальных персонажей---");
        startTime = System.nanoTime();
        Lichnost a = new Lichnost("Agent 47");
        a.addComo(Characteristic.HAB);
        a.addComo(Characteristic.TAL);
        System.out.println(a);
        Lichnost b = new Lichnost("Agent 48");
        b.addComo(Characteristic.HAB);
        b.addComo(Characteristic.TAL);
        System.out.println(b);

        Storychar m = new Storychar("Миго");
        Storychar j = new Storychar("Жулио");
        Storychar n = new Storychar("Незнайка");
        Storychar k = new Storychar("Козлик");
        System.out.println(m);
        System.out.println(j);
        System.out.println(n);
        System.out.println(k);
        stopTime = System.nanoTime();
        elapsedTime = stopTime - startTime;
        elapsedTimeInSecond = (double) elapsedTime / 1000000000;
        System.out.println("---Время обработки: " + elapsedTimeInSecond + " сек---\n");


        said = "У меня имеются две личности: " + a.getName() + " он" + a.getComoTitles() + " и " + b.getName() + " он" + b.getComoTitles();
        sp.talk(said);
        t.hear(said, BB);

        said = "Они могут взяться за это дельце и в два счета уберут с дороги " + m.getName() + " и " + j.getName() + ", а заодно и " + n.getName() + " с " + k.getName();
        sp.talk(said);
        t.hear(said, BB);

        said = ("Вы " + du.getName() + ", видимо меня не поняли, так как, говоря о том, что дело надо убить в зародыше, я вовсе не подразумевал, что кого-либо следует убить в буквальном смысле этого слова.");
        sp.talk(said);
        t.hear(said, BB);

        System.out.println("\n---Состояние членов Большого Бредлама---");
        System.out.println(sp);
        System.out.println(du);
        System.out.println(me);
        System.out.println(mf);
        System.out.println("----------\n");

        System.out.println("---Убийства---");
        a.kill(m);
        a.kill(j);
        a.kill(n);
        b.kill(k);
        System.out.println("----------\n");

        System.out.println("\n---Состояние остальных персонажей---");
        System.out.println(a);
        System.out.println(b);

        System.out.println(m);
        System.out.println(j);
        System.out.println(n);
        System.out.println(k);
        System.out.println("----------\n");

    }
}