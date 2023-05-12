package ru.practicum.javashareit.user.model;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserModel {
    @Setter(AccessLevel.NONE) //запрет на выставление айдишника
    private Long id;
    private String name;
    private String email;
}
