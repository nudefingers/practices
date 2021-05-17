package com.ifmo.jjd.courseworks.game;

import com.ifmo.jjd.courseworks.game.menu.Menu;

import java.io.Serializable;
import java.util.*;

public class Section implements Serializable {
    private String title;
    private String text;
    private HashMap<Integer, String> ways = new HashMap<>();

    private Section(String title, String text, String firstWay, String secondWay) {
        this.title = title;
        this.text = text;
        addWays(firstWay, secondWay);
    }

    public String getTitle() {
        return title;
    }

    private void setWays(HashMap<Integer, String> ways) {
        this.ways = ways;
    }

    private void addWays(String firstWay, String secondWay){
        ways.put(1, firstWay);
        ways.put(2, secondWay);
    }

    private void displaySection(){
        StringBuilder sb = new StringBuilder();
        sb.append(this.title).append("\n").append(this.text).append("\n");

        for (HashMap.Entry<Integer, String> way : this.ways.entrySet()) {
            sb.append(way.getKey()).append(". ").append( modifyWay(way.getValue(),false)).append("\n");
        }

        System.out.println(sb);
    }

    public static Section createStart() {
        String title = "Лисенок";
        String text = """
                        Каждое утро Лисёнок просыпался, завтракал и шёл увидеться с Бельчонком. Это утро не было исключением. Лисёнок пришёл на
                        их обычное место встречи, но Бельчонка там не было. Лисёнок ждал, ждал, но так и не смог дождаться своего друга. "
                        Бельчонок не пропустил еще ни одной встречи, вдруг он попал в беду." - подумал Лисёнок. Как поступить Лисенку?
                        """;
        String firstWay = "Вернуться домой";
        String secondWay = "Отправиться на поиски";
        return new Section(title, text, firstWay, secondWay);
    }

    public static void runGame(Section current) {

        HashMap<String, Section> sections = createSections();
        Scanner scanner = new Scanner(System.in);
        Section section = current;

        while (true) {
            current.displaySection();
            int wayNumber = userChoice(scanner);
            if (wayNumber == 0) {
                Menu.getInstance().setSection(current);
                Menu.getInstance().runCommand();
                break;
            }

            current = receiveNextSection(current,sections, wayNumber);

            if (current.ways.get(1) == current.ways.get(2)) {
                System.out.println(current.title);
                System.out.println(current.text);
                System.out.println(current.ways.get(1));
                break;
            }
        }
    }

