package Model;


public abstract class Person {
  private int zip;
  private String address;
  private String id;
  private String name;

  public Person(int zip, String address, String id, String name) {
    this.zip = zip;
    this.address = address;
    this.id = id;
    this.name = name;
  }

  public Person() {
  }

  public int getZip() {
    return zip;
  }

  public void setZip(int zip) {
    this.zip = zip;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
