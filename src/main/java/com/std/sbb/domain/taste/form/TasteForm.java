package com.std.sbb.domain.taste.form;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;

@Data
@Getter
public class TasteForm{
    @NotNull(message = "Please provide a value for sweet")
    private Integer sweet;
    @NotNull(message = "Please provide a value for body")
    private Integer body;
    @NotNull(message = "Please provide a value for acidity")
    private Integer acidity;
    @NotNull(message = "Please provide a value for tannin")
    private Integer tannin;
}
