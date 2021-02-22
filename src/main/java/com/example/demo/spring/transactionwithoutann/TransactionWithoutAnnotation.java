package com.example.demo.spring.transactionwithoutann;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

@Component
public class TransactionWithoutAnnotation {

    @Autowired
    private PlatformTransactionManager transactionManager;

    public void doItInTransaction() {
        TransactionTemplate template = new TransactionTemplate(transactionManager);
        // Vous pouvez configurer votre template : propagation, isolation, readonly
        // template.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
        // template.setReadOnly(true);
        template.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                try {
                    // Do what you want
                } catch (Exception ex) {
                    transactionStatus.setRollbackOnly();
                }
            }
        });
    }
}
