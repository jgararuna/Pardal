package models;

import annotations.Column;
import annotations.Entity;

/**
 * Created by andrebsguedes on 24/04/15.
 *
 */


@Entity(table="brand",primaryKey = "id")
public class Brand {

    @Column(name="_id", nullable = false)
    private int id;
    private String name;

    public Brand(){

    }

    public Brand(int id){
        this.id = id;
    }

    public Brand(String name){
        this.name=name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean save(){
        return true;
    }

}
