package functions;

import interfaces.FileInterface;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileWorkImpl implements FileInterface{

    private Path path;

    private final String ENCODING = "UTF-8";

    private FileWorkImpl(){}

    public FileWorkImpl(Path filePath){

        this.path = filePath;

    }

    public Path getFilePath(){

        return this.path;

    }

    public String getENCODING(){

        return this.ENCODING;

    }

    @Override
    public List<String> getDataFromFile(Path pathToFile) {


        List<String> resultList = null;

        if(!Files.exists(pathToFile)){

            throw new NullPointerException("Путь к файлу не существует");

        }else{

           resultList = new ArrayList<>();

           try(BufferedReader br = new BufferedReader(new InputStreamReader(
                                                                             new FileInputStream(pathToFile.toFile()), this.getENCODING())))
           {

               String line = br.readLine();

               while(line != null){

                   resultList.add(line);

                   line = br.readLine();

               }

           }catch(IOException e){

               System.err.println("Произошла ошибка ввода - вывода");

           }

        }

        return resultList;

    }

    @Override
    public void putDataToFile(List<String> data, Path pathToFile) {

        if (!Files.exists(pathToFile)) {

            throw new NullPointerException("Путь к файлу не существует");

        } else {

            try (PrintWriter pw = new PrintWriter(pathToFile.toFile(), this.getENCODING())) {

                for (String newData : data) {

                    pw.println(newData);

                }

            } catch (IOException e) {

                System.err.println("Произошла ошибка ввода - вывода");

            }


        }

    }

    @Override
    public void showFile(Path pathToFile) {

        if(!Files.exists(pathToFile)){

            throw new NullPointerException("Путь к файлу не существует");

        }else{

            try(BufferedReader br = new BufferedReader(new FileReader(pathToFile.toFile()))){

                String line = br.readLine();

                while(line != null){

                    System.out.println(line);

                    line = br.readLine();

                }

            }catch(IOException e){

                System.err.println("Произошла ошибка ввода - вывода");

            }

        }

    }

}
