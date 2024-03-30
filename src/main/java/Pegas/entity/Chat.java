package Pegas.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Builder
@Table(name="chat")
public class Chat implements BaseEntity<Long>{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "chat_name")
    private String chatName;
    @Builder.Default
    @OneToMany(mappedBy = "chat")
    private List<UserChat> userChats = new ArrayList<>();
}
