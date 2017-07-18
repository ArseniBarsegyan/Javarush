package com.javarush.task.task31.task3110;

import com.javarush.task.task31.task3110.exception.PathIsNotFoundException;
import com.sun.nio.zipfs.ZipPath;

import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * Created by arseniy.barsegyan on 18.07.2017.
 */
public class ZipFileManager {
    private Path zipFile;

    public ZipFileManager(Path zipFile) {
        this.zipFile = zipFile;
    }

    public void createZip(Path source) throws Exception {
        Path path = zipFile.getParent();
        if (Files.notExists(path)) {
            Files.createDirectories(path);
        }

        try(ZipOutputStream zipOutputStream = new ZipOutputStream(Files.newOutputStream(zipFile)))
        {
            if (Files.isRegularFile(source)) {
                addNewZipEntry(zipOutputStream, source.getParent(), source.getFileName());
            } else if (Files.isDirectory(source)) {
                FileManager manager = new FileManager(source);
                List<Path> fileNames = manager.getFileList();
                for (Path fileName : fileNames) {
                    addNewZipEntry(zipOutputStream, source, fileName);
                }
            } else {
                throw new PathIsNotFoundException();
            }
        }
    }

    private void addNewZipEntry(ZipOutputStream zipOutputStream, Path filePath, Path fileName) throws Exception {
        try (InputStream zipInputStream = Files.newInputStream(filePath.resolve(fileName))) {
            ZipEntry entry = new ZipEntry(fileName.toString());
            zipOutputStream.putNextEntry(entry);
            copyData(zipInputStream, zipOutputStream);
            zipOutputStream.closeEntry();
        }
    }

    private void copyData(InputStream in, OutputStream out) throws Exception {
        while (in.available() > 0) {
            out.write(in.read());
        }
    }
}
