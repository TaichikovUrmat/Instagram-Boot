package peaksoft.entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

import static jakarta.persistence.CascadeType.PERSIST;
import static jakarta.persistence.CascadeType.REMOVE;

@Entity
@Table(name="images")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Image {
    @Id
    @GeneratedValue(generator = "images_gen",strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(
            name = "images_gen",
            sequenceName = "images_seq",
            allocationSize = 1)
    private Long id;

    @Column(length = 10000)
    private String imageURL;

   //***************** User *********************//
    @OneToMany(mappedBy = "image",cascade = {PERSIST,REMOVE})
    private List<User>  user;

    //***************** Post *********************//
    @ManyToOne(cascade = {PERSIST,REMOVE})
    private Post post;


}
