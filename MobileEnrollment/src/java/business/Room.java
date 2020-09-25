/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author tom
 */

@Entity
@Table(name="room")

public class Room {
    @Id
    @Basic(optional = false)
    @Column(name = "room_id")
    private String roomId;
    @Column(name = "build_id")
    private String buildId;

    

    public Room() {
        this.roomId = "";
        this.buildId ="";
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public String getBuildId() {
        return buildId;
    }

    public void setBuildId(String buildId) {
        this.buildId = buildId;
    }

}
