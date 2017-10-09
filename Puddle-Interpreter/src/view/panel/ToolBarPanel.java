package view.panel;

import view.actions.OpenAction;
import view.actions.SaveAction;
import view.actions.TestAction;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ToolBarPanel extends JPanel {
    private ArrayList<JButton> btn_array;

    public ToolBarPanel(int w, int h){
        super();
        this.setPreferredSize(new Dimension(w, h));
        setLayout(new FlowLayout(FlowLayout.LEFT));
        initializeButtons(h);

        for(JButton btn : btn_array){
            this.add(btn);
        }

    }

    public void initializeButtons(int h){
        btn_array = new ArrayList<>();
        btn_array.add(new JButton("Open"));
        btn_array.add(new JButton("Save"));
        btn_array.add(new JButton("Test"));
        btn_array.get(0).addActionListener(new OpenAction(this));
        btn_array.get(1).addActionListener(new SaveAction(this));
        btn_array.get(2).addActionListener(new TestAction());
        for(JButton btn : btn_array){
            btn.setMaximumSize(new Dimension(100, h - 6));
        }

    }
}
