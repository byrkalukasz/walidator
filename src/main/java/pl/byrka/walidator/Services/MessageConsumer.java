package pl.byrka.walidator.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;
import pl.byrka.walidator.Model.StudentApplication;

import javax.sound.midi.SysexMessage;

@Component
public class MessageConsumer {
    @Autowired
    private JmsTemplate jmsTemplate;

    @JmsListener(destination = "${activemq.receive}")
    public void messagelistener(String application){
        System.out.println(application);
        messageSent(application);
    }

    public void messageSent(String studentApplication){
        jmsTemplate.convertAndSend("${activemq.send}",studentApplication);
    }
}
