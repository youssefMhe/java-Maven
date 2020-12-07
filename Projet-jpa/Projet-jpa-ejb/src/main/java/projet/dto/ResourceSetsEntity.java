package projet.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResourceSetsEntity {
	 private List<ResourcesEntity> resources;
     private Integer estimatedTotal;

     public void setResources(List<ResourcesEntity> resources) {
         this.resources = resources;
     }

     public void setEstimatedTotal(Integer estimatedTotal) {
         this.estimatedTotal = estimatedTotal;
     }

     public List<ResourcesEntity> getResources() {
         return resources;
     }

     public Integer getEstimatedTotal() {
         return estimatedTotal;
     }



}