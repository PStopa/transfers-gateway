package com.kodilla.transfersgateway.connector;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@EqualsAndHashCode(callSuper=false)
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include. NON_NULL)
public class AccountDto {
    private Long id;
    private String nrb;
    private String currency;
    private BigDecimal availableFounds;

    public AccountDto(String nrb, String currency, BigDecimal availableFounds) {
        this.nrb = nrb;
        this.currency = currency;
        this.availableFounds = availableFounds;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNrb() {
        return nrb;
    }

    public void setNrb(String nrb) {
        this.nrb = nrb;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public BigDecimal getAvailableFounds() {
        return availableFounds;
    }

    public void setAvailableFounds(BigDecimal availableFounds) {
        this.availableFounds = availableFounds;
    }
}
