package ex00;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Program {
    private static final String FILE_NAME = "signatures.txt";
    private static final char[] HEX_FORMAT = "0123456789ABCDEF".toCharArray();
    private static final String RESULT_FILE_NAME = "result.txt";

    public static void main(String[] args) {
        Map<String, String> signatures = new HashMap<>();
        try(FileInputStream fileInputStream = new FileInputStream(FILE_NAME)){
            Scanner scanner = new Scanner(fileInputStream);
            while(scanner.hasNextLine()){
                String address = scanner.nextLine();
                String[] addressArray = address.split(",");
                signatures.put(addressArray[0], addressArray[1]).replaceAll("\\s+", "");
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
            System.exit(-1);
        }
        Scanner scanner = new Scanner(System.in);
        String inputFile = scanner.nextLine();
        while (!inputFile.equals("42")){
            try (FileInputStream fileInputStream = new FileInputStream(inputFile)){
                byte[] bytesSignature = new byte[8];
                int readenBytes = fileInputStream.read(bytesSignature, 0, 8);
                if(readenBytes == 8){
                    compareSignature(bytesToHexFormat(bytesSignature), signatures);
                } else {
                    throw new Exception("File too small for read bytes");
                }
            } catch (Exception e){
                System.out.println(e.getMessage());
            }
            inputFile = scanner.nextLine();
        }
    }



    private static void compareSignature(String signature, Map<String, String> map){
        try (FileOutputStream fileOutputStream = new FileOutputStream(RESULT_FILE_NAME)){

        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }








    private static String bytesToHexFormat(byte[] bytes ){
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02X", b));
        }
        return sb.toString();
    }
}
