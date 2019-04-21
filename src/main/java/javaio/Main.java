package javaio;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static <fileReader> void main(String[] args) throws IOException {
        File file = new File("src/main/resources/TomJ.txt");

        ArrayList<Video> list = new ArrayList<>();
        FileReader fileReader = new FileReader("src/main/resources/TomJ.txt");
        BufferedReader br = new BufferedReader(fileReader);

        String line;
        int count = 0;

        while ((line = br.readLine()) != null) {
            if (count == 0) {
                count++;
                continue;
            }
            System.out.println((line));
            String[] splitted = line.split("\\s{2,}");
            if (splitted.length == 4) {
                String day = splitted[0];
                String id = splitted[1];
                String title = splitted[2];

                double view = Double.parseDouble(splitted[3]);
                Video video = new Video( day, id, title, view);
                list.add(video);
                System.out.println("day :" + " " + day);
                System.out.println("id :" + " " + id);
                System.out.println("title :" + " " + title);
                System.out.println("view :" + " " + view);

            }
            count++;

        }

        HashMap<String, VideoDetail> statistic = new HashMap<>();
        for (Video video : list) {
            double currentView = 0;
            if (statistic.containsKey(video.getId())) {
                VideoDetail videoDetail = statistic.get(video.getId());
                currentView = videoDetail.getView();
            }
            currentView = currentView + video.getView();
            VideoDetail videoDetail = new VideoDetail(video.getId(), video.getTitle(), currentView);
            statistic.put(video.getId(), videoDetail);
        }

        for (String id :
                statistic.keySet()) {
            System.out.println(id);
            VideoDetail video = statistic.get(id);
            System.out.println(video.getTitle());
            System.out.println(video.getView());


        }

    }
}




