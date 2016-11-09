package be.pxl.rest.mirror.controller.input;

/**
 * Created by Bram on 19/10/2016.
 */
public class MirrorInput {
    private String name;
    private String sourceText;
    
    public String getName () {
        return name;
    }
    
    public void setName (String name) {
        this.name = name;
    }
    
    public String getSourceText () {
        return sourceText;
    }
    
    public void setSourceText (String sourceText) {
        this.sourceText = sourceText;
    }
}
