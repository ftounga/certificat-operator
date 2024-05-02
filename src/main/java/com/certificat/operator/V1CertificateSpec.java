package com.certificat.operator;

public class V1CertificateSpec {
    private String domainName;
    private String issuerName;
    private int validityDays;

    // Getters and Setters
    public String getDomainName() { return domainName; }
    public void setDomainName(String domainName) { this.domainName = domainName; }

    public String getIssuerName() { return issuerName; }
    public void setIssuerName(String issuerName) { this.issuerName = issuerName; }

    public int getValidityDays() { return validityDays; }
    public void setValidityDays(int validityDays) { this.validityDays = validityDays; }
}
