package com.academy.techcenture.ecommerce.utils;

import com.github.javafaker.Faker;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.Locale;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class CommonUtils {


    private Faker faker;

    public CommonUtils() {
        this.faker = new Faker();
    }

    public  String randomZipCode(){
        return faker.address().zipCode().substring(0, 5);
    }

    public  String randomPhoneNumber(){
        return String.format("(%03d) %03d-%04d",
                (int) Math.floor(999*Math.random()),
                (int) Math.floor(999*Math.random()),
                (int) Math.floor(9999*Math.random()));
    }

    public  String generateRandomString(int limit){
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890".toLowerCase();
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < limit) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;
    }

    public String randomCompanyName(){
        return faker.company().name();
    }

    public String randomState(){
        return faker.address().state();
    }

    public String randomCity(){
        return faker.address().cityName();
    }

    public String randomStrAddress(){
        return faker.address().streetAddress();
    }

    public int randomNumber(int from, int to){
        return (int)(Math.random() * (to - from  + 1 ) + from);
    }

    public String randomEmail(){

        String lastName = faker.name().lastName(); //random lastname
        String firstName = faker.name().firstName();
        String[] domain = {"gmail","yahoo","icloud","hotmail"};
        String email = lastName + "." + firstName + "@" + domain[(int) (Math.random() * (4))] + ".com";
        return email.toLowerCase(Locale.ROOT);
    }

    public String randomDOB18OrAbove(){
        LocalDate startDate = LocalDate.of(1950, 1, 1); //start date
        long start = startDate.toEpochDay();
        LocalDate endDate = LocalDate.of(LocalDate.now().getYear()-18, 1, 1); //end date
        long end = endDate.toEpochDay();
        long randomEpochDay = ThreadLocalRandom.current().longs(start, end).findAny().getAsLong();
        return LocalDate.ofEpochDay(randomEpochDay).toString();
    }

    public String randomPassword(){
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz!@#$%^&*()/1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 12) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String password = salt.toString();
        return password;
    }

    public String randomApartment( ){
        return String.format(("%04d"), (int) Math.floor(9999*Math.random()));
    }
    public static int randomStar(){
        return (int)(Math.random() * (5 - 1  + 1 ) + 1);
    }

    public String getRecentFileName(String directoryPath) {

        File file = new File(directoryPath);

        String[] directories = file.list((current, name) -> new File(current, name).isDirectory());

        Arrays.sort(directories, Collections.reverseOrder());

        String latestFileName = directories[0];

        File loc = new File(directoryPath + "/" + latestFileName) ;

        File[] files = loc.listFiles();

        String fileName = files[0].getAbsolutePath();

        System.out.println(fileName);

        return fileName;
    }

    public String readPdfDocument(String pdfFilePath) throws IOException {
        String content  = "";
        PDDocument document = PDDocument.load(new File(pdfFilePath));
        if (!document.isEncrypted()) {
            PDFTextStripper stripper = new PDFTextStripper();
            content = stripper.getText(document);
        }
        document.close();
        return content;
    }


}
