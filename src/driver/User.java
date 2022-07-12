package driver;


public class User {
    
    private String name;
    private String password;
    private boolean print;
    private boolean edit;
    private boolean add;
    private boolean delete;
    private boolean accessToUSer;

    public User(String name, String password, boolean print, boolean edit, boolean add, boolean delete, boolean accessToUSer) {
        this.name = name;
        this.password = password;
        this.print = print;
        this.edit = edit;
        this.add = add;
        this.delete = delete;
        this.accessToUSer = accessToUSer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isPrint() {
        return print;
    }

    public void setPrint(boolean print) {
        this.print = print;
    }

    public boolean isEdit() {
        return edit;
    }

    public void setEdit(boolean edit) {
        this.edit = edit;
    }

    public boolean isAdd() {
        return add;
    }

    public void setAdd(boolean add) {
        this.add = add;
    }

    public boolean isDelete() {
        return delete;
    }

    public void setDelete(boolean delete) {
        this.delete = delete;
    }

    public boolean isAccessToUSer() {
        return accessToUSer;
    }

    public void setAccessToUSer(boolean accessToUSer) {
        this.accessToUSer = accessToUSer;
    }
    
}
