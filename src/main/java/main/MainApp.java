package main;

import db.Repository;
import model.Task;
import model.TaskRepository;
import swing.Window;

import javax.swing.*;
import java.awt.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class MainApp {
    public static void main(String[] args) throws ParseException {
        AppUtils.getInstance().setTaskList(TaskRepository.getInstance().getAll());



        JFrame frame = new JFrame("Procena otpadnog materijala pri sečenju proče");
        frame.setSize(new Dimension(600, 938));
        JPanel panel = new Window();
        frame.add(panel);
        frame.setVisible(true);
    }
}
