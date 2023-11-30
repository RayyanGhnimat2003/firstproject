package com.example.myfirstassignment;
import java.util.ArrayList;
import java.util.List;

public class Tasks {
    public static List<String> tasks2 = new ArrayList<>();
    public static List<String> tasks3= new ArrayList<>();

    private String taskName;
    private String Date;
    private String taskDescription;
    private boolean isfinished;
    private int imageiD;
    public static final Tasks[] tasks = {
            new Tasks("Morning Tasks","12/11/2023",true,"should not eat unhealthy food "),
            new Tasks("Night Tasks","13/11/2023",false,"You should exercise for an hour and practice yoga after that for ten minutes to meditate "),
    };




    public Tasks(String taskName) {
        this.taskName = taskName;
    }

    public Tasks(String taskName, String date, boolean isfinished, String taskDescription) {
        this.taskName = taskName;
        Date = date;
        this.isfinished = isfinished;
        this.taskDescription = taskDescription;
    }

    public Tasks(String taskName,String taskDescription,  int imageiD) {
        this.taskName = taskName;

        this.taskDescription = taskDescription;
        this.imageiD = imageiD;
    }

    public Tasks(String taskName, boolean isfinished) {
        this.taskName = taskName;
        this.isfinished = isfinished;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public boolean isStatues() {
        return isfinished;
    }

    public void setStatues(boolean statues) {
        this.isfinished = statues;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }
    public static final Tasks[] tasks33 = {
            new Tasks("Eat Dinner"),
            new Tasks(" Read a book"), new Tasks("Read Quran"),
    };
    public static final Tasks[] tasks4 = {
            new Tasks("eat Breakfast","Should eat healthy food",R.drawable.breakfast),
            new Tasks("do yoga","There are various styles of yoga, ranging from the vigorous ",R.drawable.yoga),
            new Tasks("Study Andoid","Review the previous lecture and prepare for the new one",R.drawable.andord),

    };

    /*public String toString1() {
        return "Tasks{" +
                "taskName='" + taskName + '\'' +
                ", Date='" + Date + '\'' +
                ", statues=" + isfinished +
                ", taskDescription='" + taskDescription + '\'' +
                '}';
    }
*/
    @Override
    public String toString() {
        return  taskName
                ;
    }


}
