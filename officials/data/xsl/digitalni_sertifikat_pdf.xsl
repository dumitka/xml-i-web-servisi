<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
    xmlns:b="http://www.baklavice.com/digitalni_sertifikat"
    xmlns:t="http://www.baklavice.com/tipovi" version="2.0">

    <xsl:template match="/">
        <html>
            <head>
                <title>Digitalni sertifikat</title>
                <meta charset="UTF-8"/>
            </head>
            <body>
            	<p><img src="data\pictures\zaglavlje.png"/></p>
            	<p style="font-size:12">
	            	<img src="data\pictures\cir_br_datum.png" heigth="15"/><br/>
	            	Certificate ID: <img src="data\pictures\prazan_prostor.png" width="20" height="12"/> <xsl:value-of select="b:Sertifikat/b:Info_sertifikat/b:Broj_sertifikata"/>
	            	<img src="data\pictures\prazan_prostor.png" width="185" height="12"/>
	            	Certificate issuing date and time: <img src="data\pictures\prazan_prostor.png" width="30" height="12"/> <xsl:value-of select="b:Sertifikat/b:Info_sertifikat/b:Datum_izdavanja"/> <br />
	            	<img src="data\pictures\cir_ime.png" width="320" heigth="15"/> 
	            	<xsl:value-of select="b:Sertifikat/b:Info_korisnika/t:Ime"/>
	            	<img src="data\pictures\prazan_prostor.png" width="5" height="12"/>
	            	<xsl:value-of select="b:Sertifikat/b:Info_korisnika/t:Prezime"/>
	            	<br/>
	            	<img src="data\pictures\cir_pol.png" width="320" heigth="15"/> <xsl:value-of select="b:Sertifikat/b:Info_korisnika/t:Pol"/><br/>
	            	<img src="data\pictures\cir_dat_rodj.png" width="320" heigth="15"/> <xsl:value-of select="b:Sertifikat/b:Info_korisnika/t:Datum_rodjenja"/><br/>
	            	<img src="data\pictures\cir_jmbg.png" width="320" heigth="15"/> <xsl:value-of select="b:Sertifikat/b:Info_korisnika/t:JMBG"/><br/>
	            	<img src="data\pictures\cir_br_pas.png" width="320" heigth="15"/> <xsl:value-of select="b:Sertifikat/b:Info_korisnika/t:Broj_pasosa"/><br/>
	            	<img src="data\pictures\linija.png"/><br/>
	            	
	            	<img src="data\pictures\cir_vakc.png" heigth="70"/><br/>
	            	<img src="data\pictures\prazan_prostor.png" width="12" height="12"/>
	            	<xsl:for-each select="b:Sertifikat/b:Info_vakcinacije/b:Vakcinacije">
                        <xsl:sort select="@Doza"/>
                      	<xsl:value-of select="b:Tip"/>
                      	<img src="data\pictures\prazan_prostor.png" width="40" height="12"/>
                     </xsl:for-each>
                     <br/>
                     <img src="data\pictures\cir_proizvodjac.png"/><br/>
	            	<img src="data\pictures\prazan_prostor.png" width="12" height="12"/>
                     <xsl:for-each select="b:Sertifikat/b:Info_vakcinacije/b:Vakcinacije">
                        <xsl:sort select="@Doza"/>
                      	<xsl:value-of select="b:Proizvodjac"/>, <xsl:value-of select="b:Serija"/>
                      	<img src="data\pictures\prazan_prostor.png" width="12" height="12"/>
                     </xsl:for-each>
                     <br/>
                     <img src="data\pictures\cir_dat.png" heigth="15"/><br/>
	            	 <img src="data\pictures\prazan_prostor.png" width="12" height="12"/>
	            	 <xsl:for-each select="b:Sertifikat/b:Info_vakcinacije/b:Vakcinacije">
                     	<xsl:sort select="@Doza"/>
                      	<xsl:value-of select="b:Zdravsvena_ustanova"/>
                      	<img src="data\pictures\prazan_prostor.png" width="12" height="12"/>
                      </xsl:for-each>
                      <br/>
                      <img src="data\pictures\linija.png"/><br/>
                      <img src="data\pictures\cir_rez.png"/><br/>
            	</p>
                               
            	<p><img src="data\pictures\podnozje.png"/></p>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>
