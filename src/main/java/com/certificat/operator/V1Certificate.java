package com.certificat.operator;

import io.kubernetes.client.common.KubernetesObject;
import io.kubernetes.client.openapi.models.V1ObjectMeta;

public class V1Certificate implements KubernetesObject {
    private V1ObjectMeta metadata;
    private V1CertificateSpec spec;
    private V1CertificateStatus status;

    // getters and setters
    public V1ObjectMeta getMetadata() { return metadata; }
    public void setMetadata(V1ObjectMeta metadata) { this.metadata = metadata; }

    public V1CertificateSpec getSpec() { return spec; }
    public void setSpec(V1CertificateSpec spec) { this.spec = spec; }

    public V1CertificateStatus getStatus() { return status; }
    public void setStatus(V1CertificateStatus status) { this.status = status; }

    @Override
    public String getApiVersion() {
        return "";
    }

    @Override
    public String getKind() {
        return "";
    }
}
