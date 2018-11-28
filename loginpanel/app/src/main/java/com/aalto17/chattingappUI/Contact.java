package com.aalto17.chattingappUI;

public class Contact {
    private String contactName;
    private String message;
    private String imageName;

    public Contact(String contactName, String message, String imageName) {
        this.contactName = contactName;
        this.message = message;
        this.imageName = imageName;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }
}
