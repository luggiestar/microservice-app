package com.arms.roombooking.controllers;

import com.arms.roombooking.models.Room;
import com.arms.roombooking.responses.MessageResponse;
import com.arms.roombooking.responses.SaveResponse;
import com.arms.roombooking.services.RoomService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("room/")
@CrossOrigin(origins = "*")
public class RoomController {
    private final RoomService service;

    @PostMapping(path = "new-room")
    public SaveResponse saveRoom(@RequestBody Room room) {
        return service.saveRoom(room);
    }

    @GetMapping(path = "all-rooms")
    public List<Room> allRoom() {
        return service.findAllRooms();
    }

    @GetMapping(path = "room/{roomID}")
    public Optional<Room> findSingleRoom(@PathVariable Integer roomID) {
        return service.findRoom(roomID);
    }

    @DeleteMapping(path = "delete/{roomID}")
    public MessageResponse deleteRoom(@PathVariable Integer roomID) {
        return new MessageResponse(service.deleteRoom(roomID));
    }
}
