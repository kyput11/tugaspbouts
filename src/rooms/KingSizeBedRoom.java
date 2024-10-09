/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rooms;

/**
 *
 * @author awliy
 */

public class KingSizeBedRoom extends Room {
    public KingSizeBedRoom(int roomNumber) {
        super(roomNumber);
    }

    @Override
    public String getRoomType() {
        return "King Size Bed";
    }
}
