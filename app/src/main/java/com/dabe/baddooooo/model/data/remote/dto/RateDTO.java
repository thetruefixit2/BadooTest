package com.dabe.baddooooo.model.data.remote.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.math.BigDecimal;

/**
 * Created by Daniil Belevtsev
 * Project: Baddooooo; Skype: pandamoni1
 */

public class RateDTO {
    @SerializedName("from")
    @Expose
    public String from;
    @SerializedName("rate")
    @Expose
    public BigDecimal rate;
    @SerializedName("to")
    @Expose
    public String to;

    public RateDTO(String from, BigDecimal rate, String to) {
        this.from = from;
        this.rate = rate;
        this.to = to;
    }

    public String getFrom() {
        return from;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public String getTo() {
        return to;
    }


}
