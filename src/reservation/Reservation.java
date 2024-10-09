/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reservation;

/**
 *
 * @author awliy
 */

public interface Reservation {
    void bookRoom(int roomNumber);
    boolean checkAvailability(int roomNumber);
    void viewBookingDetails();
}
