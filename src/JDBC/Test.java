package JDBC;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.*;

public class Test {

    public static final  String URL = "jdbc:mysql://localhost:3306/java_db?useSSL=false";
    public static final String USERNAME = "root";
    public static final String PASSWORD = "4773";

    public static void main(String[] args) throws IOException {

        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             Statement statement = connection.createStatement()){

//            statement.executeUpdate("CREATE TABLE array (array_id INT PRIMARY KEY NOT NULL AUTO_INCREMENT, array_name VARCHAR(30) NOT NULL, img BLOB );");

            BufferedImage image = ImageIO.read(new File("tables.jpg")); // читаем картинку
            Blob blob = connection.createBlob(); // blob для хранения картинкки
            try (OutputStream outputStream = blob.setBinaryStream(1)) {
                ; // необходимо для указания позиции
                ImageIO.write(image, "jpg", outputStream); // запись файла
            }
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO array (array_name, img) VALUES (?,?);");
            preparedStatement.setString(1, "image");
            preparedStatement.setBlob(2, blob);
            preparedStatement.execute();


            ResultSet resultSet = statement.executeQuery("SELECT * FROM array;");

            while (resultSet.next()) {
                Blob blob1 = resultSet.getBlob("img"); // Все это вывод с перезаписью
                BufferedImage image1 = ImageIO.read(blob.getBinaryStream());
                File outputFile = new File("saved_tables.jpg");
                ImageIO.write(image1, "png", outputFile);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
