package com.certificat.operator.controller;

import com.certificat.operator.model.CertificateDetails;
import com.certificat.operator.model.V1Certificate;
import com.certificat.operator.service.CertificateService;
import io.kubernetes.client.extended.controller.reconciler.Result;
import org.springframework.stereotype.Component;
import org.springframework.boot.CommandLineRunner;
import io.kubernetes.client.extended.controller.Controller;
import io.kubernetes.client.extended.controller.builder.ControllerBuilder;
import io.kubernetes.client.informer.SharedInformerFactory;
import io.kubernetes.client.openapi.ApiClient;
import org.springframework.beans.factory.annotation.Autowired;

@Component
public class CertificateController implements CommandLineRunner {

    private final ApiClient client;
    private final SharedInformerFactory informerFactory;
    private final CertificateService certificateService;

    @Autowired
    public CertificateController(ApiClient client, SharedInformerFactory informerFactory, CertificateService certificateService) {
        this.client = client;
        this.informerFactory = informerFactory;
        this.certificateService = certificateService;
    }

    @Override
    public void run(String... args) throws Exception {
        Controller controller = ControllerBuilder.defaultBuilder(informerFactory)
                .watch((workQueue) -> ControllerBuilder.controllerWatchBuilder(V1Certificate.class, workQueue).build())
                .withReconciler(request -> {
                    V1Certificate certificate = new V1Certificate()/* Assume method to fetch V1Certificate based on request */;
                    CertificateDetails details = convertToDetails(certificate);
                    certificateService.processNewCertificate(details);
                    System.out.println("Reconciling changes for certificate: " + request.getName());
                    return new Result(false); // Ne re-planifie pas immédiatement
                })
                .build();

        // Blocage appel jusqu'à interruption du contrôleur
        controller.run();
    }

    private CertificateDetails convertToDetails(V1Certificate certificate) {
        return new CertificateDetails(); //TODO
    }
}
