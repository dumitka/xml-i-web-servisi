<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
    xmlns:b="http://www.baklavice.com/digitalni_sertifikat"
    xmlns:t="http://www.baklavice.com/tipovi" version="2.0">

    <xsl:template match="/">
        <html>
            <head>
                <title>Digitalni sertifikat</title>
                <meta charset="UTF-8"/>
                <link rel="stylesheet" type="text/css" href="digitalni_sertifikat.css"/>
            </head>
            <body>
            	<p>
            		<img src="../../data/pictures/grb_rs.png" 
            			class="levo" alt="Grb Srbije" width="30%" height="30%"/>
            		<img src="../../data/pictures/primer_qrk.jpg" 
            			class="desno" alt="QR kod" width="30%" height="30%"/>
            			
            		<img src="../../data/pictures/prazan_prostor.png" width="1000" height="25"/>
            		<img src="../../data/pictures/prazan_prostor.png" width="250" height="12"/>
            		<span class="naslov"> ДИГИТАЛНИ ЗЕЛЕНИ СЕРТИФИКАТ </span>
            		<img src="../../data/pictures/prazan_prostor.png" width="200" height="12"/>
            		<img src="../../data/pictures/prazan_prostor.png" width="300" height="12"/>
            		<span class="podnaslov">Потврда о извршеној вакцинацији против</span>
            		<img src="../../data/pictures/prazan_prostor.png" width="200" height="12"/>
            		<img src="../../data/pictures/prazan_prostor.png" width="400" height="12"/>
            		<span class="podnaslov">COVID-19 и резултатима тестирања</span>
            		<img src="../../data/pictures/prazan_prostor.png" width="300" height="12"/>
            		
            		<img src="../../data/pictures/prazan_prostor.png" width="300" height="12"/>
            		<span class="naslov"> DIGITAL GREEN CERTIFICATE </span>
            		<img src="../../data/pictures/prazan_prostor.png" width="250" height="12"/>
            		<img src="../../data/pictures/prazan_prostor.png" width="250" height="12"/>
            		<span class="podnaslov">Certificate of vaccination against COVID-19</span>
            		<img src="../../data/pictures/prazan_prostor.png" width="150" height="12"/>
            		<img src="../../data/pictures/prazan_prostor.png" width="420" height="12"/>
            		<span class="podnaslov">and test result</span>
            		<img src="../../data/pictures/prazan_prostor.png" width="330" height="12"/>
            		<img src="../../data/pictures/prazan_prostor.png" width="1000" height="25"/>
            	</p>
            	<br/>
            	<p>
	            	<span class="boldovano">Број сертификата /</span>
	            	<img src="../../data/pictures/prazan_prostor.png" width="590" height="12"/>
	            	<span class="boldovano">Датум и време издавања сертификата /</span>
	            	<br/>
	            	<span class="boldovano">Certificate ID: </span>
	            	<img src="../../data/pictures/prazan_prostor.png" width="90" height="12"/>
	            	<xsl:value-of select="b:Sertifikat/b:Info_sertifikat/b:Broj_sertifikata"/>
	            	<img src="../../data/pictures/prazan_prostor.png" width="500" height="12"/>
	            	<span class="boldovano">Certificate issuing date and time: </span>
	            	<img src="../../data/pictures/prazan_prostor.png" width="90" height="12"/>
	            	<xsl:value-of select="b:Sertifikat/b:Info_sertifikat/b:Datum_izdavanja"/>
	            	<br/>
	            	<br/>
	            	<span class="boldovano">Име и презиме / Name and surname: </span>
	            	<img src="../../data/pictures/prazan_prostor.png" width="90" height="12"/>
	            	<xsl:value-of select="b:Sertifikat/b:Info_korisnika/t:Ime"/>
	            	<img src="../../data/pictures/prazan_prostor.png" width="5" height="12"/>
	            	<xsl:value-of select="b:Sertifikat/b:Info_korisnika/t:Prezime"/>
	            	<br/>
	            	<span class="boldovano">Пол / Gender: </span>
	            	<img src="../../data/pictures/prazan_prostor.png" width="308" height="12"/>
	            	<xsl:value-of select="b:Sertifikat/b:Info_korisnika/t:Pol"/>
	            	<br/>
	            	<span class="boldovano">Датум рођења / Date of birth: </span>
	            	<img src="../../data/pictures/prazan_prostor.png" width="160" height="12"/>
	            	<xsl:value-of select="b:Sertifikat/b:Info_korisnika/t:Datum_rodjenja"/>
	            	<br/>
	            	<span class="boldovano">ЈМБГ / Personal No. / EBS: </span>
	            	<img src="../../data/pictures/prazan_prostor.png" width="188" height="12"/>
	            	<xsl:value-of select="b:Sertifikat/b:Info_korisnika/t:JMBG"/>
	            	<br/>
	            	<span class="boldovano">Број пасоша / Passport No.: </span>
	            	<img src="../../data/pictures/prazan_prostor.png" width="178" height="12"/>
	            	<xsl:value-of select="b:Sertifikat/b:Info_korisnika/t:Broj_pasosa"/>
	            	<br/>
	            	<img src="../../data/pictures/linija.png"/>
	            	<br/>
            	</p>
            	
            	<table style="width: 95%; align:center; text-align:left">
            		<tr>
                        <td colspan="2" style="text-align:center"><span class="veci_bold" style="text-align:center">Вакцинација / Vaccination</span></td>
                    </tr>
                    <tr>
                        <td><span class="boldovano">Доза / Dose: 1/2</span></td>
                        <td><span class="boldovano">Доза / Dose: 2/2</span></td>
                    </tr>
                    <tr>
                        <td><span class="boldovano">Tип / Type:</span></td>
                        <td><span class="boldovano">Tип / Type:</span></td>
                    </tr>
                    <tr>
                     <xsl:for-each select="b:Sertifikat/b:Info_vakcinacije/b:Vakcinacije">
                        <xsl:sort select="@Doza"/>
                        <td><xsl:value-of select="b:Tip"/></td>
                     </xsl:for-each>
                    </tr>
                    <tr>
                        <td><span class="boldovano">Произвођач и серија / Manufacturer and batch number:</span></td>
                        <td><span class="boldovano">Произвођач и серија / Manufacturer and batch number:</span></td>
                    </tr>
                    <tr>
                     <xsl:for-each select="b:Sertifikat/b:Info_vakcinacije/b:Vakcinacije">
                        <xsl:sort select="@Doza"/>
                        <td><xsl:value-of select="b:Proizvodjac"/>, <xsl:value-of select="b:Serija"/></td>
                     </xsl:for-each>
                    </tr>
                    <tr>
                        <td><span class="boldovano">Датум / Date:</span></td>
                        <td><span class="boldovano">Датум / Date:</span></td>
                    </tr>
                    <tr>
                        <td><span class="boldovano">Здравствена установа / Health care institution:</span></td>
                        <td><span class="boldovano">Здравствена установа / Health care institution:</span></td>
                    </tr>
                    <tr>
                     <xsl:for-each select="b:Sertifikat/b:Info_vakcinacije/b:Vakcinacije">
                        <xsl:sort select="@Doza"/>
                        <td><xsl:value-of select="b:Zdravsvena_ustanova"/></td>
                     </xsl:for-each>
                    </tr>
            	</table>
            	
            	<p>
	            	<img src="../../data/pictures/linija.png"/>
	            	<br/>
            	</p> 
            	<table style="width: 95%; align:center;text-align:left">
            		<tr>
                        <td style="text-align:center"><span class="veci_bold" style="text-align:center">SARS-CoV-2 RT</span></td>
                        <td style="text-align:center"><span class="veci_bold" style="text-align:center">SARS-CoV-2 Ag-RDT</span></td>
                        <td style="text-align:center"><span class="veci_bold" style="text-align:center">SARS-CoV-2 RBD S-Protein</span></td>
                    </tr>
            		<tr>
                        <td style="text-align:center"><span class="veci_bold" style="text-align:center">Real-time PCR</span></td>
                        <td style="text-align:center"><span class="veci_bold" style="text-align:center">(Antigen Rapid Detection test)</span></td>
                        <td style="text-align:center"><span class="veci_bold" style="text-align:center">Immunoglobulin G (IgG) test</span></td>
                    </tr>
                    <tr>
                        <td><span class="boldovano">Врста узорка / Sample type:</span></td>
                        <td><span class="boldovano">Врста узорка / Sample type:</span></td>
                        <td><span class="boldovano">Врста узорка / Sample type:</span></td>
                    </tr>
                    <tr>
                        <td>N/A</td>
                        <td>N/A</td>
                        <td>N/A</td>
                    </tr>
                    <tr>
                        <td><span class="boldovano">Произвођач теста / Test manufacurer:</span></td>
                        <td><span class="boldovano">Произвођач теста / Test manufacurer:</span></td>
                        <td><span class="boldovano">Произвођач теста / Test manufacurer:</span></td>
                    </tr>
                    <tr>
                        <td>N/A</td>
                        <td>N/A</td>
                        <td>N/A</td>
                    </tr>
                    <tr>
                        <td><span class="boldovano">Датум и време узроковања /</span></td>
                        <td><span class="boldovano">Датум и време узроковања /</span></td>
                        <td><span class="boldovano">Датум и време узроковања /</span></td>
                    </tr>
                    <tr>
                        <td><span class="boldovano">Date and time of sampling:</span></td>
                        <td><span class="boldovano">Date and time of sampling:</span></td>
                        <td><span class="boldovano">Date and time of sampling:</span></td>
                    </tr>
                    <tr>
                        <td>N/A</td>
                        <td>N/A</td>
                        <td>N/A</td>
                    </tr>
                    <tr>
                        <td><span class="boldovano">Датум и време издавања резултата /</span></td>
                        <td><span class="boldovano">Датум и време издавања резултата /</span></td>
                        <td><span class="boldovano">Датум и време издавања резултата /</span></td>
                    </tr>
                    <tr>
                        <td><span class="boldovano">Date and time of result:</span></td>
                        <td><span class="boldovano">Date and time of result:</span></td>
                        <td><span class="boldovano">Date and time of result:</span></td>
                    </tr>
                    <tr>
                        <td>N/A</td>
                        <td>N/A</td>
                        <td>N/A</td>
                    </tr>
                    <tr style="background-color:#D3D3D3">
                        <td><span class="boldovano">Резултат / Result:</span></td>
                        <td><span class="boldovano">Резултат / Result:</span></td>
                        <td><span class="boldovano">Резултат / Result:</span></td>
                    </tr>
                    <tr style="background-color:#D3D3D3">
                        <td>N/A</td>
                        <td>N/A</td>
                        <td>N/A</td>
                    </tr>
                    <tr style="background-color:#D3D3D3">
                        <td><span class="boldovano">Лабораторија / Laboratory:</span></td>
                        <td><span class="boldovano">Лабораторија / Laboratory:</span></td>
                        <td><span class="boldovano">Лабораторија / Laboratory:</span></td>
                    </tr>
                    <tr style="background-color:#D3D3D3">
                        <td>N/A</td>
                        <td>N/A</td>
                        <td>N/A</td>
                    </tr>
                    
            	</table>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>
