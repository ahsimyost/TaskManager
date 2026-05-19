import java.util.ArrayList;

public class TaskManager {
    private ArrayList<Task> tasks = new ArrayList<>();
    private int nextId = 1;

    public void addTask(String title, String priority) {
        Task newTask = new Task(nextId, title, priority);
        tasks.add(newTask);
        System.out.println("Задача успешно добавлена! (ID: " + nextId + ")");
        nextId++;
    }

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

    public void removeTask(int id) {
        boolean removed = tasks.removeIf(task -> task.getId() == id);
        if (removed) {
            System.out.println("Задача с ID " + id + " удалена.");
        } else {
            System.out.println("Задача с ID " + id + " не найдена.");
        }
    }

    public void printTasksByPriority(String priority) {
        System.out.println("\n--- Задачи с приоритетом: " + priority + " ---");
        for (Task task : tasks) {
            if (task.getPriority().equalsIgnoreCase(priority)) {
                System.out.println(task);
            }
        }
    }
}