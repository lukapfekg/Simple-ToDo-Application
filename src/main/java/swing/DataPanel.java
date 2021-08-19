package swing;

import main.AppUtils;
import main.Tag;
import model.Task;
import model.TaskRepository;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;


public class DataPanel extends JPanel {
    private Graphics g;
    private ArrayList<Tag> tagList = new ArrayList<Tag>();

    private static DataPanel instance = null;

    private DataPanel(){
        setLayout(null);
        setBackground(Color.WHITE);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                for(int i = 0; i < tagList.size(); i++){
                    if(tagList.get(i).isInTag(e.getX(), e.getY())){
                        if(ControlPanel.getInstance().selected){
                            ControlPanel.getInstance().selectForDelete.add(AppUtils.getInstance().getTaskList().get(i).getId());
                        }else {
                            tagList.get(i).setSelected();
                            Task task = AppUtils.getInstance().getTaskList().get(i);
                            task.setDone(!task.getDone());
                            TaskRepository.getInstance().update(task);
                        }
                        break;
                    }
                }

                repaint();
            }
        });

    }

    public void paint(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        g.setFont(new  Font("Calibri", Font.PLAIN, 20));
        tagList.clear();
        for(int i = 0; i < AppUtils.getInstance().getTaskList().size(); i++){
            Tag t = new Tag(10, 30*i+20, 20, AppUtils.getInstance().getTaskList().get(i).getDone());
            tagList.add(t);
        }


        if(ControlPanel.getInstance().selected){
            for (int i = 0; i < tagList.size(); i++) {
                g.fillOval(tagList.get(i).getX(), tagList.get(i).getY(), tagList.get(i).getR(), tagList.get(i).getR());
                g.setColor(Color.WHITE);
                if (ControlPanel.getInstance().selectForDelete.contains(AppUtils.getInstance().getTaskList().get(i).getId())) g.setColor(Color.ORANGE);
                drawInnerCircle(g, i);

            }
        }else {
            for (int i = 0; i < tagList.size(); i++) {
                g.fillOval(tagList.get(i).getX(), tagList.get(i).getY(), tagList.get(i).getR(), tagList.get(i).getR());
                g.setColor(Color.WHITE);
                if (tagList.get(i).isSelected()) g.setColor(Color.GREEN);
                drawInnerCircle(g, i);

            }
        }
    }

    private void drawInnerCircle(Graphics g, int i) {
        g.fillOval(tagList.get(i).getX() + 3, tagList.get(i).getY() + 3, tagList.get(i).getR() - 6, tagList.get(i).getR() - 6);

        g.setColor(Color.BLACK);
        g.drawString(AppUtils.getInstance().getTaskList().get(i).getText(), 40, 30 * i + 37);
    }

    public static DataPanel getInstance(){
        if(instance == null){
            instance = new DataPanel();
        }
        return instance;
    }

    public void repaintGraphic(){
        repaint();
    }



}
