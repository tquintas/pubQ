package tquintas.pubq.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "recipes")
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User author;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String photo;

    @OneToMany(mappedBy = "recipe")
    private List<Slot> slotList;

    @Column(nullable = false, columnDefinition = "json")
    private String steps;

    @Column
    private String description;
}
