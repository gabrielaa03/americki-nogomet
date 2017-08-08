package com.example.plavatvornica.prvamalenaaplikacija.test_pcgfso;

/**
 * Created by Plava tvornica on 25.7.2017..
 */

public interface TestContract {

    interface View {

    }

    interface Presenter {
        // inače se stavi uvijek BasePresenter koji sadrži ove dvije metode i svaki drugi presenter samo nasljeđuje ove osnovne metode start i stop, zato što se u njima odvija dohvaćanje podataka
        void onStart();

        void onStop();
    }
}
