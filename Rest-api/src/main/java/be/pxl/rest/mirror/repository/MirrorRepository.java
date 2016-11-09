package be.pxl.rest.mirror.repository;

import be.pxl.rest.mirror.entity.Call;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

/**
 * Created by Bram on 19/10/2016.
 */
public interface MirrorRepository extends CrudRepository<Call,UUID>{
    
}
