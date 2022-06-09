<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
    xmlns:b="http://www.baklavice.com/digitalni_sertifikat"
    xmlns:t="http://www.baklavice.com/tipovi" version="2.0">

    <xsl:template match="/">
        <html>
            <head>
                <title>Digitalni sertifikat</title>
                <style type="text/css">
                    table {
                        font-family: serif;
                        border-collapse: collapse;
                        margin: 50px auto 50px auto;
                        width: 50%;
                        align: center;
                    }
                    tr, td {
                        text-align: left;
                        padding: 15px;
                    }
                    
                    tr:nth-child(even){ background-color: #f2f2f2 }
                    tr {
                        font-family: sans-serif;
                    }
                    tr { border: 1px solid darkgrey; }
                    tr:hover {
                        font-style: italic;
                        background-color: #008080;
                    	color: white;
                    }
                    body { 
                    	font-family: sans-serif;
                    }
                    h1, h2 {
                    	margin-left: 300px;
                    	color: #008B8B;
                    }
                    
                </style>
            </head>
            <body>
                <h1>Digitalni sertifikat</h1>
                <h2>Informacije o sertifikatu:</h2>
                <table style="border: 1px; color:#008B8B;">
                    <tr>
                        <td bgcolor="#008B8B" style="color:white">Broj</td>
	                    <td><xsl:value-of select="b:Sertifikat/b:Info_sertifikat/b:Broj_sertifikata"/></td>
                    </tr>
                    <tr>
                        <td bgcolor="#008B8B" style="color:white">Datum</td>
	                    <td><xsl:value-of select="b:Sertifikat/b:Info_sertifikat/b:Datum_izdavanja"/></td>
	                </tr>
                </table>
                
                <h2>Informacije o korisniku:</h2>
                <table style="border: 1px; color:#008B8B;">
                     <tr>
                        <td bgcolor="#008B8B" style="color:white">Drzavljanstvo</td>
	                    <td><xsl:value-of select="b:Sertifikat/b:Info_korisnika/t:Drzavljanstvo"/></td>
                    </tr>
                    <tr>
                        <td bgcolor="#008B8B" style="color:white">Boraviste</td>
	                    <td><xsl:value-of select="b:Sertifikat/b:Info_korisnika/t:Boraviste"/></td>
	                </tr> <tr>
                        <td bgcolor="#008B8B" style="color:white">Ime</td>
	                    <td><xsl:value-of select="b:Sertifikat/b:Info_korisnika/t:Ime"/></td>
                    </tr>
                    <tr>
                        <td bgcolor="#008B8B" style="color:white">Prezime</td>
	                    <td><xsl:value-of select="b:Sertifikat/b:Info_korisnika/t:Prezime"/></td>
	                </tr> <tr>
                        <td bgcolor="#008B8B" style="color:white">Pol</td>
	                    <td><xsl:value-of select="b:Sertifikat/b:Info_korisnika/t:Pol"/></td>
                    </tr>
                    <tr>
                        <td bgcolor="#008B8B" style="color:white">Datum rodjenja</td>
	                    <td><xsl:value-of select="b:Sertifikat/b:Info_korisnika/t:Datum_rodjenja"/></td>
	                </tr> <tr>
                        <td bgcolor="#008B8B" style="color:white">JMBG</td>
	                    <td><xsl:value-of select="b:Sertifikat/b:Info_korisnika/t:JMBG"/></td>
                    </tr>
                </table>
                
                <h2>Informacije o vakcinaciji:</h2>
                <table style="border: 1px; color:#008B8B;">
                	<tr>
                       	<td colspan="2" style="text-align: center">Sve doze</td>
                    </tr>
                    <xsl:for-each select="b:Sertifikat/b:Info_vakcinacije/b:Vakcinacije">
                        <xsl:sort select="@Doza"/>
                        <tr>
                        	<td colspan="2"  bgcolor="#008B8B" style="color:white; text-align: center">
                        		<xsl:value-of select="@Doza"/>
                        	</td>
                        </tr>
	                    <tr>
	                        <td bgcolor="#008B8B" style="color:white">Tip</td>
		                    <td><xsl:value-of select="b:Tip"/></td>
		                </tr>
	                    <tr>
	                        <td bgcolor="#008B8B" style="color:white">Proizvodjac</td>
		                    <td><xsl:value-of select="b:Proizvodjac"/></td>
		                </tr>
	                    <tr>
	                        <td bgcolor="#008B8B" style="color:white">Serija</td>
		                    <td><xsl:value-of select="b:Serija"/></td>
		                </tr>
	                    <tr>
	                        <td bgcolor="#008B8B" style="color:white">Zdravstvena ustanova</td>
		                    <td><xsl:value-of select="b:Zdravsvena_ustanova"/></td>
		                </tr>
	                </xsl:for-each>
                </table>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>
