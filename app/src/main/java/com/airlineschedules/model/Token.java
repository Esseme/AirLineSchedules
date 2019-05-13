package com.airlineschedules.model;

/**
 * Created by Ed Ssemuwemba on 5/13/19.
 * esseme@gmail.com
 */
public class Token {
    private String accesToken;
    private String tokenType;
    private Double expiresIn;

    public String getAccesToken() {
        return accesToken;
    }

    public void setAccesToken(String accesToken) {
        this.accesToken = accesToken;
    }

    public String getTokenType() {
        return tokenType;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }

    public Double getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(Double expiresIn) {
        this.expiresIn = expiresIn;
    }
}
