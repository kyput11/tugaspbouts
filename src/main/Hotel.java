/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

/**
 *
 * @author awliy
 */

import rooms.Room;
import rooms.SingleBedRoom;
import rooms.KingSizeBedRoom;

public class Hotel {
    private static Hotel instance;
    private Room[] rooms;

    private Hotel() {
        rooms = new Room[10];
        // Buat 5 kamar Single Bed dan 5 kamar King Size Bed
        for (int i = 0; i < 5; i++) {
            rooms[i] = new SingleBedRoom(i + 1);
        }
        for (int i = 5; i < 10; i++) {
            rooms[i] = new KingSizeBedRoom(i + 1);
        }
    }

    public static Hotel getInstance() {
        if (instance == null) {
            instance = new Hotel();
        }
        return instance;
    }

    public Room getRoom(int roomNumber) {
        if (roomNumber < 1 || roomNumber > rooms.length) {
            return null;
        }
        return rooms[roomNumber - 1];
    }

    public Room[] getAllRooms() {
        return rooms;
    }
}

