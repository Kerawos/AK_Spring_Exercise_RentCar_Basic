package pl.akademiakodu.AK_Spring_Exercise_RentCar_Basic.models;

/**
 * Class for holding user input as object.
 */
public class UserPreferencesModel {

    /**
     * Variables declarations
     */
    private int moneyForRent;
    private int rentDuration;
    private int proximalDistance;
    private int passengerCapacity;

    /**
     * constructors
     */
    public UserPreferencesModel() {
    }

    public UserPreferencesModel(int moneyForRent, int rentDuration, int proximalDistance, int passengerCapacity) {
        this.moneyForRent = moneyForRent;
        this.rentDuration = rentDuration;
        this.proximalDistance = proximalDistance;
        this.passengerCapacity = passengerCapacity;
    }

    /**
     * Getters and setters section
     */
    public int getMoneyForRent() {
        return moneyForRent;
    }

    public void setMoneyForRent(int moneyForRent) {
        this.moneyForRent = moneyForRent;
    }

    public int getRentDuration() {
        return rentDuration;
    }

    public void setRentDuration(int rentDuration) {
        this.rentDuration = rentDuration;
    }

    public int getProximalDistance() {
        return proximalDistance;
    }

    public void setProximalDistance(int proximalDistance) {
        this.proximalDistance = proximalDistance;
    }

    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    public void setPassengerCapacity(int passengerCapacity) {
        this.passengerCapacity = passengerCapacity;
    }
}
