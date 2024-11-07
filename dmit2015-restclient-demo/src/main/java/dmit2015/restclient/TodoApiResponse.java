package dmit2015.restclient;

import java.util.LinkedHashMap;
import java.util.Map;
import jakarta.annotation.Generated;
import jakarta.json.bind.annotation.JsonbProperty;
import jakarta.json.bind.annotation.JsonbPropertyOrder;
import jakarta.json.bind.annotation.JsonbTransient;

@JsonbPropertyOrder({
"complete",
"id",
"name",
"version"
})
@Generated("jsonschema2pojo")
public class TodoApiResponse {

@JsonbProperty("complete")
private Boolean complete;
@JsonbProperty("id")
private Long id;
@JsonbProperty("name")
private String name;
@JsonbProperty("version")
private Integer version;
@JsonbTransient
private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

@JsonbProperty("complete")
public Boolean getComplete() {
return complete;
}

@JsonbProperty("complete")
public void setComplete(Boolean complete) {
this.complete = complete;
}

@JsonbProperty("id")
public Long getId() {
return id;
}

@JsonbProperty("id")
public void setId(Long id) {
this.id = id;
}

@JsonbProperty("name")
public String getName() {
return name;
}

@JsonbProperty("name")
public void setName(String name) {
this.name = name;
}

@JsonbProperty("version")
public Integer getVersion() {
return version;
}

@JsonbProperty("version")
public void setVersion(Integer version) {
this.version = version;
}

public Map<String, Object> getAdditionalProperties() {
return this.additionalProperties;
}

public void setAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
}

}
