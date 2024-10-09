/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package users;

/**
 *
 * @author awliy
 */


import rooms.Room;
import main.Hotel;

public class Admin {
    private String adminName;
    private String username;
    private String password;

    public Admin(String adminName, String username, String password) {
        this.adminName = adminName;
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void checkRoomStatus(int roomNumber) {
        Hotel hotel = Hotel.getInstance();
        Room room = hotel.getRoom(roomNumber);
        if (room != null) {
            System.out.println("Kamar " + roomNumber + " status: " + (room.isAvailable() ? "Tersedia" : "Dipesan"));
        } else {
            System.out.println("Kamar tidak ditemukan.");
        }
    }

    public void viewAllRooms() {
        Hotel hotel = Hotel.getInstance();
        for (Room room : hotel.getAllRooms()) {
            System.out.println("Kamar " + room.getRoomNumber() + " - Tipe: " + room.getRoomType() + " - Status: " + (room.isAvailable() ? "Tersedia" : "Dipesan"));
        }
    }
}

