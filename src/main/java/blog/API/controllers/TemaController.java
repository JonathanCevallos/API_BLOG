package blog.API.controllers;

import blog.API.models.Tema;
import blog.API.services.TemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/temas")
@CrossOrigin("*")
public class TemaController {
    @Autowired
    private TemaService temaService;

    //LISTAR TODO
    @GetMapping
    public ResponseEntity<List<Tema>> getAll()
    {
        try
        {
            return ResponseEntity.ok().body(temaService.findAll());
        }
        catch (Exception e)
        {
            return ResponseEntity.notFound().build();
        }
    }

    //BUSCAR POR ID
    @RequestMapping(value = "{id}")
    public ResponseEntity<Tema> finfById(@PathVariable("id")int id)
    {
        try
        {
            return ResponseEntity.ok().body(temaService.findById(id));
        }
        catch (Exception e)
        {
            return ResponseEntity.notFound().build();
        }
    }

    //GUARDAR
    @PostMapping
    public ResponseEntity<Tema> create (@RequestBody Tema entity)
    {
        try
        {
            return ResponseEntity.ok().body(temaService.save(entity));
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
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(temaService.delete(id));
        }
        catch (Exception e)
        {
            return ResponseEntity.badRequest().build();
        }
    }

    //ACTUALIZAR
    @PutMapping(value =  "{id}")
    private ResponseEntity<Tema>update(@PathVariable int id, @RequestBody Tema entity)
    {
        try
        {
            return ResponseEntity.ok().body(temaService.update(id,entity));
        }
        catch (Exception e)
        {
            return ResponseEntity.badRequest().build();
        }
    }
}
