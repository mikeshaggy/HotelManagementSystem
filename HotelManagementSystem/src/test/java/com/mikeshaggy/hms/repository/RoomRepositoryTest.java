package com.mikeshaggy.hms.repository;

import com.mikeshaggy.hms.model.Room;
import com.mikeshaggy.hms.model.RoomType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class RoomRepositoryTest {

    @Autowired
    private RoomRepository roomRepository;

    @Test
    void countByRoomType_shouldReturnCorrectNumberOfRooms() {
        // Given
        List<Room> mockedRooms = List.of(
                new Room(RoomType.CLASSIC_DOUBLE), new Room(RoomType.CLASSIC_DOUBLE), new Room(RoomType.CLASSIC_DOUBLE),
                new Room(RoomType.SUITE), new Room(RoomType.EXECUTIVE_SUITE), new Room(RoomType.CLASSIC_SINGLE),
                new Room(RoomType.CLASSIC_TWIN), new Room(RoomType.CLASSIC_TWIN), new Room(RoomType.DELUXE_DOUBLE)
        );
        roomRepository.saveAll(mockedRooms);

        // When
        int classicDoubleRoomsAmount = roomRepository.countByRoomType(RoomType.CLASSIC_DOUBLE);

        // Then
        assertThat(classicDoubleRoomsAmount).isEqualTo(3);
    }
}