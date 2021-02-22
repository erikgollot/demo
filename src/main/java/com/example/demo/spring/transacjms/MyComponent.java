package com.example.demo.spring.transacjms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronization;
import org.springframework.transaction.support.TransactionSynchronizationAdapter;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;
import java.util.List;

@Component
public class MyComponent {

    @Autowired
    private JmsTemplate jmsTemplate;

    @Transactional
    public void doTheJobBadly() {
        List<Data> data = loadData();
        processData(data);
        saveData(data);
        jmsTemplate.send("topic", new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                TextMessage message = session.createTextMessage();
                message.setText("welcome");
                return message;
            }
        });
    }

    @Transactional
    public void doTheJobCorrectly() {
        TransactionSynchronizationManager.registerSynchronization(new MyTransactionAdapter() {
            @Override
            public void afterCompletion(int status) {
                if (status==0) {
                    jmsTemplate.send("topic", new MessageCreator() {
                        @Override
                        public Message createMessage(Session session) throws JMSException {
                            TextMessage message = session.createTextMessage();
                            message.setText("welcome");
                            return message;
                        }
                    });
                }
            }
        });
        List<Data> data = loadData();
        processData(data);
        saveData(data);
    }

    private void saveData(List<Data> data) {
    }

    private void processData(List<Data> data) {
    }

    private List<Data> loadData() {
        return null;
    }
}
