package com.arms.roombooking.services;

import com.arms.roombooking.models.Room;
import com.arms.roombooking.repositories.RoomRepository;
import com.arms.roombooking.responses.SaveResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class RoomService {
    private final RoomRepository repository;

    public SaveResponse saveRoom(Room room) {
        long roomCount = repository.findByRoomNumber(room.getRoomNumber());
        if (roomCount < 1) {
            return new SaveResponse("saved", repository.save(room));
        }
        else {
            return new SaveResponse("room with given number exist", room);
        }
    }

    public List<Room> findAllRooms() {
        return repository.findAll();
    }

    public Optional<Room> findRoom(Integer roomId) {
        return repository.findById(roomId);
    }

    public String deleteRoom(Integer roomId) {
        long roomCount = repository.findByRoomNumber(String.valueOf(roomId));
        if (roomCount < 1) {
            repository.deleteById(roomId);
            return "deleted";
        }
        else {
            return "room with the given id not found";
        }
    }
}
