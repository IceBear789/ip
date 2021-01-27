package main.java;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;

class TaskList {
    private ArrayList<Task> taskList;

    public TaskList() {
        this.taskList = new ArrayList<>();
        File file = new File("./data/duke.txt");
        try {
            if (file.exists()) {
                Storage.convert(file, this.taskList);
            }
        } catch (IOException exception) {
            System.out.println(exception);
        }
    }

    public void listTask() {
        System.out.println("Here are the tasks in your list:");
        for (int i = 0; i < taskList.size(); i++) {
            Task currTask = taskList.get(i);
            System.out.println(i + 1 + "." + currTask);
        }
    }

    public void doneTask(int index) throws DukeException {
        if (this.taskList.size() >= index) {
            Task currTask = this.taskList.get(index - 1);
            currTask.completeTask();
            System.out.println("Nice! I've marked this task as done:");
            System.out.println("  " + currTask);
        } else {
            System.out.println("Task not found");
        }
        Storage.update(this.taskList);
    }

    public void delete(int index) {
        int deleteIndex = index;
        if (this.taskList.size() >= deleteIndex) {
            System.out.println("Noted. I've removed this task:");
            System.out.println("  " + this.taskList.remove(deleteIndex - 1));
            System.out.println(this);
        } else {
            System.out.println("Task not found");
        }
        Storage.update(this.taskList);
    }

    public void addToDo(String taskName) {
        ToDo newTask = new ToDo(taskName);
        this.taskList.add(newTask);
        System.out.println("Got it. I've added this task:");
        System.out.println("  " + newTask);
        System.out.println(this);
        Storage.update(this.taskList);
    }

    public void addEvent(String taskName, LocalDate date) {
        Event newTask = new Event(taskName, date);
        this.taskList.add(newTask);
        System.out.println("Got it. I've added this task:");
        System.out.println("  " + newTask);
        System.out.println(this);
        Storage.update(this.taskList);
    }

    public void addDeadline(String taskName, LocalDate date) {
        Deadline newTask = new Deadline(taskName, date);
        this.taskList.add(newTask);
        System.out.println("Got it. I've added this task:");
        System.out.println("  " + newTask);
        System.out.println(this);
        Storage.update(this.taskList);
    }

    @Override
    public String toString() {
        if (this.taskList.size() == 1) {
            return "Now you have " + this.taskList.size() + " task in the list";
        } else {
            return "Now you have " + this.taskList.size() + " tasks in the list";
        }
    }
}