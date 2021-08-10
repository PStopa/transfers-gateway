package com.kodilla.transfersgateway.service;

import com.kodilla.commons.Transfer;
import com.kodilla.commons.TransferMessage;
import com.kodilla.transfersgateway.connector.AccountDto;
import com.kodilla.transfersgateway.provider.AccountsProvider;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Slf4j
@Service
@RequiredArgsConstructor
public class TransferProducer {

    private static final String TRANSFERS_TOPIC = "transfers";
    private final KafkaTemplate<String, Object> kafkaTemplate;
    private final AccountsProvider accountsProvider;

    public void sendTransfer(final Transfer transfer) {
        AccountDto accountDto = accountsProvider.getCustomerAccounts(123L).get(0);
        if (1 != accountDto.getAvailableFounds().compareTo(transfer.getAmount())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Bad request!");
        }
        TransferMessage transferMessage = new TransferMessage(transfer);
        log.info("Sending message to Kafka, transferMessage: {}", transferMessage);
        kafkaTemplate.send(TRANSFERS_TOPIC, transferMessage);
        log.info("Message was sent");
    }

}
