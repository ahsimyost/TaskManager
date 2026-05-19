public class Task { // Это бывшая строка 2, теперь она главная
    private int id;
    private String title;
    private String priority;
    private boolean isCompleted;

    public Task(int id, String title, String priority) {
        this.id = id;
            this.title = title;
            this.priority = priority;
            this.isCompleted = false;
        }

        public int getId() { return id; }

        public String getTitle() { return title; }
        public void setTitle(String title) { this.title = title; }

        public String getPriority() { return priority; }
        public void setPriority(String priority) { this.priority = priority; }

        public boolean isCompleted() { return isCompleted; }
        public void setCompleted(boolean completed) { isCompleted = completed; }

        @Override
        public String toString() {
            String status = isCompleted ? "[X]" : "[ ]";
            return id + ". " + status + " " + title + " (" + priority + " приоритет)";
        }
    }
