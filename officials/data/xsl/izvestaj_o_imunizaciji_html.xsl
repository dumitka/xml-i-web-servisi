<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
    xmlns:b="http://www.baklavice.com/izvestaj" version="2.0">

    <xsl:template match="/">
        <html>
            <head>
                <title>Izvestaj o imunizaciji</title>
                <meta charset="UTF-8"/>
                <style type="text/css">
					body {
					    background-color: white;
					    font-family: Georgia, serif;
					    color: black;
					    text-align: justify;
					    font-size: 18;
					    margin-left:150;
					}
					
					
					.boldovano {
					    font-weight: bold;
					}

                </style>
            </head>
            <body>
           		<br/>
           		<p class="boldovano" style="text-align:center"> Извештај о имунизацији </p>
           		<br/>
           		<br/>
           		<p>Извештај се односи на период од <span class="boldovano"><xsl:value-of select="b:Izvestaj/b:Period/b:Datum_od"/></span> до  <span class="boldovano"><xsl:value-of select="b:Izvestaj/b:Period/b:Datum_do"/></span>.</p>
           		<br/>
           		<br/>
           		<p>
	           		У напоменутом временском интервалу је:
	           		<br/>
	           		<ul>
	           			<li>
	           				поднето <span class="boldovano"><xsl:value-of select="b:Izvestaj/b:Broj_interesovanja"/></span> докумената о интересовању за вакцинацију
	           			</li>
	           			<li>
	           				примљено <span class="boldovano"><xsl:value-of select="b:Izvestaj/b:Zahtevi_za_sertifikat"/></span> захтева за дигитални зелени сертификат,
	           				од којих је <span class="boldovano"><xsl:value-of select="b:Izvestaj/b:Izdati_sertifikati"/></span> издато
	           			</li>
	           		</ul>
           		</p>
           		<br/>
           		<br/>
           		<p>
           			Примљено је <span class="boldovano"><xsl:value-of select="b:Izvestaj/b:Doze_vakcine/b:Ukupno_datih_doza"/></span> доза бакцинације против
           			covid-19 вируса, од чега је <span class="boldovano"><xsl:value-of select="b:Izvestaj/b:Doze_vakcine/b:Doza/b:Broj_datih_doza"/></span> ново вакцинисаних.
           		</p>
           		<br/>
           		<br/>
           		<p>
	           		Расподела по произвођачима је:
	           		<ul>
	           			<xsl:for-each select="b:Izvestaj/b:Raspodela_proizvodjaca/b:Proizvodjac">
	                       	<xsl:sort select="b:Izvestaj/b:Raspodela_proizvodjaca/b:Proizvodjac/b:Broj_doza"/>
	                       	<li>
	                       		<span class="boldovano"><xsl:value-of select="b:Naziv_proizvodjaca"/> - <xsl:value-of select="b:Broj_doza"/></span>
	                       	</li>
	                       </xsl:for-each>
	           		</ul>
            	</p>
           		<br/>
           		<br/>
            	<p>
           			Извештај издат <xsl:value-of select="b:Izvestaj/b:Datum_izdavanja"/>
           			<img src="../../data/pictures/prazan_prostor.png" width="400" height="12"/>
           			_______________________________________
           			<br/>
           			<img src="../../data/pictures/prazan_prostor.png" width="800" height="12"/>
           			<span style="font-size:14">Потпис</span>
           		</p>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>
