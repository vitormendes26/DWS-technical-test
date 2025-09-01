package com.dws.isobar.fm.bands.domain.exception;

public class BandNotFoundException extends RuntimeException {

    public BandNotFoundException() {
        super("Sorry! Band was not found in our database");
    }

}
