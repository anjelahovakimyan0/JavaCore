package homework.fileutil;

public class FileUtilTest {

    public static void main(String[] args) {
        String filePath = "C:\\Users\\sky\\IdeaProjects\\JavaCore0\\example";
        String fileName = "mytext.txt";

        FileUtil.fileSearch(filePath, fileName);
        FileUtil.createFileWithContent(filePath, "newFile.txt", "Hello from Java");
        System.out.println(FileUtil.printSizeOfPackage(filePath));
        FileUtil.contentSearch(filePath, "k");
        FileUtil.findLines(filePath, "W");
    }
}
