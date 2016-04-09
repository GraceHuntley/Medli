
package com.biomarkhealth.medli.models;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class MedSuggestions {

    private SuggestionGroup suggestionGroup;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The suggestionGroup
     */
    public SuggestionGroup getSuggestionGroup() {
        return suggestionGroup;
    }

    /**
     * 
     * @param suggestionGroup
     *     The suggestionGroup
     */
    public void setSuggestionGroup(SuggestionGroup suggestionGroup) {
        this.suggestionGroup = suggestionGroup;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
