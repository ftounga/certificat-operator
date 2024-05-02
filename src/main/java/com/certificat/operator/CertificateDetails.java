package com.certificat.operator;

import io.kubernetes.client.openapi.models.V1ObjectMeta;

public class CertificateDetails {
    private V1ObjectMeta metadata;
    private String status;
    private String issuer;

    // Getters et setters
    public V1ObjectMeta getMetadata() { return metadata; }
    public void setMetadata(V1ObjectMeta metadata) { this.metadata = metadata; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getIssuer() { return issuer; }
    public void setIssuer(String issuer) { this.issuer = issuer; }

    // Constructeur, si nécessaire
}
