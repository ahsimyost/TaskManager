import java.io.*;
import java.util.ArrayList;

public class TaskManager {
    private ArrayList<Task> tasks = new ArrayList<>();
    private int nextId = 1;
    private static final String FILE_NAME = "tasks.txt";

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


    public void saveTasksToFile() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_NAME))) {
            for (Task task : tasks) {
                // Сохраняем данные
                writer.println(task.getId() + "|" + task.getTitle() + "|" + task.getPriority() + "|" + task.isCompleted());
            }
        } catch (IOException e) {
            System.out.println("Ошибка при сохранении: " + e.getMessage());
        }
    }

    public void loadTasksFromFile() {
        File file = new File(FILE_NAME);
        if (!file.exists()) return;

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|"); // Разделяем строку по символу |
                if (parts.length >= 3) {
                    int id = Integer.parseInt(parts[0]);
                    String title = parts[1];
                    String priority = parts[2];
                    boolean completed = Boolean.parseBoolean(parts[3]);

                    Task task = new Task(id, title, priority);
                    task.setCompleted(completed);
                    tasks.add(task);

                    // Обновляем nextId, чтобы новые задачи не имели тот же ID
                    if (id >= nextId) nextId = id + 1;
                }
            }
        } catch (IOException | NumberFormatException e) {
            System.out.println("Ошибка при загрузке: " + e.getMessage());
        }
    }
    // ----------------------------------

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