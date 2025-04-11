<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="/cartelera/recinto">
        <html>
            <head>
                <link rel="stylesheet" href="./styles.css"> </link>
            </head>
            <body>
                <!-- Header -->
                <div class="address"> Adreça: <xsl:value-of select="address"/></div>
                <div class="postcode"> Codi postal: <xsl:value-of select="postcode" /></div>
                <div class="city"> Ciutat: <xsl:value-of select="city" /></div>

                <!-- Container with all the films -->
                <div class="container">
                    <xsl:for-each select="evento">
                        <div>
                            <!-- title of the filjm-->
                            <p class="title">TÍTOL: <xsl:value-of select="titulo/@value"></xsl:value-of></p>
                            <!-- image of the film-->
                            <xsl:element name="img">
                                <xsl:attribute name="src">
                                    <xsl:if test="caratula != ''">
                                        <xsl:value-of select="caratula"></xsl:value-of>
                                    </xsl:if>
                                    <xsl:if test="caratula = ''">
                                        <xsl:text>http://portal.reservaentradas.com/portal/obj/ReservaEntradas_dat_dat/eventos/JPG00cwq.jpg</xsl:text>
                                    </xsl:if>
                                </xsl:attribute>
                                <xsl:attribute name="height">390</xsl:attribute>
                                <xsl:attribute name="width">273.04</xsl:attribute>
                            </xsl:element>
                            <!-- description of th efilm -->
                            <xsl:if test="sinopsis != ''">
                                <p>SINOPSI: <xsl:value-of select="sinopsis"></xsl:value-of></p>
                            </xsl:if>
                            <xsl:if test="calificacion != ''">
                                <p>INFO: <xsl:value-of select="calificacion"></xsl:value-of></p>
                            </xsl:if>
                            <xsl:if test="genero != ''">
                                <p>GÈNERE: <xsl:value-of select="genero"></xsl:value-of></p>
                            </xsl:if>
                            <!-- add also the trailer-->
                        </div>
                    </xsl:for-each>
                </div>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>