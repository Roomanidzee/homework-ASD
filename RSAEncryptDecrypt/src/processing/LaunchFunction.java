package processing;

import functions.FileWorkImpl;
import functions.RSAAlgorithm;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LaunchFunction {

    private static final String DIRECTORY = "src/data/";
    private static final String ENCRYPTED_TAG = "_encrypted";
    private static final String DECRYPTED_TAG = "_decrypted";
    private static final String TYPE = ".txt";

    private static Byte[] toByteObjects(byte[] original){

        Byte[] result = new Byte[original.length];

        for(int i = 0; i < result.length; i++){

            result[i] = original[i];

        }

        return result;

    }

    private static byte[] toUsualByte(Byte[] original){

        byte[] result = new byte[original.length];

        int i = 0;

        for(Byte b: result){

            result[i] = b.byteValue();
            i++;

        }

        return result;

    }

    public static void launch(){

         Scanner sc = new Scanner(System.in);

         System.out.print("Пожалуйста, введите название вашего файла: ");
         String fileName = sc.nextLine();

         System.out.println();

         Path originalPath = null;

         try {

             String path = DIRECTORY + fileName + TYPE;

             originalPath = Paths.get(path).toRealPath();

         } catch (IOException e) {

            e.printStackTrace();

         }

         RSAAlgorithm rsa = new RSAAlgorithm();
         FileWorkImpl fileWork = new FileWorkImpl(originalPath);

         System.out.println("Список возможных команд: show_file, encrypt, decrypt," +
                 " show_encrypt_file, show_decrypt_file, exit");

         boolean exit = false;

         String command = "";

         Path encryptedPath = null;
         Path decryptedPath = null;

         while(!exit){

             System.out.print("Ваша команда: ");

             command = sc.nextLine();

             System.out.println();
             System.out.println();

             switch (command){

                 case "exit":

                     System.out.println("Спасибо вам за использование этой программы!");
                     exit = true;
                     break;

                 case "show_file":

                     System.out.println("Исходный файл: ");
                     System.out.println();

                     fileWork.showFile(fileWork.getFilePath());

                     break;

                 case "encrypt":

                     List<String> data = fileWork.getDataFromFile(fileWork.getFilePath());

                     List<Byte[]> encryptList = new ArrayList<>(data.size());

                     for(int i = 0; i < encryptList.size(); i++){

                         encryptList.add(toByteObjects(rsa.encrypt(data.get(i).getBytes())));

                     }

                     try{

                         String encryptPath = DIRECTORY + fileName + ENCRYPTED_TAG + TYPE;

                         encryptedPath = Paths.get(encryptPath).toRealPath();

                     }catch(IOException e){

                         System.err.println("Ошибка ввода - вывода");

                     }

                     List<String> resultData = new ArrayList<>(encryptList.size());

                     for(int i = 0; i < resultData.size(); i++){

                         resultData.add(rsa.bytesToString(toUsualByte(encryptList.get(i))));

                     }

                     fileWork.putDataToFile(resultData, encryptedPath);

                     System.out.println("Файл успешно зашифрован");

                     break;

                 case "decrypt":

                     if(encryptedPath == null){

                         throw new NullPointerException("Файл не был зашифрован");

                     }

                     List<String> dataToDecrypt = fileWork.getDataFromFile(encryptedPath);

                     List<Byte[]> decryptList = new ArrayList<>(dataToDecrypt.size());

                     for(int i = 0; i < decryptList.size(); i++){

                         decryptList.add(toByteObjects(rsa.decrypt(dataToDecrypt.get(i).getBytes())));

                     }

                     try{

                         String decryptPath = DIRECTORY + fileName + DECRYPTED_TAG + TYPE;

                         decryptedPath = Paths.get(decryptPath).toRealPath();

                     }catch(IOException e){

                         System.err.println("Ошибка ввода - вывода");

                     }

                     List<String> resultDecryptedData = new ArrayList<>(decryptList.size());

                     for(int i = 0; i < resultDecryptedData.size(); i++){

                         resultDecryptedData.add(rsa.bytesToString(toUsualByte(decryptList.get(i))));

                     }

                     fileWork.putDataToFile(resultDecryptedData, decryptedPath);

                     System.out.println("Файл успешно расшифрован");

                     break;

                 case "show_encrypt_file":

                     if(encryptedPath == null){

                         throw new NullPointerException("Файл не был зашифрован");

                     }

                     fileWork.showFile(encryptedPath);

                     break;

                 case "show_decrypt_file":

                     if(decryptedPath == null){

                         throw new NullPointerException("Файл не был расшифрован");

                     }

                     fileWork.showFile(decryptedPath);

                     break;

             }

         }

    }

}
