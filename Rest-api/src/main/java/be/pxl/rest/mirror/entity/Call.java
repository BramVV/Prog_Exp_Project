package be.pxl.rest.mirror.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Created by Bram on 19/10/2016.
 */
@Entity
public class Call {
    @Id
    private UUID id;
    private String name;
    private String input;
    @Column (name="created_on")
    private LocalDateTime createOn;
    
    public Call () {
        this.id = UUID.randomUUID();
        this.createOn = LocalDateTime.now();
    }
    
    public Call (String name, String input) {
        this();
        this.name = name;
        this.input = input;
    }
    
    public UUID getId () {
        return id;
    }
    
    public String getName () {
        return name;
    }
    
    public String getInput () {
        return input;
    }
    
    public LocalDateTime getCreateOn () {
        return createOn;
    }
}
