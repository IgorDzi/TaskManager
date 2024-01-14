package ui;

import service.JsonTaskProcessor;
import service.TaskManager;
import service.XmlTaskProcessor;


public class Main {
    public static void main(String[] args) {
        String filePath = "src/main/java/ui/exampletasks_save.json";
        JsonTaskProcessor jtp = new JsonTaskProcessor();
        XmlTaskProcessor xtp = new XmlTaskProcessor();

        TaskManager taskManager = new TaskManager(jtp.importTasks(filePath));
        xtp.saveTasks(taskManager.getTasks(),"src/main/java/ui/exampletasks.xml");
        jtp.saveTasks(taskManager.getTasks(),"src/main/java/ui/exampletasks_save.json");



    }
}
