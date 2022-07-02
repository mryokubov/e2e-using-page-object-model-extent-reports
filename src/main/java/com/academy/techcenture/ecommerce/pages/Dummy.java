package com.academy.techcenture.ecommerce.pages;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

public class Dummy {
//    public static void main(String[] args) throws IOException {
//
//
//
////        URL pdfUrl = new URL("src/main/resources/invoices/IN220027.pdf");
////        InputStream in = pdfUrl.openStream();
////        BufferedInputStream bf = new BufferedInputStream(in);
////
////
////        PDDocument doc = PDDocument.load(bf);
////        PDFTextStripper pdfStrip = new PDFTextStripper();
////        pdfStrip.setStartPage(1);
////        String content = pdfStrip.getText(doc);
////        doc.close();
//
//        PDDocument document = PDDocument.load(new File("src/main/resources/invoices/IN220027.pdf"));
//        if (!document.isEncrypted()) {
//            PDFTextStripper stripper = new PDFTextStripper();
//            String text = stripper.getText(document);
//            System.out.println("Text:" + text);
//        }
//        document.close();
//
//
//
//
//
//
//
//    }

    public static void main(String[] args) throws IOException {
        try {
            byte[] fileAsBytes = getArrayFromInputStream(new FileInputStream(new File( "src/main/resources/invoices/IN220027.pdf")));
            writeContent(fileAsBytes,  "src/main/resources/invoices/sample.pdf");
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    private static byte[] getArrayFromInputStream(InputStream inputStream) throws IOException {
        byte[] bytes;
        byte[] buffer = new byte[1024];
        try(BufferedInputStream is = new BufferedInputStream(inputStream)){
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            int length;
            while ((length = is.read(buffer)) > -1 ) {
                bos.write(buffer, 0, length);
            }
            bos.flush();
            bytes = bos.toByteArray();
        }
        return bytes;
    }

    private static void writeContent(byte[] content, String fileToWriteTo) throws IOException {
        File file = new File(fileToWriteTo);
        try(BufferedOutputStream salida = new BufferedOutputStream(new FileOutputStream(file))){
            salida.write(content);
            salida.flush();
        }
    }
}

