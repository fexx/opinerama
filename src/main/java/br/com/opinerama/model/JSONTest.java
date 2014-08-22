package br.com.opinerama.model;

import br.com.opinerama.dao.generic.BaseEntity;

/**
 * @author Carlos Mecha
 * 
 */
public class JSONTest implements BaseEntity<Long>{

	private long id;

    private String name;

    private String comment;

    /**
     * 
     */
    public JSONTest() {
    }

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     *            the id to set
     */
    public void setId( Long id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     *            the name to set
     */
    public void setName( String name) {
        this.name = name;
    }

    /**
     * @return the comment
     */
    public String getComment() {
        return comment;
    }

    /**
     * @param comment
     *            the comment to set
     */
    public void setComment( String comment) {
        this.comment = comment;
    }

}
