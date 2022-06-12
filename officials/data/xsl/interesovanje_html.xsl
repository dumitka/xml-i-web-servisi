<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
    xmlns:b="http://www.baklavice.com/interesovanje"
    xmlns:t="http://www.baklavice.com/tipovi" version="2.0">

    <xsl:template match="/">
        <html>
            <head>
                <title>Interesovanje za vakcinaciju</title>
                <meta charset="UTF-8"/>
                <style type="text/css">
					body {
					    background-color: white;
					    font-family: Georgia, serif;
					    color: black;
					    text-align: justify;
					    font-size: 16;
					    margin-left:150;
					    margin-right:150;
					}
                </style>
            </head>
            <body>
            	<p style="text-align:center;font-weight: bold;font-size:22;">
            		Исказивање интересовања за вакцинисање против COVID-19
            	</p>
            	<p>
            		<br/>
            		Одаберите опцију
            		<xsl:if test="b:Interesovanje/b:Podaci_o_licu/t:Drzavljanstvo='Republika Srbija'">
	            		<ul>
	            			<li type="disc">Држављанин Републике Србије</li>
	            			<li type="circle">Страни држављанин са боравком у РС</li>
	            			<li type="circle">Страни држављанин без боравка у РС</li>
	            		</ul>
            		</xsl:if>
            		<xsl:else>
            			<xsl:if test="b:Interesovanje/b:Podaci_o_licu/t:Boraviste='Republika Srbija'">
            				<ul>
		            			<li type="circle">Држављанин Републике Србије</li>
		            			<li type="disc">Страни држављанин са боравком у РС</li>
		            			<li type="circle">Страни држављанин без боравка у РС</li>
		            		</ul>
            			</xsl:if>
	            		<xsl:else>
            				<ul>
		            			<li type="circle">Држављанин Републике Србије</li>
		            			<li type="circle">Страни држављанин са боравком у РС</li>
		            			<li type="disc">Страни држављанин без боравка у РС</li>
		            		</ul>
            			</xsl:else>
            		</xsl:else>
            		<br/>
            	</p>
            	<p>
            		<span style="font-size:18">ЈМБГ:</span><br/>
            		<xsl:value-of select="b:Interesovanje/b:Podaci_o_licu/t:JMBG"/><br/><br/>
            		<span style="font-size:18">Име:</span><br/>
            		<xsl:value-of select="b:Interesovanje/b:Podaci_o_licu/t:Ime"/><br/><br/>
            		<span style="font-size:18">Презиме:</span><br/>
            		<xsl:value-of select="b:Interesovanje/b:Podaci_o_licu/t:Prezime"/><br/><br/>
            		<span style="font-size:18">Адреса електронске поште:</span><br/>
            		<xsl:value-of select="b:Interesovanje/b:Kontakt/t:Email"/><br/><br/>
            		<span style="font-size:18">Број мобилног телефона (навести број у формату 06Х... без размака и цртица):</span><br/>
            		<xsl:value-of select="b:Interesovanje/b:Kontakt/t:Broj_mobilnog"/><br/><br/>
            		<span style="font-size:18">Број фикцног телефона (навести број у формату нпр. 021... без размака и цртица):</span><br/>
            		<xsl:value-of select="b:Interesovanje/b:Kontakt/t:Broj_fiksnog"/><br/><br/>
            		<span style="font-size:18">Одаберите локацију где желите да примите вакцину (унесите општину):</span><br/>
            		<xsl:value-of select="b:Interesovanje/b:Podaci_o_vakcinaciji/b:Opstina_ustanove"/><br/><br/>
            	</p>
            	<p>
            		<span style="font-size:18">Исказујем интересовање да примим искључиво вакцину
            		следећих произвођача за који Агенција за лекове и медицинска средства потврди
            		безбедност, ефикасност и квалитет и изда дозволу за употребу лека:</span><br/>
            		<xsl:if test="b:Interesovanje/b:Podaci_o_vakcinaciji/b:Tip_vakcine='Pfizer-BioNTech'">
	            		<ul>
	            			<li type="disc">Pfizer-BioNTech</li>
	            			<li type="circle">Sputnik V (Gamaleya и истраживачки центар)</li>
	            			<li type="circle">Sinopharm</li>
	            			<li type="circle">AstraZeneca</li>
	            			<li type="circle">Moderna</li>
	            			<li type="circle">Било која</li>
	            		</ul>
            		</xsl:if>
           			<xsl:if test="b:Interesovanje/b:Podaci_o_vakcinaciji/b:Tip_vakcine='Sputnik V (Gamaleya и истраживачки центар)'">
	            		<ul>
	            			<li type="circle">Pfizer-BioNTech</li>
	            			<li type="disc">Sputnik V (Gamaleya и истраживачки центар)</li>
	            			<li type="circle">Sinopharm</li>
	            			<li type="circle">AstraZeneca</li>
	            			<li type="circle">Moderna</li>
	            			<li type="circle">Било која</li>
	            		</ul>
            		</xsl:if>
            		<xsl:if test="b:Interesovanje/b:Podaci_o_vakcinaciji/b:Tip_vakcine='Sinopharm'">
	            		<ul>
	            			<li type="circle">Pfizer-BioNTech</li>
	            			<li type="circle">Sputnik V (Gamaleya и истраживачки центар)</li>
	            			<li type="disc">Sinopharm</li>
	            			<li type="circle">AstraZeneca</li>
	            			<li type="circle">Moderna</li>
	            			<li type="circle">Било која</li>
	            		</ul>
            		</xsl:if>
            		<xsl:if test="b:Interesovanje/b:Podaci_o_vakcinaciji/b:Tip_vakcine='AstraZeneca'">
	            		<ul>
	            			<li type="circle">Pfizer-BioNTech</li>
	            			<li type="circle">Sputnik V (Gamaleya и истраживачки центар)</li>
	            			<li type="circle">Sinopharm</li>
	            			<li type="disc">AstraZeneca</li>
	            			<li type="circle">Moderna</li>
	            			<li type="circle">Било која</li>
	            		</ul>
            		</xsl:if>
            		<xsl:if test="b:Interesovanje/b:Podaci_o_vakcinaciji/b:Tip_vakcine='Moderna'">
	            		<ul>
	            			<li type="circle">Pfizer-BioNTech</li>
	            			<li type="circle">Sputnik V (Gamaleya и истраживачки центар)</li>
	            			<li type="circle">Sinopharm</li>
	            			<li type="circle">AstraZeneca</li>
	            			<li type="disc">Moderna</li>
	            			<li type="circle">Било која</li>
	            		</ul>
            		</xsl:if>
            		<xsl:if test="b:Interesovanje/b:Podaci_o_vakcinaciji/b:Tip_vakcine='Било која'">
	            		<ul>
	            			<li type="circle">Pfizer-BioNTech</li>
	            			<li type="circle">Sputnik V (Gamaleya и истраживачки центар)</li>
	            			<li type="circle">Sinopharm</li>
	            			<li type="circle">AstraZeneca</li>
	            			<li type="circle">Moderna</li>
	            			<li type="disc">Било која</li>
	            		</ul>
            		</xsl:if>
            		<br/>
            	</p>
            	<p>
            		<span style="font-size:18">Да ли сте добровољни давалац крви?</span><br/>
            		<xsl:if test="b:Interesovanje/b:Podaci_o_vakcinaciji/b:Davalac_krvi='true'">
	            		<ul>
	            			<li type="disc">Да</li>
	            			<li type="circle">Не</li>
	            		</ul>
            		</xsl:if>
            		<xsl:else>
           				<ul>
	            			<li type="circle">Да</li>
	            			<li type="disc">Не</li>
	            		</ul>
            		</xsl:else>
            		<br/>
            	</p>
            	<p>
            	<br/><br/><br/><br/><br/>
            	дана <xsl:value-of select="b:Interesovanje/b:Datum_interesovanja"/> године
            	<img src="../../data/pictures/prazan_prostor.png" width="500" height="12"/>
            	____________________________________
            	<br/>
            	<img src="../../data/pictures/prazan_prostor.png" width="850" height="12"/>
            	<span style="font-size:10">Потпис</span>
            	</p>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>
