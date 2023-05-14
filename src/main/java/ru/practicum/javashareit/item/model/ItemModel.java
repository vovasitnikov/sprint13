package ru.practicum.javashareit.item.model;

import lombok.*;
import ru.practicum.javashareit.user.model.UserModel;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ItemModel {

    @Setter(AccessLevel.NONE)
    private Long id;

    private String name;

    private String description;

    private Boolean available;

    private UserModel owner;

    //private ItemRequest request;

}
