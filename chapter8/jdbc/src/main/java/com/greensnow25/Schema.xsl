<?xml version="1.0" encoding="utf-8"?>
<xsl:stylesheet version="1.0"
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="xml" indent="yes"/>

    <xsl:template match="/">
        <xsl:apply-templates/>
    </xsl:template>
    >

    <xsl:template match="id_number">
        <xsl:element name="entity">
            <xsl:attribute name="id_key">
                <xsl:value-of select="id_key"/>
            </xsl:attribute>
            <xsl:attribute name="number">
                <xsl:value-of select="number"/>
            </xsl:attribute>
        </xsl:element>
    </xsl:template>
</xsl:stylesheet>
