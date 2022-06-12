<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
    xmlns:b="http://www.baklavice.com/zahtev_za_sertifikat"
    xmlns:t="http://www.baklavice.com/tipovi" version="2.0">

    <xsl:template match="/">
        <html>
            <head>
                <title>Zahtev za zeleni sertifikat</title>
                <meta charset="UTF-8"/>
                <style type="text/css">
					body {
					    background-color: white;
					    font-family: Georgia, serif;
					    color: black;
					    text-align: justify;
					    font-size: 18;
					    margin-left:150;
					    margin-right:150;
					    margin-top:50;
					}
                </style>
            </head>
            <body>
            	<p style="text-align:center;font-weight: bold;font-size:22;">
            		ЗАХТЕВ<br/>
            		за издавање зеленог сертификата
            	</p>
            	<p>
            		<br/>
            		<br/>
            		У складу са одредбом Републике Србије о издавању дигиталног зеленог сертификата као потврде
            		о извршеној вакцинацији против COVID-19, резултатима тестирања на заразну болест SARS-CoV-2
            		или опоравну од болести COVID-19, подносим захтев за издавање дигиталног зеленог сертификата.
            		<br/>
            		<br/>
            		Подносилац захтева:
            		<br/>
            		<br/>
            		Име и презиме: 
            		<xsl:value-of select="b:Zahtev/b:Podaci_o_podnosiocu/t:Ime"/>
            		<img src="../../data/pictures/prazan_prostor.png" width="5" height="12"/>
            		<xsl:value-of select="b:Zahtev/b:Podaci_o_podnosiocu/t:Prezime"/>
            		<br/>
            		Датум рођења: <xsl:value-of select="b:Zahtev/b:Podaci_o_podnosiocu/t:Datum_rodjenja"/>
            		<br/>
            		Пол: <xsl:value-of select="b:Zahtev/b:Podaci_o_podnosiocu/t:Pol"/>
            		<br/>
            		Јединствени матични број грађанина: <xsl:value-of select="b:Zahtev/b:Podaci_o_podnosiocu/t:JMBG"/>
            		<br/>
            		Број пасоша: <xsl:value-of select="b:Zahtev/b:Podaci_o_podnosiocu/t:Broj_pasosa"/>
            		<br/>
            		<br/>
            		Разлог за подношење захтева:
            		<br/>
            		<xsl:value-of select="b:Zahtev/b:Razlog_podnosenja_zahteva"/>
            	</p>
            	<p style="font-size:10;text-align:center">(навести што прецизније разлог за подношење захтева за издавање дигиталног пасоша)</p>
            	<p>
            		<br/>
            		У <xsl:value-of select="b:Zahtev/b:Mesto_podnosenja_zahteva"/>,
            		<br/>
            		<br/>
            		дана <xsl:value-of select="b:Zahtev/b:Datum_podnosenja_zahteva"/> године
            		<br/>
            		<img src="../../data/pictures/prazan_prostor.png" width="800" height="12"/>
            		_______________________________
            		<br/>
            		<img src="../../data/pictures/prazan_prostor.png" width="950" height="12"/>
            		<span style="font-size:10">Потпис</span>
            	</p>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>
