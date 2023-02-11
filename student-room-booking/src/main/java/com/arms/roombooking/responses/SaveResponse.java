package com.arms.roombooking.responses;

import com.arms.roombooking.models.Room;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Optional;

public record SaveResponse (String message, Room room){ }
