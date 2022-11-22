package main;

import main.manager.InMemoryHistoryManager;
import main.manager.Managers;
import main.manager.TaskManager;
import main.tasks.Status;
import main.tasks.*;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        TaskManager taskManager = Managers.getDefault();
        InMemoryHistoryManager inMemoryHistoryManager = new InMemoryHistoryManager();


        Task task1 = new Task("task1", "купить афобазол, а то с этими дедлайнами скоро кукуха поедет)", Status.NEW);
        taskManager.addNewTask(task1);


        Epic epicForRepair = new Epic("Epic1", "\"Сделать ремонт в зале\"");
        taskManager.addNewEpic(epicForRepair);

        SubTask subTask1 = new SubTask("subTask1", "ободрать старые обои", Status.NEW, epicForRepair.getId());
        taskManager.addSubTask(subTask1);
        SubTask subTask2 = new SubTask("subTask2", "узнать, можно ли снести стену", Status.NEW, epicForRepair.getId());
        taskManager.addSubTask(subTask2);

        System.out.println("все сабтаски эпика " + taskManager.getAllSubTaskForEpic(epicForRepair.getId()));


        System.out.println("---------------------------------------------------------------------------------------");

        System.out.println(epicForRepair.getStatus());
        System.out.println(epicForRepair.getId());


        System.out.println("Вывожу задачу по id");
        System.out.println(taskManager.getTaskById(1));

        System.out.println(taskManager.getSubTaskById(3));
        System.out.println(taskManager.getSubTaskById(4));
        System.out.println(taskManager.getSubTaskById(4));
        System.out.println(taskManager.getSubTaskById(4));
        System.out.println(taskManager.getSubTaskById(4));
        System.out.println(taskManager.getSubTaskById(4));
        System.out.println(taskManager.getSubTaskById(4));
        System.out.println(taskManager.getSubTaskById(4));
        System.out.println(taskManager.getSubTaskById(4));
        System.out.println(taskManager.getSubTaskById(4));
        System.out.println(taskManager.getSubTaskById(4));


        SubTask newSubTask1 = new SubTask("подзадача 1", "обновленная задача", Status.IN_PROGRESS, epicForRepair.getId());
        taskManager.updateSubTask(newSubTask1);

        System.out.println("---------------------------------------------------------------------------------------");

        System.out.println("Выводим все сабтаски: " + taskManager.getAllSubtasks());


        System.out.println(epicForRepair.getSubTaskIds());

        System.out.println("Выводим историю просмотров:");
        List<Task> history = inMemoryHistoryManager.getHistory();
        for (int i = 0; i < history.size(); i++) {
            System.out.println((i + 1) + "." + history.get(i));
        }
    }
}