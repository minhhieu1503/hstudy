package vn.nmh.hstudy.models;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

import java.util.List;


@Table(name = "Category")
public class Category extends Model {
    @Column(name = "Name")
    public String name;

    public List<Items> items() {
        return getMany(Items.class, "Category");
    }
}
