<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
    xmlns:b="http://www.baklavice.com/digitalni_sertifikat"
    xmlns:t="http://www.baklavice.com/tipovi" version="2.0">

    <xsl:template match="/">
        <html>
            <head>
                <title>Digitalni sertifikat</title>
                <meta charset="UTF-8"/>
                <style type="text/css">
					body {
					    background-color: white;
					    font-family: Georgia, serif;
					    color: black;
					    text-align: justify;
					    font-size: 13;
					}
					span.naslov {
					    font-size: 15;
					    font-weight: bold;
					}
					
					span.podnaslov {
					    font-size: 14;
					}
					
					span.veci_bold {
					    font-size: 14;
					    font-weight: bold;
					}
					
					span.jos_veci_bold {
					    font-size: 15;
					    font-weight: bold;
					}
					
					span.boldovano {
					    font-weight: bold;
					}

                </style>
            </head>
            <body>
           		<img src="data\pictures\zaglavlje_zs.png" align="center"/>
            	<br/>
            	<p>
	            	<span class="boldovano">Број сертификата /</span>
	            	<img src="data\pictures\prazan_prostor.png" width="155" height="13"/>
	            	<span class="boldovano">Датум и време издавања сертификата /</span>
	            	<br/>
	            	<span class="boldovano">Certificate ID: </span>
	            	<img src="data\pictures\prazan_prostor.png" width="50" height="12"/>
	            	<xsl:value-of select="b:Sertifikat/b:Info_sertifikat/b:Broj_sertifikata"/>
	            	<img src="data\pictures\prazan_prostor.png" width="100" height="12"/>
	            	<span class="boldovano">Certificate issuing date and time: </span>
	            	<img src="data\pictures\prazan_prostor.png" width="50" height="12"/>
	            	<xsl:value-of select="b:Sertifikat/b:Info_sertifikat/b:Datum_izdavanja"/>
	            	<br/>
	            </p>
	            <table style="width: 80%; align:left; text-align:left;font-size:12;">
	            	<tr>
                        <td><span class="boldovano">Име и презиме / Name and surname:</span></td>
                        <td>
                        	<xsl:value-of select="b:Sertifikat/b:Info_korisnika/t:Ime"/>
                        	<img src="data\pictures\prazan_prostor.png" width="5" height="12"/>
	            			<xsl:value-of select="b:Sertifikat/b:Info_korisnika/t:Prezime"/>
                        </td>
                    </tr>
                    <tr>
                        <td><span class="boldovano">Пол / Gender:</span></td>
                        <td><xsl:value-of select="b:Sertifikat/b:Info_korisnika/t:Pol"/></td>
                    </tr>
                    <tr>
                        <td><span class="boldovano">Датум рођења / Date of birth:</span></td>
                        <td><xsl:value-of select="b:Sertifikat/b:Info_korisnika/t:Datum_rodjenja"/></td>
                    </tr>
                    <tr>
                        <td><span class="boldovano">ЈМБГ / Personal No. / EBS:</span></td>
                        <td><xsl:value-of select="b:Sertifikat/b:Info_korisnika/t:JMBG"/></td>
                    </tr>
                    <tr>
                        <td><span class="boldovano">Број пасоша / Passport No.:</span></td>
                        <td><xsl:value-of select="b:Sertifikat/b:Info_korisnika/t:Broj_pasosa"/></td>
                    </tr>
				</table>
            	<br/>
            	<img src="data\pictures\linija.png"/>
            	<br/>
            	
            	<table style="width: 95%; align:center; text-align:left;font-size:13;">
            		<tr>
                        <td colspan="2" style="text-align:center"><span class="jos_veci_bold">Вакцинација / Vaccination</span></td>
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
	            	<img src="data\pictures\linija.png"/>
	            	<br/>
            	</p> 
            	<table style="text-align:left;font-size:13;width:100%;align:center">
            		<tr>
                        <td style="text-align:center"><span class="veci_bold">SARS-CoV-2 RT</span></td>
                        <td style="text-align:center"><span class="veci_bold">SARS-CoV-2 Ag-RDT</span></td>
                        <td style="text-align:center"><span class="veci_bold">SARS-CoV-2 RBD S-Protein</span></td>
                    </tr>
            		<tr>
                        <td style="text-align:center"><span class="veci_bold">Real-time PCR</span></td>
                        <td style="text-align:center"><span class="veci_bold">(Antigen Rapid Detection test)</span></td>
                        <td style="text-align:center"><span class="veci_bold">Immunoglobulin G (IgG) test</span></td>
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
                        <td><span class="boldovano">Датум и време узроковања / Date and time of sampling:</span></td>
                        <td><span class="boldovano">Датум и време узроковања / Date and time of sampling:</span></td>
                        <td><span class="boldovano">Датум и време узроковања / Date and time of sampling:</span></td>
                    </tr>
                    <tr>
                        <td>N/A</td>
                        <td>N/A</td>
                        <td>N/A</td>
                    </tr>
                    <tr>
                        <td><span class="boldovano">Датум и време издавања резултата / Date and time of result:</span></td>
                        <td><span class="boldovano">Датум и време издавања резултата / Date and time of result:</span></td>
                        <td><span class="boldovano">Датум и време издавања резултата / Date and time of result:</span></td>
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
            	
            	<br/>
           		<img src="data\pictures\podnozje_zs.png" align="center"/>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>
