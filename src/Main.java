public class Main {

    public static void main(String[] args) {

        // Создаем список работников
        Workers workers = new Workers();
        // Загружаем список с файла
        workers = Serialize.Load();

        // Добавляем работников по одному
        workers.add(Worker.Education.BACHELOR, "Кумиров", 1997, "Слесарь", 15000);
        workers.add(Worker.Education.HIGH_SCHOOL, "Попов", 2001, "Столяр", 11000);
        workers.add(Worker.Education.DOCTOR, "Аксеснов", 1998, "Плотник", 8000);
        workers.add(Worker.Education.BACHELOR, "Антипов", 1999, "Сантехник", 16000);

        // Выводим самого молодого
        workers.printYoungest();
        // Записываем список работников в файл
        Serialize.Save(workers);
    }

}
