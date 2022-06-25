package blog.API.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "unidades")
public class Unidad  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_unidad")
    private int idUnidad;

    @NotEmpty
    @Column(name = "titulo", length = 50)
    private String titulo;

    @NotEmpty
    @Column(name = "objetivo", length = 50)
    private String objetivo;


    //todo: relacion con la entidad TEMAS
    @OneToMany(cascade = {CascadeType.ALL}, targetEntity = Tema.class)
    @JoinColumn(name = "id_unidad", referencedColumnName = "id_unidad")
    private Set<Tema> temas;

}