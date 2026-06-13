package com.silog.silog_user.interfaces.rest.cashsession.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;

import java.util.List;

public class OpenCashSessionRequest {

    @NotEmpty(message = "Se debe especificar al menos un monto de apertura")
    @Valid
    private List<OpeningAmountDto> openingAmounts;

    public List<OpeningAmountDto> getOpeningAmounts() { return openingAmounts; }
    public void setOpeningAmounts(List<OpeningAmountDto> openingAmounts) { this.openingAmounts = openingAmounts; }
}
