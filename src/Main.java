import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    TaskManager manager = new TaskManager();
    manager.loadTasksFromFile();
    Scanner scanner = new Scanner(System.in);
    boolean running = true;

    System.out.println("=== МЕНЕДЖЕР ЗАДАЧ ЗАПУЩЕН ===");

    while (running) {
      System.out.println("\nВыберите действие:");
      System.out.println("1 - Добавить задачу");
      System.out.println("2 - Показать все задачи");
      System.out.println("3 - Удалить задачу по ID");
      System.out.println("4 - Выйти");
      System.out.print("Ваш выбор: ");

      String choice = scanner.nextLine();

      switch (choice) {
        case "1":
          System.out.print("Название на английском!!  : ");
          String title = scanner.nextLine();
          System.out.print("Приоритет (High/low): ");
          String priority = scanner.nextLine();
          manager.addTask(title, priority);
          System.out.println(">> Задача добавлена.");
          break;
        case "2":
          System.out.println("\n--- СПИСОК ЗАДАЧ ---");
          manager.printAllTasks();
          break;
        case "3":
          System.out.print("Введите ID задачи: ");
          try {
            int id = Integer.parseInt(scanner.nextLine());
            manager.removeTask(id);
          } catch (NumberFormatException e) {
            System.out.println("Ошибка: ID должен быть числом!");
          }
          break;
        case "4":
          running = false;
          manager.saveTasksToFile();
          System.out.println("Выход...");
          break;
        default:
          System.out.println("Неверная команда, попробуйте снова.");
      }
    }
    scanner.close();
  }
}