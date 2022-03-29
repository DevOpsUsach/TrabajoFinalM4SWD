package com.devops.dxc.devops.model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.HashMap;
import java.util.List;
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
"version",
"autor",
"codigo",
"nombre",
"unidad_medida",
"serie"
})
@Generated("jsonschema2pojo")
public class UfHoy {

@JsonProperty("version")
private String version;
@JsonProperty("autor")
private String autor;
@JsonProperty("codigo")
private String codigo;
@JsonProperty("nombre")
private String nombre;
@JsonProperty("unidad_medida")
private String unidadMedida;
@JsonProperty("serie")
private List<Serie> serie = null;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

@JsonProperty("version")
public String getVersion() {
return version;
}

@JsonProperty("version")
public void setVersion(String version) {
this.version = version;
}

@JsonProperty("autor")
public String getAutor() {
return autor;
}

@JsonProperty("autor")
public void setAutor(String autor) {
this.autor = autor;
}

@JsonProperty("codigo")
public String getCodigo() {
return codigo;
}

@JsonProperty("codigo")
public void setCodigo(String codigo) {
this.codigo = codigo;
}

@JsonProperty("nombre")
public String getNombre() {
return nombre;
}

@JsonProperty("nombre")
public void setNombre(String nombre) {
this.nombre = nombre;
}

@JsonProperty("unidad_medida")
public String getUnidadMedida() {
return unidadMedida;
}

@JsonProperty("unidad_medida")
public void setUnidadMedida(String unidadMedida) {
this.unidadMedida = unidadMedida;
}

@JsonProperty("serie")
public List<Serie> getSerie() {
return serie;
}

@JsonProperty("serie")
public void setSerie(List<Serie> serie) {
this.serie = serie;
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
  public String toString() {
    return serie.toString(); /*"Valor UF hoy{" +
        "codigo='" + codigo + '\'' +
        ", serie=" + serie +
        '}';*/
  }

}