
package com.biomarkhealth.medli.models;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class SuggestionGroup {

    private String name;
    private SuggestionList suggestionList;
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
     *     The suggestionList
     */
    public SuggestionList getSuggestionList() {
        return suggestionList;
    }

    /**
     * 
     * @param suggestionList
     *     The suggestionList
     */
    public void setSuggestionList(SuggestionList suggestionList) {
        this.suggestionList = suggestionList;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
