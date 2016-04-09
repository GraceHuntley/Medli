
package com.biomarkhealth.medli.models.doses;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class ConceptProperty {

    private String rxcui;
    private String name;
    private String synonym;
    private String tty;
    private String language;
    private String suppress;
    private String umlscui;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The rxcui
     */
    public String getRxcui() {
        return rxcui;
    }

    /**
     * 
     * @param rxcui
     *     The rxcui
     */
    public void setRxcui(String rxcui) {
        this.rxcui = rxcui;
    }

    /**
     * 
     * @return
     *     The name
     */
    public String getName() {
        return name;
    }

    /**
     * 
     * @param name
     *     The name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 
     * @return
     *     The synonym
     */
    public String getSynonym() {
        return synonym;
    }

    /**
     * 
     * @param synonym
     *     The synonym
     */
    public void setSynonym(String synonym) {
        this.synonym = synonym;
    }

    /**
     * 
     * @return
     *     The tty
     */
    public String getTty() {
        return tty;
    }

    /**
     * 
     * @param tty
     *     The tty
     */
    public void setTty(String tty) {
        this.tty = tty;
    }

    /**
     * 
     * @return
     *     The language
     */
    public String getLanguage() {
        return language;
    }

    /**
     * 
     * @param language
     *     The language
     */
    public void setLanguage(String language) {
        this.language = language;
    }

    /**
     * 
     * @return
     *     The suppress
     */
    public String getSuppress() {
        return suppress;
    }

    /**
     * 
     * @param suppress
     *     The suppress
     */
    public void setSuppress(String suppress) {
        this.suppress = suppress;
    }

    /**
     * 
     * @return
     *     The umlscui
     */
    public String getUmlscui() {
        return umlscui;
    }

    /**
     * 
     * @param umlscui
     *     The umlscui
     */
    public void setUmlscui(String umlscui) {
        this.umlscui = umlscui;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
