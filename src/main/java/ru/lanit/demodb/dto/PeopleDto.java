package ru.lanit.demodb.dto;


import java.util.Date;
import java.util.List;

public class PeopleDto {

    private int id;

    private String fio;

    private Date birthDate;

    private List<AddressDto> addressList;

    public PeopleDto(int id, String fio, Date birthDate) {
        this.id = id;
        this.fio = fio;
        this.birthDate = birthDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public String getFio() {
        return fio;
    }

    public List<AddressDto> getAddressList() {
        return addressList;
    }

    public void setAddressList(List<AddressDto> addressList) {
        this.addressList = addressList;
    }

    public String getAddressesAsString() {
        StringBuilder result = new StringBuilder();
        for (AddressDto address : this.addressList) {
            result.append(address).append("<br />\n");
        }

        return result.toString();
    }

    @Override
    public String toString() {
        return  "Id=" + id + ", " + fio + ", д.р.=" + birthDate ;
    }
}
