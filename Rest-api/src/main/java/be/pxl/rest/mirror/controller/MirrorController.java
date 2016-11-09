package be.pxl.rest.mirror.controller;

import be.pxl.rest.mirror.controller.input.MirrorInput;
import be.pxl.rest.mirror.entity.Call;
import be.pxl.rest.mirror.service.MirrorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Bram on 19/10/2016.
 */
@RestController
public class MirrorController {
    @Autowired
    private MirrorService mirrorService;
    @PostMapping ("/mirror")
    public String getMirroredText(@RequestBody MirrorInput mirrorInput){
        mirrorService.storeCall(new Call(mirrorInput.getName(),mirrorInput.getSourceText()));
        return mirrorInput.getName() + ": "+new StringBuilder(mirrorInput.getSourceText()).reverse().toString();
    }
}
