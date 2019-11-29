import java.util.ArrayList;
import java.util.List;

public class StorePro {
    private List<Object> customers;
    private List<Object> inventories;
    private List<Object> staff;

    public StorePro(
            Object lastUpdate, Object managerStaff, Object address, long id) {

        this.lastUpdate = lastUpdate;
        this.managerStaff = managerStaff;
        this.address = address;
        this.id = id;

        StorePro storePro = this;
        boolean bool = false;
        ArrayList<Object> arrayList = new ArrayList<>();

        storePro = this;
        bool = false;
        storePro.inventories = (List)(arrayList = new ArrayList<>());
        storePro = this;
        bool = false;
        storePro.staff = (List)(arrayList = new ArrayList<>());
    }

    private Object lastUpdate;
    private Object managerStaff;
    private Object address;
    private long id;

    public final Object getLastUpdate() { return this.lastUpdate; }

    public final void setLastUpdate(
        Object set) {
        this.lastUpdate = set;
    }

    public final Object getManagerStaff() { return this.managerStaff; }
    public final void setManagerStaff(Object set) {
        this.managerStaff = set;
    }
    public final Object getAddress() { return this.address; }
    public final void setAddress(Object set) {
        this.address = set;
    }
    public final long getId() { return this.id; }
    public final void setId(long set) { this.id = set; }
    public final List<Object> getCustomers() { return this.customers; }
    public final void setCustomers(List<Object> set) {
        this.customers = set;
    }
    public final List<Object> getInventories() { return this.inventories; }
    public final void setInventories(
            List<Object> set) {
        this.inventories = set;
    }
    public final List<Object> getStaff() {
        return this.staff;
    }
    public final void setStaff(List<Object> set) {
        this.staff = set;
    }

    public StorePro() {}
}
