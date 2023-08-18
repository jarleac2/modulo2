package edu.co.jhair.reactiva.modulo2.services;

import edu.co.jhair.reactiva.modulo2.models.Cliente;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {
    private final Logger LOGGER = LoggerFactory.getLogger(KafkaProducerService.class);

    private final KafkaTemplate<String, String> kafkaTemplate;

    public KafkaProducerService(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendKey(String topico, Integer key, Cliente cliente ){
        var future = kafkaTemplate.send(topico, key.toString(), cliente.toString());

        future.whenComplete((resultadoEnvio, excepcion) -> {
            if(excepcion != null){
                LOGGER.error(excepcion.getMessage());
                future.completeExceptionally(excepcion);
            } else {
                future.complete(resultadoEnvio);
            }
            LOGGER.info("Cliente enviado al topico de Kafka con id"+cliente);
        });
    }

    public void send(String topico, Cliente cliente){
        var future = kafkaTemplate.send(topico, cliente.toString());

        future.whenComplete((resultadoEnvio, excepcion) -> {
            if(excepcion != null){
                LOGGER.error(excepcion.getMessage());
                future.completeExceptionally(excepcion);
            } else {
                future.complete(resultadoEnvio);
            }
            LOGGER.info("Cliente enviado al topico de Kafka "+cliente);
        });

    }
}
