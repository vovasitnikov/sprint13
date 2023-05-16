package ru.practicum.javashareit.booking.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.practicum.javashareit.item.model.ItemModel;
import ru.practicum.javashareit.user.model.UserModel;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor@AllArgsConstructor
@Table(name = "bookings")
public class BookingModel {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "booking_seq_generator") //автоинкрементация, выбор стратегии
    @SequenceGenerator(name = "booking_seq_generator", sequenceName = "booking_seq", allocationSize = 1) //включаем автоинскремент, allocationSize - шаг 1
    private Long id;

    @Column(name = "start_date", nullable = false)
    private LocalDateTime start;

    @Column(name = "end_date", nullable = false)
    private LocalDateTime end;

    @ManyToOne
    @JoinColumn(name = "item_id", nullable = false)
    private ItemModel item;

    @ManyToOne
    @JoinColumn(name = "booker_id", nullable = false)
    private UserModel booker;
}
