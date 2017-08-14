package com.javarush.task.task32.task3209;

import com.javarush.task.task32.task3209.listeners.FrameListener;
import com.javarush.task.task32.task3209.listeners.TabbedPaneChangeListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by arseniy.barsegyan on 14.08.2017.
 */
public class View extends JFrame implements ActionListener {
    private Controller controller;
    private JTabbedPane tabbedPane = new JTabbedPane();
    private JTextPane htmlTextPane = new JTextPane();
    private JEditorPane plainTextPane = new JEditorPane();

    public Controller getController() {
        return controller;
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public void init() {
        initGui();
        FrameListener listener = new FrameListener(this);
        addWindowListener(listener);
        setVisible(true);
    }

    public void exit() {
        controller.exit();
    }

    public void initMenuBar() {}

    public void initEditor() {
        htmlTextPane.setContentType("text/html");
        JScrollPane htmlPane = new JScrollPane(htmlTextPane);
        tabbedPane.addTab("HTML", htmlPane);

        JScrollPane textPane = new JScrollPane(plainTextPane);
        tabbedPane.addTab("Текст", textPane);

        tabbedPane.setPreferredSize(new Dimension(400, 400));
        TabbedPaneChangeListener tabbedPaneChangeListener = new TabbedPaneChangeListener(this);
        tabbedPane.addChangeListener(tabbedPaneChangeListener);

        getContentPane().add(tabbedPane, BorderLayout.CENTER);
    }

    public void initGui() {
        initMenuBar();
        initEditor();
        pack();
    }

    public void selectedTabChanged() {}
}
