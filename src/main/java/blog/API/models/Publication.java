package blog.API.models;

import blog.API.security.models.Usuario;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "publicaciones")
public class Publication implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_publicacion")
    private int idPublicacion;

    @NotEmpty
    @Column(name = "titulo", length = 50)
    private String titulo;


    @Column(name = "cuerpo")
    private String cuerpo;


    @Column(name = "indice")
    private String indice;

    @Column(name = "create_at")
    private Date createAt;

    @Column(name = "update_at")
    private Date updateAt;


    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;



}
