public class Main {
  public static void main(String[] args) {
    System.out.println("ПРИВЕТ! ПРОГРАММА ЗАПУЩЕНА.");// проверка экзешника, потом удалить!!!!
    TaskManager manager = new TaskManager();

    manager.addTask("Сделать ДЗ по Java", "Высокий");
    manager.addTask("Купить молоко", "Низкий");


    manager.printAllTasks();
    manager.printTasksByPriority("Высокий");
    manager.removeTask(1);
    manager.printAllTasks();

    System.out.println("\nНажмите Enter, чтобы выйти...");
    new java.util.Scanner(System.in).nextLine();
  }
}