
package ip.geolocation.io;

import java.util.LinkedHashMap;
import java.util.Map;
import jakarta.annotation.Generated;
import jakarta.json.bind.annotation.JsonbProperty;
import jakarta.json.bind.annotation.JsonbPropertyOrder;
import jakarta.json.bind.annotation.JsonbTransient;

@JsonbPropertyOrder({
    "name",
    "code",
    "symbol"
})
@Generated("jsonschema2pojo")
public class Currency {

    @JsonbProperty("name")
    private String name;
    @JsonbProperty("code")
    private String code;
    @JsonbProperty("symbol")
    private String symbol;
    @JsonbTransient
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonbProperty("name")
    public String getName() {
        return name;
    }

    @JsonbProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonbProperty("code")
    public String getCode() {
        return code;
    }

    @JsonbProperty("code")
    public void setCode(String code) {
        this.code = code;
    }

    @JsonbProperty("symbol")
    public String getSymbol() {
        return symbol;
    }

    @JsonbProperty("symbol")
    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
