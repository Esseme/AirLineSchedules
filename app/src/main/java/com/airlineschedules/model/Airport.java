package com.airlineschedules.model;

import java.math.BigDecimal;

/**
 * Created by Ed Ssemuwemba on 5/13/19.
 * esseme@gmail.com
 */
public class Airport {
    //float or double can work
    private BigDecimal latitude;
    private BigDecimal longitude;

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }
}
