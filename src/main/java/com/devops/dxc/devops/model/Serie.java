package com.devops.dxc.devops.model;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"fecha",
"valor"
})
@Generated("jsonschema2pojo")
public class Serie {

@JsonProperty("fecha")
private String fecha;
@JsonProperty("valor")
private Double valor;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

@JsonProperty("fecha")
public String getFecha() {
return fecha;
}

@JsonProperty("fecha")
public void setFecha(String fecha) {
this.fecha = fecha;
}

@JsonProperty("valor")
public Double getValor() {
return valor;
}

@JsonProperty("valor")
public void setValor(Double valor) {
this.valor = valor;
}

@JsonAnyGetter
public Map<String, Object> getAdditionalProperties() {
return this.additionalProperties;
}

@JsonAnySetter
public void setAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
}

@Override
public String toString(){
  return valor.toString();
}
/*
      public String toString() {
        return ":[{" +
            "fecha=" + fecha +
            ", valor='" + valor + '\'' +
            '}';
      }*/
}
