package com.javarush.task.task31.task3111;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

public class SearchFileVisitor extends SimpleFileVisitor<Path> {
    private String partOfName;
    private String partOfContent;
    private int minSize;
    private int maxSize;
    private List<Path> foundFiles = new ArrayList<>();

    public void setPartOfName(String partOfName) {
        this.partOfName = partOfName;
    }

    public void setPartOfContent(String partOfContent) {
        this.partOfContent = partOfContent;
    }

    public void setMinSize(int minSize) {
        this.minSize = minSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    public List<Path> getFoundFiles() {
        return foundFiles;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        byte min = (byte) minSize;
        byte max = (byte) maxSize;

        if ((min == 0 || Files.size(file) >= minSize) && (max == 0 || Files.size(file) <= maxSize)) {
            if (partOfName == null || file.getFileName().toString().contains(partOfName)) {
                if (partOfContent == null) {
                    foundFiles.add(file);
                } else {
                    String string = new String(Files.readAllBytes(file));
                    if (string.contains(partOfContent)) {
                        foundFiles.add(file);
                    }
                }
            }
        }
        return super.visitFile(file, attrs);
    }
}
