package javaTest;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
<<<<<<< HEAD
import java.util.Scanner;
=======
>>>>>>> f7fc22f588ef163d0ae68476714fa43c4f0bce5b

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class pdf {
  public static void main(String[] args) {
    // Create an array of keywords
<<<<<<< HEAD
	 Scanner sc = new Scanner(System.in);
	 System.out.println("please enter the keyword 1");
	 String k1 = sc.next();
	 System.out.println("please enter the keyword 1");
	 String k2 = sc.next();
	 System.out.println("please enter the keyword 1");
	 String k3 =  sc.next();
	 
	  
	  String[] keywords = {k1,k2, k3 };
=======
    String[] keywords = {"java", "c++", "python"};
>>>>>>> f7fc22f588ef163d0ae68476714fa43c4f0bce5b
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
<<<<<<< HEAD
      }
    System.out.println("PDF file Created!!!");
    }
  }
=======
    }
  }
}
>>>>>>> f7fc22f588ef163d0ae68476714fa43c4f0bce5b
