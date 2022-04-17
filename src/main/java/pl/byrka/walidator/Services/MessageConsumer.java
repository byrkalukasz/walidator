package pl.byrka.walidator.Services;

import com.google.gson.Gson;
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
    @Autowired
    private Gson gson;

    @JmsListener(destination = "${activemq.receive}")
    public void messagelistener(String application){
        System.out.println(application);
        var model = gson.fromJson(application,StudentApplication.class);
        var send = validateApplication(model);
        var string = gson.toJson(send);
        messageSent(string);
    }

    public void messageSent(String studentApplication){
        jmsTemplate.convertAndSend("${activemq.send}",studentApplication);
    }

    private StudentApplication validateApplication(StudentApplication studentApplication){
        if(studentApplication.getPesel() == "96011803330"){
            studentApplication.setMessage("Walidacja numeru PESELu niepoprawna");
            studentApplication.setState(5);
        }else{
            studentApplication.setState(2);
        }
        return studentApplication;
    }
}
