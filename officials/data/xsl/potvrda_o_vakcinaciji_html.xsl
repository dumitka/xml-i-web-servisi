<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
    xmlns:b="http://www.baklavice.com/potvrda"
    xmlns:t="http://www.baklavice.com/tipovi" version="2.0">

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
					    margin-left:50;
					    margin-right:50;
					}
					
					img.levo {
					    float: left;
					    padding: 8px;
					    margin-left: 8px;
					    width: 200;
					    height: 200;
					}
					
					img.desno {
					    float: right;
					    padding: 8px;
					    margin-right: 8px;
					    width: 200;
					    height: 200;
					}

					.boldovano {
					    font-weight: bold;
					    color:black;
					}

                </style>
            </head>
            <body>
            	<p style="text-align:center; font-size:20; color:d3d3d3;">
            		<img src="../../data/pictures/grb_ijzs.jpg" class="levo" alt="Grb Instituta za javno zdravlje Srbije"/>

            		<br/>
            		<br/>
            		<span class="boldovano"> ИHСТИТУТ ЗА ЈАВНО ЗДРАВЉЕ СРБИЈЕ </span>
            		<br/>
            		<span class="boldovano">"Др Милан Јовановић Батут"</span>
            		<br/>
            		 INSTITUT ZA JAVNO ZDRAVLJE SRBIJE 
            		<br/>
            		"Dr Milan Jovanović Batut"
            		<br/>
            		 INSTITUTE OF PUBLIC HEALTH OF SERBIA 
            		<br/>
            		"Dr Milan Jovanović Batut"
            		<br/>
            		<br/>
            	</p>
            	<p style="color:d3d3d3">
            		<span class="boldovano"> Шифра потврде вакцинације: <xsl:value-of select="b:Potvrda/b:Sifra_potvrde"/></span>
            		<br/>
            		Šifra potvrde / Confirmation code
            		<br/>
            	</p>
            	<p style="color:d3d3d3;font-size:18;text-align:center">
            		<span class="boldovano" style="font-size:23"> ПОТВРДА О ИЗВРШЕНОЈ ВАКЦИНАЦИЈИ ПРОТИВ COVID-19 </span>
            		<br/>
            		POTVRDA O IZVRŠENOJ VAKCINACIJI PROTIV COVID-19
            		<br/>
            		CONFIRMATION OF THE COVID-19 VACCINATION
            		<br/>
            	</p>
            	<p style="color:d3d3d3;font-size:14;">
            		<span class="boldovano" style="font-size:18"> Име и презиме: <xsl:value-of select="b:Potvrda/b:Info_korisnika/t:Ime"/>  <xsl:value-of select="b:Potvrda/b:Info_korisnika/t:Prezime"/></span>
            		<br/>
            		Ime i prezime / First and last name
            		<br/>
            		<br/>
            		<span class="boldovano" style="font-size:18"> Датум рођења: <xsl:value-of select="b:Potvrda/b:Info_korisnika/t:Datum_rodjenja"/></span>
            		<br/>
            		Datum rođenja / Date of birth
            		<br/>
            		<br/>
            		<span class="boldovano" style="font-size:18"> Пол: <xsl:value-of select="b:Potvrda/b:Info_korisnika/t:Pol"/></span>
            		<br/>
            		Pol / Gender
            		<br/>
            		<br/>
            		<span class="boldovano" style="font-size:18"> ЈМБГ: <xsl:value-of select="b:Potvrda/b:Info_korisnika/t:JMBG"/></span>
            		<br/>
            		JMBG / Personal No.
            		<br/>
            		<br/>
            		<span class="boldovano" style="font-size:18"> Датум давања и број серије прве дозе: </span>
            		<xsl:for-each select="b:Potvrda/b:Doze_vakcine/b:Doza">
                        <xsl:if test="@Broj_doze='1'">
                        	<span class="boldovano" style="font-size:18"><xsl:value-of select="b:Datum_davanja"/>, серија: <xsl:value-of select="b:Serija"/></span>
                        </xsl:if>
                    </xsl:for-each>
            		<br/>
            		Datum vakcinacije / Vaccination date
            		<br/>
            		<br/>
            		<span class="boldovano" style="font-size:18"> Датум давања и број серије друге дозе:</span>
            		<xsl:for-each select="b:Potvrda/b:Doze_vakcine/b:Doza">
                        <xsl:if test="@Broj_doze='2'">
                        	<span class="boldovano" style="font-size:18"><xsl:value-of select="b:Datum_davanja"/>, серија: <xsl:value-of select="b:Serija"/></span>
                        </xsl:if>
                    </xsl:for-each>
            		<br/>
            		Datum druge vakcinacije / Second vaccination date
            		<br/>
            		<br/>
            		<span class="boldovano" style="font-size:18"> Здравствена установа која вакцинише:</span>
            		<br/>
            		Zdravstvena ustanova koja vakciniše / Health care institution of vaccination
            		<br/>
            		<br/>
            		<span class="boldovano" style="font-size:18"> Назив вакцине: <xsl:value-of select="b:Potvrda/b:Naziv_vakcine"/></span>
            		<br/>
            		Naziv vkacine / Name of vaccine
            		<br/>
            		<br/>
            		<span class="boldovano" style="font-size:18"> Датум издавања потврде: <xsl:value-of select="b:Potvrda/b:Info_korisnika/t:Datum_izdavanja"/></span>
            		<br/>
            		Datum izdavanja potvrde / Confirmation realease date
            		<br/>
            		<br/>
            	</p>
            	<p style="color:d3d3d3;font-size:14;text-align:right;">
            		<span class="boldovano" style="font-size:18">Здравствена установа: ДОМ ЗДРАВЉА ЗВЕЗДАРА</span>
            		<br/>
            		Zdravstvena ustanova / Medical institution
            	</p>
            	<p style="color:d3d3d3;font-size:14">
            		<img src="../../data/pictures/primer_qrk.jpg" class="desno" alt="QR kod"/>
            		<br/><br/><br/><br/><br/><br/>
            		<br/><br/><br/>
            		<span class="boldovano" style="font-size:18">Ова потврда важи без потписа и печата</span>
            		<br/>
            		Ova potvrda važi bez potpisa i pečata / This certificate is valid without signatures and seals
            	</p>
            	
            
           		
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>
