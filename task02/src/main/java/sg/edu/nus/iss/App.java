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

/**
 * Hello world!
 *
 */
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
  
            // Displays the names of the files, put 'frost' or 'seuss' as argument when running App.java
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

   
                String fileContent = sbFileContent.toString().toLowerCase();
                fileContent = fileContent.replaceAll("[\\W]", " ");
                String [] fileContentArray = fileContent.split("\\s+");

                
                // Stream<String> stream1 = Arrays.stream(fileContentArray);
                // stream1.


                for (int i = 0; i < fileContentArray.length; i++) {
                    Integer wordMatches = 0;
                    Integer totalMatches = 5;
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

                nextWordFreqMap.forEach((k,v) -> {
                    System.out.println(k + "[" + v + "]");
                });


                // System.out.println(nextWordFreqMap.toString());
                // System.out.println(Arrays.asList(nextWordFreqMap) + nextWordFreqMap);
















                // for (String word: fileContentArray){
                //     Integer wordCount = nextWordFreqMap.get(word);

                //     if (wordCount == null){
                //         nextWordFreqMap.put(word, 1);
                //     }
                //     else {
                //         nextWordFreqMap.put(word, wordCount + 1);
                //     }
                // }

                // System.out.println(fileContentArray.toString());

                // .collect(Collectors.toList());
            //     fileOut = br.lines()

            // .filter(line -> !line.contains("NaN")) // lines that don't have NaN

            // .map(line -> line.split("[\n]+"))
            // .flatMap(words -> Arrays.asList(words).stream())
            // .map(line -> line + "\n\n\n")
            // .collect(Collectors.toList());
            // fileOut.forEach(arr -> System.out.println(Arrays.toString(arr))); //to print line by line, use on List<String[]> without flatMap operation
            // System.out.println(fileOut);
            // System.out.println(sbFileContent);
            
            
            // System.out.println(Arrays.toString(fileOut.toArray()));
            // System.out.println(fileOut.toArray());
            // fileOut.stream().forEach(System.out::println);
            // System.out.println(fileOut);
           


            }
        }
        catch (Exception e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
    }














    }

