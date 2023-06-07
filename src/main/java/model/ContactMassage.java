package model;

import enums.ContactMassageSubject;
import lombok.Data;

@Data
public class ContactMassage {

    private ContactMassageSubject subject;
    private String email;
    private String orderReference;
    private String message;
}
