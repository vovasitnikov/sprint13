package ru.practicum.javashareit.user.model;

import jakarta.persistence.*;
import lombok.*;

@Entity //обозначение сущности в JPA
//настройка наименования таблицы
//выставление уникальности значений определенных полей, т.е. невозможно будет внести одинаковые значения в поля
@Table(name = "users",
        uniqueConstraints = {
                                @UniqueConstraint(name = "uniqueEmail", columnNames = "email"),
                                @UniqueConstraint(name = "uniqueLogin", columnNames = "login"),
                            })
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserModel {
    @Setter(AccessLevel.NONE) //запрет на выставление айдишника
    @Id //специальная аннотация для создания айдишника
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq_generator") //автоинкрементация, выбор стратегии
    @SequenceGenerator(name = "user_seq_generator", sequenceName = "users_seq", allocationSize = 1) //включаем автоинскремент, allocationSize - шаг 1
    @Column(name = "id") //аннотация для наименования колонки
    private Long id;

    @Column(name = "name", nullable = false) //выставляем имя колонки и запрет вносить нулевое значение
    private String name;
    @Column(name = "email", nullable = false) //выставляем имя колонки и запрет вносить нулевое значение
    private String email;
    @Column(name = "login", nullable = false) //выставляем имя колонки и запрет вносить нулевое значение
    private String login;
}
