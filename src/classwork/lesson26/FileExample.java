package classwork.lesson26;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class FileExample {

    public static void main(String[] args) throws IOException {
        String filePath = "C:\\Users\\sky\\IdeaProjects\\JavaCore0\\src\\classwork\\chapter13\\test\\folder";
        String filePathTxt = "C:\\Users\\sky\\IdeaProjects\\JavaCore0\\src\\classwork\\chapter13\\test\\newFile.txt";
        File fileTxt = new File(filePathTxt);
        fileTxt.setLastModified(213246);
        File fileDir = new File(filePath + File.separator + "newFolder\\a\\b");

        File file1Dir = new File(filePath + File.separator + "newFolder1");
        file1Dir.mkdir();

        File file2Dir = new File(filePath + File.separator + "newFolder2");
        file2Dir.mkdir();

        if (!fileDir.exists()) {
            System.out.println(fileDir.mkdirs());
        }

        String documentFilePath = "C:\\Users\\sky\\IdeaProjects\\JavaCore0\\src\\classwork\\chapter13\\test\\document.docx";
        File documentFile = new File(documentFilePath);
        documentFile.setReadOnly();

        String notesFilePath = "C:\\Users\\sky\\IdeaProjects\\JavaCore0\\src\\classwork\\chapter13\\test\\notes.txt";
        String newNotesFilePath = "C:\\Users\\sky\\IdeaProjects\\JavaCore0\\src\\classwork\\chapter13\\test\\notes123.txt";
//        String fileName = "FileExample.java";
//        String filePath = directoryPath + File.separator + fileName;
        File file = new File(filePath);

        File renameFile = new File(notesFilePath);
        boolean result = renameFile.renameTo(new File(newNotesFilePath));
        System.out.println("result: " + result);

        System.out.println();

        File parent = file.getParentFile();
        String parentOfParent = parent.getParent();
        System.out.println(parentOfParent);

        System.out.println();

        System.out.println(file.getCanonicalFile());
        System.out.println(file.getAbsolutePath());

        if (!file.exists()) {
            try {
                file.createNewFile();
                System.out.println("File created!");
            } catch (IOException e) {
                System.out.println("Can not create file " + e);
            }
        } else {
            System.out.println("File NOT created!");
        }

//        if(file.exists()) {
//            if (file.delete()) {
//                System.out.println("Deleted");
//            }
//        }

        System.out.println(file.exists());
        System.out.println(file.isFile());

        if (file.isDirectory()) {
            String[] list = file.list();
            for (String name : list) {
                System.out.println(name);
            }
        }

        if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (File f : files) {
                if (f.isFile()) {
                    System.out.println(f.getAbsolutePath());
                    System.out.println(f.getName() + " " + f.length() + " " + new Date(f.lastModified()) + " " + f.canWrite());
                }
                System.out.println();
            }
        }

        System.out.println(file.getTotalSpace());
        System.out.println(file.getUsableSpace());
        System.out.println(file.getFreeSpace());
    }
}
