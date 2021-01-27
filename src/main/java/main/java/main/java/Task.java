package main.java;
import java.time.LocalDate;

abstract class Task {
    protected final String taskName;
    protected boolean isDone;

    public Task(String taskName) {
        this.taskName = taskName;
        this.isDone = false;
    }

    public Task(String taskName, boolean isDone) {
        this.taskName = taskName;
        this.isDone = isDone;
    }

    protected void completeTask() {
        this.isDone = true;
    }

    public String getTaskName() {
        return this.taskName;
    }

    public static String printDate(LocalDate date) {
        String month = date.getMonth().toString().substring(0,3);
        String[] splitDate = date.toString().split("-");
        String year = splitDate[0];
        String day = splitDate[2];
        return month.substring(0,1) + month.substring(1,3).toLowerCase() +
                " " + day + " " + year;
    }

    protected boolean isComplete() {
        return this.isDone;
    }
}