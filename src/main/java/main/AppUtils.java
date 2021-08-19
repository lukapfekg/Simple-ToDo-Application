package main;

import model.Task;

import java.util.ArrayList;
import java.util.List;

public class AppUtils {
    private static AppUtils instance;
    private List<Task> taskList;
    AppUtils(){
        taskList = new ArrayList<>();
    }

    public List<Task> getTaskList(){ return taskList;}

    public void setTaskList(List<Task> l ){ this.taskList = l;}

    public static AppUtils getInstance(){
        if(instance == null)
            instance = new AppUtils();
        return instance;
    }
}
