package com.arms.roombooking.repositories;

import com.arms.roombooking.models.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RoomRepository extends JpaRepository<Room, Integer> {
    @Query("SELECT COUNT(r) FROM Room r WHERE r.roomNumber = ?1")
    long findByRoomNumber(String roomNumber);
}
