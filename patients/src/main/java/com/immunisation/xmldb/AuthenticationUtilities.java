package com.immunisation.xmldb;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

// Pomoćna klasa koja nam služi za konekciju sa exist bazom

public class AuthenticationUtilities {
	// U connectionUri se nalaze host i port za konekciju ka bazi
	private static String connectionUri = "xmldb:exist://%1$s:%2$s/exist/xmlrpc";
	
	// Parametri konekcije
	static public class ConnectionProperties {
		public String host;
		public int port = -1;
		public String user;
		public String password;
		public String driver;
		public String uri;

		public ConnectionProperties(Properties props) {
			super();
			
			user = props.getProperty("conn.user").trim();
			password = props.getProperty("conn.password").trim();

			host = props.getProperty("conn.host").trim();
			port = Integer.parseInt(props.getProperty("conn.port"));
			
			uri = String.format(connectionUri, host, port);
			
			driver = props.getProperty("conn.driver").trim();
		}
	}

	// Isčitavanje connection properties-a iz exist.properties fajla
	public static ConnectionProperties loadProperties() throws IOException {
		String propsName = "exist.properties";

		InputStream propsStream = openStream(propsName);
		if (propsStream == null)
			throw new IOException("Could not read properties " + propsName);

		Properties props = new Properties();
		props.load(propsStream);

		return new ConnectionProperties(props);
	}

	// Isčitavanje fajla u vidu stream-a
	public static InputStream openStream(String fileName) throws IOException {
		return AuthenticationUtilities.class.getClassLoader().getResourceAsStream(fileName);
	}
}
