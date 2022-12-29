package javaTest;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class pdf {
  public static void main(String[] args) {
    // Create an array of keywords
    String[] keywords = {"java", "c++", "python"};
    // Create a loop to generate 100 PDF files
    for (int i = 1; i <= 100; i++) {
      // Generate a random keyword
      int index = (int) (Math.random() * keywords.length);
      String keyword = keywords[index];
      // Create the PDF document
      Document document = new Document();
      try {
        // Create the folder if it does not exist
        File folder = new File(keyword);
        folder.mkdirs();
        // Set the file path and name
        String fileName = keyword + "/file" + i + ".pdf";
        // Create a PdfWriter
        PdfWriter.getInstance(document, new FileOutputStream(fileName));
        // Open the document
        document.open();
        // Add a paragraph with the keyword
        document.add(new Paragraph(keyword));
      } catch (DocumentException | IOException e) {
        e.printStackTrace();
      } finally {
        // Close the document
        document.close();
      }
    }
  }
}
