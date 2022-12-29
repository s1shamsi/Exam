package javaTest;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;

public class pdf {

    public static void main(String[] args) {
        // Create a list to store the PDF documents
        List<File> pdfFiles = new ArrayList<>();

        // Create 100 PDF documents
        for (int i = 1; i <= 25; i++) {
            String fileName = "document" + i + ".pdf";
            String text = "This " + i;
            File file = createPDF(fileName, text);
            pdfFiles.add(file);
            
        }
        for (int i = 26; i <= 50; i++) {
            String fileName = "document" + i + ".pdf";
            String text = "This is the text  " +i;
            File file = createPDF(fileName, text);
            pdfFiles.add(file);
        }
        for (int i = 51; i <= 75; i++) {
            String fileName = "document" + i + ".pdf";
            String text = "Hello ";
            File file = createPDF(fileName, text);
            pdfFiles.add(file);
        }
        for (int i = 76; i <= 100; i++) {
            String fileName = "document" + i + ".pdf";
            String text = "document ";
            File file = createPDF(fileName, text);
            pdfFiles.add(file);
        }

        // Search for documents that match the keywords "Hello", "This", and "document"
        List<String> keywords = new ArrayList<>();
        keywords.add("Hello");
        keywords.add("This");
        keywords.add("document");

        for (String keyword : keywords) {
            List<File> matchingFiles = searchForKeyword(pdfFiles, keyword);

            // Create the "matching_documents_<keyword>" folder if it does not exist
            File folder = new File("matching_documents_" + keyword);
            if (!folder.exists()) {
                folder.mkdir();
            }

            // Move the matching documents to the folder
            for (File file : matchingFiles) {
                try {
                    file.renameTo(new File(folder, file.getName()));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        System.out.println("PDF files created and moved to matching folders!");
    }

    public static File createPDF(String fileName, String text) {
        // Create a new PDF document
    	Document document = new Document();

        try {
            // Create a PDF writer for the document
            PdfWriter.getInstance(document, new FileOutputStream(fileName));

            // Open the document
            document.open();

            // Add the text to the document
            document.add(new Paragraph(text));

            // Close the document
            document.close();
        } catch (DocumentException | IOException e) {
            e.printStackTrace();
        }

        return new File(fileName);
    }

    public static List<File> searchForKeyword(List<File> files, String keyword) {
        List<File> matchingFiles = new ArrayList<>();

        // Search each file for the keyword
        for (File file : files) {
            String text = getFileText(file);
            if (text.contains(keyword)) {
                matchingFiles.add(file);
            }
        }

        return matchingFiles;
    }

    public static String getFileText(File file) {
        // Use iText to read the text from the PDF file
        StringBuilder text = new StringBuilder();
        try {
            PdfReader reader = new PdfReader(file.getAbsolutePath());
            for (int i = 1; i <= reader.getNumberOfPages(); i++) {
                text.append(PdfTextExtractor.getTextFromPage(reader, i));
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return text.toString();
    }
}


