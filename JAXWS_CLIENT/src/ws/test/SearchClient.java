
package ws.test;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for searchClient complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="searchClient">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="cle" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ob" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "searchClient", propOrder = {
    "cle",
    "ob"
})
public class SearchClient {

    protected String cle;
    protected String ob;

    /**
     * Gets the value of the cle property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCle() {
        return cle;
    }

    /**
     * Sets the value of the cle property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCle(String value) {
        this.cle = value;
    }

    /**
     * Gets the value of the ob property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOb() {
        return ob;
    }

    /**
     * Sets the value of the ob property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOb(String value) {
        this.ob = value;
    }

}
