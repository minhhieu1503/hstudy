package vn.nmh.hstudy.models;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

/**
 * Created by sutrixmedia on 4/2/16.
 */
@Table(name = "Items")
public class Items extends Model {
    @Column(name = "Name", index = true)
    public String name;

    @Column(name = "Category", index = true)
    public Category category;

    public Items() {
        super();
    }

    public Items(String name, Category category) {
        super();
        this.name = name;
        this.category = category;
    }
}
