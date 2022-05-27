package model;

public class Person {
    private String name;
    private Long documentId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getDocumentId() {
        return documentId;
    }

    public void setDocumentId(Long documentId) {
        this.documentId = documentId;
    }

    public Person(String name, Long documentId) {
        this.name = name;
        this.documentId = documentId;
    }
}
