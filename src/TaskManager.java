import java.util.ArrayList;

public class TaskManager {
    // Создать динамический список для хранения данных вроде.
    private ArrayList<Task> tasks = new ArrayList<>();
    private int nextId = 1; // это если че Автоматический счетчик ID

    public void addTask(String title, String priority) {
        Task newTask = new Task(nextId, title, priority);
        tasks.add(newTask);
        System.out.println("Задача успешно добавлена! (ID: " + nextId + ")");
        nextId++;
    }

    // вывод на экран
    public void printAllTasks() {
        if (tasks.isEmpty()) {
            System.out.println("Ваш список задач пуст.");
            return;
        }
        System.out.println("\n--- СПИСОК ВАШИХ ЗАДАЧ ---");
        for (Task task : tasks) {
            System.out.println(task);
        }
        System.out.println("--------------------------");
    }

    // это нужно для отметки задачи как выполненной по её айдиии
    public void completeTask(int id) {
        for (Task task : tasks) {
            if (task.getId() == id) {
                task.setCompleted(true);
                System.out.println("Задача с ID " + id + " теперь выполнена!");
                return;
            }
        }
        System.out.println("Задача с ID " + id + " не найдена.");
    }
}

