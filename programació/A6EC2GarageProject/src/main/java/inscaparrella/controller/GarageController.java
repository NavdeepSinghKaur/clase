package inscaparrella.controller;

import inscaparrella.model.Car;
import inscaparrella.model.Report;

import java.util.ArrayList;

public class GarageController {
    private ArrayList<Car> cars;

    public GarageController() {
        this.cars = new ArrayList<>();
    }

    public boolean addCar(Car c) {
        boolean found = this.cars.contains(c);
        if(!found) {
            this.cars.add(new Car(c));
        }
        return (!found);

        //Codi intern del mètode contains() de l'ArrayList
        /*boolean exists = false;
        int pos = 0;
        while(pos<this.cars.size() && !exists) {
            if(this.cars.get(pos).equals(c)) exists = true;
            pos++;
        }
        return exists;*/
    }

    public Report checkCar(String lisence) {
        /**
         * Si el taller no té un cotxe amb matrícula lisence, retorna null
         * Si el té, li omple el dipòsit, li fa el canvi de rodes, si fa falta,
         * li fa el canvi d'oli, si fa falta, crea el Report i li associa.
         * Finalment, retorna el Report creat
         */

        int pos = 0;
        boolean found = false;
        boolean oilChanged, wheelsChanged, tankFilled;
        Report report = null;
        Car car;

        while(pos<this.cars.size() && !found) {
            if(this.cars.get(pos).getLisence().equals(lisence)) {
                found = true;
            }
            pos++;
        }

        if(found) {
            //Revisió del cotxe
            car = this.cars.get(pos-1);
            oilChanged = car.oilChangeRequired();
            wheelsChanged = car.wheelsChangeRequired();
            if(oilChanged) {
                car.setLastOilKM(0.0f);
            }
            if(wheelsChanged) {
                car.setLastWheelsKM(0.0f);
            }
            tankFilled = (car.fillTank() > 0.0f);

            report = new Report(tankFilled, oilChanged, wheelsChanged);
            car.setLastReport(report);
        }
        return report;
    }

    @Override
    public String toString() {
        String str = "COTXES EN REPARACIÓ\n";
        for(int pos=0; pos<this.cars.size(); pos++) {
            str+= "---------------------------------\n";
            str += this.cars.get(pos).toString() + "\n";
            str+= "---------------------------------\n";
        }
        return str;
    }
}
