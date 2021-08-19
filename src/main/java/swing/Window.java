package swing;

import javax.swing.*;

public class Window extends JPanel {

    private JPanel addTask;
    private JPanel graphic;


    public Window() {
        setLayout(null);

        addTask = ControlPanel.getInstance();
        addTask.setBounds(0, 790, 600, 200);

        graphic = DataPanel.getInstance();
        graphic.setBounds(0,0,600,790);



        add(addTask);

        add(graphic);
    }

}
