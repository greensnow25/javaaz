<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:output method="xml" indent="yes"/>
    <xsl:template match="/">
        <xsl:for-each select="id_number">
            <item >
                <id><xsl:value-of select="id_key"/></id>>
                <number><xsl:value-of select="number"/></number>>
            </item>>
        </xsl:for-each>
    </xsl:template>

</xsl:stylesheet>