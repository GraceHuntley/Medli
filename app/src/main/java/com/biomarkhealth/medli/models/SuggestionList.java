
package com.biomarkhealth.medli.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class SuggestionList {

    private List<String> suggestion = new ArrayList<String>();
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The suggestion
     */
    public List<String> getSuggestion() {
        return suggestion;
    }

    /**
     * 
     * @param suggestion
     *     The suggestion
     */
    public void setSuggestion(List<String> suggestion) {
        this.suggestion = suggestion;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
