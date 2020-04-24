package card.mng.dto.model;

public class RequestModel {

    int id;
    String name;

    public RequestModel(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "RequestModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
