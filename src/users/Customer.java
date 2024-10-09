/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package users;

/**
 *
 * @author awliy
 */



import reservation.Reservation;
import rooms.Room;
import main.Hotel;

public class Customer implements Reservation {
    private String name;
    private String username;
    private String password;
    private Room bookedRoom;

    public Customer(String name, String username, String password) {
        this.name = name;
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public void bookRoom(int roomNumber) {
        if (bookedRoom != null) {
            System.out.println("Anda sudah memiliki reservasi.");
            return;
        }
        Hotel hotel = Hotel.getInstance();
        Room room = hotel.getRoom(roomNumber);
        if (room != null && room.isAvailable()) {
            room.setAvailable(false);
            bookedRoom = room;
            System.out.println("Kamar " + roomNumber + " dengan tipe " + room.getRoomType() + " berhasil dipesan.");
        } else {
            System.out.println("Kamar tidak tersedia.");
        }
    }

    @Override
    public boolean checkAvailability(int roomNumber) {
        Hotel hotel = Hotel.getInstance();
        Room room = hotel.getRoom(roomNumber);
        return room != null && room.isAvailable();
    }

    @Override
    public void viewBookingDetails() {
        if (bookedRoom != null) {
            System.out.println("Detail Pesanan:");
            System.out.println("Nama: " + name);
            System.out.println("Nomor Kamar: " + bookedRoom.getRoomNumber());
            System.out.println("Tipe Kamar: " + bookedRoom.getRoomType());
        } else {
            System.out.println("Anda belum memesan kamar.");
        }
    }
}


