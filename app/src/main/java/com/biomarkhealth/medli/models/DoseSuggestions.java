
package com.biomarkhealth.medli.models;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class DoseSuggestions {

    private DrugGroup drugGroup;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The drugGroup
     */
    public DrugGroup getDrugGroup() {
        return drugGroup;
    }

    /**
     * 
     * @param drugGroup
     *     The drugGroup
     */
    public void setDrugGroup(DrugGroup drugGroup) {
        this.drugGroup = drugGroup;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
