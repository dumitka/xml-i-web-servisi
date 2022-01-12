package com.immunisation.officials.metadata;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.ResultSet;
import org.apache.jena.query.ResultSetFormatter;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.update.UpdateExecutionFactory;
import org.apache.jena.update.UpdateFactory;
import org.apache.jena.update.UpdateProcessor;
import org.apache.jena.update.UpdateRequest;

import javax.xml.transform.TransformerException;

import org.xml.sax.SAXException;

import com.immunisation.officials.metadata.AuthenticationUtilities.ConnectionProperties;

public class RdfConverter {

	private static final String SPARQL_NAMED_GRAPH_URI = "/example/sparql/metadata";
	
	public static void convertXmlToRdf(String xmlFilePath, String rdfFilePath) throws SAXException, IOException, TransformerException {
		
		ConnectionProperties conn = AuthenticationUtilities.loadProperties(); 
		MetadataExtractor metadataExtractor = new MetadataExtractor();
		
		System.out.println("Extracting metadata from " + xmlFilePath);
		
		metadataExtractor.extractMetadata(
				new FileInputStream(new File(xmlFilePath)), 
				new FileOutputStream(new File(rdfFilePath)));
		
		// Loading a default model with extracted metadata
		Model model = ModelFactory.createDefaultModel();
		model.read(rdfFilePath);
		
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		
		model.write(out, SparqlUtil.NTRIPLES);
		
		//Writing the named graph
		System.out.println("Extracted metadata to " + rdfFilePath);
		model.write(System.out, SparqlUtil.RDF_XML);
		//
		
		// Writing the named graph
		System.out.println("[INFO] Populating named graph \"" + SPARQL_NAMED_GRAPH_URI + "\" with extracted metadata.");
		String sparqlUpdate = SparqlUtil.insertData(conn.dataEndpoint + SPARQL_NAMED_GRAPH_URI, new String(out.toByteArray()));
		System.out.println(sparqlUpdate);
		
		// UpdateRequest represents a unit of execution
		UpdateRequest update = UpdateFactory.create(sparqlUpdate);
	
		UpdateProcessor processor = UpdateExecutionFactory.createRemote(update, conn.updateEndpoint);
		processor.execute();
		

		// Read the triples from the named graph
		System.out.println();
		System.out.println("[INFO] Retrieving triples from RDF store.");
		System.out.println("[INFO] Using \"" + SPARQL_NAMED_GRAPH_URI + "\" named graph.");
		
		System.out.println("[INFO] Selecting the triples from the named graph \"" + SPARQL_NAMED_GRAPH_URI + "\".");
		String sparqlQuery = SparqlUtil.selectData(conn.dataEndpoint + SPARQL_NAMED_GRAPH_URI, "?s ?p ?o");
		
		QueryExecution query = QueryExecutionFactory.sparqlService(conn.queryEndpoint, sparqlQuery);
		
		ResultSet results = query.execSelect();
		
		ResultSetFormatter.out(System.out, results);
		
		query.close();
		System.out.println("[INFO] End.");
	}
	
	
	
	public void test() throws SAXException, IOException, TransformerException {
		String xmlPath = "temp/Interesovanje.xml";
//		String xmlPath = "temp/Digitalni_sertifikat1.xml";
//		String xmlPath = "temp/Digitalni_sertifikat2.xml";
//		String xmlPath = "temp/Izvestaj_o_imunizaciji.xml";
//		String xmlPath = "temp/Potvrda_o_vakcinaciji.xml";
//		String xmlPath = "temp/Saglasnost.xml";
//		String xmlPath = "temp/Zahtev_za_sertifikat.xml";
		
		String rdfPath = "gen/test.rdf";
		
		convertXmlToRdf(xmlPath, rdfPath);
		
	}
	
	public static void main(String[] args) throws SAXException, IOException, TransformerException {
		RdfConverter converter = new RdfConverter();
		
		converter.test();
	}
	
	
	
	
	
	
	
	
	
	
}
