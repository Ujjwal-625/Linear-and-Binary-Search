import java.io.*;
import java.util.StringTokenizer;

public class PerformanceComparison {
    public static void main(String[] args) {
        // Compare StringBuilder and StringBuffer
        compareStringConcatenation();
        
        // Read a large file and count words
        String filePath = "large_text_file.txt"; // Change to actual file path
        countWordsUsingFileReader(filePath);
        countWordsUsingInputStreamReader(filePath);
    }

    private static void compareStringConcatenation() {
        int iterations = 1_000_000;
        String text = "hello";

        // Using StringBuilder
        long startTime = System.nanoTime();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < iterations; i++) {
            sb.append(text);
        }
        long endTime = System.nanoTime();
        System.out.println("Time taken using StringBuilder: " + (endTime - startTime) / 1_000_000 + " ms");

        // Using StringBuffer
        startTime = System.nanoTime();
        StringBuffer sbf = new StringBuffer();
        for (int i = 0; i < iterations; i++) {
            sbf.append(text);
        }
        endTime = System.nanoTime();
        System.out.println("Time taken using StringBuffer: " + (endTime - startTime) / 1_000_000 + " ms");
    }

    private static void countWordsUsingFileReader(String filePath) {
        try (FileReader fr = new FileReader(filePath);
             BufferedReader br = new BufferedReader(fr)) {
            long startTime = System.nanoTime();
            int wordCount = 0;
            String line;
            while ((line = br.readLine()) != null) {
                wordCount += new StringTokenizer(line).countTokens();
            }
            long endTime = System.nanoTime();
            System.out.println("Word count using FileReader: " + wordCount);
            System.out.println("Time taken using FileReader: " + (endTime - startTime) / 1_000_000 + " ms");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void countWordsUsingInputStreamReader(String filePath) {
        try (InputStreamReader isr = new InputStreamReader(new FileInputStream(filePath));
             BufferedReader br = new BufferedReader(isr)) {
            long startTime = System.nanoTime();
            int wordCount = 0;
            String line;
            while ((line = br.readLine()) != null) {
                wordCount += new StringTokenizer(line).countTokens();
            }
            long endTime = System.nanoTime();
            System.out.println("Word count using InputStreamReader: " + wordCount);
            System.out.println("Time taken using InputStreamReader: " + (endTime - startTime) / 1_000_000 + " ms");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}