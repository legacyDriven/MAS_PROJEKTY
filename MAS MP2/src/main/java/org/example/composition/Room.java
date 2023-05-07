package org.example.composition;

import lombok.*;

@Getter
@RequiredArgsConstructor
@ToString
class Room {
    @Setter
    private Building building;
    @NonNull
    private final String name;
    @NonNull
    private final int size;

    public Room(@NonNull Building building, @NonNull String name, @NonNull int size) {
        this.building = building;
        this.name = name;
        this.size = size;
    }
}


