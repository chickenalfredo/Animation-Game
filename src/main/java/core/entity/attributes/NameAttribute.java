package core.entity.attributes;

import java.io.Serializable;

/**
 * NameAttribute allows the Entity object to have a name attribute.
 * This class will set the name on construction and can
 * only be retrieved as this class is final.
 */
public final class NameAttribute implements Attribute, Serializable {
    
    private static final long serialVersionUID = 1L;
    private final String NAME;

    /**
     * Constructs this attribute with the specified name
     * 
     * @param name
     */
    public NameAttribute(String name) {
        this.NAME = name;
    }

    /**
     * @return the name
     */
    public String getName() {
        return NAME;
    }
}
