package blog.API.controllers;


import blog.API.models.Unidad;
import blog.API.services.UnidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/unidades")
@CrossOrigin("*")
public class UnidadController {
    @Autowired
    private UnidadService unidadService;

    //LISTAR TODO
    @GetMapping
    public ResponseEntity<List<Unidad>> getAll()
    {
        try
        {
            return ResponseEntity.ok().body(unidadService.findAll());
        }
        catch (Exception e)
        {
            return ResponseEntity.notFound().build();
        }
    }

    //BUSCAR POR ID
    @RequestMapping(value = "{id}")
    public ResponseEntity<Unidad> finfById(@PathVariable("id")int id)
    {
        try
        {
            return ResponseEntity.ok().body(unidadService.findById(id));
        }
        catch (Exception e)
        {
            return ResponseEntity.notFound().build();
        }
    }

    //GUARDAR
    @PostMapping
    public ResponseEntity<Unidad> create (@RequestBody Unidad entity)
    {
        try
        {
            return ResponseEntity.ok().body(unidadService.save(entity));
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
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(unidadService.delete(id));
        }
        catch (Exception e)
        {
            return ResponseEntity.badRequest().build();
        }
    }

    //ACTUALIZAR
    @PutMapping(value =  "{id}")
    private ResponseEntity<Unidad>update(@PathVariable int id, @RequestBody Unidad entity)
    {
        try
        {
            return ResponseEntity.ok().body(unidadService.update(id,entity));
        }
        catch (Exception e)
        {
            return ResponseEntity.badRequest().build();
        }
    }
}
