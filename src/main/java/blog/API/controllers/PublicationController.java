package blog.API.controllers;


import blog.API.models.Publication;
import blog.API.services.PublicacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/publicaciones")
@CrossOrigin("*")
public class PublicationController {
    @Autowired
    private PublicacionService publicacionService;

    //LISTAR TODO
    @GetMapping
    public ResponseEntity<List<Publication>> getAll()
    {
        try
        {
            return ResponseEntity.ok().body(publicacionService.findAll());
        }
        catch (Exception e)
        {
            return ResponseEntity.notFound().build();
        }
    }

    //BUSCAR POR ID
    @RequestMapping(value = "{id}")
    public ResponseEntity<Publication> finfById(@PathVariable("id")int id)
    {
        try
        {
            return ResponseEntity.ok().body(publicacionService.findById(id));
        }
        catch (Exception e)
        {
            return ResponseEntity.notFound().build();
        }
    }

    //GUARDAR
    @PostMapping
    public ResponseEntity<Publication> create (@RequestBody Publication entity)
    {
        try
        {
            return ResponseEntity.ok().body(publicacionService.save(entity));
        }
        catch (Exception e)
        {
            return ResponseEntity.badRequest().build();
        }
    }

    //ELIMINAR
    @DeleteMapping(value =  "{id}")
    public ResponseEntity<Boolean> delete (@PathVariable int id)
    {
        try
        {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(publicacionService.delete(id));
        }
        catch (Exception e)
        {
            return ResponseEntity.badRequest().build();
        }
    }

    //ACTUALIZAR
    @PutMapping(value =  "{id}")
    private ResponseEntity<Publication>update(@PathVariable int id, @RequestBody Publication entity)
    {
        try
        {
            return ResponseEntity.ok().body(publicacionService.update(id,entity));
        }
        catch (Exception e)
        {
            return ResponseEntity.badRequest().build();
        }
    }
}
