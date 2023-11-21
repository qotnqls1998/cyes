//package com.cyes.webserver.config;
//
//import org.apache.kafka.clients.CommonClientConfigs;
//import org.apache.kafka.clients.consumer.ConsumerConfig;
//import org.apache.kafka.clients.producer.ProducerConfig;
//import org.apache.kafka.common.config.SaslConfigs;
//import org.apache.kafka.common.security.plain.PlainLoginModule;
//import org.apache.kafka.common.serialization.StringDeserializer;
//import org.apache.kafka.common.serialization.StringSerializer;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.kafka.core.*;
//
//import java.util.HashMap;
//import java.util.Map;
//
//@Configuration
//public class CloudKafkaConfig {
//
//    @Value("${kafka.bootstrap.servers}")
//    private String bootstrapAddress;
//    @Value("${kafka.cloud.username}")
//    private String cloudUsername;
//    @Value("${kafka.cloud.password}")
//    private String cloudPassword;
//
//    @Bean
//    public ProducerFactory<Object, Object> producerFactory(){
//        Map<String, Object> props = new HashMap<>();
//        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
//        props.put(CommonClientConfigs.SECURITY_PROTOCOL_CONFIG, "SASL_SSL");
//        props.put(SaslConfigs.SASL_MECHANISM, "SCRAM-SHA-256");
//        props.put(SaslConfigs.SASL_JAAS_CONFIG, PlainLoginModule.class.getName() + " required " +
//                "username='" + cloudUsername +
//                "' password='" + cloudPassword + "';");
//
//        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
//        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
//        return new DefaultKafkaProducerFactory<>(props);
//    }
//
//    @Bean
//    public ConsumerFactory<Object, Object> consumerFactory() {
//        Map<String, Object> props = new HashMap<>();
//        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
//        props.put(CommonClientConfigs.SECURITY_PROTOCOL_CONFIG, "SASL_SSL");
//        props.put(SaslConfigs.SASL_MECHANISM, "SCRAM-SHA-256");
//        props.put(SaslConfigs.SASL_JAAS_CONFIG, PlainLoginModule.class.getName() + " required " +
//                "username='" + cloudUsername +
//                "' password='" + cloudPassword + "';");
//        props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
//        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
//        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
//        return new DefaultKafkaConsumerFactory<>(props);
//    }
//
//    @Bean
//    public KafkaTemplate<Object, Object> kafkaTemplate() {
//        return new KafkaTemplate<>(producerFactory());
//    }
//
//}