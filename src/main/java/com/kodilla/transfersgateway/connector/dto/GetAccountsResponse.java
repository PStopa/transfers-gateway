package com.kodilla.transfersgateway.connector.dto;

import com.kodilla.transfersgateway.connector.AccountDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetAccountsResponse {
    private List<AccountDto> accounts;
}
