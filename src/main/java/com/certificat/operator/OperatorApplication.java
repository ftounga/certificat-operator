package com.certificat.operator;

import com.certificat.operator.model.V1Certificate;
import io.kubernetes.client.extended.controller.Controller;
import io.kubernetes.client.extended.controller.builder.ControllerBuilder;
import io.kubernetes.client.informer.SharedInformerFactory;
import io.kubernetes.client.openapi.ApiClient;
//import io.kubernetes.client.spring.extended.controller.annotation.KubernetesReconcilerWatcher;
import io.kubernetes.client.util.ClientBuilder;
import io.kubernetes.client.extended.controller.reconciler.Request;
import io.kubernetes.client.extended.controller.reconciler.Result;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class OperatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(OperatorApplication.class, args);
	}

	@Bean
	public ApiClient client() throws Exception {
		return ClientBuilder.cluster().build();
	}

	@Bean
	public SharedInformerFactory informerFactory(ApiClient client) {
		return new SharedInformerFactory();
	}

	@Bean
	public Controller certController(SharedInformerFactory informerFactory) {
		return ControllerBuilder.defaultBuilder(informerFactory)
				.watch((queue) -> ControllerBuilder.controllerWatchBuilder(V1Certificate.class, queue).build())
				.withReconciler(request -> reconcile(request))
				.build();
	}

	private Result reconcile(Request request) {
		// Implémentation de la logique de réconciliation
		System.out.println("Reconciling Certificate: " + request.getName());
		// Retourne un résultat pour indiquer que la réconciliation est complète et s'il faut reprogrammer
		return new Result(false); // false signifie qu'aucun re-essai immédiat n'est nécessaire
	}
}
