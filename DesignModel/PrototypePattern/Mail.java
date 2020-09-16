package DesignModel.PrototypePattern;

public class Mail implements Cloneable {
    private String subject = "";
    private String context = "";
    private String name = "";
    private String email = "";
    private String title = "";

    Mail (AdvTemplate advTemplate) {
        this.subject = advTemplate.getSubject();
        this.context = advTemplate.getContext();
    }

    @Override
    public Mail clone(){
        Mail mail = null;
        try {
            mail = (Mail) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return mail;
    }

    public String getSubject() {
        return subject;
    }

    public String getContext() {
        return context;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getTitle() {
        return title;
    }

    public void setName (String name) {
        this.name = name;
    }

    public void setEmail (String email) {
        this.email = email;
    }

    public void setTitle (String title) {
        this.title = title;
    }
}
