package sg.edu.nus.iss;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class App 
{
    public static void main( String[] args ) throws Exception
    {
        Map<String, String> wordPair = new HashMap<>();
        Map<Map<String, String>, Integer> nextWordFreqMap = new HashMap<>();
        List<String> fileOut = new LinkedList<>();
        String line = "";

         try {
            // Create a file object
            File f = new File(args[0]);
  
            File[] files = f.listFiles();
  
            System.out.println("Files are: ");
  
            // Displays the names of the files, put 'frost' or 'seuss' as arguments when running App.java
            for (File file : files) {
                String fileName = file.getName();
                System.out.println(fileName);

                FileReader fr = new FileReader(args[0] + "/" + fileName);
                BufferedReader br = new BufferedReader(fr);

                StringBuilder sbFileContent = new StringBuilder();

                //read until end of file and append to sbFileContent
                while (null != (line = br.readLine())){
                    sbFileContent.append(line);
                }
        
                br.close();
                fr.close();

                //strips all punctuation and use .LowerCase() to ensure words of different cases treated as the same
                String fileContent = sbFileContent.toString().toLowerCase();
                fileContent = fileContent.replaceAll("\\p{Punct}", " ");
                String [] fileContentArray = fileContent.split("\\s+");



                for (int i = 0; i < fileContentArray.length; i++) {
                    Integer wordMatches = 0;
                    Integer totalMatches = 0;
                    String word = fileContentArray[i];
                    String nextWord = "";

                    //to ensure nextWord won't go beyond last entry of fileContentArray
                    if (i < fileContentArray.length - 1){
                        nextWord = fileContentArray[i + 1];
                    }
                    
                    wordPair.putIfAbsent(word, nextWord);
                    nextWordFreqMap.putIfAbsent(wordPair, 1);
                    
                    if (nextWordFreqMap.containsKey(wordPair)){
                        Integer value = nextWordFreqMap.get(wordPair); // get current frequency of wordPair
                        nextWordFreqMap.put(wordPair, value + 1); //updates wordpair frequency if another wordPair is found
                     
                    }
                    else {
                        nextWordFreqMap.put(wordPair, 0); 
                    }
                }

                Map<String, Integer> pairCount = new HashMap<>();
                nextWordFreqMap
                    .forEach((k1,v1) -> k1.forEach((k2, v2) -> System.out.println(k2 + "\n    " + v2 + " " + v1)));

                    // Attempts to group all nextWord that share the same (first) word.
                    // nextWordFreqMap
                        // .map(k -> k.toString())
                        // .collect(Collectors.groupingBy(key -> map.get(key)))
                        // .collect((k,v) -> Collectors.groupingBy(key -> k.get(key)))
                    // pairCount.map(Map.Entry::getValue)
                        // .collect(Collectors.toList());

                    // Arrays.toString(pairCount);
                    
                    // // .collect(Collectors.groupingBy(key -> map.get));
                    // System.out.println(pairCount);

                    // .forEach((k, v) -> System.out.printf("pair = %s",k));
                    // nextWordFreqMap
                    // .forEach((k, v) -> System.out.println(v));



                    // Attempts to sum all nextWord frequencies for each (first) word,  
                    // so probability can be computed, by nextWordFrequency/sum
                    // int sum = pairCount
                    //     .values()
                    //     .stream()
                    //     // .mapToInt(Integer::parseInt)
                    //     .mapToInt(num -> Integer.parseInt(num))
                    //     .sum();
                    // System.out.println(sum);







            }
        }
        catch (Exception e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
    }














    }

