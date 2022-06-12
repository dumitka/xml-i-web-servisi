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
					    font-size: 14;
					}
                </style>
            </head>
            <body>
            	<p style="text-align:center;font-weight: bold;font-size:17;">
            		Исказивање интересовања за вакцинисање против COVID-19
            	</p>
            	<p>
            		<br/>
            		Одаберите опцију
            		<xsl:if test="b:Interesovanje/b:Podaci_o_licu/t:Drzavljanstvo='Republika Srbija'">
            			<ul><li>Држављанин Републике Србије</li></ul>
	            		<img src="data\pictures\prazan_prostor.png" width="30" height="12"/>Страни држављанин са боравком у РС<br/>
	            		<img src="data\pictures\prazan_prostor.png" width="30" height="12"/>Страни држављанин без боравка у РС<br/>
            		</xsl:if>
            		<xsl:else>
            			<xsl:if test="b:Interesovanje/b:Podaci_o_licu/t:Boraviste='Republika Srbija'">
            				<img src="data\pictures\prazan_prostor.png" width="30" height="12"/>Држављанин Републике Србије<br/>
            				<ul><li>Страни држављанин са боравком у РС</li></ul>
		            		<img src="data\pictures\prazan_prostor.png" width="30" height="12"/>Страни држављанин без боравка у РС<br/>
            			</xsl:if>
	            		<xsl:else>
	            			<img src="data\pictures\prazan_prostor.png" width="30" height="12"/>Држављанин Републике Србије<br/>
	            			<img src="data\pictures\prazan_prostor.png" width="30" height="12"/>Страни држављанин са боравка у РС<br/>
            				<ul><li>Страни држављанин без боравком у РС</li></ul>
		            		
            				
            			</xsl:else>
            		</xsl:else>
            		<br/>
            	</p>
            	<p>
            		<span style="font-size:15">ЈМБГ:</span><br/>
            		<xsl:value-of select="b:Interesovanje/b:Podaci_o_licu/t:JMBG"/><br/><br/>
            		<span style="font-size:15">Име:</span><br/>
            		<xsl:value-of select="b:Interesovanje/b:Podaci_o_licu/t:Ime"/><br/><br/>
            		<span style="font-size:15">Презиме:</span><br/>
            		<xsl:value-of select="b:Interesovanje/b:Podaci_o_licu/t:Prezime"/><br/><br/>
            		<span style="font-size:15">Адреса електронске поште:</span><br/>
            		<xsl:value-of select="b:Interesovanje/b:Kontakt/t:Email"/><br/><br/>
            		<span style="font-size:15">Број мобилног телефона (навести број у формату 06Х... без размака и цртица):</span><br/>
            		<xsl:value-of select="b:Interesovanje/b:Kontakt/t:Broj_mobilnog"/><br/><br/>
            		<span style="font-size:15">Број фикцног телефона (навести број у формату нпр. 021... без размака и цртица):</span><br/>
            		<xsl:value-of select="b:Interesovanje/b:Kontakt/t:Broj_fiksnog"/><br/><br/>
            		<span style="font-size:15">Одаберите локацију где желите да примите вакцину (унесите општину):</span><br/>
            		<xsl:value-of select="b:Interesovanje/b:Podaci_o_vakcinaciji/b:Opstina_ustanove"/><br/><br/>
            	</p>
            	<p>
            		<span style="font-size:15">Исказујем интересовање да примим искључиво вакцину
            		следећих произвођача за који Агенција за лекове и медицинска средства потврди
            		безбедност, ефикасност и квалитет и изда дозволу за употребу лека:</span><br/>
            		<xsl:if test="b:Interesovanje/b:Podaci_o_vakcinaciji/b:Tip_vakcine='Pfizer-BioNTech'">
	            		<ul><li>Pfizer-BioNTech</li></ul>
	            		<img src="data\pictures\prazan_prostor.png" width="30" height="12"/>Sputnik V (Gamaleya и истраживачки центар)<br/>
	            		<img src="data\pictures\prazan_prostor.png" width="30" height="12"/>Sinopharm<br/>
	            		<img src="data\pictures\prazan_prostor.png" width="30" height="12"/>AstraZeneca<br/>
	            		<img src="data\pictures\prazan_prostor.png" width="30" height="12"/>Moderna<br/>
	            		<img src="data\pictures\prazan_prostor.png" width="30" height="12"/>Било која<br/>
            		</xsl:if>
           			<xsl:if test="b:Interesovanje/b:Podaci_o_vakcinaciji/b:Tip_vakcine='Sputnik V (Gamaleya и истраживачки центар)'">
						<img src="data\pictures\prazan_prostor.png" width="30" height="12"/>Pfizer-BioNTech<br/>
	            		<ul><li>Sputnik V (Gamaleya и истраживачки центар)</li></ul>
	            		<img src="data\pictures\prazan_prostor.png" width="30" height="12"/>Sinopharm<br/>
	            		<img src="data\pictures\prazan_prostor.png" width="30" height="12"/>AstraZeneca<br/>
	            		<img src="data\pictures\prazan_prostor.png" width="30" height="12"/>Moderna<br/>
	            		<img src="data\pictures\prazan_prostor.png" width="30" height="12"/>Било која<br/>
            		</xsl:if>
            		<xsl:if test="b:Interesovanje/b:Podaci_o_vakcinaciji/b:Tip_vakcine='Sinopharm'">
	            		<img src="data\pictures\prazan_prostor.png" width="30" height="12"/>Pfizer-BioNTech<br/>
	            		<img src="data\pictures\prazan_prostor.png" width="30" height="12"/>Sputnik V (Gamaleya и истраживачки центар)<br/>
	            		<ul><li>Sinopharm</li></ul>
	            		<img src="data\pictures\prazan_prostor.png" width="30" height="12"/>AstraZeneca<br/>
	            		<img src="data\pictures\prazan_prostor.png" width="30" height="12"/>Moderna<br/>
	            		<img src="data\pictures\prazan_prostor.png" width="30" height="12"/>Било која<br/>
            		</xsl:if>
            		<xsl:if test="b:Interesovanje/b:Podaci_o_vakcinaciji/b:Tip_vakcine='AstraZeneca'">
	            		<img src="data\pictures\prazan_prostor.png" width="30" height="12"/>Pfizer-BioNTech<br/>
	            		<img src="data\pictures\prazan_prostor.png" width="30" height="12"/>Sputnik V (Gamaleya и истраживачки центар)<br/>
	            		<img src="data\pictures\prazan_prostor.png" width="30" height="12"/>Sinopharm<br/>
	            		<ul><li>AstraZeneca</li></ul>
	            		<img src="data\pictures\prazan_prostor.png" width="30" height="12"/>Moderna<br/>
	            		<img src="data\pictures\prazan_prostor.png" width="30" height="12"/>Било која<br/>
            		</xsl:if>
            		<xsl:if test="b:Interesovanje/b:Podaci_o_vakcinaciji/b:Tip_vakcine='Moderna'">
	            		<img src="data\pictures\prazan_prostor.png" width="30" height="12"/>Pfizer-BioNTech<br/>
	            		<img src="data\pictures\prazan_prostor.png" width="30" height="12"/>Sputnik V (Gamaleya и истраживачки центар)<br/>
	            		<img src="data\pictures\prazan_prostor.png" width="30" height="12"/>Sinopharm<br/>
	            		<img src="data\pictures\prazan_prostor.png" width="30" height="12"/>AstraZeneca<br/>
	            		<ul><li>Moderna</li></ul>
	            		<img src="data\pictures\prazan_prostor.png" width="30" height="12"/>Било која<br/>
            		</xsl:if>
            		<xsl:if test="b:Interesovanje/b:Podaci_o_vakcinaciji/b:Tip_vakcine='Било која'">
	            		<img src="data\pictures\prazan_prostor.png" width="30" height="12"/>Pfizer-BioNTech<br/>
	            		<img src="data\pictures\prazan_prostor.png" width="30" height="12"/>Sputnik V (Gamaleya и истраживачки центар)<br/>
	            		<img src="data\pictures\prazan_prostor.png" width="30" height="12"/>Sinopharm<br/>
	            		<img src="data\pictures\prazan_prostor.png" width="30" height="12"/>AstraZeneca<br/>
	            		<img src="data\pictures\prazan_prostor.png" width="30" height="12"/>Moderna<br/>
	            		<ul><li>Било која</li></ul>
            		</xsl:if>
            		<br/>
            	</p>
            	<p>
            		<span style="font-size:15">Да ли сте добровољни давалац крви?</span><br/>
            		<xsl:if test="b:Interesovanje/b:Podaci_o_vakcinaciji/b:Davalac_krvi='true'">
	            		<ul><li>Да</li></ul>
	            		<img src="data\pictures\prazan_prostor.png" width="30" height="12"/>Не<br/>
            		</xsl:if>
            		<xsl:else>
	            		<img src="data\pictures\prazan_prostor.png" width="30" height="12"/>Да<br/>
           				<ul><li>Не</li></ul>
            		</xsl:else>
            		<br/>
            	</p>
            	<p>
            	<br/><br/><br/><br/><br/>
            	дана <xsl:value-of select="b:Interesovanje/b:Datum_interesovanja"/> године
            	<img src="data\pictures\prazan_prostor.png" width="280" height="12"/>
            	______________________
            	<br/>
            	<img src="data\pictures\prazan_prostor.png" width="530" height="12"/>
            	<span style="font-size:10">Потпис</span>
            	</p>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>
