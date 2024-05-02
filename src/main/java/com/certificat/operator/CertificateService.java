package com.certificat.operator;

import org.springframework.stereotype.Service;

@Service
public class CertificateService {

    public void processNewCertificate(CertificateDetails details) {
        // Implémenter la logique pour traiter un nouveau certificat
        System.out.println("Processing new certificate for: " + details.getMetadata().getName());
    }

    public void updateCertificate(CertificateDetails details) {
        // Implémenter la logique pour mettre à jour un certificat existant
        System.out.println("Updating certificate: " + details.getMetadata().getName());
    }

    public void deleteCertificate(CertificateDetails details) {
        // Implémenter la logique pour gérer la suppression d'un certificat
        System.out.println("Deleting certificate: " + details.getMetadata().getName());
    }
}
