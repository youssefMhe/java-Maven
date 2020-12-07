package projet.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonIgnoreProperties(ignoreUnknown = true)
public class test {
    

    private String traceId;
    private String copyright;
    private String statusDescription;
    private String brandLogoUri;
    private List<ResourceSetsEntity> resourceSets;
    private String authenticationResultCode;
    private Integer statusCode;

    public void setTraceId(String traceId) {
        this.traceId = traceId;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public void setStatusDescription(String statusDescription) {
        this.statusDescription = statusDescription;
    }

    public void setBrandLogoUri(String brandLogoUri) {
        this.brandLogoUri = brandLogoUri;
    }

    public void setResourceSets(List<ResourceSetsEntity> resourceSets) {
        this.resourceSets = resourceSets;
    }

    public void setAuthenticationResultCode(String authenticationResultCode) {
        this.authenticationResultCode = authenticationResultCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public String getTraceId() {
        return traceId;
    }

    public String getCopyright() {
        return copyright;
    }

    public String getStatusDescription() {
        return statusDescription;
    }

    public String getBrandLogoUri() {
        return brandLogoUri;
    }

    public List<ResourceSetsEntity> getResourceSets() {
        return resourceSets;
    }

    public String getAuthenticationResultCode() {
        return authenticationResultCode;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    
}