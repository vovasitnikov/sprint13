package ru.practicum.javashareit.request.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.practicum.javashareit.user.model.UserModel;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "requests")
public class ItemRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "request_seq_generator") //автоинкрементация, выбор стратегии
    @SequenceGenerator(name = "request_seq_generator", sequenceName = "request_seq", allocationSize = 1) //включаем автоинскремент, allocationSize - шаг 1
    private Long id;

    @Column(name = "description", nullable = false)
    private String description;

    @ManyToOne //ставится на стороне внешнего ключа Много к Одному
    //ставится вместо @Column показать поле внешнего ключа
    //обязательно назначить имя для внешнего ключа foreignKey = @ForeignKey(name = "fk_item_user")
    @JoinColumn(name = "requester_id", nullable = false, foreignKey = @ForeignKey(name = "fk_item_user"))
    private UserModel requesterUser;

    @Column(name = "created", nullable = false)
    private LocalDateTime created;

}
