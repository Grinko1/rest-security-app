package security.controllers;

import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import security.models.Application;
import security.models.MyUser;
import security.services.AppService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/apps")
@AllArgsConstructor
public class AppController {

    private AppService appService;

    @GetMapping("/welcome")
    public String welcome(){
        return "Welcome to unprotected page";
    }
    @GetMapping
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public List<Application> getAll(){
        return appService.allApplications();
    }
    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public Application geyById(@PathVariable("id") int id){
        return appService.applicationById(id);
    }
    @PostMapping
    public String addUser(@RequestBody MyUser user){

        appService.addUser(user);
        return "User saved successfully";
    }

}
