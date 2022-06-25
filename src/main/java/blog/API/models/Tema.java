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
@Table(name = "temas")
public class Tema implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tema")
    private int idTema;

    @NotEmpty
    @Column(name = "indice", length = 50)
    private String indice;

    @Column(name = "titulo", length = 50)
    private String titulo;

    @Column(name = "descripccion", length = 50)
    private String descripccion;


    //todo: relacion con la entidad PUBLICACIONES
    @OneToMany(cascade = {CascadeType.ALL}, targetEntity = Publication.class)
    @JoinColumn(name = "id_tema", referencedColumnName = "id_tema")
    private Set<Publication> publicaciones;

}
