package mainthread;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpConnection {
    public static void main(String[] args) {
        try {
            //Mở kết nối để gọi dữ liệu lên sever trang web
            URL url = new URL("https://www.w3schools.com/js/json_demo_array.txt");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()));
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
            br.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}