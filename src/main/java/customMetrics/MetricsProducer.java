package customMetrics;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;

public class MetricsProducer {
	KafkaProducer<String, String> m_Producer = null;
	public MetricsProducer(String bootstrapServer) {

		Properties props = new Properties();
		props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServer);
		props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);

		m_Producer = new KafkaProducer<String, String>(
				props);
	}

	public void sendMetrics(String topic, String metric, String key) {
	    if (m_Producer == null) {
		System.out.println("sendMetrics: NULL m_Producer!");
		return;
	    }
	    ProducerRecord<String, String> record = new ProducerRecord<String, String>(
			    topic, key, metric);
	    m_Producer.send(record);
	}

	public void deleteMetricProducer() {
	    if (m_Producer != null) {
		m_Producer.close(1000, TimeUnit.MILLISECONDS);
		m_Producer = null;
	    }
	}

}



