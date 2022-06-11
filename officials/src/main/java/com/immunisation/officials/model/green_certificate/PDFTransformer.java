package com.immunisation.officials.model.green_certificate;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerHelper;

public class PDFTransformer {
	
	private static DocumentBuilderFactory documentFactory;
	private static TransformerFactory transformerFactory;
	
	private static String inputFile = "data/xml/";
	private static final String XSL_HTML_FILE = "data/xsl/digitalni_sertifikat_html.xsl";
	private static final String XSL_PDF_FILE = "data/xsl/digitalni_sertifikat_pdf.xsl";
	private static String htmlFile = "gen/html";
	private static final String HTML_PDF_FILE = "gen/html/digitalni_sertifikat_pdf.html";
	private static String outputFile = "gen/pdf";
	
	// *** za demonstraciju iz main-a
	public static final String INPUT_FILE = "data/xml/Digitalni_sertifikat1.xml";
	public static final String HTML_FILE = "gen/html/digitalni_sertifikat_html.html";
	public static final String OUTPUT_FILE = "gen/pdf/digitalni_sertifikat.pdf";

	static {
		/* Inicijalizacija DOM fabrike */
		documentFactory = DocumentBuilderFactory.newInstance();
		documentFactory.setNamespaceAware(true);
		documentFactory.setIgnoringComments(true);
		documentFactory.setIgnoringElementContentWhitespace(true);
		
		/* Inicijalizacija Transformer fabrike */
		transformerFactory = TransformerFactory.newInstance();
	}
	
	// potreban parametara "Digitalni_sertifikat1.xml"
	// *** static zbog main-a
	public static void generateXHTML(String xmlDoc) {
		inputFile += xmlDoc;
		int brojHTMLa = new File(htmlFile).listFiles().length - 3;
		htmlFile = htmlFile + "/digitalni_sertifikat_html" + brojHTMLa + ".html";
		int brojPDFa = new File(outputFile).listFiles().length;
		outputFile = outputFile + "/digitalni_sertifikat" + brojPDFa + ".pdf";
		
		System.out.println("Generisanje XHTML-a u toku...");
    	
    	// Creates parent directory if necessary
    	File pdfFile = new File(outputFile);
		if (!pdfFile.getParentFile().exists()) {
			System.out.println("[INFO] A new directory is created: " + pdfFile.getParentFile().getAbsolutePath() + ".");
			pdfFile.getParentFile().mkdir();
		}
		PDFTransformer pdfTransformer = new PDFTransformer();
		try {
			pdfTransformer.generateHTML(inputFile, htmlFile);
			pdfTransformer.generatePDF(outputFile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Izgenerisan HTML i PDF.");
	}
 
    public void generatePDF(String filePath) throws IOException, DocumentException {
    	Document document = new Document();
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(filePath));
        document.open();
        XMLWorkerHelper.getInstance().parseXHtml(writer, document, new FileInputStream(HTML_PDF_FILE));
        document.close();
    }

    public org.w3c.dom.Document buildDocument(String filePath) {
    	org.w3c.dom.Document document = null;
		try {
			DocumentBuilder builder = documentFactory.newDocumentBuilder();
			document = builder.parse(new File(filePath)); 

			if (document != null)
				System.out.println("[INFO] File parsed with no errors.");
			else
				System.out.println("[WARN] Document is null.");
		} catch (Exception e) {
			return null;
		} 
		return document;
	}
    
    public void generateHTML(String xmlPath, String htmlPath) throws FileNotFoundException {
		try {
			// ZA DIGITALNI_SERTIFIKAT_HTML
			StreamSource transformSource = new StreamSource(new File(XSL_HTML_FILE));
			Transformer transformer = transformerFactory.newTransformer(transformSource);
			transformer.setOutputProperty("{http://xml.apache.org/xalan}indent-amount", "2");
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			
			transformer.setOutputProperty(OutputKeys.METHOD, "xhtml");

			DOMSource source = new DOMSource(buildDocument(xmlPath));
			StreamResult result = new StreamResult(new FileOutputStream(htmlPath));
			transformer.transform(source, result);
			
			// ZA DIGITALNI_SERTIFIKAT_PDF
			transformSource = new StreamSource(new File(XSL_PDF_FILE));
			transformer = transformerFactory.newTransformer(transformSource);
			transformer.setOutputProperty("{http://xml.apache.org/xalan}indent-amount", "2");
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.setOutputProperty(OutputKeys.METHOD, "xhtml");

			source = new DOMSource(buildDocument(xmlPath));
			result = new StreamResult(new FileOutputStream(HTML_PDF_FILE));
			transformer.transform(source, result);
		} catch (TransformerConfigurationException e) {
			e.printStackTrace();
		} catch (TransformerFactoryConfigurationError e) {
			e.printStackTrace();
		} catch (TransformerException e) {
			e.printStackTrace();
		}
    }
    
    public static void main(String[] args) throws IOException, DocumentException {
    	System.out.println("[INFO] " + PDFTransformer.class.getSimpleName());
    	
    	// Creates parent directory if necessary
    	File pdfFile = new File(OUTPUT_FILE);
		if (!pdfFile.getParentFile().exists()) {
			System.out.println("[INFO] A new directory is created: " + pdfFile.getParentFile().getAbsolutePath() + ".");
			pdfFile.getParentFile().mkdir();
		}
		PDFTransformer pdfTransformer = new PDFTransformer();
		pdfTransformer.generateHTML(INPUT_FILE, HTML_FILE);
		pdfTransformer.generatePDF(OUTPUT_FILE);
		
		System.out.println("[INFO] File \"" + OUTPUT_FILE + "\" generated successfully.");
		System.out.println("[INFO] End.");

		//System.out.println("--------------------------------------------------------");
		//generateXHTML("Digitalni_sertifikat2.xml");
    }
}
