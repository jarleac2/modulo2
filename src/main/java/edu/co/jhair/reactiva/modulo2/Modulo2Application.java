package edu.co.jhair.reactiva.modulo2;

import edu.co.jhair.reactiva.modulo2.models.Cliente;
import edu.co.jhair.reactiva.modulo2.services.KafkaProducerService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Modulo2Application implements CommandLineRunner {

	private final KafkaProducerService kafkaProducerService;

	public Modulo2Application(KafkaProducerService kafkaProducerService) {
		this.kafkaProducerService = kafkaProducerService;
	}

	public static void main(String[] args) {
		SpringApplication.run(Modulo2Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception{
		producerData();
	}

	private void producerData(){
		Cliente cliente1 = new Cliente(23, 1, "1098123123", "Jhair", "Leal", "3133133133", "jhair.leal@sophossolutions.com", true);
		Cliente cliente2 = new Cliente(24, 1, "1098124124", "Armando", "Acuna", "3144134133", "armando.acuna@sophossolutions.com", true);
		String topico = "Cliente-2023-8";
		kafkaProducerService.sendKey(topico, cliente1.getId(), cliente1);
		kafkaProducerService.sendKey(topico, cliente2.getId(), cliente2);
	}
}
