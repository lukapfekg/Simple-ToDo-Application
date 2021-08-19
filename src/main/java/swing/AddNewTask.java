package swing;

import main.AppUtils;
import model.Task;
import model.TaskRepository;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.sql.Date;

public class AddNewTask {


    AddNewTask(){
    }

    public void main(String[] args){
        showWindow();
    }



    public void showWindow() {

        JFrame frame = new JFrame("Window2");
        frame.setBounds(100,100,450,170);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        JTextField tf = new JTextField();
        tf.setBounds(20,40,200,50);

        JLabel greska = new JLabel("Polje ne sme biti prazano");
        greska.setBounds(20,50,200,100);
        greska.setFont(new Font("Calibri", Font.PLAIN, 14));
        greska.setForeground(Color.RED);

        greska.setVisible(false);

        JButton b = new JButton("Add New Task");
        b.setBounds(270,30,150,70);
        b.addActionListener(l->{
            if(!tf.getText().isBlank()) {
                greska.setVisible(false);
                frame.setVisible(false);
                Task t = new Task();//******************************************************
                t.setDone(false);
                t.setText(tf.getText());
                AppUtils.getInstance().getTaskList().add(t);
                DataPanel.getInstance().repaintGraphic();
                tf.setText("");
                TaskRepository.getInstance().persist(t);
            }
            else {
                greska.setVisible(true);
            }
        });


        frame.add(greska);
        frame.add(b);
        frame.add(tf);
        frame.setVisible(true);

    }


}