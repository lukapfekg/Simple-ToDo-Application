package swing;

import db.HibernateUtil;
import main.AppUtils;
import model.TaskRepository;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ControlPanel extends JPanel {
    private JButton add;
    private JButton quit;
    private JButton select;
    private JButton delete;
    public ArrayList<Integer> selectForDelete = new ArrayList<Integer>();
    public boolean selected = false;
    private static ControlPanel instance = null;

    private ControlPanel(){
        setLayout(null);
        initButtonAdd();
        initButtonQuit();
        initButtonSelect();
        initButtonDelete();
        setBackground(Color.GRAY);
    }

    private void initButtonAdd(){
        add = new JButton("ADD TASK");
        add.setBounds(240,5,100,100);
        add.setBackground(Color.DARK_GRAY);
        add.setFont(new Font("Calibri", Font.PLAIN, 14));
        add.setForeground(Color.white);
        add.addActionListener(l ->{
            AddNewTask f = new AddNewTask();
            f.showWindow();
        });

        this.add(add);
    }

    private void initButtonQuit(){
        quit = new JButton("Quit");
        quit.setBounds(460,5,100,100);
        quit.setBackground(Color.DARK_GRAY);
        quit.setForeground(Color.white);
        Border line = new LineBorder(Color.BLACK);
        Border margin = new EmptyBorder(5, 15, 5, 15);
        Border compound = new CompoundBorder(line, margin);
        quit.setBorder(compound);
        quit.setFont(new Font("Calibri", Font.PLAIN, 14));
        quit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                HibernateUtil.shutdown();
                JComponent comp = (JComponent) e.getSource();
                Window win = SwingUtilities.getWindowAncestor(comp);
                ((java.awt.Window) win).dispose();
            }
        });

        this.add(quit);
    }

    private void initButtonSelect(){
        select = new JButton("Select");
        select.setBounds(20,5,100,100);
        select.setBackground(Color.DARK_GRAY);
        select.setForeground(Color.white);
        select.setFont(new Font("Calibri", Font.PLAIN, 14));
        select.addActionListener(l->{
            this.selected = !this.selected;
            if(this.selected){
                select.setText("Deselect");
            }else{
                select.setText("Select");
            }
            delete.setVisible(selected);
            add.setVisible(!selected);

            DataPanel.getInstance().repaint();
        });

        add(select);
    }

    private void initButtonDelete(){
        delete = new JButton("Delete");
        delete.setBounds(130,5,100,100);
        delete.setBackground(Color.DARK_GRAY);
        delete.setForeground(Color.white);
        delete.setFont(new Font("Calibri", Font.PLAIN, 14));
        delete.addActionListener(l->{
            for (Integer integer : selectForDelete) {
                System.out.println("integer - " + integer);
                TaskRepository.getInstance().deleteRow(integer);
            }
            for(int i = 0; i < AppUtils.getInstance().getTaskList().size(); i++){
                if(selectForDelete.contains(AppUtils.getInstance().getTaskList().get(i).getId())){
                    AppUtils.getInstance().getTaskList().remove(i);
                }
            }
            selectForDelete.clear();
            select.setText("Select");
            delete.setVisible(false);
            add.setVisible(true);
            DataPanel.getInstance().repaint();
        });

        add(delete);
        delete.setVisible(false);
    }

    public void output(){
        DataPanel.getInstance().repaint();
    }

    public static ControlPanel getInstance(){
        if(instance == null)
            instance = new ControlPanel();
        return instance;
    }


}