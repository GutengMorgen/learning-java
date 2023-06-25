package com.testing;

// import java.nio.file.Files;
import java.io.File;
// import java.io.InputStream;

import static java.lang.System.*;

public class packages {
    public static void main(String[] args) {
        // out.println("hello world");

        File parentDirectory = new File("D:\\TelegramDownloads2");

        if (parentDirectory.isDirectory()) {
            out.println(parentDirectory + "\nit is a directory");

            for (File subFiles : parentDirectory.listFiles()) {
                out.println(subFiles);
            }
        } else {
            out.println(parentDirectory + "\nit is not  a directory");
        }
        // out.print(file.getPath());
    }
}
