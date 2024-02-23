package com.library.libraryservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Library {
    @Id
    @Column(name = "library_id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id="";

    @ElementCollection
    private List<String> userBook;
    //Burada BookDb üzerinden bir bağlantı Pk-Fk yapmadık. Zaten microservis mantığında her bir uygulamanın kendi içeriisnde bağımsız olarak çalışabilmesi gerekir.
    // yazılacak olan ilişki library Db de şişmeye ve bağımlılıklara sebep olacaktır.
    // Bu yüzden sadece BookId  bilgisi üzerinden data işlemlerini gerçekleştireceğiz.
}
