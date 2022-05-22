// Нам нужны библиотеки: Список, Коллекции (для задания порядка сортировки)
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

// Класс Работники будет хранить список работников (объектов)
public class Workers implements Serializable {
    // Задаем список «Работники» типа Работник
    private ArrayList<Worker> workers = new ArrayList<Worker>();

    // Конструктор пустой, задавать значения будем в сеттерах
    public Workers() {
    }

    /**
     * Функция для добавления в список нового работника
     * @param education образование
     * @param lastname фамилия
     * @param birthYear год рождения
     * @param jobTitle работа
     * @param salary зарплата
     */
    public void add(Worker.Education education, String lastname, int birthYear, String jobTitle, int salary) {
        // Создаем новый объект работника
        Worker worker = new Worker();
        // Задаем все необходимые значения
        worker.setEducation(education);
        worker.setLastName(lastname);
        worker.setBirthYear(birthYear);
        worker.setJobTitle(jobTitle);
        worker.setSalary(salary);
        // Добавляем работника в список работников
        workers.add(worker);
    }

    /**
     * Функция для печати младшего работника
     */
    public void printYoungest() {
        // Сортируем всех работников по году рождения в обратном порядке (по возрасту)
        Collections.sort(workers, Collections.reverseOrder());
        // Выводим значения всех полей для первого (будет самым молодым)
        System.out.println("Самый молодой работник: " + workers.get(0).getLastName() + " " +
                workers.get(0).getBirthYear() + " года рождения, "
                + workers.get(0).getJobTitle() + " с зарплатой " + workers.get(0).getSalary());
    }
}