    private static HashMap<String, Section> createSections() {
        HashMap<String, Section> sections = new HashMap<>();

        String win = "Игра завершилась успехом";
        String loss = "Игра завершилась неудачей";

        String title = "Лисенок";
        String text = """
                        Каждое утро Лисёнок просыпался, завтракал и шёл увидеться с Бельчонком. Это утро не было исключением. Лисёнок пришёл на
                        их обычное место встречи, но Бельчонка там не было. Лисёнок ждал, ждал, но так и не смог дождаться своего друга. "
                        Бельчонок не пропустил еще ни одной встречи, вдруг он попал в беду." - подумал Лисёнок. Как поступить Лисенку?
                        """;
        String firstWay = "Вернуться домой";
        String secondWay = "Отправиться на поиски";

        title = "Вернуться домой";
        text = """
                        Вернувшись домой, Лисёнок нашёл там Бельчонка. Оказалось, что Бельчонок пришёл на место встречи раньше и увидел там рой
                        злобных пчел. Он поспешил предупредить об этом Лисёнка, но они разминулись. Наконец-то друзья нашли друг друга! <b>Игра
                        завершилась успехом</b>
                        """;
        firstWay = win;
        secondWay = win;
        sections.put(title, new Section(title, text, firstWay, secondWay));

        title = "Отправиться на поиски";
        text = """
                Все лесные жители были заняты своими делами и не обращали внимания на Лисёнка и его проблему. Но вдруг кто нибудь видел
                Бельчонка... Лисёнок не знал, что ему делать. Помогите ему.
                """;
        firstWay = "Попытаться разузнать о Бельчонке у лесных жителей";
        secondWay = "Искать Бельчонка в одиночку";
        sections.put(title, new Section(title, text, firstWay, secondWay));

        title = "Попытаться разузнать о Бельчонке у лесных жителей";
        text = """              
                Пока Лисёнок принимал решение, лесные жители разошлись кто куда. Остались только Сова и Волк. Но у Совы бывают проблемы
                с памятью, а Волк может сильно разозлиться из-за расспросов. Кого выбрать?
                """;
        firstWay = "Расспросить Сову";
        secondWay = "Расспросить Волка";
        sections.put(title, new Section(title, text, firstWay, secondWay));

        title = "Искать Бельчонка в одиночку";
        text = """
                Лисёнок слишком долго плутал по лесу в поисках друга и сам не заметил, как заблудился. Теперь его самого нужно искать.
                """;
        firstWay = loss;
        secondWay = loss;
        sections.put(title, new Section(title, text, firstWay, secondWay));

        title = "Расспросить Сову";
        text = """
                Сова долго не хотела говорить, но в итоге сказала, что видела испуганного Бельчонка, бежавшего вглубь леса. Все лесные
                жители знают, что в глубине леса опасно, если Бельчонок там, ему срочно нужна помощь. 
                """;
        firstWay = "Поверить Сове и отправиться вглубь леса";
        secondWay = "Сове не стоит верить -> Искать Бельчонка в одиночку";
        sections.put(title, new Section(title, text, firstWay, secondWay));

        title = "Расспросить Волка";
        text = """
                Волк оказался вполне дружелюбным, но помочь не смог. Лишь сказал, что маленькому лисенку не стоит бродить по лесу
                одному. И как теперь поступить?
                """;
        firstWay = "Волк прав -> Вернуться домой";
        secondWay = "Искать Бельчонка в одиночку";
        sections.put(title, new Section(title, text, firstWay, secondWay));

        title = "Поверить Сове и отправиться вглубь леса";
        text = """
                В глубине леса Лисёнок встретил Медвежонка. Ленивый Медвежонок был готов рассказать все, что знает, если Лисёнок
                принесёт ему мёда.
                """;
        firstWay = "Нет, потрачено слишком много времени, нужно идти дальше -> Искать Бельчонка в одиночку";
        secondWay = "Нужно воспользоваться шансом и раздобыть мёд";
        sections.put(title, new Section(title, text, firstWay, secondWay));

        title = "Нужно воспользоваться шансом и раздобыть мёд";
        text = """
                Лисёнок быстро нашёл мёд, но вокруг летал рой злобных пчел. Лисёнок всегда боялся пчёл, но и не найти друга он тоже
                боялся.
                """;
        firstWay = "Подождать, вдруг пчёлы улетят";
        secondWay = "Нужно попытаться выкрасть мёд немедленно";
        sections.put(title, new Section(title, text, firstWay, secondWay));

        title = "Подождать, вдруг пчёлы улетят";
        text = """
                Лисёнок подождал немного, и пчёлы разлетелись. Лисёнок без проблем набрал мёда. Вдруг он понял, что очень голоден. Что
                же делать?
                """;
        firstWay = "Поесть немного и передохнуть";
        secondWay = "Скорее отнести мёд Медвежонку";
        sections.put(title, new Section(title, text, firstWay, secondWay));

        title = "Нужно попытаться выкрасть мёд немедленно";
        text = """
                Это была не лучшая идея. Пчёлы покусали Лисёнка, теперь ему самому нужна помощь.
                """;
        firstWay = loss;
        secondWay = loss;
        sections.put(title, new Section(title, text, firstWay, secondWay));

        title = "Поесть немного и передохнуть";
        text = """
                Пока Лисёнок ел, злобные пчёлы вернулись и покусали его. Лисёнку нужна помощь, он не сможет продолжить поиски.
                """;
        firstWay = loss;
        secondWay = loss;
        sections.put(title, new Section(title, text, firstWay, secondWay));

        title = "Скорее отнести мёд Медвежонку";
        text = """
                Довольный Медвежонок рассказал Лисёнку, что очень хорошо знает семью Белок и уверен, что Бельчонок никогда не пошёл бы в
                глубь леса. Он заверял Лисёнка, что Белки не попадают в неприятности, и что Совам нельзя верить, он также уговаривал
                Лисёнка вернуться домой.
                """;
        firstWay = "Медвежонок ничего не знает, нужно продолжить поиски -> Искать Бельчонка в одиночку";
        secondWay = "Может быть он прав и Лисёнок просто паникует -> Вернуться домой";
        sections.put(title, new Section(title, text, firstWay, secondWay));


        return sections;
    }

    private static int userChoice(Scanner scanner){
        while (true) {
            try {
                System.out.println("Что делать Лисёнку? \nДля выхода в меню введите 0");
                int userInt = scanner.nextInt();
                if (userInt == 1 || userInt == 2) {
                    return userInt;
                }
                if (userInt == 0) {
                    return 0;
                }
                else {
                    System.out.println("Необходимо выбрать: 1,2 или 0 для выхода в меню\n");
                    continue;
                }
            }
            catch (InputMismatchException e) {
                System.out.println("Необходимо выбрать: 1,2 или 0 для выхода в меню\n");
                scanner.nextLine();
            }
        }
    }

    private static String modifyWay(String way, boolean isKey) {
        if (!way.contains(" -> ")) return way;

        String[] parts = way.split(" -> ");
        if (isKey) return parts[1].trim();
        else return parts[0].trim();
    }

    private static Section receiveNextSection(Section current, HashMap<String, Section> sections, int wayNumber) {
        return sections.entrySet()
                .stream()
                .filter(s -> s.getKey().equals(modifyWay(current.ways.get(wayNumber), true)))
                .map(e ->  e.getValue())
                .findFirst()
                .orElse(current);
    }

    public static Section getSectionByKey(String key) {
        return createSections()
                .entrySet()
                .stream()
                .filter(s -> s.getKey().equals(key))
                .map(e -> e.getValue())
                .findFirst()
                .orElse(createStart());
    }
}
