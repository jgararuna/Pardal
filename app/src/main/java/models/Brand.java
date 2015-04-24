package models;

import java.sql.SQLException;
import java.util.ArrayList;

import annotations.Column;
import annotations.Entity;
import helpers.Condition;
import helpers.GenericPersistence;
import libraries.NotNullableException;

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

    public boolean save() throws SQLException, ClassNotFoundException, NotNullableException {
        GenericPersistence gP = new GenericPersistence();
        boolean result = gP.insertBean(this);
        this.setId(Brand.last().getId());
        return result;
    }

    public static Brand last() throws SQLException, ClassNotFoundException{
        GenericPersistence gP = new GenericPersistence();
        return ((Brand)gP.firstOrLastBean(new Brand(), true));
    }

    public static Brand get(int id) throws ClassNotFoundException, SQLException{
        GenericPersistence gP = new GenericPersistence();
        return (Brand) gP.selectBean(new Brand(id));
    }

    public static ArrayList<Brand> getAll() throws ClassNotFoundException, SQLException{
        GenericPersistence gP = new GenericPersistence();
        ArrayList<Brand> brands = new ArrayList<Brand>();
        for (Object bean : gP.selectAllBeans(new Brand())) {
            brands.add((Brand)bean);
        }
        return brands;
    }

    public static int count() throws ClassNotFoundException, SQLException {
        GenericPersistence gDB = new GenericPersistence();
        return gDB.countBean(new Brand());
    }

    public static Brand first() throws ClassNotFoundException, SQLException{
        GenericPersistence gP = new GenericPersistence();
        return (Brand) gP.firstOrLastBean(new Brand() , false);
    }

    public static ArrayList<Brand> getWhere(Condition condition) throws ClassNotFoundException, SQLException{
        GenericPersistence gP = new GenericPersistence();
        ArrayList<Brand> brands = new ArrayList<Brand>();
        for (Object bean : gP.selectWhere(new Brand(), condition)) {
            brands.add((Brand)bean);
        }
        return brands;
    }

    public boolean delete() throws ClassNotFoundException, SQLException {
        GenericPersistence gP = new GenericPersistence();
        return gP.deleteBean(this);
    }
}
