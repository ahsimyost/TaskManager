public class Main {
  public static void main(String[] args) {
    TaskManager manager = new TaskManager();

    manager.addTask("Запустить проект на Java для практики", "Высокий");
    manager.addTask("Поиграть в Steam вечером", "Низкий");
    manager.addTask("Распечатать справку об отсрочке", "Средний");

    manager.printAllTasks();

    manager.completeTask(1);

    manager.printAllTasks();
  }
}