
package com.biomarkhealth.medli.models;

import com.biomarkhealth.medli.models.doses.ConceptGroup;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class DrugGroup {

    private String name;
    private List<ConceptGroup> conceptGroup = new ArrayList<ConceptGroup>();
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

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
     *     The conceptGroup
     */
    public List<ConceptGroup> getConceptGroup() {
        return conceptGroup;
    }

    /**
     * 
     * @param conceptGroup
     *     The conceptGroup
     */
    public void setConceptGroup(List<ConceptGroup> conceptGroup) {
        this.conceptGroup = conceptGroup;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
