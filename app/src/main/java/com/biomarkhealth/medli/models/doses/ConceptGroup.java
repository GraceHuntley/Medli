
package com.biomarkhealth.medli.models.doses;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class ConceptGroup {

    private String tty;
    private List<ConceptProperty> conceptProperties = new ArrayList<ConceptProperty>();
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

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
     *     The conceptProperties
     */
    public List<ConceptProperty> getConceptProperties() {
        return conceptProperties;
    }

    /**
     * 
     * @param conceptProperties
     *     The conceptProperties
     */
    public void setConceptProperties(List<ConceptProperty> conceptProperties) {
        this.conceptProperties = conceptProperties;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
