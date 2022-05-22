import java.io.Serializable;

// Чтобы можно было сортировать работников по возрасту,
// используем интерфейс (шаблон) Comparable
public class Worker implements Comparable<Worker>, Serializable {
    // Конструктор, не принимает значений
    public Worker() {
    }

    // Поля (всегда должны быть приватными)
    private String lastName; // Фамилия
    private int birthYear; // Год рождения
    private String jobTitle; // Профессия
    private int salary; // Зарплата
    private Education education; // Образование, типа enum (выбор из списка допустимых значений)
    // Список допустимых значений для образования
    enum Education {
        HIGH_SCHOOL,
        BACHELOR,
        MASTER,
        DOCTOR
    }
    // Сеттер (для изменения приватных полей)
    /**
     * Задать образование
     * @param education образование
     */
    public void setEducation(Education education) {
        this.education = education;
    }

    // Если метод может выбросить исключение, обязательно использовать throws с типом исключения

    /**
     * Задать фамилию
     * @param lastName
     * @throws IllegalArgumentException фамилия содержит символы помимо букв и пробелов
     */
    public void setLastName(String lastName) throws IllegalArgumentException {
        // Проверка фамилии на содержание символов помимо букв и пробелов
        if (!lastName.matches("[A-Za-zА-Яа-я\\s]*"))
            // Если содержит, то кидаем исключение (и прекращаем работу)
            throw new IllegalArgumentException("Фамилия должна содержать только латинские или кириллические буквы и пробелы");
        // Если исключение не было выброшено, то присваиваем значение
        this.lastName = lastName;
    }
    // Аналогичный сеттер для года рождения

    /**
     * Задать год рождения
     * @param birthYear год рождения
     * @throws IllegalArgumentException слишком большой или маленький возраст
     */
    public void setBirthYear(int birthYear) throws IllegalArgumentException {
        // Проверяем год рождения на реалистичность
        if (birthYear < 1900 || birthYear > 2006)
            throw new IllegalArgumentException("Введен некорректный год рождения");
        this.birthYear = birthYear;
    }

    /**
     * Задать профессию
     * @param jobTitle профессия
     */
    public void setJobTitle(String jobTitle) { // Сеттер для профессии
        this.jobTitle = jobTitle;
    }

    /**
     * Задать зарплату
     * @param salary зарплата
     */
    public void setSalary(int salary) { // Сеттер для зарплаты
        // Допустимые значения: от 0 до 300000
        if (salary < 0 || salary > 300000)
            throw new IllegalArgumentException("Введено некорректное значение зарплаты");
        this.salary = salary;
    }
    // Геттеры
    public String getLastName() { // Фамилия
        return lastName;
    }
    public int getBirthYear() { // Год рождения
        return birthYear;
    }
    public String getJobTitle() { // Профессия
        return jobTitle;
    }
    public int getSalary() { // Зарплата
        return salary;
    }

    @Override
    // Функция для сортировки (называется компаратор)
    // Принимает объект Worker
    /**
     * Метод для сортировки по году рождения
     */
    public int compareTo(Worker e) {
        // Возвращает сравнение текущего и переданного значения года рождения
        // (сортировка по году рождения)
        return Integer.compare(getBirthYear(), e.getBirthYear());
    }

}
