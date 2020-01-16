package testMetrics;

import customMetrics.MetricsProducer;

public class TestMetrics {

	public static void main(String[] args) {
		MetricsProducer producer = new MetricsProducer("localhost:9092");
		for (int i=0; i<20; i++) {
			producer.sendMetrics("ctmetrics", "metric string" + i, null);
				
		}
		producer.deleteMetricProducer();

	}

}
