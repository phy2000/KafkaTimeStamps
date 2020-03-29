# KafkaTimeStamps

This is example code to insert a unique message ID and a series of application timestamps into a custom message header.
The timestamp should have be in a base10 Linux millisecond epoch time, same as retrieved by
<br>``(Java): System.currentTimeMillis();``
<br>or 
<br>``(bash): echo $(($(date '+%s%N') / 1000000))``

The message ID should be unique across all producers on a given topic, and is inserted by the first producer in the chain.

There are 3 code examples here

## `ProducerPerformanceSendTime`
[`ProducerPerformanceSendTime`](src/main/java/org/phy2000/kafka/ProducerPerformanceSendTime.java) is identical to the class which implements `kafka-producer-perf-test` (`ProducerPerformanceSend`), except it creates a unique message ID and a timestamp and inserts it into the custom header named `metrics`.
It takes the same command line options as kafka-producer-perf-test.
  
  To use, run `kafka-run-class org.apache.kafka.tools.ProducerPerformanceSendTime $@`
  
## `MetricsProducer`
[`MetricsProducer`](src/main/java/customMetrics/MetricsProducer.java) is class which appends a time stamp and sends the message to the given topic.

## `TestMetrics`
[`TestMetrics`](src/main/java/testMetrics/TestMetrics.java) is an example producer which calls MetricsProducer to send a message.
