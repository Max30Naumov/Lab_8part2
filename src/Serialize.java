import java.io.*;
import java.sql.Timestamp;

public class Serialize implements Serializable {
    /**
     * Сохранить объект в файл, название -- метка времени
     */
    public static void Save(Workers o) {
        try
        {
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            FileOutputStream fos = new FileOutputStream("database/" + timestamp.getTime() + ".txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(o);
            oos.close();
            fos.close();
        }
        catch (IOException ioe)
        {
            ioe.printStackTrace();
        }
    }

    /**
     * Найти последний модифицированный файл в директории
     * @param dirPath
     * @return последний модифицированный файл
     */
    private static File getLatestFilefromDir(String dirPath){
        File dir = new File(dirPath);
        File[] files = dir.listFiles();
        if (files == null || files.length == 0) {
            return null;
        }

        File lastModifiedFile = files[0];
        for (int i = 1; i < files.length; i++) {
            if (lastModifiedFile.lastModified() < files[i].lastModified()) {
                lastModifiedFile = files[i];
            }
        }
        return lastModifiedFile;
    }

    /**
     * Загрузить объекты с последнего отредактированного файла обратно в список объектов
     */
    public static Workers Load() {
        try
        {
            File file = getLatestFilefromDir("database");
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            Workers result = (Workers) ois.readObject();
            ois.close();
            fis.close();
            return result;
        }
        catch (IOException ioe)
        {
            ioe.printStackTrace();
            return new Workers();
        }
        catch (ClassNotFoundException c)
        {
            System.out.println("Class not found");
            c.printStackTrace();
            return new Workers();
        }

    }
}
