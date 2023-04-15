package br.com.nubr.capital.gains.application.entity;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Input {

    private final String operation;
    @SerializedName("unit-cost")
    private final Double unitCost;
    private final int quantity;
}