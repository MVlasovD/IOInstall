import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        StringBuilder infoFile = new StringBuilder();
        final String C_DIR = "Создана директория ";
        final String C_FILE = "Создан файл ";
        final String N = "\n";

        //        src,res,savegames,temp
        File src = new File("C://Games/Games/", "src");
        File res = new File("C://Games/Games/", "res");
        File savegames = new File("C://Games/Games/", "savegames");
        File temp = new File("C://Games/Games/", "temp");

        src.mkdir();
        infoFile.append(C_DIR + src + N);
        res.mkdir();
        infoFile.append(C_DIR + res + N);
        savegames.mkdir();
        infoFile.append(C_DIR + savegames + N);
        temp.mkdir();
        infoFile.append(C_DIR + temp + N);

        //        main, test in src
        File main = new File("C://Games/Games/src/", "main");
        File test = new File("C://Games/Games/src/", "test");
        main.mkdir();
        infoFile.append(C_DIR + main + N);
        test.mkdir();
        infoFile.append(C_DIR + test + N);

        //        Main.java, Utils.java
        File file1 = new File(main, "Main.java");
        File file2 = new File(main, "Utils.java");
        try {
            file1.createNewFile();
            infoFile.append(C_FILE + file1 + N);
            file2.createNewFile();
            infoFile.append(C_FILE + file2 + N);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //        drawables, vectors, icons
        File drawables = new File(res, "drawables");
        File vectors = new File(res, "vectors");
        File icons = new File(res, "icons");
        drawables.mkdir();
        infoFile.append(C_DIR + drawables + N);
        vectors.mkdir();
        infoFile.append(C_DIR + vectors + N);
        icons.mkdir();
        infoFile.append(C_DIR + icons + N);

        //        temp.txt
        File tempFile = new File(temp, "temp.txt");
        try {
            tempFile.createNewFile();
            infoFile.append(C_FILE + tempFile + N);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //запись в файл
        try (FileWriter inFile = new FileWriter(tempFile, false)) {
            inFile.write(String.valueOf(infoFile));
            inFile.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        //вывод в консоль
        System.out.println(infoFile);
    }
}