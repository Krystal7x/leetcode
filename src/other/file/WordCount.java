package other.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 描述:
 *
 * @author luokui
 * @create 2021-04-16 8:18 PM
 */
public class WordCount {


    public static HashMap<String, Integer> wordsCount(String filepath) throws IOException {
        File file = new File(filepath);
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        String line;
        HashMap<String, Integer> wordCount = new HashMap<>();
        while ((line = bufferedReader.readLine()) != null) {
            String[] str = line.split(" ");
            for (String word : str) {
                if (!word.equals(""))
                    wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
            }
        }
        bufferedReader.close();
        return wordCount;
    }


    public static HashMap<String, Integer> concurrentWordsCount(String[] args) {
        if (args == null || args.length == 0) return null;
        try {
            int num = args.length;
            ExecutorService executorService = Executors.newFixedThreadPool(5);
            //CountDownLatch latch = new CountDownLatch(num);
            //1、多线程提交任务
            Future[] futureArr = new Future[num];
            for (int i = 0; i < num; i++) {
                //文件
                String filepath = args[i];
                futureArr[i] = executorService.submit(() -> {
                    try {
                        HashMap<String, Integer> wordCount = wordsCount(filepath);
                        //latch.countDown();
                        return wordCount;
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    return null;
                });
            }
            //等待全部线程执行完毕
            //latch.await();
            executorService.shutdown();
            //循环结果，合并得到map
            HashMap<String, Integer> wordCount = new HashMap<>();
            for (int i = 0; i < num; i++) {
                HashMap<String, Integer> one = (HashMap<String, Integer>) futureArr[i].get();
                if (one != null) {
                    for (String word : one.keySet()) {
                        wordCount.put(word, wordCount.getOrDefault(word, 0) + one.get(word));
                    }
                }
            }
            return wordCount;


        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    public static void main(String[] args) {
        HashMap<String, Integer> wordCount = concurrentWordsCount(new String[]{"/Users/luokui/code/java1", "/Users/luokui/code/java2"});
        if (wordCount != null) {
            for (String word : wordCount.keySet()) {
                System.out.println(word + " " + wordCount.get(word));
            }
        }
        return;

    }
}
