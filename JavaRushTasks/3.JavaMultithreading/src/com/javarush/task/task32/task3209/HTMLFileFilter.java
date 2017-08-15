package com.javarush.task.task32.task3209;

import javax.swing.filechooser.FileFilter;
import java.io.File;

/**
 * Created by Administrator on 15.08.2017.
 */
public class HTMLFileFilter extends FileFilter {
    @Override
    public boolean accept(File f) {
        String extension = f.getName().toLowerCase().substring(f.getName().lastIndexOf('.'));
        return f.isDirectory() || extension.equals(".html") || extension.equals(".htm");
    }

    @Override
    public String getDescription() {
        return "HTML и HTM файлы";
    }
}
