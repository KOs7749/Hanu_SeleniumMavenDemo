package dinhthe.Models;

public class Supplier {
    private String name;
    private String phone;
    private String email;
    private String DOB;
    private String id;
    private String idDate;

    // Constructor
    public Supplier(String name, String phone, String email, String DOB, String id, String idDate) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.DOB = DOB;
        this.id = id;
        this.idDate = idDate;
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getDOB() {
        return DOB;
    }

    public String getId() {
        return id;
    }

    public String getIdDate() {
        return idDate;
    }
}
