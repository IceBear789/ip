package main.java;
import java.time.LocalDate;

class Event extends Task {
    protected final LocalDate date;

    public Event(String eventInfo, LocalDate date) {
        super(eventInfo);
        this.date = date;
    }

    public Event(String eventInfo, boolean isDone, LocalDate date) {
        super(eventInfo, isDone);
        this.date = date;
    }

    protected String getDate() {
        return Task.printDate(this.date);
    }

    @Override
    public String toString() {
        if (this.isDone) {
            return "[E][X] " + this.taskName + " (at: " + Task.printDate(date) + ")";
        } else {
            return "[E][ ] " + this.taskName + " (at: " + Task.printDate(date) + ")";
        }
    }
}