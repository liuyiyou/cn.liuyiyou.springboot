package cn.liuyiyou.springboot.kafka;

import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@RestController
public class KafkaApplication {

    @Autowired
    private KafkaTemplate kafkaTemplate;


    public static void main(String[] args) {
        SpringApplication.run(KafkaApplication.class, args);

    }


    @GetMapping("/")
    public String send() {
        final ListenableFuture send = kafkaTemplate.send(new ProducerRecord("LYY_Test", "Hello Kafak"));
        send.addCallback(new ListenableFutureCallback<String>() {
            @Override
            public void onFailure(Throwable throwable) {
                System.out.println("xx");
            }

            @Override
            public void onSuccess(String message) {
                System.out.println(message);
            }
        });
        return "success";
    }

}
