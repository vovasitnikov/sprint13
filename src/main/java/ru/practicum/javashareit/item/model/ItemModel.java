package ru.practicum.javashareit.item.model;

import jakarta.persistence.*;
import lombok.*;
import ru.practicum.javashareit.request.model.ItemRequest;
import ru.practicum.javashareit.user.model.UserModel;

@Entity
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "items")
public class ItemModel {

    @Setter(AccessLevel.NONE)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "item_seq_generator") //автоинкрементация, выбор стратегии
    @SequenceGenerator(name = "item_seq_generator", sequenceName = "items_seq", allocationSize = 1) //включаем автоинскремент, allocationSize - шаг 1
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private Boolean available;

    @ManyToOne
    @JoinColumn(name = "owner_id", nullable = false)
    private UserModel owner;

    @ManyToOne
    @JoinColumn(name = "request_id")
    private ItemRequest request;


}
