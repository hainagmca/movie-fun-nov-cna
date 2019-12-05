package org.superbiz.moviefun.blobstore;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStream;

import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.pdf.PDFParser;
import org.apache.tika.sax.BodyContentHandler;

public class PdfParse {

    public static void main(final String[] args) throws Exception {

        BodyContentHandler handler = new BodyContentHandler();
        Metadata metadata = new Metadata();


        ClassLoader classLoader = PdfParse.class.getClassLoader();

        File file = new File(
                PdfParse.class.getClassLoader().getResource("RESUME.pdf").getFile())
        ;
        FileInputStream fileInputStream = new FileInputStream(file);

        //FileInputStream inputstream = new FileInputStream(new File("C:\\LABs\\NOV CNA\\movie-fun\\src\\main\\resources\\RESUME.pdf"));
        ParseContext pcontext = new ParseContext();

        //parsing the document using PDF parser
        PDFParser pdfparser = new PDFParser();
        pdfparser.parse(fileInputStream, handler, metadata,pcontext);

        //getting the content of the document
        System.out.println("Contents of the PDF :" + handler.toString());

        //getting metadata of the document
        System.out.println("Metadata of the PDF:");
        String[] metadataNames = metadata.names();

        for(String name : metadataNames) {
            System.out.println(name+ " : " + metadata.get(name));
        }
    }
}
