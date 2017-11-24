package org.cmpiler.kotlin.ide.view.panel;


import javax.swing.*;
import java.awt.*;
import org.cmpiler.kotlin.ide.model.SharedData;

public class ConsolePanel extends JPanel {
    JTextPane txt_textArea;
    JScrollPane scl_scroll;
    public ConsolePanel(int w, int h) {
        super();
        txt_textArea = SharedData.getInstance().getConsoleTextArea();
        txt_textArea.setEditable(false);
        //txt_textArea.setFont(new Font( "Courier New", Font.PLAIN, 15));
        txt_textArea.setForeground(Color.WHITE);
        txt_textArea.setBackground(Color.BLACK);
        txt_textArea.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
        scl_scroll = new JScrollPane(txt_textArea);
        scl_scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scl_scroll.setPreferredSize(new Dimension(w - 16, h));
        this.add(scl_scroll);
    }
}
